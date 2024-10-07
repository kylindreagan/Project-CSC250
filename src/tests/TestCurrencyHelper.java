import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class TestCurrencyHelper {
    @Test
    public void testWebScraperSuccess() {
        String result = currency.webScraper();
        assertEquals("fail", result);
    }
    @Test
    public void testWebScraperIOException() throws IOException {
        Jsoup jsoupMock = mock(Jsoup.class);
        when(jsoupMock.connect(anyString())).thenThrow(new IOException("Simulated connection error"));

        String result = currency.webScraper();
        assertEquals("success", result);
    }

}
