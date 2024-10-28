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

    public static List<Integer> Total_Required_Retirement_Income(float FIN, int LE, int RA, int CA, float OIAR, float Inflate, float Invest){
        List<Integer> TRRI = new ArrayList<>();
        float Yearly_Needs = (FIN - OIAR*12); //OIAR = Other Income After Retirement 
        System.out.println(Yearly_Needs);
        float Total_Needs = 0.0f;
        TRRI.add(0);
        for (int i = LE; i >= RA; i--) {
           Total_Needs += (Yearly_Needs * (float)Math.pow(1+Inflate,i-CA)) / (float)Math.pow(1 + Invest, i - RA + 1);
            TRRI.add(Math.round(Total_Needs));
            System.out.println("Year " + i + " Total Needs (discounted): " + Total_Needs);
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
        }
        return TORI;
    }
    
    public static List<Integer> Total_Obtained_Retirement_Income_Alt(int Living_Years, float Invest, float Current, float future) {
        List<Integer> TORI = new ArrayList<>();
        float savings = Current;
        TORI.add(Math.round(savings));
        for (int i = 0; i < Living_Years; i++){
            float contribution = future;
            savings *= (1+Invest);
            savings += contribution;
            TORI.add(Math.round(savings));
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
    
    public static int posOfSmallestElementGtOeT(Integer limit, List<Integer> list) {
    double greater = 0;
    int pos = -1;
    for(int i=0; i < list.size(); i++) {
        if(list.get(i) >= limit) {
            if(pos == -1) // check whether its the first value above the limit in the list
                pos = i;
            else if(list.get(pos) > list.get(i)) //compare the current value with the previous smallest value
                pos = i;
        }
    }
    return pos;
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