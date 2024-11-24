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
                        message = "⚠ Invalid Auto Price";
                        totalAmtField.setForeground(Color.red); 
                        errorLabel.setVisible(true);
                        errorLabel.setText(message); 
                        calculateButton.setEnabled(false);
                    }   else {
                        totalAmtField.setForeground(Color.black);
                    }
                    
                    if (!validMP){
                        message = "⚠ Invalid Monthly Payment";
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
                    boolean combo = AutoLoanCalculator.isZero(yearsField.getText()) && AutoLoanCalculator.isZero(monthsField.getText());
                    if ( Y || M || IR || combo) {
                    calculateButton.setEnabled(false);
                    if (Y) {
                        yearsField.setForeground(Color.red);
                        errorLabel.setVisible(true);
                        errorLabel.setText("⚠ Invalid Number of Years.");
                    }
                    else {
                        yearsField.setForeground(Color.black);
                    }
                    if (IR) {
                        intRateField.setForeground(Color.red);
                        errorLabel.setVisible(true);
                        errorLabel.setText("⚠ Invalid Interest Rate.");
                    }
                    else {
                        intRateField.setForeground(Color.black);
                    }
                    if (M) {
                        monthsField.setForeground(Color.red);
                        errorLabel.setVisible(true);
                        errorLabel.setText("⚠ Invalid Number of Months.");
                    }
                    else {
                        monthsField.setForeground(Color.black);
                    }
                    if (combo){
                        monthsField.setForeground(Color.red);
                        yearsField.setForeground(Color.red);
                        errorLabel.setVisible(true);
                        errorLabel.setText("⚠ Must have a positive number of months or years");                        
                    } else {
                        monthsField.setForeground(Color.black);
                        yearsField.setForeground(Color.black);
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

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Lucida Fax", 0, 24)); // NOI18N
        jLabel1.setText("Amortization Calculator");

        jButton1.setText("Return");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        totalAmtLabel.setText("Total Amount  $");

        totalAmtField.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter()));
        totalAmtField.setText("200,000");

        jLabel3.setText("Loan Term ");

        jLabel4.setText("Interest Rate ");

        yearsField.setText("15");

        jLabel5.setText("Years");

        monthsField.setText("0");

        jLabel6.setText("Months ");

        intRateField.setText("6");

        jLabel7.setText("%");

        resultsField.setEditable(false);
        resultsField.setColumns(20);
        resultsField.setRows(5);
        jScrollPane1.setViewportView(resultsField);

        jLabel8.setText("Results ");

        calculateButton.setText("Calculate");
        calculateButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                calculateButtonActionPerformed(evt);
            }
        });

        clearButton.setText("Clear");
        clearButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clearButtonActionPerformed(evt);
            }
        });

        resetButton.setText("Reset");
        resetButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                resetButtonActionPerformed(evt);
            }
        });

        buttonGroup1.add(loanButton);
        loanButton.setSelected(true);
        loanButton.setText("Amortized Interest from Total Loan");
        loanButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                loanButtonActionPerformed(evt);
            }
        });

        buttonGroup1.add(mpButton);
        mpButton.setText("Amortized Interest from Monthly Payment");
        mpButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mpButtonActionPerformed(evt);
            }
        });

        monthlyPaymentLabel.setText("Monthly Payment  $");

        monthlyPaymentField.setText("750");

        errorLabel.setForeground(new java.awt.Color(255, 0, 0));
        errorLabel.setText("Error: None");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jButton1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(80, 80, 80)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(calculateButton)
                                    .addGap(18, 18, 18)
                                    .addComponent(clearButton)
                                    .addGap(18, 18, 18)
                                    .addComponent(resetButton)))
                            .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(262, 262, 262)
                                .addComponent(jLabel1))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(208, 208, 208)
                                .addComponent(loanButton)
                                .addGap(86, 86, 86)
                                .addComponent(mpButton))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(intRateField, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel7))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel3)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(yearsField, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(monthsField, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(totalAmtLabel)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(totalAmtField, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel6))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(monthlyPaymentLabel)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(monthlyPaymentField, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(errorLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 283, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(113, 113, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jButton1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addComponent(jLabel1)))
                .addGap(19, 19, 19)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(loanButton)
                    .addComponent(mpButton))
                .addGap(28, 28, 28)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(monthlyPaymentLabel)
                    .addComponent(monthlyPaymentField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(totalAmtLabel)
                    .addComponent(totalAmtField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(yearsField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5)
                    .addComponent(monthsField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(intRateField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7))
                .addGap(25, 25, 25)
                .addComponent(errorLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(calculateButton)
                    .addComponent(clearButton)
                    .addComponent(resetButton))
                .addContainerGap(84, Short.MAX_VALUE))
        );

        pack();
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
