/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package main;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.KeyboardFocusManager;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.io.File;
import java.io.IOException;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.*;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.CategoryAxis;
import org.jfree.chart.axis.CategoryLabelPositions;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;

/**
 *
 * @author Kylind
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
        CalculateFunction();
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
                Boolean c = ((!MainHelper.validate_money(AnnualField.getText(), false)) && !YesRadioButton.isSelected());
                Boolean a = !MainHelper.isValidNumber(ERRField.getText());
                Boolean b = !MainHelper.isValidNumber(TaxField.getText()) || !(Float.parseFloat(TaxField.getText())<100);
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
    
    private void addChartToPanel(List<Integer> RothIRAData, List<Integer> TaxableData, List<Integer> PricipalData, Integer CA) {
        int tabIndex = IRATabs.indexOfTab("Graph");
        if (tabIndex != -1) {
            IRATabs.remove(tabIndex);
        }
        DefaultCategoryDataset dataset = createDataset(RothIRAData, TaxableData, PricipalData, CA);
        
        // Create chart
        JFreeChart chart = ChartFactory.createLineChart(
                "Balance Accumulation Graph",
                "Age",
                "Savings ($)",
                dataset,
                PlotOrientation.VERTICAL,
                true, true, false);
        
        // Customize the chart
        chart.setBackgroundPaint(Color.white);
        
        CategoryPlot plot = (CategoryPlot) chart.getPlot();
        CategoryAxis xAxis = plot.getDomainAxis();
        xAxis.setTickLabelsVisible(true);
        xAxis.setTickMarksVisible(true);
        xAxis.setCategoryLabelPositions(CategoryLabelPositions.UP_45); // Rotate labels for clarity
        xAxis.setMaximumCategoryLabelWidthRatio(1.0f); // Prevent truncation
        xAxis.setCategoryMargin(0.2); // Space between categories

        // Add the chart to a ChartPanel
        ChartPanel chartPanel = new ChartPanel(chart);
        chartPanel.setPreferredSize(new Dimension(350, 240));
        
        // Add the ChartPanel to the existing panel
        IRATabs.addTab("Graph", chartPanel);
    }
    
     private DefaultCategoryDataset createDataset(List<Integer> RothIRADAta, List<Integer> TaxableData, List<Integer> PrincipalData, Integer CA) {
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        
        if (RothIRADAta.size() < 50){
        // Populate dataset
        for (int year = 0; year < RothIRADAta.size(); year++) {
            dataset.addValue(RothIRADAta.get(year), "Roth IRA", Integer.toString(CA+year));
        }
        for (int year = 0; year < TaxableData.size(); year++) {
            dataset.addValue(TaxableData.get(year), "Taxable Account", Integer.toString(CA+year));
        }
        for (int year = 0; year < PrincipalData.size(); year++) {
            dataset.addValue(PrincipalData.get(year), "Principal", Integer.toString(CA+year));
        }
            return dataset;
        }
        else{
        // Populate dataset
        for (int year = 0; year < RothIRADAta.size(); year+=2) {
            dataset.addValue(RothIRADAta.get(year), "Roth IRA", Integer.toString(CA+year));
        }
        for (int year = 0; year < TaxableData.size(); year+=2) {
            dataset.addValue(TaxableData.get(year), "Taxable Account", Integer.toString(CA+year));
        }
        for (int year = 0; year < PrincipalData.size(); year+=2) {
            dataset.addValue(PrincipalData.get(year), "Principal", Integer.toString(CA+year));
        }
            return dataset;
        }
    }
     
     private void addTableToPanel(List<Integer> RothIRADAta, List<Integer> TaxableData, List<Integer> PrincipalData, Integer CA){
         String[] columnNames = {"", "Principal", "Roth IRA", "Taxable account"};
         Object[][] data = new Object[RothIRADAta.size()][4];
         for (int year = 0; year < RothIRADAta.size(); year++) {
             data[year][0] = CA + year;
             data[year][1] = PrincipalData.get(year);
             data[year][2] = RothIRADAta.get(year);
             data[year][3] = TaxableData.get(year);
         }
        DefaultTableModel tableModel = new DefaultTableModel(data, columnNames);
        JTable table = new JTable(tableModel);
        SchedulePanel.setViewportView(table);
         
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
        AmountLabel19 = new javax.swing.JLabel();
        WarningLabel = new javax.swing.JLabel();
        infoBoxLabel = new javax.swing.JLabel();
        infoBoxLabel1 = new javax.swing.JLabel();
        infoBoxLabel2 = new javax.swing.JLabel();
        infoBoxLabel3 = new javax.swing.JLabel();
        ResultPane = new javax.swing.JScrollPane();
        AmountLabel20 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        SchedulePanel = new javax.swing.JScrollPane();
        QuitButton = new javax.swing.JButton();
        infoBoxLabel4 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Title1.setFont(getFontTitle());
        Title1.setForeground(new java.awt.Color(255, 255, 255));
        Title1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Title1.setText("Roth IRA Calculator");
        getContentPane().add(Title1, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 20, 513, -1));

        InputPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        AmountLabel2.setFont(getFontParas());
        AmountLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        AmountLabel2.setText("Current Amount");
        InputPanel.add(AmountLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 50, 130, -1));

        AmountLabel3.setFont(getFontParas());
        AmountLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        AmountLabel3.setText("Annual Contribution");
        InputPanel.add(AmountLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 80, -1, -1));

        AmountLabel4.setFont(getFontParas());
        AmountLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        AmountLabel4.setText("Marginal Tax Rate");
        AmountLabel4.setToolTipText("");
        InputPanel.add(AmountLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 300, 181, -1));

        AmountLabel5.setFont(getFontParas());
        AmountLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        AmountLabel5.setText("Current Age");
        InputPanel.add(AmountLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 220, 161, -1));

        AmountLabel6.setFont(getFontParas());
        AmountLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        AmountLabel6.setText("Retirement Age");
        InputPanel.add(AmountLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 260, 161, -1));

        AmountLabel7.setFont(getFontParas());
        AmountLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        AmountLabel7.setText("<html>Expected Rate<br>of Return</html>");
        InputPanel.add(AmountLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 160, 182, -1));

        AmountLabel8.setFont(getFontParas());
        AmountLabel8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        AmountLabel8.setText("Maximize Contributions?");
        AmountLabel8.setToolTipText("");
        InputPanel.add(AmountLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 120, 229, -1));

        IRAbuttons.add(YesRadioButton);
        YesRadioButton.setText("Yes");
        YesRadioButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                YesRadioButtonActionPerformed(evt);
            }
        });
        InputPanel.add(YesRadioButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 120, 53, -1));

        IRAbuttons.add(NoRadioButton);
        NoRadioButton.setSelected(true);
        NoRadioButton.setText("No");
        NoRadioButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                NoRadioButtonActionPerformed(evt);
            }
        });
        InputPanel.add(NoRadioButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 120, 47, -1));

        CurrentAmountField.setText("20,000");
        InputPanel.add(CurrentAmountField, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 40, 189, -1));

        AnnualField.setText("7,000");
        InputPanel.add(AnnualField, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 80, 189, -1));

        ERRField.setText("6");
        InputPanel.add(ERRField, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 160, 189, 40));

        CurrentAgeField.setText("30");
        InputPanel.add(CurrentAgeField, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 210, 189, -1));

        RetireAgeField.setText("65");
        InputPanel.add(RetireAgeField, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 250, 189, -1));

        TaxField.setText("25");
        InputPanel.add(TaxField, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 300, 189, -1));

        CalculateButton.setBackground(new java.awt.Color(0, 100, 0));
        CalculateButton.setForeground(new java.awt.Color(0, 0, 0));
        CalculateButton.setText("Calculate");
        CalculateButton.setToolTipText("Click to calculate the converted amount.");
        CalculateButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CalculateButtonActionPerformed(evt);
            }
        });
        InputPanel.add(CalculateButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 50, 115, 51));

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
        InputPanel.add(ClearButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 110, 100, 46));

        SuperClearButton.setBackground(new java.awt.Color(255, 255, 255));
        SuperClearButton.setForeground(new java.awt.Color(0, 0, 0));
        SuperClearButton.setText("Clear All");
        SuperClearButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                SuperClearButtonMouseClicked(evt);
            }
        });
        InputPanel.add(SuperClearButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 160, 80, 51));

        ResetButton.setBackground(new java.awt.Color(255, 255, 255));
        ResetButton.setForeground(new java.awt.Color(0, 0, 0));
        ResetButton.setText("Reset");
        ResetButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ResetButtonMouseClicked(evt);
            }
        });
        InputPanel.add(ResetButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 220, 60, 51));

        AmountLabel16.setFont(getFontParas());
        AmountLabel16.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        AmountLabel16.setText("$");
        InputPanel.add(AmountLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 50, -1, -1));

        AmountLabel17.setFont(getFontParas());
        AmountLabel17.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        AmountLabel17.setText("$");
        InputPanel.add(AmountLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 80, 20, -1));

        AmountLabel19.setFont(getFontParas());
        AmountLabel19.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        AmountLabel19.setText("%");
        InputPanel.add(AmountLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 300, -1, -1));

        WarningLabel.setForeground(new java.awt.Color(255, 51, 0));
        WarningLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        InputPanel.add(WarningLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 0, 639, 30));

        infoBoxLabel.setFont(new java.awt.Font("sansserif", 1, 12)); // NOI18N
        infoBoxLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        infoBoxLabel.setText("?");
        infoBoxLabel.setToolTipText("<html><body style='width: 200px;'>The amount you plan to contribute to the Roth IRA account each year. The maximum contribution limit is $7,000 for individuals under the age of 50 and increases to $8,000 for individuals aged 50 and above.</body></html>  ");
        infoBoxLabel.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        infoBoxLabel.setOpaque(true);
        InputPanel.add(infoBoxLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 80, 20, 23));

        infoBoxLabel1.setFont(new java.awt.Font("sansserif", 1, 12)); // NOI18N
        infoBoxLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        infoBoxLabel1.setText("?");
        infoBoxLabel1.setToolTipText("<html><body style='width: 200px;'>Please select 'yes' if you plan to contribute the maximum allowed amount each year. The maximum contribution limit is $6,500 before the age of 50 and increases to $7,500 after the age of 50.</body></html>  ");
        infoBoxLabel1.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        infoBoxLabel1.setOpaque(true);
        InputPanel.add(infoBoxLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 120, 20, 23));

        infoBoxLabel2.setFont(new java.awt.Font("sansserif", 1, 12)); // NOI18N
        infoBoxLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        infoBoxLabel2.setText("?");
        infoBoxLabel2.setToolTipText("<html><body style='width: 200px;'>The expected average annual return you will earn on your money in the account.</body></html>  ");
        infoBoxLabel2.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        infoBoxLabel2.setOpaque(true);
        InputPanel.add(infoBoxLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 170, 20, 23));

        infoBoxLabel3.setFont(new java.awt.Font("sansserif", 1, 12)); // NOI18N
        infoBoxLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        infoBoxLabel3.setText("?");
        infoBoxLabel3.setToolTipText("<html><body style='width: 200px;''>The tax rate you pay on additional income. Please includes the combined federal and state/local marginal tax rates, if applicable.</body></html>  ");
        infoBoxLabel3.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        infoBoxLabel3.setOpaque(true);
        InputPanel.add(infoBoxLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 300, 20, 23));
        InputPanel.add(ResultPane, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 390, 528, 109));

        AmountLabel20.setFont(getFontParas());
        AmountLabel20.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        AmountLabel20.setText("%");
        InputPanel.add(AmountLabel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 170, -1, -1));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/RothIRA.png"))); // NOI18N
        InputPanel.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 720, 500));

        IRATabs.addTab("Input", InputPanel);
        IRATabs.addTab("Annual Schedule", SchedulePanel);

        getContentPane().add(IRATabs, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 79, 720, 530));

        QuitButton.setBackground(new java.awt.Color(255, 255, 255));
        QuitButton.setForeground(new java.awt.Color(0, 0, 0));
        QuitButton.setText("Return");
        QuitButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                QuitButtonMouseClicked(evt);
            }
        });
        getContentPane().add(QuitButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 20, 74, 38));

        infoBoxLabel4.setFont(new java.awt.Font("sansserif", 1, 12)); // NOI18N
        infoBoxLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        infoBoxLabel4.setText("?");
        infoBoxLabel4.setToolTipText("<html><body style='width: 200px;'>A Roth IRA is a type of Individual Retirement Arrangement (IRA) that provides tax-free growth and tax-free income in retirement. The major difference between Roth IRAs and traditional IRAs is that contributions to the former are not tax-deductible, and contributions (not earnings) may be withdrawn tax-free at any time without penalty. Roth IRA was first introduced and established by the Taxpayer Relief Act of 1997 and is named after Senator William Roth.</body></html>  ");
        infoBoxLabel4.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        infoBoxLabel4.setOpaque(true);
        getContentPane().add(infoBoxLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 30, 20, 23));
        infoBoxLabel4.getAccessibleContext().setAccessibleDescription("<html><body style='width: 200px;'>A Roth IRA is a type of Individual Retirement Arrangement (IRA) that provides tax-free growth and tax-free income in retirement. The major difference between Roth IRAs and traditional IRAs is that contributions to the former are not tax-deductible, and contributions (not earnings) may be withdrawn tax-free at any time without penalty. Roth IRA was first introduced and established by the Taxpayer Relief Act of 1997 and is named after Senator William Roth.</body></html>  ");

        jLabel1.setBackground(new java.awt.Color(11, 56, 79));
        jLabel1.setOpaque(true);
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 720, 110));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void QuitButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_QuitButtonMouseClicked
        this.dispose();
    }//GEN-LAST:event_QuitButtonMouseClicked

    private void ResetButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ResetButtonMouseClicked
        Yes = false;
        No = true;
        AnnualField.setEditable(true);
        AnnualField.setFocusable(true);
        CurrentAmountField.setText("20,000");
        AnnualField.setText("7,000");
        ERRField.setText("6");
        YesRadioButton.setSelected(false);
        NoRadioButton.setSelected(true);
        CurrentAgeField.setText("30");
        RetireAgeField.setText("65");
        TaxField.setText("25");
    }//GEN-LAST:event_ResetButtonMouseClicked

    private void SuperClearButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_SuperClearButtonMouseClicked
        RetirementHelper.clearAllTextFields(InputPanel);
        lastFocusedField = null;
        if (YesRadioButton.isSelected()) {
            AnnualField.setText("Maximized");
        }
    }//GEN-LAST:event_SuperClearButtonMouseClicked

    private void ClearButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ClearButtonActionPerformed
        if (lastFocusedField != null && !(lastFocusedField == AnnualField && YesRadioButton.isSelected())) {
            lastFocusedField.setText("");  // Clear the content of the last focused text field
            lastFocusedField = null;
        } else {
            JOptionPane.showMessageDialog(null, "No text field was selected!");
        }
    }//GEN-LAST:event_ClearButtonActionPerformed

    private void ClearButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ClearButtonMouseClicked
        Component focusedComponent = KeyboardFocusManager.getCurrentKeyboardFocusManager().getFocusOwner();
        if (focusedComponent instanceof JTextField) {
            ((JTextField) focusedComponent).setText("");
        }
    }//GEN-LAST:event_ClearButtonMouseClicked

    private void CalculateButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CalculateButtonActionPerformed
        CalculateFunction();
    }//GEN-LAST:event_CalculateButtonActionPerformed

    private void NoRadioButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_NoRadioButtonActionPerformed
        if (No == false){
            AnnualField.setEditable(true);
            AnnualField.setFocusable(true);
            AnnualField.setText(lastsavedannual);
            AmountLabel17.setVisible(true);
            Yes = false;
            No = true;
        }
    }//GEN-LAST:event_NoRadioButtonActionPerformed

    private void YesRadioButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_YesRadioButtonActionPerformed
        if (Yes == false){
            lastsavedannual = AnnualField.getText();
            AnnualField.setEditable(false);
            AnnualField.setFocusable(false);
            AnnualField.setText("Maximized");
            AmountLabel17.setVisible(false);
            Yes = true;
            No = false;
        }
    }//GEN-LAST:event_YesRadioButtonActionPerformed

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
    
    public void CalculateFunction() {
        float balance = MainHelper.parseMoney(CurrentAmountField.getText(), ",");
        String temp = AnnualField.getText();
        float annual;
        if (!"Maximized".equals(temp)){
            annual = MainHelper.parseMoney(temp, ",");
            if (annual > 7000) {
                WarningLabel.setText("Annual contribution greater than limit ($7000) so was adjusted");
                annual = 7000;
            }
        }
        else{
            annual = 8000;
        }
        int CA = Integer.parseInt(CurrentAgeField.getText());
        int RA = Integer.parseInt(RetireAgeField.getText());
        int years = RA-CA;
        float ERR = MainHelper.parseMoney(ERRField.getText(),",")/100;
        float taxes = MainHelper.parseMoney(TaxField.getText(),",")/100;
        List<Integer> RothIRABalance = RothIRAHelper.Roth_IRA(years, CA, annual, ERR, balance);
        List<Integer> Principal = RothIRAHelper.Principal(years, CA, annual, balance);
        List<Integer> Taxable = RothIRAHelper.TaxableAccount(years, CA, annual, ERR, balance, taxes);
        Integer  final_principal = Principal.get(Principal.size()-1);
        Integer final_IRA = RothIRABalance.get(RothIRABalance.size()-1);
        Integer final_Taxable = Taxable.get(Taxable.size()-1);
        Integer total_taxes = RothIRAHelper.Total_Taxes(years, CA, annual, ERR, balance, taxes);
        Integer total_interest = RothIRAHelper.Total_Interest(years, CA, annual, ERR, balance);
        Integer total_tax_interest = RothIRAHelper.Total_Tax_Interest(years, CA, annual, ERR, balance, taxes);
        System.out.println(RothIRABalance);
        String[] columnNames = {"", "Roth IRA", "Taxable account"};
        Object[][] data = {{"Balance at age "+String.valueOf(RA),"$"+MainHelper.formatCurrency(final_IRA),"$"+MainHelper.formatCurrency(final_Taxable) },{"Total principal","$"+MainHelper.formatCurrency(final_principal), "$"+MainHelper.formatCurrency(final_principal)}, {"Total interest", "$"+MainHelper.formatCurrency(total_interest), "$"+MainHelper.formatCurrency(total_tax_interest)}, {"Total Tax", "$0","$"+MainHelper.formatCurrency(total_taxes)}};
        DefaultTableModel tableModel = new DefaultTableModel(data, columnNames);
        JTable table = new JTable(tableModel);
        // Add the table to the existing scroll pane
        ResultPane.setViewportView(table);
        addChartToPanel(RothIRABalance, Taxable, Principal, CA);
        addTableToPanel(RothIRABalance, Taxable, Principal, CA);
    }
    
    public Font getFontTitle() {
        try {
            Font customFont = Font.createFont(Font.TRUETYPE_FONT, new File("src/fonts/Nunito-VariableFont_wght.ttf"));
            customFont = customFont.deriveFont(Font.BOLD, 36);
            return customFont;
        } catch (FontFormatException | IOException e) {
           Font customFont = new java.awt.Font("Arial Unicode MS", java.awt.Font.BOLD, 36);
            customFont = customFont.deriveFont(18f); // Set the desired size
            return customFont;
        }

    }
     public Font getFontParas() {
        try {
            Font customFont = Font.createFont(Font.TRUETYPE_FONT, new File("src/fonts/Nunito-VariableFont_wght.ttf"));
            customFont = customFont.deriveFont(Font.PLAIN, 18);
            return customFont;
        } catch (FontFormatException | IOException e) {
           Font customFont = new java.awt.Font("Arial Unicode MS", java.awt.Font.PLAIN, 18);
            customFont = customFont.deriveFont(18f); // Set the desired size
            return customFont;
        }
     }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel AmountLabel16;
    private javax.swing.JLabel AmountLabel17;
    private javax.swing.JLabel AmountLabel19;
    private javax.swing.JLabel AmountLabel2;
    private javax.swing.JLabel AmountLabel20;
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
    private javax.swing.JTabbedPane IRATabs;
    private javax.swing.ButtonGroup IRAbuttons;
    private javax.swing.JPanel InputPanel;
    private javax.swing.JRadioButton NoRadioButton;
    private javax.swing.JButton QuitButton;
    private javax.swing.JButton ResetButton;
    private javax.swing.JScrollPane ResultPane;
    private javax.swing.JTextField RetireAgeField;
    private javax.swing.JScrollPane SchedulePanel;
    private javax.swing.JButton SuperClearButton;
    private javax.swing.JTextField TaxField;
    private javax.swing.JLabel Title1;
    private javax.swing.JLabel WarningLabel;
    private javax.swing.JRadioButton YesRadioButton;
    private javax.swing.JLabel infoBoxLabel;
    private javax.swing.JLabel infoBoxLabel1;
    private javax.swing.JLabel infoBoxLabel2;
    private javax.swing.JLabel infoBoxLabel3;
    private javax.swing.JLabel infoBoxLabel4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    // End of variables declaration//GEN-END:variables
}
