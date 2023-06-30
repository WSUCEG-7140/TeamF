package WrightFlightManager;
import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        // Call to establish connection to DB
        // Call to inject dependencies for interfaces as objects
        SwingUtilities.invokeLater(() -> {
            new WelcomeScreen();
        });
    }
}

public class WelcomeScreen extends JFrame {
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
