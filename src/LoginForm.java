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
    private JLabel ForgotPasswordLink;
    private JLabel SignUpAccount;
    private String email="abc";
    private String pass="abc";

    private int count=0;


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
            } else {
                JOptionPane.showMessageDialog(null, "Email or Password is incorrect");
                LoginText1.setText(null);
                LoginText2.setText(null);
            }


        }
    }









    LoginForm(){

        LoginFrame=new JFrame("LOGIN FORM");

        //label 1
        LoginLabel1=new JLabel("Email Id: ");
        LoginLabel1.setBounds(85,70,100,20);
         //TextBox1 (Email ID)
        LoginText1=new JTextField();
        LoginText1.setBounds(140,70,220,25);
        //label 2
        LoginLabel2=new JLabel("Password: ");
        LoginLabel2.setBounds(75,110,100,20);
         //TextBox2 (Password)
        LoginText2=new JTextField();
        LoginText2.setBounds(140,110,220,25);

         //Login Button
          LoginButton=new JButton("Login");
          LoginButton.setBounds(140,150,220,30);

          //SignUp Account
         SignUpAccount=new JLabel("OR Create Account");
         SignUpAccount.setBounds(200,190,110,50);
         SignUpAccount.setForeground(Color.orange);
          // Forgot Password Link
        ForgotPasswordLink=new JLabel("Forget Password");
        ForgotPasswordLink.setBounds(200,220,100,20);
        ForgotPasswordLink.setForeground(Color.BLUE);

          SignUpAccount.addMouseListener(new MouseAdapter() {
              @Override
              public void mouseClicked(MouseEvent e) {
                    new SignupForm();
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
        LoginFrame.add(ForgotPasswordLink);
        LoginFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        LoginFrame.setResizable(false);
        LoginFrame.setSize(500,400);
        LoginFrame.setLayout(null);
        LoginFrame.setVisible(true);

    }



}
