package test.java;

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

        jMenuItem1 = new javax.swing.JMenuItem();
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
            new Object [][] {
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

        AccountTransactionsButton.setText("Account Transactions");
        AccountTransactionsButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AccountTransactionsButtonActionPerformed(evt);
            }
        });

        CreateButton.setText("Create Account");
        CreateButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CreateButtonActionPerformed(evt);
            }
        });

        DeleteButton.setText("Delete Account");
        DeleteButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DeleteButtonActionPerformed(evt);
            }
        });

        MonthlyStatementButton.setText("Monthly Statement");
        MonthlyStatementButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MonthlyStatementButtonActionPerformed(evt);
            }
        });

        PendingTransactionsButton.setText("Pending Transactions");
        PendingTransactionsButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PendingTransactionsButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
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

        pack();
    }// </editor-fold>                        

    private void AccountsTableMouseClicked(java.awt.event.MouseEvent evt) {                                           
        
    }                                          

    private void AccountTransactionsButtonActionPerformed(java.awt.event.ActionEvent evt) {                                                          
        new AccountTransactions().setVisible(true);
    }                                                         

    private void DeleteButtonActionPerformed(java.awt.event.ActionEvent evt) {                                             
   
        int viewIndex = AccountsTable.getSelectedRow();
    if(viewIndex != -1) {
        int modelIndex = AccountsTable.convertRowIndexToModel(viewIndex);
        DefaultTableModel model = (DefaultTableModel)AccountsTable.getModel();
        model.removeRow(modelIndex);
    }
    }                                            

    private void MonthlyStatementButtonActionPerformed(java.awt.event.ActionEvent evt) {                                                       
        new MonthlyStatement().setVisible(true);
    }                                                      

    private void PendingTransactionsButtonActionPerformed(java.awt.event.ActionEvent evt) {                                                          
        new PendingTransactions().setVisible(true);
    }                                                         

    private void CreateButtonActionPerformed(java.awt.event.ActionEvent evt) {                                             
        
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
            java.util.logging.Logger.getLogger(AccountManagement.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AccountManagement.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AccountManagement.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AccountManagement.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        

        
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AccountManagement().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify                     
    private javax.swing.JButton AccountTransactionsButton;
    private javax.swing.JTable AccountsTable;
    private javax.swing.JButton CreateButton;
    private javax.swing.JButton DeleteButton;
    private javax.swing.JButton MonthlyStatementButton;
    private javax.swing.JButton PendingTransactionsButton;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem6;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration                   
}
