package test.java;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import main.MonthlyPayment;

import static org.junit.Assert.*;


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
// Tests if inputs are 0.0
@Test
public void testMonthlyPayment0() {
    System.out.println("monthlyPayment");
    double amt = 0.0;
    double yearlyInterestRate = 0.0;
    int numYears = 0;
    String expResult = "0.00";
    String result = MonthlyPayment.calculatePayment(amt, yearlyInterestRate, numYears, true);
    assertEquals("Test 0", result, expResult);
}

//Tests if amt is $400 at 5% for 4 years. Computes only monthly payment
@Test
public void testMonthlyPayment400M() {
        System.out.println("monthlyPayment");
        double amt = 400.0;
        double yearlyInterestRate = 5.0;
        int numYears = 4;
        String expResult = "9.21";
        String result = MonthlyPayment.calculatePayment(amt, yearlyInterestRate, numYears, false);
        assertEquals("Tests if amt is $400 at 5% for 4 years. Computes only monthly payment", result, expResult);
    }

//Tests if amt is $400 at 5% for 4 years. Computes only total payment
@Test
public void testMonthlyPayment400T() {
        System.out.println("monthlyPayment");
        double amt = 400.0;
        double yearlyInterestRate = 5.0;
        int numYears = 4;
        String expResult = "442.16";
        String result = MonthlyPayment.calculatePayment(amt, yearlyInterestRate, numYears, true);
        assertEquals("Tests if amt is $400 at 5% for 4 years. Computes only total payment", result, expResult);
    }
//Tests if inputs are negative values. 
public void testMonthlyPaymentNegative() {
    System.out.println("monthlyPayment");
    double amt = -1;
    double yearlyInterestRate = -1;
    int numYears = -1;
    String expResult = "0.00";
    String result = MonthlyPayment.calculatePayment(amt, yearlyInterestRate, numYears, true);
    assertEquals("Tests if inputs are negative values.", result, expResult);
}

}
