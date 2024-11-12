/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package main;

/**
 *
 * @author giann
 */
public class AmortizationHelper {
    public static Double amortizationInterest (float principal, float intRate, float numPayments){
        Float r = (intRate/100) / 12;        
        Double numerator = (r) * Math.pow((1 + r), numPayments);        
        Double denominator = Math.pow((1 + r), numPayments) - 1;        
        Double fraction = numerator/denominator;        
        return fraction * principal;
    }
    
}
