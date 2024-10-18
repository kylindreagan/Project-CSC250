/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package main;

import java.awt.Font;
import java.awt.FontFormatException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import javax.swing.JComboBox;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;


/**
 *
 * @author kylin
 */
public class CurrencyConverter extends javax.swing.JFrame {
    private Map<String, Double[]> currencyDict;
    private static final List<String> Popular_Currencies = Arrays.asList(
        "US Dollar", 
        "Euro", 
        "British Pound", 
        "Japanese Yen", 
        "Australian Dollar", 
        "Canadian Dollar", 
        "Swiss Franc", 
        "Chinese Yuan Renminbi", 
        "Swedish Krona", 
        "New Zealand Dollar", 
        "Russian Ruble", 
        "Mexican Peso"
    );
    

    /**
     * Creates new form CurrencyCalculator
     */
    public CurrencyConverter() {
        currencyDict = currencyHelper.webScraper();
        initComponents();
        updateComboBox(FromComboBox, FromCheckBox.isSelected());
        updateComboBox(ToComboBox, ToCheckBox.isSelected());
        DocumentListener documentListener = new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) { checkFields(); }
            @Override
            public void removeUpdate(DocumentEvent e) { checkFields(); }
            @Override
            public void changedUpdate(DocumentEvent e) { checkFields(); }
            private void checkFields() {
                boolean allFilled = currencyHelper.validate_currency(AmountTextField.getText(), currencyHelper.getLocale(FromComboBox.getSelectedItem().toString()));
                CalculateButton.setEnabled(allFilled);
            }
        };
        AmountTextField.getDocument().addDocumentListener(documentListener);
        // Add ActionListener to the JComboBox
        FromComboBox.addActionListener(e -> documentListener.changedUpdate(null));

        // Add ActionListener to the JCheckBox
        FromCheckBox.addActionListener(e -> documentListener.changedUpdate(null));
    }
    
    private void updateComboBox(JComboBox<String> comboBox, boolean popular) {
        comboBox.removeAllItems();
        
        List<String> items = popular ? Popular_Currencies : new ArrayList<>(currencyDict.keySet());
        for (String item : items) {
            comboBox.addItem(item);
    }
    comboBox.setSelectedItem("US Dollar");
}


    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        FromComboBox = new javax.swing.JComboBox<>();
        ToComboBox = new javax.swing.JComboBox<>();
        FromLabel = new javax.swing.JLabel();
        Title = new javax.swing.JLabel();
        ToLabel = new javax.swing.JLabel();
        AmountLabel = new javax.swing.JLabel();
        AmountTextField = new javax.swing.JTextField();
        CalculateButton = new javax.swing.JButton();
        ClearButton = new javax.swing.JButton();
        AmountLabel1 = new javax.swing.JLabel();
        FromCheckBox = new javax.swing.JCheckBox();
        ToCheckBox = new javax.swing.JCheckBox();
        QuitButton = new javax.swing.JButton();
        FromAmountLabel = new javax.swing.JLabel();
        ToAmountLabel = new javax.swing.JLabel();
        equivLabel = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        FromComboBox.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        ToComboBox.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        FromLabel.setFont(new java.awt.Font("Franklin Gothic Heavy", 2, 24)); // NOI18N
        FromLabel.setText("From");

        Title.setFont(new java.awt.Font("Franklin Gothic Heavy", 2, 36)); // NOI18N
        Title.setForeground(new java.awt.Color(51, 0, 204));
        Title.setText("Currency Calculator");

        ToLabel.setFont(new java.awt.Font("Franklin Gothic Heavy", 2, 24)); // NOI18N
        ToLabel.setText("To");

        AmountLabel.setFont(new java.awt.Font("Franklin Gothic Heavy", 2, 24)); // NOI18N
        AmountLabel.setText("Amount");

        AmountTextField.setText("100");

        CalculateButton.setBackground(new java.awt.Color(204, 153, 0));
        CalculateButton.setForeground(new java.awt.Color(0, 0, 0));
        CalculateButton.setText("Calculate");
        CalculateButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CalculateButtonActionPerformed(evt);
            }
        });

        ClearButton.setBackground(new java.awt.Color(255, 255, 255));
        ClearButton.setForeground(new java.awt.Color(0, 0, 0));
        ClearButton.setText("Clear");
        ClearButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ClearButtonMouseClicked(evt);
            }
        });

        AmountLabel1.setFont(new java.awt.Font("Franklin Gothic Heavy", 2, 24)); // NOI18N
        AmountLabel1.setText("Result");

        FromCheckBox.setSelected(true);
        FromCheckBox.setText("Show only most popular currencies");
        FromCheckBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                FromCheckBoxActionPerformed(evt);
            }
        });

        ToCheckBox.setText("Show only most popular currencies");
        ToCheckBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ToCheckBoxActionPerformed(evt);
            }
        });

        QuitButton.setBackground(new java.awt.Color(255, 0, 0));
        QuitButton.setForeground(new java.awt.Color(0, 0, 0));
        QuitButton.setText("Quit");
        QuitButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                QuitButtonMouseClicked(evt);
            }
        });

        FromAmountLabel.setFont(getFont());
        FromAmountLabel.setForeground(new java.awt.Color(153, 153, 0));
        FromAmountLabel.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        FromAmountLabel.setText("$100.00");

        ToAmountLabel.setFont(getFont());
        ToAmountLabel.setForeground(new java.awt.Color(153, 153, 0));
        ToAmountLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        ToAmountLabel.setText("$100.00");

        equivLabel.setFont(getFont());
        equivLabel.setForeground(new java.awt.Color(153, 153, 0));
        equivLabel.setText("is equivelant to...");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGap(49, 49, 49)
                        .addComponent(Title, javax.swing.GroupLayout.PREFERRED_SIZE, 365, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGap(173, 173, 173)
                        .addComponent(FromCheckBox, javax.swing.GroupLayout.PREFERRED_SIZE, 227, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGap(165, 165, 165)
                        .addComponent(ToCheckBox, javax.swing.GroupLayout.PREFERRED_SIZE, 227, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(layout.createSequentialGroup()
                            .addContainerGap()
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(FromLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(FromComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 317, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(AmountLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(AmountTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 307, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                            .addGap(34, 34, 34)
                            .addComponent(ToLabel)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(ToComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 317, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createSequentialGroup()
                            .addContainerGap()
                            .addComponent(FromAmountLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGap(45, 45, 45)
                        .addComponent(QuitButton, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(AmountLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(64, 64, 64)
                                .addComponent(CalculateButton, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(40, 40, 40)
                                .addComponent(ClearButton, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(101, 101, 101)
                                .addComponent(equivLabel)
                                .addGap(0, 0, Short.MAX_VALUE)))))
                .addGap(31, 31, 31))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(ToAmountLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(Title)
                .addGap(33, 33, 33)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(AmountLabel)
                    .addComponent(AmountTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(FromComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(FromLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(FromCheckBox)
                .addGap(4, 4, 4)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ToComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ToLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(ToCheckBox)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(44, 44, 44)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(FromAmountLabel)
                            .addComponent(equivLabel))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 41, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(AmountLabel1)
                        .addGap(5, 5, 5)))
                .addComponent(ToAmountLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(ClearButton, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(CalculateButton, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(12, 12, 12))
                    .addComponent(QuitButton, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(25, 25, 25))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void ClearButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ClearButtonMouseClicked
        AmountTextField.setText("");
    }//GEN-LAST:event_ClearButtonMouseClicked

    private void FromCheckBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_FromCheckBoxActionPerformed
        ActionListener[] listeners = FromComboBox.getActionListeners();
        for (ActionListener listener : listeners) {
            FromComboBox.removeActionListener(listener);
        }
        updateComboBox(FromComboBox, FromCheckBox.isSelected());
        for (ActionListener listener : listeners) {
            FromComboBox.addActionListener(listener);
        }
    }//GEN-LAST:event_FromCheckBoxActionPerformed

    private void ToCheckBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ToCheckBoxActionPerformed
        updateComboBox(ToComboBox, ToCheckBox.isSelected());
    }//GEN-LAST:event_ToCheckBoxActionPerformed

    private void QuitButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_QuitButtonMouseClicked
        this.dispose();
    }//GEN-LAST:event_QuitButtonMouseClicked

    private void CalculateButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CalculateButtonActionPerformed
        Object toCountry = ToComboBox.getSelectedItem();
        Object fromCountry = FromComboBox.getSelectedItem();
        Double fromRate = currencyDict.get(FromComboBox.getSelectedItem())[1];
        Double toRate = currencyDict.get(toCountry)[0];
        String amount = AmountTextField.getText().toString();

        String newAmount = currencyHelper.currencyConverter(fromRate, toRate, amount, currencyHelper.getLocale(toCountry.toString()));
        FromAmountLabel.setText(currencyHelper.formatCurrency(amount, currencyHelper.getLocale(fromCountry.toString())));
        ToAmountLabel.setText(newAmount);
    }//GEN-LAST:event_CalculateButtonActionPerformed

    
    public Font getFont() {
        Font customFont = new java.awt.Font("Arial Unicode MS", java.awt.Font.BOLD, 18);
        customFont = customFont.deriveFont(18f); // Set the desired size
        return customFont;
    }
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
            java.util.logging.Logger.getLogger(CurrencyConverter.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CurrencyConverter.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CurrencyConverter.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CurrencyConverter.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CurrencyConverter().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel AmountLabel;
    private javax.swing.JLabel AmountLabel1;
    private javax.swing.JTextField AmountTextField;
    private javax.swing.JButton CalculateButton;
    private javax.swing.JButton ClearButton;
    private javax.swing.JLabel FromAmountLabel;
    private javax.swing.JCheckBox FromCheckBox;
    private javax.swing.JComboBox<String> FromComboBox;
    private javax.swing.JLabel FromLabel;
    private javax.swing.JButton QuitButton;
    private javax.swing.JLabel Title;
    private javax.swing.JLabel ToAmountLabel;
    private javax.swing.JCheckBox ToCheckBox;
    private javax.swing.JComboBox<String> ToComboBox;
    private javax.swing.JLabel ToLabel;
    private javax.swing.JLabel equivLabel;
    // End of variables declaration//GEN-END:variables
}
