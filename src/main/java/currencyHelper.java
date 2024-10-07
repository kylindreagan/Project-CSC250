package main.java;

import java.io.IOException;
import java.util.Dictionary;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import java.util.Hashtable;

/**
 *
 * @author kylin
 */
public class currencyHelper {
    public static String webScraper(){
        String s = "success";
        Dictionary<String, Double> dict = new Hashtable<>();
        try {
        Document doc = Jsoup.connect("https://www.x-rates.com/table/?from=USD&amount=1").get();
        
        Elements rows = doc.select("table.ratesTable > tbody > tr");
        for (Element row : rows) {
            Elements tds = row.select("td");
            String currency = tds.get(0).text();
            Double rate1 = Double.valueOf(tds.get(1).text());
            Double rate2 = Double.valueOf(tds.get(2).text());
            System.out.printf("Currency: %s, rate1: %s, rate2: %s%n",
                        currency, rate1, rate2);
        }
        }
        catch (IOException e) {
           System.out.printf("Error: %s", e);
           s = "fail";
        }
        return s;
    }
    
}
