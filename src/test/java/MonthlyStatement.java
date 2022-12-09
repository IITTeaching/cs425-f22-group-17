
package test.java;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;

/**
 *
 * @author fmeraz
 */
public class MonthlyStatement extends javax.swing.JFrame {

    private int acct;

    public MonthlyStatement(int acct) {
        this.acct = acct;
        initComponents();
    }

    
    @SuppressWarnings("unchecked")
                              
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();//Creates all the variables in the GUI
        MonthlyStatementTable = new javax.swing.JTable();
        MonthlyStatementLabel = new javax.swing.JLabel();
        MonthDropDownBox = new javax.swing.JComboBox<>();
        YearDropDownBox = new javax.swing.JComboBox<>();
        MonthLabel = new javax.swing.JLabel();
        YearLabel = new javax.swing.JLabel();
        AccountBalanceLabel = new javax.swing.JLabel();
        MoneySignLabel = new javax.swing.JLabel();
        AmountLabel = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        MonthlyStatementTable.setFont(new java.awt.Font("sansserif", 0, 18));//sets the font, style, and size of the text
        
        DBConnect database = new DBConnect(Login.username, Login.password);
        try
        { //populate table
            int size = 0;
            double endMonthBalance = 0;
            String sql1 = String.format("select id, type, amount, date, balance_after from Transactions where DATE_PART('month', date) = DATE_PART('month', CURRENT_DATE - interval '1 month') and DATE_PART('year', date) = DATE_PART('year', CURRENT_DATE - interval '1 month') and acct_num = %s", this.acct);
            String sql2 = String.format("select count(*) from Transactions where DATE_PART('month', date) = DATE_PART('month', CURRENT_DATE - interval '1 month') and DATE_PART('year', date) = DATE_PART('year', CURRENT_DATE - interval '1 month') and acct_num = %s", this.acct);
            ResultSet data = database.connect().createStatement().executeQuery(sql1);
            ResultSet sizeRs = database.connect().createStatement().executeQuery(sql2);
            if(sizeRs.next())
            {
                size = sizeRs.getInt(1);
            }

            Object [][] rows = new Object[size][4];
            int i = 0;
            while(data.next())
            {
                rows[i][0] = data.getInt("id");
                rows[i][1] = data.getString("type");
                rows[i][2] = String.format("$%.2f", data.getDouble("amount"));
                rows[i][3] = data.getString("date");
                endMonthBalance = data.getDouble("balance_after");
                i++;
            }

            MonthlyStatementTable.setModel(new javax.swing.table.DefaultTableModel(
                rows,
                new String [] {
                    "Transactions", "Type", "Amount", "Date"
                }
            ));

            AmountLabel.setText(String.format("%.2f", endMonthBalance));

            database.connect().close();
        }
        catch(SQLException e)
        {
            System.out.println(e.getMessage());
            MonthlyStatementTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "Transactions", "Date"
            }
        )); 
            AmountLabel.setText("jLabel3");
        }
        
        jScrollPane1.setViewportView(MonthlyStatementTable);

        
        MonthlyStatementLabel.setFont(new java.awt.Font("Helvetica Neue", 1, 24)); //sets the font, style, and size of the text
        MonthlyStatementLabel.setText("Monthly Statement");//sets text

        MonthDropDownBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December" }));//sets text of drop down items

        

        try
        {
            int year = 0;
            Statement statement = database.connect().createStatement();
            String sql = "SELECT DATE_PART('year', CURRENT_DATE)"; //gets current year
            ResultSet rs = statement.executeQuery(sql);
            if(rs.next())
            {
                year = rs.getInt(1); 
            }
            database.connect().close();
            String years[] = new String[10];
            for(int i = 0; i < years.length; i++)
            {
                years[i] = Integer.toString(year - i); //populate year drop down
            }
            YearDropDownBox.setModel(new javax.swing.DefaultComboBoxModel<>(years));
        }
        catch(SQLException e)
        {
            YearDropDownBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
            System.out.println(e.getMessage());
        }

        MonthDropDownBox.addActionListener (new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                String month = (String) MonthDropDownBox.getSelectedItem();
                String year = (String) YearDropDownBox.getSelectedItem();
                HashMap<String, Integer> monthMap = new HashMap<>(); //assigns string of month to number
                monthMap.put("January", 1);
                monthMap.put("February", 2);
                monthMap.put("March", 3);
                monthMap.put("April", 4);
                monthMap.put("May", 5);
                monthMap.put("June", 6);
                monthMap.put("July", 7);
                monthMap.put("August", 8);
                monthMap.put("September", 9);
                monthMap.put("October", 10);
                monthMap.put("November", 11);
                monthMap.put("December", 12);
                try
                {
                    int size = 0;
                    double endMonthBalance = 0;
                    Statement statement = database.connect().createStatement();
                    String sql1 = String.format("select id, type, amount, date, balance_after from Transactions where DATE_PART('month', date) = %d and DATE_PART('year', date) = %s and acct_num = %s", monthMap.get(month), year, acct); //get all transactions during that month for the selected account
                    ResultSet data = statement.executeQuery(sql1);
                    Statement statement2 = database.connect().createStatement();
                    String sql2 = String.format("select count(*) from Transactions where DATE_PART('month', date) = %d and DATE_PART('year', date) = %s and acct_num = %s", monthMap.get(month), year, acct);
                    ResultSet rs = statement2.executeQuery(sql2);
                    if(rs.next())
                    {
                        size = rs.getInt(1);
                    }
                    Object[][] rows = new Object[size][4];
                    int i = 0;
                    while(data.next()) //populate table
                    {
                        rows[i][0] = data.getInt("id");
                        rows[i][1] = data.getString("type");
                        rows[i][2] = String.format("$%.2f", data.getDouble("amount"));
                        rows[i][3] = data.getString("date");
                        endMonthBalance = data.getDouble("balance_after");
                        i++;
                    }

                    MonthlyStatementTable.setModel(new javax.swing.table.DefaultTableModel(
                        rows,
                        new String [] {
                            "Transactions", "Type", "Amount", "Date"
                        }
                    ));

                    AmountLabel.setText(String.format("%.2f", endMonthBalance));

                    database.connect().close();
                }
                catch(SQLException e)
                {
                    System.out.println(e.getMessage());
                }
            }
        });
        

        MonthLabel.setText("Month");//sets text

        YearLabel.setText("Year");//sets text

        AccountBalanceLabel.setText("Account Balance");//sets text

        MoneySignLabel.setText("$");//sets text



        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());//all this sets the layout of the alignment of GUI elements
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(95, 95, 95)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(YearDropDownBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(MonthLabel)
                            .addComponent(YearLabel)
                            .addComponent(MonthDropDownBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(AccountBalanceLabel)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(MoneySignLabel)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(AmountLabel))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(205, 205, 205)
                        .addComponent(MonthlyStatementLabel)))
                .addContainerGap(12, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(MonthlyStatementLabel)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(28, 28, 28)
                        .addComponent(MonthLabel)
                        .addGap(18, 18, 18)
                        .addComponent(MonthDropDownBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(19, 19, 19)
                        .addComponent(YearLabel)
                        .addGap(18, 18, 18)
                        .addComponent(YearDropDownBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 186, Short.MAX_VALUE)
                        .addComponent(AccountBalanceLabel)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(MoneySignLabel)
                            .addComponent(AmountLabel))
                        .addGap(15, 15, 15))))
        );

        pack();
    }                      

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {

        
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
               // new MonthlyStatement().setVisible(true);
            }
        });
    }

                        
    private javax.swing.JLabel AccountBalanceLabel;// This is where the variables are declared
    private javax.swing.JLabel AmountLabel;
    private javax.swing.JLabel MoneySignLabel;
    private javax.swing.JComboBox<String> MonthDropDownBox;
    private javax.swing.JLabel MonthLabel;
    private javax.swing.JLabel MonthlyStatementLabel;
    private javax.swing.JTable MonthlyStatementTable;
    private javax.swing.JComboBox<String> YearDropDownBox;
    private javax.swing.JLabel YearLabel;
    private javax.swing.JScrollPane jScrollPane1;                 
}

