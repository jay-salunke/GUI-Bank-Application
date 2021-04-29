import javax.swing.*;
import javax.swing.Timer;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;

public class LoginForm{
    private JFrame LoginFrame;
    private JButton LoginButton;
    private JLabel LoginLabel1;
    private JLabel LoginLabel2;
    private JTextField LoginText1;
    private JTextField LoginText2;
    private JCheckBox  LoginRemCheck;
    private String email="abc";
    private String pass="abc";
    private JLabel seconds;
    private int count=0;
    private int SecondsPassed=60;

    public void LoginCheck(String email,String pass){
      boolean giveAccess=false;
      if(email.isEmpty() || pass.isEmpty()){
          JOptionPane.showMessageDialog(null,"Please fill the fields");
      }

          if(this.email.equals(email) && this.pass.equals(pass)){
               JOptionPane.showMessageDialog(null,"Login Successfully done");
               giveAccess=true;
          }
          else
          {

              if(count==3){

                  JOptionPane.showMessageDialog(null,"Too Many Failed Attempts Please try again after 60 seconds");
                  LoginButton.setEnabled(false);
                  Timer t=new Timer(1000, new ActionListener() {
                      @Override
                      public void actionPerformed(ActionEvent e) {
                          --SecondsPassed;
                          seconds.setVisible(true);
                          seconds.setBounds(190,190,100,100);
                          seconds.setText("00:"+String.valueOf(SecondsPassed));
                          System.out.println("00:"+String.valueOf(SecondsPassed));


                      }
                  });

                  t.start();



              }
              else
              {
                  ++count;
                  JOptionPane.showMessageDialog(null,"Password or Email Id is incorrect");
              }
          }


      if(giveAccess){
          LoginFrame.setVisible(false);
          new UserForm();
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
          LoginButton.setBounds(190,150,100,30);

        //Seconds label
          seconds=new JLabel();

          LoginButton.addActionListener(new ActionListener() {

              public void actionPerformed(ActionEvent e) {
                   String email=LoginText1.getText();
                   String pass=LoginText2.getText();

                   LoginCheck(email,pass);
              }
          });

          //Timer Label


        //Adding all components in frame
        LoginFrame.add(LoginLabel1);
        LoginFrame.add(LoginLabel2);
        LoginFrame.add(LoginText1);
        LoginFrame.add(LoginText2);
        LoginFrame.add(LoginButton);
        LoginFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        LoginFrame.setResizable(false);
        LoginFrame.setSize(500,400);
        LoginFrame.setLayout(null);
        LoginFrame.setVisible(true);

    }



}
