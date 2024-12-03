/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package main;
import javax.swing.*;
import java.awt.*;
import java.util.Map;
import java.util.List;
import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JPanel;

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
    
    public static double interestByItself(double interestRate, double loanTerm){
        double interest;
        interest = (interestRate/100.0)/12;
        return interest;
        
    }
    
    public static double interestWithOne(double interestRate, double loanTerm){
        double interest = ((interestRate)/100.0);
        double interest2 = ((interest/12));
        double loanMonths = loanTerm*12;
        double oneInt = 1+interest2;
        double formula = Math.pow(oneInt,loanMonths);
        return formula;
        
    }
    
    public static double percentageDebts(double perPropTax, double perHoa, double perInsurance, double perDownPayment){
        double debts = perPropTax + perHoa+ perInsurance;
        double Home = 12 * (1.0-perDownPayment);
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
    public static double onlyPercentageDebts(double perPropTax, double perHoa, double perInsurance, double perDownPayment){
        double debts = (perPropTax + perHoa + perInsurance)/12.0;
        return debts;
    }
    public static double percentageDebtsVA(double perPropTax, double perHoa, double perInsurance, double perDownPayment,double VAloan){
        double debts = perPropTax + perHoa+ perInsurance;
        double percDebts = debts/12.0;
        double PMI = VAloan/12.0;
        double VA = percDebts + PMI;
        return VA;
        

    }
    
    public static double principleLoan(boolean isDownPaymentCash, boolean isPropTaxCash, boolean isHoaCash, boolean isInsCash, double income, double frontEnd, double backEnd, double loanTerm, double interestRate, double monthlyDebt, double downPayment, double propertyTax, double hoaFee, double insurance, double perDownPayment, double perPropTax, double perHoa, double perInsurance, double loan){
        double numerator;
        double DTI;
        double cashDebts;
        double interest;
        double percDebts;
        double denominator;
       
        if (isDownPaymentCash == false){
            DTI = bestDTI(income,monthlyDebt,frontEnd,backEnd);
            cashDebts = cashDebts(propertyTax, hoaFee, insurance);

            interest = interestFormula(interestRate, loanTerm);
            percDebts = percentageDebts(perPropTax,perHoa,perInsurance,perDownPayment); 

            numerator = DTI - cashDebts;
            denominator = interest + percDebts;

            loan = numerator/denominator;
        }
    return loan;

    }
    public static double CashprincipleLoan(boolean isDownPaymentCash, boolean isPropTaxCash, boolean isHoaCash, boolean isInsCash, double income, double frontEnd, double backEnd, double loanTerm, double interestRate, double monthlyDebt, double downPayment, double propertyTax, double hoaFee, double insurance, double perDownPayment, double perPropTax, double perHoa, double perInsurance, double loan){
        double numerator;
        double DTI;
        double cashDebts;
        double interest;
        double percDebts;
        double denominator;
        double finalDTI;
        double interestWithone;
        double pmi;
        
        DTI = bestDTI(income,monthlyDebt,frontEnd,backEnd);
        cashDebts = cashDebts(propertyTax, hoaFee, insurance);
        finalDTI = DTI - cashDebts;
        interest = interestByItself(interestRate,loanTerm);
        interestWithone = interestWithOne(interestRate,loanTerm);
        percDebts = onlyPercentageDebts(perPropTax, perHoa, perInsurance,downPayment);
        pmi = (0.005)/12;
        
        numerator = (finalDTI*interestWithone) - finalDTI - (downPayment*percDebts)*interestWithone + (downPayment*percDebts);
        denominator = (interest*interestWithone) + (percDebts*interestWithone) - percDebts + (pmi*interestWithone) - pmi;
        
        loan = numerator/denominator;
        return loan;
    }
    
    public static double principleLoanVA(boolean isDownPaymentCash, boolean isPropTaxCash, boolean isHoaCash, boolean isInsCash, double income, double frontEnd, double backEnd, double loanTerm, double interestRate, double monthlyDebt, double downPayment, double propertyTax, double hoaFee, double insurance, double perDownPayment, double perPropTax, double perHoa, double perInsurance, double loan,double VAloan){
        double numerator;
        double DTI;
        double cashDebts;
        double interest;
        double percDebts;
        double denominator;
       
        DTI = bestDTI(income,monthlyDebt,frontEnd,backEnd);
        cashDebts = cashDebts(propertyTax, hoaFee, insurance);

        interest = interestFormula(interestRate, loanTerm);
        percDebts = percentageDebtsVA(perPropTax,perHoa,perInsurance,perDownPayment,VAloan); 

        numerator = DTI - cashDebts;
        denominator = interest + percDebts;

        loan = numerator/denominator;
    return loan;
    }
    
    public static double TotalHousePrice(double loan, double percDebt, double debt, boolean isDownPaymentCash){
            double totalHouse;
            if (isDownPaymentCash == false){
                totalHouse = loan / (1-percDebt);
                return totalHouse;
            }
            else{
                totalHouse = loan + debt;
                return totalHouse;
            }
    }
    
    public static double totalDownPayment(double totalHouse, double percDebt, double debt, boolean isDownPaymentCash){
        double downPayment;
        if (isDownPaymentCash == false){
            downPayment = totalHouse * percDebt;
            return downPayment;
        }
        else{
            downPayment = debt;
            return downPayment;
        }
    }
    public static boolean checkDebt(double debt, double total){
        double percentageDebt = debt/total;
        if (percentageDebt < 0.208){
            return false;
        }
        else{
            return true; 
        }
    }
    
    public static double pmiTotal(double loan, boolean isDownPaymentCash,double percDebt){
        double PMITotal;
        if (isDownPaymentCash==false){
            if (percDebt < 0.20){
                PMITotal = (0.005 * loan)/12;
                return PMITotal;
            }
            else{
                return 0;
            }
        }
        else{
            PMITotal = (0.005 * loan)/12;
            return PMITotal;
        }
        
    }
    
    public static double ptTotal(double total , double perPropTax, double propertyTax, boolean isPropTaxCash){
        double PTPayment;
        if (isPropTaxCash == false){
            PTPayment = total * perPropTax;
            return PTPayment;
        }
        else{
            PTPayment = propertyTax;
            return PTPayment;
        }
    }
    public static double HOATotal(double total , double perHoa, double hoaFee, boolean isHoaCash){
        double hoaPayment;
        if (isHoaCash == false){
            hoaPayment = total * perHoa;
            return hoaPayment;
        }
        else{
            hoaPayment = hoaFee;
            return hoaPayment;
        }
        
    }
    public static double inTotal(double Total,double perInsurance,double insurance, boolean isInsCash){
        double insuranceTotal;
        if (isInsCash == false){
            insuranceTotal = Total * perInsurance;
            return insuranceTotal;
        }
        else{
            return insurance;
        }
        
    }
    public static double monthlyMortgage(double income, double monthlyDebt, double frontEnd, double backEnd, double pmi, double propertyTax, double Hoa, double insurance){
        double DTI = bestDTI(income,monthlyDebt,frontEnd,backEnd);
        
        double monthlyMortgage = (DTI) - (pmi) - (propertyTax/12) - (Hoa/12) - (insurance/12);
        return monthlyMortgage;
        
    }
    
    public static double totalMonthlyCost(double month, double pmi, double property, double hoa, double insurance, double maintenance){
        double totalmonth = month + pmi + (property/12) + (hoa/12) + (insurance/12) + (maintenance/12);
        return totalmonth;
    }
    public static double principleHouse(boolean isPropTaxCash, boolean isHoaCash, boolean isInsCash, boolean isMaintenanceCash, double budget, double loanTerm, double interestRate,double downPayment,double propertyTax, double hoaFee, double insurance, double maint, double perPropTax, double perHoa, double perInsurance,double perMaintenance, double loan){
        double numerator = budget - (propertyTax + hoaFee + insurance + maint);
        double interest;
        double percDebts;
        double denominator;
        interest = interestFormula(interestRate, loanTerm);
        percDebts = monthlypercDebts(perPropTax,perHoa,perInsurance,downPayment,perMaintenance);
        denominator = interest + percDebts;

        loan = numerator/denominator;
        return loan;
    }
    
        public static double monthlypercDebts(double perPropTax, double perHoa, double perInsurance, double perDownPayment,double perMaintenance){
        double debts = perPropTax + perHoa+ perInsurance + perMaintenance;
        double Home = 12 * (1.0-perDownPayment);
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
    
    

}
