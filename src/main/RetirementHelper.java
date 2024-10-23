/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package main;

import java.awt.Component;
import java.awt.Container;
import javax.swing.JTextField;

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

    public static float Future_Income_Needed(float PreTax_Income, int Retirement_Age, int Current_Age, int Retirement_Years,float Annual_Increase, float Inflation) {
        float FIN;

        double Expected_Increase = Math.pow((1+Annual_Increase), (Retirement_Age-Current_Age));
        double Expected_Decrease = Math.pow((1+Inflation), Retirement_Years); //Retirement Years = Life Expectancy - Retrement Age

        FIN = (float)(PreTax_Income * Expected_Decrease * Expected_Increase);
        return FIN;
    }

    public static float Total_Required_Retirement_Income(float FIN, int Retirement_Years, float OIAR, float Investment_Return_Rate){
        return FIN * Retirement_Years - OIAR * Retirement_Years; //OIAR = Other Income After Retirement 
    }

    public static float Present_Value_of_Required_Retirement_Income(float FIN, int Retirement_Years, float Inflation,  float Investment_Return_Rate) {
        float PV = 0.0f;
        float r = (Investment_Return_Rate - Inflation) / 100; 

        for (int i = 1; i <= Retirement_Years; i++) {
            PV += FIN / Math.pow(1+r, i);
        }

        return PV;
    }

    public static float Future_Value_of_Current_and_Future_Retirement_Savings(float Current_Savings, float Future_Savings, int Retirement_Age, int Current_Age, int Retirement_Years, float Investment_Return_Rate){
        float FV;

        double Prospective_Funds = Math.pow((1 + Investment_Return_Rate),(Retirement_Age-Current_Age));

        FV = Current_Savings * (float)Prospective_Funds;

        for (int i = 1; i <= Retirement_Years; i++) {
            FV += Future_Savings / Math.pow(1+Investment_Return_Rate, i);
        }

        return FV;
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

    //Additional Savings Needed=PV−FV

    
}