package test.java;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.ListSelectionModel;
import javax.swing.table.*;

/**
 *
 * @author fmeraz
 */
public class AccountManagement extends javax.swing.JFrame {

   
    public AccountManagement() {
        initComponents();
    }

    //@SuppressWarnings("unchecked")
                           
    private void initComponents() {

        

        jMenuItem1 = new javax.swing.JMenuItem(); //Creates all the variables in the GUI
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenuItem6 = new javax.swing.JMenuItem();
        jScrollPane1 = new javax.swing.JScrollPane();
        AccountsTable = new javax.swing.JTable();
        AccountTransactionsButton = new javax.swing.JButton();
        CreateButton = new javax.swing.JButton();
        DeleteButton = new javax.swing.JButton();
        MonthlyStatementButton = new javax.swing.JButton();
        PendingTransactionsButton = new javax.swing.JButton();

        jMenuItem1.setText("jMenuItem1");

        jMenuItem2.setText("jMenuItem2");

        jMenuItem6.setText("jMenuItem6");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        AccountsTable.setModel(new javax.swing.table.DefaultTableModel(
            new String [][] {
                {"test"},
                {"test2"}
            },
            new String [] {
                "Accounts"
            }
        ));
        AccountsTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                AccountsTableMouseClicked(evt);
            }
        });

        jScrollPane1.setViewportView(AccountsTable);

        AccountTransactionsButton.setText("Account Transactions"); //sets the text of the button
        AccountTransactionsButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AccountTransactionsButtonActionPerformed(evt);
            }
        });

        CreateButton.setText("Create Account"); //sets the text of the button
        CreateButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CreateButtonActionPerformed(evt);
            }
        });

        DeleteButton.setText("Delete Account"); //sets the text of the button
        DeleteButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DeleteButtonActionPerformed(evt);
            }
        });

        MonthlyStatementButton.setText("Monthly Statement"); //sets the text of the button
        MonthlyStatementButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MonthlyStatementButtonActionPerformed(evt);
            }
        });

        PendingTransactionsButton.setText("Pending Transactions"); //sets the text of the button
        PendingTransactionsButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PendingTransactionsButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane()); //all this sets the layout of the alignment of GUI elements
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(80, 80, 80)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(AccountTransactionsButton)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(PendingTransactionsButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(MonthlyStatementButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(DeleteButton)
                            .addComponent(CreateButton))))
                .addContainerGap(39, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addComponent(CreateButton)
                .addGap(18, 18, 18)
                .addComponent(DeleteButton)
                .addGap(82, 82, 82)
                .addComponent(AccountTransactionsButton)
                .addGap(18, 18, 18)
                .addComponent(MonthlyStatementButton)
                .addGap(18, 18, 18)
                .addComponent(PendingTransactionsButton)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 501, Short.MAX_VALUE)
        );

        DBConnect database = new DBConnect(Login.username, Login.password);
        try  
        { //populate AccountsTable with acct_num and balance
            int size = 0;
            ResultSet accounts = database.connect().createStatement().executeQuery("Select acct_num, balance from Account");
            ResultSet sizeResult = database.connect().createStatement().executeQuery("Select COUNT(*) from Account");
            database.connect().close();
            if(sizeResult.next())
            {
                size = sizeResult.getInt(1);
            }
            String[][] data = new String[size][2];
            int i = 0;
            while(accounts.next())
            {
                data[i][0] = accounts.getString("acct_num");
                data[i][1] = String.format("$%.2f", accounts.getDouble("balance"));
                i++;
            }

            AccountsTable.setModel(new javax.swing.table.DefaultTableModel(//names the columns of the table
            data,
            new String [] {
                "Accounts", "Balance"
            }
            ));

            AccountsTable.setRowSelectionAllowed(true);
        } 
        catch(SQLException e)
        {
            System.out.print(e.getMessage());
            AccountsTable.setModel(new javax.swing.table.DefaultTableModel(
            new String [][] {
                {"test", "$1.00"},
                {"test2", "$0.50"}
            },
            new String [] {
                "Accounts", "Balance"
            }));
        }


        pack();
    }                       

    private void AccountsTableMouseClicked(java.awt.event.MouseEvent evt) {//Sets what happens when rows on a table are clicked on                           
        System.out.println(AccountsTable.getSelectedRow());              
    }                                          

    private void AccountTransactionsButtonActionPerformed(java.awt.event.ActionEvent evt) {//Sets action that occurs when button is pressed                                                          
        new AccountTransactions().setVisible(true);
        dispose();
    }                                                         

    private void DeleteButtonActionPerformed(java.awt.event.ActionEvent evt) { //Sets action that occurs when button is pressed                                            
        String selectedAcct = (String) AccountsTable.getValueAt(AccountsTable.getSelectedRow(), 0);
        DBConnect database = new DBConnect(Login.username, Login.password);
        try
        {
            Statement stmt = database.connect().createStatement();
            String sql = String.format("delete from Account where acct_num = %s", selectedAcct);
            stmt.executeQuery(sql);
            database.connect().close();
        }
        catch(SQLException e)
        {
            System.out.println(e.getMessage());
        }
        try
        {
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

            AccountsTable.setModel(new javax.swing.table.DefaultTableModel(
            data,
            new String [] {
                "Accounts", "Balance", "User"
            }
            ));

            AccountsTable.setRowSelectionAllowed(true);
        }
        catch(SQLException e)
        {
            System.out.print(e.getMessage());
            AccountsTable.setModel(new javax.swing.table.DefaultTableModel(
            new String [][] {
                {"test", "$1.00"},
                {"test2", "$0.50"}
            },
            new String [] {
                "Accounts", "Balance"
            }));
        }
    }                                            

    private void MonthlyStatementButtonActionPerformed(java.awt.event.ActionEvent evt) { //Sets action that occurs when button is pressed     
        String selectedAcct = (String) AccountsTable.getValueAt(AccountsTable.getSelectedRow(), 0);
        new MonthlyStatement(Integer.parseInt(selectedAcct)).setVisible(true); //open MonthlyStatement GUI
    }                                                      

    private void PendingTransactionsButtonActionPerformed(java.awt.event.ActionEvent evt) { //Sets action that occurs when button is pressed
        String selectedAcct = (String) AccountsTable.getValueAt(AccountsTable.getSelectedRow(), 0);                                                          
        new PendingTransactions(Integer.parseInt(selectedAcct)).setVisible(true); //open Transactions GUI
    }                                                         

    private void CreateButtonActionPerformed(java.awt.event.ActionEvent evt) { //Sets action that occurs when button is pressed                                       
        new CreateAccount().setVisible(true); //open create account GUI
    }

    
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {

        
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                AccountManagement gui = new AccountManagement();
                gui.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
                gui.setVisible(true);
            }
        });
    }
                     
    private javax.swing.JButton AccountTransactionsButton; // This is where the variables are declared
    private javax.swing.JTable AccountsTable;
    private javax.swing.JButton CreateButton;
    private javax.swing.JButton DeleteButton;
    private javax.swing.JButton MonthlyStatementButton;
    private javax.swing.JButton PendingTransactionsButton;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem6;
    private javax.swing.JScrollPane jScrollPane1;
}
