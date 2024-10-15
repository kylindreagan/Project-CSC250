/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package main;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import javax.swing.JComboBox;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

/**
 *
 * @author kylin
 */
public class CurrencyConverter extends javax.swing.JFrame {
    private Map<String, Double[]> currencyDict;
    private List<String> popularCurrencies;

    /**
     * Creates new form CurrencyCalculator
     */
    public CurrencyConverter() {
        currencyDict = currencyHelper.webScraper();
        popularCurrencies = Arrays.asList(
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
        initComponents();
        updateComboBox(FromComboBox, currencyDict, popularCurrencies, FromCheckBox.isSelected());
        updateComboBox(ToComboBox, currencyDict, popularCurrencies, ToCheckBox.isSelected());
        DocumentListener documentListener = new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                checkFields();
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                checkFields();
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                checkFields();
            }

            // Check if all fields are filled, then enable the button
            private void checkFields() {
                boolean allFilled = MainHelper.validate_money(AmountTextField.getText());
                CalculateButton.setEnabled(allFilled);
            }
        };
         
        AmountTextField.getDocument().addDocumentListener(documentListener);
    }
    
    private void updateComboBox(JComboBox<String> comboBox, Map<String, Double[]> map, List<String> currencies, boolean popular) {
        // Clear existing items
        comboBox.removeAllItems();
        
        if (popular) {
            for (String value : currencies) {
                comboBox.addItem(value);
            }
        }
        else {
        // Add each key from the map as an item in the combo box
        for (String key : map.keySet()) {
            comboBox.addItem(key);
        }  
        }
        FromComboBox.setSelectedItem("US Dollar");
        ToComboBox.setSelectedItem("US Dollar");
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
        ResultTextField = new javax.swing.JTextField();
        FromCheckBox = new javax.swing.JCheckBox();
        ToCheckBox = new javax.swing.JCheckBox();
        QuitButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        FromComboBox.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        ToComboBox.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        FromLabel.setFont(new java.awt.Font("Franklin Gothic Heavy", 2, 24)); // NOI18N
        FromLabel.setText("From");

        Title.setFont(new java.awt.Font("Franklin Gothic Heavy", 2, 24)); // NOI18N
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

        ResultTextField.setEditable(false);
        ResultTextField.setText("100.00 US Dollar = 100.00 US Dollar");

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

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
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
                        .addGroup(layout.createSequentialGroup()
                            .addGap(90, 90, 90)
                            .addComponent(Title, javax.swing.GroupLayout.PREFERRED_SIZE, 263, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                            .addGap(34, 34, 34)
                            .addComponent(ToLabel)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(ToComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 317, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createSequentialGroup()
                            .addContainerGap()
                            .addComponent(AmountLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(ResultTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 307, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createSequentialGroup()
                            .addGap(51, 51, 51)
                            .addComponent(QuitButton, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(42, 42, 42)
                            .addComponent(CalculateButton, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(40, 40, 40)
                            .addComponent(ClearButton, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(173, 173, 173)
                        .addComponent(FromCheckBox, javax.swing.GroupLayout.PREFERRED_SIZE, 227, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(31, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(ToCheckBox, javax.swing.GroupLayout.PREFERRED_SIZE, 227, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(48, 48, 48))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(Title)
                .addGap(35, 35, 35)
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
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(AmountLabel1)
                    .addComponent(ResultTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(CalculateButton, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ClearButton, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(QuitButton, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(14, 14, 14))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void ClearButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ClearButtonMouseClicked
        AmountTextField.setText("");
    }//GEN-LAST:event_ClearButtonMouseClicked

    private void FromCheckBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_FromCheckBoxActionPerformed
        updateComboBox(FromComboBox, currencyDict, popularCurrencies, FromCheckBox.isSelected());
    }//GEN-LAST:event_FromCheckBoxActionPerformed

    private void ToCheckBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ToCheckBoxActionPerformed
        updateComboBox(ToComboBox, currencyDict, popularCurrencies, ToCheckBox.isSelected());
    }//GEN-LAST:event_ToCheckBoxActionPerformed

    private void QuitButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_QuitButtonMouseClicked
        this.dispose();
    }//GEN-LAST:event_QuitButtonMouseClicked

    private void CalculateButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CalculateButtonActionPerformed
        Double fromRate = currencyDict.get(FromComboBox.getSelectedItem())[1];
        Double toRate = currencyDict.get(ToComboBox.getSelectedItem())[0];
        float amount = Float.parseFloat(AmountTextField.getText());
        Double newAmount = currencyHelper.currencyConverter(fromRate, toRate, amount);
        String Result = String.format("%.2f %s = %.2f %s", 
                                  amount, 
                                  FromComboBox.getSelectedItem(), 
                                  newAmount, 
                                  ToComboBox.getSelectedItem());;
        ResultTextField.setText(Result);
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
    private javax.swing.JCheckBox FromCheckBox;
    private javax.swing.JComboBox<String> FromComboBox;
    private javax.swing.JLabel FromLabel;
    private javax.swing.JButton QuitButton;
    private javax.swing.JTextField ResultTextField;
    private javax.swing.JLabel Title;
    private javax.swing.JCheckBox ToCheckBox;
    private javax.swing.JComboBox<String> ToComboBox;
    private javax.swing.JLabel ToLabel;
    // End of variables declaration//GEN-END:variables
}
