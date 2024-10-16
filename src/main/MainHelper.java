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

            if (money.matches(REGEX1) || money.matches(REGEX2)) {
                return true;
            } else {
                return false;
            }
        }
        else {
            String REGEX = "^\\d{1,3}(,{1}\\d{3})*(\\.\\d{1,2})?$";

            if (money.matches(REGEX)) {
                return true;
            } else {
                return false;
            }
        }
    }


    public static boolean is_positive(float f) {
        return f > 0;
    }

    public static boolean is_zero (float f) {
        return f == 0;
        
    }
}