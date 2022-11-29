package test.java;

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

        Withdraw = new javax.swing.JLabel();
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

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        Withdraw.setText("Withdrawl");

        AccountTransactionsMain.setFont(new java.awt.Font("Helvetica Neue", 1, 24)); // NOI18N
        AccountTransactionsMain.setText("Account Transactions");

        EnterAmount1.setText("Enter Amount:");

        WithdrawAccountName.setText("Enter Account Name:");

        DepositAccountName.setText("Enter Account Name:");

        Deposit.setText("Deposit");

        EnterAmount2.setText("Enter Amount:");

        TranferFromAccount.setText("From (Account Name):");

        Tranfer.setText("Transfer");

        EnterAmount3.setText("Enter Amount:");

        ExTransferFromAccount.setText("From (Account Name):");

        ExTransfer.setText("External Transfer");

        EnterAmount4.setText("Enter Amount:");

        WithdrawToAccount.setText("To (Account Name):");

        ExTransferToAccount.setText("To (Account Name):");

        MoneySign4.setText("$");

        MoneySign1.setText("$");

        MoneySign2.setText("$");

        MoneySign3.setText("$");

        ExTransferButton.setText("Ex. Transfer");

        WithdrawButton.setText("Withdraw");

        TransferButton.setText("Transfer");

        DepositButton.setText("Deposit");

        jSeparator1.setOrientation(javax.swing.SwingConstants.VERTICAL);

        jSeparator2.setOrientation(javax.swing.SwingConstants.VERTICAL);

        jSeparator3.setOrientation(javax.swing.SwingConstants.VERTICAL);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
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
        
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(AccountTransactions.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AccountTransactions.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AccountTransactions.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AccountTransactions.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AccountTransactions().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify                     
    private javax.swing.JLabel AccountTransactionsMain;
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
    // End of variables declaration                   
}
