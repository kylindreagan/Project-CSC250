/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package main;

import java.text.DecimalFormat;

/**
 *
 * @author kylin
 */
public class MainHelper {
    
    public static double monthlyPayment(float amt, float yearlyInterestRate, int numYears, boolean total){
        if (is_positive(amt) && is_positive(yearlyInterestRate) && is_positive(numYears)){
            int months = numYears * 12;
            double monthlyInterestRate = (yearlyInterestRate * 0.01) / 12;
            double monthlyPayment = (amt * monthlyInterestRate) / (1 - (1 / Math.pow((1 + monthlyInterestRate),months)));
            double totalPayment = monthlyPayment * 12;
            if (total){
                return totalPayment;
            } else{
                return monthlyPayment;
            }
        } else{
            return 0.0;

        }
    }

    public static boolean validate_money(String money, boolean allow_foreign) {
        if (allow_foreign) {
            String REGEX1 = "^\\d{1,3}(,{1}\\d{3})*(\\.\\d{1,2})?$";
            String REGEX2 = "^\\d{1,3}(.{1}\\d{3})*(\\,\\d{1,2})?$";
            String regexNoGroup = "^\\d+(\\.\\d{1,2})?$";
            String regexNoGroup2 = "^\\d+(\\,\\d{1,2})?$";

            if (money.matches(REGEX1) || money.matches(REGEX2) || money.matches(regexNoGroup) || money.matches(regexNoGroup2)) {
                return true;
            } else {
                return false;
            }
        }
        else {
            String REGEX = "^\\d{1,3}(,{1}\\d{3})*(\\.\\d{1,2})?$";
            String regexNoGroup = "^\\d+(\\.\\d{1,2})?$";

            if (money.matches(REGEX) || money.matches(regexNoGroup)) {
                return true;
            } else {
                return false;
            }
        }
    }
    
    public static float parseMoney(String m, String groupingSeparator) {
        Float money;
        
        m = m.replaceAll("\\Q" + groupingSeparator + "\\E", "");
        money = Float.valueOf(m);
        return money;
        
    }
    
    public static String formatCurrency(float number) {
        DecimalFormat formatter = new DecimalFormat("#,###.##");
        
        // Format the number
        return formatter.format(number);
    }

    public static String generate_USD_warning(String amount) {
        String regexWhole = "^\\d{1,3}(,{1}\\d{3})*(\\.\\d{1,2})?$";
        String regexNoGroup = "^\\d+(\\.\\d{1,2})?$";
        if (amount.isEmpty()) {
            return "⚠ Amount cannot be empty.";
        }
        
        else if (!amount.matches("^[0-9.,]*$")) {
            return "⚠ Amount contains invalid characters (Can only cantains digits, commas, and dots)";
        }
        else if (!amount.matches(regexWhole) && !amount.matches(regexNoGroup)) {
            return "⚠ Wrong numerical format (Must match 1,000.00 or 1000.00)";
        }
        return "⚠ Unknown formatting error";
    }

    public static boolean isValidNumber (String test) {
        // a valid number is any positive or zero number
        try {
            float i = Float.parseFloat(test);
            if (i < 0) {
                return false;
            }
        } catch (NumberFormatException e) {
            return false;
        }
        return true;
    }

    public static boolean is_positive(float f) {
        return f > 0;
    }
    public static boolean is_nonneg(int i) {
        return i >= 0;
    }

    public static boolean is_zero (float f) {
        return f == 0;
        
    }
    public static boolean isZeroS (String n) {
        return Float.parseFloat(n) == 0;
        
    }
}