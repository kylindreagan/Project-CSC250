package test.java;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import static org.junit.Assert.*;

import org.jsoup.Jsoup;

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
    public void testWebScraperSuccess() {
        String result = currencyHelper.webScraper();
        assertEquals("success", result);
        fail("The test case is a prototype.");
    }
}