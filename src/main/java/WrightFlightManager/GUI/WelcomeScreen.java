package WrightFlightManager.GUI;

import javax.swing.*;
/**
 * @class WelcomeScreen
 * @brief Represents a custom JFrame class displaying a welcome message.
 */

public class WelcomeScreen extends JFrame {
    /**
     * @brief Constructor for WelcomeScreen class.
     *        Initializes the JFrame properties and displays a welcome message.
     */
    public WelcomeScreen() {
        setTitle("Welcome");
        setSize(600, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);
        JLabel welcomeLabel = new JLabel("Welcome to Wright Flight Manager App");
        welcomeLabel.setHorizontalAlignment(SwingConstants.CENTER);
        add(welcomeLabel);

        setVisible(true);
    }
}
