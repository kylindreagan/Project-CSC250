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
        float Yearly_Gets = OIAR*12;
        System.out.println(Yearly_Needs);
        float Total_Needs = 0.0f;
        TRRI.add(0);
        for (int i = LE; i >= RA; i--) {
            Total_Needs += ((FIN * (float)Math.pow(1+Inflate,i-CA)) - Yearly_Gets) / (float)Math.pow(1 + Invest, i - RA + 1);
            TRRI.add(Math.round(Total_Needs));
            System.out.println("Year " + i + " Total Needs (discounted): " + Total_Needs);
        }
        Collections.reverse(TRRI); // Reverse the list in-place for correct order
        return TRRI;
    }

    public static List<Integer> Total_Obtained_Retirement_Income(int Living_Years, float PTI, float Invest, float Current, float Increase) {
        List<Integer> TORI = new ArrayList<>();
        float savings = Current;
        TORI.add(Math.round(savings));
        for (int i = 1; i <= Living_Years; i++){
            float particular_solution;
            if (Invest != Increase) {
                particular_solution = ((PTI * (float)Math.abs(Math.pow(1 + Invest, i) - Math.pow(1 + Increase, i))) / Math.abs(Invest - Increase));
                savings = Current * (float)Math.pow(1 + Invest, i) + particular_solution;
            }
            else {
                savings = (Current + PTI * i) * (float)Math.pow(1 + Increase, i);
            }
            
            TORI.add(Math.round(savings));
        }
        return TORI;
    }
    
    public static float Current_Needed(float Invest, float ending_value, Integer Living_Years) {
        return ending_value / (float)Math.pow(1+Invest, Living_Years);
    }

    public static Integer Total_Obtained_Retirement_Income_At_Year(int Living_Years, float PTI, float Invest, float Current, float Increase) {
        float TORI = Math.round(Current * Math.pow(1 + Invest, Living_Years) + ((PTI * Math.abs(Math.pow(1 + Invest, Living_Years) - Math.pow(1 + Increase, Living_Years))) / Math.abs(Invest - Increase)));
        System.out.println(TORI);
        return Math.round(TORI);
    }
    
    public static List<Integer> Total_Obtained_Retirement_Income_Alt(int Living_Years, float Invest, float Current, float future) {
        List<Integer> TORI = new ArrayList<>();
        for (int i = 0; i <= Living_Years; i++){
            float savings = Current + (future * (1+Invest) * ((float)Math.pow(1+Invest,i)-1))/Invest;
            TORI.add(Math.round(savings));
        }
        return TORI;
    }
    
    public static List<Integer> Total_Obtained_Retirement_Income_Monthly(int Living_Years, float Invest, float Current, float Annual, float Monthly) {
        List<Integer> TORI = new ArrayList<>();
        float savings = Current;
        float monthlyInvestRate = (float)Math.pow(1 + Invest, 1.0 / 12) - 1;
        TORI.add(Math.round(savings));
        for (int i = 1; i <= Living_Years*12; i++){
            savings *= (1+monthlyInvestRate);
            savings += Monthly;
            if (i % 12 == 0) {
                savings += Annual;
                TORI.add(Math.round(savings));
            }
        }
        return TORI;
    }
    
    public static float Inverse_TORI(float ending_value, int Living_Years, float PIT, float Invest, float Current, float Increase) {
        float future;
        if (Invest != Increase) {
            float numerator = (ending_value - Current * (float)Math.pow(1 + Invest, Living_Years)) * Math.abs(Invest - Increase);
            float denom = PIT * Math.abs((float)Math.pow(1 + Invest, Living_Years) - (float)Math.pow(1 + Increase, Living_Years));
            future = numerator / denom;
        }
        else {
            future = (ending_value / (float)Math.pow(1 + Invest, Living_Years) - Current) / (PIT * Living_Years);
        }
        return future;
    }
    
    public static float Inverse_PTI(float ending_value, int Living_Years, float Invest, float Current) {
        float PTI;
        PTI = ((ending_value - Current) * Invest) / ((1+Invest)*((float)Math.pow((1+Invest), Living_Years)-1));
        return PTI;
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
    
    public static Integer Earliest_Retirement(float final_needed, Integer final_obtained, Integer RA, Integer CA, float Inflate, float Yearly_Gets, float Invest, float FIN) {
        for (int i=RA; i>=CA; i--) {
            final_needed += ((FIN * (float)Math.pow(1+Inflate,i-CA)) - Yearly_Gets) / (float)Math.pow(1 + Invest, i - RA + 1);
            if (final_needed > final_obtained) {
                return i+1;
            }
        }
        return -1;
        
    }
    
    public static List<Integer> WithdrawPlan(int final_obtained, float withdrawrate, float invest, float inflate, int LY) {
        List<Integer> withdraw = new ArrayList<>();
        float current = final_obtained;
        float monthlyInvestRate = (float)Math.pow(1 + invest, 1.0 / 12) - 1;
        withdraw.add(Math.round(current));
        for (int i=1;i<LY;i++){
            for (int j=0;j<12;j++) {
                current *= (1+monthlyInvestRate);
                current-=withdrawrate;
                if (current < 0){
                    System.out.println("Balance ran out on month "+ String.valueOf(j)+" of year " +String.valueOf(i));
                    break; // Stop further withdrawals
                }
            }
            withdrawrate += withdrawrate*inflate;
            if (current < 0){
                    withdraw.add(0);
                    break; // Stop further withdrawals
            }
            withdraw.add(Math.round(current));
        }
        
        return withdraw;
    }
    
    public static float calculateInflationAdjustedMonthly(float final_obtained, float inflate, float invest, int years) {
        float sum = 0.0f;
        System.out.println(final_obtained);
        for (int t = 0; t < years*12; t++) {
            sum += Math.pow(1 + inflate, t) / Math.pow(1 + invest, t);
        }
        return final_obtained / (sum*5);
}



    //Additional Savings Needed=PV−FV

    
}