package WrightFlightManager.GUI;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileWriter;
import java.io.IOException;

public class PassengerAccountCreationView extends JFrame {
    private JLabel nameLabel;
    private JTextField nameField;
    private JLabel emailLabel;
    private JTextField emailField;
    private JLabel passwordLabel;
    private JPasswordField passwordField;
    private JButton createAccountButton;

    public PassengerAccountCreationView () {
        setTitle("Passenger Account Creation");
        setLayout(null);

        nameLabel = new JLabel("Name:");
        nameLabel.setBounds(20, 20, 80, 25);
        add(nameLabel);

        nameField = new JTextField();
        nameField.setBounds(100, 20, 200, 25);
        add(nameField);

        emailLabel = new JLabel("Email:");
        emailLabel.setBounds(20, 60, 80, 25);
        add(emailLabel);

        emailField = new JTextField();
        emailField.setBounds(100, 60, 200, 25);
        add(emailField);

        passwordLabel = new JLabel("Password:");
        passwordLabel.setBounds(20, 100, 80, 25);
        add(passwordLabel);

        passwordField = new JPasswordField();
        passwordField.setBounds(100, 100, 200, 25);
        add(passwordField);

        createAccountButton = new JButton("Create Account");
        createAccountButton.setBounds(20, 140, 280, 25);
        createAccountButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String name = nameField.getText();
                String email = emailField.getText();
                String password = new String(passwordField.getPassword());

                // Save data to PSV file
                saveData(name, email, password);

                // Clear input fields
                nameField.setText("");
                emailField.setText("");
                passwordField.setText("");
            }
        });
        add(createAccountButton);

        setSize(330, 220);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);
        setVisible(true);
    }

    private void saveData(String name, String email, String password) {
        try (FileWriter writer = new FileWriter("PassengerAccounts.psv", true)) {
            String line = name + "|" + email + "|" + password + "\n";
            writer.write(line);
            JOptionPane.showMessageDialog(null,"Data saved successfully!");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}