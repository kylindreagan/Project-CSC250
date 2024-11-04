/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package main;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
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
    private static final Boolean allow_foreign = false;
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
                System.out.println(ValidAge);
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
                    else{
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
    
    private void addChartToPanel(List<Integer> savingsData, List<Integer> neededData, Integer CA, Boolean two_graphs) {
        Graph.removeAll(); // Clear previous charts or components
        DefaultCategoryDataset dataset = createDataset(savingsData, neededData, CA, two_graphs);
        
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

        // Add the chart to a ChartPanel
        ChartPanel chartPanel = new ChartPanel(chart);
        chartPanel.setPreferredSize(new Dimension(500, 400));
        System.out.println("Adding chart with data: " + savingsData);
        
        // Add the ChartPanel to the existing panel
        Graph.add(chartPanel, BorderLayout.CENTER);
        
        // Refresh the panel to show the new component
        Graph.validate();
    }
    
     private DefaultCategoryDataset createDataset(List<Integer> savingsData, List<Integer> neededData, Integer CA, Boolean two_graphs) {
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        
        // Populate dataset
        for (int year = 0; year < savingsData.size(); year++) {
            dataset.addValue(savingsData.get(year), "Obtained", Integer.toString(CA+year));
        }
        
        if (two_graphs){
        for (int year = 0; year < savingsData.size(); year++) {
            dataset.addValue(neededData.get(year), "Needed", Integer.toString(CA+year));
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
        ResultTab = new javax.swing.JPanel();
        OutputLabel = new javax.swing.JLabel();
        TitleLabel = new javax.swing.JLabel();
        TitleLabel1 = new javax.swing.JLabel();
        OutputLabel1 = new javax.swing.JLabel();
        TitleLabel2 = new javax.swing.JLabel();
        OutputLabel2 = new javax.swing.JLabel();
        OutputLabel3 = new javax.swing.JLabel();
        Graph = new javax.swing.JPanel();
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
                .addContainerGap(27, Short.MAX_VALUE))
        );

        RetirementTabs.addTab("How much do you need to retire?", HowMuch);

        CalculateButton2.setBackground(new java.awt.Color(204, 153, 0));
        CalculateButton2.setForeground(new java.awt.Color(0, 0, 0));
        CalculateButton2.setText("Calculate");
        CalculateButton2.setToolTipText("Click to calculate the converted amount.");
        CalculateButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CalculateButton2ActionPerformed(evt);
            }
        });

        ClearButton1.setBackground(new java.awt.Color(255, 255, 255));
        ClearButton1.setForeground(new java.awt.Color(0, 0, 0));
        ClearButton1.setText("Clear Current");
        ClearButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ClearButton1ActionPerformed(evt);
            }
        });

        SuperClearButton1.setBackground(new java.awt.Color(255, 255, 255));
        SuperClearButton1.setForeground(new java.awt.Color(0, 0, 0));
        SuperClearButton1.setText("Clear All");
        SuperClearButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SuperClearButton1ActionPerformed(evt);
            }
        });

        ResetButton1.setBackground(new java.awt.Color(255, 255, 255));
        ResetButton1.setForeground(new java.awt.Color(0, 0, 0));
        ResetButton1.setText("Reset");
        ResetButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ResetButton1ActionPerformed(evt);
            }
        });

        AmountLabel19.setFont(new java.awt.Font("Franklin Gothic Heavy", 2, 18)); // NOI18N
        AmountLabel19.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        AmountLabel19.setText("Current Age");

        CurrentAgeField1.setText("35");

        AmountLabel21.setFont(new java.awt.Font("Franklin Gothic Heavy", 2, 18)); // NOI18N
        AmountLabel21.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        AmountLabel21.setText("Retirement Age");

        RetireAgeField1.setText("67");

        AmountLabel23.setFont(new java.awt.Font("Franklin Gothic Heavy", 2, 18)); // NOI18N
        AmountLabel23.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        AmountLabel23.setText("Current Savings");

        CurrentField1.setText("30,000");

        DollarSign.setFont(new java.awt.Font("Franklin Gothic Heavy", 2, 18)); // NOI18N
        DollarSign.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        DollarSign.setText("$");

        AmountLabel24.setFont(new java.awt.Font("Franklin Gothic Heavy", 2, 18)); // NOI18N
        AmountLabel24.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        AmountLabel24.setText("Amount needed");

        DollarSign1.setFont(new java.awt.Font("Franklin Gothic Heavy", 2, 18)); // NOI18N
        DollarSign1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        DollarSign1.setText("$");

        NeededField.setText("1,894,683");

        AmountLabel25.setFont(new java.awt.Font("Franklin Gothic Heavy", 2, 18)); // NOI18N
        AmountLabel25.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        AmountLabel25.setText("Investment Return");

        InvestField1.setText("6");

        AmountLabel26.setFont(new java.awt.Font("Franklin Gothic Heavy", 2, 18)); // NOI18N
        AmountLabel26.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        AmountLabel26.setText("%/year");

        WarningLabel1.setForeground(new java.awt.Color(255, 51, 51));
        WarningLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout HowToLayout = new javax.swing.GroupLayout(HowTo);
        HowTo.setLayout(HowToLayout);
        HowToLayout.setHorizontalGroup(
            HowToLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(HowToLayout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addGroup(HowToLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(AmountLabel25, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(AmountLabel23, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(AmountLabel21, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(AmountLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(AmountLabel24, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(HowToLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, HowToLayout.createSequentialGroup()
                        .addGroup(HowToLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(HowToLayout.createSequentialGroup()
                                .addComponent(DollarSign, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(CurrentField1, javax.swing.GroupLayout.PREFERRED_SIZE, 189, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(HowToLayout.createSequentialGroup()
                                .addComponent(DollarSign1, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(NeededField, javax.swing.GroupLayout.PREFERRED_SIZE, 189, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(ClearButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(77, 77, 77)
                        .addComponent(SuperClearButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(39, 39, 39))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, HowToLayout.createSequentialGroup()
                        .addGap(0, 387, Short.MAX_VALUE)
                        .addComponent(CalculateButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(119, 119, 119))
                    .addGroup(HowToLayout.createSequentialGroup()
                        .addGroup(HowToLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(RetireAgeField1, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(CurrentAgeField1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 189, Short.MAX_VALUE))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(HowToLayout.createSequentialGroup()
                        .addComponent(InvestField1, javax.swing.GroupLayout.PREFERRED_SIZE, 189, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(AmountLabel26)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(ResetButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(128, 128, 128))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, HowToLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(WarningLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 639, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(62, 62, 62))
        );
        HowToLayout.setVerticalGroup(
            HowToLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(HowToLayout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(WarningLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(HowToLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(AmountLabel19)
                    .addComponent(CurrentAgeField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(HowToLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(HowToLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(CalculateButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(HowToLayout.createSequentialGroup()
                        .addGap(32, 32, 32)
                        .addGroup(HowToLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(AmountLabel21)
                            .addComponent(RetireAgeField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGroup(HowToLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(HowToLayout.createSequentialGroup()
                        .addGap(29, 29, 29)
                        .addGroup(HowToLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(ClearButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(SuperClearButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(ResetButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(HowToLayout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addGroup(HowToLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(AmountLabel23)
                            .addComponent(CurrentField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(DollarSign))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(HowToLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(AmountLabel24)
                            .addComponent(DollarSign1)
                            .addComponent(NeededField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(HowToLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(AmountLabel25)
                            .addComponent(InvestField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(AmountLabel26))))
                .addContainerGap(301, Short.MAX_VALUE))
        );

        RetirementTabs.addTab("How can you save for Retirement?", HowTo);

        WarningLabel2.setForeground(new java.awt.Color(255, 51, 51));
        WarningLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        CalculateButton3.setBackground(new java.awt.Color(204, 153, 0));
        CalculateButton3.setForeground(new java.awt.Color(0, 0, 0));
        CalculateButton3.setText("Calculate");
        CalculateButton3.setToolTipText("Click to calculate the converted amount.");
        CalculateButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CalculateButton3ActionPerformed(evt);
            }
        });

        ClearButton2.setBackground(new java.awt.Color(255, 255, 255));
        ClearButton2.setForeground(new java.awt.Color(0, 0, 0));
        ClearButton2.setText("Clear Current");
        ClearButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ClearButton2ActionPerformed(evt);
            }
        });

        SuperClearButton2.setBackground(new java.awt.Color(255, 255, 255));
        SuperClearButton2.setForeground(new java.awt.Color(0, 0, 0));
        SuperClearButton2.setText("Clear All");
        SuperClearButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SuperClearButton2ActionPerformed(evt);
            }
        });

        ResetButton2.setBackground(new java.awt.Color(255, 255, 255));
        ResetButton2.setForeground(new java.awt.Color(0, 0, 0));
        ResetButton2.setText("Reset");
        ResetButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ResetButton2ActionPerformed(evt);
            }
        });

        AmountLabel27.setFont(new java.awt.Font("Franklin Gothic Heavy", 2, 18)); // NOI18N
        AmountLabel27.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        AmountLabel27.setText("Current Age");

        CurrentAgeField2.setText("35");

        AmountLabel28.setFont(new java.awt.Font("Franklin Gothic Heavy", 2, 18)); // NOI18N
        AmountLabel28.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        AmountLabel28.setText("Retirement Age");

        RetireAgeField2.setText("67");

        AmountLabel29.setFont(new java.awt.Font("Franklin Gothic Heavy", 2, 18)); // NOI18N
        AmountLabel29.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        AmountLabel29.setText("Life Expectancy");

        LifeExpField1.setText("85");

        AmountLabel30.setFont(new java.awt.Font("Franklin Gothic Heavy", 2, 18)); // NOI18N
        AmountLabel30.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        AmountLabel30.setText("Annual Contribution");

        AmountLabel31.setFont(new java.awt.Font("Franklin Gothic Heavy", 2, 18)); // NOI18N
        AmountLabel31.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        AmountLabel31.setText("$");

        CurrentField2.setText("30,000");

        AmountLabel32.setFont(new java.awt.Font("Franklin Gothic Heavy", 2, 18)); // NOI18N
        AmountLabel32.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        AmountLabel32.setText("Current Savings");

        AmountLabel33.setFont(new java.awt.Font("Franklin Gothic Heavy", 2, 18)); // NOI18N
        AmountLabel33.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        AmountLabel33.setText("Monthly Contribution");

        AmountLabel34.setFont(new java.awt.Font("Franklin Gothic Heavy", 2, 18)); // NOI18N
        AmountLabel34.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        AmountLabel34.setText("$");

        AmountLabel35.setFont(new java.awt.Font("Franklin Gothic Heavy", 2, 18)); // NOI18N
        AmountLabel35.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        AmountLabel35.setText("$");

        AnnualField.setText("0");

        MonthlyField.setText("1,510");

        AmountLabel36.setFont(new java.awt.Font("Franklin Gothic Heavy", 2, 18)); // NOI18N
        AmountLabel36.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        AmountLabel36.setText("Investment Return");

        InvestField2.setText("6");

        AmountLabel37.setFont(new java.awt.Font("Franklin Gothic Heavy", 2, 18)); // NOI18N
        AmountLabel37.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        AmountLabel37.setText("%/year");

        AmountLabel38.setFont(new java.awt.Font("Franklin Gothic Heavy", 2, 18)); // NOI18N
        AmountLabel38.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        AmountLabel38.setText("Inflation Rate");

        InflateField1.setText("3");

        AmountLabel39.setFont(new java.awt.Font("Franklin Gothic Heavy", 2, 18)); // NOI18N
        AmountLabel39.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        AmountLabel39.setText("%/year");

        javax.swing.GroupLayout WithdrawLayout = new javax.swing.GroupLayout(Withdraw);
        Withdraw.setLayout(WithdrawLayout);
        WithdrawLayout.setHorizontalGroup(
            WithdrawLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(WithdrawLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(WithdrawLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, WithdrawLayout.createSequentialGroup()
                        .addComponent(AmountLabel27, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(CurrentAgeField2, javax.swing.GroupLayout.DEFAULT_SIZE, 130, Short.MAX_VALUE)
                        .addGap(239, 239, 239)
                        .addComponent(CalculateButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(160, 160, 160))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, WithdrawLayout.createSequentialGroup()
                        .addComponent(AmountLabel28, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(RetireAgeField2)
                        .addGap(119, 119, 119)
                        .addComponent(ClearButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(96, 96, 96)
                        .addComponent(SuperClearButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(69, 69, 69))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, WithdrawLayout.createSequentialGroup()
                        .addGroup(WithdrawLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(WithdrawLayout.createSequentialGroup()
                                .addComponent(AmountLabel29, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(LifeExpField1, javax.swing.GroupLayout.PREFERRED_SIZE, 189, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(WithdrawLayout.createSequentialGroup()
                                .addGap(167, 167, 167)
                                .addComponent(AmountLabel31, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(CurrentField2, javax.swing.GroupLayout.PREFERRED_SIZE, 189, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(ResetButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(171, 171, 171))
                    .addGroup(WithdrawLayout.createSequentialGroup()
                        .addComponent(AmountLabel30, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(AmountLabel34, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(AnnualField, javax.swing.GroupLayout.PREFERRED_SIZE, 189, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(WithdrawLayout.createSequentialGroup()
                        .addComponent(AmountLabel33, javax.swing.GroupLayout.PREFERRED_SIZE, 194, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(AmountLabel35, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(MonthlyField, javax.swing.GroupLayout.PREFERRED_SIZE, 189, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))))
            .addGroup(WithdrawLayout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addGroup(WithdrawLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(AmountLabel38, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(AmountLabel36, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(WithdrawLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(WithdrawLayout.createSequentialGroup()
                        .addComponent(InvestField2, javax.swing.GroupLayout.PREFERRED_SIZE, 189, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(AmountLabel37))
                    .addGroup(WithdrawLayout.createSequentialGroup()
                        .addComponent(InflateField1, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(AmountLabel39)))
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, WithdrawLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(WarningLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 639, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(89, 89, 89))
            .addGroup(WithdrawLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(WithdrawLayout.createSequentialGroup()
                    .addGap(16, 16, 16)
                    .addComponent(AmountLabel32, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(640, Short.MAX_VALUE)))
        );
        WithdrawLayout.setVerticalGroup(
            WithdrawLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(WithdrawLayout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addComponent(WarningLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(38, 38, 38)
                .addGroup(WithdrawLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(CalculateButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(WithdrawLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(AmountLabel27)
                        .addComponent(CurrentAgeField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(WithdrawLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ClearButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(SuperClearButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(AmountLabel28)
                    .addComponent(RetireAgeField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(WithdrawLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(ResetButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(WithdrawLayout.createSequentialGroup()
                        .addGroup(WithdrawLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(AmountLabel29)
                            .addComponent(LifeExpField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(WithdrawLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(AmountLabel31)
                            .addComponent(CurrentField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(29, 29, 29)
                .addGroup(WithdrawLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(AmountLabel30)
                    .addComponent(AmountLabel34)
                    .addComponent(AnnualField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(WithdrawLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(AmountLabel33)
                    .addComponent(AmountLabel35)
                    .addComponent(MonthlyField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(WithdrawLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(AmountLabel36)
                    .addComponent(InvestField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(AmountLabel37))
                .addGap(18, 18, 18)
                .addGroup(WithdrawLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(AmountLabel38)
                    .addComponent(InflateField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(AmountLabel39))
                .addContainerGap(92, Short.MAX_VALUE))
            .addGroup(WithdrawLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, WithdrawLayout.createSequentialGroup()
                    .addContainerGap(311, Short.MAX_VALUE)
                    .addComponent(AmountLabel32)
                    .addGap(282, 282, 282)))
        );

        RetirementTabs.addTab("How much can you withdraw after retirement?", Withdraw);

        OutputLabel.setFont(new java.awt.Font("HP Simplified Jpan", 1, 12)); // NOI18N
        OutputLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        TitleLabel.setFont(new java.awt.Font("HP Simplified", 3, 18)); // NOI18N
        TitleLabel.setForeground(new java.awt.Color(51, 0, 204));
        TitleLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        TitleLabel1.setFont(new java.awt.Font("HP Simplified", 3, 18)); // NOI18N
        TitleLabel1.setForeground(new java.awt.Color(51, 0, 204));
        TitleLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        OutputLabel1.setFont(new java.awt.Font("HP Simplified Jpan", 1, 12)); // NOI18N
        OutputLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        TitleLabel2.setFont(new java.awt.Font("HP Simplified", 3, 18)); // NOI18N
        TitleLabel2.setForeground(new java.awt.Color(51, 0, 204));
        TitleLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        OutputLabel2.setFont(new java.awt.Font("HP Simplified Jpan", 1, 12)); // NOI18N
        OutputLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        OutputLabel3.setFont(new java.awt.Font("HP Simplified Jpan", 1, 12)); // NOI18N
        OutputLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout ResultTabLayout = new javax.swing.GroupLayout(ResultTab);
        ResultTab.setLayout(ResultTabLayout);
        ResultTabLayout.setHorizontalGroup(
            ResultTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(OutputLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(TitleLabel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(OutputLabel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(TitleLabel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(TitleLabel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(OutputLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, ResultTabLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(OutputLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 805, Short.MAX_VALUE)
                .addContainerGap())
        );
        ResultTabLayout.setVerticalGroup(
            ResultTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ResultTabLayout.createSequentialGroup()
                .addGap(44, 44, 44)
                .addComponent(TitleLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(OutputLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(TitleLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(OutputLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(TitleLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(OutputLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(OutputLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(269, Short.MAX_VALUE))
        );

        RetirementTabs.addTab("Results", ResultTab);

        Graph.setLayout(new java.awt.BorderLayout());
        RetirementTabs.addTab("Graph", Graph);

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

    private void CalculateButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CalculateButton2ActionPerformed
        // TODO add your handling code here:
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
        // TODO add your handling code here:
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
            TORI = RetirementHelper.Total_Obtained_Retirement_Income(LY, PIT, Invest, current, future, Increase);
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
        float the_Beginning_Of_My_Poor_Ass_Life;
        if ("%".equals(FutureComboBox.getSelectedItem())){
            the_Beginning_Of_My_Poor_Ass_Life = future;
        }
        else{
            the_Beginning_Of_My_Poor_Ass_Life = future/PIT;
        }
        System.out.println(the_Beginning_Of_My_Poor_Ass_Life);
        float percentHigher = Math.abs((float)final_needed - (float)final_obtained) / (((float)final_needed + (float)final_obtained)/2) / ((Invest+.01)*100);
        System.out.println(percentHigher);
        float savingsPercentage = (percentHigher + the_Beginning_Of_My_Poor_Ass_Life)*100; //adjusted for error
        float yearlySavings = PIT * (savingsPercentage/100);

        
        if (final_needed > final_obtained) {
            OutputLabel3.setText("Save $" + MainHelper.formatCurrency(yearlySavings) + "/year or");
            OutputLabel2.setText(String.format("%.2f%% of your annual income", savingsPercentage));
        }
        else {
            Integer lowest_possible = RetirementHelper.posOfSmallestElementGtOeT(final_needed, TORI);
            
            OutputLabel3.setText(String.format("You'll have the amount you need at age %d by age %d", RA, lowest_possible+CA));
            Integer Earliest_Retirement = RetirementHelper.Earliest_Retirement(final_needed, final_obtained, RA, CA, Inflate, OIAR*12, Invest, FIN);
            OutputLabel2.setText(String.format("Assuming no changes to variables you might be able to retire by age %d", Earliest_Retirement));
            
        }
        List<Integer> Required_TORI = RetirementHelper.Total_Obtained_Retirement_Income(LY, PIT, Invest, current, savingsPercentage/100, Increase);
        System.out.println(Required_TORI);
        addChartToPanel(TORI, Required_TORI, CA, final_needed > final_obtained);
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
    private javax.swing.JLabel TitleLabel;
    private javax.swing.JLabel TitleLabel1;
    private javax.swing.JLabel TitleLabel2;
    private javax.swing.JLabel WarningLabel;
    private javax.swing.JLabel WarningLabel1;
    private javax.swing.JLabel WarningLabel2;
    private javax.swing.JPanel Withdraw;
    // End of variables declaration//GEN-END:variables
}