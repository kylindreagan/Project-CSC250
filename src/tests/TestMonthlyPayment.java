
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;


public class TestMonthlyPayment {
// Tests if input is 0.0
@Test
public void testMonthlyPayment0() {
    System.out.println("monthlyPayment");
    double amt = 0.0;
    double yearlyInterestRate = 0.0;
    int numYears = 0;
    double expResult = 0.0;
    double result = Helper.monthlyPayment(amt, yearlyInterestRate, numYears, true);
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
        double result = Helper.monthlyPayment(amt, yearlyInterestRate, numYears, false);
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
        double result = Helper.monthlyPayment(amt, yearlyInterestRate, numYears, true);
        assertEquals(expResult, result, 0);
    }
}