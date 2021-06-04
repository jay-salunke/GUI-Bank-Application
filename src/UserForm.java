import javax.swing.*;
public class UserForm {

    private JFrame UserFrame;
    private JTabbedPane tp;
    private JPanel p1;
    private JPanel p2;
    private JPanel p3;
    private JPanel p4;
    private JPanel p5;
     UserForm(){
         UserFrame=new JFrame("Welcome User");
         UserFrame.setSize(500,400);
         tp = new JTabbedPane();
         p1 = new JPanel();
         p2 = new JPanel();
         p3 = new JPanel();
         p4 = new JPanel();
         p5= new JPanel();
         tp.add("Profile",p1);
         tp.add("Transactions",p2);
         tp.add("Withdraw",p3);
         tp.add("Change Password",p4);
         tp.add("History",p5);
         tp.setBounds(0,0,500,500);
         UserFrame.add(tp);
         UserFrame.setLayout(null);
         UserFrame.setVisible(true);
         UserFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
     }
}
