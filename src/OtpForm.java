import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.KeySpec;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.SplittableRandom;
import java.util.Timer;
import java.util.TimerTask;

public class OtpForm extends JFrame {
    private JTextField otptextfield;
    private JPasswordField passwordField;
    private JPasswordField confirmpasswordfield;
    private JLabel otplabel;
    private JLabel passlabel;
    private JLabel confirmpasslabel;
    private JLabel otperrorlabel;
    private JLabel passerrorlabel;
    private JLabel confirmpasserrorlabel;
    private JButton Button;
    private boolean otpexpiry = false;
    private boolean validation = true;
    private int Otp;
    private String Email;
    private JLabel ResendOtp;


    private void setTimer() {
        Timer timer = new Timer();
        TimerTask task = new TimerTask() {
            @Override
            public void run() {
                otpexpiry = true;
                otptextfield.setEditable(false);
                passwordField.setEditable(false);
                confirmpasswordfield.setEditable(false);
                otperrorlabel.setVisible(true);
                otperrorlabel.setText("Otp is Expired");
                ResendOtp.setVisible(true);
                timer.cancel();
            }
        };
        timer.scheduleAtFixedRate(task, 60000, 1);
    }


    private void OtpValidation() {
        otperrorlabel.setVisible(true);
        if (otptextfield.getText().isBlank()) {
            otperrorlabel.setText("Enter the otp");
        } else if (otptextfield.getText().matches("^[0-9]*$")) {
            otperrorlabel.setText("");
        } else if (otptextfield.getText().length() < 5) {
            otperrorlabel.setText("Enter 5 digits otp only!...");
        } else {
            otperrorlabel.setText("Please enter only digits");
            validation = false;
        }
    }

    private void PasswordValidation() {
        passerrorlabel.setVisible(true);
        if (String.valueOf(passwordField.getPassword()).isBlank()) {
            passerrorlabel.setText("Enter the password");
        } else if (passwordField.getPassword().length < 8) {
            passerrorlabel.setText("Password must be greater than 10 characters");
            validation = false;
        } else passerrorlabel.setText("");
    }


    private void ConfirmPassValidation() {
        confirmpasserrorlabel.setVisible(true);
        if (String.valueOf(confirmpasswordfield.getPassword()).isBlank()) {
            confirmpasserrorlabel.setText("Confirm Password is Empty");
        } else if (String.valueOf(passwordField.getPassword()).equals(String.valueOf(confirmpasswordfield.getPassword()))) {
            confirmpasserrorlabel.setText("");
            validation = true;
        } else {
            confirmpasserrorlabel.setText("Password is not matching");
            validation = false;
        }
    }

    private void CheckValidation() {
        OtpValidation();
        PasswordValidation();
        ConfirmPassValidation();
    }

    private void ChangePassword() {
        CheckValidation();
        try {
            if (Integer.parseInt(otptextfield.getText()) == Otp && (!otpexpiry) && validation) {
                JOptionPane.showMessageDialog(null, "Password Changes Successfully");
                try {

                } catch (Exception ex) {
                    ex.printStackTrace();
                }
                try {
                    byte[] salt = new byte[20];
                    SecureRandom random = new SecureRandom();
                    random.nextBytes(salt);
                    KeySpec spec = new PBEKeySpec(passwordField.getPassword(), salt, 65536, 128);
                    SecretKeyFactory f = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA1");
                    byte[] hash = f.generateSecret(spec).getEncoded();
                    StringBuilder sb = new StringBuilder();
                    for (byte b : hash) {
                        sb.append(String.format("%02x", b));
                    }
                    String hashpassword = sb.toString();
                    JDBCConnection con = new JDBCConnection();
                    Class.forName(con.Driver);
                    Connection connection = DriverManager.getConnection(con.DB_URL, con.DB_Username, con.DB_pass);
                    String query = "update usersinfo set Password='" + hashpassword + "' where EmailID ='" + Email + "'";
                    Statement stmt = connection.createStatement();
                    stmt.execute(query);
                    connection.close();
                    setVisible(false);
                    new LoginForm();
                } catch (SQLException | ClassNotFoundException ex) {
                    ex.printStackTrace();
                } catch (NoSuchAlgorithmException e) {
                    e.printStackTrace();
                } catch (InvalidKeySpecException e) {
                    e.printStackTrace();
                }
            } else otperrorlabel.setText("Otp is not matching");
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(null, "Fields cannot be Empty");
        }
    }


    OtpForm(String getEmail, int Getotp) {
        Email = getEmail;
        Otp = Getotp;
        otplabel = new JLabel("Enter Otp: ");
        otplabel.setBounds(60, 50, 70, 20);
        otptextfield = new JTextField();
        otptextfield.setBounds(60, 70, 200, 20);

        otperrorlabel = new JLabel();
        otperrorlabel.setForeground(Color.RED);
        otperrorlabel.setVisible(false);
        otperrorlabel.setBounds(60, 90, 200, 20);

        otptextfield.addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e) {
                OtpValidation();
            }
        });
        passwordField = new JPasswordField();
        passlabel = new JLabel("Set New Password: ");
        passlabel.setBounds(60, 120, 150, 20);
        passwordField.setBounds(60, 140, 200, 20);
        passerrorlabel = new JLabel();
        passerrorlabel.setForeground(Color.red);
        passerrorlabel.setBounds(60, 160, 250, 20);

        passwordField.addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e) {
                PasswordValidation();
            }
        });

        confirmpasslabel = new JLabel("Confirm Password: ");
        confirmpasslabel.setBounds(60, 190, 200, 20);
        confirmpasswordfield = new JPasswordField();
        confirmpasswordfield.setBounds(60, 210, 200, 20);
        confirmpasserrorlabel = new JLabel();
        confirmpasserrorlabel.setForeground(Color.red);
        confirmpasserrorlabel.setBounds(60, 230, 250, 20);

        confirmpasswordfield.addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e) {
                ConfirmPassValidation();
            }
        });
        setTimer();
        Button = new JButton("Change Password");
        Button.setBounds(60, 260, 200, 25);

        ResendOtp = new JLabel("Resend Otp");
        ResendOtp.setBounds(240, 290, 150, 20);
        ResendOtp.setVisible(false);
        ResendOtp.setForeground(Color.blue);

        ResendOtp.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                otptextfield.setEditable(true);
                passwordField.setEditable(true);
                confirmpasswordfield.setEditable(true);
                otptextfield.setText("");
                passwordField.setText("");
                confirmpasswordfield.setText("");
                Mail m1 = new Mail();
                SplittableRandom resetotp = new SplittableRandom();
                Otp = Math.abs(resetotp.nextInt(10000, 99999));
                otpexpiry = false;
                Thread t1 = new Thread(new Runnable() {
                    @Override
                    public void run() {
                        m1.sendEmail(Email, Otp);
                    }
                });
                t1.start();
                setTimer();

            }
        });

        Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ChangePassword();
            }
        });
        add(otplabel);
        add(otptextfield);
        add(otperrorlabel);
        add(passlabel);
        add(passerrorlabel);
        add(passwordField);
        add(confirmpasslabel);
        add(confirmpasswordfield);
        add(confirmpasserrorlabel);
        add(Button);
        add(ResendOtp);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);
        setSize(330, 350);
        setLayout(null);
        setVisible(true);
    }


}

