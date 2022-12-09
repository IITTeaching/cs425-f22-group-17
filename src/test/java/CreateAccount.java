package test.java;

import java.awt.event.ActionEvent;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.AbstractButton;

public class CreateAccount extends javax.swing.JFrame {

    
    public CreateAccount() {
        initComponents();
    }

    
    @SuppressWarnings("unchecked")
                             
    private void initComponents() {

        ChooseAccountTypeText = new javax.swing.JLabel();//Creates all the variables in the GUI
        SavingsToggleButton = new javax.swing.JToggleButton();
        CheckingToggleButton = new javax.swing.JToggleButton();
        ChooseAccountNameText = new javax.swing.JLabel();
        EnterAccountNameTextField = new javax.swing.JTextField();
        EnterButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        ChooseAccountTypeText.setFont(new java.awt.Font("Helvetica Neue", 1, 24)); //sets the font, style, and size of the text
        ChooseAccountTypeText.setText("Choose Account Type");//sets text

        SavingsToggleButton.setText("Savings");//sets text of button
        SavingsToggleButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SavingsToggleButtonActionPerformed(evt);
            }
        });

        CheckingToggleButton.setText("Checking");//sets text of button
        CheckingToggleButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CheckingToggleButtonActionPerformed(evt);
            }
        });

        ChooseAccountNameText.setFont(new java.awt.Font("Helvetica Neue", 1, 24));//sets the font, style, and size of the text
        ChooseAccountNameText.setText("Choose Account Name");//sets text

        EnterAccountNameTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EnterAccountNameTextFieldActionPerformed(evt);
            }
        });

        EnterButton.setText("Enter");//sets text of button
        EnterButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EnterButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());//all this sets the layout of the alignment of GUI elements
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(174, 174, 174)
                        .addComponent(ChooseAccountTypeText))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(152, 152, 152)
                        .addComponent(SavingsToggleButton, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(73, 73, 73)
                        .addComponent(CheckingToggleButton, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(164, 164, 164)
                        .addComponent(ChooseAccountNameText))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(215, 215, 215)
                        .addComponent(EnterAccountNameTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(251, 251, 251)
                        .addComponent(EnterButton)))
                .addContainerGap(159, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addComponent(ChooseAccountTypeText)
                .addGap(52, 52, 52)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(CheckingToggleButton, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(SavingsToggleButton, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(67, 67, 67)
                .addComponent(ChooseAccountNameText)
                .addGap(26, 26, 26)
                .addComponent(EnterAccountNameTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(41, 41, 41)
                .addComponent(EnterButton)
                .addContainerGap(57, Short.MAX_VALUE))
        );

        pack();
    }                      

    
    private void SavingsToggleButtonActionPerformed(java.awt.event.ActionEvent evt) {  //sets action that occurs when button is pressed     
 
    }
                                             
    private void CheckingToggleButtonActionPerformed(java.awt.event.ActionEvent evt) {  //sets action that occurs when button is pressed                                                    

    }                                                    

    private void EnterAccountNameTextFieldActionPerformed(java.awt.event.ActionEvent evt) {                                                          
    	
    }                                                         

    private void EnterButtonActionPerformed(java.awt.event.ActionEvent evt) { //sets action that occurs when button is pressed
    	DBConnect database = new DBConnect(Login.username, Login.password);
    	
    	if(CheckingToggleButton.isSelected() == true && SavingsToggleButton.isSelected() == false) {
	        try
	        {
	            Statement stmt = database.connect().createStatement();
	            String sql1 = String.format("INSERT INTO Account(type) VALUES ('checking')", EnterButton.getText());
	            stmt.executeQuery(sql1);
	            database.connect().close();
	        }
	        catch(SQLException e)
	        {
	            System.out.println(e.getMessage());
	        }
	        finally
	        {
	            new AccountManagement().setVisible(true);
	            dispose();
	        }
	    } else if(CheckingToggleButton.isSelected() == false && SavingsToggleButton.isSelected() == true){
	    	 try
		        {
		            Statement stmt = database.connect().createStatement();
		            String sql1 = String.format("INSERT INTO Account(type) VALUES ('savings')", EnterButton.getText());
		            stmt.executeQuery(sql1);
		            database.connect().close();
		        }
		        catch(SQLException e)
		        {
		            System.out.println(e.getMessage());
		        }
		        finally
		        {
		            new AccountManagement().setVisible(true);
		            dispose();
		        }
	    }
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CreateAccount().setVisible(true);
            }
        });
    }
                   
    private javax.swing.JToggleButton CheckingToggleButton;// This is where the variables are declared
    private javax.swing.JLabel ChooseAccountNameText;
    private javax.swing.JLabel ChooseAccountTypeText;
    private javax.swing.JTextField EnterAccountNameTextField;
    private javax.swing.JButton EnterButton;
    private javax.swing.JToggleButton SavingsToggleButton;                 
}
