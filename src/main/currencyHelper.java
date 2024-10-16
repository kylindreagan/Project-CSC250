package main;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Locale;

import org.apache.commons.validator.routines.BigDecimalValidator;
import org.apache.commons.validator.routines.CurrencyValidator;
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


    public static Double currencyConverter(double fromRate, double toRate, String currency, Locale locale) {
        if(locale != locale.ROOT) {
        BigDecimalValidator validator = CurrencyValidator.getInstance();
        double newRate = validator.validate(currency, locale).doubleValue() * fromRate * toRate;
        return newRate;
        }
        else {
            return Double.valueOf(currency) * fromRate * toRate;
        }
    }

    public static boolean validate_currency(String money, Locale locale) {
        if(locale != locale.ROOT) {
            // Create an instance of CurrencyValidator
            BigDecimalValidator validator = CurrencyValidator.getInstance();

    
            // Use the validator to check if the money string is valid for the given locale
            // The validate method returns a BigDecimal if valid, or null if invalid
            return validator.validate(money, locale) != null;
        }
        else {
            return MainHelper.validate_money(money, true);
        }

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
