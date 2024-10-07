package main;

public class MonthlyPayment {
    
    public static boolean isPositive(double n){
            return n > 0;
    }

    public static double monthlyPayment(double amt, double yearlyInterestRate, int numYears, boolean total){
            if (isPositive(amt) && isPositive(yearlyInterestRate) && isPositive(numYears)){
                int months = numYears * 12;
                double monthlyInterestRate = (yearlyInterestRate * 0.01) / 12;
                double monthlyPayment = (amt * monthlyInterestRate) / (1 - (1 / Math.pow((1 + monthlyInterestRate),months)));
                double totalPayment = monthlyPayment * 12;
                if (total){
                    return totalPayment;
                } else{
                    return monthlyPayment;
                }
            } else{
                return 0.0;

            }
    }
}