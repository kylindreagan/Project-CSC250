/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package main;

import java.awt.Component;
import java.awt.Container;
import javax.swing.JTextField;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 *
 * @author kylin
 */
public class RetirementHelper {
    public static void clearAllTextFields(Container container) {
        for (Component component : container.getComponents()) {
            if (component instanceof JTextField) {
                ((JTextField) component).setText("");
            } else if (component instanceof Container) {
                // Recursively check nested containers (if any)
                clearAllTextFields((Container) component);
            }
        }
    }

    public static List<Float> Total_Required_Retirement_Income(float FIN, int Retirement_Years, float OIAR, float Invest, float PIT){
        List<Float> TRRI = new ArrayList<>();
        float end_value = FIN * Retirement_Years - OIAR * Retirement_Years * 12; //OIAR = Other Income After Retirement 
        TRRI.add(end_value);
        for (int i = Retirement_Years; i >= 0; i--) {
            end_value -= PIT * Math.pow(1+Invest, i);
            TRRI.add(end_value);
        }
        Collections.reverse(TRRI); // Reverse the list in-place for correct order
        return TRRI;
    }

    public static List<Integer> Total_Obtained_Retirement_Income(int Living_Years, float PIT, float Invest, float Current, float future, float Increase) {
        List<Integer> TORI = new ArrayList<>();
        float years_income;
        float savings = Current;
        TORI.add(Math.round(savings));
        for (int i = 0; i < Living_Years; i++){
            years_income = PIT * (float)Math.pow((1+Increase),i);
            float contribution = years_income * future;
            savings *= (1+Invest);
            savings += contribution;
            TORI.add(Math.round(savings));
            System.out.println(savings);
        }
        return TORI;
    }

    public static boolean validate_ages(String Retirement_Age, String Current_Age, String Life_Expectency) {
        int RA;
        int CA;
        int LE;
        try{
            RA = Integer.parseInt(Retirement_Age);
            CA = Integer.parseInt(Current_Age);
            LE = Integer.parseInt(Life_Expectency);
        }
        catch (NumberFormatException e) {
            return false;
        }

        if (LE <= RA || RA < CA ||CA <= 0 || LE > 150) {
            return false;
        }
        
        return true;
    }
    
    public static String generate_age_warning(String Retirement_Age, String Current_Age, String Life_Expectency) {
        int RA;
        int CA;
        int LE;
        try{
            RA = Integer.parseInt(Retirement_Age);
            CA = Integer.parseInt(Current_Age);
            LE = Integer.parseInt(Life_Expectency);
        }
        catch (NumberFormatException e) {
            return "Ages must be valid whole number integers.";
        }

        if (LE <= RA) {
            return "Life expectancy needs to be larger than planned retirement age.";
        }
        
        if (RA < CA){
            return "You are already in retirement";
        }
        
        if (CA <= 0 || LE > 150) {
            return "Please provide positive and reasonable ages"; 
        }
        
        return "Unknown error has occured";
    }
    
    public static Boolean validate_dynamic(String value, Boolean is_percent) {
        return MainHelper.validate_money(value, false);
    }
    
    public static float parseDynamic(String value, Boolean is_percent){
        if (is_percent) {
            return MainHelper.parseMoney(value, ",") / 100;
        }
        else{
            return MainHelper.parseMoney(value, ",");
        }
    }

    //Additional Savings Needed=PV−FV

    
}