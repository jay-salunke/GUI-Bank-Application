
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class SignupForm extends JFrame {
    private JLabel label1;
    private JLabel label2;
    private JLabel label3;
    private JLabel label4;
    private JLabel label5;
    private JLabel label6;
    private JLabel label7;
    private JLabel label8;
    private JLabel label9;
    private JLabel label10;
    private JTextField TextField1;
    private JTextField TextField2;
    private JTextField TextField3;
    private JTextField TextField4;
    private JTextField TextField5;
    private JTextField TextField6;
    private JTextField TextField7;
    private JTextField TextField8;
    private JTextField TextField9;
    private JTextField TextField10;
    private JButton SubmitButton;
    private JButton ResetButton;
    private JLabel PhoneNomsg;
    private JLabel PasswordConfirmationLabel;
    private JLabel EmailIDLabel;
    private String RegexEmail = "([a-z\\d\\.-]+)@([a-z\\d-]+)\\.([a-z]{2,3})(\\.[a-z]{2,3})?";

    private JLabel NameValidation;

    private void NameFieldValidation(String getName) {
        System.out.print(getName);
    }

    private boolean Success = false;

    public void ResetAll() {
        TextField1.setText(null);
        TextField2.setText(null);
        TextField3.setText(null);
        TextField4.setText(null);
        TextField5.setText(null);
        TextField6.setText(null);
        TextField7.setText(null);
        TextField8.setText(null);
        TextField9.setText(null);
        TextField10.setText(null);

    }


    SignupForm() {
        setTitle("Signup Page");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setSize(400, 500);
        setLayout(null);
        setResizable(false);
        setLayout(null);
        setVisible(true);

    }


}
