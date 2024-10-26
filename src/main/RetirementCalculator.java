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
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author kylind
 */
public class RetirementCalculator extends javax.swing.JFrame {
    
    private Boolean INARpercent;
    private Boolean Futurepercent;
    private static JTextField lastFocusedField = null;  // Variable to track last focused JTextField
    private static Boolean allow_foreign = false;
    float future;
    float OIAR;
    float current;

    /**
     * Creates new form RetirementCalculator
     */
    public RetirementCalculator() {
        INARpercent = true;
        Futurepercent = true;
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
        CurrentField.addFocusListener(focusListenerLastFocused);
        FutureField.addFocusListener(focusListenerLastFocused);
        LifeExpField.addFocusListener(focusListenerLastFocused);
        RetireAgeField.addFocusListener(focusListenerLastFocused);
        PrecomeField.addFocusListener(focusListenerLastFocused);
        IncreaseField.addFocusListener(focusListenerLastFocused);
        INARField.addFocusListener(focusListenerLastFocused);
        OIARField.addFocusListener(focusListenerLastFocused);
        InvestField.addFocusListener(focusListenerLastFocused);
        InflateField.addFocusListener(focusListenerLastFocused);
        
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
                String LE = LifeExpField.getText();
                Boolean ValidAge = RetirementHelper.validate_ages(RA, CA, LE);
                if (!ValidAge){
                CalculateButton.setEnabled(false);
                String message = RetirementHelper.generate_age_warning(RA, CA, LE);
                WarningLabel.setText(message); 
                RetireAgeField.setForeground(Color.red);
                CurrentAgeField.setForeground(Color.red);
                LifeExpField.setForeground(Color.red);
            }
            else {
                RetireAgeField.setForeground(Color.black);
                CurrentAgeField.setForeground(Color.black);
                LifeExpField.setForeground(Color.black);
                Boolean x = !MainHelper.validate_money(PrecomeField.getText(), false);
                Boolean a = !MainHelper.isValidNumber(IncreaseField.getText());
                Boolean b = !MainHelper.isValidNumber(InvestField.getText());
                Boolean c = !MainHelper.isValidNumber(InflateField.getText());
                if (x || a || b || c) {
                    CalculateButton.setEnabled(false);
                    if (c) {
                        InflateField.setForeground(Color.red);
                        WarningLabel.setText("⚠ Invalid Inflation Rate.");
                    }
                    else {
                        InflateField.setForeground(Color.black);
                    }
                    if (b) {
                        InvestField.setForeground(Color.red);
                        WarningLabel.setText("⚠ Invalid Investment Returns.");
                    }
                    else {
                        InvestField.setForeground(Color.red);
                    }
                    if (a) {
                        IncreaseField.setForeground(Color.red);
                        WarningLabel.setText("⚠ Invalid Income Increase.");
                    }
                    else {
                        IncreaseField.setForeground(Color.black);
                    }
                    if(x) {
                        PrecomeField.setForeground(Color.red);
                        WarningLabel.setText("⚠ Invalid Pre-Income Tax.");
                    }
                    else {
                        PrecomeField.setForeground(Color.black);
                    }
                }
                else {
                    PrecomeField.setForeground(Color.black);
                    InflateField.setForeground(Color.black);
                    InvestField.setForeground(Color.black);
                    IncreaseField.setForeground(Color.black);
                    Boolean INARValid = RetirementHelper.validate_dynamic(INARField.getText(), "%".equals(INARComboBox.getSelectedItem()));
                    if (!INARValid) {
                       INARField.setForeground(Color.red);
                       WarningLabel.setText("⚠ Invalid Income Needed After Retirement.");
                        CalculateButton.setEnabled(false);
                    }
                    else{
                        INARField.setForeground(Color.black);
                        WarningLabel.setText("");
                        CalculateButton.setEnabled(true);
                    }
                    
                }
            }
          }
        };
        CurrentAgeField.getDocument().addDocumentListener(documentListener);
        RetireAgeField.getDocument().addDocumentListener(documentListener);
        LifeExpField.getDocument().addDocumentListener(documentListener);
        PrecomeField.getDocument().addDocumentListener(documentListener);
        InvestField.getDocument().addDocumentListener(documentListener);
        InflateField.getDocument().addDocumentListener(documentListener);
        IncreaseField.getDocument().addDocumentListener(documentListener);
        INARField.getDocument().addDocumentListener(documentListener);
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        RetirementTabs = new javax.swing.JTabbedPane();
        HowMuch = new javax.swing.JPanel();
        AmountLabel2 = new javax.swing.JLabel();
        AmountLabel3 = new javax.swing.JLabel();
        AmountLabel4 = new javax.swing.JLabel();
        AmountLabel5 = new javax.swing.JLabel();
        AmountLabel6 = new javax.swing.JLabel();
        INARComboBox = new javax.swing.JComboBox<>();
        AmountLabel7 = new javax.swing.JLabel();
        AmountLabel8 = new javax.swing.JLabel();
        AmountLabel9 = new javax.swing.JLabel();
        AmountLabel10 = new javax.swing.JLabel();
        LifeExpField = new javax.swing.JTextField();
        CurrentAgeField = new javax.swing.JTextField();
        PrecomeField = new javax.swing.JTextField();
        IncreaseField = new javax.swing.JTextField();
        RetireAgeField = new javax.swing.JTextField();
        InvestField = new javax.swing.JTextField();
        InflateField = new javax.swing.JTextField();
        INARField = new javax.swing.JTextField();
        Title3 = new javax.swing.JLabel();
        Title4 = new javax.swing.JLabel();
        AmountLabel11 = new javax.swing.JLabel();
        OIARField = new javax.swing.JTextField();
        AmountLabel12 = new javax.swing.JLabel();
        AmountLabel13 = new javax.swing.JLabel();
        FutureField = new javax.swing.JTextField();
        CurrentField = new javax.swing.JTextField();
        FutureComboBox = new javax.swing.JComboBox<>();
        AmountLabel14 = new javax.swing.JLabel();
        AmountLabel15 = new javax.swing.JLabel();
        AmountLabel16 = new javax.swing.JLabel();
        AmountLabel17 = new javax.swing.JLabel();
        AmountLabel18 = new javax.swing.JLabel();
        INARLabelTrailing = new javax.swing.JLabel();
        AmountLabel20 = new javax.swing.JLabel();
        FutureLabelTrailing = new javax.swing.JLabel();
        AmountLabel22 = new javax.swing.JLabel();
        WarningLabel = new javax.swing.JLabel();
        CalculateButton = new javax.swing.JButton();
        ClearButton = new javax.swing.JButton();
        SuperClearButton = new javax.swing.JButton();
        ResetButton = new javax.swing.JButton();
        ResultTab = new javax.swing.JPanel();
        OutputLabel = new javax.swing.JLabel();
        TitleLabel = new javax.swing.JLabel();
        TitleLabel1 = new javax.swing.JLabel();
        OutputLabel1 = new javax.swing.JLabel();
        Title1 = new javax.swing.JLabel();
        QuitButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setForeground(java.awt.Color.white);

        HowMuch.setPreferredSize(new java.awt.Dimension(710, 710));

        AmountLabel2.setFont(new java.awt.Font("Franklin Gothic Heavy", 2, 18)); // NOI18N
        AmountLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        AmountLabel2.setText("Current Age");

        AmountLabel3.setFont(new java.awt.Font("Franklin Gothic Heavy", 2, 18)); // NOI18N
        AmountLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        AmountLabel3.setText("Life Expectancy");

        AmountLabel4.setFont(new java.awt.Font("Franklin Gothic Heavy", 2, 18)); // NOI18N
        AmountLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        AmountLabel4.setText("/year");

        AmountLabel5.setFont(new java.awt.Font("Franklin Gothic Heavy", 2, 18)); // NOI18N
        AmountLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        AmountLabel5.setText("Retirement Age");

        AmountLabel6.setFont(new java.awt.Font("Franklin Gothic Heavy", 2, 18)); // NOI18N
        AmountLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        AmountLabel6.setText("Current Savings");

        INARComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "%", "$" }));
        INARComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                INARComboBoxActionPerformed(evt);
            }
        });

        AmountLabel7.setFont(new java.awt.Font("Franklin Gothic Heavy", 2, 18)); // NOI18N
        AmountLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        AmountLabel7.setText("<html>\nIncome Needed <br> After Retirement\n</html>");

        AmountLabel8.setFont(new java.awt.Font("Franklin Gothic Heavy", 2, 18)); // NOI18N
        AmountLabel8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        AmountLabel8.setText("Pre Income Tax");

        AmountLabel9.setFont(new java.awt.Font("Franklin Gothic Heavy", 2, 18)); // NOI18N
        AmountLabel9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        AmountLabel9.setText("Income Increase");

        AmountLabel10.setFont(new java.awt.Font("Franklin Gothic Heavy", 2, 18)); // NOI18N
        AmountLabel10.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        AmountLabel10.setText("Inflation Rate");

        LifeExpField.setText("85");

        CurrentAgeField.setText("35");

        PrecomeField.setText("70,000");

        IncreaseField.setText("3");

        RetireAgeField.setText("67");

        InvestField.setText("6");

        InflateField.setText("3");

        INARField.setText("75");

        Title3.setFont(new java.awt.Font("Franklin Gothic Heavy", 2, 24)); // NOI18N
        Title3.setForeground(new java.awt.Color(51, 0, 204));
        Title3.setText("Assumptions");

        Title4.setFont(new java.awt.Font("Franklin Gothic Heavy", 2, 24)); // NOI18N
        Title4.setForeground(new java.awt.Color(51, 0, 204));
        Title4.setText("Optional");

        AmountLabel11.setFont(new java.awt.Font("Franklin Gothic Heavy", 2, 18)); // NOI18N
        AmountLabel11.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        AmountLabel11.setText("<html>\nOther income <br> After Retirement\n</html>");

        OIARField.setText("0");

        AmountLabel12.setFont(new java.awt.Font("Franklin Gothic Heavy", 2, 18)); // NOI18N
        AmountLabel12.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        AmountLabel12.setText("Investment Return");

        AmountLabel13.setFont(new java.awt.Font("Franklin Gothic Heavy", 2, 18)); // NOI18N
        AmountLabel13.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        AmountLabel13.setText("Future Savings");

        FutureField.setText("10");

        CurrentField.setText("30,000");

        FutureComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "%", "$" }));
        FutureComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                FutureComboBoxActionPerformed(evt);
            }
        });

        AmountLabel14.setFont(new java.awt.Font("Franklin Gothic Heavy", 2, 18)); // NOI18N
        AmountLabel14.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        AmountLabel14.setText("$");

        AmountLabel15.setFont(new java.awt.Font("Franklin Gothic Heavy", 2, 18)); // NOI18N
        AmountLabel15.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        AmountLabel15.setText("$");

        AmountLabel16.setFont(new java.awt.Font("Franklin Gothic Heavy", 2, 18)); // NOI18N
        AmountLabel16.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        AmountLabel16.setText("$");

        AmountLabel17.setFont(new java.awt.Font("Franklin Gothic Heavy", 2, 18)); // NOI18N
        AmountLabel17.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        AmountLabel17.setText("%/year");

        AmountLabel18.setFont(new java.awt.Font("Franklin Gothic Heavy", 2, 18)); // NOI18N
        AmountLabel18.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        AmountLabel18.setText("%/year");

        INARLabelTrailing.setFont(new java.awt.Font("Franklin Gothic Heavy", 2, 18)); // NOI18N
        INARLabelTrailing.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        INARLabelTrailing.setText("of current income");

        AmountLabel20.setFont(new java.awt.Font("Franklin Gothic Heavy", 2, 18)); // NOI18N
        AmountLabel20.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        AmountLabel20.setText("%/year");

        FutureLabelTrailing.setFont(new java.awt.Font("Franklin Gothic Heavy", 2, 18)); // NOI18N
        FutureLabelTrailing.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        FutureLabelTrailing.setText("of current income");

        AmountLabel22.setFont(new java.awt.Font("Franklin Gothic Heavy", 2, 18)); // NOI18N
        AmountLabel22.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        AmountLabel22.setText("/month");

        WarningLabel.setForeground(new java.awt.Color(255, 51, 51));
        WarningLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

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

        javax.swing.GroupLayout HowMuchLayout = new javax.swing.GroupLayout(HowMuch);
        HowMuch.setLayout(HowMuchLayout);
        HowMuchLayout.setHorizontalGroup(
            HowMuchLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, HowMuchLayout.createSequentialGroup()
                .addGroup(HowMuchLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(HowMuchLayout.createSequentialGroup()
                        .addGap(44, 44, 44)
                        .addGroup(HowMuchLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(HowMuchLayout.createSequentialGroup()
                                .addGroup(HowMuchLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, HowMuchLayout.createSequentialGroup()
                                        .addComponent(AmountLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(RetireAgeField))
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, HowMuchLayout.createSequentialGroup()
                                        .addComponent(AmountLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(LifeExpField, javax.swing.GroupLayout.PREFERRED_SIZE, 189, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(SuperClearButton, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(HowMuchLayout.createSequentialGroup()
                                .addComponent(AmountLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(CurrentAgeField, javax.swing.GroupLayout.PREFERRED_SIZE, 189, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(CalculateButton, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(73, 73, 73))))
                    .addGroup(HowMuchLayout.createSequentialGroup()
                        .addGap(0, 117, Short.MAX_VALUE)
                        .addComponent(WarningLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 639, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(61, 61, 61))
            .addGroup(HowMuchLayout.createSequentialGroup()
                .addGroup(HowMuchLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(HowMuchLayout.createSequentialGroup()
                        .addGap(35, 35, 35)
                        .addComponent(AmountLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(AmountLabel16)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(PrecomeField, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(AmountLabel4)
                        .addGap(123, 123, 123)
                        .addComponent(ResetButton, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(HowMuchLayout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addGroup(HowMuchLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(AmountLabel11, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(AmountLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(AmountLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(AmountLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(AmountLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(AmountLabel6, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(AmountLabel13, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(HowMuchLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(HowMuchLayout.createSequentialGroup()
                                .addGap(6, 6, 6)
                                .addComponent(FutureField, javax.swing.GroupLayout.PREFERRED_SIZE, 183, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(FutureComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(FutureLabelTrailing))
                            .addGroup(HowMuchLayout.createSequentialGroup()
                                .addComponent(IncreaseField, javax.swing.GroupLayout.PREFERRED_SIZE, 189, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(AmountLabel17))
                            .addGroup(HowMuchLayout.createSequentialGroup()
                                .addComponent(InvestField, javax.swing.GroupLayout.PREFERRED_SIZE, 189, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(AmountLabel18))
                            .addGroup(HowMuchLayout.createSequentialGroup()
                                .addComponent(InflateField, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(AmountLabel20))
                            .addGroup(HowMuchLayout.createSequentialGroup()
                                .addComponent(AmountLabel14)
                                .addGap(18, 18, 18)
                                .addComponent(CurrentField, javax.swing.GroupLayout.PREFERRED_SIZE, 189, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(HowMuchLayout.createSequentialGroup()
                                .addComponent(AmountLabel15)
                                .addGap(18, 18, 18)
                                .addComponent(OIARField, javax.swing.GroupLayout.PREFERRED_SIZE, 189, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(AmountLabel22))
                            .addGroup(HowMuchLayout.createSequentialGroup()
                                .addComponent(INARField, javax.swing.GroupLayout.PREFERRED_SIZE, 189, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(INARComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(HowMuchLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(ClearButton, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(INARLabelTrailing)))))
                    .addGroup(HowMuchLayout.createSequentialGroup()
                        .addGap(167, 167, 167)
                        .addComponent(Title3))
                    .addGroup(HowMuchLayout.createSequentialGroup()
                        .addGap(190, 190, 190)
                        .addComponent(Title4)))
                .addContainerGap(144, Short.MAX_VALUE))
        );
        HowMuchLayout.setVerticalGroup(
            HowMuchLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(HowMuchLayout.createSequentialGroup()
                .addComponent(WarningLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(HowMuchLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(HowMuchLayout.createSequentialGroup()
                        .addGap(2, 2, 2)
                        .addGroup(HowMuchLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(AmountLabel2)
                            .addComponent(CurrentAgeField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(42, 42, 42)
                        .addGroup(HowMuchLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(AmountLabel5)
                            .addComponent(RetireAgeField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(15, 15, 15)
                        .addGroup(HowMuchLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(AmountLabel3)
                            .addComponent(LifeExpField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(HowMuchLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(AmountLabel16)
                            .addComponent(PrecomeField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(AmountLabel4)
                            .addComponent(AmountLabel8))
                        .addComponent(Title3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(HowMuchLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(AmountLabel9)
                            .addComponent(IncreaseField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(AmountLabel17))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(AmountLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, HowMuchLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(CalculateButton, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(HowMuchLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(ClearButton, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(SuperClearButton, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(ResetButton, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(HowMuchLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(INARField, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(INARComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(INARLabelTrailing))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(HowMuchLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(AmountLabel12)
                    .addComponent(InvestField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(AmountLabel18))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(HowMuchLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(AmountLabel10)
                    .addComponent(InflateField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(AmountLabel20))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Title4)
                .addGap(9, 9, 9)
                .addGroup(HowMuchLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(AmountLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(AmountLabel15)
                    .addComponent(OIARField, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(AmountLabel22))
                .addGap(18, 18, 18)
                .addGroup(HowMuchLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(AmountLabel6)
                    .addComponent(AmountLabel14)
                    .addComponent(CurrentField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(HowMuchLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(AmountLabel13)
                    .addComponent(FutureField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(FutureComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(FutureLabelTrailing))
                .addContainerGap(14, Short.MAX_VALUE))
        );

        RetirementTabs.addTab("How much do you need to retire?", HowMuch);

        OutputLabel.setFont(new java.awt.Font("HP Simplified Jpan", 1, 12)); // NOI18N

        TitleLabel.setFont(new java.awt.Font("HP Simplified", 3, 18)); // NOI18N

        TitleLabel1.setFont(new java.awt.Font("HP Simplified", 3, 18)); // NOI18N

        OutputLabel1.setFont(new java.awt.Font("HP Simplified Jpan", 1, 12)); // NOI18N

        javax.swing.GroupLayout ResultTabLayout = new javax.swing.GroupLayout(ResultTab);
        ResultTab.setLayout(ResultTabLayout);
        ResultTabLayout.setHorizontalGroup(
            ResultTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ResultTabLayout.createSequentialGroup()
                .addContainerGap(273, Short.MAX_VALUE)
                .addGroup(ResultTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, ResultTabLayout.createSequentialGroup()
                        .addComponent(TitleLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 438, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(106, 106, 106))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, ResultTabLayout.createSequentialGroup()
                        .addGroup(ResultTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(OutputLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 241, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(OutputLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 241, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(209, 209, 209))))
            .addGroup(ResultTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, ResultTabLayout.createSequentialGroup()
                    .addContainerGap(287, Short.MAX_VALUE)
                    .addComponent(TitleLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 438, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(92, 92, 92)))
        );
        ResultTabLayout.setVerticalGroup(
            ResultTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ResultTabLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(TitleLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(OutputLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(102, 102, 102)
                .addComponent(OutputLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(396, Short.MAX_VALUE))
            .addGroup(ResultTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(ResultTabLayout.createSequentialGroup()
                    .addGap(145, 145, 145)
                    .addComponent(TitleLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(429, Short.MAX_VALUE)))
        );

        RetirementTabs.addTab("Results", ResultTab);

        Title1.setFont(new java.awt.Font("Franklin Gothic Heavy", 2, 48)); // NOI18N
        Title1.setForeground(new java.awt.Color(51, 0, 204));
        Title1.setText("Retirement Calculator");

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
                .addComponent(RetirementTabs, javax.swing.GroupLayout.PREFERRED_SIZE, 817, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(QuitButton, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(Title1, javax.swing.GroupLayout.PREFERRED_SIZE, 513, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(127, 127, 127))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Title1)
                    .addComponent(QuitButton, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(42, 42, 42)
                .addComponent(RetirementTabs, javax.swing.GroupLayout.PREFERRED_SIZE, 644, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void CalculateButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CalculateButtonActionPerformed
        CalculateFunction();
        RetirementTabs.setSelectedComponent(ResultTab);
    }//GEN-LAST:event_CalculateButtonActionPerformed

    private void ClearButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ClearButtonMouseClicked
        Component focusedComponent = KeyboardFocusManager.getCurrentKeyboardFocusManager().getFocusOwner();
        if (focusedComponent instanceof JTextField) {
            ((JTextField) focusedComponent).setText("");
        }
    }//GEN-LAST:event_ClearButtonMouseClicked

    private void SuperClearButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_SuperClearButtonMouseClicked
        RetirementHelper.clearAllTextFields(HowMuch);
        lastFocusedField = null;
    }//GEN-LAST:event_SuperClearButtonMouseClicked

    private void QuitButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_QuitButtonMouseClicked
        this.dispose();
    }//GEN-LAST:event_QuitButtonMouseClicked

    private void ClearButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ClearButtonActionPerformed
         if (lastFocusedField != null) {
                    lastFocusedField.setText("");  // Clear the content of the last focused text field
                    lastFocusedField = null;
                } else {
                    JOptionPane.showMessageDialog(null, "No text field was selected!");
                }
    }//GEN-LAST:event_ClearButtonActionPerformed

    private void FutureComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_FutureComboBoxActionPerformed
        if ("$".equals(FutureComboBox.getSelectedItem().toString())) {
            FutureLabelTrailing.setText("/year");
            if (Futurepercent) {
            if (MainHelper.isValidNumber(FutureField.getText())) {
                Float f = Float.valueOf(FutureField.getText());
                f *= 700;
                if (f < 1 && f != 0) {
                   FutureField.setText("1"); 
                }
                else {
                    FutureField.setText(String.valueOf(f));
                }
                
            }
            else {
                FutureField.setText("7,000");
            }
            Futurepercent = false;
            }
        }
        else {
            FutureLabelTrailing.setText("of current income");
            if (!Futurepercent){
            if (MainHelper.validate_money(FutureField.getText(), allow_foreign)) {
                Float f = MainHelper.parseMoney(FutureField.getText(), ",");
                f /= 700;
                FutureField.setText(String.valueOf(f));
                
            }
            else {
                FutureField.setText("10");
            }
            Futurepercent = true;
            }
        }
        
    }//GEN-LAST:event_FutureComboBoxActionPerformed

    private void ResetButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ResetButtonMouseClicked
        LifeExpField.setText("85");

        CurrentAgeField.setText("35");

        PrecomeField.setText("70,000");

        IncreaseField.setText("3");

        RetireAgeField.setText("67");

        InvestField.setText("6");

        InflateField.setText("3");

        INARField.setText("75");
        
        FutureField.setText("10");

        CurrentField.setText("30,000");
        
        OIARField.setText("0");
        
        INARComboBox.setSelectedItem("%");
        
        FutureComboBox.setSelectedItem("%");
    }//GEN-LAST:event_ResetButtonMouseClicked

    private void INARComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_INARComboBoxActionPerformed
        if ("$".equals(INARComboBox.getSelectedItem().toString())) {
            INARLabelTrailing.setText("/year (today's money)");
            if (INARpercent) {
                if (MainHelper.isValidNumber(INARField.getText())) {
                Float f = Float.valueOf(INARField.getText());
                f *= 700;
                if (f < 1 && f != 0) {
                   INARField.setText("1"); 
                }
                else {
                    INARField.setText(String.valueOf(f));
                }
                
            }
            else {
                INARField.setText("52,500");
            }
                INARpercent = false;
            }
            
        }
        else {
            INARLabelTrailing.setText("of current income");
            if (!INARpercent){
            INARpercent = true;
            if (MainHelper.validate_money(INARField.getText(), allow_foreign)) {
                Float f = MainHelper.parseMoney(INARField.getText(), ",");
                f /= 700;
                INARField.setText(String.valueOf(f));
                
            }
            else {
                INARField.setText("75");
            }
            }
        }
    }//GEN-LAST:event_INARComboBoxActionPerformed

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
            java.util.logging.Logger.getLogger(RetirementCalculator.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(RetirementCalculator.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(RetirementCalculator.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(RetirementCalculator.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new RetirementCalculator().setVisible(true);
            }
        });
    }
    
    private void CalculateFunction() {
        Boolean IRisPercent = "%".equals(INARComboBox.getSelectedItem().toString());
        getOptionals();
        String groupingseperator = ",";
        int CA = Integer.parseInt(CurrentAgeField.getText());
        int RA = Integer.parseInt(RetireAgeField.getText());
        int LE = Integer.parseInt(LifeExpField.getText());
        float PIT = MainHelper.parseMoney(PrecomeField.getText(), groupingseperator);
        float Increase = MainHelper.parseMoney(IncreaseField.getText(), groupingseperator) / 100;
        float INAR = RetirementHelper.parseDynamic(INARField.getText(), "%".equals(INARComboBox.getSelectedItem().toString()));
        float Invest = MainHelper.parseMoney(InvestField.getText(), ",") / 100;
        float Inflate = MainHelper.parseMoney(InflateField.getText(), ",") / 100;
        int RY = LE - RA;
        int LY = RA - CA;
        float FIN;
        
        if (IRisPercent) {
            FIN = INAR * PIT;
        }
        else {
            FIN = INAR;
        }
        List<Float> NeededRemaining = RetirementHelper.Total_Required_Retirement_Income(FIN, RY, OIAR, Invest, PIT);
        float final_needed = NeededRemaining.get(NeededRemaining.size()-1);
        List<Integer> TORI = RetirementHelper.Total_Obtained_Retirement_Income(LY, PIT, Invest, current, future, Increase);
        float final_obtained = TORI.get(TORI.size()-1);
        TitleLabel.setText("YOU WILL NEED:");
        TitleLabel1.setText("YOU WILL HAVE:");
        OutputLabel.setText("$" + MainHelper.formatCurrency(final_obtained));
    }
    
    private void getOptionals() {
        Boolean FutureValid = RetirementHelper.validate_dynamic(FutureField.getText(), "%".equals(FutureComboBox.getSelectedItem()));
        if (FutureValid && "%".equals(FutureComboBox.getSelectedItem())) {
            future = MainHelper.parseMoney(FutureField.getText(), ",") / 100;
        }
        else if (FutureValid) {
            future = MainHelper.parseMoney(FutureField.getText(), ",");
        }
        else {
            future = 0;
        }
        Boolean OIARValid = MainHelper.validate_money(OIARField.getText(), allow_foreign);
        if (OIARValid) {
            OIAR =MainHelper.parseMoney(OIARField.getText(), ",");
        }
        else {
            OIAR = 0;
        }
        Boolean CurrentValid = MainHelper.validate_money(CurrentField.getText(), allow_foreign);
        if (CurrentValid) {
            current = MainHelper.parseMoney(CurrentField.getText(), ",");
        }
        else {
            current = 0;
        }
    }
    
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel AmountLabel10;
    private javax.swing.JLabel AmountLabel11;
    private javax.swing.JLabel AmountLabel12;
    private javax.swing.JLabel AmountLabel13;
    private javax.swing.JLabel AmountLabel14;
    private javax.swing.JLabel AmountLabel15;
    private javax.swing.JLabel AmountLabel16;
    private javax.swing.JLabel AmountLabel17;
    private javax.swing.JLabel AmountLabel18;
    private javax.swing.JLabel AmountLabel2;
    private javax.swing.JLabel AmountLabel20;
    private javax.swing.JLabel AmountLabel22;
    private javax.swing.JLabel AmountLabel3;
    private javax.swing.JLabel AmountLabel4;
    private javax.swing.JLabel AmountLabel5;
    private javax.swing.JLabel AmountLabel6;
    private javax.swing.JLabel AmountLabel7;
    private javax.swing.JLabel AmountLabel8;
    private javax.swing.JLabel AmountLabel9;
    private javax.swing.JButton CalculateButton;
    private javax.swing.JButton ClearButton;
    private javax.swing.JTextField CurrentAgeField;
    private javax.swing.JTextField CurrentField;
    private javax.swing.JComboBox<String> FutureComboBox;
    private javax.swing.JTextField FutureField;
    private javax.swing.JLabel FutureLabelTrailing;
    private javax.swing.JPanel HowMuch;
    private javax.swing.JComboBox<String> INARComboBox;
    private javax.swing.JTextField INARField;
    private javax.swing.JLabel INARLabelTrailing;
    private javax.swing.JTextField IncreaseField;
    private javax.swing.JTextField InflateField;
    private javax.swing.JTextField InvestField;
    private javax.swing.JTextField LifeExpField;
    private javax.swing.JTextField OIARField;
    private javax.swing.JLabel OutputLabel;
    private javax.swing.JLabel OutputLabel1;
    private javax.swing.JTextField PrecomeField;
    private javax.swing.JButton QuitButton;
    private javax.swing.JButton ResetButton;
    private javax.swing.JPanel ResultTab;
    private javax.swing.JTextField RetireAgeField;
    private javax.swing.JTabbedPane RetirementTabs;
    private javax.swing.JButton SuperClearButton;
    private javax.swing.JLabel Title1;
    private javax.swing.JLabel Title3;
    private javax.swing.JLabel Title4;
    private javax.swing.JLabel TitleLabel;
    private javax.swing.JLabel TitleLabel1;
    private javax.swing.JLabel WarningLabel;
    // End of variables declaration//GEN-END:variables
}
