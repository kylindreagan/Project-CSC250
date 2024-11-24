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
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import java.util.List;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;
import java.awt.GridBagConstraints;
import java.io.File;
import java.io.IOException;
import java.util.Collections;
import org.jfree.chart.axis.CategoryAxis;
import org.jfree.chart.axis.CategoryLabelPositions;
import org.jfree.chart.plot.CategoryPlot;



/**
 *
 * @author kylind
 */
public class RetirementCalculator extends javax.swing.JFrame {
    
    private Boolean INARpercent;
    private Boolean Futurepercent;
    private static JTextField lastFocusedField = null;  // Variable to track last focused JTextField
    private static JTextField lastFocusedField1 = null;
    private static JTextField lastFocusedField2 = null;
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
        addChartToPanel(Collections.emptyList(), Collections.emptyList(), null, false, "Savings", "Needed");
        setResizable(false);
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
        
        FocusListener focusListenerLastFocused1 = new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                // Record the last focused JTextField
                lastFocusedField1 = (JTextField) e.getComponent();
            }

            @Override
            public void focusLost(FocusEvent e) {
                // Do nothing when focus is lost
            }
        };
        
        CurrentAgeField1.addFocusListener(focusListenerLastFocused1);
        CurrentField1.addFocusListener(focusListenerLastFocused1);
        RetireAgeField1.addFocusListener(focusListenerLastFocused1);
        NeededField.addFocusListener(focusListenerLastFocused1);
        InvestField1.addFocusListener(focusListenerLastFocused1);
        
        FocusListener focusListenerLastFocused2 = new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                // Record the last focused JTextField
                lastFocusedField2 = (JTextField) e.getComponent();
            }

            @Override
            public void focusLost(FocusEvent e) {
                // Do nothing when focus is lost
            }
        };
        
        CurrentAgeField2.addFocusListener(focusListenerLastFocused2);
        CurrentField2.addFocusListener(focusListenerLastFocused2);
        RetireAgeField2.addFocusListener(focusListenerLastFocused2);
        LifeExpField1.addFocusListener(focusListenerLastFocused2);
        AnnualField.addFocusListener(focusListenerLastFocused2);
        MonthlyField.addFocusListener(focusListenerLastFocused2);
        InflateField1.addFocusListener(focusListenerLastFocused2);
        InvestField2.addFocusListener(focusListenerLastFocused2);
        
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
        
        DocumentListener documentListener1 = new DocumentListener() { 
            @Override
            public void insertUpdate(DocumentEvent e) { checkFields(); }
            @Override
            public void removeUpdate(DocumentEvent e) { checkFields(); }
            @Override
            public void changedUpdate(DocumentEvent e) { checkFields(); }
            private void checkFields() {
                String RA = RetireAgeField1.getText();
                String CA = CurrentAgeField1.getText();
                Boolean ValidAge = RetirementHelper.validate_ages(RA, CA, "150");
                if (!ValidAge){
                CalculateButton2.setEnabled(false);
                String message = RetirementHelper.generate_age_warning(RA, CA, "150");
                WarningLabel1.setText(message); 
                RetireAgeField1.setForeground(Color.red);
                CurrentAgeField1.setForeground(Color.red);
            }
                else{
                    RetireAgeField1.setForeground(Color.black);
                    CurrentAgeField1.setForeground(Color.black);
                    Boolean x = !MainHelper.validate_money(CurrentField1.getText(), false);
                    Boolean y = !MainHelper.validate_money(NeededField.getText(), false);
                    if (x||y){
                        CalculateButton2.setEnabled(false);
                        if (y) {
                            NeededField.setForeground(Color.red);
                            WarningLabel1.setText("⚠ Invalid Amount Needed at Retirement Age.");
                        }
                        else {
                            NeededField.setForeground(Color.black);
                            CurrentField1.setForeground(Color.red);
                            WarningLabel1.setText("⚠ Invalid Current Amount.");
                        }
                    }
                    else {
                        NeededField.setForeground(Color.black);
                        CurrentField1.setForeground(Color.black);
                        if (!MainHelper.isValidNumber(InvestField1.getText())){
                            CalculateButton2.setEnabled(false);
                            InvestField1.setForeground(Color.red);
                            WarningLabel1.setText("⚠ Invalid Investment Returns.");
                            
                        }
                        else {
                            CalculateButton2.setEnabled(true);
                            WarningLabel1.setText("");
                            InvestField1.setForeground(Color.black);
                        }
                    }
                }
                
           }
        };
        CurrentAgeField1.getDocument().addDocumentListener(documentListener1);
        RetireAgeField1.getDocument().addDocumentListener(documentListener1);
        NeededField.getDocument().addDocumentListener(documentListener1);
        InvestField1.getDocument().addDocumentListener(documentListener1);
        CurrentField1.getDocument().addDocumentListener(documentListener1);
        
        
          DocumentListener documentListener2 = new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) { checkFields(); }
            @Override
            public void removeUpdate(DocumentEvent e) { checkFields(); }
            @Override
            public void changedUpdate(DocumentEvent e) { checkFields(); }
            private void checkFields() { 
                String RA = RetireAgeField2.getText();
                String CA = CurrentAgeField2.getText();
                String LE = LifeExpField1.getText();
               
                Boolean ValidAge = RetirementHelper.validate_ages(RA, CA, LE);
                if (!ValidAge){
                CalculateButton3.setEnabled(false);
                String message = RetirementHelper.generate_age_warning(RA, CA, LE);
                WarningLabel2.setText(message); 
                RetireAgeField2.setForeground(Color.red);
                CurrentAgeField2.setForeground(Color.red);
                LifeExpField1.setForeground(Color.red);
            }
            else {
                RetireAgeField2.setForeground(Color.black);
                CurrentAgeField2.setForeground(Color.black);
                LifeExpField1.setForeground(Color.black);
                
                Boolean x = !MainHelper.validate_money(AnnualField.getText(), false);
                Boolean y = !MainHelper.validate_money(CurrentField2.getText(), false);
                Boolean a = !MainHelper.validate_money(MonthlyField.getText(), false);
                Boolean b = !MainHelper.isValidNumber(InvestField2.getText());
                Boolean c = !MainHelper.isValidNumber(InflateField1.getText());
                if (x||y||a||b||c)
                {
                    CalculateButton3.setEnabled(true);
                    if (c){
                        InflateField1.setForeground(Color.red);
                        WarningLabel2.setText("⚠ Invalid Inflation Rate.");
                    }
                    if (b){
                        InflateField1.setForeground(Color.black);
                        InvestField2.setForeground(Color.red);
                        WarningLabel2.setText("⚠ Invalid Investment Returns.");
                    }
                    if(a){
                        InflateField1.setForeground(Color.black);
                        InvestField2.setForeground(Color.black);
                         MonthlyField.setForeground(Color.red);
                         WarningLabel2.setText("⚠ Invalid Monthly Contribution.");
                         
                    }
                    if(x){
                        InflateField1.setForeground(Color.black);
                        InvestField2.setForeground(Color.black);
                        MonthlyField.setForeground(Color.black);
                        AnnualField.setForeground(Color.red);
                         WarningLabel2.setText("⚠ Invalid Annual Contribution.");
                    }
                    if (y){
                        InflateField1.setForeground(Color.black);
                        InvestField2.setForeground(Color.black);
                        MonthlyField.setForeground(Color.black);
                        AnnualField.setForeground(Color.black);
                        CurrentField2.setForeground(Color.red);
                        WarningLabel2.setText("⚠ Invalid Current Amount.");
                    }
                }
                else{
                    AnnualField.setForeground(Color.black);
                    CurrentField2.setForeground(Color.black);
                    MonthlyField.setForeground(Color.black);
                    InvestField2.setForeground(Color.black);
                    InflateField1.setForeground(Color.black);
                    WarningLabel2.setText("");
                    CalculateButton3.setEnabled(true);
                }
                }
                
                
            
            }

          };
          
        CurrentAgeField2.getDocument().addDocumentListener(documentListener2);
        RetireAgeField2.getDocument().addDocumentListener(documentListener2);
        LifeExpField1.getDocument().addDocumentListener(documentListener2);
        InvestField2.getDocument().addDocumentListener(documentListener2);
        InflateField1.getDocument().addDocumentListener(documentListener2);
        AnnualField.getDocument().addDocumentListener(documentListener2);
        MonthlyField.getDocument().addDocumentListener(documentListener2);
        CurrentField2.getDocument().addDocumentListener(documentListener2);
        
    }
    
    private void addChartToPanel(List<Integer> savingsData, List<Integer> neededData, Integer CA, Boolean two_graphs, String title_1, String title_2) {
        Graph.removeAll(); // Clear previous charts or components
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0; // Column index
        gbc.gridy = 0; // Row index
        gbc.weightx = 1.0; // Stretch horizontally
        gbc.weighty = 1.0; // Stretch vertically
        gbc.fill = GridBagConstraints.BOTH; // Fill both horizontally and vertically
        
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();;
        
        // Check if data exists, and fill the dataset only if valid data is provided
        if (savingsData != null && !savingsData.isEmpty() && neededData != null && !neededData.isEmpty()) {
            dataset = createDataset(savingsData, neededData, CA, two_graphs, title_1, title_2);
        }
        
        // Create chart
        JFreeChart chart = ChartFactory.createLineChart(
                "Projected Retirement Savings Over Time",
                "Year",
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
        chartPanel.setPreferredSize(new Dimension(800, 600));
        
        // Add the ChartPanel to the existing panel
        Graph.add(chartPanel, gbc);
        
        // Refresh the panel to show the new component
        Graph.validate();
    }
    
     private DefaultCategoryDataset createDataset(List<Integer> savingsData, List<Integer> neededData, Integer CA, Boolean two_graphs, String title_1, String title_2) {
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        
        if (savingsData.size() < 80) {
        // Populate dataset
        for (int year = 0; year < savingsData.size(); year++) {
            dataset.addValue(savingsData.get(year), title_1, Integer.toString(CA+year));
        }
        
        if (two_graphs){
        for (int year = 0; year < savingsData.size(); year++) {
            dataset.addValue(neededData.get(year), title_2, Integer.toString(CA+year));
        }
        }
        }
        else if (savingsData.size() < 120){
            // Populate dataset
        for (int year = 0; year < savingsData.size(); year+=2) {
            dataset.addValue(savingsData.get(year), title_1, Integer.toString(CA+year));
        }
        
        if (two_graphs){
        for (int year = 0; year < savingsData.size(); year+=2) {
            dataset.addValue(neededData.get(year), title_2, Integer.toString(CA+year));
        }
        }
        }
        else {
           for (int year = 0; year < savingsData.size(); year+=5) {
            dataset.addValue(savingsData.get(year), title_1, Integer.toString(CA+year));
        }
        
        if (two_graphs){
        for (int year = 0; year < savingsData.size(); year+=5) {
            dataset.addValue(neededData.get(year), title_2, Integer.toString(CA+year));
        }
        } 
        }

        return dataset;
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
        infoBoxLabel = new javax.swing.JLabel();
        infoBoxLabel1 = new javax.swing.JLabel();
        infoBoxLabel2 = new javax.swing.JLabel();
        Title5 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        HowTo = new javax.swing.JPanel();
        CalculateButton2 = new javax.swing.JButton();
        ClearButton1 = new javax.swing.JButton();
        SuperClearButton1 = new javax.swing.JButton();
        ResetButton1 = new javax.swing.JButton();
        AmountLabel19 = new javax.swing.JLabel();
        CurrentAgeField1 = new javax.swing.JTextField();
        AmountLabel21 = new javax.swing.JLabel();
        RetireAgeField1 = new javax.swing.JTextField();
        AmountLabel23 = new javax.swing.JLabel();
        CurrentField1 = new javax.swing.JTextField();
        DollarSign = new javax.swing.JLabel();
        AmountLabel24 = new javax.swing.JLabel();
        DollarSign1 = new javax.swing.JLabel();
        NeededField = new javax.swing.JTextField();
        AmountLabel25 = new javax.swing.JLabel();
        InvestField1 = new javax.swing.JTextField();
        AmountLabel26 = new javax.swing.JLabel();
        WarningLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        Withdraw = new javax.swing.JPanel();
        WarningLabel2 = new javax.swing.JLabel();
        CalculateButton3 = new javax.swing.JButton();
        ClearButton2 = new javax.swing.JButton();
        SuperClearButton2 = new javax.swing.JButton();
        ResetButton2 = new javax.swing.JButton();
        AmountLabel27 = new javax.swing.JLabel();
        CurrentAgeField2 = new javax.swing.JTextField();
        AmountLabel28 = new javax.swing.JLabel();
        RetireAgeField2 = new javax.swing.JTextField();
        AmountLabel29 = new javax.swing.JLabel();
        LifeExpField1 = new javax.swing.JTextField();
        AmountLabel30 = new javax.swing.JLabel();
        AmountLabel31 = new javax.swing.JLabel();
        CurrentField2 = new javax.swing.JTextField();
        AmountLabel32 = new javax.swing.JLabel();
        AmountLabel33 = new javax.swing.JLabel();
        AmountLabel34 = new javax.swing.JLabel();
        AmountLabel35 = new javax.swing.JLabel();
        AnnualField = new javax.swing.JTextField();
        MonthlyField = new javax.swing.JTextField();
        AmountLabel36 = new javax.swing.JLabel();
        InvestField2 = new javax.swing.JTextField();
        AmountLabel37 = new javax.swing.JLabel();
        AmountLabel38 = new javax.swing.JLabel();
        InflateField1 = new javax.swing.JTextField();
        AmountLabel39 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        ResultTab = new javax.swing.JPanel();
        OutputLabel = new javax.swing.JLabel();
        TitleLabel = new javax.swing.JLabel();
        TitleLabel1 = new javax.swing.JLabel();
        OutputLabel1 = new javax.swing.JLabel();
        TitleLabel2 = new javax.swing.JLabel();
        OutputLabel2 = new javax.swing.JLabel();
        OutputLabel3 = new javax.swing.JLabel();
        OutputLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        Graph = new javax.swing.JPanel();
        Title1 = new javax.swing.JLabel();
        QuitButton = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setForeground(java.awt.Color.white);
        setPreferredSize(new java.awt.Dimension(1140, 700));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        RetirementTabs.setPreferredSize(new java.awt.Dimension(1243, 700));

        HowMuch.setPreferredSize(new java.awt.Dimension(710, 710));
        HowMuch.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        AmountLabel2.setFont(getFontParas());
        AmountLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        AmountLabel2.setText("Current Age");
        HowMuch.add(AmountLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 120, 161, -1));

        AmountLabel3.setFont(getFontParas());
        AmountLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        AmountLabel3.setText("Life Expectancy");
        HowMuch.add(AmountLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 180, 161, -1));

        AmountLabel4.setFont(getFontParas());
        AmountLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        AmountLabel4.setText("/year");
        HowMuch.add(AmountLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 210, -1, -1));

        AmountLabel5.setFont(getFontParas());
        AmountLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        AmountLabel5.setText("Retirement Age");
        HowMuch.add(AmountLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 150, 161, -1));

        AmountLabel6.setFont(getFontParas());
        AmountLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        AmountLabel6.setText("Current Savings");
        HowMuch.add(AmountLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 420, 161, -1));

        INARComboBox.setFont(getFontCombo());
        INARComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "%", "$" }));
        INARComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                INARComboBoxActionPerformed(evt);
            }
        });
        HowMuch.add(INARComboBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(870, 170, 64, -1));

        AmountLabel7.setFont(getFontParas());
        AmountLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        AmountLabel7.setText("<html>\nIncome Needed <br> After Retirement\n</html>");
        HowMuch.add(AmountLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 170, 161, -1));

        AmountLabel8.setFont(getFontParas());
        AmountLabel8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        AmountLabel8.setText("Pre Income Tax");
        HowMuch.add(AmountLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 210, 161, -1));

        AmountLabel9.setFont(getFontParas());
        AmountLabel9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        AmountLabel9.setText("Income Increase");
        HowMuch.add(AmountLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 110, 161, 30));

        AmountLabel10.setFont(getFontParas());
        AmountLabel10.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        AmountLabel10.setText("Inflation Rate");
        HowMuch.add(AmountLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 270, 161, -1));

        LifeExpField.setText("85");
        HowMuch.add(LifeExpField, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 170, 190, -1));

        CurrentAgeField.setText("35");
        HowMuch.add(CurrentAgeField, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 110, 189, -1));

        PrecomeField.setText("70,000");
        HowMuch.add(PrecomeField, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 210, 160, -1));

        IncreaseField.setText("3");
        HowMuch.add(IncreaseField, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 110, 189, -1));

        RetireAgeField.setText("67");
        HowMuch.add(RetireAgeField, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 140, 190, -1));

        InvestField.setText("6");
        HowMuch.add(InvestField, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 230, 189, -1));

        InflateField.setText("3");
        HowMuch.add(InflateField, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 270, 190, -1));

        INARField.setText("75");
        HowMuch.add(INARField, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 160, 170, 40));

        Title3.setFont(getFontHeading());
        Title3.setForeground(new java.awt.Color(11, 56, 79));
        Title3.setText("Attributes");
        HowMuch.add(Title3, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 70, -1, -1));

        Title4.setFont(getFontHeading());
        Title4.setForeground(new java.awt.Color(11, 56, 79));
        Title4.setText("Optional");
        HowMuch.add(Title4, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 330, -1, -1));

        AmountLabel11.setFont(getFontParas());
        AmountLabel11.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        AmountLabel11.setText("<html> Other Income <br> After Retirement </html>");
        HowMuch.add(AmountLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 360, 161, -1));

        OIARField.setText("0");
        HowMuch.add(OIARField, new org.netbeans.lib.awtextra.AbsoluteConstraints(189, 360, 180, 44));

        AmountLabel12.setFont(getFontParas());
        AmountLabel12.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        AmountLabel12.setText("<html>Average <br> Investment Return</html>");
        HowMuch.add(AmountLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 220, 161, -1));

        AmountLabel13.setFont(getFontParas());
        AmountLabel13.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        AmountLabel13.setText("Future Savings");
        HowMuch.add(AmountLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 450, 161, -1));

        FutureField.setText("10");
        HowMuch.add(FutureField, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 450, 183, -1));

        CurrentField.setText("30,000");
        HowMuch.add(CurrentField, new org.netbeans.lib.awtextra.AbsoluteConstraints(189, 410, 180, 30));

        FutureComboBox.setFont(getFontCombo());
        FutureComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "%", "$" }));
        FutureComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                FutureComboBoxActionPerformed(evt);
            }
        });
        HowMuch.add(FutureComboBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 450, 64, -1));

        AmountLabel14.setFont(getFontParas());
        AmountLabel14.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        AmountLabel14.setText("$");
        HowMuch.add(AmountLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 410, -1, -1));

        AmountLabel15.setFont(getFontParas());
        AmountLabel15.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        AmountLabel15.setText("$");
        HowMuch.add(AmountLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 370, -1, -1));

        AmountLabel16.setFont(getFontParas());
        AmountLabel16.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        AmountLabel16.setText("$");
        HowMuch.add(AmountLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 210, -1, -1));

        AmountLabel17.setFont(getFontParas());
        AmountLabel17.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        AmountLabel17.setText("%/year");
        HowMuch.add(AmountLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(870, 110, -1, -1));

        AmountLabel18.setFont(getFontParas());
        AmountLabel18.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        AmountLabel18.setText("%/year");
        HowMuch.add(AmountLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(880, 240, -1, -1));

        INARLabelTrailing.setFont(getFontParas());
        INARLabelTrailing.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        INARLabelTrailing.setText("of current income");
        HowMuch.add(INARLabelTrailing, new org.netbeans.lib.awtextra.AbsoluteConstraints(940, 170, -1, -1));

        AmountLabel20.setFont(getFontParas());
        AmountLabel20.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        AmountLabel20.setText("%/year");
        HowMuch.add(AmountLabel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(870, 270, -1, -1));

        FutureLabelTrailing.setFont(getFontParas());
        FutureLabelTrailing.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        FutureLabelTrailing.setText("of current income");
        HowMuch.add(FutureLabelTrailing, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 450, -1, -1));

        AmountLabel22.setFont(getFontParas());
        AmountLabel22.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        AmountLabel22.setText("/month");
        HowMuch.add(AmountLabel22, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 420, -1, -1));

        WarningLabel.setForeground(new java.awt.Color(255, 51, 0));
        WarningLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        HowMuch.add(WarningLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 0, 639, 46));

        CalculateButton.setBackground(new java.awt.Color(0, 100, 0));
        CalculateButton.setForeground(new java.awt.Color(0, 0, 0));
        CalculateButton.setText("Calculate");
        CalculateButton.setToolTipText("Click to calculate the converted amount.");
        CalculateButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CalculateButtonActionPerformed(evt);
            }
        });
        HowMuch.add(CalculateButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 400, 290, 60));

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
        HowMuch.add(ClearButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(750, 460, -1, 60));

        SuperClearButton.setBackground(new java.awt.Color(255, 255, 255));
        SuperClearButton.setForeground(new java.awt.Color(0, 0, 0));
        SuperClearButton.setText("Clear All");
        SuperClearButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                SuperClearButtonMouseClicked(evt);
            }
        });
        HowMuch.add(SuperClearButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(850, 460, 94, 60));

        ResetButton.setBackground(new java.awt.Color(255, 255, 255));
        ResetButton.setForeground(new java.awt.Color(0, 0, 0));
        ResetButton.setText("Reset");
        ResetButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ResetButtonMouseClicked(evt);
            }
        });
        HowMuch.add(ResetButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 460, 94, 60));

        infoBoxLabel.setFont(new java.awt.Font("sansserif", 1, 12)); // NOI18N
        infoBoxLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        infoBoxLabel.setText("?");
        infoBoxLabel.setToolTipText("<html><body style='width: 200px;'>The income you want to have after retirement. Many experts think that you will need 70-80% of your pre-retirement income to maintain your standard of living in retirement. You can either choose a percentage of current income or specify a dollar amount. When providing a dollar amount, please provide a number in today's money.</body></html>  ");
        infoBoxLabel.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        infoBoxLabel.setOpaque(true);
        HowMuch.add(infoBoxLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 180, 20, 23));

        infoBoxLabel1.setFont(new java.awt.Font("sansserif", 1, 12)); // NOI18N
        infoBoxLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        infoBoxLabel1.setText("?");
        infoBoxLabel1.setToolTipText("<html><body style='width: 200px;'>The average inflation rate is around 3.5% in the past 100 years in U.S.</body></html>  ");
        infoBoxLabel1.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        infoBoxLabel1.setOpaque(true);
        HowMuch.add(infoBoxLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 270, 20, 23));

        infoBoxLabel2.setFont(new java.awt.Font("sansserif", 1, 12)); // NOI18N
        infoBoxLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        infoBoxLabel2.setText("?");
        infoBoxLabel2.setToolTipText("<html><body style='width: 200px;'>The income after retirement that comes from sources other than your savings, such as social security, pension, rental property, etc. Please provide the estimated money amount at time of retirement age rather than in today's money.</body></html>  ");
        infoBoxLabel2.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        infoBoxLabel2.setOpaque(true);
        HowMuch.add(infoBoxLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 370, 20, 23));

        Title5.setFont(getFontHeading());
        Title5.setForeground(new java.awt.Color(11, 56, 79));
        Title5.setText("Assumptions");
        HowMuch.add(Title5, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 80, -1, -1));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/HowMuch.png"))); // NOI18N
        HowMuch.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1160, 600));

        RetirementTabs.addTab("How much do you need to retire?", HowMuch);

        HowTo.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        CalculateButton2.setBackground(new java.awt.Color(0, 100, 0));
        CalculateButton2.setForeground(new java.awt.Color(0, 0, 0));
        CalculateButton2.setText("Calculate");
        CalculateButton2.setToolTipText("Click to calculate the converted amount.");
        CalculateButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CalculateButton2ActionPerformed(evt);
            }
        });
        HowTo.add(CalculateButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 400, 90, 51));

        ClearButton1.setBackground(new java.awt.Color(255, 255, 255));
        ClearButton1.setForeground(new java.awt.Color(0, 0, 0));
        ClearButton1.setText("Clear Current");
        ClearButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ClearButton1ActionPerformed(evt);
            }
        });
        HowTo.add(ClearButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 400, 115, 50));

        SuperClearButton1.setBackground(new java.awt.Color(255, 255, 255));
        SuperClearButton1.setForeground(new java.awt.Color(0, 0, 0));
        SuperClearButton1.setText("Clear All");
        SuperClearButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SuperClearButton1ActionPerformed(evt);
            }
        });
        HowTo.add(SuperClearButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 400, 94, 51));

        ResetButton1.setBackground(new java.awt.Color(255, 255, 255));
        ResetButton1.setForeground(new java.awt.Color(0, 0, 0));
        ResetButton1.setText("Reset");
        ResetButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ResetButton1ActionPerformed(evt);
            }
        });
        HowTo.add(ResetButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 400, 94, 51));

        AmountLabel19.setFont(getFontParas());
        AmountLabel19.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        AmountLabel19.setText("Current Age");
        HowTo.add(AmountLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(17, 81, 161, -1));

        CurrentAgeField1.setText("35");
        HowTo.add(CurrentAgeField1, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 80, 189, -1));

        AmountLabel21.setFont(getFontParas());
        AmountLabel21.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        AmountLabel21.setText("Retirement Age");
        HowTo.add(AmountLabel21, new org.netbeans.lib.awtextra.AbsoluteConstraints(17, 141, 161, -1));

        RetireAgeField1.setText("67");
        HowTo.add(RetireAgeField1, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 140, 189, -1));

        AmountLabel23.setFont(getFontParas());
        AmountLabel23.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        AmountLabel23.setText("Current Savings");
        HowTo.add(AmountLabel23, new org.netbeans.lib.awtextra.AbsoluteConstraints(17, 194, 161, -1));

        CurrentField1.setText("30,000");
        HowTo.add(CurrentField1, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 190, 170, -1));

        DollarSign.setFont(getFontParas());
        DollarSign.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        DollarSign.setText("$");
        HowTo.add(DollarSign, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 200, 20, -1));

        AmountLabel24.setFont(getFontParas());
        AmountLabel24.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        AmountLabel24.setText("Amount needed");
        HowTo.add(AmountLabel24, new org.netbeans.lib.awtextra.AbsoluteConstraints(17, 234, 161, -1));

        DollarSign1.setFont(getFontParas());
        DollarSign1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        DollarSign1.setText("$");
        HowTo.add(DollarSign1, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 240, 20, -1));

        NeededField.setText("600,000");
        HowTo.add(NeededField, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 240, 180, -1));

        AmountLabel25.setFont(getFontParas());
        AmountLabel25.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        AmountLabel25.setText("Investment Return");
        HowTo.add(AmountLabel25, new org.netbeans.lib.awtextra.AbsoluteConstraints(17, 287, 161, -1));

        InvestField1.setText("6");
        HowTo.add(InvestField1, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 280, 189, -1));

        AmountLabel26.setFont(getFontParas());
        AmountLabel26.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        AmountLabel26.setText("%/year");
        HowTo.add(AmountLabel26, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 290, -1, -1));

        WarningLabel1.setForeground(new java.awt.Color(255, 51, 0));
        WarningLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        HowTo.add(WarningLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 0, 639, 46));

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/HowTo.png"))); // NOI18N
        HowTo.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1180, 600));

        RetirementTabs.addTab("How can you save for Retirement?", HowTo);

        Withdraw.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        WarningLabel2.setBackground(new java.awt.Color(255, 255, 255));
        WarningLabel2.setForeground(new java.awt.Color(255, 51, 0));
        WarningLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Withdraw.add(WarningLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 520, 550, 46));

        CalculateButton3.setBackground(new java.awt.Color(0, 100, 0));
        CalculateButton3.setForeground(new java.awt.Color(0, 0, 0));
        CalculateButton3.setText("Calculate");
        CalculateButton3.setToolTipText("Click to calculate the converted amount.");
        CalculateButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CalculateButton3ActionPerformed(evt);
            }
        });
        Withdraw.add(CalculateButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 470, 115, 51));

        ClearButton2.setBackground(new java.awt.Color(255, 255, 255));
        ClearButton2.setForeground(new java.awt.Color(0, 0, 0));
        ClearButton2.setText("Clear Current");
        ClearButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ClearButton2ActionPerformed(evt);
            }
        });
        Withdraw.add(ClearButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 470, 115, 50));

        SuperClearButton2.setBackground(new java.awt.Color(255, 255, 255));
        SuperClearButton2.setForeground(new java.awt.Color(0, 0, 0));
        SuperClearButton2.setText("Clear All");
        SuperClearButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SuperClearButton2ActionPerformed(evt);
            }
        });
        Withdraw.add(SuperClearButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 470, 110, 51));

        ResetButton2.setBackground(new java.awt.Color(255, 255, 255));
        ResetButton2.setForeground(new java.awt.Color(0, 0, 0));
        ResetButton2.setText("Reset");
        ResetButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ResetButton2ActionPerformed(evt);
            }
        });
        Withdraw.add(ResetButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 470, 110, 51));

        AmountLabel27.setFont(getFontParas());
        AmountLabel27.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        AmountLabel27.setText("Current Age");
        Withdraw.add(AmountLabel27, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 40, 161, -1));

        CurrentAgeField2.setText("35");
        Withdraw.add(CurrentAgeField2, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 40, 200, -1));

        AmountLabel28.setFont(getFontParas());
        AmountLabel28.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        AmountLabel28.setText("Retirement Age");
        Withdraw.add(AmountLabel28, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 80, 161, -1));

        RetireAgeField2.setText("67");
        Withdraw.add(RetireAgeField2, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 80, 200, -1));

        AmountLabel29.setFont(getFontParas());
        AmountLabel29.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        AmountLabel29.setText("Life Expectancy");
        Withdraw.add(AmountLabel29, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 120, 161, -1));

        LifeExpField1.setText("85");
        Withdraw.add(LifeExpField1, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 120, 200, -1));

        AmountLabel30.setFont(getFontParas());
        AmountLabel30.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        AmountLabel30.setText("Annual Contribution");
        Withdraw.add(AmountLabel30, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 230, 187, -1));

        AmountLabel31.setFont(getFontParas());
        AmountLabel31.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        AmountLabel31.setText("$");
        Withdraw.add(AmountLabel31, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 170, 20, -1));

        CurrentField2.setText("30,000");
        Withdraw.add(CurrentField2, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 170, 189, -1));

        AmountLabel32.setFont(getFontParas());
        AmountLabel32.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        AmountLabel32.setText("Current Savings");
        Withdraw.add(AmountLabel32, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 170, 161, -1));

        AmountLabel33.setFont(getFontParas());
        AmountLabel33.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        AmountLabel33.setText("Monthly Contribution");
        Withdraw.add(AmountLabel33, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 280, 194, -1));

        AmountLabel34.setFont(getFontParas());
        AmountLabel34.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        AmountLabel34.setText("$");
        Withdraw.add(AmountLabel34, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 230, 20, -1));

        AmountLabel35.setFont(getFontParas());
        AmountLabel35.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        AmountLabel35.setText("$");
        Withdraw.add(AmountLabel35, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 280, 20, -1));

        AnnualField.setText("0");
        Withdraw.add(AnnualField, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 230, 189, -1));

        MonthlyField.setText("500");
        Withdraw.add(MonthlyField, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 280, 189, -1));

        AmountLabel36.setFont(getFontParas());
        AmountLabel36.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        AmountLabel36.setText("Investment Return");
        Withdraw.add(AmountLabel36, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 330, 161, -1));

        InvestField2.setText("6");
        Withdraw.add(InvestField2, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 330, 189, -1));

        AmountLabel37.setFont(getFontParas());
        AmountLabel37.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        AmountLabel37.setText("%/year");
        Withdraw.add(AmountLabel37, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 330, -1, -1));

        AmountLabel38.setFont(getFontParas());
        AmountLabel38.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        AmountLabel38.setText("Inflation Rate");
        Withdraw.add(AmountLabel38, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 370, 161, -1));

        InflateField1.setText("3");
        Withdraw.add(InflateField1, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 370, 190, -1));

        AmountLabel39.setFont(getFontParas());
        AmountLabel39.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        AmountLabel39.setText("%/year");
        Withdraw.add(AmountLabel39, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 370, -1, -1));

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Withdraw.png"))); // NOI18N
        Withdraw.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1180, 600));

        RetirementTabs.addTab("How much can you withdraw after retirement?", Withdraw);

        ResultTab.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        OutputLabel.setFont(getFontParas());
        OutputLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        ResultTab.add(OutputLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 226, 1100, 29));

        TitleLabel.setFont(getFontHeading());
        TitleLabel.setForeground(new java.awt.Color(11, 56, 79));
        TitleLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        ResultTab.add(TitleLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 44, 1100, 40));

        TitleLabel1.setFont(getFontHeading());
        TitleLabel1.setForeground(new java.awt.Color(11, 56, 79));
        TitleLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        ResultTab.add(TitleLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 168, 1100, 40));

        OutputLabel1.setFont(getFontParas());
        OutputLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        ResultTab.add(OutputLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 96, 1100, 29));

        TitleLabel2.setFont(getFontHeading());
        TitleLabel2.setForeground(new java.awt.Color(11, 56, 79));
        TitleLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        ResultTab.add(TitleLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 290, 1100, 40));

        OutputLabel2.setFont(getFontParas());
        OutputLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        ResultTab.add(OutputLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 390, 1090, 29));

        OutputLabel3.setFont(getFontParas());
        OutputLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        ResultTab.add(OutputLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 340, 1090, 29));

        OutputLabel4.setFont(getFontParas());
        OutputLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        ResultTab.add(OutputLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 131, 1090, 29));

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/RetirementImage.png"))); // NOI18N
        ResultTab.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1150, 600));

        RetirementTabs.addTab("Results", ResultTab);

        Graph.setLayout(new java.awt.GridBagLayout());
        RetirementTabs.addTab("Graph", Graph);

        getContentPane().add(RetirementTabs, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 70, 1150, 600));

        Title1.setFont(getFontTitle());
        Title1.setForeground(new java.awt.Color(255, 255, 255));
        Title1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Title1.setText("Retirement Calculator");
        getContentPane().add(Title1, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 10, 513, 50));

        QuitButton.setBackground(new java.awt.Color(255, 255, 255));
        QuitButton.setForeground(new java.awt.Color(0, 0, 0));
        QuitButton.setText("Return");
        QuitButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                QuitButtonMouseClicked(evt);
            }
        });
        getContentPane().add(QuitButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(1030, 20, 74, 38));

        jLabel1.setBackground(new java.awt.Color(11, 56, 79));
        jLabel1.setOpaque(true);
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1270, 110));

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
            if (MainHelper.validate_money(FutureField.getText(), false)) {
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
        INARComboBox.setSelectedItem("%");
        
        FutureComboBox.setSelectedItem("%");
        
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
            if (MainHelper.validate_money(INARField.getText(), false)) {
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

    private void CalculateButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CalculateButton2ActionPerformed
        CalculateSave();
        RetirementTabs.setSelectedComponent(ResultTab);
    }//GEN-LAST:event_CalculateButton2ActionPerformed

    private void ClearButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ClearButton1ActionPerformed
        if (lastFocusedField1 != null) {
                    lastFocusedField1.setText("");  // Clear the content of the last focused text field
                    lastFocusedField1 = null;
                } else {
                    JOptionPane.showMessageDialog(null, "No text field was selected!");
                }
    }//GEN-LAST:event_ClearButton1ActionPerformed

    private void SuperClearButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SuperClearButton1ActionPerformed
        RetirementHelper.clearAllTextFields(HowTo);
        lastFocusedField1 = null;
    }//GEN-LAST:event_SuperClearButton1ActionPerformed

    private void ResetButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ResetButton1ActionPerformed
        CurrentAgeField1.setText("35");
        RetireAgeField1.setText("67");
        CurrentField1.setText("30,000");
        NeededField.setText("1,894,683");
        InvestField1.setText("6");
    }//GEN-LAST:event_ResetButton1ActionPerformed

    private void CalculateButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CalculateButton3ActionPerformed
        WithdrawCalculate();
        RetirementTabs.setSelectedComponent(ResultTab);
    }//GEN-LAST:event_CalculateButton3ActionPerformed

    private void ClearButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ClearButton2ActionPerformed
       if (lastFocusedField2 != null) {
                    lastFocusedField2.setText("");  // Clear the content of the last focused text field
                    lastFocusedField2 = null;
                } else {
                    JOptionPane.showMessageDialog(null, "No text field was selected!");
                }
    }//GEN-LAST:event_ClearButton2ActionPerformed

    private void SuperClearButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SuperClearButton2ActionPerformed
        RetirementHelper.clearAllTextFields(Withdraw);
        lastFocusedField2 = null;
    }//GEN-LAST:event_SuperClearButton2ActionPerformed

    private void ResetButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ResetButton2ActionPerformed
        CurrentAgeField2.setText("35");
        RetireAgeField2.setText("67");
        LifeExpField1.setText("85");
        CurrentField2.setText("30,000");
        AnnualField.setText("0");
        MonthlyField.setText("1,510");
        InvestField2.setText("6");
        InflateField1.setText("3");
    }//GEN-LAST:event_ResetButton2ActionPerformed

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
        int LY = RA - CA;
        float FIN;
        Integer final_obtained;
        
        if (IRisPercent) {
            FIN = INAR * PIT;
        }
        else {
            FIN = INAR;
        }
        List<Integer> NeededRemaining = RetirementHelper.Total_Required_Retirement_Income(FIN, LE, RA, CA, OIAR, Inflate, Invest);
        Integer final_needed = NeededRemaining.get(0);
        List<Integer> TORI;
        if ("%".equals(FutureComboBox.getSelectedItem())){
            float PTI = future * PIT; 
            TORI = RetirementHelper.Total_Obtained_Retirement_Income(LY, PTI, Invest, current, Increase);
            final_obtained = TORI.get(TORI.size()-1);
        }
        else {
            TORI = RetirementHelper.Total_Obtained_Retirement_Income_Alt(LY, Invest, current, future);
            final_obtained = TORI.get(TORI.size()-1);
        }
        TitleLabel.setText("YOU WILL NEED:");
        OutputLabel1.setText("$" + MainHelper.formatCurrency(final_needed));
        TitleLabel1.setText("YOU WILL HAVE:");
        OutputLabel.setText("$" + MainHelper.formatCurrency(final_obtained));
        TitleLabel2.setText("HOW CAN YOU REACH THIS?");
        float percentHigher = Math.abs((float)final_needed - (float)final_obtained) / (((float)final_needed + (float)final_obtained)/2) / (Invest*100);
        float savingsPercentage = RetirementHelper.Inverse_TORI(final_needed, LY, PIT, Invest, current, Increase);
        float yearlySavings = PIT * savingsPercentage;

        
        if (final_needed > final_obtained) {
            OutputLabel3.setText("Save $" + MainHelper.formatCurrency(yearlySavings) + "/year or");
            OutputLabel2.setText(String.format("%.2f%% of your annual income", savingsPercentage*100+.01));
        }
        else {
            Integer lowest_possible = RetirementHelper.posOfSmallestElementGtOeT(final_needed, TORI);
            
            OutputLabel3.setText(String.format("You'll have the amount you need at age %d by age %d", RA, lowest_possible+CA));
            Integer Earliest_Retirement = RetirementHelper.Earliest_Retirement(final_needed, final_obtained, RA, CA, Inflate, OIAR*12, Invest, FIN);
            OutputLabel2.setText(String.format("Assuming no changes to variables you might be able to retire by age %d", Earliest_Retirement));
            
        }
        float needed_PTI = PIT * (savingsPercentage);
        List<Integer> Required_TORI = RetirementHelper.Total_Obtained_Retirement_Income(LY, needed_PTI, Invest, current, Increase);
        addChartToPanel(TORI, Required_TORI, CA, final_needed > final_obtained, "Obtained", "Needed");
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
        Boolean OIARValid = MainHelper.validate_money(OIARField.getText(), false);
        if (OIARValid) {
            OIAR =MainHelper.parseMoney(OIARField.getText(), ",");
        }
        else {
            OIAR = 0;
        }
        Boolean CurrentValid = MainHelper.validate_money(CurrentField.getText(), false);
        if (CurrentValid) {
            current = MainHelper.parseMoney(CurrentField.getText(), ",");
        }
        else {
            current = 0;
        }
    }
    
    private void CalculateSave() {
        int CA = Integer.parseInt(CurrentAgeField1.getText());
        int RA = Integer.parseInt(RetireAgeField1.getText());
        if (RA==CA) {
           float Current = MainHelper.parseMoney(CurrentField1.getText(), ",");
           float needed = MainHelper.parseMoney(NeededField.getText(), ","); 
           float one_year_needs = needed-Current;
           TitleLabel.setText("ANNUAL SAVINGS");
            OutputLabel1.setText("Save $" + MainHelper.formatCurrency(one_year_needs) + " by the end of the year");
            TitleLabel1.setText("MONTHLY SAVINGS");
            OutputLabel.setText("Save $" + MainHelper.formatCurrency(one_year_needs/12) + "/month for the rest of the year");
            TitleLabel2.setText("IF YOU HAVE IT NOW");
            OutputLabel3.setText("Additional Amount Needed $" + MainHelper.formatCurrency(one_year_needs));
            OutputLabel2.setText("");

        }
        else{
        int Living_Years = RA - CA;
        float Current = MainHelper.parseMoney(CurrentField1.getText(), ",");
        float needed = MainHelper.parseMoney(NeededField.getText(), ",");
        float invest = MainHelper.parseMoney(InvestField1.getText(), ",") / 100;
        
        float annual_investment = RetirementHelper.Inverse_PTI(needed, Living_Years, invest, Current);
        float monthly_investment = annual_investment / 12;
        float current_needed = RetirementHelper.Current_Needed(invest, needed, Living_Years);
        
        TitleLabel.setText("ANNUAL SAVINGS");
        OutputLabel1.setText("Save $" + MainHelper.formatCurrency(annual_investment) + "/year or");
        TitleLabel1.setText("MONTHLY SAVINGS");
        OutputLabel.setText("Save $" + MainHelper.formatCurrency(monthly_investment) + "/month or");
        TitleLabel2.setText("IF YOU HAVE IT NOW");
        OutputLabel3.setText("Additional Amount Needed $" + MainHelper.formatCurrency(current_needed));
        
        List<Integer> annual_invest_lines = RetirementHelper.Total_Obtained_Retirement_Income_Alt(RA-CA, invest, Current, annual_investment);
        List<Integer> have_it_now = RetirementHelper.Total_Obtained_Retirement_Income(RA-CA, 0, invest, current_needed, invest);
        addChartToPanel(annual_invest_lines, have_it_now, CA, true, "Annual Investments", "Single Investment");
        
        OutputLabel2.setText("");
        }
        
        
    }
    
    private void WithdrawCalculate() {
        int CA = Integer.parseInt(CurrentAgeField2.getText());
        int RA = Integer.parseInt(RetireAgeField2.getText());
        int Living_Years = RA - CA;
        int LE = Integer.parseInt(LifeExpField1.getText());
        int Retirement_Years = LE - RA;
        float Current = MainHelper.parseMoney(CurrentField2.getText(), ",");
        float invest = MainHelper.parseMoney(InvestField2.getText(), ",") / 100;
        float inflate = MainHelper.parseMoney(InflateField1.getText(), ",") / 100;
        float annual = MainHelper.parseMoney(AnnualField.getText(), ",");
        float monthly = MainHelper.parseMoney(MonthlyField.getText(), ",");
        
        List<Integer> buildup = RetirementHelper.Total_Obtained_Retirement_Income_Monthly(Living_Years, invest, Current, annual, monthly);
        int final_obtained = buildup.get(buildup.size()-1);
        float monthlyRate = invest/12;
        float monthlyinfrate = inflate/12;
        
        float initialMonthlyWithdrawal = (final_obtained*monthlyRate*(float)Math.pow(1+monthlyRate, Retirement_Years*12))/((float)(Math.pow(1+monthlyRate, Retirement_Years*12))-1);
        float inflationAdjustedMonthly;
        if (monthlyRate != monthlyinfrate) {
        inflationAdjustedMonthly = (final_obtained*Math.abs(monthlyRate-monthlyinfrate))/(1-((float)Math.pow(1+monthlyRate-monthlyinfrate,-(Retirement_Years*12))));
        }
        else{
            inflationAdjustedMonthly = initialMonthlyWithdrawal/(float)(Math.pow(1+inflate, Retirement_Years));
  
        }
        
        TitleLabel.setText("BALANCE AT RETIREMENT");
        OutputLabel1.setText("$" + MainHelper.formatCurrency(final_obtained) + " by age " + String.valueOf(RA));
        TitleLabel1.setText("FIXED AMOUNT");
        OutputLabel.setText("$" + MainHelper.formatCurrency(initialMonthlyWithdrawal) + " from ages " + String.valueOf(RA) + " to " + String.valueOf(LE));
        TitleLabel2.setText("ACCOUNTING FOR INFLATION");
        OutputLabel3.setText("$" + MainHelper.formatCurrency(inflationAdjustedMonthly) + " adjusting " + String.valueOf(inflate*100) +"% annualy");
        OutputLabel2.setText("");
        
        List<Integer> withdraw_fixed = RetirementHelper.WithdrawPlan(final_obtained, initialMonthlyWithdrawal, invest, 0, Retirement_Years);
        List<Integer> withdraw_inflated = RetirementHelper.WithdrawPlan(final_obtained, inflationAdjustedMonthly, invest, inflate, Retirement_Years);
        int final_withdraw = Math.min(withdraw_fixed.get(withdraw_fixed.size()-1), withdraw_inflated.get(withdraw_inflated.size()-1));
        for (int i=0;i<withdraw_fixed.size();i++){
            withdraw_fixed.set(i, withdraw_fixed.get(i)-final_withdraw);
            withdraw_inflated.set(i, withdraw_inflated.get(i)-final_withdraw);
        }
        
        addChartToPanel(withdraw_fixed, withdraw_inflated, RA+1, true, "Fixed Withdraw", "Inflation Withdraw");
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
    
    public Font getFontHeading() {
        try {
            Font customFont = Font.createFont(Font.TRUETYPE_FONT, new File("src/fonts/Nunito-VariableFont_wght.ttf"));
            customFont = customFont.deriveFont(Font.BOLD, 20);
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
     
     public Font getFontCombo() {
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
    private javax.swing.JLabel AmountLabel10;
    private javax.swing.JLabel AmountLabel11;
    private javax.swing.JLabel AmountLabel12;
    private javax.swing.JLabel AmountLabel13;
    private javax.swing.JLabel AmountLabel14;
    private javax.swing.JLabel AmountLabel15;
    private javax.swing.JLabel AmountLabel16;
    private javax.swing.JLabel AmountLabel17;
    private javax.swing.JLabel AmountLabel18;
    private javax.swing.JLabel AmountLabel19;
    private javax.swing.JLabel AmountLabel2;
    private javax.swing.JLabel AmountLabel20;
    private javax.swing.JLabel AmountLabel21;
    private javax.swing.JLabel AmountLabel22;
    private javax.swing.JLabel AmountLabel23;
    private javax.swing.JLabel AmountLabel24;
    private javax.swing.JLabel AmountLabel25;
    private javax.swing.JLabel AmountLabel26;
    private javax.swing.JLabel AmountLabel27;
    private javax.swing.JLabel AmountLabel28;
    private javax.swing.JLabel AmountLabel29;
    private javax.swing.JLabel AmountLabel3;
    private javax.swing.JLabel AmountLabel30;
    private javax.swing.JLabel AmountLabel31;
    private javax.swing.JLabel AmountLabel32;
    private javax.swing.JLabel AmountLabel33;
    private javax.swing.JLabel AmountLabel34;
    private javax.swing.JLabel AmountLabel35;
    private javax.swing.JLabel AmountLabel36;
    private javax.swing.JLabel AmountLabel37;
    private javax.swing.JLabel AmountLabel38;
    private javax.swing.JLabel AmountLabel39;
    private javax.swing.JLabel AmountLabel4;
    private javax.swing.JLabel AmountLabel5;
    private javax.swing.JLabel AmountLabel6;
    private javax.swing.JLabel AmountLabel7;
    private javax.swing.JLabel AmountLabel8;
    private javax.swing.JLabel AmountLabel9;
    private javax.swing.JTextField AnnualField;
    private javax.swing.JButton CalculateButton;
    private javax.swing.JButton CalculateButton2;
    private javax.swing.JButton CalculateButton3;
    private javax.swing.JButton ClearButton;
    private javax.swing.JButton ClearButton1;
    private javax.swing.JButton ClearButton2;
    private javax.swing.JTextField CurrentAgeField;
    private javax.swing.JTextField CurrentAgeField1;
    private javax.swing.JTextField CurrentAgeField2;
    private javax.swing.JTextField CurrentField;
    private javax.swing.JTextField CurrentField1;
    private javax.swing.JTextField CurrentField2;
    private javax.swing.JLabel DollarSign;
    private javax.swing.JLabel DollarSign1;
    private javax.swing.JComboBox<String> FutureComboBox;
    private javax.swing.JTextField FutureField;
    private javax.swing.JLabel FutureLabelTrailing;
    private javax.swing.JPanel Graph;
    private javax.swing.JPanel HowMuch;
    private javax.swing.JPanel HowTo;
    private javax.swing.JComboBox<String> INARComboBox;
    private javax.swing.JTextField INARField;
    private javax.swing.JLabel INARLabelTrailing;
    private javax.swing.JTextField IncreaseField;
    private javax.swing.JTextField InflateField;
    private javax.swing.JTextField InflateField1;
    private javax.swing.JTextField InvestField;
    private javax.swing.JTextField InvestField1;
    private javax.swing.JTextField InvestField2;
    private javax.swing.JTextField LifeExpField;
    private javax.swing.JTextField LifeExpField1;
    private javax.swing.JTextField MonthlyField;
    private javax.swing.JTextField NeededField;
    private javax.swing.JTextField OIARField;
    private javax.swing.JLabel OutputLabel;
    private javax.swing.JLabel OutputLabel1;
    private javax.swing.JLabel OutputLabel2;
    private javax.swing.JLabel OutputLabel3;
    private javax.swing.JLabel OutputLabel4;
    private javax.swing.JTextField PrecomeField;
    private javax.swing.JButton QuitButton;
    private javax.swing.JButton ResetButton;
    private javax.swing.JButton ResetButton1;
    private javax.swing.JButton ResetButton2;
    private javax.swing.JPanel ResultTab;
    private javax.swing.JTextField RetireAgeField;
    private javax.swing.JTextField RetireAgeField1;
    private javax.swing.JTextField RetireAgeField2;
    private javax.swing.JTabbedPane RetirementTabs;
    private javax.swing.JButton SuperClearButton;
    private javax.swing.JButton SuperClearButton1;
    private javax.swing.JButton SuperClearButton2;
    private javax.swing.JLabel Title1;
    private javax.swing.JLabel Title3;
    private javax.swing.JLabel Title4;
    private javax.swing.JLabel Title5;
    private javax.swing.JLabel TitleLabel;
    private javax.swing.JLabel TitleLabel1;
    private javax.swing.JLabel TitleLabel2;
    private javax.swing.JLabel WarningLabel;
    private javax.swing.JLabel WarningLabel1;
    private javax.swing.JLabel WarningLabel2;
    private javax.swing.JPanel Withdraw;
    private javax.swing.JLabel infoBoxLabel;
    private javax.swing.JLabel infoBoxLabel1;
    private javax.swing.JLabel infoBoxLabel2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    // End of variables declaration//GEN-END:variables
}