package tests;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;


public class MonthlyPaymentTest {

    public MonthlyPaymentTest() {
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
// Tests if input is 0.0
@Test
public void testMonthlyPayment0() {
    System.out.println("monthlyPayment");
    double amt = 0.0;
    double yearlyInterestRate = 0.0;
    int numYears = 0;
    double expResult = 0.0;
    double result = MonthlyPayment.monthlyPayment(amt, yearlyInterestRate, numYears, true);
    assertEquals(expResult, result, 0);
}

//Tests if amt is $400 at 5% for 4 years. Computes only monthly payment
@Test
public void testMonthlyPayment400M() {
        System.out.println("monthlyPayment");
        double amt = 400.0;
        double yearlyInterestRate = 5.0;
        int numYears = 4;
        double expResult = 9.21;
        double result = MonthlyPayment.monthlyPayment(amt, yearlyInterestRate, numYears, false);
        assertEquals(expResult, result, 0);
    }

//Tests if amt is $400 at 5% for 4 years. Computes only total payment
@Test
public void testMonthlyPayment400T() {
        System.out.println("monthlyPayment");
        double amt = 400.0;
        double yearlyInterestRate = 5.0;
        int numYears = 4;
        double expResult = 442.16;
        double result = MonthlyPayment.monthlyPayment(amt, yearlyInterestRate, numYears, true);
        assertEquals(expResult, result, 0);
    }
}