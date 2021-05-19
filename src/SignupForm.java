
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

        //label 1
        label1 = new JLabel("NAME: ");
        label1.setBounds(40, 5, 50, 20);

        //TextField1
        TextField1 = new JTextField();
        TextField1.setBounds(40, 25, 200, 20);
        NameValidation = new JLabel();
        NameValidation.setBounds(255, 25, 160, 20);
        TextField1.addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e) {
                String NameField = TextField1.getText();
                NameFieldValidation(NameField);
                NameValidation.setForeground(Color.red);

                if (TextField1.getText().isEmpty()) {
                    NameValidation.setText("Name Field is Empty");

                } else {
                    if (TextField1.getText().matches("([A-z a-z]+)")) {
                        NameValidation.setText("");
                        Success = true;
                    } else {

                        if (!TextField1.getText().matches("([^0-9]*)")) {
                            NameValidation.setText("Numbers are not valid");
                            Success = false;
                        } else {
                            NameValidation.setText("");
                        }
                    }
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

                PhoneNomsg.setForeground(Color.red);
                if (TextField3.getText().matches("^[0-9]*$")) {
                    PhoneNomsg.setText("");
                    Success = true;
                    if (!(TextField3.getText().length() == 10)) {
                        PhoneNomsg.setText("Please Enter 10 digits only");
                        Success = false;

                    } else {
                        Success = true;
                        PhoneNomsg.setText("");
                    }


                } else {

                    PhoneNomsg.setText("Please enter digits only");
                    Success = false;

                }


                if (TextField3.getText().isEmpty()) {
                    PhoneNomsg.setText("Please Enter Phone Field");
                    Success = false;
                }

            }

        });

        PhoneNomsg = new JLabel();
        PhoneNomsg.setBounds(245, 110, 160, 20);

        //label4
        label4 = new JLabel("STATE: ");
        label4.setBounds(40, 130, 50, 20);

        //TextField4
        TextField4 = new JTextField();
        TextField4.setBounds(40, 150, 200, 20);


        //label 5
        label5 = new JLabel("CITY: ");
        label5.setBounds(40, 170, 50, 20);

        //TextField5
        TextField5 = new JTextField();
        TextField5.setBounds(40, 189, 200, 20);


        //label6
        label6 = new JLabel("PINCODE: ");
        label6.setBounds(40, 210, 80, 20);

        //TextField6
        TextField6 = new JTextField();
        TextField6.setBounds(40, 230, 200, 20);

        //label7
        label7 = new JLabel("EMAIL ID: ");
        label7.setBounds(40, 250, 80, 20);

        //TextField7
        TextField7 = new JTextField();
        TextField7.setBounds(40, 272, 200, 20);
        EmailIDLabel = new JLabel();
        EmailIDLabel.setBounds(249, 272, 160, 20);
        //Email Id Functionalities
        TextField7.addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e) {
                EmailIDLabel.setForeground(Color.red);
                if (TextField7.getText().isEmpty()) {
                    EmailIDLabel.setText("Email Id cannot be empty");
                    Success = false;
                } else {
                    EmailIDLabel.setText("");
                }


                if (!TextField7.getText().matches(RegexEmail)) {
                    Success = false;
                    EmailIDLabel.setText("Please Enter valid Email Id");
                } else {
                    Success = true;
                    EmailIDLabel.setText("");


                }
            }
        });

        //label8
        label8 = new JLabel("INITIAL AMOUNT:");
        label8.setBounds(40, 295, 100, 20);

        //TextField8
        TextField8 = new JTextField();
        TextField8.setBounds(40, 315, 200, 20);

        //label 9
        label9 = new JLabel("PASSWORD: ");
        label9.setBounds(40, 335, 80, 20);

        //TextField9
        TextField9 = new JTextField();
        TextField9.setBounds(40, 355, 200, 20);

        //label10
        label10 = new JLabel("CONFIRM PASSWORD: ");
        label10.setBounds(40, 376, 130, 20);

        //TextField10
        TextField10 = new JTextField();
        TextField10.setBounds(40, 395, 200, 20);
        PasswordConfirmationLabel = new JLabel();
        PasswordConfirmationLabel.setBounds(245, 395, 160, 20);
        TextField10.addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e) {
                PasswordConfirmationLabel.setForeground(Color.red);
                if (!TextField9.getText().equals(TextField10.getText())) {

                    PasswordConfirmationLabel.setText("Password does not match");
                    Success = false;
                } else {
                    PasswordConfirmationLabel.setText("Password matches");
                    Success = true;
                }

                if (TextField10.getText().isEmpty()) {

                    PasswordConfirmationLabel.setText("Please fill this field");
                    Success = false;

                }


            }
        });

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
                String pass = TextField9.getText();

                if (!Success) {
                    if ((name.isEmpty() && phone.isEmpty() && email.isEmpty() && pass.isEmpty())) {
                        JOptionPane.showMessageDialog(null, "Please Fill all the field");
                    }


                } else {

                    if (name.isEmpty() || phone.isEmpty() || email.isEmpty() || pass.isEmpty()) {
                        JOptionPane.showMessageDialog(null, "Field cannot be empty");
                    } else {
                        System.out.println(name);
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
        add(PhoneNomsg);
        add(label5);
        add(TextField5);
        add(label6);
        add(TextField6);
        add(label7);
        add(TextField7);
        add(EmailIDLabel);
        add(label8);
        add(TextField8);
        add(label9);
        add(TextField9);
        add(label10);
        add(TextField10);
        add(PasswordConfirmationLabel);
        add(SubmitButton);
        add(ResetButton);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setSize(400, 500);
        setLayout(null);
        setResizable(false);
        setLayout(null);
        setVisible(true);

    }


}
