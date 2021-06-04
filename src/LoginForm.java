import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
public class LoginForm extends JDBCConnection{
    private JFrame LoginFrame;
    private JButton LoginButton;
    private JLabel LoginLabel1;
    private JLabel LoginLabel2;
    private JTextField LoginText1;
    private JTextField LoginText2;
    private JCheckBox  LoginRemCheck;
    private JButton ForgotPassword;
    private JButton SignUpAccount;
    private JPanel panel;

    public void LoginCheck(String email,String pass) {
        boolean giveAccess = false;
        if (email.isEmpty() || pass.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Field cannot be empty....");
        } else {

            try {
                String DB_EmailID = null;
                String DB_Password = null;
                String DB_Name = null;
                Class.forName(Driver);
                Connection con = DriverManager.getConnection(DB_URL, DB_Username, DB_pass);
                Statement stmt = con.createStatement();
                String query = "SELECT Name,EmailID,Password FROM `usersinfo` WHERE `EmailID` ='" + email + "' AND `Password` ='" + pass + "'";
                ResultSet rs = stmt.executeQuery(query);
                while (rs.next()) {
                    DB_Name = rs.getString("Name");
                    DB_EmailID = rs.getString("EmailID");
                    DB_Password = rs.getString("Password");
                }
                if (DB_EmailID.equals(email) && DB_Password.equals(pass)) {
                    JOptionPane.showMessageDialog(null, "Dear" + DB_Name + " you have login successfully in your account");
                    giveAccess = true;

                }

            } catch (Exception ex) {
                System.out.println(ex);

            }
            if (giveAccess) {

                new UserForm();
                LoginFrame.setVisible(false);
            } else {
                JOptionPane.showMessageDialog(null, "Email or Password is incorrect");
                LoginText1.setText(null);
                LoginText2.setText(null);
            }


        }
    }









    LoginForm(){


        LoginFrame=new JFrame("LOGIN FORM");
        panel = new JPanel();
        panel.setBounds(15,15,340,300);
        panel.setBackground(Color.white);
        //label 1
        LoginLabel1=new JLabel("Email Id: ");
        LoginLabel1.setBounds(70,45,100,20);
         //TextBox1 (Email ID)
        LoginText1=new JTextField();
        LoginText1.setBounds(70,65,220,25);
        //label 2
        LoginLabel2=new JLabel("Password: ");
        LoginLabel2.setBounds(70,100,100,20);
         //TextBox2 (Password)
        LoginText2=new JTextField();
        LoginText2.setBounds(70,120,220,25);

         //Login Button
          LoginButton=new JButton("Login");
          LoginButton.setBounds(70,160,220,25);

          //SignUp Account
         SignUpAccount=new JButton("Create Account");
         SignUpAccount.setBounds(70,200,220,25);
         SignUpAccount.setForeground(Color.orange);
          // Forgot Password Link
        ForgotPassword=new JButton("Forget Password");
        ForgotPassword.setBounds(70,240,220,25);
        ForgotPassword.setForeground(Color.BLUE);

        SignUpAccount.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new SignupForm();
                LoginFrame.setVisible(false);
            }
        });

        ForgotPassword.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new ForgotPassword();
                LoginFrame.setVisible(false);
            }
        });



          LoginButton.addActionListener(new ActionListener() {

              public void actionPerformed(ActionEvent e) {
                   String email=LoginText1.getText();
                   String pass=LoginText2.getText();

                   LoginCheck(email,pass);
              }
          });

        //Adding all components in frame
        LoginFrame.add(LoginLabel1);
        LoginFrame.add(LoginLabel2);
        LoginFrame.add(LoginText1);
        LoginFrame.add(LoginText2);
        LoginFrame.add(LoginButton);
        LoginFrame.add(SignUpAccount);
        LoginFrame.add(ForgotPassword);
        LoginFrame.add(panel);
        LoginFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        LoginFrame.setResizable(false);
        LoginFrame.setSize(375,370);
        LoginFrame.setLayout(null);
        LoginFrame.setVisible(true);

    }



}
