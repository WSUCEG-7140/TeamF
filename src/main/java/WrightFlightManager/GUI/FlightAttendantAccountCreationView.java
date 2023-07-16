package WrightFlightManager.GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FlightAttendantAccountCreationView extends JFrame {

    private JButton createAccountButton;

    public FlightAttendantAccountCreationView () {
        // Create the main frame
        setTitle("Flight Attendant System");
        setSize(600, 600);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);
        setLayout(null);

        // Create the create account button
        createAccountButton = createButton("Create Flight Attendant Account", 180, 200, 240, 30);

        // Add components to the frame
        add(createAccountButton);

        // Register action listeners for the buttons
        createAccountButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                FlightAttendantAccountCreationView ob = new FlightAttendantAccountCreationView();
                ob.setVisible(true);
            }
        });
    }

    private JButton createButton(String label, int x, int y, int width, int height) {
        JButton button = new JButton(label);
        button.setBounds(x, y, width, height);
        return button;
    }

    private JLabel createLabel(String text, int x, int y, int width, int height) {
        JLabel label = new JLabel(text);
        label.setBounds(x, y, width, height);
        return label;
    }

    private JTextField createTextField(int x, int y, int width, int height) {
        JTextField textField = new JTextField();
        textField.setBounds(x, y, width, height);
        return textField;
    }

    private JPasswordField createPasswordField(int x, int y, int width, int height) {
        JPasswordField passwordField = new JPasswordField();
        passwordField.setBounds(x, y, width, height);
        return passwordField;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                FlightAttendantAccountCreationView system = new FlightAttendantAccountCreationView();
                system.setVisible(true);
            }
        });
    }
}
