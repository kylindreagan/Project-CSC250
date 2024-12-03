package main;
import java.awt.*;
import javax.swing.JOptionPane;
import javax.swing.ToolTipManager;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */

/**
 *
 * @author gustavo
 */
public class RentCalculator extends javax.swing.JFrame {

    /**
     * Creates new form RentCalc
     */
    private void hidePanels() {
        jPanel7.setVisible(false);
        jPanel8.setVisible(false);
        jPanel4.setVisible(false);
        jPanel5.setVisible(false);
        jPanel6.setVisible(false);
        jLabel7.setVisible(false);
        jLabel11.setVisible(false);
        jLabel12.setVisible(false);
        jLabel8.setVisible(false);
        jLabel9.setVisible(false);
}

    private void showPanels() {
        jPanel4.setVisible(true);
        jPanel5.setVisible(true);
        jPanel6.setVisible(true);
        jLabel7.setVisible(true);
        jLabel11.setVisible(true);
        jLabel12.setVisible(true);
        jPanel7.setVisible(true);
        jPanel8.setVisible(true);    }
    public RentCalculator() {
        initComponents();
        setResizable(false);

        hidePanels();
        ToolTipManager.sharedInstance().setInitialDelay(0);
        ToolTipManager.sharedInstance().setDismissDelay(20000);




        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jButton3 = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jTextField2 = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jComboBox2 = new javax.swing.JComboBox<>();
        jLabel14 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        jLabel12 = new javax.swing.JLabel();
        jPanel7 = new javax.swing.JPanel();
        jPanel8 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jLabel15 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(153, 0, 0));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Nunito", 0, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Rent Calculator");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 20, -1, 49));

        jLabel6.setFont(new java.awt.Font("Nunito", 0, 18)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(239, 240, 240));
        jLabel6.setText("<html><body style='width: 400px;'>Use the rent calculator below to estimate the affordable monthly rental spending amount based on income and debt level.</body></html>");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 90, 490, 70));

        jLabel10.setFont(new java.awt.Font("Nunito", 0, 18)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(25, 55, 77));
        getContentPane().add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 430, -1, -1));

        jLabel2.setBackground(new java.awt.Color(0, 0, 0));
        jLabel2.setFont(new java.awt.Font("Nunito", 0, 36)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(25, 55, 77));
        jLabel2.setText("How much Rent can you afford?");
        jLabel2.setToolTipText("");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 190, -1, -1));

        jLabel8.setFont(new java.awt.Font("Nunito", 0, 18)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(25, 55, 77));
        getContentPane().add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 270, 170, 40));

        jLabel9.setBackground(new java.awt.Color(0, 0, 0));
        jLabel9.setFont(new java.awt.Font("Nunito", 0, 18)); // NOI18N
        jLabel9.setToolTipText("");
        jLabel9.setMaximumSize(new java.awt.Dimension(20, 23));
        getContentPane().add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(940, 270, 180, 40));

        jButton3.setFont(new java.awt.Font("Nunito", 0, 18)); // NOI18N
        jButton3.setForeground(new java.awt.Color(25, 55, 77));
        jButton3.setText("Return");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(1100, 30, 110, 40));

        jLabel3.setFont(new java.awt.Font("Nunito", 0, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(25, 55, 77));
        jLabel3.setText("Your pre-tax income:");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 200, -1, -1));

        jLabel4.setFont(new java.awt.Font("Nunito", 0, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(25, 55, 77));
        jLabel4.setText("<html>Your monthly payback Debt:<html>");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 260, 200, 50));

        jTextField1.setFont(new java.awt.Font("Nunito", 0, 18)); // NOI18N
        jTextField1.setForeground(new java.awt.Color(25, 55, 77));
        getContentPane().add(jTextField1, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 200, 100, -1));

        jTextField2.setFont(new java.awt.Font("Nunito", 0, 18)); // NOI18N
        jTextField2.setForeground(new java.awt.Color(25, 55, 77));
        jTextField2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField2ActionPerformed(evt);
            }
        });
        getContentPane().add(jTextField2, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 270, 100, -1));

        jLabel5.setBackground(new java.awt.Color(102, 102, 255));
        jLabel5.setFont(new java.awt.Font("Helvetica Neue", 0, 10)); // NOI18N
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("?");
        jLabel5.setToolTipText("<html><body style='width: 200px;'>The total of the minimum amounts you pay each month to keep up with the ongoing debts, such as student loans, car loans, credit cards, child support, alimony paid, and personal loans</body></html>");
        jLabel5.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jLabel5.setOpaque(true);
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 290, 20, 20));

        jLabel13.setFont(new java.awt.Font("Nunito", 0, 18)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(25, 55, 77));
        jLabel13.setText("$");
        getContentPane().add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 200, 20, 30));

        jComboBox2.setFont(new java.awt.Font("Nunito", 0, 18)); // NOI18N
        jComboBox2.setForeground(new java.awt.Color(25, 55, 77));
        jComboBox2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "per month", "per year" }));
        getContentPane().add(jComboBox2, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 200, 130, -1));

        jLabel14.setFont(new java.awt.Font("Nunito", 0, 18)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(25, 55, 77));
        jLabel14.setText("$");
        getContentPane().add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 270, -1, 30));

        jPanel4.setBackground(new java.awt.Color(51, 204, 0));

        jLabel7.setFont(new java.awt.Font("Nunito", 0, 18)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(25, 55, 77));
        jLabel7.setText("Safe");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(74, 74, 74)
                .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(69, 69, 69))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap(18, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 330, 180, 50));

        jPanel5.setBackground(new java.awt.Color(255, 255, 0));
        jPanel5.setForeground(new java.awt.Color(255, 255, 255));

        jLabel11.setFont(new java.awt.Font("Nunito", 0, 18)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(25, 55, 77));
        jLabel11.setText("Acceptable");

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addContainerGap(50, Short.MAX_VALUE)
                .addComponent(jLabel11)
                .addGap(40, 40, 40))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel11)
                .addContainerGap(18, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(770, 330, 180, 50));

        jPanel6.setBackground(new java.awt.Color(255, 51, 0));

        jLabel12.setFont(new java.awt.Font("Nunito", 0, 18)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(25, 55, 77));
        jLabel12.setText("Aggressive");

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                .addContainerGap(41, Short.MAX_VALUE)
                .addComponent(jLabel12)
                .addGap(49, 49, 49))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel12)
                .addContainerGap(18, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(950, 330, 180, 50));

        jPanel7.setBackground(new java.awt.Color(0, 0, 0));

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 10, Short.MAX_VALUE)
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 50, Short.MAX_VALUE)
        );

        getContentPane().add(jPanel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(945, 308, 10, 50));

        jPanel8.setBackground(new java.awt.Color(25, 55, 77));

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 10, Short.MAX_VALUE)
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 50, Short.MAX_VALUE)
        );

        getContentPane().add(jPanel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(764, 308, 10, 50));

        jButton1.setBackground(new java.awt.Color(158, 191, 183));
        jButton1.setFont(new java.awt.Font("Nunito", 0, 18)); // NOI18N
        jButton1.setText("Calculate");
        jButton1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton1MouseClicked(evt);
            }
        });
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 390, 140, 30));

        jButton2.setBackground(new java.awt.Color(153, 153, 153));
        jButton2.setFont(new java.awt.Font("Nunito", 0, 18)); // NOI18N
        jButton2.setForeground(new java.awt.Color(255, 255, 255));
        jButton2.setText("Clear");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 390, 140, 30));

        jLabel15.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/RentCalcDesign.png"))); // NOI18N
        getContentPane().add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1243, 700));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        jTextField1.setText("");
        jTextField2.setText("");
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton1MouseClicked
        // TODO add your handling code here:
        String incomeInput = jTextField1.getText().trim().replace(",", "");
        String debtInput = jTextField2.getText().trim().replace(",", "");

        // Check if the income input is valid and positive
        if (!RentCalculatorHelper.isValidNumber(incomeInput) || Double.parseDouble(incomeInput) < 0)  {
            jTextField1.setBackground(Color.red);
            JOptionPane.showMessageDialog(
                null,
                "Please input a valid income (positive number > 0)",
                "Invalid Input",
                JOptionPane.ERROR_MESSAGE
            );
            jTextField1.setBackground(Color.white);
            return;
        }

        // Check if the debt input is valid
        if (!RentCalculatorHelper.isValidNumber(debtInput)) {
            jTextField2.setBackground(Color.red);
                        JOptionPane.showMessageDialog(
                null,
                "Please input a valid monthly debt payback)",
                "Invalid Input",
                JOptionPane.ERROR_MESSAGE
            );
            jTextField2.setBackground(Color.white);

            return;
        }
        
        jTextField1.setBackground(Color.white); // Custom red color
        jTextField2.setBackground(Color.white); // Custom red color

        double income = Double.parseDouble(incomeInput);
        double debt = Double.parseDouble(debtInput);
        double Threshold;
        double max;
        double min;
        double monthlyincome;

        String selectedFrequency = (String) jComboBox2.getSelectedItem();

        if ("per month".equals(selectedFrequency)) {
            Threshold = RentCalculatorHelper.ThreshHold(income);
            max = RentCalculatorHelper.max(income, debt);
            min = RentCalculatorHelper.min(income, debt);
        } else {
            monthlyincome = RentCalculatorHelper.calculateRentFromYearly(income);
            Threshold = RentCalculatorHelper.ThreshHold(monthlyincome);
            max = RentCalculatorHelper.max(monthlyincome, debt);
            min = RentCalculatorHelper.min(monthlyincome, debt);
        }

        if (max <= 0 || income == 0 && debt>=0){

            jLabel10.setText("<html> At that income and debt level, it will be hard to meet rent payments.<html>");
            hidePanels();

        }

        else if(income == 0 && debt < 0){
            jLabel8.setVisible(true);
            jLabel9.setVisible(true);
            jLabel8.setText(String.format("$%,.0f",min));
            jLabel9.setText(String.format("$%,.0f",max));
            showPanels();
            jLabel10.setText(String.format("<html> Some landlords may not accept applications with more <br>" 
                    + "than 1/3 of gross income on rent, which is $%,.0f <br>"
                + "You can afford up to $%,.0f per month on a rental payment.<br>"
                + "It is recommended to keep your rental payment below $%,.0f per month.<html>" ,Threshold,max,min));
        }

        else if(debt <= 0){
            jLabel8.setVisible(true);
            jLabel9.setVisible(true);
            jLabel8.setText(String.format("$%,.0f",min));
            jLabel9.setText(String.format("$%,.0f",max));
            showPanels();
            jLabel10.setText(String.format("<html> Some landlords may not accept applications with more <br>"+ "than 1/3 of gross income on rent, which is $%,.0f <br>"
                + "You can afford up to $%,.0f per month on a rental payment.<br>"
                + "It is recommended to keep your rental payment below $%,.0f per month.<html>" ,Threshold,max,min));

        }

        else if(Threshold < max){
            jLabel8.setVisible(true);
            jLabel9.setVisible(true);
            jLabel8.setText(String.format("$%,.0f",min));
            jLabel9.setText(String.format("$%,.0f",max));
            showPanels();
            jLabel10.setText(String.format("<html> Some landlords may not accept applications with more<br>"+ "than 1/3 of gross income on rent, which is $%,.0f <br>"
                + "You can afford up to $%,.0f per month on a rental payment.<br>"
                + "It is recommended to keep your rental payment below $%,.0f per month.<html>" ,Threshold,max,min));
        }
        else{
            jLabel8.setVisible(true);
            jLabel9.setVisible(true);
            jLabel8.setText(String.format("$%,.0f",min));
            jLabel9.setText(String.format("$%,.0f",max));
            showPanels();
            jLabel10.setText(String.format("<html> You can afford up to $%,.0f per month on a rental payment.<br>"
                + "It is recommended to keep your rental payment below $%,.0f per month.<html>" ,max,min));

        }
    }//GEN-LAST:event_jButton1MouseClicked

    private void jTextField2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField2ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton1ActionPerformed

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
            java.util.logging.Logger.getLogger(RentCalculator.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(RentCalculator.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(RentCalculator.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(RentCalculator.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new RentCalculator().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JComboBox<String> jComboBox2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    // End of variables declaration//GEN-END:variables
}
