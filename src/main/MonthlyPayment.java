package main;

public class MonthlyPayment {
    
    public static boolean isPositive(double n){
            return n > 0;
    }

    public static String calculatePayment(double amt, double yearlyInterestRate, int numYears, boolean total){
            if (isPositive(amt) && isPositive(yearlyInterestRate) && isPositive(numYears)){
                int months = numYears * 12;
                double monthlyInterestRate = (yearlyInterestRate * 0.01) / 12;
                double monthlyPayment = (amt * monthlyInterestRate) / (1 - (1 / Math.pow((1 + monthlyInterestRate),months)));
                if (total){
                    double totalPayment = monthlyPayment * months;
                    String formattedPayment = String.format("%.02f", totalPayment);
                    return formattedPayment;
                } else{
                    String formattedPayment = String.format("%.02f", monthlyPayment);
                    return formattedPayment;
                }
            } else{
                return "0.00";

            }
    }
}