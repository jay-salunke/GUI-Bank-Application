
import com.toedter.calendar.JDateChooser;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.Arrays;

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
    private JPasswordField PasswordField1;
    private JPasswordField PasswordField2;
    private JButton SubmitButton;
    private JButton ResetButton;
    private JLabel NameValidation;
    private JLabel PhoneValidation;
    private JLabel PincodeValidation;
    private JLabel EmailIDValidation;
    private JLabel InitialAmountValidation;
    private JLabel PasswordValidation;
    private JLabel ConfirmPassValidation;
    private JDateChooser Date;

    private String RegexEmail = "([a-z\\d\\.-]+)@([a-z\\d-]+)\\.([a-z]{2,3})(\\.[a-z]{2,3})?";


    private boolean Success = false;

    public void ResetAll() {
        TextField1.setText(null);
        TextField2.setText(null);
        TextField3.setText(null);
        TextField4.setText(null);
        Date.setDate(null);
        TextField6.setText(null);
        TextField7.setText(null);
        TextField8.setText(null);
        PasswordField1.setText(null);
        PasswordField2.setText(null);
        NameValidation.setText(null);
        PhoneValidation.setText(null);
        PincodeValidation.setText(null);
        EmailIDValidation.setText(null);
        PasswordValidation.setText(null);
        ConfirmPassValidation.setText(null);
        InitialAmountValidation.setText(null);
    }


    SignupForm() {
        setTitle("Signup Page");

        //label 1
        label1 = new JLabel("NAME: ");
        label1.setBounds(40, 5, 50, 20);

        //TextField1
        TextField1 = new JTextField();
        TextField1.setBounds(40, 25, 200, 20);
        NameValidation = new JLabel();
        NameValidation.setBounds(255, 25, 200, 20);
        TextField1.addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e) {
                NameValidation.setForeground(Color.red);

                if (TextField1.getText().isEmpty()) {
                    NameValidation.setText("Name Field is Empty");

                } else if (!TextField1.getText().matches("([^0-9]*)")) {
                    NameValidation.setText("Numbers are not valid");
                    Success = false;
                } else if (!TextField1.getText().matches("([A-z a-z]+)")) {
                    NameValidation.setText("Please Enter Name Correctly");
                    Success = false;
                } else {
                    NameValidation.setText("");
                    Success = true;
                }

            }
        });
        //label2
        label2 = new JLabel("ADDRESS: ");
        label2.setBounds(40, 50, 150, 20);

        //TextField2
        TextField2 = new JTextField();
        TextField2.setBounds(40, 70, 200, 20);

        //label3
        label3 = new JLabel("PHONE NO: ", 10);
        label3.setBounds(40, 90, 80, 20);

        //TextField3
        TextField3 = new JTextField();
        TextField3.setBounds(40, 110, 200, 20);


        //Phone Functionalities

        TextField3.addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e) {

                PhoneValidation.setForeground(Color.red);
                if (TextField3.getText().isEmpty()) {
                    PhoneValidation.setText("Phone Field Cannot be Empty");
                } else if (!TextField3.getText().matches("^[0-9]*$")) {
                    PhoneValidation.setText("Please Enter Digits only");
                    Success = false;
                } else if (!(TextField3.getText().length() == 10)) {
                    PhoneValidation.setText("Please Enter 10 digits number only");
                    Success = false;
                } else {
                    PhoneValidation.setText("");
                    Success = true;
                }
            }
        });

        PhoneValidation = new JLabel();
        PhoneValidation.setBounds(245, 110, 160, 20);

        //label4
        label4 = new JLabel("OCCUPATION: ");
        label4.setBounds(40, 130, 160, 20);

        //TextField4
        TextField4 = new JTextField();
        TextField4.setBounds(40, 150, 200, 20);


        //label 5
        label5 = new JLabel("DOB: ");
        label5.setBounds(40, 170, 50, 20);

        //TextField5
        Date = new JDateChooser();
        Date.setBounds(40, 189, 200, 20);


        //label6
        label6 = new JLabel("PINCODE: ");
        label6.setBounds(40, 210, 80, 20);

        //TextField6
        TextField6 = new JTextField();
        TextField6.setBounds(40, 230, 200, 20);

        TextField6.addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e) {
                PincodeValidation.setForeground(Color.red);
                if (TextField6.getText().isEmpty()) {
                    PincodeValidation.setText("Please Fill the Pincode");
                    Success = false;
                } else if (!TextField6.getText().matches("^[0-9]*$")) {
                    PincodeValidation.setText("Please Enter Digits only");
                    Success = false;
                } else if (!(TextField6.getText().length() == 6)) {
                    PincodeValidation.setText("Pincode should be 6 digit number only");
                    Success = false;
                } else {
                    PincodeValidation.setText("");
                    Success = true;
                }

            }
        });

        //Pincode Validation Label
        PincodeValidation = new JLabel();
        PincodeValidation.setBounds(245, 230, 160, 20);


        //label7
        label7 = new JLabel("EMAIL ID: ");
        label7.setBounds(40, 250, 80, 20);

        //TextField7
        TextField7 = new JTextField();
        TextField7.setBounds(40, 272, 200, 20);
        EmailIDValidation = new JLabel();
        EmailIDValidation.setBounds(249, 272, 160, 20);
        //Email Id Functionalities
        TextField7.addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e) {
                EmailIDValidation.setForeground(Color.red);
                if (TextField7.getText().isEmpty()) {
                    EmailIDValidation.setText("Email Id cannot be empty");
                    Success = false;
                } else if (!TextField7.getText().matches(RegexEmail)) {
                    Success = false;
                    EmailIDValidation.setText("Enter valid Email Id");
                } else {
                    Success = true;
                    EmailIDValidation.setText("");

                }
            }
        });

        //label8
        label8 = new JLabel("INITIAL AMOUNT:");
        label8.setBounds(40, 295, 100, 20);

        //TextField8
        TextField8 = new JTextField();
        TextField8.setBounds(40, 315, 200, 20);

        //InitialAmountValidation label
        InitialAmountValidation = new JLabel();
        InitialAmountValidation.setBounds(245, 315, 200, 20);

        TextField8.addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e) {
                if (TextField8.getText().isEmpty()) {
                    InitialAmountValidation.setText("Please Enter the Amount");
                } else if (!(TextField8.getText().matches("^[0-9]*$"))) {
                    InitialAmountValidation.setText("Please fill Digits only");
                } else if (Integer.parseInt(TextField8.getText()) < 5000) {
                    InitialAmountValidation.setText("Enter the Amount greater than 5000");

                } else {
                    InitialAmountValidation.setText("");
                    Success = true;
                }

            }
        });
        //label 9
        label9 = new JLabel("PASSWORD: ");
        label9.setBounds(40, 335, 80, 20);

        //PasswordField1
        PasswordField1 = new JPasswordField();
        PasswordField1.setBounds(40, 355, 200, 20);


        //PasswordValidation Label
        PasswordValidation = new JLabel();
        PasswordValidation.setBounds(245, 355, 200, 20);

        PasswordField1.addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e) {
                PasswordValidation.setForeground(Color.red);
                if (PasswordField1.getPassword().length == 0) {
                    PasswordValidation.setText("Please fill the password field");
                } else if (PasswordField1.getPassword().length < 8) {
                    PasswordValidation.setText("Please Enter Strong password");
                } else {
                    PasswordValidation.setText("");
                    Success = true;
                }

            }
        });


        //label10
        label10 = new JLabel("CONFIRM PASSWORD: ");
        label10.setBounds(40, 376, 130, 20);

        //PasswordField2
        PasswordField2 = new JPasswordField();
        PasswordField2.setBounds(40, 395, 200, 20);

        PasswordField2.addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e) {
                ConfirmPassValidation.setForeground(Color.red);
                if (PasswordField2.getPassword().length == 0) {
                    ConfirmPassValidation.setText("Please Confirm password ");
                } else {
                    ConfirmPassValidation.setText("");
                    Success = true;
                }
                for (int i = 0; i < PasswordField2.getPassword().length; i++) {
                    if ((Arrays.equals(PasswordField2.getPassword(), PasswordField1.getPassword()))) {
                        ConfirmPassValidation.setText("");
                        Success = true;

                    } else ConfirmPassValidation.setText("Password Doesnt Match");

                }

            }
        });

        //ConfirmPassValidation label
        ConfirmPassValidation = new JLabel();
        ConfirmPassValidation.setBounds(245, 395, 160, 20);

        //SubmitButton
        SubmitButton = new JButton("SUBMIT");
        SubmitButton.setBounds(40, 430, 100, 20);
        SubmitButton.setBackground(Color.green);
        SubmitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String name = TextField1.getText();
                String phone = TextField3.getText();
                String email = TextField7.getText();
                String pass = PasswordField1.getPassword().toString();

                if (!Success) {
                    if ((name.isEmpty() && phone.isEmpty() && email.isEmpty() && pass.isEmpty())) {
                        JOptionPane.showMessageDialog(null, "Please Fill all the field");
                    }


                } else {

                    if (name.isEmpty() || phone.isEmpty() || email.isEmpty() || pass.isEmpty()) {
                        JOptionPane.showMessageDialog(null, "Field cannot be empty");
                    } else {
//                        System.out.println(name);
                        System.out.println(phone);
                        System.out.println(email);
                        System.out.println(pass);

                        new UserForm();
                        setVisible(false);


                    }
                }

            }
        });

        //ResetButton
        ResetButton = new JButton("RESET");
        ResetButton.setBounds(150, 430, 100, 20);
        ResetButton.setBackground(Color.ORANGE);
        ResetButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ResetAll();
            }
        });
        add(label1);
        add(TextField1);
        add(NameValidation);
        add(label2);
        add(TextField2);
        add(label3);
        add(TextField3);
        add(label4);
        add(TextField4);
        add(PhoneValidation);
        add(label5);
        add(Date);
        add(label6);
        add(TextField6);
        add(PincodeValidation);
        add(label7);
        add(TextField7);
        add(EmailIDValidation);
        add(label8);
        add(TextField8);
        add(label9);
        add(PasswordField1);
        add(PasswordValidation);
        add(label10);
        add(PasswordField2);
        add(ConfirmPassValidation);
        add(SubmitButton);
        add(ResetButton);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setSize(433, 500);
        setLayout(null);
        setResizable(false);
        setLayout(null);
        setVisible(true);

    }


}
