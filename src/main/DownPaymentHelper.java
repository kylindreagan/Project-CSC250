/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package main;


import java.text.DecimalFormat;
import java.util.Dictionary;
import java.util.Hashtable;

/**
 *
 * @author giann
 */
public class DownPaymentHelper {
    static Dictionary<String, Integer> stateClosingCosts = createVals(); //Global Dictionary
    
    public static String homePriceCalculateEntry(float uCash, float dPayment, float intRate, float lTerm, float cCost){
        float homePrice = (uCash-cCost)/(dPayment/100);
        float loanAmount = homePrice - uCash + cCost;        
        double monthlyPayment = MainHelper.monthlyPayment(loanAmount, intRate, lTerm, false);
        String s = new DecimalFormat ("#,###.00").format (homePrice);
        String s2 = new DecimalFormat ("#,###.00").format (loanAmount);
        String s3 = new DecimalFormat ("#,###.00").format (monthlyPayment);
        String s4 = new DecimalFormat ("#,###.00").format (cCost);
        String s5 = new DecimalFormat ("#,###.00").format (uCash-cCost);
        String msg = "Home price is: $ " + s + '\n' + "Loan Amount is: $ " + s2 + '\n' +"Monthly Payment is: $ " + s3 + '\n' + "Closing Costs are: $ " + s4 + '\n' + "Down Payment is: $ " + s5;
        return msg;
    }
    
    public static String homePriceCalculateState(float uCash, float dPayment, float intRate, float lTerm, String cCost){
        float actualCC = stateClosingCosts.get(cCost);
        float homePrice = (uCash-actualCC)/(dPayment/100);
        float loanAmount = homePrice - uCash + actualCC;
        double monthlyPayment = MainHelper.monthlyPayment(loanAmount, intRate, lTerm, false);
        String s = new DecimalFormat ("#,###.00").format (homePrice);
        String s2 = new DecimalFormat ("#,###.00").format (loanAmount);
        String s3 = new DecimalFormat ("#,###.00").format (monthlyPayment);
        String s4 = new DecimalFormat ("#,###.00").format (actualCC);
        String s5 = new DecimalFormat ("#,###.00").format (uCash-actualCC);
        String msg = "Home price is: $ " + s + '\n' + "Loan Amount is: $ " + s2 + '\n' +"Monthly Payment is: $ " + s3 + '\n' + "Closing Costs are: $ " + s4 + '\n' + "Down Payment is: $ " + s5;
        
        return msg;
    }
    public static String homePriceCalculate(float uCash, float dPayment, float intRate, float lTerm){
        float homePrice = uCash/(dPayment/100);
        float loanAmount = homePrice - uCash;
        double monthlyPayment = MainHelper.monthlyPayment(loanAmount, intRate, lTerm, false);
        String s = new DecimalFormat ("#,###.00").format (homePrice);
        String s2 = new DecimalFormat ("#,###.00").format (loanAmount);
        String s3 = new DecimalFormat ("#,###.00").format (monthlyPayment);
        String s4 = new DecimalFormat ("#,###.00").format (uCash);
        String msg = "Home price is: $ " + s + "\nLoan Amount is: $ " + s2 + "\nMonthly Payment is: $ " + s3 + "\nDown Payment is: $ " + s4;
        return msg;
    }
    
    public static String cashCalculateEntry(float hPrice, float dPayment, float intRate, float lTerm, float cCost){
        float cash = (hPrice * (dPayment/100)) + cCost;
        float loanAmount = hPrice - cash + cCost;
        double monthlyPayment = MainHelper.monthlyPayment(loanAmount, intRate, lTerm, false);
        String s = new DecimalFormat ("#,###.00").format (cash);
        String s1 = new DecimalFormat ("#,###.00").format (hPrice * (dPayment/100));
        String s2 = new DecimalFormat ("#,###.00").format (cCost);
        String s3 = new DecimalFormat ("#,###.00").format (loanAmount);
        String s4 = new DecimalFormat ("#,###.00").format (monthlyPayment);
        String msg = "Cash needed is: $ " + s + "\nDown Payment is: $ " +  s1 + "\nClosing Costs are: $" + s2 + "\nLoan Amount is: " + s3 + "\nMonthly Payment is: $ " + s4 ;
        return msg;
    }
    
    public static String cashCalculateState(float hPrice, float dPayment, float intRate, float lTerm, String cCost){
        float actualCC = stateClosingCosts.get(cCost);
        float cash = (hPrice * (dPayment/100)) + actualCC;
        float loanAmount = hPrice - cash + actualCC;
        double monthlyPayment = MainHelper.monthlyPayment(loanAmount, intRate, lTerm, false);
        String s = new DecimalFormat ("#,###.00").format (cash);
        String s1 = new DecimalFormat ("#,###.00").format (hPrice * (dPayment/100));
        String s2 = new DecimalFormat ("#,###.00").format (actualCC);
        String s3 = new DecimalFormat ("#,###.00").format (loanAmount);
        String s4 = new DecimalFormat ("#,###.00").format (monthlyPayment);
        String msg = "Cash needed is: $ " + s + "\nDown Payment is: $ " +  s1 + "\nClosing Costs are: $" + s2 + "\nLoan Amount is: " + s3 + "\nMonthly Payment is: $ " + s4 ;
        return msg;
    }
    
    public static String cashCalculate(float hPrice, float dPayment, float intRate, float lTerm){
        float cash = hPrice * (dPayment/100);
        float loanAmount = hPrice - cash;
        double monthlyPayment = MainHelper.monthlyPayment(loanAmount, intRate, lTerm, false);
        String s = new DecimalFormat ("#,###.00").format (cash);
        String s1 = new DecimalFormat ("#,###.00").format (hPrice * (dPayment/100));
        String s3 = new DecimalFormat ("#,###.00").format (loanAmount);
        String s4 = new DecimalFormat ("#,###.00").format (monthlyPayment);
        String msg = "Cash needed is: $ " + s + "\nDown Payment is: $ " +  s1 + "\nLoan Amount is: " + s3 + "\nMonthly Payment is: $ " + s4 ;
        return msg;
    }
    
    public static String downPaymentCalculateEntry(float hPrice, float uCash, float intRate, float lTerm, float cCost){
        float down = ((uCash-cCost)/hPrice) * 100;
        float loanAmount = hPrice - uCash + cCost;
        double monthlyPayment = MainHelper.monthlyPayment(loanAmount, intRate, lTerm, false);
        String s = new DecimalFormat ("#,###.00").format (down);
        String s1 = new DecimalFormat ("#,###.00").format (hPrice * (down/100));
        String s2 = new DecimalFormat ("#,###.00").format (cCost);
        String s3 = new DecimalFormat ("#,###.00").format (loanAmount);
        String s4 = new DecimalFormat ("#,###.00").format (monthlyPayment);
        String msg = "Down Payment Percentage: " + s + "%\nDown Payment is: $" + s1 +"\nClosing Costs are: $" + s2 + "\nLoan Amount is: " + s3 + "\nMonthly Payment is: $ " + s4 ;
        return msg;
    }
    
    public static String downPaymentCalculateState(float hPrice, float uCash, float intRate, float lTerm, String cCost){
        float actualCC = stateClosingCosts.get(cCost);
        float down = ((uCash-actualCC)/hPrice) * 100;
        float loanAmount = hPrice - uCash + actualCC;
        double monthlyPayment = MainHelper.monthlyPayment(loanAmount, intRate, lTerm, false);
        String s = new DecimalFormat ("#,###.00").format (down);
        String s1 = new DecimalFormat ("#,###.00").format (hPrice * (down/100));
        String s2 = new DecimalFormat ("#,###.00").format (actualCC);
        String s3 = new DecimalFormat ("#,###.00").format (loanAmount);
        String s4 = new DecimalFormat ("#,###.00").format (monthlyPayment);
        String msg = "Down Payment Percentage: " + s + "%\nDown Payment is: $" + s1 +"\nClosing Costs are: $" + s2 + "\nLoan Amount is: " + s3 + "\nMonthly Payment is: $ " + s4 ;
        return msg;
    }
    
    public static String downPaymentCalculate(float hPrice, float uCash, float intRate, float lTerm){
        float down = (uCash/hPrice) * 100;
        float loanAmount = hPrice - uCash;
        double monthlyPayment = MainHelper.monthlyPayment(loanAmount, intRate, lTerm, false);
        String s = new DecimalFormat ("#,###.00").format (down);
        String s1 = new DecimalFormat ("#,###.00").format (hPrice * (down/100));
        String s3 = new DecimalFormat ("#,###.00").format (loanAmount);
        String s4 = new DecimalFormat ("#,###.00").format (monthlyPayment);
        String msg = "Down Payment Percentage: " + s + "%\nDown Payment is: $" + s1 + "\nLoan Amount is: " + s3 + "\nMonthly Payment is: $ " + s4 ;
        return msg;
    }
    
    public static Dictionary<String, Integer> createVals(){
        Dictionary <String, Integer> stateClosingCosts = new Hashtable<>();
        String [] names = {"Alabama", "Alaska", "Arizona","Arkansas", "California", "Colorado", "Connecticut", "Delaware", "Florida", "Georgia" , "Hawaii", "Idaho", "Illinios", "Indiana", "Iowa", "Kansas", "Kentucky", "Lousiana", "Maine", "Maryland", "Massachusetts", "Michigan", "Minnesota", "Mississippi", "Missouri", "Montana", "Nebraska", "Nevada", "New Hampshire", "New Jersey", "New Mexico", "New York", "North Carolina", "North Dakota", "Ohio", "Oklahoma", "Oregon", "Pennsylvania", "Rhode Island", "South Carolina", "South Dakota", "Tennessee", "Texas", "Utah", "Vermont", "Virginia", "Washington", "Washington, DC", "West Virginia", "Wisconsin", "Wyoming"};
        int [] costs = {2986, 3581, 4701, 3115, 7953, 3881, 8821, 17859, 8554, 3762, 7463, 4082, 5929, 2200, 3146, 2793, 2802, 3711, 4420, 14721, 7964, 5714, 4011, 2756, 2061, 3337, 2781, 6383, 8183, 7915, 3513, 16849, 3406, 2501, 4223, 2893, 4327, 10634, 5568, 3447, 3105, 3911, 4548, 4837, 7906, 6346, 13927, 29888, 3406, 3459, 2589};
        for (int i = 0; i < 51; i++){
            stateClosingCosts.put(names[i], costs[i]);
        }
        return stateClosingCosts;
    }
    

}
