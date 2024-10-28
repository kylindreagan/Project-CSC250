/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package main;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Dictionary;
import java.util.Enumeration;
import java.util.Hashtable;
import java.util.List;
import java.util.TreeSet;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
/**
 *
 * @author gianna
 */
public class DownPaymentCalculator extends javax.swing.JFrame {

    /**
     * Creates new form DownPaymentCalculator
     */
    public DownPaymentCalculator() {
        initComponents();
        setInvisible();
        Dictionary<String, Integer> stateClosingCosts = DownPaymentHelper.createVals();
        updateComboBox(closingCostsStateSelection, stateClosingCosts);
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
        closingCostsPercentSign.setVisible(false);
        homePriceEntryField.setVisible(false);
        upfrontCashEntryField.setVisible(false);
        downPaymentEntryField.setVisible(false);
        closingCostsEntryField.setVisible(false);
        interestRateEntryField.setVisible(false);
        loanTermEntryField.setVisible(false);
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
        upfrontCashEntryField = new javax.swing.JTextField();
        downPaymentLabel = new javax.swing.JLabel();
        downPaymentEntryField = new javax.swing.JTextField();
        downPaymentPercentSign = new javax.swing.JLabel();
        interestRateLabel = new javax.swing.JLabel();
        closingCostsCheckBox = new javax.swing.JCheckBox();
        loanTermLabel = new javax.swing.JLabel();
        CalculateButton = new javax.swing.JButton();
        clearButton = new javax.swing.JButton();
        closingCostsEntryField = new javax.swing.JTextField();
        closingCostsPercentSign = new javax.swing.JLabel();
        closingCostsStateSelection = new javax.swing.JComboBox<>();
        interestRateEntryField = new javax.swing.JTextField();
        interestRatePercentSign = new javax.swing.JLabel();
        loanTermEntryField = new javax.swing.JTextField();
        yearsLabel = new javax.swing.JLabel();
        returnButton = new javax.swing.JButton();
        resetButton = new javax.swing.JButton();
        homePriceEntryField = new javax.swing.JFormattedTextField();

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

        upfrontCashEntryField.setText("100,000");

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

        closingCostsEntryField.setText("3,391");

        closingCostsPercentSign.setText("$");

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
                        .addComponent(cashRadio)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(downPaymentRadio))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(94, 94, 94)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(upfrontCashLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(upfrontCashEntryField, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(downPaymentLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(downPaymentEntryField, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(downPaymentPercentSign, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(closingCostsCheckBox)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(closingCostsPercentSign, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(loanTermLabel, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(interestRateLabel, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(interestRateEntryField, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(interestRatePercentSign))
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
                                        .addComponent(resetButton))))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(homePriceLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(homePriceEntryField, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(56, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(249, 249, 249)
                .addComponent(closingCostsEntryField, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(closingCostsStateSelection, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
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
                        .addGap(18, 18, 18)
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
                            .addComponent(closingCostsEntryField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(closingCostsPercentSign)
                            .addComponent(closingCostsStateSelection, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
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
                        .addContainerGap(50, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(CalculateButton)
                            .addComponent(clearButton)
                            .addComponent(resetButton))
                        .addContainerGap())))
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
    private void CalculateButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CalculateButtonActionPerformed
        if (homePriceRadio.isSelected()){
            float uCash = Float.parseFloat(upfrontCashEntryField.getText());
            float dPayment = Float.parseFloat(downPaymentEntryField.getText());
            float intRate = Float.parseFloat(interestRateEntryField.getText());
            float lTerm = Float.parseFloat(loanTermEntryField.getText());
            if (closingCostsEntryField.isVisible()){
                float cCost = Float.parseFloat(closingCostsEntryField.getText());
                DownPaymentHelper.homePriceCalculate(uCash, dPayment, intRate, lTerm, cCost);
            }
            else if (closingCostsEntryField.isVisible()){
                float cCost = 0;
                DownPaymentHelper.homePriceCalculate(uCash, dPayment, intRate, lTerm, cCost);
            }
        }
        if (cashRadio.isSelected()){
            DownPaymentHelper.cashCalculate();
        }
        if (downPaymentRadio.isSelected()){
            DownPaymentHelper.downPaymentCalculate();
        }
    }//GEN-LAST:event_CalculateButtonActionPerformed
    //Updates the ComboBox to have the names of all the States
    //Needs updating 
    private void updateComboBox(JComboBox<String> comboBox, Dictionary<String, Integer> stateClosingCosts) {
        comboBox.removeAllItems();
        
        /*final List<String> rankList = Arrays.asList(items.values());
  
        TreeSet<String> ranks = new TreeSet<String>();
        ranks.addAll(rankList);

        System.out.println("--- Using the default sorting ---");
        for (Rank rank : ranks) {
         System.out.println(rank);
        } */
        Enumeration items = stateClosingCosts.keys();
        
        //Collections.sort(items);
        while (items.hasMoreElements()) {
            comboBox.addItem(String.valueOf(items.nextElement()));
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
            closingCostsPercentSign.setVisible(true);
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
            closingCostsPercentSign.setVisible(false);
            closingCostsStateSelection.setVisible(false);
        }
    }//GEN-LAST:event_closingCostsCheckBoxActionPerformed

    private void CalculateButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CalculateButtonActionPerformed
        if (homePriceRadio.isSelected()){
            DownPaymentHelper.homePriceCalculate();
        }
        if (cashRadio.isSelected()){
            DownPaymentHelper.cashCalculate();
        }
        if (downPaymentRadio.isSelected()){
            DownPaymentHelper.downPaymentCalculate();
        }
    }//GEN-LAST:event_CalculateButtonActionPerformed

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
    private javax.swing.JTextField closingCostsEntryField;
    private javax.swing.JLabel closingCostsPercentSign;
    private javax.swing.JComboBox<String> closingCostsStateSelection;
    private javax.swing.JTextField downPaymentEntryField;
    private javax.swing.JLabel downPaymentLabel;
    private javax.swing.JLabel downPaymentPercentSign;
    private javax.swing.JRadioButton downPaymentRadio;
    private javax.swing.JFormattedTextField homePriceEntryField;
    private javax.swing.JLabel homePriceLabel;
    private javax.swing.JRadioButton homePriceRadio;
    private javax.swing.JTextField interestRateEntryField;
    private javax.swing.JLabel interestRateLabel;
    private javax.swing.JLabel interestRatePercentSign;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField loanTermEntryField;
    private javax.swing.JLabel loanTermLabel;
    private javax.swing.JButton resetButton;
    private javax.swing.JButton returnButton;
    private javax.swing.JTextField upfrontCashEntryField;
    private javax.swing.JLabel upfrontCashLabel;
    private javax.swing.JLabel yearsLabel;
    // End of variables declaration//GEN-END:variables
}
