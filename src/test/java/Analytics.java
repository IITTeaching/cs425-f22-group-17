package test.java;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author fmeraz
 */
public class Analytics extends javax.swing.JFrame {

    public Analytics() {
        initComponents();
    }

    
    @SuppressWarnings("unchecked")
                         
    private void initComponents() {

        AnalyticsLabel = new javax.swing.JLabel(); //Creates all the labels in the GUI
        NetWorthLabel = new javax.swing.JLabel();
        NetWorthLabel2 = new javax.swing.JLabel();
        MoneySignLabel = new javax.swing.JLabel();
        NetWorthAmountLabel = new javax.swing.JLabel();
        TotalConsumersLabel = new javax.swing.JLabel();
        TotalConsumersAmountLabel = new javax.swing.JLabel();
        TotalCheckingLabel = new javax.swing.JLabel();
        TotalCheckingAmountLabel = new javax.swing.JLabel();
        TotalSavingsLabel = new javax.swing.JLabel();
        TotalSavingsAmountLabel = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        AnalyticsLabel.setFont(new java.awt.Font("Helvetica Neue", 1, 24)); //sets the font, style, and size of the text
        AnalyticsLabel.setText("Analytics"); //sets the actual text

        NetWorthLabel.setFont(new java.awt.Font("Helvetica Neue", 1, 13)); //sets the font, style, and size of the text
        NetWorthLabel.setText("Total Net Worth of of "); //sets the actual text

        NetWorthLabel2.setFont(new java.awt.Font("Helvetica Neue", 1, 13)); //sets the font, style, and size of the text
        NetWorthLabel2.setText("all consumers in this Branch:"); //sets the actual text

        MoneySignLabel.setText("$"); //sets the actual text

        DBConnect database = new DBConnect(Login.username, Login.password);

        try
        {
            Statement stmt = database.connect().createStatement();
            String sql = "select sum(balance) from Account";
            ResultSet sum = stmt.executeQuery(sql);
            if(sum.next())
            {
                NetWorthAmountLabel.setText(sum.getString(1));
            }
            database.connect().close();
        }
        catch(SQLException e)
        {
            NetWorthAmountLabel.setText("jLabel5");
        }

        TotalConsumersLabel.setFont(new java.awt.Font("Helvetica Neue", 1, 13)); //sets the font, style, and size of the text
        TotalConsumersLabel.setText("Total Number of Consumers:"); //sets the actual text

        try
        {
            Statement stmt = database.connect().createStatement();
            String sql = "select count(*) from Customer";
            ResultSet rs = stmt.executeQuery(sql);
            if(rs.next())
            {
                TotalConsumersAmountLabel.setText(rs.getString(1));
            }
            database.connect().close();
        }
        catch(SQLException e)
        {
            TotalConsumersAmountLabel.setText("jLabel7");
        }


        TotalCheckingLabel.setFont(new java.awt.Font("Helvetica Neue", 1, 13)); //sets the font, style, and size of the text
        TotalCheckingLabel.setText("Total Number of Checking Accounts:"); //sets the actual text

        try
        {
            Statement stmt = database.connect().createStatement();
            String sql = "select count(*) from Account where type = 'checking'";
            ResultSet rs = stmt.executeQuery(sql);
            if(rs.next())
            {
                TotalCheckingAmountLabel.setText(rs.getString(1));
            }
            database.connect().close();
        }
        catch(SQLException e)
        {
            TotalCheckingAmountLabel.setText("jLabel9");
        }

        TotalSavingsLabel.setFont(new java.awt.Font("Helvetica Neue", 1, 13)); //sets the font, style, and size of the text
        TotalSavingsLabel.setText("Total Number of Savings Accounts:"); //sets the actual text

        try
        {
            Statement stmt = database.connect().createStatement();
            String sql = "select count(*) from Account where type = 'savings'";
            ResultSet rs = stmt.executeQuery(sql);
            if(rs.next())
            {
                TotalSavingsAmountLabel.setText(rs.getString(1));
            }
            database.connect().close();
        }
        catch(SQLException e)
        {
            TotalSavingsAmountLabel.setText("jLabel11");
        }

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane()); //all this sets the layout of the alignment of GUI elements
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(51, 51, 51)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(NetWorthLabel2)
                            .addComponent(TotalConsumersLabel)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(24, 24, 24)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(NetWorthLabel)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(9, 9, 9)
                                        .addComponent(AnalyticsLabel))))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(102, 102, 102)
                        .addComponent(MoneySignLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(NetWorthAmountLabel))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(114, 114, 114)
                        .addComponent(TotalConsumersAmountLabel))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(112, 112, 112)
                        .addComponent(TotalCheckingAmountLabel))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(109, 109, 109)
                        .addComponent(TotalSavingsAmountLabel))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(31, 31, 31)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(TotalSavingsLabel)
                            .addComponent(TotalCheckingLabel))))
                .addContainerGap(30, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(AnalyticsLabel)
                .addGap(45, 45, 45)
                .addComponent(NetWorthLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(NetWorthLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(MoneySignLabel)
                    .addComponent(NetWorthAmountLabel))
                .addGap(38, 38, 38)
                .addComponent(TotalConsumersLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(TotalConsumersAmountLabel)
                .addGap(45, 45, 45)
                .addComponent(TotalCheckingLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(TotalCheckingAmountLabel)
                .addGap(38, 38, 38)
                .addComponent(TotalSavingsLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(TotalSavingsAmountLabel)
                .addContainerGap(61, Short.MAX_VALUE))
        );

        pack();
    }                       

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Analytics().setVisible(true);
            }
        });
    }
                        
    private javax.swing.JLabel AnalyticsLabel; // This is where the variables are declared
    private javax.swing.JLabel MoneySignLabel;
    private javax.swing.JLabel NetWorthAmountLabel;
    private javax.swing.JLabel NetWorthLabel;
    private javax.swing.JLabel NetWorthLabel2;
    private javax.swing.JLabel TotalCheckingAmountLabel;
    private javax.swing.JLabel TotalCheckingLabel;
    private javax.swing.JLabel TotalConsumersAmountLabel;
    private javax.swing.JLabel TotalConsumersLabel;
    private javax.swing.JLabel TotalSavingsAmountLabel;
    private javax.swing.JLabel TotalSavingsLabel;                
}
