package main;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;

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


    public static Double currencyConverter(double fromRate, double toRate, float currency) {
        double USDrate = currency * fromRate;
        double newRate = USDrate * toRate;
        return newRate;
    }
}
