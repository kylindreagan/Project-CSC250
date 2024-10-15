/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package main;

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
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu2 = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Lucida Fax", 0, 24)); // NOI18N
        jLabel1.setText("Financial Calculators");

        currencyButton.setFont(new java.awt.Font("Lucida Fax", 0, 12)); // NOI18N
        currencyButton.setText("Currency Converter");
        currencyButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                currencyButtonMouseClicked(evt);
            }
        });

        mortgageButton.setFont(new java.awt.Font("Lucida Fax", 0, 12)); // NOI18N
        mortgageButton.setText("Mortgage Calculator");
        mortgageButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                mortgageButtonMousePressed(evt);
            }
        });

        amortizationButton.setFont(new java.awt.Font("Lucida Fax", 0, 12)); // NOI18N
        amortizationButton.setText("Amortization Calculator");
        amortizationButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                amortizationButtonMouseClicked(evt);
            }
        });

        rentVsBuyButton.setFont(new java.awt.Font("Lucida Fax", 0, 12)); // NOI18N
        rentVsBuyButton.setText("Rent vs. Buy Calculator");
        rentVsBuyButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                rentVsBuyButtonMouseClicked(evt);
            }
        });

        houseAffordabilityButton.setFont(new java.awt.Font("Lucida Fax", 0, 12)); // NOI18N
        houseAffordabilityButton.setText("House Affordability Calculator");
        houseAffordabilityButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                houseAffordabilityButtonMouseClicked(evt);
            }
        });

        retirementButton.setFont(new java.awt.Font("Lucida Fax", 0, 12)); // NOI18N
        retirementButton.setText("Retirement Calculator");
        retirementButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                retirementButtonMouseClicked(evt);
            }
        });

        autoLoanButton.setFont(new java.awt.Font("Lucida Fax", 0, 12)); // NOI18N
        autoLoanButton.setText("Auto Loan Calculator");
        autoLoanButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                autoLoanButtonMouseClicked(evt);
            }
        });

        interestButton.setFont(new java.awt.Font("Lucida Fax", 0, 12)); // NOI18N
        interestButton.setText("Interest Calculator");
        interestButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                interestButtonMouseClicked(evt);
            }
        });

        rentButton.setFont(new java.awt.Font("Lucida Fax", 0, 12)); // NOI18N
        rentButton.setText("Rent Calculator");
        rentButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                rentButtonMouseClicked(evt);
            }
        });

        refinanceButton.setFont(new java.awt.Font("Lucida Fax", 0, 12)); // NOI18N
        refinanceButton.setText("Refinance Calculator");
        refinanceButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                refinanceButtonMouseClicked(evt);
            }
        });

        rothIRAButton.setFont(new java.awt.Font("Lucida Fax", 0, 12)); // NOI18N
        rothIRAButton.setText("Roth IRA Calculator");
        rothIRAButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                rothIRAButtonMouseClicked(evt);
            }
        });

        downPaymentButton.setFont(new java.awt.Font("Lucida Fax", 0, 12)); // NOI18N
        downPaymentButton.setText("Down Payment Calculator");
        downPaymentButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                downPaymentButtonMouseClicked(evt);
            }
        });

        jMenu2.setText("Quit");
        jMenu2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jMenu2MouseClicked(evt);
            }
        });
        jMenuBar1.add(jMenu2);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(137, 137, 137)
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(currencyButton)
                            .addComponent(rentVsBuyButton)
                            .addComponent(autoLoanButton)
                            .addComponent(refinanceButton))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(mortgageButton)
                            .addComponent(houseAffordabilityButton)
                            .addComponent(interestButton)
                            .addComponent(rothIRAButton))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(downPaymentButton)
                            .addComponent(rentButton)
                            .addComponent(retirementButton)
                            .addComponent(amortizationButton))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(currencyButton)
                    .addComponent(mortgageButton)
                    .addComponent(amortizationButton))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(rentVsBuyButton)
                    .addComponent(houseAffordabilityButton)
                    .addComponent(retirementButton))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(autoLoanButton)
                    .addComponent(interestButton)
                    .addComponent(rentButton))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(refinanceButton)
                    .addComponent(rothIRAButton)
                    .addComponent(downPaymentButton))
                .addContainerGap(96, Short.MAX_VALUE))
        );

        pack();
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
        new RentVsBuyCalculator().setVisible(true);
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
        new RefinanceCalculator().setVisible(true);
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
