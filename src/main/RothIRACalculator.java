/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package main;

import java.awt.Color;
import java.awt.Component;
import java.awt.KeyboardFocusManager;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

/**
 *
 * @author giann
 */
public class RothIRACalculator extends javax.swing.JFrame {
    private static JTextField lastFocusedField = null;
    private static String lastsavedannual = "7,000";
    private static Boolean Yes = false;
    private static Boolean No = true;
    /**
     * Creates new form RothIRACalculator
     */
    public RothIRACalculator() {
        initComponents();
        FocusListener focusListenerLastFocused = new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                // Record the last focused JTextField
                lastFocusedField = (JTextField) e.getComponent();
            }

            @Override
            public void focusLost(FocusEvent e) {
                // Do nothing when focus is lost
            }
        };
        CurrentAgeField.addFocusListener(focusListenerLastFocused);
        CurrentAmountField.addFocusListener(focusListenerLastFocused);
        AnnualField.addFocusListener(focusListenerLastFocused);
        ERRField.addFocusListener(focusListenerLastFocused);
        RetireAgeField.addFocusListener(focusListenerLastFocused);
        TaxField.addFocusListener(focusListenerLastFocused);
        
        DocumentListener documentListener = new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) { checkFields(); }
            @Override
            public void removeUpdate(DocumentEvent e) { checkFields(); }
            @Override
            public void changedUpdate(DocumentEvent e) { checkFields(); }
            private void checkFields() {
                String RA = RetireAgeField.getText();
                String CA = CurrentAgeField.getText();
                Boolean ValidAge = RothIRAHelper.validate_ages(RA, CA);
                if (!ValidAge){
                CalculateButton.setEnabled(false);
                String message = RothIRAHelper.generate_age_warning(RA, CA);
                WarningLabel.setText(message); 
                RetireAgeField.setForeground(Color.red);
                CurrentAgeField.setForeground(Color.red);
            }
            else {
                RetireAgeField.setForeground(Color.black);
                CurrentAgeField.setForeground(Color.black);
                Boolean x = !MainHelper.validate_money(CurrentAmountField.getText(), false);
                Boolean c = (!MainHelper.validate_money(AnnualField.getText(), false) && !"Maximized".equals(AnnualField.getText()));
                Boolean a = !MainHelper.isValidNumber(ERRField.getText());
                Boolean b = !MainHelper.isValidNumber(TaxField.getText());
                if (x || a || b || c) {
                    CalculateButton.setEnabled(false);
                    if (b) {
                        TaxField.setForeground(Color.red);
                        WarningLabel.setText("⚠ Invalid Marginal Tax Rate.");
                    }
                    else {
                        TaxField.setForeground(Color.black);
                    }
                    if (a) {
                        ERRField.setForeground(Color.red);
                        WarningLabel.setText("⚠ Invalid Expected Rate of Return.");
                    }
                    else {
                        ERRField.setForeground(Color.red);
                    }
                    if (c) {
                        AnnualField.setForeground(Color.red);
                        WarningLabel.setText("⚠ Invalid Annual Contribution.");
                    }
                    else {
                        AnnualField.setForeground(Color.black);
                    }
                    if(x) {
                        CurrentAmountField.setForeground(Color.red);
                        WarningLabel.setText("⚠ Invalid Current Amount.");
                    }
                    else {
                        CurrentAmountField.setForeground(Color.black);
                    }
                }
                else {
                    CurrentAmountField.setForeground(Color.black);
                    AnnualField.setForeground(Color.black);
                    ERRField.setForeground(Color.black);
                    TaxField.setForeground(Color.black);
                    WarningLabel.setText("");
                    CalculateButton.setEnabled(true);  
                }
            }
          }
        };
        CurrentAgeField.getDocument().addDocumentListener(documentListener);
        RetireAgeField.getDocument().addDocumentListener(documentListener);
        CurrentAmountField.getDocument().addDocumentListener(documentListener);
        AnnualField.getDocument().addDocumentListener(documentListener);
        ERRField.getDocument().addDocumentListener(documentListener);
        TaxField.getDocument().addDocumentListener(documentListener);
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        IRAbuttons = new javax.swing.ButtonGroup();
        Title1 = new javax.swing.JLabel();
        IRATabs = new javax.swing.JTabbedPane();
        InputPanel = new javax.swing.JPanel();
        AmountLabel2 = new javax.swing.JLabel();
        AmountLabel3 = new javax.swing.JLabel();
        AmountLabel4 = new javax.swing.JLabel();
        AmountLabel5 = new javax.swing.JLabel();
        AmountLabel6 = new javax.swing.JLabel();
        AmountLabel7 = new javax.swing.JLabel();
        AmountLabel8 = new javax.swing.JLabel();
        YesRadioButton = new javax.swing.JRadioButton();
        NoRadioButton = new javax.swing.JRadioButton();
        CurrentAmountField = new javax.swing.JTextField();
        AnnualField = new javax.swing.JTextField();
        ERRField = new javax.swing.JTextField();
        CurrentAgeField = new javax.swing.JTextField();
        RetireAgeField = new javax.swing.JTextField();
        TaxField = new javax.swing.JTextField();
        CalculateButton = new javax.swing.JButton();
        ClearButton = new javax.swing.JButton();
        SuperClearButton = new javax.swing.JButton();
        ResetButton = new javax.swing.JButton();
        AmountLabel16 = new javax.swing.JLabel();
        AmountLabel17 = new javax.swing.JLabel();
        AmountLabel18 = new javax.swing.JLabel();
        AmountLabel19 = new javax.swing.JLabel();
        WarningLabel = new javax.swing.JLabel();
        infoBoxLabel = new javax.swing.JLabel();
        infoBoxLabel1 = new javax.swing.JLabel();
        infoBoxLabel2 = new javax.swing.JLabel();
        infoBoxLabel3 = new javax.swing.JLabel();
        ResultPanel = new javax.swing.JPanel();
        GraphPanel = new javax.swing.JPanel();
        SchedulePanel = new javax.swing.JPanel();
        QuitButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        Title1.setFont(new java.awt.Font("Franklin Gothic Heavy", 2, 48)); // NOI18N
        Title1.setForeground(new java.awt.Color(51, 0, 204));
        Title1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Title1.setText("Roth IRA Calculator");

        AmountLabel2.setFont(new java.awt.Font("Franklin Gothic Heavy", 2, 18)); // NOI18N
        AmountLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        AmountLabel2.setText("Current Amount");

        AmountLabel3.setFont(new java.awt.Font("Franklin Gothic Heavy", 2, 18)); // NOI18N
        AmountLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        AmountLabel3.setText("Annual Contribution");

        AmountLabel4.setFont(new java.awt.Font("Franklin Gothic Heavy", 2, 18)); // NOI18N
        AmountLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        AmountLabel4.setText("Marginal Tax Rate");
        AmountLabel4.setToolTipText("");

        AmountLabel5.setFont(new java.awt.Font("Franklin Gothic Heavy", 2, 18)); // NOI18N
        AmountLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        AmountLabel5.setText("Current Age");

        AmountLabel6.setFont(new java.awt.Font("Franklin Gothic Heavy", 2, 18)); // NOI18N
        AmountLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        AmountLabel6.setText("Retirement Age");

        AmountLabel7.setFont(new java.awt.Font("Franklin Gothic Heavy", 2, 18)); // NOI18N
        AmountLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        AmountLabel7.setText("<html>Expected Rate<br>of Return</html>");

        AmountLabel8.setFont(new java.awt.Font("Franklin Gothic Heavy", 2, 18)); // NOI18N
        AmountLabel8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        AmountLabel8.setText("Maximize Contributions?");
        AmountLabel8.setToolTipText("");

        IRAbuttons.add(YesRadioButton);
        YesRadioButton.setText("Yes");
        YesRadioButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                YesRadioButtonActionPerformed(evt);
            }
        });

        IRAbuttons.add(NoRadioButton);
        NoRadioButton.setSelected(true);
        NoRadioButton.setText("No");
        NoRadioButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                NoRadioButtonActionPerformed(evt);
            }
        });

        CurrentAmountField.setText("20,000");

        AnnualField.setText("7,000");

        ERRField.setText("6");

        CurrentAgeField.setText("30");

        RetireAgeField.setText("65");

        TaxField.setText("25");

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
        ClearButton.setText("Clear Current");
        ClearButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ClearButtonMouseClicked(evt);
            }
        });
        ClearButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ClearButtonActionPerformed(evt);
            }
        });

        SuperClearButton.setBackground(new java.awt.Color(255, 255, 255));
        SuperClearButton.setForeground(new java.awt.Color(0, 0, 0));
        SuperClearButton.setText("Clear All");
        SuperClearButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                SuperClearButtonMouseClicked(evt);
            }
        });

        ResetButton.setBackground(new java.awt.Color(255, 255, 255));
        ResetButton.setForeground(new java.awt.Color(0, 0, 0));
        ResetButton.setText("Reset");
        ResetButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ResetButtonMouseClicked(evt);
            }
        });

        AmountLabel16.setFont(new java.awt.Font("Franklin Gothic Heavy", 2, 18)); // NOI18N
        AmountLabel16.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        AmountLabel16.setText("$");

        AmountLabel17.setFont(new java.awt.Font("Franklin Gothic Heavy", 2, 18)); // NOI18N
        AmountLabel17.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        AmountLabel17.setText("$");

        AmountLabel18.setFont(new java.awt.Font("Franklin Gothic Heavy", 2, 18)); // NOI18N
        AmountLabel18.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        AmountLabel18.setText("%");

        AmountLabel19.setFont(new java.awt.Font("Franklin Gothic Heavy", 2, 18)); // NOI18N
        AmountLabel19.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        AmountLabel19.setText("%");

        WarningLabel.setForeground(new java.awt.Color(255, 51, 51));
        WarningLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        infoBoxLabel.setFont(new java.awt.Font("sansserif", 1, 12)); // NOI18N
        infoBoxLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        infoBoxLabel.setText("?");
        infoBoxLabel.setToolTipText("<html><body style='width: 200px;'>The amount you plan to contribute to the Roth IRA account each year. The maximum contribution limit is $7,000 for individuals under the age of 50 and increases to $8,000 for individuals aged 50 and above.</body></html>  ");
        infoBoxLabel.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        infoBoxLabel.setOpaque(true);

        infoBoxLabel1.setFont(new java.awt.Font("sansserif", 1, 12)); // NOI18N
        infoBoxLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        infoBoxLabel1.setText("?");
        infoBoxLabel1.setToolTipText("<html><body style='width: 200px;'>Please select 'yes' if you plan to contribute the maximum allowed amount each year. The maximum contribution limit is $6,500 before the age of 50 and increases to $7,500 after the age of 50.</body></html>  ");
        infoBoxLabel1.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        infoBoxLabel1.setOpaque(true);

        infoBoxLabel2.setFont(new java.awt.Font("sansserif", 1, 12)); // NOI18N
        infoBoxLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        infoBoxLabel2.setText("?");
        infoBoxLabel2.setToolTipText("<html><body style='width: 200px;'>The expected average annual return you will earn on your money in the account.</body></html>  ");
        infoBoxLabel2.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        infoBoxLabel2.setOpaque(true);

        infoBoxLabel3.setFont(new java.awt.Font("sansserif", 1, 12)); // NOI18N
        infoBoxLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        infoBoxLabel3.setText("?");
        infoBoxLabel3.setToolTipText("<html><body style='width: 200px;''>The tax rate you pay on additional income. Please includes the combined federal and state/local marginal tax rates, if applicable.</body></html>  ");
        infoBoxLabel3.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        infoBoxLabel3.setOpaque(true);

        javax.swing.GroupLayout InputPanelLayout = new javax.swing.GroupLayout(InputPanel);
        InputPanel.setLayout(InputPanelLayout);
        InputPanelLayout.setHorizontalGroup(
            InputPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(InputPanelLayout.createSequentialGroup()
                .addGroup(InputPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(InputPanelLayout.createSequentialGroup()
                        .addGroup(InputPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(InputPanelLayout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(InputPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(InputPanelLayout.createSequentialGroup()
                                        .addGroup(InputPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(AmountLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(AmountLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                    .addGroup(InputPanelLayout.createSequentialGroup()
                                        .addGroup(InputPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(InputPanelLayout.createSequentialGroup()
                                                .addComponent(AmountLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(infoBoxLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(AmountLabel17))
                                            .addGroup(InputPanelLayout.createSequentialGroup()
                                                .addComponent(AmountLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(infoBoxLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGroup(InputPanelLayout.createSequentialGroup()
                                                .addComponent(AmountLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(infoBoxLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(0, 0, Short.MAX_VALUE)))
                                        .addGap(18, 18, 18)))
                                .addGroup(InputPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(AnnualField, javax.swing.GroupLayout.PREFERRED_SIZE, 189, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(InputPanelLayout.createSequentialGroup()
                                        .addGroup(InputPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(CurrentAgeField, javax.swing.GroupLayout.PREFERRED_SIZE, 189, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(ERRField, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 189, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(RetireAgeField, javax.swing.GroupLayout.PREFERRED_SIZE, 189, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(AmountLabel18))
                                    .addGroup(InputPanelLayout.createSequentialGroup()
                                        .addComponent(TaxField, javax.swing.GroupLayout.PREFERRED_SIZE, 189, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(AmountLabel19))))
                            .addGroup(InputPanelLayout.createSequentialGroup()
                                .addGap(26, 26, 26)
                                .addComponent(AmountLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(13, 13, 13)
                                .addComponent(AmountLabel16)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(CurrentAmountField, javax.swing.GroupLayout.PREFERRED_SIZE, 189, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addGap(119, 119, 119))
                    .addGroup(InputPanelLayout.createSequentialGroup()
                        .addComponent(AmountLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 229, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(infoBoxLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(YesRadioButton, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(NoRadioButton, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGroup(InputPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(ClearButton, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(CalculateButton, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(InputPanelLayout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addGroup(InputPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(ResetButton, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(SuperClearButton, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(40, 40, 40))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, InputPanelLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(WarningLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 639, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(19, 19, 19))
        );
        InputPanelLayout.setVerticalGroup(
            InputPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(InputPanelLayout.createSequentialGroup()
                .addComponent(WarningLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(InputPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(InputPanelLayout.createSequentialGroup()
                        .addGroup(InputPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(AmountLabel2)
                            .addComponent(CurrentAmountField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(CalculateButton, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(AmountLabel16))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(InputPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(AmountLabel3)
                            .addComponent(AnnualField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(AmountLabel17)
                            .addComponent(infoBoxLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(InputPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(InputPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(AmountLabel8)
                                .addComponent(YesRadioButton)
                                .addComponent(NoRadioButton))
                            .addComponent(infoBoxLabel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(ClearButton, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(InputPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(InputPanelLayout.createSequentialGroup()
                        .addComponent(AmountLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(InputPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(CurrentAgeField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(AmountLabel5))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(InputPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(AmountLabel6)
                            .addComponent(RetireAgeField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(InputPanelLayout.createSequentialGroup()
                        .addGroup(InputPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(SuperClearButton, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(ERRField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(infoBoxLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(AmountLabel18))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(ResetButton, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(InputPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(AmountLabel4)
                    .addComponent(TaxField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(AmountLabel19)
                    .addComponent(infoBoxLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(21, Short.MAX_VALUE))
        );

        IRATabs.addTab("Input", InputPanel);

        javax.swing.GroupLayout ResultPanelLayout = new javax.swing.GroupLayout(ResultPanel);
        ResultPanel.setLayout(ResultPanelLayout);
        ResultPanelLayout.setHorizontalGroup(
            ResultPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 719, Short.MAX_VALUE)
        );
        ResultPanelLayout.setVerticalGroup(
            ResultPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 349, Short.MAX_VALUE)
        );

        IRATabs.addTab("Results", ResultPanel);

        javax.swing.GroupLayout GraphPanelLayout = new javax.swing.GroupLayout(GraphPanel);
        GraphPanel.setLayout(GraphPanelLayout);
        GraphPanelLayout.setHorizontalGroup(
            GraphPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 719, Short.MAX_VALUE)
        );
        GraphPanelLayout.setVerticalGroup(
            GraphPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 349, Short.MAX_VALUE)
        );

        IRATabs.addTab("Graph", GraphPanel);

        javax.swing.GroupLayout SchedulePanelLayout = new javax.swing.GroupLayout(SchedulePanel);
        SchedulePanel.setLayout(SchedulePanelLayout);
        SchedulePanelLayout.setHorizontalGroup(
            SchedulePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 719, Short.MAX_VALUE)
        );
        SchedulePanelLayout.setVerticalGroup(
            SchedulePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 349, Short.MAX_VALUE)
        );

        IRATabs.addTab("Annual Schedule", SchedulePanel);

        QuitButton.setBackground(new java.awt.Color(255, 0, 0));
        QuitButton.setForeground(new java.awt.Color(0, 0, 0));
        QuitButton.setText("Return");
        QuitButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                QuitButtonMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(IRATabs)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(QuitButton, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(Title1, javax.swing.GroupLayout.PREFERRED_SIZE, 513, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(77, 77, 77))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(Title1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(QuitButton, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(21, 21, 21)))
                .addComponent(IRATabs)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void CalculateButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CalculateButtonActionPerformed
        CalculateFunction();
        IRATabs.setSelectedComponent(ResultPanel);
    }//GEN-LAST:event_CalculateButtonActionPerformed

    private void ClearButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ClearButtonMouseClicked
        Component focusedComponent = KeyboardFocusManager.getCurrentKeyboardFocusManager().getFocusOwner();
        if (focusedComponent instanceof JTextField) {
            ((JTextField) focusedComponent).setText("");
        }
    }//GEN-LAST:event_ClearButtonMouseClicked

    private void ClearButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ClearButtonActionPerformed
        if (lastFocusedField != null) {
            lastFocusedField.setText("");  // Clear the content of the last focused text field
            lastFocusedField = null;
        } else {
            JOptionPane.showMessageDialog(null, "No text field was selected!");
        }
    }//GEN-LAST:event_ClearButtonActionPerformed

    private void SuperClearButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_SuperClearButtonMouseClicked
        RetirementHelper.clearAllTextFields(InputPanel);
        lastFocusedField = null;
    }//GEN-LAST:event_SuperClearButtonMouseClicked

    private void ResetButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ResetButtonMouseClicked
        CurrentAmountField.setText("20,000");
        AnnualField.setText("7,000");
        ERRField.setText("6");
        YesRadioButton.setSelected(false);
        NoRadioButton.setSelected(true);
    }//GEN-LAST:event_ResetButtonMouseClicked

    private void QuitButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_QuitButtonMouseClicked
        this.dispose();
    }//GEN-LAST:event_QuitButtonMouseClicked

    private void YesRadioButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_YesRadioButtonActionPerformed
        if (Yes == false){
        lastsavedannual = AnnualField.getText();
        AnnualField.setEditable(false);
        AnnualField.setText("Maximized");
        AmountLabel17.setVisible(false);
        Yes = true;
        No = false;
        }
    }//GEN-LAST:event_YesRadioButtonActionPerformed

    private void NoRadioButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_NoRadioButtonActionPerformed
        if (No == false){
        AnnualField.setEditable(true);
        AnnualField.setText(lastsavedannual);
        AmountLabel17.setVisible(true);
        Yes = false;
        No = true;
        }
    }//GEN-LAST:event_NoRadioButtonActionPerformed

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
            java.util.logging.Logger.getLogger(RothIRACalculator.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(RothIRACalculator.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(RothIRACalculator.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(RothIRACalculator.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new RothIRACalculator().setVisible(true);
            }
        });
    }
    
    public static void CalculateFunction() {
    //temp
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel AmountLabel16;
    private javax.swing.JLabel AmountLabel17;
    private javax.swing.JLabel AmountLabel18;
    private javax.swing.JLabel AmountLabel19;
    private javax.swing.JLabel AmountLabel2;
    private javax.swing.JLabel AmountLabel3;
    private javax.swing.JLabel AmountLabel4;
    private javax.swing.JLabel AmountLabel5;
    private javax.swing.JLabel AmountLabel6;
    private javax.swing.JLabel AmountLabel7;
    private javax.swing.JLabel AmountLabel8;
    private javax.swing.JTextField AnnualField;
    private javax.swing.JButton CalculateButton;
    private javax.swing.JButton ClearButton;
    private javax.swing.JTextField CurrentAgeField;
    private javax.swing.JTextField CurrentAmountField;
    private javax.swing.JTextField ERRField;
    private javax.swing.JPanel GraphPanel;
    private javax.swing.JTabbedPane IRATabs;
    private javax.swing.ButtonGroup IRAbuttons;
    private javax.swing.JPanel InputPanel;
    private javax.swing.JRadioButton NoRadioButton;
    private javax.swing.JButton QuitButton;
    private javax.swing.JButton ResetButton;
    private javax.swing.JPanel ResultPanel;
    private javax.swing.JTextField RetireAgeField;
    private javax.swing.JPanel SchedulePanel;
    private javax.swing.JButton SuperClearButton;
    private javax.swing.JTextField TaxField;
    private javax.swing.JLabel Title1;
    private javax.swing.JLabel WarningLabel;
    private javax.swing.JRadioButton YesRadioButton;
    private javax.swing.JLabel infoBoxLabel;
    private javax.swing.JLabel infoBoxLabel1;
    private javax.swing.JLabel infoBoxLabel2;
    private javax.swing.JLabel infoBoxLabel3;
    // End of variables declaration//GEN-END:variables
}
