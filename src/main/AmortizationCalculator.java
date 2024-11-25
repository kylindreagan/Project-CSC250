/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package main;

import java.awt.Color;
import java.text.DecimalFormat;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

/**
 *
 * @author giann
 */
public class AmortizationCalculator extends javax.swing.JFrame {

    /**
     * Creates new form AmortizationCalculator
     */
    public AmortizationCalculator() {
        initComponents();
        monthlyPaymentField.setVisible(false);
        monthlyPaymentLabel.setVisible(false);//Code from Kylind -- Used in Retirement Calculator
        DocumentListener documentListener = new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) { checkFields(); }
            @Override
            public void removeUpdate(DocumentEvent e) { checkFields(); }
            @Override
            public void changedUpdate(DocumentEvent e) { checkFields(); }
                private void checkFields() {
                    String TA = totalAmtField.getText();
                    String MP = monthlyPaymentField.getText();                    
                    boolean validTA = MainHelper.validate_money(TA, false);
                    boolean validMP = MainHelper.validate_money(MP, false);                    
                    String message = "";
                    if (!validTA){
                        message = "Error: Invalid Auto Price";
                        totalAmtField.setForeground(Color.red); 
                        errorLabel.setVisible(true);
                        errorLabel.setText(message); 
                        calculateButton.setEnabled(false);
                    }   else {
                        totalAmtField.setForeground(Color.black);
                    }
                    
                    if (!validMP){
                        message = "Error: Invalid Monthly Payment";
                        monthlyPaymentField.setForeground(Color.red); 
                        errorLabel.setVisible(true);
                        errorLabel.setText(message); 
                        calculateButton.setEnabled(false);
                    }   else {
                        monthlyPaymentField.setForeground(Color.black);
                    }
                    
                    boolean Y = !MainHelper.isValidNumber(yearsField.getText());
                    boolean M = !MainHelper.isValidNumber(monthsField.getText());              
                    boolean IR = !MainHelper.isValidNumber(intRateField.getText()) || AutoLoanCalculator.isZero(intRateField.getText());
                    boolean combo = false;
                    if (!Y && !M){
                        combo = AutoLoanCalculator.isZero(yearsField.getText()) && AutoLoanCalculator.isZero(monthsField.getText());
                    }
                    
                    if ( Y || M || IR || combo) {
                    calculateButton.setEnabled(false);
                    if (combo){
                        monthsField.setForeground(Color.red);
                        yearsField.setForeground(Color.red);
                        errorLabel.setVisible(true);
                        errorLabel.setText("Error: Must have a positive number of months or years");                        
                    } else {
                        monthsField.setForeground(Color.black);
                        yearsField.setForeground(Color.black);
                    }
                    if (M) {
                        monthsField.setForeground(Color.red);
                        errorLabel.setVisible(true);
                        errorLabel.setText("Error: Invalid Number of Months.");
                    }
                    else {
                        monthsField.setForeground(Color.black);
                    }
                    if (Y) {
                        yearsField.setForeground(Color.red);
                        errorLabel.setVisible(true);
                        errorLabel.setText("Error: Invalid Number of Years.");
                    }
                    else {
                        yearsField.setForeground(Color.black);
                    }
                    if (IR) {
                        intRateField.setForeground(Color.red);
                        errorLabel.setVisible(true);
                        errorLabel.setText("Error: Invalid Interest Rate.");
                    }
                    else {
                        intRateField.setForeground(Color.black);
                    }
                    
                    
                }
                else if (validTA && validMP){
                    totalAmtField.setForeground(Color.black);
                    monthlyPaymentField.setForeground(Color.black);
                    intRateField.setForeground(Color.black);
                    yearsField.setForeground(Color.black);
                    monthsField.setForeground(Color.black);
                    errorLabel.setText("Error: None");
                    calculateButton.setEnabled(true);
                }
                }
            };
                
            totalAmtField.getDocument().addDocumentListener(documentListener);
            yearsField.getDocument().addDocumentListener(documentListener);
            monthsField.getDocument().addDocumentListener(documentListener);
            intRateField.getDocument().addDocumentListener(documentListener);
            monthlyPaymentField.getDocument().addDocumentListener(documentListener);
            
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jLabel1 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        totalAmtLabel = new javax.swing.JLabel();
        totalAmtField = new javax.swing.JFormattedTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        yearsField = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        monthsField = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        intRateField = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        resultsField = new javax.swing.JTextArea();
        jLabel8 = new javax.swing.JLabel();
        calculateButton = new javax.swing.JButton();
        clearButton = new javax.swing.JButton();
        resetButton = new javax.swing.JButton();
        loanButton = new javax.swing.JRadioButton();
        mpButton = new javax.swing.JRadioButton();
        monthlyPaymentLabel = new javax.swing.JLabel();
        monthlyPaymentField = new javax.swing.JFormattedTextField();
        errorLabel = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Nunito", 1, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(238, 239, 239));
        jLabel1.setText("Amortization Calculator");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 50, -1, -1));

        jButton1.setFont(new java.awt.Font("Nunito", 0, 18)); // NOI18N
        jButton1.setForeground(new java.awt.Color(27, 45, 74));
        jButton1.setText("Return");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(1140, 20, -1, -1));

        totalAmtLabel.setFont(new java.awt.Font("Nunito", 0, 18)); // NOI18N
        totalAmtLabel.setForeground(new java.awt.Color(27, 45, 74));
        totalAmtLabel.setText("Total Amount        $");
        getContentPane().add(totalAmtLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 330, -1, -1));

        totalAmtField.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter()));
        totalAmtField.setText("200,000");
        totalAmtField.setFont(new java.awt.Font("Nunito", 0, 18)); // NOI18N
        getContentPane().add(totalAmtField, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 330, 190, -1));

        jLabel3.setFont(new java.awt.Font("Nunito", 0, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(27, 45, 74));
        jLabel3.setText("Loan Term ");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 370, -1, -1));

        jLabel4.setFont(new java.awt.Font("Nunito", 0, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(27, 45, 74));
        jLabel4.setText("Interest Rate ");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 410, -1, -1));

        yearsField.setFont(new java.awt.Font("Nunito", 0, 18)); // NOI18N
        yearsField.setText("15");
        getContentPane().add(yearsField, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 370, 100, -1));

        jLabel5.setFont(new java.awt.Font("Nunito", 0, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(27, 45, 74));
        jLabel5.setText("Years");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 370, 70, -1));

        monthsField.setFont(new java.awt.Font("Nunito", 0, 18)); // NOI18N
        monthsField.setText("0");
        getContentPane().add(monthsField, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 370, 90, -1));

        jLabel6.setFont(new java.awt.Font("Nunito", 0, 18)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(27, 45, 74));
        jLabel6.setText("Months ");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 370, -1, -1));

        intRateField.setFont(new java.awt.Font("Nunito", 0, 18)); // NOI18N
        intRateField.setText("6");
        getContentPane().add(intRateField, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 410, 190, -1));

        jLabel7.setFont(new java.awt.Font("Nunito", 0, 18)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(27, 45, 74));
        jLabel7.setText("%");
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 410, -1, -1));

        resultsField.setEditable(false);
        resultsField.setColumns(20);
        resultsField.setRows(5);
        jScrollPane1.setViewportView(resultsField);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 210, 320, 390));

        jLabel8.setFont(new java.awt.Font("Nunito", 1, 36)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(27, 45, 74));
        jLabel8.setText("Results ");
        getContentPane().add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 140, 240, -1));

        calculateButton.setFont(new java.awt.Font("Nunito", 0, 18)); // NOI18N
        calculateButton.setText("Calculate");
        calculateButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                calculateButtonActionPerformed(evt);
            }
        });
        getContentPane().add(calculateButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 550, -1, -1));

        clearButton.setFont(new java.awt.Font("Nunito", 0, 18)); // NOI18N
        clearButton.setText("Clear");
        clearButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clearButtonActionPerformed(evt);
            }
        });
        getContentPane().add(clearButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 550, -1, -1));

        resetButton.setFont(new java.awt.Font("Nunito", 0, 18)); // NOI18N
        resetButton.setText("Reset");
        resetButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                resetButtonActionPerformed(evt);
            }
        });
        getContentPane().add(resetButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 550, -1, -1));

        buttonGroup1.add(loanButton);
        loanButton.setFont(new java.awt.Font("Nunito", 0, 18)); // NOI18N
        loanButton.setForeground(new java.awt.Color(27, 45, 74));
        loanButton.setSelected(true);
        loanButton.setText("Amortized Interest from Total Loan");
        loanButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                loanButtonActionPerformed(evt);
            }
        });
        getContentPane().add(loanButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 170, -1, -1));

        buttonGroup1.add(mpButton);
        mpButton.setFont(new java.awt.Font("Nunito", 0, 18)); // NOI18N
        mpButton.setForeground(new java.awt.Color(27, 45, 74));
        mpButton.setText("Amortized Interest from Monthly Payment");
        mpButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mpButtonActionPerformed(evt);
            }
        });
        getContentPane().add(mpButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 230, -1, -1));

        monthlyPaymentLabel.setFont(new java.awt.Font("Nunito", 0, 18)); // NOI18N
        monthlyPaymentLabel.setForeground(new java.awt.Color(27, 45, 74));
        monthlyPaymentLabel.setText("Monthly Payment  $");
        getContentPane().add(monthlyPaymentLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 330, -1, -1));

        monthlyPaymentField.setText("750");
        monthlyPaymentField.setFont(new java.awt.Font("Nunito", 0, 18)); // NOI18N
        getContentPane().add(monthlyPaymentField, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 330, 190, -1));

        errorLabel.setFont(new java.awt.Font("Nunito", 0, 18)); // NOI18N
        errorLabel.setForeground(new java.awt.Color(255, 0, 0));
        errorLabel.setText("Error: None");
        getContentPane().add(errorLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 60, 450, -1));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/downPaymentBckgrd.png"))); // NOI18N
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, 700));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        this.dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void clearButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clearButtonActionPerformed
        totalAmtField.setText(" ");
        monthsField.setText(" ");
        yearsField.setText(" ");
        intRateField.setText(" ");        
        resultsField.setText(" ");
    }//GEN-LAST:event_clearButtonActionPerformed

    private void resetButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_resetButtonActionPerformed
        totalAmtField.setText("200,000");
        monthsField.setText("0");
        yearsField.setText("15");
        intRateField.setText("6");
    }//GEN-LAST:event_resetButtonActionPerformed

    private void calculateButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_calculateButtonActionPerformed
        float numPayments = (Float.parseFloat(yearsField.getText()) * 12) + Float.parseFloat(monthsField.getText());
        float interest = Float.parseFloat(intRateField.getText());
        if (loanButton.isSelected()){
            float principal = MainHelper.parseMoney(totalAmtField.getText(), ",");        
            Double monthlyPay = AmortizationHelper.amortizationInterest(principal, interest, numPayments);
            String s1 = new DecimalFormat ("#,###.00").format (monthlyPay);
            Double totalMPInterest = monthlyPay * numPayments; 
            String s2 = new DecimalFormat ("#,###.00").format (totalMPInterest);
            Double totalInterest = totalMPInterest - principal;
            String s3 = new DecimalFormat ("#,###.00").format (totalInterest);
            String message = "Monthly Pay: $" + s1 + "\nTotal of " + numPayments + " monthly payments: $" + s2 + "\nTotal Interest: $" + s3;
            resultsField.setText(message);
        } else{
            float mp = MainHelper.parseMoney(monthlyPaymentField.getText(), ",");
            Double principal = AmortizationHelper.principalFromMP(interest, numPayments, mp);
            String s1 = new DecimalFormat ("#,###.00").format (principal);
            float totalMPInterest = mp * numPayments; 
            String s2 = new DecimalFormat ("#,###.00").format (totalMPInterest);
            Double totalInterest = totalMPInterest - principal;
            String s3 = new DecimalFormat ("#,###.00").format (totalInterest);
            String message = "Principal: $" + s1 + "\nTotal of " + numPayments + " monthly payments: $" + s2 + "\nTotal Interest: $" + s3;
            resultsField.setText(message);
        }
        
    }//GEN-LAST:event_calculateButtonActionPerformed

    private void loanButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_loanButtonActionPerformed
        monthlyPaymentField.setVisible(false);
        monthlyPaymentLabel.setVisible(false);
        totalAmtLabel.setVisible(true);
        totalAmtField.setVisible(true);
    }//GEN-LAST:event_loanButtonActionPerformed

    private void mpButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mpButtonActionPerformed
        monthlyPaymentField.setVisible(true);
        monthlyPaymentLabel.setVisible(true);
        totalAmtLabel.setVisible(false);
        totalAmtField.setVisible(false);
    }//GEN-LAST:event_mpButtonActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(AmortizationCalculator.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AmortizationCalculator.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AmortizationCalculator.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AmortizationCalculator.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AmortizationCalculator().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JButton calculateButton;
    private javax.swing.JButton clearButton;
    private javax.swing.JLabel errorLabel;
    private javax.swing.JTextField intRateField;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JRadioButton loanButton;
    private javax.swing.JFormattedTextField monthlyPaymentField;
    private javax.swing.JLabel monthlyPaymentLabel;
    private javax.swing.JTextField monthsField;
    private javax.swing.JRadioButton mpButton;
    private javax.swing.JButton resetButton;
    private javax.swing.JTextArea resultsField;
    private javax.swing.JFormattedTextField totalAmtField;
    private javax.swing.JLabel totalAmtLabel;
    private javax.swing.JTextField yearsField;
    // End of variables declaration//GEN-END:variables
}
