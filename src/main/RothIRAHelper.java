/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package main;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author kylin
 */
public class RothIRAHelper {

    public static Boolean validate_ages(String Retirement_Age, String Current_Age) {
        int RA;
        int CA;
        try{
            RA = Integer.parseInt(Retirement_Age);
            CA = Integer.parseInt(Current_Age);
        }
        catch (NumberFormatException e) {
            return false;
        }

        if (RA <= CA ||CA <= 0 || RA>120) {
            return false;
        }
        
        return true;
    }

    public static String generate_age_warning(String Retirement_Age, String Current_Age) {
        int RA;
        int CA;
        try{
            RA = Integer.parseInt(Retirement_Age);
            CA = Integer.parseInt(Current_Age);
        }
        catch (NumberFormatException e) {
            return "Ages must be valid whole number integers.";
        }
        
        if (RA <= CA){
            return "You are already in retirement";
        }
        
        if (CA <= 0 || RA > 120) {
            return "Please provide positive and reasonable ages"; 
        }
        
        return "Unknown error has occured";    }
    
    public static List<Integer> Roth_IRA(int years, int CA, float contribution, float ERR, float Current) {
        List<Integer> Roth_IRA = new ArrayList<>();
        float balance = Current;
        Roth_IRA.add(Math.round(balance));
        for (int i = 0; i < years; i++){
            balance += balance * ERR;
            if (CA+years > 50 || contribution < 7000){
                balance += contribution;
            }
            else {
                balance += 7000;
            }
            Roth_IRA.add(Math.round(balance));
        }
        return Roth_IRA;
    }
    
    public static List<Integer> TaxableAccount(int years, int CA, float contribution, float ERR, float Current, float Tax) {
        List<Integer> TaxAccount = new ArrayList<>();
        float balance = Current;
        TaxAccount.add(Math.round(balance));
        for (int i = 0; i < years; i++){
            balance += balance * ERR *(1-Tax);
            if (CA+years > 50 || contribution < 7000){
                balance += contribution;
            }
            else {
                balance += 7000;
            }
            TaxAccount.add(Math.round(balance));
        }
        return TaxAccount;
    }
    public static Integer Total_Taxes(int years, int CA, float contribution, float ERR, float Current, float Tax) {
        List<Integer> TaxAccount = new ArrayList<>();
        float balance = Current;
        TaxAccount.add(Math.round(balance));
        float Total_Taxes = 0;
        for (int i = 0; i < years; i++){
            balance += balance * ERR *(1-Tax);
            Total_Taxes += (balance * ERR) - (balance * ERR *(1-Tax));
            if (CA+years > 50 || contribution < 7000){
                balance += contribution;
            }
            else {
                balance += 7000;
            }
            TaxAccount.add(Math.round(balance));
        }
        return Math.round(Total_Taxes);
    }
    public static List<Integer> Principal(int years, int CA, float contribution, float Current) {
        List<Integer> Principal = new ArrayList<>();
        float balance = Current;
        Principal.add(Math.round(balance));
        for (int i = 0; i < years; i++){
            if (CA+years > 50 || contribution < 7000){
                balance += contribution;
            }
            else {
                balance += 7000;
            }
            Principal.add(Math.round(balance));
        }
        return Principal;
    }
    
}
