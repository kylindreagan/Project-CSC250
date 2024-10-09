package test.java;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import static org.junit.Assert.*;

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
}
