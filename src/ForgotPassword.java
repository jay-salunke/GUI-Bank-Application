import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.SplittableRandom;

public class ForgotPassword extends JFrame {
    private JLabel EmailIDlabel;
    private JTextField EmailIDTextField;
    private JPanel panel;
    private JButton ResetPasswordButton;
    private JLabel fieldEmptyLabel;

    ForgotPassword() {
        setTitle("ForgotPassword");
        panel = new JPanel();
        panel.setBounds(30, 20, 260, 260);
        panel.setBackground(Color.white);
        EmailIDlabel = new JLabel("Email ID: ");
        EmailIDlabel.setBounds(60, 70, 80, 20);
        EmailIDTextField = new JTextField();
        EmailIDTextField.setBounds(60, 100, 200, 25);
        fieldEmptyLabel = new JLabel();
        fieldEmptyLabel.setBounds(60, 120, 150, 20);
        ResetPasswordButton = new JButton("ResetPassword");
        ResetPasswordButton.setBounds(60, 160, 200, 25);

        ResetPasswordButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String getEmail = EmailIDTextField.getText();
                if (getEmail.isEmpty()) {
                    fieldEmptyLabel.setForeground(Color.red);
                    fieldEmptyLabel.setText("Please fill the Email Field");
                } else {
                    SplittableRandom otp = new SplittableRandom();
                    int getOtp = Math.abs(otp.nextInt(10000, 99999));

                    Thread t1 = new Thread(new Runnable() {
                        @Override
                        public void run() {
                            Mail m1 = new Mail();
                            m1.sendEmail(getEmail, getOtp);
                        }
                    });
                    t1.start();
                    JOptionPane.showMessageDialog(null,"Check your Email for One time password");
                    setVisible(false);
                    new OtpForm(getEmail, getOtp);
                }
            }
        });
        add(ResetPasswordButton);
        add(EmailIDlabel);
        add(EmailIDTextField);
        add(fieldEmptyLabel);
        add(panel);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);
        setSize(330, 330);
        setLayout(null);
        setVisible(true);
    }
}
