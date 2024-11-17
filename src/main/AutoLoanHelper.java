/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package main;

import java.text.DecimalFormat;

/**
 *
 * @author giann
 */
public class AutoLoanHelper {
    public static String carPriceCalculate (float lTerm, float intRate, float sTax, float cIncent, float dPay, float trade, float fees, float monthly){
        
        return "";
    }
    
    public static String monthlyPaymentCalculate(float lTerm, float intRate, float sTax, float cIncent, float dPay, float trade, float fees, float car){
        float loanAmt = car - dPay;
        Double monthlyPayment = AmortizationHelper.amortizationInterest(loanAmt, intRate, lTerm);
        float saleTax = car * (sTax/100);
        float upfrontPayment = saleTax + dPay + fees;
        Double totalLoanInterest = monthlyPayment * lTerm;     
        Double totalPayments = loanAmt + totalLoanInterest;
        Double totalCost = totalLoanInterest + upfrontPayment;
        String s = new DecimalFormat ("#,###.00").format (monthlyPayment);
        String s1 = new DecimalFormat ("#,###.00").format (loanAmt);
        String s2 = new DecimalFormat ("#,###.00").format (saleTax);
        String s3 = new DecimalFormat ("#,###.00").format (upfrontPayment);
        String s4 = new DecimalFormat ("#,###.00").format (totalPayments);
        String s5 = new DecimalFormat ("#,###.00").format (totalLoanInterest);
        String s6 = new DecimalFormat ("#,###.00").format (totalCost);
        return "Monthly Payment is: $" +s + "\nLoan Amount is: $"+ s1 + "\nSale Tax is: $"+ s2 + "\nUpfront Payment is: $"+ s3 + "\nTotal of "+ lTerm + " Loan Payments is: $"+ s4 + "\nTotal loan Interest is: $"+ s5 + "\nTotal Cost is: $"+ s6;
    }
}
