package test.java;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author fmeraz
 */
public class Branches extends javax.swing.JFrame {

    public Branches() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
                             
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel(); //Creates all the variables in the GUI
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Helvetica Neue", 1, 24)); //sets the font, style, and size of the text
        jLabel1.setText("Branch Locations");//sets text of label

        DBConnect database = new DBConnect(Login.username, Login.password);

        try
        {
            int size = 0;
            Statement stmt = database.connect().createStatement();
            String sql = "select addr_num, street, city, state from Branch";
            ResultSet branches = stmt.executeQuery(sql);
            ResultSet rs = database.connect().createStatement().executeQuery("select count(*) from Branch");
            if(rs.next())
            {
                size = rs.getInt(1);
            }
            String[][] rows = new String[size][4];
            int i = 0;
            while(branches.next())
            {
                rows[i][0] = branches.getString("addr_num");
                rows[i][1] = branches.getString("street");
                rows[i][2] = branches.getString("city");
                rows[i][3] = branches.getString("state");
                i++;
            }
            jTable1.setModel(new javax.swing.table.DefaultTableModel(
            rows,
            new String [] {
                "Address", "Street", "City", "State"
            }
            ));
        }
        catch(SQLException e)
        {
            System.out.println(e.getMessage());
            jTable1.setModel(new javax.swing.table.DefaultTableModel(
                new Object [][] {
                    {null, null, null, null},
                    {null, null, null, null},
                    {null, null, null, null},
                    {null, null, null, null}
                },
                new String [] {
                    "Address", "Street", "City", "State"
                }
            ));
        }
        
        jScrollPane1.setViewportView(jTable1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());//all this sets the layout of the alignment of GUI elements
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(194, 194, 194)
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(66, 66, 66)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(77, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 433, Short.MAX_VALUE))
        );

        pack();
    }                       

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Branches().setVisible(true);
            }
        });
    }
                  
    private javax.swing.JLabel jLabel1;// This is where the variables are declared
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;                 
}
