package test.java;

import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author fmeraz
 */
public class AccountTransactions extends javax.swing.JFrame {

    
    public AccountTransactions() {
        initComponents();
    }

    
    //@SuppressWarnings("unchecked")
                           
    private void initComponents() {

        Withdraw = new javax.swing.JLabel(); //Creates all the variables in the GUI
        AccountTransactionsMain = new javax.swing.JLabel();
        EnterAmount1 = new javax.swing.JLabel();
        WithdrawEnterAmount = new javax.swing.JTextField();
        WithdrawAccountName = new javax.swing.JLabel();
        WithdrawEnterAccountName = new javax.swing.JTextField();
        DepositAccountName = new javax.swing.JLabel();
        DepositEnterAccountName = new javax.swing.JTextField();
        Deposit = new javax.swing.JLabel();
        EnterAmount2 = new javax.swing.JLabel();
        DepositEnterAmount = new javax.swing.JTextField();
        TranferFromAccount = new javax.swing.JLabel();
        ExTransferEnterAmount = new javax.swing.JTextField();
        TranferEnterFromAccount = new javax.swing.JTextField();
        Tranfer = new javax.swing.JLabel();
        EnterAmount3 = new javax.swing.JLabel();
        ExTransferFromAccount = new javax.swing.JLabel();
        TransferEnterAmount = new javax.swing.JTextField();
        ExTransferEnterFromAccount = new javax.swing.JTextField();
        ExTransfer = new javax.swing.JLabel();
        EnterAmount4 = new javax.swing.JLabel();
        WithdrawToAccount = new javax.swing.JLabel();
        WithdrawEnterToAccount = new javax.swing.JTextField();
        ExTransferToAccount = new javax.swing.JLabel();
        ExTransferEnterToAccount = new javax.swing.JTextField();
        MoneySign4 = new javax.swing.JLabel();
        MoneySign1 = new javax.swing.JLabel();
        MoneySign2 = new javax.swing.JLabel();
        MoneySign3 = new javax.swing.JLabel();
        ExTransferButton = new javax.swing.JButton();
        WithdrawButton = new javax.swing.JButton();
        TransferButton = new javax.swing.JButton();
        DepositButton = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();
        jSeparator2 = new javax.swing.JSeparator();
        jSeparator3 = new javax.swing.JSeparator();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        Withdraw.setText("Withdrawl");

        AccountTransactionsMain.setFont(new java.awt.Font("Helvetica Neue", 1, 24)); //sets the font, style, and size of the text
        AccountTransactionsMain.setText("Account Transactions");//sets text

        EnterAmount1.setText("Enter Amount:");//sets text

        WithdrawAccountName.setText("Enter Account Name:");//sets text

        DepositAccountName.setText("Enter Account Name:");//sets text

        Deposit.setText("Deposit");//sets text

        EnterAmount2.setText("Enter Amount:");//sets text

        TranferFromAccount.setText("From (Account Name):");//sets text

        Tranfer.setText("Transfer");//sets text

        EnterAmount3.setText("Enter Amount:");//sets text

        ExTransferFromAccount.setText("From (Account Name):");//sets text

        ExTransfer.setText("External Transfer");//sets text

        EnterAmount4.setText("Enter Amount:");//sets text

        WithdrawToAccount.setText("To (Account Name):");//sets text

        ExTransferToAccount.setText("To (Account Name):");//sets text

        MoneySign4.setText("$");//sets text

        MoneySign1.setText("$");//sets text

        MoneySign2.setText("$");//sets text

        MoneySign3.setText("$");//sets text

        ExTransferButton.setText("Ex. Transfer");//sets text of button

        ExTransferButton.addActionListener(new java.awt.event.ActionListener() {//sets the action that occurs when button is pressed
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DBConnect database = new DBConnect(Login.username, Login.password);
                try
                {
                    Statement stmt = database.connect().createStatement();
                    double amount = Double.parseDouble(ExTransferEnterAmount.getText());
                    String sql = String.format("INSERT INTO Transactions(acct_num, type, amount) VALUES (%s, 'withdrawal', %.2f)", ExTransferEnterFromAccount.getText(), amount);
                    stmt.executeQuery(sql);
                    database.connect().close();
                }
                catch(SQLException e)
                {
                    System.out.println(e.getMessage());
                }
                finally
                {
                    if(Login.role.equals("manager"))
                    {
                        new ManagerAccountManagement().setVisible(true);
                    }
                    else
                    {
                        new AccountManagement().setVisible(true);
                    }
                    dispose();
                }
            }
        });

        WithdrawButton.setText("Withdraw");//sets text of button
        
        WithdrawButton.addActionListener(new java.awt.event.ActionListener() {//sets the action that occurs when button is pressed
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DBConnect database = new DBConnect(Login.username, Login.password);
                try
                {
                    Statement stmt = database.connect().createStatement();
                    double amount = Double.parseDouble(WithdrawEnterAmount.getText());
                    String sql = String.format("INSERT INTO Transactions(acct_num, type, amount) VALUES (%s, 'withdrawal', %.2f)", WithdrawEnterAccountName.getText(), amount);

                    stmt.executeQuery(sql);
                    database.connect().close();
                }
                catch(SQLException e)
                {
                    System.out.println(e.getMessage());
                }
                finally
                {
                    //new AccountManagement().setVisible(true);
                    if(Login.role.equals("manager"))
                    {
                        new ManagerAccountManagement().setVisible(true);
                    }
                    else
                    {
                        new AccountManagement().setVisible(true);
                    }
                    dispose();
                }
            }
        });

        TransferButton.setText("Transfer");//sets button text

        TransferButton.addActionListener(new java.awt.event.ActionListener() {//sets the action that occurs when button is pressed
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                System.out.println(ExTransferEnterToAccount.getText());
                DBConnect user = new DBConnect(Login.username, Login.password);
                DBConnect admin = new DBConnect("postgres", "bball0128");
                try
                {
                    
                    Statement stmt = user.connect().createStatement();
                    double amount = Double.parseDouble(TransferEnterAmount.getText());
                    String sql = String.format("INSERT INTO Transactions(acct_num, type, amount) VALUES (%s, 'withdrawal', %.2f)", TranferEnterFromAccount.getText(), amount);
                    stmt.executeQuery(sql);
                    user.connect().close();
                    Statement stmt2 = admin.connect().createStatement();
                    String sql2 = String.format("INSERT INTO Transactions(acct_num, type, amount) VALUES (%s, 'deposit', %.2f)", WithdrawEnterToAccount.getText(), amount);
                    stmt2.executeQuery(sql2);
                    admin.connect().close();
                }
                catch(SQLException e)
                {
                    System.out.println(e.getMessage());
                }
                finally
                {
                    if(Login.role.equals("manager"))
                    {
                        new ManagerAccountManagement().setVisible(true);
                    }
                    else
                    {
                        new AccountManagement().setVisible(true);
                    }
                    dispose();
                }
            }
        });

        DepositButton.setText("Deposit");
        
        DepositButton.addActionListener(new java.awt.event.ActionListener() {//sets the action that occurs when button is pressed
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DBConnect database = new DBConnect(Login.username, Login.password);
                try
                {
                    Statement stmt = database.connect().createStatement();
                    double amount = Double.parseDouble(DepositEnterAmount.getText());
                    String sql = String.format("INSERT INTO Transactions(acct_num, type, amount) VALUES (%s, 'deposit', %.2f)", DepositEnterAccountName.getText(), amount);
                    stmt.executeQuery(sql);
                    database.connect().close();
                }
                catch(SQLException e)
                {
                    System.out.println(e.getMessage());
                }
                finally
                {
                    if(Login.role.equals("manager"))
                    {
                        new ManagerAccountManagement().setVisible(true);
                    }
                    else
                    {
                        new AccountManagement().setVisible(true);
                    }
                    dispose();
                }
            }
        });

        jSeparator1.setOrientation(javax.swing.SwingConstants.VERTICAL);

        jSeparator2.setOrientation(javax.swing.SwingConstants.VERTICAL);

        jSeparator3.setOrientation(javax.swing.SwingConstants.VERTICAL);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane()); //all this sets the layout of the alignment of GUI elements
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(1, 1, 1)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(EnterAmount1)
                            .addComponent(Withdraw)))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(WithdrawAccountName)
                        .addComponent(WithdrawEnterAccountName, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(MoneySign1)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(WithdrawEnterAmount, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(1, 1, 1)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(Deposit)
                            .addComponent(EnterAmount2)))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(DepositAccountName)
                        .addComponent(DepositEnterAccountName, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(MoneySign2)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(DepositEnterAmount, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 7, Short.MAX_VALUE)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(17, 17, 17)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(Tranfer)
                            .addComponent(EnterAmount3)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(MoneySign3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(TransferEnterAmount, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(7, 7, 7))
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(TranferFromAccount)
                                .addComponent(TranferEnterFromAccount, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(WithdrawToAccount)
                                .addComponent(WithdrawEnterToAccount, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addGap(18, 18, 18)
                .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 28, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(ExTransfer)
                    .addComponent(EnterAmount4)
                    .addComponent(ExTransferFromAccount)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(MoneySign4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(ExTransferEnterAmount, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(ExTransferEnterFromAccount, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ExTransferToAccount)
                    .addComponent(ExTransferEnterToAccount, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(28, 28, 28))
            .addGroup(layout.createSequentialGroup()
                .addGap(38, 38, 38)
                .addComponent(WithdrawButton)
                .addGap(63, 63, 63)
                .addComponent(DepositButton)
                .addGap(77, 77, 77)
                .addComponent(TransferButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(ExTransferButton)
                .addGap(42, 42, 42))
            .addGroup(layout.createSequentialGroup()
                .addGap(203, 203, 203)
                .addComponent(AccountTransactionsMain)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(AccountTransactionsMain, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                            .addGap(18, 18, 18)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 282, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 282, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(layout.createSequentialGroup()
                                    .addGap(9, 9, 9)
                                    .addComponent(Deposit)
                                    .addGap(18, 18, 18)
                                    .addComponent(EnterAmount2)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(DepositEnterAmount, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(MoneySign2))
                                    .addGap(24, 24, 24)
                                    .addComponent(DepositAccountName)
                                    .addGap(18, 18, 18)
                                    .addComponent(DepositEnterAccountName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 282, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGroup(layout.createSequentialGroup()
                            .addGap(27, 27, 27)
                            .addComponent(Tranfer)
                            .addGap(18, 18, 18)
                            .addComponent(EnterAmount3)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(layout.createSequentialGroup()
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(TransferEnterAmount, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(MoneySign3))
                                    .addGap(59, 59, 59)
                                    .addComponent(TranferEnterFromAccount, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(layout.createSequentialGroup()
                                    .addGap(47, 47, 47)
                                    .addComponent(TranferFromAccount)
                                    .addGap(41, 41, 41)))
                            .addGap(29, 29, 29)
                            .addComponent(WithdrawToAccount)
                            .addGap(18, 18, 18)
                            .addComponent(WithdrawEnterToAccount, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(ExTransfer)
                            .addGap(18, 18, 18)
                            .addComponent(EnterAmount4)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(ExTransferEnterAmount, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(MoneySign4))
                            .addGap(24, 24, 24)
                            .addComponent(ExTransferFromAccount)
                            .addGap(18, 18, 18)
                            .addComponent(ExTransferEnterFromAccount, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(29, 29, 29)
                            .addComponent(ExTransferToAccount)
                            .addGap(18, 18, 18)
                            .addComponent(ExTransferEnterToAccount, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(16, 16, 16)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(27, 27, 27)
                        .addComponent(Withdraw)
                        .addGap(18, 18, 18)
                        .addComponent(EnterAmount1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(WithdrawEnterAmount, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(MoneySign1))
                        .addGap(24, 24, 24)
                        .addComponent(WithdrawAccountName)
                        .addGap(18, 18, 18)
                        .addComponent(WithdrawEnterAccountName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(40, 40, 40)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(DepositButton)
                    .addComponent(TransferButton)
                    .addComponent(ExTransferButton)
                    .addComponent(WithdrawButton))
                .addContainerGap(47, Short.MAX_VALUE))
        );

        pack();
    }    
    
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AccountTransactions().setVisible(true);
            }
        });
    }
               
    private javax.swing.JLabel AccountTransactionsMain; // This is where the variables are declared
    private javax.swing.JLabel Deposit;
    private javax.swing.JLabel DepositAccountName;
    private javax.swing.JButton DepositButton;
    private javax.swing.JTextField DepositEnterAccountName;
    private javax.swing.JTextField DepositEnterAmount;
    private javax.swing.JLabel EnterAmount1;
    private javax.swing.JLabel EnterAmount2;
    private javax.swing.JLabel EnterAmount3;
    private javax.swing.JLabel EnterAmount4;
    private javax.swing.JLabel ExTransfer;
    private javax.swing.JButton ExTransferButton;
    private javax.swing.JTextField ExTransferEnterAmount;
    private javax.swing.JTextField ExTransferEnterFromAccount;
    private javax.swing.JTextField ExTransferEnterToAccount;
    private javax.swing.JLabel ExTransferFromAccount;
    private javax.swing.JLabel ExTransferToAccount;
    private javax.swing.JLabel MoneySign1;
    private javax.swing.JLabel MoneySign2;
    private javax.swing.JLabel MoneySign3;
    private javax.swing.JLabel MoneySign4;
    private javax.swing.JLabel Tranfer;
    private javax.swing.JTextField TranferEnterFromAccount;
    private javax.swing.JLabel TranferFromAccount;
    private javax.swing.JButton TransferButton;
    private javax.swing.JTextField TransferEnterAmount;
    private javax.swing.JLabel Withdraw;
    private javax.swing.JLabel WithdrawAccountName;
    private javax.swing.JButton WithdrawButton;
    private javax.swing.JTextField WithdrawEnterAccountName;
    private javax.swing.JTextField WithdrawEnterAmount;
    private javax.swing.JTextField WithdrawEnterToAccount;
    private javax.swing.JLabel WithdrawToAccount;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;                
}
