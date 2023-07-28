package WrightFlightManager.GUI;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

public class LoginUsernameAndPasswordView extends JFrame {
    private JLabel usernameLabel;
    private JTextField usernameField;
    private JLabel passwordLabel;
    private JPasswordField passwordField;
    private JButton loginButton;

    public LoginUsernameAndPasswordView() {
        setTitle("Login");
        setLayout(null);

        usernameLabel = new JLabel("Username:");
        usernameLabel.setBounds(20, 20, 80, 25);
        add(usernameLabel);

        usernameField = new JTextField();
        usernameField.setBounds(100, 20, 200, 25);
        add(usernameField);

        passwordLabel = new JLabel("Password:");
        passwordLabel.setBounds(20, 60, 80, 25);
        add(passwordLabel);

        passwordField = new JPasswordField();
        passwordField.setBounds(100, 60, 200, 25);
        add(passwordField);

        loginButton = new JButton("Login");
        loginButton.setBounds(20, 100, 280, 25);
        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String username = usernameField.getText();
                String password = new String(passwordField.getPassword());

                // Perform user authentication
                boolean isAuthenticated = authenticateUser(username, password);

                if (isAuthenticated) {
                    JOptionPane.showMessageDialog(LoginUsernameAndPasswordView.this, "Login Successful");
                    // TODO: Handle login success and redirect to appropriate view
                } else {
                    JOptionPane.showMessageDialog(LoginUsernameAndPasswordView.this, "Invalid username or password", "Login Failed", JOptionPane.ERROR_MESSAGE);
                }

                // Clear input fields
                usernameField.setText("");
                passwordField.setText("");
            }
        });
        add(loginButton);

        setSize(330, 180);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);
        setVisible(true);
    }

    private boolean authenticateUser(String username, String password) {
        try (BufferedReader reader = new BufferedReader(new FileReader("users.psv"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] userData = line.split("\\|");
                if (userData.length == 12) {
                    String user = userData[0];
                    String passwordHash = userData[1];
                    String passwordSalt = userData[2];
                    //Role userRole = Role.valueOf(userData[3]);// uncomment it when uploading
                    String firstName = userData[4];
                    String lastName = userData[5];
                    String streetAddress = userData[6];
                    String city = userData[7];
                    String state = userData[8];
                    String zipcode = userData[9];
                    String phoneNumber = userData[10];
                    String emailAddress = userData[11];

                    if (user.equals(username) && isPasswordMatch(password, passwordHash, passwordSalt)) {
                        return true;
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return false;
    }

    private boolean isPasswordMatch(String password, String passwordHash, String passwordSalt) {
        String hashedPassword = hashPassword(password, passwordSalt);
        return hashedPassword.equals(passwordHash);
    }

    private String hashPassword(String password, String salt) {
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            byte[] saltBytes = Base64.getDecoder().decode(salt);
            md.update(saltBytes);
            byte[] hashedPasswordBytes = md.digest(password.getBytes(StandardCharsets.UTF_8));
            return Base64.getEncoder().encodeToString(hashedPasswordBytes);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return null;
    }
}
