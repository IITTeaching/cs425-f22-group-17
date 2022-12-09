
package test.java;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author fmeraz
 */
public class PendingTransactions extends javax.swing.JFrame {

    private int acct;
    
    public PendingTransactions(int acct){
        this.acct = acct;
        initComponents();
        
    }

    
    @SuppressWarnings("unchecked")
                             
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane(); //Creates all the variables in the GUI
        PendingTransactionsTable = new javax.swing.JTable();
        PendingTransactionsLabel = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        DBConnect database = new DBConnect(Login.username, Login.password);
        try
        {
            int size = 0;
            String sql1 = String.format("select id, type, amount, date from Transactions where DATE_PART('month', date) = DATE_PART('month', CURRENT_DATE) and DATE_PART('year', date) = DATE_PART('year', CURRENT_DATE) AND acct_num = %s", this.acct); //selects all transactions for the account in the current month
            String sql2 = String.format("select COUNT(*) from Transactions where DATE_PART('month', date) = DATE_PART('month', CURRENT_DATE) AND DATE_PART('year', date) = DATE_PART('year', CURRENT_DATE) AND acct_num = %s", this.acct);
            ResultSet data = database.connect().createStatement().executeQuery(sql1);
            ResultSet sizeRs = database.connect().createStatement().executeQuery(sql2);
            if(sizeRs.next())
            {
                size = sizeRs.getInt(1);
            }

            Object [][] rows = new Object[size][4];
            int i = 0;
            while(data.next()) //populate table
            {
                rows[i][0] = data.getInt("id");
                rows[i][1] = data.getString("type");
                rows[i][2] = String.format("$%.2f", data.getDouble("amount"));
                rows[i][3] = data.getString("date");
                i++;
            }

            PendingTransactionsTable.setModel(new javax.swing.table.DefaultTableModel(
                rows,
                new String [] {
                    "Transactions", "Type", "Amount", "Date"
                }
            ));

            database.connect().close();
        }
        catch(SQLException e)
        {
            System.out.println(e.getMessage());
            PendingTransactionsTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null},
                {null},
                {null},
                {null}
            },
            new String [] {
                "Pending Transactions"
            }
        ));
        }
        jScrollPane1.setViewportView(PendingTransactionsTable);

        PendingTransactionsLabel.setFont(new java.awt.Font("Helvetica Neue", 1, 24)); //sets the font, style, and size of the text
        PendingTransactionsLabel.setText("Pending Transactions");//sets the text of the label

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());//all this sets the layout of the alignment of GUI elements
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(110, 110, 110)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(207, 207, 207)
                        .addComponent(PendingTransactionsLabel)))
                .addContainerGap(117, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(PendingTransactionsLabel)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 400, Short.MAX_VALUE))
        );

        pack();
    }                       

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
       
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                //new PendingTransactions().setVisible(true);
            }
        });
    }

    private javax.swing.JLabel PendingTransactionsLabel;// This is where the variables are declared
    private javax.swing.JTable PendingTransactionsTable;
    private javax.swing.JScrollPane jScrollPane1;
            
}

