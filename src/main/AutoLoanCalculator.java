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
                        message = "Error: Invalid Auto Price";
                        autoPriceEntryField.setForeground(Color.red); 
                        errorLabel.setVisible(true);
                        errorLabel.setText(message); 
                        calculateButton.setEnabled(false);
                    }   else {
                        autoPriceEntryField.setForeground(Color.black);
                    }
                    
                    if (!validMP){
                        message = "Error: Invalid Monthly Payment";
                        monthlyPaymentsEntryField.setForeground(Color.red); 
                        errorLabel.setVisible(true);
                        errorLabel.setText(message); 
                        calculateButton.setEnabled(false);
                    }   else {
                        monthlyPaymentsEntryField.setForeground(Color.black);
                    }
                    if (!validCI){
                        message = "Error: Invalid Cash Incentives";
                        cashIncentivesEntryField.setForeground(Color.red); 
                        errorLabel.setVisible(true);
                        errorLabel.setText(message); 
                        calculateButton.setEnabled(false);
                    }   else {
                        cashIncentivesEntryField.setForeground(Color.black);
                    }
                    if (!validDP){
                        message = "Error: Invalid Down Payment";
                        downPaymentEntryField.setForeground(Color.red); 
                        errorLabel.setVisible(true);
                        errorLabel.setText(message); 
                        calculateButton.setEnabled(false);
                    }   else {
                        downPaymentEntryField.setForeground(Color.black);
                    }
                    if (!validTV){
                        message = "Error: Invalid Trade-in Value";
                        tradeEntryField.setForeground(Color.red); 
                        errorLabel.setVisible(true);
                        errorLabel.setText(message); 
                        calculateButton.setEnabled(false);
                    }   else {
                        tradeEntryField.setForeground(Color.black);
                    }
                    if (!validAO){
                        message = "Error: Invalid Amount Owed";
                        amtOwedEntryField.setForeground(Color.red); 
                        errorLabel.setVisible(true);
                        errorLabel.setText(message); 
                        calculateButton.setEnabled(false);
                    }   else {
                        amtOwedEntryField.setForeground(Color.black);
                    }
                    if (!validOF){
                        message = "Error: Invalid Additional Fees";
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
                        errorLabel.setText("Error: Invalid Loan Term.");
                    }
                    else {
                        loanTermEntryField.setForeground(Color.black);
                    }
                    if (IR) {
                        interestRateEntryField.setForeground(Color.red);
                        errorLabel.setVisible(true);
                        errorLabel.setText("Error: Invalid Interest Rate.");
                    }
                    else {
                        interestRateEntryField.setForeground(Color.black);
                    }
                    if (ST) {
                        salesTaxEntryField.setForeground(Color.red);
                        errorLabel.setVisible(true);
                        errorLabel.setText("Error: Invalid Sales Tax.");
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
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(1259, 701));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        returnButton.setFont(new java.awt.Font("Nunito", 0, 18)); // NOI18N
        returnButton.setForeground(new java.awt.Color(25, 55, 77));
        returnButton.setText("Return");
        returnButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                returnButtonActionPerformed(evt);
            }
        });
        getContentPane().add(returnButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(1140, 10, -1, -1));

        titleLabel.setFont(new java.awt.Font("Nunito", 1, 36)); // NOI18N
        titleLabel.setForeground(new java.awt.Color(238, 239, 239));
        titleLabel.setText("Auto Loan Calculator");
        getContentPane().add(titleLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 20, 490, -1));

        autoPriceLabel.setFont(new java.awt.Font("Nunito", 0, 18)); // NOI18N
        autoPriceLabel.setForeground(new java.awt.Color(25, 55, 77));
        autoPriceLabel.setText("Auto Price                                 $");
        getContentPane().add(autoPriceLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 210, 260, -1));

        autoPriceEntryField.setText("50,000");
        autoPriceEntryField.setFont(new java.awt.Font("Nunito", 0, 18)); // NOI18N
        getContentPane().add(autoPriceEntryField, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 210, 150, -1));

        loanTermLabel.setFont(new java.awt.Font("Nunito", 0, 18)); // NOI18N
        loanTermLabel.setForeground(new java.awt.Color(25, 55, 77));
        loanTermLabel.setText("Loan Term");
        getContentPane().add(loanTermLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 250, -1, -1));

        interestRateLabel.setFont(new java.awt.Font("Nunito", 0, 18)); // NOI18N
        interestRateLabel.setForeground(new java.awt.Color(25, 55, 77));
        interestRateLabel.setText("Interest Rate");
        getContentPane().add(interestRateLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 290, -1, -1));

        cashIncentivesLabel.setFont(new java.awt.Font("Nunito", 0, 18)); // NOI18N
        cashIncentivesLabel.setForeground(new java.awt.Color(25, 55, 77));
        cashIncentivesLabel.setText("Cash Incentives                                $");
        getContentPane().add(cashIncentivesLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 330, 300, -1));

        downPaymentLabel.setFont(new java.awt.Font("Nunito", 0, 18)); // NOI18N
        downPaymentLabel.setForeground(new java.awt.Color(25, 55, 77));
        downPaymentLabel.setText("Down Payment                                $");
        getContentPane().add(downPaymentLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 370, 300, -1));

        tradeLabel.setFont(new java.awt.Font("Nunito", 0, 18)); // NOI18N
        tradeLabel.setForeground(new java.awt.Color(25, 55, 77));
        tradeLabel.setText("Trade-in value                                  $");
        getContentPane().add(tradeLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 410, 300, -1));

        amtOwedLabel.setFont(new java.awt.Font("Nunito", 0, 18)); // NOI18N
        amtOwedLabel.setForeground(new java.awt.Color(25, 55, 77));
        amtOwedLabel.setText("Amount owed on trade in                $");
        getContentPane().add(amtOwedLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 450, 310, -1));

        salesTaxLabel.setFont(new java.awt.Font("Nunito", 0, 18)); // NOI18N
        salesTaxLabel.setForeground(new java.awt.Color(25, 55, 77));
        salesTaxLabel.setText("Sales Tax");
        getContentPane().add(salesTaxLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 490, 110, -1));

        feesLabel.setFont(new java.awt.Font("Nunito", 0, 18)); // NOI18N
        feesLabel.setForeground(new java.awt.Color(25, 55, 77));
        feesLabel.setText("Title, Registration, and Other Fees  $");
        getContentPane().add(feesLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 530, -1, -1));

        feesEntryField.setText("2,700");
        feesEntryField.setFont(new java.awt.Font("Nunito", 0, 18)); // NOI18N
        getContentPane().add(feesEntryField, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 530, 150, -1));

        loanTermEntryField.setFont(new java.awt.Font("Nunito", 0, 18)); // NOI18N
        loanTermEntryField.setText("60");
        getContentPane().add(loanTermEntryField, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 250, 150, -1));

        interestRateEntryField.setFont(new java.awt.Font("Nunito", 0, 18)); // NOI18N
        interestRateEntryField.setText("5");
        getContentPane().add(interestRateEntryField, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 290, 150, -1));

        cashIncentivesEntryField.setText("0.00");
        cashIncentivesEntryField.setFont(new java.awt.Font("Nunito", 0, 18)); // NOI18N
        getContentPane().add(cashIncentivesEntryField, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 330, 150, -1));

        downPaymentEntryField.setText("10,000");
        downPaymentEntryField.setFont(new java.awt.Font("Nunito", 0, 18)); // NOI18N
        getContentPane().add(downPaymentEntryField, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 370, 150, -1));

        tradeEntryField.setText("0.00");
        tradeEntryField.setFont(new java.awt.Font("Nunito", 0, 18)); // NOI18N
        getContentPane().add(tradeEntryField, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 410, 150, -1));

        amtOwedEntryField.setText("0.00");
        amtOwedEntryField.setFont(new java.awt.Font("Nunito", 0, 18)); // NOI18N
        getContentPane().add(amtOwedEntryField, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 450, 150, -1));

        salesTaxEntryField.setFont(new java.awt.Font("Nunito", 0, 18)); // NOI18N
        salesTaxEntryField.setText("7");
        getContentPane().add(salesTaxEntryField, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 490, 150, -1));

        calculateButton.setFont(new java.awt.Font("Nunito", 0, 14)); // NOI18N
        calculateButton.setText("Calculate");
        calculateButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                calculateButtonActionPerformed(evt);
            }
        });
        getContentPane().add(calculateButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 600, -1, -1));

        clearButton.setFont(new java.awt.Font("Nunito", 0, 14)); // NOI18N
        clearButton.setText("Clear");
        clearButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clearButtonActionPerformed(evt);
            }
        });
        getContentPane().add(clearButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 600, -1, -1));

        resetButton.setFont(new java.awt.Font("Nunito", 0, 14)); // NOI18N
        resetButton.setText("Reset");
        resetButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                resetButtonActionPerformed(evt);
            }
        });
        getContentPane().add(resetButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 600, -1, -1));

        buttonGroup1.add(carPriceRadio);
        carPriceRadio.setFont(new java.awt.Font("Nunito", 1, 18)); // NOI18N
        carPriceRadio.setForeground(new java.awt.Color(150, 200, 206));
        carPriceRadio.setText("Calculate Total Car Price");
        carPriceRadio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                carPriceRadioActionPerformed(evt);
            }
        });
        getContentPane().add(carPriceRadio, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 70, -1, -1));

        buttonGroup1.add(monthlyPaymentsRadio);
        monthlyPaymentsRadio.setFont(new java.awt.Font("Nunito", 1, 18)); // NOI18N
        monthlyPaymentsRadio.setForeground(new java.awt.Color(150, 200, 206));
        monthlyPaymentsRadio.setText("Calculate Monthly Payments");
        monthlyPaymentsRadio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                monthlyPaymentsRadioActionPerformed(evt);
            }
        });
        getContentPane().add(monthlyPaymentsRadio, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 70, 370, -1));

        monthsLabel.setFont(new java.awt.Font("Nunito", 0, 18)); // NOI18N
        monthsLabel.setForeground(new java.awt.Color(25, 55, 77));
        monthsLabel.setText("Months");
        getContentPane().add(monthsLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 250, 70, -1));

        percentLabel1.setFont(new java.awt.Font("Nunito", 0, 18)); // NOI18N
        percentLabel1.setForeground(new java.awt.Color(25, 55, 77));
        percentLabel1.setText("%");
        getContentPane().add(percentLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 290, -1, -1));

        percentLabel2.setFont(new java.awt.Font("Nunito", 0, 18)); // NOI18N
        percentLabel2.setForeground(new java.awt.Color(25, 55, 77));
        percentLabel2.setText("%");
        getContentPane().add(percentLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 490, -1, -1));

        monthlyPaymentsLabel.setFont(new java.awt.Font("Nunito", 0, 18)); // NOI18N
        monthlyPaymentsLabel.setForeground(new java.awt.Color(25, 55, 77));
        monthlyPaymentsLabel.setText("Monthly Payments                  $");
        getContentPane().add(monthlyPaymentsLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 210, 270, 20));

        monthlyPaymentsEntryField.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter()));
        monthlyPaymentsEntryField.setText("750");
        monthlyPaymentsEntryField.setFont(new java.awt.Font("Nunito", 0, 18)); // NOI18N
        getContentPane().add(monthlyPaymentsEntryField, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 210, 150, -1));

        resultsBox.setEditable(false);
        resultsBox.setColumns(20);
        resultsBox.setFont(new java.awt.Font("Nunito", 0, 18)); // NOI18N
        resultsBox.setForeground(new java.awt.Color(25, 55, 77));
        resultsBox.setRows(5);
        jScrollPane1.setViewportView(resultsBox);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 200, 320, 400));

        resultsLabel.setFont(new java.awt.Font("Nunito", 1, 36)); // NOI18N
        resultsLabel.setForeground(new java.awt.Color(25, 55, 77));
        resultsLabel.setText("Results");
        getContentPane().add(resultsLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 140, 200, -1));

        otherFeesCheckBox.setFont(new java.awt.Font("Nunito", 0, 18)); // NOI18N
        otherFeesCheckBox.setForeground(new java.awt.Color(25, 55, 77));
        otherFeesCheckBox.setText("Include Other Fees Into Loan");
        getContentPane().add(otherFeesCheckBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 160, -1, -1));

        errorLabel.setFont(new java.awt.Font("Nunito", 0, 18)); // NOI18N
        errorLabel.setForeground(new java.awt.Color(255, 51, 51));
        errorLabel.setText("Error: None");
        getContentPane().add(errorLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 60, 440, -1));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/downPaymentBckgrd.png"))); // NOI18N
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1270, 700));

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
    private javax.swing.JLabel jLabel1;
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
