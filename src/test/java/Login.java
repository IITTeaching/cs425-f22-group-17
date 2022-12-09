package test.java;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.*;

public class Login {

        public static String username; //store login username
        public static String password; //store login password
        public static String role; //store login role
    public static void main(String[]args){

        JPanel panel = new JPanel();//Creates new JPanel
        JFrame frame = new JFrame();//Creates new JFrame
        frame.setSize(350,200);//sets size 
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(panel);

        panel.setLayout(null);

        JLabel userLabel = new JLabel("User");//sets text of label
        userLabel.setBounds(10, 20, 80, 25);//sets bounds
        panel.add(userLabel);

        JTextField userText = new JTextField(20);//creates text field
        userText.setBounds(100, 20, 165, 25);//sets bounds
        panel.add(userText);

        JLabel passwordLabel = new JLabel("Password");//sets text of label
        passwordLabel.setBounds(10, 50, 80, 25);//sets bounds
        panel.add(passwordLabel);

        JPasswordField passwordText = new JPasswordField();
        passwordText.setBounds(100, 50, 165, 25);//sets bounds
        panel.add(passwordText);

        JLabel success = new JLabel("");
        success.setBounds(10, 110, 300, 25);//sets bounds
        panel.add(success);

        JButton button = new JButton("Login");//sets text of button
        button.setBounds(10, 80, 80 ,25);//sets bounds
        button.addActionListener(new ActionListener(){//action when button is pressed

            @Override
            public void actionPerformed(ActionEvent e) {
                
                String user = userText.getText();
                String password = passwordText.getText();//this is deprecated but still works
                System.out.println(user + "," + password);

                DBConnect database = new DBConnect(user, password); //database connection creations
                try
                {
                    Login.username = user;
                    Login.password = password;
                    Statement stmt = database.connect().createStatement();
                    String sql = "select * from Customer where username = CURRENT_USER"; //check if login user is customer
                    ResultSet rs = stmt.executeQuery(sql);
                    if(rs.next())
                    {
                        Login.role = "customer";
                        new AccountManagement().setVisible(true); //opens account management window if customer
                        frame.setVisible(false); //hides login window
                    }
                    else
                    {
                        Statement stmt2 = database.connect().createStatement();
                        ResultSet rs2 = stmt2.executeQuery("select occupation from Employee where username = CURRENT_USER"); //check if login user is manager
                        if(rs2.next())
                        {
                            System.out.println(rs2.getString("occupation"));
                            if(rs2.getString("occupation").equals("teller"))
                            {
                                Login.role = "teller";
                                new AccountManagement().setVisible(true);
                                frame.setVisible(false);
                            }
                            else
                            {
                                Login.role = "manager";
                                new ManagerAccountManagement().setVisible(true);
                                frame.setVisible(false);
                            }
                        }
                    }
                    database.connect().close(); //close connection
                }
                catch(SQLException h)
                {
                    System.out.println(h.getMessage());
                    success.setText("Login failed!"); //output if user cannot login
                }
            }

        });
        panel.add(button);
        
        frame.setVisible(true);
    }
}
