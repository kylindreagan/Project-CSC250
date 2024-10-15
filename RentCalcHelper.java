/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author gustavo
 */

public class RentCalcHelper {
    //could have prob done this in the actual form, but already did it so it was too late lol. 
    private static final double MIN_PERCENT = 0.2216;
    private static final double MAX_PERCENT = 0.3081;
    private static final double THRESHOLD_PERCENT = 1.0 / 3.0;    
        
    public static boolean isValidNumber(String test)
    {
        if (test == null || test.trim().isEmpty()){
            return false;
        }
        
        try {
            Double.valueOf(test.trim());
            return true; 
        } 
        
        catch (NumberFormatException e) {
            return false; 
        }
    }
    
    public static String calculateRent(double monthlyIncome, double monthlyDebt) {
        
        double disposableIncome = monthlyIncome - monthlyDebt;
        //formulas for the max and min amount of rent. Confused on the actual percentage need to talk to team/Johnson
        double minimumRent = MIN_PERCENT * disposableIncome;
        double maximumRent = MAX_PERCENT * disposableIncome;
        
        
        //Looks like if I had to put 0 in the dept input for the actual website, it will give me 1/3 note.
            if (monthlyDebt <= 0) {
                double thresholdRent = THRESHOLD_PERCENT * monthlyIncome;
                return String.format(
                    "Some landlords may not accept applications with more than 1/3 of gross income on rent, which is $%.2f.\n" +
                    "You can afford up to $%.0f per month on a rental payment.\n" +
                    "It is recommended to keep your rental payment below $%.0f per month.",
                    thresholdRent, maximumRent, minimumRent
                );
            }
           

            return String.format(
                    "You can afford up to $%.0f per month on a rental payment.\n" +
                    "It is recommended to keep your rental payment below $%.0f per month.",
                    maximumRent, minimumRent
            );
    }
    
    //this is if the user inputs yearly option
    
    public static String calculateRentFromYearly(double yearlyIncome, double monthlyDebt) {
        double monthlyIncome = yearlyIncome / 12;

        return calculateRent(monthlyIncome, monthlyDebt);
    }

    
}
