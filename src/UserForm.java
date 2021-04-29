import javax.swing.*;
public class UserForm {

    private JFrame UserFrame;

     UserForm(){
         UserFrame=new JFrame("Welcome User");
         UserFrame.setSize(500,400);
         UserFrame.setLayout(null);
         UserFrame.setVisible(true);
         UserFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
     }
}
