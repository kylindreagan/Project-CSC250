/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package main;
import javax.swing.*;
import java.awt.*;
import java.util.Map;
import java.util.List;

/**
 *
 * @author gustavo
 */
public class HouseAffordabilityHelper {
    
    public static boolean validateAndHighlightFields(Map<JTextField, String> fieldsToValidate) {
        boolean allFieldsValid = true;
        
        for (Map.Entry<JTextField, String> entry : fieldsToValidate.entrySet()) {
            JTextField field = entry.getKey();
            String errorMessage = entry.getValue();
            String input = field.getText().trim().replace(",", "");
            
            if (!isValidNumber(input) || Double.parseDouble(input) < 0) {
                field.setBackground(Color.RED);
                JOptionPane.showMessageDialog(null, errorMessage);
                field.setBackground(Color.WHITE);
                allFieldsValid = false;
                break;
            } else {
                field.setBackground(Color.WHITE); // Reset background if valid
                
            }
        }
        
        return allFieldsValid;
    }
    
    // Example of the isValidNumber method
    public static boolean isValidNumber(String input) {
        try {
            Double.parseDouble(input);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
    public static void clearTextFields(List<JTextField> fields) {
        for (JTextField field : fields) {
            field.setText("");
        }
    }
    
    public static double bestDTI(double income, double monthlyDebt, double frontEnd, double backEnd){
        double DTI;
        double DTI2;
        DTI = (income*frontEnd)/12;
        DTI2 = ((income*backEnd)/12) - monthlyDebt;
        if (DTI < DTI2){
            return DTI;
        }
        else if (DTI > DTI2){
            return DTI2;
        }
        else{
            return DTI;
        }
    }
    
    
    public static double cashDebts(double propertyTax,double hoaFee, double insurance){
        double total;
        propertyTax = propertyTax/12.0;
        hoaFee = hoaFee/12.0;
        insurance = insurance/12.0;
        total = propertyTax + hoaFee + insurance;
        return total;
    }
    
    public static double interestFormula(double interestRate, double loanTerm){
        double monthlyInterest = ((interestRate)/100.0)/12;
        double loanMonths = loanTerm * 12;
        double intForNum = monthlyInterest * Math.pow(1 + monthlyInterest, loanMonths);
        double intForDenom = Math.pow(1+monthlyInterest,loanMonths)-1;
        double interest = intForNum/intForDenom;
        return interest;
        
    }
    
    public static double percentageDebts(double perPropTax, double perHoa, double perInsurance, double perDownPayment){
        double debts = perPropTax + perHoa+ perInsurance;
        double Home = 12 * (1-perDownPayment);
        double percDebts = debts/Home;
        double PMI = 0.005/12;
        
        if (perDownPayment >= .20){
            return percDebts;
        }
        else{
           percDebts += PMI ;
           return percDebts;
        }
        
    }
    
    public static double principleLoan(boolean isDownPaymentCash, boolean isPropTaxCash, boolean isHoaCash, boolean isInsCash, double income, double frontEnd, double backEnd, double loanTerm, double interestRate, double monthlyDebt, double downPayment, double propertyTax, double hoaFee, double insurance, double perDownPayment, double perPropTax, double perHoa, double perInsurance, double loan){
        double numerator;
        double DTI;
        double cashDebts;
        double interest;
        double percDebts;
        double denominator;
       
        DTI = bestDTI(income,monthlyDebt,frontEnd,backEnd);
        cashDebts = cashDebts(propertyTax, hoaFee, insurance);
        
        interest = interestFormula(interestRate, loanTerm);
        percDebts = percentageDebts(perPropTax,perHoa,perInsurance,perDownPayment); 
        
        numerator = DTI - cashDebts;
        denominator = interest + percDebts;
        
        loan = numerator/denominator;
        
        return loan;
            
    }
    

}
