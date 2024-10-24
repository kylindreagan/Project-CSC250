/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package main;
/**
 *
 * @author kylin
 */
public class MainHelper {

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