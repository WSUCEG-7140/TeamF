package WrightFlightManager;
import WrightFlightManager.GUI.WelcomeScreen;

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
