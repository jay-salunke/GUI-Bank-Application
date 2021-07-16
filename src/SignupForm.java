
import com.toedter.calendar.JDateChooser;

import javax.swing.*;
import java.awt.*;
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

    //TextField4
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
    private JLabel AddressValidation;
    private JLabel PhoneValidation;
    private JLabel OccupationValidation;
    private JLabel DateValidation;
    private JLabel PincodeValidation;
    private JLabel EmailIDValidation;
    private JLabel InitialAmountValidation;
    private JLabel PasswordValidation;
    private JLabel ConfirmPassValidation;
    private JDateChooser Date;
    private boolean Success = true;
    private String RegexEmail = "([a-z\\d\\.-]+)@([a-z\\d-]+)\\.([a-z]{2,3})(\\.[a-z]{2,3})?";

    public void CheckTextBoxEmpty() {
        if (TextField1.getText().isEmpty()) Success = false;
        if (TextField2.getText().isEmpty()) Success = false;
        if (TextField3.getText().isEmpty()) Success = false;
        if (TextField4.getText().isEmpty()) Success = false;
        if (TextField6.getText().isEmpty()) Success = false;
        if (TextField7.getText().isEmpty()) Success = false;
        if (!TextField7.getText().matches(RegexEmail)) Success = false;
        if (TextField8.getText() == "0") Success = false;
        if (PasswordField1.getPassword().length == 0) Success = false;
        if (PasswordField2.getPassword().length == 0) Success = false;
    }

    private void SignUpFormValidations() {
        ValidateName();
        ValidateAddress();
        ValidatePhone();
        ValidateOccupation();
        ValidatePinCode();
        ValidateEmail();
        ValidateInitialAmount();
        ValidatePassword();
        ValidateConfirmPassword();

    }

    private void ValidateName() {
        NameValidation.setForeground(Color.red);

        if (TextField1.getText().isEmpty()) {
            NameValidation.setText("Name Field is Empty");
            Success = false;
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

    private void ValidateAddress() {
        AddressValidation.setForeground(Color.red);
        if (TextField2.getText().isEmpty()) {
            AddressValidation.setText("Address Field is Empty");
            Success = false;
        } else {
            AddressValidation.setText("");
            Success = true;
        }

    }

    private void ValidatePhone() {

        PhoneValidation.setForeground(Color.red);
        if (TextField3.getText().isEmpty()) {
            PhoneValidation.setText("Phone Field Cannot be Empty");
            Success = false;
        } else if (!TextField3.getText().matches("^[0-9]*$")) {
            PhoneValidation.setText("Please Enter Digits only");
            Success = false;
        } else if (!(TextField3.getText().length() == 10)) {
            PhoneValidation.setText("Please Enter 10 digits number only");
            Success = false;
        } else {
            PhoneValidation.setText("");

        }

    }

    private void ValidateOccupation() {
        OccupationValidation.setForeground(Color.red);
        if (TextField4.getText().isEmpty()) {
            OccupationValidation.setText("Please fill Occuption Field");
            Success = false;
        } else {
            OccupationValidation.setText("");
            Success = true;
        }
    }

    private void ValidatePinCode() {
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

    private void ValidateEmail() {
        EmailIDValidation.setForeground(Color.red);
        if (TextField7.getText().isEmpty()) {
            EmailIDValidation.setText("Email Id cannot be empty");
            Success = false;
        } else if (!TextField7.getText().matches(RegexEmail)) {
            EmailIDValidation.setText("Enter valid Email Id");
            Success = false;
        } else {
            EmailIDValidation.setText("");
            // Success = true;
        }

    }

    private void ValidateInitialAmount() {
        InitialAmountValidation.setForeground(Color.red);
        int Amount = Integer.parseInt(TextField8.getText());

        if (Amount == 0) {
            InitialAmountValidation.setText("Enter the Amount");
            Success = false;
        } else if (Amount < 0) {
            InitialAmountValidation.setText("Please enter correct Amount");
            Success = false;
        } else if (Amount < 1500) {
            InitialAmountValidation.setText("Please enter minimum 1500/- cash");
            Success = false;
        } else {
            InitialAmountValidation.setText("");
            Success = true;
        }


    }

    private void ValidatePassword() {
        PasswordValidation.setForeground(Color.red);
        if (PasswordField1.getPassword().length == 0) {
            PasswordValidation.setText("Please fill the password field");
            Success = false;
        } else if (PasswordField1.getPassword().length < 8) {
            PasswordValidation.setText("Please Enter Strong password");
            Success = false;
        } else {
            PasswordValidation.setText("");

        }


    }

    private void ValidateConfirmPassword() {
        ConfirmPassValidation.setForeground(Color.red);
        if (PasswordField2.getPassword().length == 0) {
            ConfirmPassValidation.setText("Please Confirm password ");
            Success = false;
        } else {
            ConfirmPassValidation.setText("");

        }
        for (int i = 0; i < PasswordField2.getPassword().length; i++) {
            if ((Arrays.equals(PasswordField2.getPassword(), PasswordField1.getPassword()))) {
                ConfirmPassValidation.setText("");


            } else {
                ConfirmPassValidation.setText("Password Doesnt Match");
                Success = false;
            }
        }

    }


    public void ResetAll() {
        TextField1.setText(null);
        NameValidation.setText(null);
        TextField2.setText(null);
        TextField3.setText(null);
        TextField4.setText(null);
        Date.setDate(null);
        TextField6.setText(null);
        TextField7.setText(null);
        TextField8.setText(null);
        PasswordField1.setText(null);
        PasswordField2.setText(null);
        PhoneValidation.setText(null);
        PincodeValidation.setText(null);
        EmailIDValidation.setText(null);
        PasswordValidation.setText(null);
        ConfirmPassValidation.setText(null);
        InitialAmountValidation.setText(null);
        Success = false;
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
                ValidateName();
            }
        });
        //label2
        label2 = new JLabel("ADDRESS: ");
        label2.setBounds(40, 50, 150, 20);

        //TextField2
        TextField2 = new JTextField();
        TextField2.setBounds(40, 70, 200, 20);

        //Address Validations
        AddressValidation = new JLabel();
        AddressValidation.setBounds(245, 70, 200, 20);
        TextField2.addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e) {
                ValidateAddress();
            }
        });


        //label3
        label3 = new JLabel("PHONE NO: ");
        label3.setBounds(40, 90, 80, 20);

        //TextField3
        TextField3 = new JTextField();
        TextField3.setBounds(40, 110, 200, 20);

        //Phone Validations
        PhoneValidation = new JLabel();
        PhoneValidation.setBounds(245, 110, 160, 20);
        TextField3.addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e) {
                ValidatePhone();
            }
        });

        //label4
        label4 = new JLabel("OCCUPATION: ");
        label4.setBounds(40, 130, 160, 20);
        TextField4 = new JTextField();
        TextField4.setBounds(40, 150, 200, 20);

        //OccupationValidations
        OccupationValidation = new JLabel();
        OccupationValidation.setBounds(245, 150, 200, 20);
        TextField4.addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e) {
                ValidateOccupation();
            }
        });


        //label 5
        label5 = new JLabel("DOB: ");
        label5.setBounds(40, 170, 50, 20);

        //Date
        Date = new JDateChooser();
        Date.setBounds(40, 189, 200, 20);

        //DateValidations
        DateValidation = new JLabel();
        DateValidation.setBounds(300, 189, 200, 20);
//        Date.addKeyListener(new KeyAdapter() {
//            @Override
//            public void keyReleased(KeyEvent e) {
//                ValidateDate();
//            }
//        });


        //label6
        label6 = new JLabel("PINCODE: ");
        label6.setBounds(40, 210, 80, 20);

        //TextField6
        TextField6 = new JTextField();
        TextField6.setBounds(40, 230, 200, 20);

        TextField6.addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e) {
                ValidatePinCode();
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
                ValidateEmail();
            }
        });

        //label8
        label8 = new JLabel("INITIAL AMOUNT:");
        label8.setBounds(40, 295, 100, 20);

        //TextField8
        TextField8 = new JTextField();
        TextField8.setText("0");
        TextField8.setBounds(40, 315, 200, 20);

        //InitialAmountValidation label
        InitialAmountValidation = new JLabel();
        InitialAmountValidation.setBounds(245, 315, 200, 20);

        TextField8.addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e) {
                ValidateInitialAmount();
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
                ValidatePassword();

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
                ValidateConfirmPassword();
            }
        });

        //ConfirmPassValidation label
        ConfirmPassValidation = new JLabel();
        ConfirmPassValidation.setBounds(245, 395, 160, 20);

        //SubmitButton
        SubmitButton = new JButton("SUBMIT");
        SubmitButton.setBounds(40, 430, 100, 20);
        SubmitButton.setBackground(Color.green);
        SubmitButton.addActionListener(e -> {


            SignUpFormValidations();
            CheckTextBoxEmpty();
            if (Success) {
                System.out.println("Success");
                System.out.println(Date.getDate());
            } else {
                System.out.println("Not a Success");
            }


        });


        //ResetButton
        ResetButton = new JButton("RESET");
        ResetButton.setBounds(150, 430, 100, 20);
        ResetButton.setBackground(Color.ORANGE);
        ResetButton.addActionListener(e -> ResetAll());
        add(label1);
        add(TextField1);
        add(NameValidation);
        add(label2);
        add(TextField2);
        add(AddressValidation);
        add(label3);
        add(TextField3);
        add(label4);
        add(OccupationValidation);
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
        add(InitialAmountValidation);
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
