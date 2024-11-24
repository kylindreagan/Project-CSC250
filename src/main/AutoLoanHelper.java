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
    
    public static String carPriceCalculate (float lTerm, float intRate, float sTax, float cIncent, float dPay, float trade, float amtOwed, float fees, float monthly){
        float totalPayments = monthly * lTerm;
        Double totalLoanAmount = AmortizationHelper.principalFromMP(intRate, lTerm, monthly);
        Double totalLoanInterest = totalPayments - totalLoanAmount;
        Double car = totalLoanAmount + dPay + cIncent - amtOwed;
        Double saleTax = (car) * (sTax/100);
        Double upfrontPayment = saleTax + dPay + fees;
        Double totalCost = totalPayments + upfrontPayment + trade - amtOwed;
        String s = new DecimalFormat ("#,###.00").format (totalLoanAmount);
        String s1 = new DecimalFormat ("#,###.00").format (car + trade);
        String s2 = new DecimalFormat ("#,###.00").format (saleTax);
        String s3 = new DecimalFormat ("#,###.00").format (upfrontPayment);
        String s4 = new DecimalFormat ("#,###.00").format (totalPayments);
        String s5 = new DecimalFormat ("#,###.00").format (totalLoanInterest);
        String s6 = new DecimalFormat ("#,###.00").format (totalCost);
        return "Vehicle Price is: $" +s1 + "\nTotal Loan Amount is: $"+ s + "\nSale Tax is: $"+ s2 + "\nUpfront Payment is: $"+ s3 + "\nTotal of "+ lTerm + " Loan Payments is: $"+ s4 + "\nTotal Loan Interest is: $"+ s5 + "\nTotal Cost is: $"+ s6;
    }
    
    public static String carPriceCalculateFees(float lTerm, float intRate, float sTax, float cIncent, float dPay, float trade, float amtOwed, float fees, float monthly){
        float totalPayments = monthly * lTerm;
        Double totalLoanAmount = AmortizationHelper.principalFromMP(intRate, lTerm, monthly);
        Double totalLoanInterest = totalPayments - totalLoanAmount;
        Double car = totalLoanAmount + fees + cIncent - amtOwed;
        Double saleTax = (car -trade) * (sTax/100);
        float upfrontPayment = dPay;
        float totalCost = totalPayments + upfrontPayment + trade - amtOwed;
        String s = new DecimalFormat ("#,###.00").format (totalLoanAmount);
        String s1 = new DecimalFormat ("#,###.00").format (car + trade + saleTax);
        String s2 = new DecimalFormat ("#,###.00").format (saleTax);
        String s3 = new DecimalFormat ("#,###.00").format (upfrontPayment);
        String s4 = new DecimalFormat ("#,###.00").format (totalPayments);
        String s5 = new DecimalFormat ("#,###.00").format (totalLoanInterest);
        String s6 = new DecimalFormat ("#,###.00").format (totalCost);
        return "Vehicle Price is: $" +s1 + "\nTotal Loan Amount is: $"+ s + "\nSale Tax is: $"+ s2 + "\nUpfront Payment is: $"+ s3 + "\nTotal of "+ lTerm + " Loan Payments is: $"+ s4 + "\nTotal Loan Interest is: $"+ s5 + "\nTotal Cost is: $"+ s6;
    }
    
    public static String monthlyPaymentCalculate(float lTerm, float intRate, float sTax, float cIncent, float dPay, float trade, float amtOwed, float fees, float car){
        float loanAmt = car - dPay - cIncent - trade + amtOwed;
        Double monthlyPayment = AmortizationHelper.amortizationInterest(loanAmt, intRate, lTerm);
        float saleTax = (car- trade) * (sTax/100);
        float upfrontPayment = saleTax + dPay + fees;
        Double totalPayments = monthlyPayment * lTerm;
        Double totalLoanInterest = totalPayments - loanAmt;  
        Double totalCost = totalLoanInterest + upfrontPayment + loanAmt + trade - amtOwed;
        String s = new DecimalFormat ("#,###.00").format (monthlyPayment);
        String s1 = new DecimalFormat ("#,###.00").format (loanAmt);
        String s2 = new DecimalFormat ("#,###.00").format (saleTax);
        String s3 = new DecimalFormat ("#,###.00").format (upfrontPayment);
        String s4 = new DecimalFormat ("#,###.00").format (totalPayments);
        String s5 = new DecimalFormat ("#,###.00").format (totalLoanInterest);
        String s6 = new DecimalFormat ("#,###.00").format (totalCost);
        return "Monthly Payment is: $" +s + "\nLoan Amount is: $"+ s1 + "\nSale Tax is: $"+ s2 + "\nUpfront Payment is: $"+ s3 + "\nTotal of "+ lTerm + " Loan Payments is: $"+ s4 + "\nTotal Loan Interest is: $"+ s5 + "\nTotal Cost is: $"+ s6;
    }
    
    public static String monthlyPaymentCalculateFees(float lTerm, float intRate, float sTax, float cIncent, float dPay, float trade, float amtOwed, float fees, float car){
        float saleTax = (car- trade) * (sTax/100);
        float loanAmt = car - dPay - cIncent - trade + amtOwed + fees + saleTax;
        Double monthlyPayment = AmortizationHelper.amortizationInterest(loanAmt, intRate, lTerm);        
        float upfrontPayment = dPay;
        Double totalPayments = monthlyPayment * lTerm;
        Double totalLoanInterest = totalPayments - loanAmt;  
        Double totalCost = totalLoanInterest + upfrontPayment + loanAmt + trade - amtOwed - saleTax - fees;
        String s = new DecimalFormat ("#,###.00").format (monthlyPayment);
        String s1 = new DecimalFormat ("#,###.00").format (loanAmt);
        String s2 = new DecimalFormat ("#,###.00").format (saleTax);
        String s3 = new DecimalFormat ("#,###.00").format (upfrontPayment);
        String s4 = new DecimalFormat ("#,###.00").format (totalPayments);
        String s5 = new DecimalFormat ("#,###.00").format (totalLoanInterest);
        String s6 = new DecimalFormat ("#,###.00").format (totalCost);
        return "Monthly Payment is: $" +s + "\nLoan Amount is: $"+ s1 + "\nSale Tax is: $"+ s2 + "\nUpfront Payment is: $"+ s3 + "\nTotal of "+ lTerm + " Loan Payments is: $"+ s4 + "\nTotal Loan Interest is: $"+ s5 + "\nTotal Cost is: $"+ s6;
    }
}
