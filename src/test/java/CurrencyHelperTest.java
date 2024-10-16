package test.java;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import static org.junit.Assert.*;

import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

import main.currencyHelper;

public class CurrencyHelperTest {
    
    public CurrencyHelperTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    @Test
    public void testConnection() {
        boolean s = currencyHelper.canConnect();
        assertTrue(s);
    }


    @Test
    public void testWebScraperSuccessEuro() {
        //Low fluctuation
        Map<String, Double[]> scrapedRates = currencyHelper.webScraper();
        double expectedEuroRate1 = 0.91;
        double expectedEuroRate2 = 1.09;
        double tolerance = 0.07; // Adjust tolerance as per expected variations

        // Test for Euro rates
        assertTrue("Euro rate1 is not within expected range",
            Math.abs(scrapedRates.get("Euro")[0] - expectedEuroRate1) < tolerance);
        assertTrue("Euro rate2 is not within expected range",
            Math.abs(scrapedRates.get("Euro")[1] - expectedEuroRate2) < tolerance);
    }

    @Test
    public void testWebScraperSuccessYen() {
        //High fluctuation
        Map<String, Double[]> scrapedRates = currencyHelper.webScraper();
        double expectedYenRate1 = 150.0;
        double expectedYenRate2 = 0.0067;
        double toleranceA = 10; // Adjust tolerance as per expected variations
        double toleranceB = .001;



        assertTrue("Japanese Yen rate1 is not within expected range",
            Math.abs(scrapedRates.get("Japanese Yen")[0] - expectedYenRate1) < toleranceA);
        assertTrue("Japanese Yen rate2 is not within expected range",
            Math.abs(scrapedRates.get("Japanese Yen")[1] - expectedYenRate2) < toleranceB);
    }

    @Test
    public void testFileReader() {
        Map<String, Double[]> dict = new HashMap<>();
        currencyHelper.loadFromFile(dict, "src/files/currency_rates.txt");
        double yenTo = 149.285613;
        double yenFrom = 0.006699;
        Double[] rates = dict.get("Japanese Yen");
        assertNotNull("Rates should not be null", rates);
        //delta: a small threshold value that specifies the acceptable range of error when comparing two floating-point numbers
        assertEquals("Check USD to Yen", yenTo, rates[0], 0.000001);
        assertEquals("Check Yen to USD", yenFrom, rates[1], 0.000001);

    }

    @Test
    public void testEmptyCurrency() {
        double result = currencyHelper.currencyConverter(0.0, 0.0, "0.00", Locale.ROOT);
        assertEquals(result, 0.0, .01);
    }

    @Test
    public void testBasicConversion() {
        double fromRate = 1.0; // 1 USD
        double toRate = 0.85;  // 0.85 EUR
        String amount = "100.00";  // 100 USD
        double expected = 85.0;  // Expected result is 85 EUR
        double result = currencyHelper.currencyConverter(fromRate, toRate, amount, Locale.ROOT);
        assertEquals(expected, result, 0.01f); // Allow a small delta for floating-point comparison
    }

    @Test
    public void testConversionWithNegativeAmount() {
        double fromRate = 1.0;
        double toRate = 0.85; 
        String amount = "-100.00";
        double expected = -85.0;
        double result = currencyHelper.currencyConverter(fromRate, toRate, amount, Locale.ROOT);
        assertEquals(expected, result, 0.01);
    }



}
