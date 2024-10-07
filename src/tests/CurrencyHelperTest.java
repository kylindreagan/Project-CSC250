package tests;

import org.jsoup.Jsoup;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;

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
        assertEquals("fail", result);
    }
    @Test
    public void testWebScraperIOException() throws IOException {
        Jsoup jsoupMock = mock(Jsoup.class);
        when(jsoupMock.connect(anyString())).thenThrow(new IOException("Simulated connection error"));

        String result = currencyHelper.webScraper();
        assertEquals("success", result);
    }

}
