/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Alyssa
 */
public class Helper {
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
}
