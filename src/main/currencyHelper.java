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
    public static Map<String, Double[]> webScraper(){
       Map<String, Double[]> dict = new HashMap<>();
        try {
            Document doc = Jsoup.connect("https://www.x-rates.com/table/?from=USD&amount=1").get();

            Elements rows = doc.select("table.ratesTable > tbody > tr");
            for (Element row : rows) {
                Elements tds = row.select("td");
                String currency = tds.get(0).text();
                Double rate1 = Double.valueOf(tds.get(1).text());
                Double rate2 = Double.valueOf(tds.get(2).text());

                // Store rate1 and rate2 as a tuple (Double array) in the dictionary
                dict.put(currency, new Double[]{rate1, rate2});

                System.out.printf("Currency: %s, rate1: %s, rate2: %s%n",
                        currency, rate1, rate2);
            }
        } catch (IOException e) {
            System.out.printf("Error: %s%n", e);
            loadFromFile(dict, "currency_rates.txt");
        }
        return dict;
    }

     private static void loadFromFile(Map<String, Double[]> dict, String filename) {
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
    
}
