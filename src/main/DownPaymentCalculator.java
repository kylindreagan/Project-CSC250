/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */

package main;
import java.awt.Color;
import java.awt.Font;
import java.awt.FontFormatException;
import java.io.File;
import java.io.IOException;
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
        myInitComponents();
        setInvisible();
        updateComboBox(closingCostsStateSelection);
        
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
        infoBoxLabel.setVisible(true);
        
        //Code from Kylind -- Used in Retirement Calculator
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
                Boolean validMoneyHP = !MainHelper.validate_money(HP, false);
                if (HP.equals("")){
                    HP = "0";
                }
                if (!validMoneyHP){
                    validMoneyHP = !MainHelper.is_positive(MainHelper.parseMoney(HP, ","));                 
                }
                Boolean validMoneyCC = !MainHelper.validate_money(CC, false);
                if (CC.equals("")){
                    CC = "0";
                }
                if (!validMoneyCC){
                    validMoneyCC = !MainHelper.is_positive(MainHelper.parseMoney(CC, ","));                 
                }
                Boolean validMoneyUC = !MainHelper.validate_money(UC, false);
                if (UC.equals("")){
                    UC = "0";
                }
                if (!validMoneyUC){
                    validMoneyUC = !MainHelper.is_positive(MainHelper.parseMoney(UC, ","));                 
                }           
                String message = "";
                if (validMoneyHP){
                    message = "Error: Invalid Home Price";
                    homePriceEntryField.setForeground(Color.red); 
                    errorLabel.setVisible(true);
                    errorLabel.setText(message); 
                    CalculateButton.setEnabled(false);
                } else{
                    homePriceEntryField.setForeground(Color.black);
                }
                if (validMoneyCC){
                    message = "Error: Invalid Closing Costs";
                    closingCostsEntryField.setForeground(Color.red);
                    errorLabel.setVisible(true);
                    errorLabel.setText(message); 
                    CalculateButton.setEnabled(false);
                }
                else {
                    closingCostsEntryField.setForeground(Color.black);                   
                }
                if (validMoneyUC){
                    message = "Error: Invalid Upfront Cash";                    
                    upfrontCashEntryField.setForeground(Color.red);
                    errorLabel.setVisible(true);
                    errorLabel.setText(message);
                    CalculateButton.setEnabled(false);
                }
                else {                    
                    upfrontCashEntryField.setForeground(Color.black); 
                }
                Boolean a = !MainHelper.isValidNumber(downPaymentEntryField.getText());
                Boolean b = !MainHelper.isValidNumber(interestRateEntryField.getText()); 
                Boolean c = !MainHelper.isValidNumber(loanTermEntryField.getText());
                if ( a || b || c) {
                    CalculateButton.setEnabled(false);
                    if (c) {
                        loanTermEntryField.setForeground(Color.red);
                        errorLabel.setVisible(true);
                        errorLabel.setText("Error: Invalid Loan Term.");
                    }
                    else {
                        loanTermEntryField.setForeground(Color.black);
                    }
                    if (b) {
                        interestRateEntryField.setForeground(Color.red);
                        errorLabel.setVisible(true);
                        errorLabel.setText("Error: Invalid Interest Rate.");
                    }
                    else {
                        interestRateEntryField.setForeground(Color.black);
                    }
                    if (a) {
                        downPaymentEntryField.setForeground(Color.red);
                        errorLabel.setVisible(true);
                        errorLabel.setText("Error: Invalid Down Payment Percentage.");
                    }
                    else {
                        downPaymentEntryField.setForeground(Color.black);
                    }
                }
                else if (!validMoneyUC && !validMoneyCC && !validMoneyHP){
                    downPaymentEntryField.setForeground(Color.black);
                    interestRateEntryField.setForeground(Color.black);
                    loanTermEntryField.setForeground(Color.black);
                    errorLabel.setText("Error: None");
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
            interestRateEntryField.getDocument().addDocumentListener(documentListener);
    }
    
    //Code from Alyssa in Interest Calculator
    private void myInitComponents() {
        getContentPane().setBackground(new java.awt.Color(10, 55, 78));
        setResizable(false);
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
        infoBoxLabel.setVisible(false);
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
        jLabel3 = new javax.swing.JLabel();
        infoBoxLabel = new javax.swing.JLabel();
        background = new javax.swing.JLabel();

        jTextField1.setText("jTextField1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Nunito", 1, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(238, 239, 239));
        jLabel1.setText("Down Payment Calculator");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 50, 470, -1));

        buttonGroup1.add(homePriceRadio);
        homePriceRadio.setFont(new java.awt.Font("Nunito", 0, 18)); // NOI18N
        homePriceRadio.setForeground(new java.awt.Color(25, 55, 77));
        homePriceRadio.setSelected(true);
        homePriceRadio.setText("Calculate Affordable Home Price");
        homePriceRadio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                homePriceRadioActionPerformed(evt);
            }
        });
        getContentPane().add(homePriceRadio, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 150, -1, -1));

        buttonGroup1.add(cashRadio);
        cashRadio.setFont(new java.awt.Font("Nunito", 0, 18)); // NOI18N
        cashRadio.setForeground(new java.awt.Color(25, 55, 77));
        cashRadio.setText("Calculate Upfront Cash Needed");
        cashRadio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cashRadioActionPerformed(evt);
            }
        });
        getContentPane().add(cashRadio, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 190, -1, -1));

        buttonGroup1.add(downPaymentRadio);
        downPaymentRadio.setFont(new java.awt.Font("Nunito", 0, 18)); // NOI18N
        downPaymentRadio.setForeground(new java.awt.Color(25, 55, 77));
        downPaymentRadio.setText("Calculate Down Payment %");
        downPaymentRadio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                downPaymentRadioActionPerformed(evt);
            }
        });
        getContentPane().add(downPaymentRadio, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 230, 415, -1));

        homePriceLabel.setFont(new java.awt.Font("Nunito", 0, 18)); // NOI18N
        homePriceLabel.setForeground(new java.awt.Color(25, 55, 77));
        homePriceLabel.setText("Home Price                        $");
        getContentPane().add(homePriceLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 290, 240, -1));

        upfrontCashLabel.setFont(new java.awt.Font("Nunito", 0, 18)); // NOI18N
        upfrontCashLabel.setForeground(new java.awt.Color(25, 55, 77));
        upfrontCashLabel.setText("Upfront Cash Available    $");
        getContentPane().add(upfrontCashLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 330, 230, -1));

        downPaymentLabel.setFont(new java.awt.Font("Nunito", 0, 18)); // NOI18N
        downPaymentLabel.setForeground(new java.awt.Color(25, 55, 77));
        downPaymentLabel.setText("Down Payment");
        getContentPane().add(downPaymentLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 370, 220, -1));

        downPaymentEntryField.setFont(new java.awt.Font("Nunito", 0, 18)); // NOI18N
        downPaymentEntryField.setText("20");
        getContentPane().add(downPaymentEntryField, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 370, 160, -1));

        downPaymentPercentSign.setFont(new java.awt.Font("Nunito", 0, 18)); // NOI18N
        downPaymentPercentSign.setForeground(new java.awt.Color(25, 55, 77));
        downPaymentPercentSign.setText("%");
        getContentPane().add(downPaymentPercentSign, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 370, 37, -1));

        interestRateLabel.setFont(new java.awt.Font("Nunito", 0, 18)); // NOI18N
        interestRateLabel.setForeground(new java.awt.Color(25, 55, 77));
        interestRateLabel.setText("Interest Rate");
        getContentPane().add(interestRateLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 460, -1, -1));

        closingCostsCheckBox.setFont(new java.awt.Font("Nunito", 0, 18)); // NOI18N
        closingCostsCheckBox.setForeground(new java.awt.Color(25, 55, 77));
        closingCostsCheckBox.setText("Include Closing Costs");
        closingCostsCheckBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                closingCostsCheckBoxActionPerformed(evt);
            }
        });
        getContentPane().add(closingCostsCheckBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 410, -1, -1));

        loanTermLabel.setFont(new java.awt.Font("Nunito", 0, 18)); // NOI18N
        loanTermLabel.setForeground(new java.awt.Color(25, 55, 77));
        loanTermLabel.setText("Loan Term");
        getContentPane().add(loanTermLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 500, 140, -1));

        CalculateButton.setFont(new java.awt.Font("Nunito", 0, 14)); // NOI18N
        CalculateButton.setText("Calculate");
        CalculateButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CalculateButtonActionPerformed(evt);
            }
        });
        getContentPane().add(CalculateButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 580, -1, -1));

        clearButton.setFont(new java.awt.Font("Nunito", 0, 14)); // NOI18N
        clearButton.setText("Clear");
        clearButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clearButtonActionPerformed(evt);
            }
        });
        getContentPane().add(clearButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 580, -1, -1));

        closingCostsDollarSign.setFont(new java.awt.Font("Nunito", 0, 18)); // NOI18N
        closingCostsDollarSign.setForeground(new java.awt.Color(25, 55, 77));
        closingCostsDollarSign.setText("$");
        getContentPane().add(closingCostsDollarSign, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 410, 16, -1));

        closingCostsStateSelection.setFont(new java.awt.Font("Nunito", 0, 18)); // NOI18N
        closingCostsStateSelection.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        getContentPane().add(closingCostsStateSelection, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 410, -1, -1));

        interestRateEntryField.setFont(new java.awt.Font("Nunito", 0, 18)); // NOI18N
        interestRateEntryField.setText("6.489");
        getContentPane().add(interestRateEntryField, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 450, 160, -1));

        interestRatePercentSign.setFont(new java.awt.Font("Nunito", 0, 18)); // NOI18N
        interestRatePercentSign.setForeground(new java.awt.Color(25, 55, 77));
        interestRatePercentSign.setText("%");
        getContentPane().add(interestRatePercentSign, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 450, -1, -1));

        loanTermEntryField.setFont(new java.awt.Font("Nunito", 0, 18)); // NOI18N
        loanTermEntryField.setForeground(new java.awt.Color(25, 55, 77));
        loanTermEntryField.setText("30");
        getContentPane().add(loanTermEntryField, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 490, 160, -1));

        yearsLabel.setFont(new java.awt.Font("Nunito", 0, 18)); // NOI18N
        yearsLabel.setForeground(new java.awt.Color(25, 55, 77));
        yearsLabel.setText("Years");
        getContentPane().add(yearsLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 490, 80, -1));

        returnButton.setFont(new java.awt.Font("Nunito", 0, 14)); // NOI18N
        returnButton.setText("Return");
        returnButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                returnButtonActionPerformed(evt);
            }
        });
        getContentPane().add(returnButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(1150, 20, -1, -1));

        resetButton.setFont(new java.awt.Font("Nunito", 0, 14)); // NOI18N
        resetButton.setText("Reset");
        resetButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                resetButtonActionPerformed(evt);
            }
        });
        getContentPane().add(resetButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 580, -1, -1));

        homePriceEntryField.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter()));
        homePriceEntryField.setText("500,000");
        homePriceEntryField.setFont(new java.awt.Font("Nunito", 0, 18)); // NOI18N
        getContentPane().add(homePriceEntryField, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 290, 160, -1));

        upfrontCashEntryField.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter()));
        upfrontCashEntryField.setText("100,000");
        upfrontCashEntryField.setFont(new java.awt.Font("Nunito", 0, 18)); // NOI18N
        getContentPane().add(upfrontCashEntryField, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 330, 160, -1));

        closingCostsEntryField.setText("3,391");
        closingCostsEntryField.setFont(new java.awt.Font("Nunito", 0, 18)); // NOI18N
        getContentPane().add(closingCostsEntryField, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 410, 160, -1));

        errorLabel.setFont(new java.awt.Font("Nunito", 0, 18)); // NOI18N
        errorLabel.setForeground(new java.awt.Color(255, 0, 0));
        errorLabel.setText("Error: None");
        getContentPane().add(errorLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 50, 440, 41));

        resultsLabel.setEditable(false);
        resultsLabel.setColumns(20);
        resultsLabel.setFont(new java.awt.Font("Nunito", 0, 18)); // NOI18N
        resultsLabel.setRows(5);
        jScrollPane1.setViewportView(resultsLabel);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 198, 320, 390));

        jLabel3.setFont(new java.awt.Font("Nunito", 1, 36)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(25, 55, 77));
        jLabel3.setText("Results:");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 140, 180, -1));

        infoBoxLabel.setBackground(new java.awt.Color(51, 150, 255));
        infoBoxLabel.setText(" ?");
        infoBoxLabel.setToolTipText("<html><body style='width: 200px;'>A down payment of less than 20% may result in you paying PMI Insurance or a Mortgage Insurance Premium.</body></html>  ");
        infoBoxLabel.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        infoBoxLabel.setOpaque(true);
        getContentPane().add(infoBoxLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 370, 15, -1));

        background.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/downPaymentBckgrd.png"))); // NOI18N
        getContentPane().add(background, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1240, 700));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents
    //Code from Kylind in Currency Converter
    public Font getFont() {
        try {
            Font customFont = Font.createFont(Font.TRUETYPE_FONT, new File("src/fonts/Nunito-VariableFont_wght.ttf"));
            customFont = customFont.deriveFont(Font.BOLD, 18);
            return customFont;
        } catch (FontFormatException | IOException e) {
           Font customFont = new java.awt.Font("Arial Unicode MS", java.awt.Font.BOLD, 18);
            customFont = customFont.deriveFont(18f); // Set the desired size
            return customFont;
        }

    }   



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
        infoBoxLabel.setVisible(true);
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
        infoBoxLabel.setVisible(true);
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
        float lTerm = Float.parseFloat(loanTermEntryField.getText());
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
    private javax.swing.JLabel background;
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
    private javax.swing.JLabel infoBoxLabel;
    private javax.swing.JTextField interestRateEntryField;
    private javax.swing.JLabel interestRateLabel;
    private javax.swing.JLabel interestRatePercentSign;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
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

