package test.java;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import main.MainHelper;

public class MainHelperTest {
    public MainHelperTest() {
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
    public void testValidateMoney_ValidInteger() {
        assertTrue(MainHelper.validate_money("100"));
    }

    @Test
    public void testValidateMoney_ValidFloat() {
        assertTrue(MainHelper.validate_money("100.50"));
    }

    @Test
    public void testValidateMoney_ValidWithComma() {
        assertTrue(MainHelper.validate_money("1,000"));
    }

    @Test
    public void testValidateMoney_ValidWithCommaDecimal() {
        assertTrue(MainHelper.validate_money("1,000.50"));
    }

    @Test
    public void testValidateMoney_InvalidAlphaCharacters() {
        assertFalse(MainHelper.validate_money("100a"));
    }

    @Test
    public void testValidateMoney_InvalidEmptyString() {
        assertFalse(MainHelper.validate_money(""));
    }

    @Test
    public void testValidateMoney_InvalidSpecialCharacters() {
        assertFalse(MainHelper.validate_money("$100"));
    }

    @Test
    public void testValidateMoney_ValidDecimalWithComma() {
        assertTrue(MainHelper.validate_money("1.000,50"));
    }

    @Test
    public void testValidateMoney_ValidThousandSeparator() {
        assertTrue(MainHelper.validate_money("2,500.00"));
    }

    @Test
    public void testValidateMoney_InvalidMultipleDots() {
        assertFalse(MainHelper.validate_money("100.50.60"));
    }

    @Test
    public void testValidateMoney_ValidSmallDecimal() {
        assertTrue(MainHelper.validate_money("0.99"));
    }
}
