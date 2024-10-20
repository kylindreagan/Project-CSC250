package test.java;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import static org.junit.Assert.*;

import java.math.BigDecimal;
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
        String result = currencyHelper.currencyConverter(0.0, 0.0, "0.00", Locale.ROOT, Locale.ROOT);
        assertEquals(result, "0.00");
    }

    @Test
    public void testBasicConversion() {
        double fromRate = 1.0;
        double toRate = 0.85;
        String amount = "100.00"; 
        String expected = "85.00"; 
        String result = currencyHelper.currencyConverter(fromRate, toRate, amount, Locale.ROOT, Locale.ROOT);
        assertEquals(expected, result);
    }

    @Test
    public void testBasicConversionWLocale() {
        double fromRate = 1.0;
        double toRate = 0.85;
        String amount = "100.00"; 
        String expected = "$85.00"; 
        String result = currencyHelper.currencyConverter(fromRate, toRate, amount, Locale.US, Locale.ROOT);
        assertEquals(expected, result);
    }

    @Test
    public void testValidateCurrency_ValidWithCommaDecimal() {
        assertTrue(currencyHelper.validate_currency("1,000.50", Locale.US));
    }

    @Test
    public void testValidateCurrency_ValidWithoutCommaDecimal() {
        assertTrue(currencyHelper.validate_currency("1000.50", Locale.US));
    }

    @Test
    public void testUnformat_USD() {
        Locale locale = Locale.US;
        String amount = "1,000.00";
        BigDecimal expected = new BigDecimal(1000.0);
        BigDecimal actual = currencyHelper.unformatCurrency(amount, locale);
        assertEquals(0, actual.compareTo(expected));
    }

    @Test
    public void testUnformat_Euro() {
        Locale locale = Locale.forLanguageTag("de-DE");;
        String amount = "1.000,00";
        BigDecimal expected = new BigDecimal(1000.0);
        BigDecimal actual = currencyHelper.unformatCurrency(amount, locale);
        assertEquals(0, actual.compareTo(expected));
    }

    @Test
    public void testEmptyAmount() {
        String result = currencyHelper.generateWarningMessage("", Locale.US);
        assertEquals("⚠ Amount cannot be empty.", result);
    }

    @Test
    public void testInvalidCharacters() {
        String result = currencyHelper.generateWarningMessage("12a34", Locale.US);
        assertEquals("⚠ Amount contains invalid characters (Can only cantains digits, commas, and dots)", result);
    }
    
    @Test
    public void testInvalidNumberEndingWithSeparator() {
        String result = currencyHelper.generateWarningMessage("1000.", Locale.US);
        assertEquals("⚠ Wrong numerical format (Must match 1,000.00 or 1000.00)", result);
    }
    @Test
    public void testValidDecimalNumberJapanLocale() {
        String result = currencyHelper.generateWarningMessage("1000.50", Locale.JAPAN);
        assertEquals("⚠ This format only is valid for nonnegative integers.", result);
    }

    @Test
    public void testValidWholeNumberChileLocale() {
        String result = currencyHelper.generateWarningMessage("1.000,50", new Locale("es", "CL"));
        assertEquals("⚠ This format only is valid for nonnegative integers.", result);
    }

    @Test
    public void testUnknownFormattingError() {
        String result = currencyHelper.generateWarningMessage("1000.50", new Locale("de", "DE"));
        assertEquals("⚠ Wrong numerical format (Must match 1.000,00 or 1000,00)", result);
    }
}
