/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package main;

/**
 *
 * @author gustavo
 */

import java.math.BigDecimal;
import java.math.RoundingMode;

public class RentCalculatorHelper {
    private static final double MIN_PERCENT = 0.28;
    private static final double MAX_PERCENT = 0.36;
    private static final double THRESHOLD_PERCENT = 1.0 / 3.0; 
    
    private static double roundToTwoDecimals(double value) {
        BigDecimal bd = new BigDecimal(Double.toString(value));
        bd = bd.setScale(2, RoundingMode.HALF_UP); 
        return bd.doubleValue();
    }

    public static boolean isValidNumber(String test) {
        if (test == null || test.trim().isEmpty()) {
            return false;
        }
        
        try {
            Double.valueOf(test.trim());
            return true; 
        } catch (NumberFormatException e) {
            return false; 
        }
    }
    
    public static double ThreshHold(double income) {
        return roundToTwoDecimals(income * THRESHOLD_PERCENT);
    }
    
    public static double max(double income, double debt) {
        double maximumIncome = MAX_PERCENT * income;
        double max = maximumIncome - debt;
        return roundToTwoDecimals(max);
    }
    
    public static double min(double income, double debt) {
        double minimumIncome = MIN_PERCENT * income;
        double min = minimumIncome - debt;
        return roundToTwoDecimals(min);
    }
    
    public static double calculateRentFromYearly(double yearlyIncome) {
        double monthlyIncome = yearlyIncome / 12;
        return roundToTwoDecimals(monthlyIncome);
    }
}
