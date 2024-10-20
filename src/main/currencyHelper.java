package main;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import java.math.BigDecimal;
import java.text.DecimalFormatSymbols;
import java.text.NumberFormat;
import java.util.HashMap;
import java.util.Locale;
import java.util.Currency;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import java.util.Map;

/**
 *
 * @author kylin
 */
public class currencyHelper {
    public static boolean canConnect() {
        boolean s;
        s = true;
        try {
            Document doc = Jsoup.connect("https://www.x-rates.com/table/?from=USD&amount=1").get();
        }
        catch (IOException e) {
            System.out.printf("Error: %s", e);
            s = false;
         }
         return s;


    }
    public static Map<String, Double[]> webScraper() {
        Map<String, Double[]> dict = new HashMap<>(Map.of("US Dollar", new Double[]{1.0, 1.0}));
        Elements rows = null;
        try {
            Document doc = Jsoup.connect("https://www.x-rates.com/table/?from=USD&amount=1").get();
            rows = doc.select("table.ratesTable > tbody > tr");
        }
        catch (IOException e) {
            System.out.printf("Error: %s%n", e);
            loadFromFile(dict, "src/files/currency_rates.txt");
        }
        if (rows != null) {
            for (Element row : rows) {
                Elements tds = row.select("td");
                String currency = tds.get(0).text();
                Double[] rates = new Double[]{
                    Double.valueOf(tds.get(1).text()),
                    Double.valueOf(tds.get(2).text())
                };

                System.out.printf("Currency: %s, rate1: %s, rate2: %s%n",
                currency, rates[0], rates[1]);
    
                dict.put(currency, rates);
            }
        }
        return dict;
    }
    

     public static void loadFromFile(Map<String, Double[]> dict, String filename) {
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = reader.readLine()) != null) {
                // Assuming the file has lines in the format: "Currency, rate1, rate2"
                String[] parts = line.split(",");
                if (parts.length == 3) {
                    String currency = parts[0].trim();
                    Double rate1 = Double.valueOf(parts[1].trim());
                    Double rate2 = Double.valueOf(parts[2].trim());
                    dict.put(currency, new Double[]{rate1, rate2});

                    System.out.printf("Loaded from file - Currency: %s, rate1: %s, rate2: %s%n",
                            currency, rate1, rate2);
                }
            }
        } catch (IOException e) {
            System.out.printf("Error reading from file: %s%n", e);
        }
    }


    public static String currencyConverter(double fromRate, double toRate, String currency, Locale toLocale, Locale fromLocale) {
    if (toLocale != Locale.ROOT) {
                BigDecimal newCurrency = unformatCurrency(currency, fromLocale);
                
                // Calculate the new rate
                BigDecimal newRate = newCurrency.multiply(BigDecimal.valueOf(fromRate)).multiply(BigDecimal.valueOf(toRate));
                
                // Format the new rate as a currency string
                return formatCurrency(newRate, toLocale);
       
    } else {
        // When Locale.ROOT is used, directly parse the string as a Double
        double number = Double.valueOf(currency) * fromRate * toRate;
        return String.format("%.2f", number);
    }
}

    public static boolean validate_currency(String money, Locale locale) {
        if (locale != Locale.ROOT) {
    // Get locale-specific symbols
    int i;
    if (locale == Locale.JAPAN || locale == new Locale("es", "CL") || locale == Locale.KOREA) {
        return validate_nondec_currency(money);
    }
    DecimalFormatSymbols symbols = new DecimalFormatSymbols(locale);
    char groupingSeparator = symbols.getGroupingSeparator();
    char decimalSeparator = symbols.getDecimalSeparator();

    // Create dynamic regex patterns using locale-specific separators
    // Grouped pattern: numbers with grouping separators
    String regexWithGroup = "^\\d{1,3}(\\" + groupingSeparator + "\\d{3})*(\\" + decimalSeparator + "\\d{1,2})?$";
    // Ungrouped pattern: numbers without grouping separators (e.g., 1000, 1000.00)
    String regexNoGroup = "^\\d+([" + decimalSeparator + "]\\d{1,2})?$";

    // Check if the money string matches either the grouped or ungrouped pattern
    if (money.matches(regexWithGroup) || money.matches(regexNoGroup)) {
        return true;
    }
        else {
                return false;
            }
    } else {
        return MainHelper.validate_money(money, true);
    }
}
    public static String getCurrencySymbol(Locale locale) {
        Currency currency = Currency.getInstance(locale);
        return currency.getSymbol(locale);
    }
    
    public static Boolean validate_nondec_currency(String money) {
        int i;
        try {
            i = Integer.parseInt(money); 
                return MainHelper.is_nonneg(i);
            }
            catch (NumberFormatException e) {
                return false;
            }
    }
    
    public static BigDecimal unformatCurrency(String amount, Locale locale) {
            DecimalFormatSymbols symbols = new DecimalFormatSymbols(locale);
            char groupingSeparator = symbols.getGroupingSeparator();
            char decimalSeparator = symbols.getDecimalSeparator();

            // Remove grouping separators before parsing
            String cleanedCurrency = amount.replaceAll("\\Q" + groupingSeparator + "\\E", ""); // Escape groupingSeparator
            // Replace the locale-specific decimal separator with '.'
            cleanedCurrency = cleanedCurrency.replace(Character.toString(decimalSeparator), ".");
            BigDecimal parsedValue = new BigDecimal(cleanedCurrency);
            return parsedValue;
        
    }

        public static String formatCurrency(BigDecimal amount, Locale locale) {
            try {
            // Get a currency instance of NumberFormat for the given locale
            NumberFormat currencyFormatter = NumberFormat.getCurrencyInstance(locale);
            // Format the amount into a currency string
            return currencyFormatter.format(amount);
            }
            catch (NumberFormatException e) {
            e.printStackTrace();
            // Handle the parse exception, perhaps return 0.0 or handle it in another way
            return amount.toString();
        }
            
        }
    public static String generateWarningMessage(String amount, Locale locale) {
        DecimalFormatSymbols symbols = new DecimalFormatSymbols(locale);
        char groupingSeparator = symbols.getGroupingSeparator();
        char decimalSeparator = symbols.getDecimalSeparator();
        String regexWhole = "^\\d{1,3}(\\" + decimalSeparator + "\\d{3})*(\\" + groupingSeparator + "\\d{1,2})?$";
        if (amount.isEmpty()) {
            return "Amount cannot be empty.";
        }
        
        else if (!amount.matches("^[0-9.,]*$")) {
            return "Amount contains invalid characters (Can only cantains digits, commas, and dots)";
        }
        else if (amount.matches(regexWhole)) {
            return "Wrong numerical format (Must match 1" + groupingSeparator+ "000" + decimalSeparator + "00)";
        }
        else if (amount.matches(regexWhole)) {
            return "Wrong numerical format (Must match 1" + groupingSeparator+ "000" + decimalSeparator + "00)";
        }
        else if ((locale == Locale.JAPAN || locale == new Locale("es", "CL") || locale == Locale.KOREA) && !validate_nondec_currency(amount)) {
            return "This format only is valid for nonnegative integers.";
        }
        return "Unknown formatting issue.";
    }

    public static Locale getLocale(String currency) {
        // Define the locale for each currency
        switch (currency) {
            case "US Dollar":
                return Locale.US; // United States
            case "Euro":
                return Locale.forLanguageTag("de-DE"); // Eurozone (German)
            case "British Pound":
                return Locale.UK; // United Kingdom
            case "Indian Rupee":
                return new Locale("en", "IN"); // India
            case "Australian Dollar":
                return Locale.forLanguageTag("en-AU"); // Australia
            case "Canadian Dollar":
                return Locale.CANADA; // Canada
            case "Singapore Dollar":
                return Locale.forLanguageTag("en-SG"); // Singapore
            case "Swiss Franc":
                return Locale.forLanguageTag("de-CH"); // Switzerland (German)
            case "Malaysian Ringgit":
                return new Locale("ms", "MY"); // Malaysia
            case "Japanese Yen":
                return Locale.JAPAN; // Japan
            case "Chinese Yuan Renminbi":
                return Locale.forLanguageTag("zh-CN"); // China
            case "Argentine Peso":
                return new Locale("es", "AR"); // Argentina
            case "Bahraini Dinar":
                return new Locale("ar", "BH"); // Bahrain
            case "Botswana Pula":
                return new Locale("en", "BW"); // Botswana
            case "Brazilian Real":
                return new Locale("pt", "BR"); // Brazil
            case "Bruneian Dollar":
                return new Locale("en", "BN"); // Brunei
            case "Bulgarian Lev":
                return new Locale("bg", "BG"); // Bulgaria
            case "Chilean Peso":
                return new Locale("es", "CL"); // Chile
            case "Colombian Peso":
                return new Locale("es", "CO"); // Colombia
            case "Czech Koruna":
                return new Locale("cs", "CZ"); // Czech Republic
            case "Danish Krone":
                return new Locale("da", "DK"); // Denmark
            case "Hong Kong Dollar":
                return Locale.forLanguageTag("zh-HK"); // Hong Kong
            case "Hungarian Forint":
                return new Locale("hu", "HU"); // Hungary
            case "Icelandic Krona":
                return new Locale("is", "IS"); // Iceland
            case "Indonesian Rupiah":
                return new Locale("id", "ID"); // Indonesia
            case "Iranian Rial":
                return new Locale("fa", "IR"); // Iran
            case "Israeli Shekel":
                return new Locale("he", "IL"); // Israel
            case "Kazakhstani Tenge":
                return new Locale("kk", "KZ"); // Kazakhstan
            case "South Korean Won":
                return Locale.KOREA; // South Korea
            case "Kuwaiti Dinar":
                return new Locale("ar", "KW"); // Kuwait
            case "Libyan Dinar":
                return new Locale("ar", "LY"); // Libya
            case "Mauritian Rupee":
                return new Locale("en", "MU"); // Mauritius
            case "Mexican Peso":
                return new Locale("es", "MX"); // Mexico
            case "Nepalese Rupee":
                return new Locale("ne", "NP"); // Nepal
            case "New Zealand Dollar":
                return Locale.forLanguageTag("en-NZ"); // New Zealand
            case "Norwegian Krone":
                return Locale.forLanguageTag("no-NO"); // Norway
            case "Omani Rial":
                return new Locale("ar", "OM"); // Oman
            case "Pakistani Rupee":
                return new Locale("ur", "PK"); // Pakistan
            case "Philippine Peso":
                return new Locale("en", "PH"); // Philippines
            case "Polish Zloty":
                return new Locale("pl", "PL"); // Poland
            case "Qatari Riyal":
                return new Locale("ar", "QA"); // Qatar
            case "Romanian New Leu":
                return new Locale("ro", "RO"); // Romania
            case "Russian Ruble":
                return new Locale("ru", "RU"); // Russia
            case "Saudi Arabian Riyal":
                return new Locale("ar", "SA"); // Saudi Arabia
            case "South African Rand":
                return new Locale("en", "ZA"); // South Africa
            case "Sri Lankan Rupee":
                return new Locale("si", "LK"); // Sri Lanka
            case "Swedish Krona":
                return new Locale("sv", "SE"); // Sweden
            case "Taiwan New Dollar":
                return Locale.forLanguageTag("zh-TW"); // Taiwan
            case "Thai Baht":
                return new Locale("th", "TH"); // Thailand
            case "Trinidadian Dollar":
                return new Locale("en", "TT"); // Trinidad and Tobago
            case "Turkish Lira":
                return new Locale("tr", "TR"); // Turkey
            case "Emirati Dirham":
                return new Locale("ar", "AE"); // United Arab Emirates
            case "Venezuelan Bolivar":
                return new Locale("es", "VE"); // Venezuela
            default:
                return Locale.ROOT; // Fallback for unsupported currencies
        }
    }


}
