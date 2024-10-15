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
    
    public static boolean isPositive (float n) {
        return n > 0;
    }
    
    public static float strIntoFloat (String n) {
        return Float.parseFloat(n);
    }
    
    public static boolean isZeroS (String n) {
        return Float.parseFloat(n) == 0;
        
    }
}
