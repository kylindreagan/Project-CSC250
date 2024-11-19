package test.java;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import static org.junit.Assert.*;
import java.util.List;
import main.RothIRAHelper;

public class RothIRAHelperTest {

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
    public void testValidateAges_InvalidAges() {
        assertFalse(RothIRAHelper.validate_ages("45", "65"));
        assertFalse(RothIRAHelper.validate_ages("65", "100"));
        assertFalse(RothIRAHelper.validate_ages("65", "0"));
        assertFalse(RothIRAHelper.validate_ages("121", "45"));
    }

    @Test
    public void testIntialParametersRothIRA() {
        List<Integer> RothIRA = RothIRAHelper.Roth_IRA(35, 30,7000.00f,.06f,20000);
        Integer final_obtained = RothIRA.get(RothIRA.size()-1);
        assertEquals(933765,final_obtained, 0.01f);
    }
    @Test
    public void testIntialParametersTaxable() {
        List<Integer> TA = RothIRAHelper.TaxableAccount(35, 30,7000.00f,.06f,20000,.25f);
        Integer final_obtained = TA.get(TA.size()-1);
        assertEquals(663823,final_obtained, 0.01f);
    }
    @Test
    public void testIntialParametersInterestT() {
        Integer final_obtained = RothIRAHelper.Total_Tax_Interest(35, 30,7000.00f,.06f,20000,.25f);
        assertEquals(531764,final_obtained, 0.01f);
    }
    @Test
    public void testIntialParametersInterestIRA() {
        Integer final_obtained  = RothIRAHelper.Total_Interest(35, 30,7000.00f,.06f,20000);
        assertEquals(675765,final_obtained, 0.01f);
    }
    @Test
    public void testIntialPrincipal() {
        List<Integer> RothIRA = RothIRAHelper.Principal(35, 30,7000.00f,20000);
        Integer final_obtained = RothIRA.get(RothIRA.size()-1);
        assertEquals(265000,final_obtained, 0.01f);
    }

    @Test
    public void testIntialParametersTaxes() {
        Integer final_obtained = RothIRAHelper.Total_Taxes(35, 30,7000.00f,.06f,20000,.25f);
        assertEquals(132941,final_obtained, 0.01f);
    }

}