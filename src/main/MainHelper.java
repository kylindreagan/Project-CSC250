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

    public static boolean validate_money(String money) {
        try{
            Integer.parseInt(money);
            return true;
        }
        catch (NumberFormatException e1) {
            if (money.contains(",") && money.indexOf(",") != (money.length()-3)) {
                money = money.replace(".", "");
                // Replace only the last comma with a dot for correct decimal formatting
                int lastCommaIndex = money.lastIndexOf(",");
                money = money.substring(0, lastCommaIndex) + "." + money.substring(lastCommaIndex + 1);
            }
            money = money.replace(",", "");
            try {
                Float.parseFloat(money);
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