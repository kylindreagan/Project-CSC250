/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */

/**
 *
 * @author Alyssa
 */
public class MortgageCalculator extends javax.swing.JFrame {

    /**
     * Creates new form MortgageCalculator
     */
    public MortgageCalculator() {
        initComponents();
        calcButton.setEnabled(false);
        mpLabel.setVisible(false);
        numMPLabel.setVisible(false);
        mPayoffLabel.setVisible(false);
        totalInterestLabel.setVisible(false);
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        MainLabel = new javax.swing.JLabel();
        HP = new javax.swing.JLabel();
        DP = new javax.swing.JLabel();
        LT = new javax.swing.JLabel();
        IR = new javax.swing.JLabel();
        SD = new javax.swing.JLabel();
        MonthBox = new javax.swing.JComboBox<>();
        IRField = new javax.swing.JTextField();
        LTField = new javax.swing.JTextField();
        DPField = new javax.swing.JTextField();
        HPField = new javax.swing.JTextField();
        SDField = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        calcButton = new javax.swing.JButton();
        clearButton = new javax.swing.JButton();
        mpLabel = new javax.swing.JLabel();
        Box1 = new javax.swing.JComboBox<>();
        numMPLabel = new javax.swing.JLabel();
        totalInterestLabel = new javax.swing.JLabel();
        mPayoffLabel = new javax.swing.JLabel();
        closeButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        MainLabel.setText("Mortgage Calculator");

        HP.setText("Home Price");

        DP.setText("Down Payment");

        LT.setText("Loan Term");

        IR.setText("Interest Rate");

        SD.setText("Start Date");

        MonthBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec" }));
        MonthBox.setSize(new java.awt.Dimension(78, 23));

        IRField.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                IRFieldFocusLost(evt);
            }
        });
        IRField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                IRFieldKeyPressed(evt);
            }
        });

        LTField.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                LTFieldFocusLost(evt);
            }
        });
        LTField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                LTFieldKeyPressed(evt);
            }
        });

        DPField.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                DPFieldFocusLost(evt);
            }
        });
        DPField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                DPFieldKeyPressed(evt);
            }
        });

        HPField.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                HPFieldFocusLost(evt);
            }
        });
        HPField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                HPFieldKeyPressed(evt);
            }
        });

        SDField.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                SDFieldFocusLost(evt);
            }
        });
        SDField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                SDFieldKeyPressed(evt);
            }
        });

        jLabel1.setText("years");

        calcButton.setText("Calculate");
        calcButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                calcButtonActionPerformed(evt);
            }
        });

        clearButton.setText("Clear");
        clearButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clearButtonActionPerformed(evt);
            }
        });

        mpLabel.setText("Monthly Pay:");

        Box1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "%", "$" }));

        numMPLabel.setText("Total num MP");

        totalInterestLabel.setText("Total Interest");

        mPayoffLabel.setText("Mortgage Payoff Date");

        closeButton.setText("Close");
        closeButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                closeButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(IR)
                            .addComponent(SD)
                            .addComponent(LT)
                            .addComponent(DP)
                            .addComponent(HP))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(IRField)
                                    .addComponent(HPField)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                            .addComponent(LTField)
                                            .addComponent(DPField, javax.swing.GroupLayout.DEFAULT_SIZE, 70, Short.MAX_VALUE))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel1)
                                            .addComponent(Box1, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                .addGap(52, 52, 52)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(totalInterestLabel)
                                    .addComponent(numMPLabel)
                                    .addComponent(mPayoffLabel)
                                    .addComponent(mpLabel)))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(MonthBox, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(SDField, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(50, 50, 50)
                        .addComponent(calcButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(clearButton, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(115, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(MainLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(closeButton))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(MainLabel))
                    .addComponent(closeButton))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(HP)
                    .addComponent(HPField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(mpLabel))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(DP)
                            .addComponent(DPField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Box1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(LT)
                            .addComponent(LTField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(IR)
                            .addComponent(IRField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(SD)
                            .addComponent(MonthBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(SDField, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(42, 42, 42)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(calcButton)
                            .addComponent(clearButton)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(31, 31, 31)
                        .addComponent(numMPLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(totalInterestLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(mPayoffLabel)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void HPFieldKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_HPFieldKeyPressed
        // if "enter" key pressed, check if input is valid
        // if all fields have an input, enable calcButton
        if (evt.getKeyCode() == 10) {
            if (HPField.getText().strip().compareTo("") != 0) {
               if (! (MainHelper.isValidNumber(HPField.getText())) || MainHelper.isZeroS(HPField.getText())){
                    HPField.setText("");
                    HPField.requestFocus();
                    calcButton.setEnabled(false);
                    mpLabel.setVisible(false);
                    numMPLabel.setVisible(false);
                    mPayoffLabel.setVisible(false);
                    totalInterestLabel.setVisible(false);
  
                } 
               else {
                   if (HPField.getText().strip().compareTo("") == 0){
                    DPField.requestFocus();
                    }
                   int dp = DPField.getText().strip().compareTo("");
                   int lt = LTField.getText().strip().compareTo("");
                   int ir = IRField.getText().strip().compareTo("");
                   int sd = SDField.getText().strip().compareTo("");
                   if (dp != 0 && lt != 0 && ir != 0 && sd != 0) {
                       calcButton.setEnabled(true);
                    }
               }
            }
        }
    }//GEN-LAST:event_HPFieldKeyPressed

    private void calcButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_calcButtonActionPerformed
        // whole function is the "calculator part"
        float hp = Float.parseFloat(HPField.getText());
        float dp = Float.parseFloat(DPField.getText());
        if (Box1.getSelectedItem() == "%") {
            dp = hp * (dp /100);
        }
        float lt = Float.parseFloat(LTField.getText());
        float ir = Float.parseFloat(IRField.getText()) / 100;
        float i = ir / 12;
        float sd = Float.parseFloat(SDField.getText());
        // n is the number of mortgage payments made
        float n = 12 * lt;
        // defines the loan amount as home price - down payment
        float la = hp - dp;
        //the actual calculation for monthly pay on a mortgage
        float mp = la / n;
        if (i != 0){
            mp = (float) (la / ((Math.pow(1 + i, n) - 1)  / (i * Math.pow(1 + i, n))));
        }
        // determines when loan is paid off
        float payoffDate = sd + lt;
        // determines total intrest accrued
        float totInt = (n * mp) - hp + dp ;
        
        
        mpLabel.setText("Monthly Pay: $" + String.format("%,.2f" , mp));
        mpLabel.setVisible(true);
        numMPLabel.setText("Total of " + String.format("%,.0f", n) 
                + " Mortgage Payments $" + String.format("%,.2f", n * mp));
        numMPLabel.setVisible(true);
        mPayoffLabel.setText("Mortgage Payoff Date " + MonthBox.getSelectedItem() 
                + " " + String.format("%.0f", payoffDate));
        mPayoffLabel.setVisible(true);
        totalInterestLabel.setText("Total Interest $" + String.format("%,.2f", totInt));
        totalInterestLabel.setVisible(true);
        
    }//GEN-LAST:event_calcButtonActionPerformed

    private void clearButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clearButtonActionPerformed
        // clears all values from all input boxes
        HPField.setText("");
        HPField.requestFocus();
        DPField.setText("");
        LTField.setText("");
        IRField.setText("");
        SDField.setText("");
    }//GEN-LAST:event_clearButtonActionPerformed

    private void HPFieldFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_HPFieldFocusLost
        // checks for valid input
        // if all fields have an input, enable calcButton
        if (HPField.getText().strip().compareTo("") != 0) {
            if (! (MainHelper.isValidNumber(HPField.getText())) || MainHelper.isZeroS(HPField.getText())){
                HPField.setText("");
                HPField.requestFocus();
                calcButton.setEnabled(false);
                mpLabel.setVisible(false);
                numMPLabel.setVisible(false);
                mPayoffLabel.setVisible(false);
                totalInterestLabel.setVisible(false);
            } 
            else {
                if (HPField.getText().strip().compareTo("") == 0){
                    DPField.requestFocus();
                }
                int dp = DPField.getText().strip().compareTo("");
                int lt = LTField.getText().strip().compareTo("");
                int ir = IRField.getText().strip().compareTo("");
                int sd = SDField.getText().strip().compareTo("");
                if (dp != 0 && lt != 0 && ir != 0 && sd != 0) {
                    calcButton.setEnabled(true);
                }
            }
        }
    }//GEN-LAST:event_HPFieldFocusLost

    private void DPFieldKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_DPFieldKeyPressed
        // if "enter" key pressed, check if input is valid
        // if all fields have an input, enable calcButton
        if (evt.getKeyCode() == 10) {
            if (DPField.getText().strip().compareTo("") != 0) {
                if (Box1.getSelectedItem() == "%" && Float.parseFloat(DPField.getText()) >= 100) {
                    DPField.setText("");
                    DPField.requestFocus();
                    calcButton.setEnabled(false);
                    mpLabel.setVisible(false);
                    numMPLabel.setVisible(false);
                    mPayoffLabel.setVisible(false);
                    totalInterestLabel.setVisible(false);
                }
               if (! (MainHelper.isValidNumber(DPField.getText()))){
                    DPField.setText("");
                    DPField.requestFocus();
                    calcButton.setEnabled(false);
                    mpLabel.setVisible(false);
                    numMPLabel.setVisible(false);
                    mPayoffLabel.setVisible(false);
                    totalInterestLabel.setVisible(false);
                } 
               else {
                   if (DPField.getText().strip().compareTo("") == 0){
                    LTField.requestFocus();
                    }
                   int hp = HPField.getText().strip().compareTo("");
                   int lt = LTField.getText().strip().compareTo("");
                   int ir = IRField.getText().strip().compareTo("");
                   int sd = SDField.getText().strip().compareTo("");
                   if (hp != 0 && lt != 0 && ir != 0 && sd != 0) {
                       calcButton.setEnabled(true);
                       
                    }
               }
            }
        }
    }//GEN-LAST:event_DPFieldKeyPressed

    private void DPFieldFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_DPFieldFocusLost
        // checks for valid input
        // if all fields have an input, enable calcButton
        if (DPField.getText().strip().compareTo("") != 0) {
            if (Box1.getSelectedItem() == "%" && Float.parseFloat(DPField.getText()) >= 100) {
                    DPField.setText("");
                    DPField.requestFocus();
                    calcButton.setEnabled(false);
                    mpLabel.setVisible(false);
                    numMPLabel.setVisible(false);
                    mPayoffLabel.setVisible(false);
                    totalInterestLabel.setVisible(false);
                }
            if (! (MainHelper.isValidNumber(DPField.getText()))){
                DPField.setText("");
                DPField.requestFocus();
                calcButton.setEnabled(false);
                mpLabel.setVisible(false);
                numMPLabel.setVisible(false);
                mPayoffLabel.setVisible(false);
                totalInterestLabel.setVisible(false);
            } 
            else {
                if (DPField.getText().strip().compareTo("") == 0){
                    LTField.requestFocus();
                }
                int hp = HPField.getText().strip().compareTo("");
                int lt = LTField.getText().strip().compareTo("");
                int ir = IRField.getText().strip().compareTo("");
                int sd = SDField.getText().strip().compareTo("");
                if (hp != 0 && lt != 0 && ir != 0 && sd != 0) {
                    calcButton.setEnabled(true);
                }
            }
        }
    }//GEN-LAST:event_DPFieldFocusLost

    private void LTFieldKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_LTFieldKeyPressed
        // if "enter" key pressed, check if input is valid
        // if all fields have an input, enable calcButton
        if (evt.getKeyCode() == 10) {
            if (LTField.getText().strip().compareTo("") != 0) {
               if (! (MainHelper.isValidNumber(LTField.getText())) || MainHelper.isZeroS(LTField.getText())){
                    LTField.setText("");
                    LTField.requestFocus();
                    calcButton.setEnabled(false);
                    mpLabel.setVisible(false);
                    numMPLabel.setVisible(false);
                    mPayoffLabel.setVisible(false);
                    totalInterestLabel.setVisible(false);
                } 
               else {
                    if (LTField.getText().strip().compareTo("") == 0){
                        IRField.requestFocus();
                    }
                    int dp = DPField.getText().strip().compareTo("");
                    int hp = HPField.getText().strip().compareTo("");
                    int ir = IRField.getText().strip().compareTo("");
                    int sd = SDField.getText().strip().compareTo("");
                    if (dp != 0 && hp != 0 && ir != 0 && sd != 0) {
                       calcButton.setEnabled(true);
                    }
               }
            }
        }
    }//GEN-LAST:event_LTFieldKeyPressed

    private void LTFieldFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_LTFieldFocusLost
        // checks for valid input
        // if all fields have an input, enable calcButton
        if (LTField.getText().strip().compareTo("") != 0) {
            if (! (MainHelper.isValidNumber(LTField.getText())) || MainHelper.isZeroS(LTField.getText())){
                LTField.setText("");
                LTField.requestFocus();
                calcButton.setEnabled(false);
                mpLabel.setVisible(false);
                numMPLabel.setVisible(false);
                mPayoffLabel.setVisible(false);
                totalInterestLabel.setVisible(false);
            } 
            else {
                if (LTField.getText().strip().compareTo("") == 0){
                    IRField.requestFocus();
                }
                int dp = DPField.getText().strip().compareTo("");
                int hp = HPField.getText().strip().compareTo("");
                int ir = IRField.getText().strip().compareTo("");
                int sd = SDField.getText().strip().compareTo("");
                if (dp != 0 && hp != 0 && ir != 0 && sd != 0) {
                    calcButton.setEnabled(true);
                }
            }
        }
    }//GEN-LAST:event_LTFieldFocusLost

    private void IRFieldKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_IRFieldKeyPressed
        // if "enter" key pressed, check if input is valid
        // if all fields have an input, enable calcButton
        if (evt.getKeyCode() == 10) {
            if (IRField.getText().strip().compareTo("") != 0) {
               if (! (MainHelper.isValidNumber(IRField.getText()))){
                    IRField.setText("");
                    IRField.requestFocus();
                    calcButton.setEnabled(false);
                    mpLabel.setVisible(false);
                    numMPLabel.setVisible(false);
                    mPayoffLabel.setVisible(false);
                    totalInterestLabel.setVisible(false);
                } 
               else {
                    if (IRField.getText().strip().compareTo("") == 0){
                    SDField.requestFocus();
                    }
                   int dp = DPField.getText().strip().compareTo("");
                   int lt = LTField.getText().strip().compareTo("");
                   int hp = HPField.getText().strip().compareTo("");
                   int sd = SDField.getText().strip().compareTo("");
                   if (dp != 0 && lt != 0 && hp != 0 && sd != 0) {
                       calcButton.setEnabled(true);
                    }
               }
            }
        }
    }//GEN-LAST:event_IRFieldKeyPressed

    private void IRFieldFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_IRFieldFocusLost
        // checks for valid input
        // if all fields have an input, enable calcButton
        if (IRField.getText().strip().compareTo("") != 0) {
            if (! (MainHelper.isValidNumber(IRField.getText()))){
                IRField.setText("");
                IRField.requestFocus();
                calcButton.setEnabled(false);
                mpLabel.setVisible(false);
                numMPLabel.setVisible(false);
                mPayoffLabel.setVisible(false);
                totalInterestLabel.setVisible(false);
            } 
            else {
                if (IRField.getText().strip().compareTo("") == 0){
                    SDField.requestFocus();
                }
                int dp = DPField.getText().strip().compareTo("");
                int lt = LTField.getText().strip().compareTo("");
                int hp = HPField.getText().strip().compareTo("");
                int sd = SDField.getText().strip().compareTo("");
                if (dp != 0 && lt != 0 && hp != 0 && sd != 0) {
                    calcButton.setEnabled(true);
                }
            }
        }
    }//GEN-LAST:event_IRFieldFocusLost

    private void SDFieldKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_SDFieldKeyPressed
        // if "enter" key pressed, check if input is valid
        // if all fields have an input, enable calcButton
        if (evt.getKeyCode() == 10) {
            if (SDField.getText().strip().compareTo("") != 0) {
               if (! (MainHelper.isValidNumber(SDField.getText()))){
                    SDField.setText("");
                    SDField.requestFocus();
                    calcButton.setEnabled(false);
                    mpLabel.setVisible(false);
                    numMPLabel.setVisible(false);
                    mPayoffLabel.setVisible(false);
                    totalInterestLabel.setVisible(false);
                } 
               else {
                   int dp = DPField.getText().strip().compareTo("");
                   int lt = LTField.getText().strip().compareTo("");
                   int ir = IRField.getText().strip().compareTo("");
                   int hp = HPField.getText().strip().compareTo("");
                   if (dp != 0 && lt != 0 && ir != 0 && hp != 0) {
                       calcButton.setEnabled(true);
                    }
               }
            }
        }
    }//GEN-LAST:event_SDFieldKeyPressed

    private void SDFieldFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_SDFieldFocusLost
        // checks for valid input
        // if all fields have an input, enable calcButton
        if (SDField.getText().strip().compareTo("") != 0) {
            if (! (MainHelper.isValidNumber(SDField.getText()))){
                SDField.setText("");
                SDField.requestFocus();
                calcButton.setEnabled(false);
                mpLabel.setVisible(false);
                numMPLabel.setVisible(false);
                mPayoffLabel.setVisible(false);
                totalInterestLabel.setVisible(false);
            } 
            else {
                int dp = DPField.getText().strip().compareTo("");
                int lt = LTField.getText().strip().compareTo("");
                int ir = IRField.getText().strip().compareTo("");
                int hp = HPField.getText().strip().compareTo("");
                if (dp != 0 && lt != 0 && ir != 0 && hp != 0) {
                    calcButton.setEnabled(true);
                }
            }
        }
    }//GEN-LAST:event_SDFieldFocusLost

    private void closeButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_closeButtonActionPerformed
        this.dispose();
    }//GEN-LAST:event_closeButtonActionPerformed

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
            java.util.logging.Logger.getLogger(MortgageCalculator.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MortgageCalculator.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MortgageCalculator.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MortgageCalculator.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MortgageCalculator().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> Box1;
    private javax.swing.JLabel DP;
    private javax.swing.JTextField DPField;
    private javax.swing.JLabel HP;
    private javax.swing.JTextField HPField;
    private javax.swing.JLabel IR;
    private javax.swing.JTextField IRField;
    private javax.swing.JLabel LT;
    private javax.swing.JTextField LTField;
    private javax.swing.JLabel MainLabel;
    private javax.swing.JComboBox<String> MonthBox;
    private javax.swing.JLabel SD;
    private javax.swing.JTextField SDField;
    private javax.swing.JButton calcButton;
    private javax.swing.JButton clearButton;
    private javax.swing.JButton closeButton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel mPayoffLabel;
    private javax.swing.JLabel mpLabel;
    private javax.swing.JLabel numMPLabel;
    private javax.swing.JLabel totalInterestLabel;
    // End of variables declaration//GEN-END:variables
}
