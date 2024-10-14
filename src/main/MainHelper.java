package main;
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Alyssa
 */
public class MainHelper {
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
    
    public static boolean isPositive (double n) {
        return n > 0;
    }

    public static boolean validate_money(String money) {
        float f;
        int i;
        try{
             i = Integer.parseInt(money);
            return true;
        }
        catch (NumberFormatException e1) {
            try {
                f = Float.parseFloat(money);
            }
            catch (NumberFormatException e2) {
                return false;
            }
            if (money.indexOf(".") != (money.length()-3)) {
                return false;
            }

            return true;
            }
    }
}
