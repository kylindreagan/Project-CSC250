package test.java;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import static org.junit.Assert.*;
import java.util.List;

import main.RetirementHelper;

public class RetirementHelperTest {

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
    public void testTotalRequiredRetirementIncome() {
        float FIN = 50000f;
        int LE = 85;
        int RA = 65;
        int CA = 45;
        float OIAR = 1000f;
        float Inflate = 0.02f;
        float Invest = 0.05f;

        List<Integer> result = RetirementHelper.Total_Required_Retirement_Income(FIN, LE, RA, CA, OIAR, Inflate, Invest);
        assertFalse(result.isEmpty());
        assertTrue("The calculated income should be positive", result.get(0) > 0);
    }

    @Test
    public void testTotalObtainedRetirementIncome() {
        int Living_Years = 20;
        float PIT = 60000f;
        float Invest = 0.05f;
        float Current = 100000f;
        float future = 0.1f;
        float Increase = 0.03f;

        List<Integer> result = RetirementHelper.Total_Obtained_Retirement_Income(Living_Years, PIT * future, Invest, Current, Increase);
        assertFalse(result.isEmpty());
        assertTrue("Total obtained should increase over time due to investment", result.get(result.size() - 1) > Current);
    }

    @Test
    public void testValidateAges_ValidAges() {
        assertTrue(RetirementHelper.validate_ages("65", "45", "85"));
    }

    @Test
    public void testValidateAges_InvalidAges() {
        assertFalse(RetirementHelper.validate_ages("45", "65", "85"));
        assertFalse(RetirementHelper.validate_ages("65", "45", "64"));
        assertFalse(RetirementHelper.validate_ages("65", "0", "85"));
        assertFalse(RetirementHelper.validate_ages("65", "45", "151"));
    }

    @Test
    public void testGenerateAgeWarning() {
        assertEquals("⚠ Life expectancy needs to be larger than planned retirement age.",
                RetirementHelper.generate_age_warning("65", "45", "64"));
        assertEquals("⚠ You are already in retirement",
                RetirementHelper.generate_age_warning("45", "65", "85"));
        assertEquals("⚠ Please provide positive and reasonable ages",
                RetirementHelper.generate_age_warning("65", "0", "85"));
        assertEquals("⚠ Ages must be valid whole number integers.",
                RetirementHelper.generate_age_warning("sixty-five", "forty-five", "eighty-five"));
    }

    @Test
    public void testValidateDynamic() {
        assertTrue(RetirementHelper.validate_dynamic("1000", false));
        assertFalse(RetirementHelper.validate_dynamic("Invalid", false));
    }

    @Test
    public void testParseDynamic() {
        assertEquals(10.0f, RetirementHelper.parseDynamic("1000", true), 0.01f);
        assertEquals(1000.0f, RetirementHelper.parseDynamic("1000", false), 0.01f);
    }

    @Test
    public void testIntialParameters() {
        List<Integer> TORI = RetirementHelper.Total_Obtained_Retirement_Income(32,7000.00f,.06f,30000,.03f);
        Integer final_obtained = TORI.get(TORI.size()-1);
        assertEquals(1098537,final_obtained, 0.01f);
    }
}
