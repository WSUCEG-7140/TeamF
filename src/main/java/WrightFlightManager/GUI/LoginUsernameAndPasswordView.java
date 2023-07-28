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

/**
 * @class LoginUsernameAndPasswordView
 * @brief Represents a JFrame for user login with username and password fields.
 * This class provides a graphical user interface for users to enter their
 * credentials (username and password) and attempt to log in.
 */
public class LoginUsernameAndPasswordView extends JFrame {
    private JLabel usernameLabel;
    private JTextField usernameField;
    private JLabel passwordLabel;
    private JPasswordField passwordField;
    private JButton loginButton;

    /**
     * @fn public LoginUsernameAndPasswordView()
     * @brief Constructor for LoginUsernameAndPasswordView class.
     * Initializes the JFrame with username, password fields, and login button.
     * Sets the layout, adds UI components, and sets the window properties.
     * The login button action listener handles the login process and authentication.
     */
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

    /**
     * @fn private boolean authenticateUser(String username, String password)
     * @brief Authenticates the user's credentials by checking against a user database.
     * This method reads user data from a file ("users.psv") and compares the provided
     * username and password with the stored credentials to perform authentication.
     * @param username The entered username to be authenticated.
     * @param password The entered password to be authenticated.
     * @return true if the username and password match an existing user, false otherwise.
     */
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

    /**
     * @fn private boolean isPasswordMatch(String password, String passwordHash, String passwordSalt)
     * @brief Compares the hashed password with the provided password after hashing it.
     * This method hashes the provided password using SHA-256 algorithm with the given salt,
     * then compares the resulting hash with the stored password hash to check for a match.
     * @param password The password to be hashed and compared.
     * @param passwordHash The hashed password retrieved from the user database.
     * @param passwordSalt The salt used during password hashing.
     * @return true if the hashed password matches the stored password hash, false otherwise.
     */
    private boolean isPasswordMatch(String password, String passwordHash, String passwordSalt) {
        String hashedPassword = hashPassword(password, passwordSalt);
        return hashedPassword.equals(passwordHash);
    }

    /**
     * @fn private String hashPassword(String password, String salt)
     * @brief Hashes the provided password using the SHA-256 algorithm and the given salt.
     * This method takes a plain password and a salt as input, hashes the password using
     * the SHA-256 algorithm with the provided salt, and returns the resulting hash as a Base64-encoded string.
     * @param password The password to be hashed.
     * @param salt The salt used during password hashing.
     * @return The hashed password as a Base64-encoded string.
     */
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
