/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */

package main;
import java.awt.Color;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
/**
 *
 * @author giann
 */
public class DownPaymentCalculator extends javax.swing.JFrame {

    /**
     * Creates new form DownPaymentCalculator
     */
    public DownPaymentCalculator() {
        initComponents();
        setInvisible();
        updateComboBox(closingCostsStateSelection);
        
        //Code from Kylind -- Used in Retirement Calculator
        //Continue working on error messages
        DocumentListener documentListener = new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) { checkFields(); }
            @Override
            public void removeUpdate(DocumentEvent e) { checkFields(); }
            @Override
            public void changedUpdate(DocumentEvent e) { checkFields(); }
            private void checkFields() {
                String HP = homePriceEntryField.getText();
                String CC = closingCostsEntryField.getText();
                String UC = upfrontCashEntryField.getText();
                Boolean validMoneyHP = MainHelper.validate_money(HP, false);
                Boolean validMoneyCC = MainHelper.validate_money(CC, false);
                Boolean validMoneyUC = MainHelper.validate_money(UC, false);
                if (!validMoneyHP || !validMoneyCC || !validMoneyUC){
                CalculateButton.setEnabled(false);
                String message = "";
                if (!validMoneyHP){
                    message = MainHelper.generate_USD_warning(HP);
                }
                if (!validMoneyCC){
                    message = MainHelper.generate_USD_warning(CC);
                }
                if (!validMoneyUC){
                    message = MainHelper.generate_USD_warning(UC);
                }
                errorLabel.setVisible(true);
                errorLabel.setText(message); 
                homePriceEntryField.setForeground(Color.red);
                closingCostsEntryField.setForeground(Color.red);
                upfrontCashEntryField.setForeground(Color.red);
                }
                else {
                    homePriceEntryField.setForeground(Color.black);
                    closingCostsEntryField.setForeground(Color.black);
                    upfrontCashEntryField.setForeground(Color.black); 
                }
                Boolean a = !MainHelper.isValidNumber(downPaymentEntryField.getText());
                Boolean b = !MainHelper.isValidNumber(interestRateEntryField.getText()); //Needs to be an Integer
                Boolean c = !MainHelper.isValidNumber(loanTermEntryField.getText());
                if ( a || b || c) {
                    CalculateButton.setEnabled(false);
                    if (c) {
                        loanTermEntryField.setForeground(Color.red);
                        errorLabel.setVisible(true);
                        errorLabel.setText("⚠ Invalid Loan Term.");
                    }
                    else {
                        loanTermEntryField.setForeground(Color.black);
                    }
                    if (b) {
                        interestRateEntryField.setForeground(Color.red);
                        errorLabel.setVisible(true);
                        errorLabel.setText("⚠ Invalid Interest Rate.");
                    }
                    else {
                        interestRateEntryField.setForeground(Color.black);
                    }
                    if (a) {
                        downPaymentEntryField.setForeground(Color.red);
                        errorLabel.setVisible(true);
                        errorLabel.setText("⚠ Invalid Down Payment Percentage.");
                    }
                    else {
                        downPaymentEntryField.setForeground(Color.black);
                    }
                }
                else {
                    downPaymentEntryField.setForeground(Color.black);
                    interestRateEntryField.setForeground(Color.black);
                    loanTermEntryField.setForeground(Color.black);
                    errorLabel.setVisible(false);
                    CalculateButton.setEnabled(true);
                }
              }
            };
            homePriceEntryField.getDocument().addDocumentListener(documentListener);
            closingCostsEntryField.getDocument().addDocumentListener(documentListener);
            upfrontCashEntryField.getDocument().addDocumentListener(documentListener);
            homePriceEntryField.getDocument().addDocumentListener(documentListener);
            downPaymentEntryField.getDocument().addDocumentListener(documentListener);
            loanTermEntryField.getDocument().addDocumentListener(documentListener);
    }

    
    
    
    //Hides/Clears all irrelevant fields
    public void setInvisible(){
        closingCostsCheckBox.setVisible(false);
        closingCostsCheckBox.setSelected(false); 
        closingCostsStateSelection.setVisible(false);
        yearsLabel.setVisible(false);
        interestRatePercentSign.setVisible(false);
        homePriceLabel.setVisible(false);
        upfrontCashLabel.setVisible(false);
        downPaymentLabel.setVisible(false);
        downPaymentPercentSign.setVisible(false);
        interestRateLabel.setVisible(false);
        loanTermLabel.setVisible(false);
        closingCostsDollarSign.setVisible(false);
        homePriceEntryField.setVisible(false);
        upfrontCashEntryField.setVisible(false);
        downPaymentEntryField.setVisible(false);
        closingCostsEntryField.setVisible(false);
        interestRateEntryField.setVisible(false);
        loanTermEntryField.setVisible(false);
        errorLabel.setVisible(false);
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
        jTextField1 = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        homePriceRadio = new javax.swing.JRadioButton();
        cashRadio = new javax.swing.JRadioButton();
        downPaymentRadio = new javax.swing.JRadioButton();
        jLabel2 = new javax.swing.JLabel();
        homePriceLabel = new javax.swing.JLabel();
        upfrontCashLabel = new javax.swing.JLabel();
        downPaymentLabel = new javax.swing.JLabel();
        downPaymentEntryField = new javax.swing.JTextField();
        downPaymentPercentSign = new javax.swing.JLabel();
        interestRateLabel = new javax.swing.JLabel();
        closingCostsCheckBox = new javax.swing.JCheckBox();
        loanTermLabel = new javax.swing.JLabel();
        CalculateButton = new javax.swing.JButton();
        clearButton = new javax.swing.JButton();
        closingCostsDollarSign = new javax.swing.JLabel();
        closingCostsStateSelection = new javax.swing.JComboBox<>();
        interestRateEntryField = new javax.swing.JTextField();
        interestRatePercentSign = new javax.swing.JLabel();
        loanTermEntryField = new javax.swing.JTextField();
        yearsLabel = new javax.swing.JLabel();
        returnButton = new javax.swing.JButton();
        resetButton = new javax.swing.JButton();
        homePriceEntryField = new javax.swing.JFormattedTextField();
        upfrontCashEntryField = new javax.swing.JFormattedTextField();
        closingCostsEntryField = new javax.swing.JFormattedTextField();
        errorLabel = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        resultsLabel = new javax.swing.JTextArea();

        jTextField1.setText("jTextField1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Lucida Fax", 0, 18)); // NOI18N
        jLabel1.setText("Down Payment Calculator");

        buttonGroup1.add(homePriceRadio);
        homePriceRadio.setText("Calculate Affordable Home Price");
        homePriceRadio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                homePriceRadioActionPerformed(evt);
            }
        });

        buttonGroup1.add(cashRadio);
        cashRadio.setText("Calculate Upfront Cash Needed");
        cashRadio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cashRadioActionPerformed(evt);
            }
        });

        buttonGroup1.add(downPaymentRadio);
        downPaymentRadio.setText("Calculate Down Payment %");
        downPaymentRadio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                downPaymentRadioActionPerformed(evt);
            }
        });

        jLabel2.setBackground(new java.awt.Color(255, 255, 255));
        jLabel2.setFont(new java.awt.Font("Lucida Fax", 0, 12)); // NOI18N
        jLabel2.setText("Select a calculator to start");
        jLabel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jLabel2.setOpaque(true);

        homePriceLabel.setText("Home Price    $");

        upfrontCashLabel.setText("Upfront Cash Available    $");

        downPaymentLabel.setText("Down Payment");

        downPaymentEntryField.setText("20");

        downPaymentPercentSign.setText("%");

        interestRateLabel.setText("Interest Rate");

        closingCostsCheckBox.setText("Include Closing Costs");
        closingCostsCheckBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                closingCostsCheckBoxActionPerformed(evt);
            }
        });

        loanTermLabel.setText("Loan Term");

        CalculateButton.setText("Calculate");
        CalculateButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CalculateButtonActionPerformed(evt);
            }
        });

        clearButton.setText("Clear");
        clearButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clearButtonActionPerformed(evt);
            }
        });

        closingCostsDollarSign.setText("$");

        closingCostsStateSelection.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        interestRateEntryField.setText("6.489");

        interestRatePercentSign.setText("%");

        loanTermEntryField.setText("30");

        yearsLabel.setText("Years");

        returnButton.setText("Return");
        returnButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                returnButtonActionPerformed(evt);
            }
        });

        resetButton.setText("Reset");
        resetButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                resetButtonActionPerformed(evt);
            }
        });

        homePriceEntryField.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter()));
        homePriceEntryField.setText("500,000");

        upfrontCashEntryField.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter()));
        upfrontCashEntryField.setText("100,000");

        closingCostsEntryField.setText("3,391");

        errorLabel.setForeground(new java.awt.Color(255, 0, 0));
        errorLabel.setText("Error: None");

        resultsLabel.setColumns(20);
        resultsLabel.setRows(5);
        jScrollPane1.setViewportView(resultsLabel);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jLabel2)
                        .addGap(264, 264, 264))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(returnButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 247, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(216, 216, 216))))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(44, 44, 44)
                        .addComponent(homePriceRadio)
                        .addGap(24, 24, 24)
                        .addComponent(cashRadio))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(94, 94, 94)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(upfrontCashLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(upfrontCashEntryField, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(downPaymentLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(downPaymentEntryField, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(downPaymentPercentSign, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(closingCostsCheckBox)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(closingCostsDollarSign, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(loanTermLabel, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(interestRateLabel, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(CalculateButton)
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(loanTermEntryField, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(yearsLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(clearButton)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(resetButton))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(interestRateEntryField, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(closingCostsEntryField, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(closingCostsStateSelection, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addComponent(interestRatePercentSign)))))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(homePriceLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(homePriceEntryField, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(downPaymentRadio, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(errorLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jScrollPane1))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(returnButton))
                .addGap(9, 9, 9)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(homePriceRadio)
                        .addComponent(downPaymentRadio))
                    .addComponent(cashRadio))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(homePriceLabel)
                            .addComponent(homePriceEntryField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(upfrontCashLabel)
                            .addComponent(upfrontCashEntryField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(downPaymentLabel)
                            .addComponent(downPaymentEntryField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(downPaymentPercentSign))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(closingCostsCheckBox)
                            .addComponent(closingCostsDollarSign)
                            .addComponent(closingCostsStateSelection, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(closingCostsEntryField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(interestRateLabel)
                            .addComponent(interestRateEntryField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(interestRatePercentSign))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(loanTermLabel)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(loanTermEntryField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(yearsLabel)))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 18, Short.MAX_VALUE)
                        .addComponent(errorLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(25, 25, 25)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(CalculateButton)
                            .addComponent(clearButton)
                            .addComponent(resetButton))))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    //Buttons are linked to a button group that only allows certain fields to be displayed at a time
    //This calculator does not use the initial home price
    private void homePriceRadioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_homePriceRadioActionPerformed
        setInvisible();
        upfrontCashLabel.setVisible(true);
        upfrontCashEntryField.setVisible(true);
        downPaymentLabel.setVisible(true);
        downPaymentEntryField.setVisible(true);
        downPaymentPercentSign.setVisible(true);
        closingCostsCheckBox.setVisible(true);
        interestRateLabel.setVisible(true);
        interestRatePercentSign.setVisible(true);
        interestRateEntryField.setVisible(true);
        loanTermLabel.setVisible(true);
        loanTermEntryField.setVisible(true);
        yearsLabel.setVisible(true);
    }//GEN-LAST:event_homePriceRadioActionPerformed
    //This calculator does not use the upfront cash
    private void cashRadioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cashRadioActionPerformed
        setInvisible();
        homePriceLabel.setVisible(true);
        homePriceEntryField.setVisible(true);
        downPaymentLabel.setVisible(true);
        downPaymentEntryField.setVisible(true);
        downPaymentPercentSign.setVisible(true);
        closingCostsCheckBox.setVisible(true);
        interestRateLabel.setVisible(true);
        interestRatePercentSign.setVisible(true);
        interestRateEntryField.setVisible(true);
        loanTermLabel.setVisible(true);
        loanTermEntryField.setVisible(true);
        yearsLabel.setVisible(true);
    }//GEN-LAST:event_cashRadioActionPerformed

    private void returnButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_returnButtonActionPerformed
      this.dispose();
    }//GEN-LAST:event_returnButtonActionPerformed
    //This function does not use the down payment
    private void downPaymentRadioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_downPaymentRadioActionPerformed
        setInvisible();
        homePriceLabel.setVisible(true);
        homePriceEntryField.setVisible(true);
        upfrontCashLabel.setVisible(true);
        upfrontCashEntryField.setVisible(true);
        closingCostsCheckBox.setVisible(true);
        interestRateLabel.setVisible(true);
        interestRatePercentSign.setVisible(true);
        interestRateEntryField.setVisible(true);
        loanTermLabel.setVisible(true);
        loanTermEntryField.setVisible(true);
        yearsLabel.setVisible(true);
    }//GEN-LAST:event_downPaymentRadioActionPerformed
    //Clears all fields for ease of use
    private void clearButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clearButtonActionPerformed
        closingCostsEntryField.setText("");
        downPaymentEntryField.setText("");
        homePriceEntryField.setText("");
        interestRateEntryField.setText("");
        loanTermEntryField.setText("");
        upfrontCashEntryField.setText("");
        resultsLabel.setText("");
        closingCostsCheckBox.setSelected(false);
        closingCostsStateSelection.setVisible(false);
        closingCostsEntryField.setVisible(false);
        closingCostsDollarSign.setVisible(false);
    }//GEN-LAST:event_clearButtonActionPerformed
    //Resets all fields to normalized values (as determined by calculator.net)
    private void resetButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_resetButtonActionPerformed
        closingCostsEntryField.setText("3,391");
        downPaymentEntryField.setText("20");
        homePriceEntryField.setText("500,000");
        interestRateEntryField.setText("6.489");
        loanTermEntryField.setText("30");
        upfrontCashEntryField.setText("100,000");
    }//GEN-LAST:event_resetButtonActionPerformed

    //Only shows relevant fields depending on the calculator selected
    //Checks for valid inputs from all fields and no empty fields
    //Depending on the calculator selected, it calls different calculations-- Also changes based on Closing Costs
    private void CalculateButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CalculateButtonActionPerformed
        float intRate = Float.parseFloat(interestRateEntryField.getText());
        int lTerm = Integer.parseInt(loanTermEntryField.getText());
        String message = "";
        if (homePriceRadio.isSelected()){
            float uCash = MainHelper.parseMoney(upfrontCashEntryField.getText(), ",");
            float dPayment = MainHelper.parseMoney(downPaymentEntryField.getText(), ",");
            if (closingCostsEntryField.isVisible()){
                float cCost = MainHelper.parseMoney(closingCostsEntryField.getText(), ",");
                message = DownPaymentHelper.homePriceCalculateEntry(uCash, dPayment, intRate, lTerm, cCost);
                } else if (closingCostsStateSelection.isVisible()){
                String cCost = String.valueOf(closingCostsStateSelection.getSelectedItem());
                message = DownPaymentHelper.homePriceCalculateState(uCash, dPayment, intRate, lTerm, cCost);
                } else {
                message = DownPaymentHelper.homePriceCalculate(uCash, dPayment, intRate, lTerm);
            }
            }
        if (cashRadio.isSelected()){
            float hPrice = MainHelper.parseMoney(homePriceEntryField.getText(), ",");
            float dPayment = MainHelper.parseMoney(downPaymentEntryField.getText(), ",");
            if (closingCostsEntryField.isVisible()){
                float cCost = MainHelper.parseMoney(closingCostsEntryField.getText(), ",");
                message = DownPaymentHelper.cashCalculateEntry(hPrice, dPayment, intRate, lTerm, cCost);
                } else if (closingCostsStateSelection.isVisible()){
                String cCost = String.valueOf(closingCostsStateSelection.getSelectedItem()); 
                message = DownPaymentHelper.cashCalculateState(hPrice, dPayment, intRate, lTerm, cCost);
                } else{
                message = DownPaymentHelper.cashCalculate(hPrice, dPayment, intRate, lTerm);
                }
            } 
        if (downPaymentRadio.isSelected()){
            float hPrice = MainHelper.parseMoney(homePriceEntryField.getText(), ",");
            float uCash = MainHelper.parseMoney(upfrontCashEntryField.getText(), ",");
            if (closingCostsEntryField.isVisible()){
                float cCost = MainHelper.parseMoney(closingCostsEntryField.getText(), ",");
                message = DownPaymentHelper.downPaymentCalculateEntry(hPrice, uCash, intRate, lTerm, cCost);
                } else if (closingCostsStateSelection.isVisible()){
                String cCost = String.valueOf(closingCostsStateSelection.getSelectedItem()); 
                message = DownPaymentHelper.downPaymentCalculateState(hPrice, uCash, intRate, lTerm, cCost);
                } else {
                message = DownPaymentHelper.downPaymentCalculate(hPrice, uCash, intRate, lTerm);
                }
            }
        resultsLabel.setText(message);
        
    }//GEN-LAST:event_CalculateButtonActionPerformed
    //Updates the ComboBox to have the names of all the States in order
    private void updateComboBox(JComboBox<String> comboBox) {
        comboBox.removeAllItems();
        String [] names = {"Alabama", "Alaska", "Arizona","Arkansas", "California", "Colorado", "Connecticut", "Delaware", "Florida", "Georgia" , "Hawaii", "Idaho", "Illinios", "Indiana", "Iowa", "Kansas", "Kentucky", "Lousiana", "Maine", "Maryland", "Massachusetts", "Michigan", "Minnesota", "Mississippi", "Missouri", "Montana", "Nebraska", "Nevada", "New Hampshire", "New Jersey", "New Mexico", "New York", "North Carolina", "North Dakota", "Ohio", "Oklahoma", "Oregon", "Pennsylvania", "Rhode Island", "South Carolina", "South Dakota", "Tennessee", "Texas", "Utah", "Vermont", "Virginia", "Washington", "Washington, DC", "West Virginia", "Wisconsin", "Wyoming"};
        
        //Collections.sort(items);
        for (String element : names) {
            comboBox.addItem(element);
    }
    comboBox.setSelectedItem("Alabama");
}
    //Verifies whether the user wants to enter a custom closing cost or to use
    //the average closing costs per state.
    //Code obtained from website linked.
    private void closingCostsCheckBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_closingCostsCheckBoxActionPerformed
        if (closingCostsCheckBox.isSelected()){
            //https://www.geeksforgeeks.org/java-joptionpane/
            // Define an array of custom options for the dialog 
        Object[] options = { "Entry", "State" }; 
  
        // Display an option dialog with custom options 
        // The user's choice is stored in the 'choice' variable 
        int choice = JOptionPane.showOptionDialog( 
            null, // Parent component (null means center on screen) 
            "Closing Costs by State or by Entry?", // Message to display 
            "Closings Costs Selection", // Dialog title 
            JOptionPane.YES_NO_OPTION, // Option type (Yes, No) 
            JOptionPane.QUESTION_MESSAGE, // Message type (question icon) 
            null, // Custom icon (null means no custom icon) 
            options, // Custom options array 
            options[0] // Initial selection (default is "Cancel") 
        ); 
  
        // Check the user's choice and display a 
        // corresponding message 
        if (choice == JOptionPane.YES_OPTION) { 
            closingCostsDollarSign.setVisible(true);
            closingCostsEntryField.setVisible(true);
        } 
        else if (choice == JOptionPane.NO_OPTION) { 
            closingCostsStateSelection.setVisible(true);
        } 
        else { 
            // If the user chose 'Cancel' or closed the dialog 
            // show a message indicating the operation is canceled
            // and deselects the checkbox
            JOptionPane.showMessageDialog(null, "Operation canceled."); 
            closingCostsCheckBox.setSelected(false);
        }
        } else {
            closingCostsEntryField.setVisible(false);
            closingCostsDollarSign.setVisible(false);
            closingCostsStateSelection.setVisible(false);
        }
    }//GEN-LAST:event_closingCostsCheckBoxActionPerformed

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
            java.util.logging.Logger.getLogger(DownPaymentCalculator.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(DownPaymentCalculator.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(DownPaymentCalculator.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(DownPaymentCalculator.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new DownPaymentCalculator().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton CalculateButton;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JRadioButton cashRadio;
    private javax.swing.JButton clearButton;
    private javax.swing.JCheckBox closingCostsCheckBox;
    private javax.swing.JLabel closingCostsDollarSign;
    private javax.swing.JFormattedTextField closingCostsEntryField;
    private javax.swing.JComboBox<String> closingCostsStateSelection;
    private javax.swing.JTextField downPaymentEntryField;
    private javax.swing.JLabel downPaymentLabel;
    private javax.swing.JLabel downPaymentPercentSign;
    private javax.swing.JRadioButton downPaymentRadio;
    private javax.swing.JLabel errorLabel;
    private javax.swing.JFormattedTextField homePriceEntryField;
    private javax.swing.JLabel homePriceLabel;
    private javax.swing.JRadioButton homePriceRadio;
    private javax.swing.JTextField interestRateEntryField;
    private javax.swing.JLabel interestRateLabel;
    private javax.swing.JLabel interestRatePercentSign;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField loanTermEntryField;
    private javax.swing.JLabel loanTermLabel;
    private javax.swing.JButton resetButton;
    private javax.swing.JTextArea resultsLabel;
    private javax.swing.JButton returnButton;
    private javax.swing.JFormattedTextField upfrontCashEntryField;
    private javax.swing.JLabel upfrontCashLabel;
    private javax.swing.JLabel yearsLabel;
    // End of variables declaration//GEN-END:variables
}

