/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package main;

import java.awt.Color;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

/**
 *
 * @author giann
 */
public class AutoLoanCalculator extends javax.swing.JFrame {

    /**
     * Creates new form AutoLoanCalculator
     */
    public AutoLoanCalculator() {
        initComponents();
        carPriceRadio.setSelected(true);
        autoPriceLabel.setVisible(false);
        autoPriceEntryField.setVisible(false);        
        //Code from Kylind -- Used in Retirement Calculator
        DocumentListener documentListener = new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) { checkFields(); }
            @Override
            public void removeUpdate(DocumentEvent e) { checkFields(); }
            @Override
            public void changedUpdate(DocumentEvent e) { checkFields(); }
                private void checkFields() {
                    String AP = autoPriceEntryField.getText();
                    String MP = monthlyPaymentsEntryField.getText();
                    String CI = cashIncentivesEntryField.getText();
                    String DP = downPaymentEntryField.getText();
                    String TV = tradeEntryField.getText();
                    String AO = amtOwedEntryField.getText();
                    String OF = feesEntryField.getText();
                    boolean validAP = MainHelper.validate_money(AP, false);
                    boolean validMP = MainHelper.validate_money(MP, false);
                    boolean validCI = MainHelper.validate_money(CI, false);
                    boolean validDP = MainHelper.validate_money(DP, false);
                    boolean validTV = MainHelper.validate_money(TV, false);
                    boolean validAO = MainHelper.validate_money(AO, false);
                    boolean validOF = MainHelper.validate_money(OF, false);
                    String message = "";
                    if (!validAP){
                        message = "⚠ Invalid Auto Price";
                        autoPriceEntryField.setForeground(Color.red); 
                        errorLabel.setVisible(true);
                        errorLabel.setText(message); 
                        calculateButton.setEnabled(false);
                    }   else {
                        autoPriceEntryField.setForeground(Color.black);
                    }
                    
                    if (!validMP){
                        message = "⚠ Invalid Monthly Payment";
                        monthlyPaymentsEntryField.setForeground(Color.red); 
                        errorLabel.setVisible(true);
                        errorLabel.setText(message); 
                        calculateButton.setEnabled(false);
                    }   else {
                        monthlyPaymentsEntryField.setForeground(Color.black);
                    }
                    if (!validCI){
                        message = "⚠ Invalid Cash Incentives";
                        cashIncentivesEntryField.setForeground(Color.red); 
                        errorLabel.setVisible(true);
                        errorLabel.setText(message); 
                        calculateButton.setEnabled(false);
                    }   else {
                        cashIncentivesEntryField.setForeground(Color.black);
                    }
                    if (!validDP){
                        message = "⚠ Invalid Down Payment";
                        downPaymentEntryField.setForeground(Color.red); 
                        errorLabel.setVisible(true);
                        errorLabel.setText(message); 
                        calculateButton.setEnabled(false);
                    }   else {
                        downPaymentEntryField.setForeground(Color.black);
                    }
                    if (!validTV){
                        message = "⚠ Invalid Trade-in Value";
                        tradeEntryField.setForeground(Color.red); 
                        errorLabel.setVisible(true);
                        errorLabel.setText(message); 
                        calculateButton.setEnabled(false);
                    }   else {
                        tradeEntryField.setForeground(Color.black);
                    }
                    if (!validAO){
                        message = "⚠ Invalid Amount Owed";
                        amtOwedEntryField.setForeground(Color.red); 
                        errorLabel.setVisible(true);
                        errorLabel.setText(message); 
                        calculateButton.setEnabled(false);
                    }   else {
                        amtOwedEntryField.setForeground(Color.black);
                    }
                    if (!validOF){
                        message = "⚠ Invalid Additional Fees";
                        feesEntryField.setForeground(Color.red); 
                        errorLabel.setVisible(true);
                        errorLabel.setText(message); 
                        calculateButton.setEnabled(false);
                    }   else {
                        feesEntryField.setForeground(Color.black);
                    }
                    boolean ST = !MainHelper.isValidNumber(salesTaxEntryField.getText());
                    boolean LT = !MainHelper.isValidNumber(loanTermEntryField.getText());
                    boolean IR = !MainHelper.isValidNumber(interestRateEntryField.getText()) || isZero(interestRateEntryField.getText());
                    if ( ST || LT || IR) {
                    calculateButton.setEnabled(false);
                    if (LT) {
                        loanTermEntryField.setForeground(Color.red);
                        errorLabel.setVisible(true);
                        errorLabel.setText("⚠ Invalid Loan Term.");
                    }
                    else {
                        loanTermEntryField.setForeground(Color.black);
                    }
                    if (IR) {
                        interestRateEntryField.setForeground(Color.red);
                        errorLabel.setVisible(true);
                        errorLabel.setText("⚠ Invalid Interest Rate.");
                    }
                    else {
                        interestRateEntryField.setForeground(Color.black);
                    }
                    if (ST) {
                        salesTaxEntryField.setForeground(Color.red);
                        errorLabel.setVisible(true);
                        errorLabel.setText("⚠ Invalid Sales Tax.");
                    }
                    else {
                        salesTaxEntryField.setForeground(Color.black);
                    }
                }
                else if (validAP && validMP && validCI && validDP && validDP && validTV && validAO && validOF){
                    autoPriceEntryField.setForeground(Color.black);
                    monthlyPaymentsEntryField.setForeground(Color.black);
                    cashIncentivesEntryField.setForeground(Color.black);
                    downPaymentEntryField.setForeground(Color.black);
                    tradeEntryField.setForeground(Color.black);
                    amtOwedEntryField.setForeground(Color.black);
                    feesEntryField.setForeground(Color.black);
                    salesTaxEntryField.setForeground(Color.black);
                    interestRateEntryField.setForeground(Color.black);
                    loanTermEntryField.setForeground(Color.black);
                    errorLabel.setText("Error: None");
                    calculateButton.setEnabled(true);
                }
                }
            };
                
            autoPriceEntryField.getDocument().addDocumentListener(documentListener);
            amtOwedEntryField.getDocument().addDocumentListener(documentListener);
            cashIncentivesEntryField.getDocument().addDocumentListener(documentListener);
            monthlyPaymentsEntryField.getDocument().addDocumentListener(documentListener);
            salesTaxEntryField.getDocument().addDocumentListener(documentListener);
            tradeEntryField.getDocument().addDocumentListener(documentListener);
            feesEntryField.getDocument().addDocumentListener(documentListener);
            downPaymentEntryField.getDocument().addDocumentListener(documentListener);
            loanTermEntryField.getDocument().addDocumentListener(documentListener);
            interestRateEntryField.getDocument().addDocumentListener(documentListener);
    }
    
     public static boolean isZero(String s){
        if (s.equals("")){
            return false;
        }
        float str = Float.parseFloat(s);
        if (str == 0){
            return true;
        }
        return false;
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
        returnButton = new javax.swing.JButton();
        titleLabel = new javax.swing.JLabel();
        autoPriceLabel = new javax.swing.JLabel();
        autoPriceEntryField = new javax.swing.JFormattedTextField();
        loanTermLabel = new javax.swing.JLabel();
        interestRateLabel = new javax.swing.JLabel();
        cashIncentivesLabel = new javax.swing.JLabel();
        downPaymentLabel = new javax.swing.JLabel();
        tradeLabel = new javax.swing.JLabel();
        amtOwedLabel = new javax.swing.JLabel();
        salesTaxLabel = new javax.swing.JLabel();
        feesLabel = new javax.swing.JLabel();
        feesEntryField = new javax.swing.JFormattedTextField();
        loanTermEntryField = new javax.swing.JTextField();
        interestRateEntryField = new javax.swing.JTextField();
        cashIncentivesEntryField = new javax.swing.JFormattedTextField();
        downPaymentEntryField = new javax.swing.JFormattedTextField();
        tradeEntryField = new javax.swing.JFormattedTextField();
        amtOwedEntryField = new javax.swing.JFormattedTextField();
        salesTaxEntryField = new javax.swing.JTextField();
        calculateButton = new javax.swing.JButton();
        clearButton = new javax.swing.JButton();
        resetButton = new javax.swing.JButton();
        carPriceRadio = new javax.swing.JRadioButton();
        monthlyPaymentsRadio = new javax.swing.JRadioButton();
        monthsLabel = new javax.swing.JLabel();
        percentLabel1 = new javax.swing.JLabel();
        percentLabel2 = new javax.swing.JLabel();
        monthlyPaymentsLabel = new javax.swing.JLabel();
        monthlyPaymentsEntryField = new javax.swing.JFormattedTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        resultsBox = new javax.swing.JTextArea();
        resultsLabel = new javax.swing.JLabel();
        otherFeesCheckBox = new javax.swing.JCheckBox();
        errorLabel = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        returnButton.setText("Return");
        returnButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                returnButtonActionPerformed(evt);
            }
        });

        titleLabel.setFont(new java.awt.Font("Lucida Fax", 0, 24)); // NOI18N
        titleLabel.setText("Auto Loan Calculator");

        autoPriceLabel.setText("Auto Price  $");

        autoPriceEntryField.setText("50,000");

        loanTermLabel.setText("Loan Term");

        interestRateLabel.setText("Interest Rate");

        cashIncentivesLabel.setText("Cash Incentives $");

        downPaymentLabel.setText("Down Payment $");

        tradeLabel.setText("Trade-in value  $");

        amtOwedLabel.setText("Amount owed on trade in  $");

        salesTaxLabel.setText("Sales Tax");

        feesLabel.setText("Title, Registration, and Other Fees  $");

        feesEntryField.setText("2,700");

        loanTermEntryField.setText("60");

        interestRateEntryField.setText("5");

        cashIncentivesEntryField.setText("0.00");

        downPaymentEntryField.setText("10,000");

        tradeEntryField.setText("0.00");

        amtOwedEntryField.setText("0.00");

        salesTaxEntryField.setText("7");

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

        buttonGroup1.add(carPriceRadio);
        carPriceRadio.setText("Calculate Total Car Price");
        carPriceRadio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                carPriceRadioActionPerformed(evt);
            }
        });

        buttonGroup1.add(monthlyPaymentsRadio);
        monthlyPaymentsRadio.setText("Calculate Monthly Payments");
        monthlyPaymentsRadio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                monthlyPaymentsRadioActionPerformed(evt);
            }
        });

        monthsLabel.setText("Months");

        percentLabel1.setText("%");

        percentLabel2.setText("%");

        monthlyPaymentsLabel.setText("Monthly Payments  $");

        monthlyPaymentsEntryField.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter()));
        monthlyPaymentsEntryField.setText("750");

        resultsBox.setEditable(false);
        resultsBox.setColumns(20);
        resultsBox.setRows(5);
        jScrollPane1.setViewportView(resultsBox);

        resultsLabel.setText("Results");

        otherFeesCheckBox.setText("Include Other Fees Into Loan");

        errorLabel.setForeground(new java.awt.Color(255, 51, 51));
        errorLabel.setText("Error: None");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(calculateButton)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(clearButton)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(resetButton))
                        .addComponent(titleLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 272, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(carPriceRadio)
                        .addGap(18, 18, 18)
                        .addComponent(monthlyPaymentsRadio, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(256, 256, 256))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(returnButton)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(4, 4, 4)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(loanTermLabel)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(loanTermEntryField, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(monthsLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(interestRateLabel)
                                    .addComponent(autoPriceLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(autoPriceEntryField, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(interestRateEntryField, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(percentLabel1))))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(monthlyPaymentsLabel)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(monthlyPaymentsEntryField, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(cashIncentivesLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cashIncentivesEntryField, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(tradeLabel, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(downPaymentLabel, javax.swing.GroupLayout.Alignment.LEADING))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(downPaymentEntryField, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(tradeEntryField, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(amtOwedLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(amtOwedEntryField, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(salesTaxLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(salesTaxEntryField, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(percentLabel2))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(feesLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(feesEntryField, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(otherFeesCheckBox))
                .addGap(150, 150, 150)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 342, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(resultsLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(errorLabel))
                .addContainerGap(95, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(returnButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(titleLabel)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(carPriceRadio)
                    .addComponent(monthlyPaymentsRadio))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(monthlyPaymentsLabel)
                    .addComponent(monthlyPaymentsEntryField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(errorLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(autoPriceLabel)
                    .addComponent(autoPriceEntryField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(loanTermEntryField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(loanTermLabel)
                    .addComponent(monthsLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(interestRateLabel)
                    .addComponent(interestRateEntryField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(percentLabel1)
                    .addComponent(resultsLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cashIncentivesLabel)
                            .addComponent(cashIncentivesEntryField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(downPaymentLabel)
                            .addComponent(downPaymentEntryField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(tradeLabel)
                            .addComponent(tradeEntryField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(amtOwedLabel)
                            .addComponent(amtOwedEntryField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(salesTaxLabel)
                            .addComponent(salesTaxEntryField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(percentLabel2))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(feesLabel)
                            .addComponent(feesEntryField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(otherFeesCheckBox))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 261, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 50, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(calculateButton)
                    .addComponent(clearButton)
                    .addComponent(resetButton))
                .addGap(22, 22, 22))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void returnButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_returnButtonActionPerformed
        this.dispose();
    }//GEN-LAST:event_returnButtonActionPerformed

    private void carPriceRadioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_carPriceRadioActionPerformed
        monthlyPaymentsLabel.setVisible(true);
        monthlyPaymentsEntryField.setVisible(true);
        autoPriceLabel.setVisible(false);
        autoPriceEntryField.setVisible(false);
    }//GEN-LAST:event_carPriceRadioActionPerformed

    private void monthlyPaymentsRadioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_monthlyPaymentsRadioActionPerformed
        monthlyPaymentsLabel.setVisible(false);
        monthlyPaymentsEntryField.setVisible(false);
        autoPriceLabel.setVisible(true);
        autoPriceEntryField.setVisible(true);
    }//GEN-LAST:event_monthlyPaymentsRadioActionPerformed

    private void clearButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clearButtonActionPerformed
        monthlyPaymentsEntryField.setText("");
        amtOwedEntryField.setText("");
        autoPriceEntryField.setText("");
        cashIncentivesEntryField.setText("");
        downPaymentEntryField.setText("");
        interestRateEntryField.setText("");
        salesTaxEntryField.setText("");
        feesEntryField.setText("");
        loanTermEntryField.setText("");
        tradeEntryField.setText("");
        resultsBox.setText(" ");
    }//GEN-LAST:event_clearButtonActionPerformed

    private void resetButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_resetButtonActionPerformed
        monthlyPaymentsEntryField.setText("750");
        amtOwedEntryField.setText("0.00");
        autoPriceEntryField.setText("50,000");
        cashIncentivesEntryField.setText("0.00");
        downPaymentEntryField.setText("10,000");
        interestRateEntryField.setText("5");
        salesTaxEntryField.setText("7");
        feesEntryField.setText("2,700");
        loanTermEntryField.setText("60");
        tradeEntryField.setText("0.00");        
    }//GEN-LAST:event_resetButtonActionPerformed

    private void calculateButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_calculateButtonActionPerformed
        float lterm = Float.parseFloat(loanTermEntryField.getText());
        float intRate = Float.parseFloat(interestRateEntryField.getText());
        float sTax = Float.parseFloat(salesTaxEntryField.getText());
        float cIncent = MainHelper.parseMoney(cashIncentivesEntryField.getText(), ",");
        float dPay = MainHelper.parseMoney(downPaymentEntryField.getText(), ",");
        float trade = MainHelper.parseMoney(tradeEntryField.getText(), ",");
        float amtOwed = MainHelper.parseMoney(amtOwedEntryField.getText(), ",");
        float fees = MainHelper.parseMoney(feesEntryField.getText(), ",");
        String message = "";
        if (carPriceRadio.isSelected() && otherFeesCheckBox.isSelected()){
            float monthly = MainHelper.parseMoney(monthlyPaymentsEntryField.getText(), ",");
            message = AutoLoanHelper.carPriceCalculateFees(lterm, intRate, sTax, cIncent, dPay, trade, amtOwed, fees, monthly);
            
        } else if (carPriceRadio.isSelected() && !otherFeesCheckBox.isSelected()) {
            float monthly = MainHelper.parseMoney(monthlyPaymentsEntryField.getText(), ",");
            message = AutoLoanHelper.carPriceCalculate(lterm, intRate, sTax, cIncent, dPay, trade, amtOwed, fees, monthly);         
        } else if (monthlyPaymentsRadio.isSelected() && otherFeesCheckBox.isSelected()) {
            float car = MainHelper.parseMoney(autoPriceEntryField.getText(), ",");
            message = AutoLoanHelper.monthlyPaymentCalculateFees(lterm, intRate, sTax, cIncent, dPay, trade, amtOwed, fees, car);
        } else{
            float car = MainHelper.parseMoney(autoPriceEntryField.getText(), ",");
            message = AutoLoanHelper.monthlyPaymentCalculate(lterm, intRate, sTax, cIncent, dPay, trade, amtOwed, fees, car);
        }
        resultsBox.setText(message);
    }//GEN-LAST:event_calculateButtonActionPerformed

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
            java.util.logging.Logger.getLogger(AutoLoanCalculator.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AutoLoanCalculator.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AutoLoanCalculator.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AutoLoanCalculator.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AutoLoanCalculator().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JFormattedTextField amtOwedEntryField;
    private javax.swing.JLabel amtOwedLabel;
    private javax.swing.JFormattedTextField autoPriceEntryField;
    private javax.swing.JLabel autoPriceLabel;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JButton calculateButton;
    private javax.swing.JRadioButton carPriceRadio;
    private javax.swing.JFormattedTextField cashIncentivesEntryField;
    private javax.swing.JLabel cashIncentivesLabel;
    private javax.swing.JButton clearButton;
    private javax.swing.JFormattedTextField downPaymentEntryField;
    private javax.swing.JLabel downPaymentLabel;
    private javax.swing.JLabel errorLabel;
    private javax.swing.JFormattedTextField feesEntryField;
    private javax.swing.JLabel feesLabel;
    private javax.swing.JTextField interestRateEntryField;
    private javax.swing.JLabel interestRateLabel;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField loanTermEntryField;
    private javax.swing.JLabel loanTermLabel;
    private javax.swing.JFormattedTextField monthlyPaymentsEntryField;
    private javax.swing.JLabel monthlyPaymentsLabel;
    private javax.swing.JRadioButton monthlyPaymentsRadio;
    private javax.swing.JLabel monthsLabel;
    private javax.swing.JCheckBox otherFeesCheckBox;
    private javax.swing.JLabel percentLabel1;
    private javax.swing.JLabel percentLabel2;
    private javax.swing.JButton resetButton;
    private javax.swing.JTextArea resultsBox;
    private javax.swing.JLabel resultsLabel;
    private javax.swing.JButton returnButton;
    private javax.swing.JTextField salesTaxEntryField;
    private javax.swing.JLabel salesTaxLabel;
    private javax.swing.JLabel titleLabel;
    private javax.swing.JFormattedTextField tradeEntryField;
    private javax.swing.JLabel tradeLabel;
    // End of variables declaration//GEN-END:variables
}
