/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package main;

import java.awt.Color;
import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.Image;
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
import java.math.BigDecimal;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyledDocument;
import java.util.Collections;
import java.util.Objects;
import java.util.concurrent.ConcurrentHashMap;
import javax.swing.ImageIcon;
import javax.swing.SwingUtilities;


/**
 *
 * @author Kylind
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
    public CurrencyConverter(){
        initComponents();
        ImageIcon originalIcon = new ImageIcon(getClass().getResource("/images/swap.png"));
        Image scaledImage = originalIcon.getImage().getScaledInstance(64, 64, Image.SCALE_SMOOTH);

        // Set the scaled image as the icon for the button
        SwapButton.setIcon(new ImageIcon(scaledImage));    
        TimestampLabel.setText("Loading currency data...");
        StyledDocument doc = ResultTextPane.getStyledDocument();
        SimpleAttributeSet center = new SimpleAttributeSet();
        StyleConstants.setAlignment(center, StyleConstants.ALIGN_CENTER);
        doc.setParagraphAttributes(0, doc.getLength(), center, false);
        DocumentListener documentListener = new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) { checkFields(); }
            @Override
            public void removeUpdate(DocumentEvent e) { checkFields(); }
            @Override
            public void changedUpdate(DocumentEvent e) { checkFields(); }
            private void checkFields() {
                Object country = FromComboBox.getSelectedItem();
                String amount = AmountTextField.getText().strip();
                Locale locale = currencyHelper.getLocale(country.toString());
                boolean allFilled = currencyHelper.validate_currency(AmountTextField.getText(), currencyHelper.getLocale(FromComboBox.getSelectedItem().toString()));
                CalculateButton.setEnabled(allFilled);
                if (!allFilled){
                String message = currencyHelper.generateWarningMessage(amount, locale);
                WarningLabel.setText(message); 
                AmountTextField.setForeground(Color.red);
            }
            else {
                AmountTextField.setForeground(Color.black);
                WarningLabel.setText("");
            }
          }
          
        };
        AmountTextField.getDocument().addDocumentListener(documentListener);
        // Add ActionListener to the JComboBox
        FromComboBox.addActionListener(e -> documentListener.changedUpdate(null));

        // Add ActionListener to the JCheckBox
        FromCheckBox.addActionListener(e -> documentListener.changedUpdate(null));
        SwapButton.addActionListener(e -> documentListener.changedUpdate(null));
        loadCurrencyDictInBackground();
    }
    
    private void loadCurrencyDictInBackground() {
    new Thread(() -> {
        // Load currencyDict in a background thread
        currencyDict = currencyHelper.webScraper();

        // Update the UI after currencyDict is loaded
        SwingUtilities.invokeLater(() -> {
            // Update timestamp and any combo boxes dependent on currencyDict
            String timestamp = currencyHelper.FromFile() 
                               ? currencyHelper.getTimestampFromFile("src/files/timestamp.txt") 
                               : ZonedDateTime.now().format(DateTimeFormatter.RFC_1123_DATE_TIME);
            TimestampLabel.setText("Conversions valid as of " + timestamp);

            // Populate combo boxes now that currencyDict is loaded
            updateComboBox(FromComboBox, FromCheckBox.isSelected());
            updateComboBox(ToComboBox, ToCheckBox.isSelected());
        });
    }).start();
}
    

    
    private void updateComboBox(JComboBox<String> comboBox, boolean popular) {
        comboBox.removeAllItems();
        
        List<String> items = popular ? Popular_Currencies : new ArrayList<>(currencyDict.keySet());
        
        Collections.sort(items);
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
        WarningLabel = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        ResultTextPane = new javax.swing.JTextPane();
        SwapButton = new javax.swing.JButton();
        TimestampLabel = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        FromComboBox.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        ToComboBox.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        FromLabel.setFont(new java.awt.Font("Franklin Gothic Heavy", 2, 24)); // NOI18N
        FromLabel.setText("From");

        Title.setFont(new java.awt.Font("Franklin Gothic Heavy", 2, 36)); // NOI18N
        Title.setForeground(new java.awt.Color(51, 0, 204));
        Title.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Title.setText("Currency Calculator");

        ToLabel.setFont(new java.awt.Font("Franklin Gothic Heavy", 2, 24)); // NOI18N
        ToLabel.setText("To");

        AmountLabel.setFont(new java.awt.Font("Franklin Gothic Heavy", 2, 24)); // NOI18N
        AmountLabel.setText("Amount");

        AmountTextField.setText("100.00");
        AmountTextField.setToolTipText("Enter the amount to be converted.");
        AmountTextField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                AmountTextFieldKeyPressed(evt);
            }
        });

        CalculateButton.setBackground(new java.awt.Color(204, 153, 0));
        CalculateButton.setForeground(new java.awt.Color(0, 0, 0));
        CalculateButton.setText("Calculate");
        CalculateButton.setToolTipText("Click to calculate the converted amount.");
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
        QuitButton.setText("Return");
        QuitButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                QuitButtonMouseClicked(evt);
            }
        });

        WarningLabel.setForeground(new java.awt.Color(255, 51, 51));
        WarningLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        ResultTextPane.setFont(getFont());
        ResultTextPane.setForeground(new java.awt.Color(153, 153, 0));
        ResultTextPane.setText("$100.00\nis equivalent to\n$100.00");
        jScrollPane2.setViewportView(ResultTextPane);

        SwapButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SwapButtonActionPerformed(evt);
            }
        });

        TimestampLabel.setFont(new java.awt.Font("Dubai", 2, 12)); // NOI18N
        TimestampLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(107, 107, 107)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(FromCheckBox, javax.swing.GroupLayout.PREFERRED_SIZE, 227, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                    .addComponent(FromLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(FromComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 317, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                    .addGap(67, 67, 67)
                                    .addComponent(QuitButton, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(CalculateButton, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                    .addComponent(ToCheckBox, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 227, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(ToLabel)
                            .addComponent(AmountLabel1))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(ToComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 317, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(ClearButton, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 289, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(SwapButton, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(43, 43, 43))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(WarningLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 639, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Title, javax.swing.GroupLayout.PREFERRED_SIZE, 645, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(88, 88, 88)
                        .addComponent(AmountLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(AmountTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 307, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(TimestampLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(Title, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(WarningLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(AmountLabel)
                    .addComponent(AmountTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(FromLabel)
                            .addComponent(FromComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(FromCheckBox)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(ToLabel)
                            .addComponent(ToComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(42, 42, 42)
                        .addComponent(SwapButton, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 26, Short.MAX_VALUE)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(ToCheckBox)
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(CalculateButton, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 50, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(60, 60, 60)
                        .addComponent(AmountLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(QuitButton, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(ClearButton, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(16, 16, 16)))
                .addComponent(TimestampLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
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
        CalculateFunction();
    }//GEN-LAST:event_CalculateButtonActionPerformed

    private void AmountTextFieldKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_AmountTextFieldKeyPressed
        if (evt.getKeyCode() == 10) {
            if (CalculateButton.isEnabled()) {
                CalculateFunction();
            }
        }
    }//GEN-LAST:event_AmountTextFieldKeyPressed

    private void SwapButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SwapButtonActionPerformed
        Object fromCountry = FromComboBox.getSelectedItem();
        Object toCountry = ToComboBox.getSelectedItem();
        Boolean fromPopular = FromCheckBox.isSelected();
        Boolean toPopular = ToCheckBox.isSelected();
        
        Boolean newFromPopular = ToCheckBox.isSelected();
        Boolean newToPopular = FromCheckBox.isSelected();
        if (!Objects.equals(newFromPopular, fromPopular)) {
        ActionListener[] listeners = FromComboBox.getActionListeners();
        for (ActionListener listener : listeners) {
            FromComboBox.removeActionListener(listener);
        }
        updateComboBox(FromComboBox, FromCheckBox.isSelected());
        for (ActionListener listener : listeners) {
            FromComboBox.addActionListener(listener);
        }
        }
        
        if (!Objects.equals(newToPopular, toPopular)) {
            updateComboBox(ToComboBox, ToCheckBox.isSelected());
        }
        
        Locale fromLocale = currencyHelper.getLocale((String) fromCountry);
        Locale toLocale = currencyHelper.getLocale((String) toCountry);
        String symbol = currencyHelper.getCurrencySymbol(toLocale);
        String amount = AmountTextField.getText();
        if (currencyHelper.validate_currency(amount, fromLocale)) {
            BigDecimal fixed_amount = currencyHelper.unformatCurrency(amount, fromLocale);
            AmountTextField.setText(currencyHelper.formatCurrency(fixed_amount, toLocale).replaceAll("\\Q" + symbol + "\\E\\s*|\u00A0", "").trim());
        }
        else {
           AmountTextField.setText("1000"); 
        }
        
        FromComboBox.setSelectedItem(toCountry);
        ToComboBox.setSelectedItem(fromCountry);
        FromCheckBox.setSelected(toPopular);
        ToCheckBox.setSelected(fromPopular);
        
        
        
        
    }//GEN-LAST:event_SwapButtonActionPerformed

    
    public Font getFont() {
        try {
            Font customFont = Font.createFont(Font.TRUETYPE_FONT, new File("src/fonts/iskoola-pota.ttf"));
            customFont = customFont.deriveFont(Font.BOLD, 18);
            return customFont;
        } catch (FontFormatException | IOException e) {
           Font customFont = new java.awt.Font("Arial Unicode MS", java.awt.Font.BOLD, 18);
            customFont = customFont.deriveFont(18f); // Set the desired size
            return customFont;
        }

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
    
    private void CalculateFunction() {
        WarningLabel.setText("");
        AmountTextField.setForeground(Color.black);
        Object toCountry = ToComboBox.getSelectedItem();
        Object fromCountry = FromComboBox.getSelectedItem();
        Double fromRate = currencyDict.get(FromComboBox.getSelectedItem())[1];
        Double toRate = currencyDict.get(toCountry)[0];
        String amount = AmountTextField.getText().strip();
        Locale fromCountryLocale = currencyHelper.getLocale(fromCountry.toString());

        String newAmount = currencyHelper.currencyConverter(fromRate, toRate, amount, currencyHelper.getLocale(toCountry.toString()), fromCountryLocale);
        String fromAmount = currencyHelper.formatCurrency(currencyHelper.unformatCurrency(amount, fromCountryLocale), fromCountryLocale);
        
        ResultTextPane.setText(fromAmount + "\n is equivalent to \n" + newAmount);
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
    private javax.swing.JTextPane ResultTextPane;
    private javax.swing.JButton SwapButton;
    private javax.swing.JLabel TimestampLabel;
    private javax.swing.JLabel Title;
    private javax.swing.JCheckBox ToCheckBox;
    private javax.swing.JComboBox<String> ToComboBox;
    private javax.swing.JLabel ToLabel;
    private javax.swing.JLabel WarningLabel;
    private javax.swing.JScrollPane jScrollPane2;
    // End of variables declaration//GEN-END:variables
}
