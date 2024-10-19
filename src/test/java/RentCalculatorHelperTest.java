/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package test.java;

import org.junit.Test;
import static org.junit.Assert.*;

import main.RentCalculatorHelper;

/**
 *
 * @author gustavo
 */
public class RentCalculatorHelperTest {
    
    public RentCalculatorHelperTest() {
    }

    /**
     * Test of isValidNumber method, of class RentCalculatorHelper.
     */
    @Test
    //tests if input is a number
    public void testIsValidNumberNum() {
        System.out.println("isValidNumber");
        String test = "abc";
        boolean expResult = false;
        boolean result = RentCalculatorHelper.isValidNumber(test);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
    }
    
    @Test
    //tests if input is a number
    public void testIsValidNumberNumempty() {
        System.out.println("isValidNumber");
        String test = "";
        boolean expResult = false;
        boolean result = RentCalculatorHelper.isValidNumber(test);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of ThreshHold method, of class RentCalculatorHelper.
     */
    @Test
    //makes 1/3 of a number
    public void testThreshHold40() {
        System.out.println("ThreshHold");
        double income = 40.00;
        double expResult = 13.33;
        double result = RentCalculatorHelper.ThreshHold(income);
        assertEquals(expResult, result, 0);
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of max method, of class RentCalculatorHelper.
     */
    @Test
    //Calculates the max rental payment
    public void testMax() {
        System.out.println("max");
        double income = 1000;
        double debt = 0;
        double expResult = 360;
        double result = RentCalculatorHelper.max(income, debt);
        assertEquals(expResult, result, 0);
        // TODO review the generated test code and remove the default call to fail.
    }
    @Test
    //calculates the max rental payment
    public void testMax0() {
        System.out.println("max");
        double income = 0;
        double debt = 0;
        double expResult = 0;
        double result = RentCalculatorHelper.max(income, debt);
        assertEquals(expResult, result, 0);
        // TODO review the generated test code and remove the default call to fail.
    }
    
    @Test
    //calculates the max rental payment, works for negatives, but main frame
    //wont allow a negative income to get sent to the testMax. Only negative 
    //number allowed is debt. 
    public void testMax4() {
        System.out.println("max");
        double income = 4;
        double debt = -3;
        double expResult = 4.44;
        double result = RentCalculatorHelper.max(income, debt);
        assertEquals(expResult, result, 0);
        // TODO review the generated test code and remove the default call to fail.
    }
    

    /**
     * Test of min method, of class RentCalculatorHelper.
     */
    @Test
    //Tests the minimum rental payment
    public void testMin() {
        System.out.println("min");
        double income = 400;
        double debt = 30;
        double expResult = 82;
        double result = RentCalculatorHelper.min(income, debt);
        assertEquals(expResult, result, 0);
        // TODO review the generated test code and remove the default call to fail.
    }
    @Test
    //calculates the min rental payment, works for negatives, but main frame
    //wont allow a negative income to get sent to the testMin. Only negative 
    //number allowed is debt. 
    public void testMinNeg() {
        System.out.println("min");
        double income = 400;
        double debt = -30;
        double expResult = 142;
        double result = RentCalculatorHelper.min(income, debt);
        assertEquals(expResult, result, 0);
        // TODO review the generated test code and remove the default call to fail.
    }


    /**
     * Test of calculateRentFromYearly method, of class RentCalculatorHelper.
     */
    @Test
    //calculates a number divided by 12.
    public void testCalculateRentFromYearly() {
        System.out.println("calculateRentFromYearly");
        double yearlyIncome = 40;
        double expResult = 3.33;
        double result = RentCalculatorHelper.calculateRentFromYearly(yearlyIncome);
        assertEquals(expResult, result, 0);
        // TODO review the generated test code and remove the default call to fail.
    }
    
}
