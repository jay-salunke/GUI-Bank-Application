import javax.swing.*;
import java.awt.*;

public class ForgotPassword extends JFrame {
    private JLabel EmailIDlabel;
    private JTextField EmailIDTextField;
    private JPanel panel;
    private JButton ResetPasswordButton;

    ForgotPassword() {
        setTitle("ForgotPassword");
        panel = new JPanel();
        panel.setBounds(30, 20, 260, 260);
        panel.setBackground(Color.white);
        EmailIDlabel = new JLabel("Email ID: ");
        EmailIDlabel.setBounds(60, 70, 80, 20);
        EmailIDTextField = new JTextField();
        EmailIDTextField.setBounds(60,100,200,25);
        ResetPasswordButton = new JButton("ResetPassword");
        ResetPasswordButton.setBounds(60,140,200,25);
        add(ResetPasswordButton);
        add(EmailIDlabel);
        add(EmailIDTextField);
        add(panel);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);
        setSize(330, 330);
        setLayout(null);
        setVisible(true);
    }
}
