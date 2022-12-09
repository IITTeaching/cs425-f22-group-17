package test.java;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.table.*;
/**
 *
 * @author fmeraz
 */
public class ManagerAccountManagement extends javax.swing.JFrame {

    
    public ManagerAccountManagement() {
        initComponents();
    }

    
    @SuppressWarnings("unchecked")
                             
    private void initComponents() {

        MCreateButton = new javax.swing.JButton();//Creates all the variables in the GUI
        MDeleteButton = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        MAccountsTable = new javax.swing.JTable();
        MMonthlyStatementButton = new javax.swing.JButton();
        MPendingTransactionsButton = new javax.swing.JButton();
        MAccountTransactionsButton = new javax.swing.JButton();
        InterestText1 = new javax.swing.JLabel();
        AddInterestButton = new javax.swing.JButton();
        OverdraftText1 = new javax.swing.JLabel();
        OverdraftFeeButton = new javax.swing.JButton();
        OverdraftText2 = new javax.swing.JLabel();
        InterestText2 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        OverdraftFeeAmountText = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        AccountFeeAmountText = new javax.swing.JTextField();
        AccountFeeButton = new javax.swing.JButton();
        MoneySign1 = new javax.swing.JLabel();
        InterestDropDownBox = new javax.swing.JComboBox<>();
        MAnalyticsButton = new javax.swing.JButton();
        MBranchesButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        MCreateButton.setText("Create Account");//sets text of button
        MCreateButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MCreateButtonActionPerformed(evt);
            }
        });

        MDeleteButton.setText("Delete Account");//sets text of button
        MDeleteButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MDeleteButtonActionPerformed(evt);
            }
        });

        /*MAccountsTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {"test", "$1.50"},
                {"test2", "$0.50"}
            },
            new String [] {
                "Accounts", "Balance"
            }
        ));/* */

        DBConnect database = new DBConnect(Login.username, Login.password);
        try
        {
            int size = 0;
            ResultSet accounts = database.connect().createStatement().executeQuery("Select a.acct_num, a.balance, o.username from Account a natural join Owners o"); //get all accounts
            ResultSet sizeResult = database.connect().createStatement().executeQuery("Select COUNT(*) from Account"); //get number of accounts
            database.connect().close();
            if(sizeResult.next())
            {
                size = sizeResult.getInt(1);
            }
            String[][] data = new String[size][3];
            int i = 0;
            while(accounts.next()) //populate 2d with acct_num and balance
            {
                data[i][0] = accounts.getString("acct_num");
                data[i][1] = String.format("$%.2f", accounts.getDouble("balance"));
                data[i][2] = accounts.getString("username");
                i++;
            }

            MAccountsTable.setModel(new javax.swing.table.DefaultTableModel(
            data,
            new String [] {
                "Accounts", "Balance", "User"
            }
            ));

            MAccountsTable.setRowSelectionAllowed(true); //allow row selection
        }
        catch(SQLException e) //if sql error
        {
            System.out.print(e.getMessage());
            MAccountsTable.setModel(new javax.swing.table.DefaultTableModel(
            new String [][] {
                {"test", "$1.00"},
                {"test2", "$0.50"}
            },
            new String [] {
                "Accounts", "Balance"
            }));
        }
        MAccountsTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                MAccountsTableMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(MAccountsTable);

        MMonthlyStatementButton.setText("Monthly Statement");//sets text of button
        MMonthlyStatementButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MMonthlyStatementButtonActionPerformed(evt);
            }
        });

        MPendingTransactionsButton.setText("Pending Transactions");//sets text of button
        MPendingTransactionsButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MPendingTransactionsButtonActionPerformed(evt);
            }
        });

        MAccountTransactionsButton.setText("Account Transactions");//sets text of button
        MAccountTransactionsButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MAccountTransactionsButtonActionPerformed(evt);
            }
        });

        InterestText1.setText("Add Interest to all ");//sets text
        InterestText1.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));

        AddInterestButton.setText("Add Interest");//sets text
        AddInterestButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AddInterestButtonActionPerformed(evt);
            }
        });

        OverdraftText1.setText("Apply Overdraft Fees for");//sets text
        OverdraftText1.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));

        OverdraftFeeButton.setText("Add Fee");//sets text
        OverdraftFeeButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                OverdraftFeeButtonActionPerformed(evt);
            }
        });

        OverdraftText2.setText("accounts with negative Balances");//sets text

        InterestText2.setText("accounts in your Branch");//sets text

        OverdraftFeeAmountText.setFont(new java.awt.Font("Helvetica Neue", 1, 13)); 
        OverdraftFeeAmountText.setText("The Fee is $35");//sets text

        jLabel1.setText("Choose an account to");//sets text

        jLabel2.setText("add Account Fees");//sets text

        AccountFeeAmountText.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AccountFeeAmountTextActionPerformed(evt);
            }
        });

        AccountFeeButton.setText("Add Fee");//sets text of button
        AccountFeeButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AccountFeeButtonActionPerformed(evt);
            }
        });

        MoneySign1.setText("$");//sets text

        InterestDropDownBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1%", "2%", "3%", "4%" }));
        InterestDropDownBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                InterestDropDownBoxActionPerformed(evt);
            }
        });

        MAnalyticsButton.setText("Analytics");//sets text of button
        MAnalyticsButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MAnalyticsButtonActionPerformed(evt);
            }
        });

        MBranchesButton.setText("Branches");//sets text of button
        MBranchesButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MBranchesButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());//all this sets the layout of the alignment of GUI elements
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(80, 80, 80)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(55, 55, 55)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(OverdraftText2)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(OverdraftFeeAmountText)
                                .addGap(28, 28, 28)
                                .addComponent(OverdraftFeeButton))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(MoneySign1)
                                .addGap(2, 2, 2)
                                .addComponent(AccountFeeAmountText, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(AccountFeeButton))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(71, 71, 71)
                        .addComponent(OverdraftText1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(63, 63, 63)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(InterestText2)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(InterestDropDownBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(AddInterestButton))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(82, 82, 82)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(6, 6, 6)
                                .addComponent(jLabel2))
                            .addComponent(jLabel1)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(82, 82, 82)
                        .addComponent(InterestText1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 311, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(71, 71, 71)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(MAccountTransactionsButton)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(MPendingTransactionsButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(MMonthlyStatementButton, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(17, 17, 17)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(MDeleteButton)
                                    .addComponent(MCreateButton)))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(103, 103, 103)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(MBranchesButton)
                            .addComponent(MAnalyticsButton))))
                .addContainerGap(15, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(76, 76, 76)
                .addComponent(MCreateButton)
                .addGap(27, 27, 27)
                .addComponent(MDeleteButton)
                .addGap(32, 32, 32)
                .addComponent(MAccountTransactionsButton)
                .addGap(18, 18, 18)
                .addComponent(MMonthlyStatementButton)
                .addGap(18, 18, 18)
                .addComponent(MPendingTransactionsButton)
                .addGap(18, 18, 18)
                .addComponent(MAnalyticsButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 19, Short.MAX_VALUE)
                .addComponent(MBranchesButton)
                .addGap(18, 18, 18)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27)
                .addComponent(InterestText1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(InterestText2)
                .addGap(32, 32, 32)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(AddInterestButton)
                    .addComponent(InterestDropDownBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(22, 22, 22)
                .addComponent(OverdraftText1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(OverdraftText2, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(OverdraftFeeButton)
                    .addComponent(OverdraftFeeAmountText))
                .addGap(33, 33, 33)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(AccountFeeAmountText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(AccountFeeButton)
                    .addComponent(MoneySign1))
                .addGap(26, 26, 26))
            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING)
        );

        pack();
    }                       

    private void MCreateButtonActionPerformed(java.awt.event.ActionEvent evt) {//sets action that occurs when button is pressed                                              
        new CreateAccount().setVisible(true);
    }                                             

    private void MDeleteButtonActionPerformed(java.awt.event.ActionEvent evt) {//sets action that occurs when button is pressed
        String selectedAcct = (String) MAccountsTable.getValueAt(MAccountsTable.getSelectedRow(), 0);
        DBConnect database = new DBConnect(Login.username, Login.password);
        try
        {
            Statement stmt = database.connect().createStatement();
            String sql = String.format("delete from Account where acct_num = %s", selectedAcct); //delete account query
            stmt.executeQuery(sql);
            database.connect().close();
        }
        catch(SQLException e)
        {
            System.out.println(e.getMessage());
        }
        try
        { //repopulate table
            int size = 0;
            ResultSet accounts = database.connect().createStatement().executeQuery("Select a.acct_num, a.balance, o.username from Account a natural join Owners o");
            ResultSet sizeResult = database.connect().createStatement().executeQuery("Select COUNT(*) from Account");
            database.connect().close();
            if(sizeResult.next())
            {
                size = sizeResult.getInt(1);
            }
            String[][] data = new String[size][3];
            int i = 0;
            while(accounts.next())
            {
                data[i][0] = accounts.getString("acct_num");
                data[i][1] = String.format("$%.2f", accounts.getDouble("balance"));
                data[i][2] = accounts.getString("username");
                i++;
            }

            MAccountsTable.setModel(new javax.swing.table.DefaultTableModel(
            data,
            new String [] {
                "Accounts", "Balance", "User"
            }
            ));

            MAccountsTable.setRowSelectionAllowed(true);
        }
        catch(SQLException e)
        {
            System.out.print(e.getMessage());
            MAccountsTable.setModel(new javax.swing.table.DefaultTableModel(
            new String [][] {
                {"test", "$1.00"},
                {"test2", "$0.50"}
            },
            new String [] {
                "Accounts", "Balance"
            }));
        }
        


        int viewIndex = MAccountsTable.getSelectedRow();
        if(viewIndex != -1) {
            int modelIndex = MAccountsTable.convertRowIndexToModel(viewIndex);
            DefaultTableModel model = (DefaultTableModel)MAccountsTable.getModel();
            model.removeRow(modelIndex);
        }
    }                                             

    private void MAccountsTableMouseClicked(java.awt.event.MouseEvent evt) {                                            
        System.out.println(MAccountsTable.getSelectedRow());
    }                                           

    private void MMonthlyStatementButtonActionPerformed(java.awt.event.ActionEvent evt) {//sets action that occurs when button is pressed
        String selectedAcct = (String) MAccountsTable.getValueAt(MAccountsTable.getSelectedRow(), 0);                                                        
        new MonthlyStatement(Integer.parseInt(selectedAcct)).setVisible(true);
    }                                                       

    private void MPendingTransactionsButtonActionPerformed(java.awt.event.ActionEvent evt) {//sets action that occurs when button is pressed
        String selectedAcct = (String) MAccountsTable.getValueAt(MAccountsTable.getSelectedRow(), 0);                                                           
        new PendingTransactions(Integer.parseInt(selectedAcct)).setVisible(true); //open pending transactions
    }                                                          

    private void MAccountTransactionsButtonActionPerformed(java.awt.event.ActionEvent evt) {  //sets action that occurs when button is pressed                                                         
        AccountTransactions t = new AccountTransactions();
        t.setVisible(true);
        dispose();
    }                                                          

    private void InterestDropDownBoxActionPerformed(java.awt.event.ActionEvent evt) {                                                    
        
    }                                                   

    private void AddInterestButtonActionPerformed(java.awt.event.ActionEvent evt) {    //sets action that occurs when button is pressed                                              
        DBConnect database = new DBConnect(Login.username, Login.password);
        try
        {
            double interest = Double.parseDouble(InterestDropDownBox.getSelectedItem().toString().substring(0, 1))/100;
            Statement stmt = database.connect().createStatement();
            String sql1 = "select acct_num, balance from Account where type = 'savings'"; //select all accounts to apply interest to
            ResultSet savingsAccts = stmt.executeQuery(sql1);
            while(savingsAccts.next()) //apply interest to all selected accounts
            {
                database.connect().createStatement().executeQuery(String.format("INSERT INTO Transactions(acct_num, type, amount) VALUES (%s, 'deposit', %.2f)", savingsAccts.getString("acct_num"), (savingsAccts.getDouble("balance")*interest)));
            }
            database.connect().close();
            
        }
        catch(SQLException e)
        {
            System.out.println(e.getMessage());
        }
        try
        { //repopulate table
            int size = 0;
            ResultSet accounts = database.connect().createStatement().executeQuery("Select a.acct_num, a.balance, o.username from Account a natural join Owners o");
            ResultSet sizeResult = database.connect().createStatement().executeQuery("Select COUNT(*) from Account");
            database.connect().close();
            if(sizeResult.next())
            {
                size = sizeResult.getInt(1);
            }
            String[][] data = new String[size][3];
            int i = 0;
            while(accounts.next())
            {
                data[i][0] = accounts.getString("acct_num");
                data[i][1] = String.format("$%.2f", accounts.getDouble("balance"));
                data[i][2] = accounts.getString("username");
                i++;
            }

            MAccountsTable.setModel(new javax.swing.table.DefaultTableModel(
            data,
            new String [] {
                "Accounts", "Balance", "User"
            }
            ));
            database.connect().close();
        }
        catch(SQLException e)
        {
            System.out.println(e.getMessage());
        }
    }                                                 

    private void OverdraftFeeButtonActionPerformed(java.awt.event.ActionEvent evt) {//sets action that occurs when button is pressed                                                   
        DBConnect database = new DBConnect(Login.username, Login.password);
        try
        {
            Statement stmt = database.connect().createStatement();
            String sql = "select acct_num from Account where type = 'checking' and balance < 0"; //query to get all accounts with overdraft
            ResultSet checkingAccounts = stmt.executeQuery(sql);
            while(checkingAccounts.next()) //apply overdraft fee to selected accounts
            {
                database.connect().createStatement().executeQuery(String.format("insert into Transactions(acct_num, type, amount) values (%s, 'withdrawal', 35)", checkingAccounts.getString("acct_num")));
            }
            database.connect().close();
        }
        catch(SQLException e)
        {
            System.out.println(e.getMessage());
        }
        try
        { //repopulate table
            int size = 0;
            ResultSet accounts = database.connect().createStatement().executeQuery("Select a.acct_num, a.balance, o.username from Account a natural join Owners o");
            ResultSet sizeResult = database.connect().createStatement().executeQuery("Select COUNT(*) from Account");
            database.connect().close();
            if(sizeResult.next())
            {
                size = sizeResult.getInt(1);
            }
            String[][] data = new String[size][3];
            int i = 0;
            while(accounts.next())
            {
                data[i][0] = accounts.getString("acct_num");
                data[i][1] = String.format("$%.2f", accounts.getDouble("balance"));
                data[i][2] = accounts.getString("username");
                i++;
            }

            MAccountsTable.setModel(new javax.swing.table.DefaultTableModel(
            data,
            new String [] {
                "Accounts", "Balance", "User"
            }
            ));
            database.connect().close();
        }
        catch(SQLException e)
        {
            System.out.println(e.getMessage());
        }
    }                                                  

    private void AccountFeeAmountTextActionPerformed(java.awt.event.ActionEvent evt) {//sets action that occurs when button is pressed                                                     
        
    }                                                    

    private void AccountFeeButtonActionPerformed(java.awt.event.ActionEvent evt) {                                                 
        DBConnect database = new DBConnect(Login.username, Login.password);
        double fee = Double.parseDouble(AccountFeeAmountText.getText()); //set fee amount
        String selectedAcct = (String) MAccountsTable.getValueAt(MAccountsTable.getSelectedRow(), 0);
        try
        {
            Statement stmt = database.connect().createStatement();
            String sql = String.format("insert into Transactions(acct_num, type, amount) values (%s, 'withdrawal', %.2f)", selectedAcct, fee); //apply fee to selected account
            stmt.executeQuery(sql);
            database.connect().close(); 
        }
        catch(SQLException e)
        {
            System.out.println(e.getMessage());
        }
        try
        { //repopulate
            int size = 0;
            ResultSet accounts = database.connect().createStatement().executeQuery("Select a.acct_num, a.balance, o.username from Account a natural join Owners o");
            ResultSet sizeResult = database.connect().createStatement().executeQuery("Select COUNT(*) from Account");
            database.connect().close();
            if(sizeResult.next())
            {
                size = sizeResult.getInt(1);
            }
            String[][] data = new String[size][3];
            int i = 0;
            while(accounts.next())
            {
                data[i][0] = accounts.getString("acct_num");
                data[i][1] = String.format("$%.2f", accounts.getDouble("balance"));
                data[i][2] = accounts.getString("username");
                i++;
            }

            MAccountsTable.setModel(new javax.swing.table.DefaultTableModel(
            data,
            new String [] {
                "Accounts", "Balance", "User"
            }
            ));
            database.connect().close();
        }
        catch(SQLException e)
        {
            System.out.println(e.getMessage());
        }

        
    }     
    private void MAnalyticsButtonActionPerformed(java.awt.event.ActionEvent evt) {  //sets action that occurs when button is pressed                                               
        new Analytics().setVisible(true); //open analytics page
    }                  
    
    private void MBranchesButtonActionPerformed(java.awt.event.ActionEvent evt) {  //sets action that occurs when button is pressed                                              
        new Branches().setVisible(true); //open branches page
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ManagerAccountManagement().setVisible(true);
            }
        });
    }
                   
    private javax.swing.JTextField AccountFeeAmountText;// This is where the variables are declared
    private javax.swing.JButton AccountFeeButton;
    private javax.swing.JButton AddInterestButton;
    private javax.swing.JComboBox<String> InterestDropDownBox;
    private javax.swing.JLabel InterestText1;
    private javax.swing.JLabel InterestText2;
    private javax.swing.JButton MAccountTransactionsButton;
    private javax.swing.JTable MAccountsTable;
    private javax.swing.JButton MAnalyticsButton;
    private javax.swing.JButton MBranchesButton;
    private javax.swing.JButton MCreateButton;
    private javax.swing.JButton MDeleteButton;
    private javax.swing.JButton MMonthlyStatementButton;
    private javax.swing.JButton MPendingTransactionsButton;
    private javax.swing.JLabel MoneySign1;
    private javax.swing.JLabel OverdraftFeeAmountText;
    private javax.swing.JButton OverdraftFeeButton;
    private javax.swing.JLabel OverdraftText1;
    private javax.swing.JLabel OverdraftText2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;                 
}