/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package main;

import javax.swing.JOptionPane;

/**
 *
 * @author kylin
 */
public class MainForm extends javax.swing.JFrame {

    /**
     * Creates new form MainForm
     */
    public MainForm() {
        initComponents();
        setResizable(false);
        amortizationButton.setContentAreaFilled(false);
        autoLoanButton.setContentAreaFilled(false);
        currencyButton.setContentAreaFilled(false);
        downPaymentButton.setContentAreaFilled(false);
        houseAffordabilityButton.setContentAreaFilled(false);
        interestButton.setContentAreaFilled(false);
        mortgageButton.setContentAreaFilled(false);
        refinanceButton.setContentAreaFilled(false);
        rentButton.setContentAreaFilled(false);
        rentVsBuyButton.setContentAreaFilled(false);
        retirementButton.setContentAreaFilled(false);
        rothIRAButton.setContentAreaFilled(false);
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
        currencyButton = new javax.swing.JButton();
        mortgageButton = new javax.swing.JButton();
        amortizationButton = new javax.swing.JButton();
        rentVsBuyButton = new javax.swing.JButton();
        houseAffordabilityButton = new javax.swing.JButton();
        retirementButton = new javax.swing.JButton();
        autoLoanButton = new javax.swing.JButton();
        interestButton = new javax.swing.JButton();
        rentButton = new javax.swing.JButton();
        refinanceButton = new javax.swing.JButton();
        rothIRAButton = new javax.swing.JButton();
        downPaymentButton = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu2 = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Nunito", 1, 48)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(27, 45, 74));
        jLabel1.setText("Financial Calculators");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 100, -1, 50));

        currencyButton.setFont(new java.awt.Font("Nunito", 0, 18)); // NOI18N
        currencyButton.setForeground(new java.awt.Color(27, 45, 74));
        currencyButton.setText("<html>Currency <br> Converter");
        currencyButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                currencyButtonMouseClicked(evt);
            }
        });
        getContentPane().add(currencyButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(750, 220, 130, 70));

        mortgageButton.setFont(new java.awt.Font("Nunito", 0, 18)); // NOI18N
        mortgageButton.setForeground(new java.awt.Color(27, 45, 74));
        mortgageButton.setText("Mortgage");
        mortgageButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                mortgageButtonMousePressed(evt);
            }
        });
        getContentPane().add(mortgageButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(750, 510, 130, 70));

        amortizationButton.setFont(new java.awt.Font("Nunito", 0, 18)); // NOI18N
        amortizationButton.setForeground(new java.awt.Color(27, 45, 74));
        amortizationButton.setText("Amortization");
        amortizationButton.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        amortizationButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                amortizationButtonMouseClicked(evt);
            }
        });
        getContentPane().add(amortizationButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 220, -1, 70));

        rentVsBuyButton.setFont(new java.awt.Font("Nunito", 0, 18)); // NOI18N
        rentVsBuyButton.setForeground(new java.awt.Color(27, 45, 74));
        rentVsBuyButton.setText("Rent vs. Buy");
        rentVsBuyButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                rentVsBuyButtonMouseClicked(evt);
            }
        });
        getContentPane().add(rentVsBuyButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 410, 140, 70));

        houseAffordabilityButton.setFont(new java.awt.Font("Nunito", 0, 18)); // NOI18N
        houseAffordabilityButton.setForeground(new java.awt.Color(27, 45, 74));
        houseAffordabilityButton.setText("<html>House<br> Affordability");
        houseAffordabilityButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                houseAffordabilityButtonMouseClicked(evt);
            }
        });
        getContentPane().add(houseAffordabilityButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 320, 140, 60));

        retirementButton.setFont(new java.awt.Font("Nunito", 0, 18)); // NOI18N
        retirementButton.setForeground(new java.awt.Color(27, 45, 74));
        retirementButton.setText("Retirement");
        retirementButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                retirementButtonMouseClicked(evt);
            }
        });
        getContentPane().add(retirementButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 510, 130, 70));

        autoLoanButton.setFont(new java.awt.Font("Nunito", 0, 18)); // NOI18N
        autoLoanButton.setForeground(new java.awt.Color(27, 45, 74));
        autoLoanButton.setText("Auto Loan");
        autoLoanButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                autoLoanButtonMouseClicked(evt);
            }
        });
        getContentPane().add(autoLoanButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(554, 220, 130, 70));

        interestButton.setFont(new java.awt.Font("Nunito", 0, 18)); // NOI18N
        interestButton.setForeground(new java.awt.Color(27, 45, 74));
        interestButton.setText("Interest");
        interestButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                interestButtonMouseClicked(evt);
            }
        });
        getContentPane().add(interestButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(750, 320, 130, 60));

        rentButton.setFont(new java.awt.Font("Nunito", 0, 18)); // NOI18N
        rentButton.setForeground(new java.awt.Color(27, 45, 74));
        rentButton.setText("Rent");
        rentButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                rentButtonMouseClicked(evt);
            }
        });
        getContentPane().add(rentButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(750, 410, 130, 70));

        refinanceButton.setFont(new java.awt.Font("Nunito", 0, 18)); // NOI18N
        refinanceButton.setForeground(new java.awt.Color(27, 45, 74));
        refinanceButton.setText("Refinance");
        refinanceButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                refinanceButtonMouseClicked(evt);
            }
        });
        getContentPane().add(refinanceButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 410, 130, 70));

        rothIRAButton.setFont(new java.awt.Font("Nunito", 0, 18)); // NOI18N
        rothIRAButton.setForeground(new java.awt.Color(27, 45, 74));
        rothIRAButton.setText("Roth IRA");
        rothIRAButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                rothIRAButtonMouseClicked(evt);
            }
        });
        getContentPane().add(rothIRAButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 510, 140, 70));

        downPaymentButton.setFont(new java.awt.Font("Nunito", 0, 18)); // NOI18N
        downPaymentButton.setForeground(new java.awt.Color(27, 45, 74));
        downPaymentButton.setText("<html>Down <br>Payment");
        downPaymentButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                downPaymentButtonMouseClicked(evt);
            }
        });
        getContentPane().add(downPaymentButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 320, 130, 60));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/MainformBkg.png"))); // NOI18N
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, -23, 1240, 700));

        jMenu2.setText("Quit");
        jMenu2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jMenu2MouseClicked(evt);
            }
        });
        jMenuBar1.add(jMenu2);

        setJMenuBar(jMenuBar1);

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jMenu2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenu2MouseClicked
        System.exit(0);
    }//GEN-LAST:event_jMenu2MouseClicked

    private void currencyButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_currencyButtonMouseClicked
        new CurrencyConverter().setVisible(true);
    }//GEN-LAST:event_currencyButtonMouseClicked

    private void mortgageButtonMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_mortgageButtonMousePressed
        new MortgageCalculator().setVisible(true);
    }//GEN-LAST:event_mortgageButtonMousePressed

    private void amortizationButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_amortizationButtonMouseClicked
        new AmortizationCalculator().setVisible(true);
    }//GEN-LAST:event_amortizationButtonMouseClicked

    private void rentVsBuyButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_rentVsBuyButtonMouseClicked
        JOptionPane.showMessageDialog(null, "This feature is under construction");
    }//GEN-LAST:event_rentVsBuyButtonMouseClicked

    private void houseAffordabilityButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_houseAffordabilityButtonMouseClicked
        new HouseAffordabilityCalculator().setVisible(true);
    }//GEN-LAST:event_houseAffordabilityButtonMouseClicked

    private void retirementButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_retirementButtonMouseClicked
        new RetirementCalculator().setVisible(true);
    }//GEN-LAST:event_retirementButtonMouseClicked

    private void autoLoanButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_autoLoanButtonMouseClicked
        new AutoLoanCalculator().setVisible(true);
    }//GEN-LAST:event_autoLoanButtonMouseClicked

    private void interestButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_interestButtonMouseClicked
        new InterestCalculator().setVisible(true);
    }//GEN-LAST:event_interestButtonMouseClicked

    private void rentButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_rentButtonMouseClicked
        new RentCalculator().setVisible(true);
    }//GEN-LAST:event_rentButtonMouseClicked

    private void refinanceButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_refinanceButtonMouseClicked
        JOptionPane.showMessageDialog(null, "This feature is under construction");
    }//GEN-LAST:event_refinanceButtonMouseClicked

    private void rothIRAButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_rothIRAButtonMouseClicked
        new RothIRACalculator().setVisible(true);
    }//GEN-LAST:event_rothIRAButtonMouseClicked

    private void downPaymentButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_downPaymentButtonMouseClicked
        new DownPaymentCalculator().setVisible(true);
    }//GEN-LAST:event_downPaymentButtonMouseClicked

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
            java.util.logging.Logger.getLogger(MainForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainForm().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton amortizationButton;
    private javax.swing.JButton autoLoanButton;
    private javax.swing.JButton currencyButton;
    private javax.swing.JButton downPaymentButton;
    private javax.swing.JButton houseAffordabilityButton;
    private javax.swing.JButton interestButton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JButton mortgageButton;
    private javax.swing.JButton refinanceButton;
    private javax.swing.JButton rentButton;
    private javax.swing.JButton rentVsBuyButton;
    private javax.swing.JButton retirementButton;
    private javax.swing.JButton rothIRAButton;
    // End of variables declaration//GEN-END:variables
}
