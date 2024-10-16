/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package main;

import java.util.Locale;

import org.apache.commons.validator.routines.BigDecimalValidator;
import org.apache.commons.validator.routines.CurrencyValidator;

/**
 *
 * @author kylin
 */
public class MainHelper {

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