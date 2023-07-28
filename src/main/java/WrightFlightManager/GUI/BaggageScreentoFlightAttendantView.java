package WrightFlightManager.GUI;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

//change functionality according to available database
//Issue no 50
/**
 * @class BaggageScreentoFlightAttendantView
 * @brief Represents the JFrame for the flight attendant's baggage scanning functionality.
 */
public class BaggageScreentoFlightAttendantView  extends JFrame {
    private JPanel mainPanel;
    private CardLayout cardLayout;
    private BaggageScreenPanel baggageScreenPanel;

    /**
     * @brief Default constructor for BaggageScreentoFlightAttendantView.
     * Sets up the GUI components and initializes the baggage screen panel.
     */
    public BaggageScreentoFlightAttendantView() {
        setTitle("Flight Control System");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(600, 400);
        setResizable(false);
        setLocationRelativeTo(null);
        mainPanel = new JPanel();
        cardLayout = new CardLayout();
        mainPanel.setLayout(cardLayout);

        baggageScreenPanel = new BaggageScreenPanel();
        mainPanel.add(baggageScreenPanel, "BaggageScreenPanel");

        getContentPane().add(mainPanel);

        setVisible(true);
    }


    //create a BaggageScreenPanel

    private class BaggageScreenPanel extends JPanel {
        private JLabel baggageInfoLabel;
        private JTextField baggageNumberField;
        private JButton scanBaggageButton;

        /**
         * @brief Constructor for BaggageScreenPanel.
         * Sets up the GUI components for baggage scanning.
         */
        public BaggageScreenPanel() {
            setLayout(new FlowLayout());

            baggageInfoLabel = new JLabel("Baggage Information:");
            baggageNumberField = new JTextField(10);
            scanBaggageButton = new JButton("Scan Baggage");

            add(baggageInfoLabel);
            add(baggageNumberField);
            add(scanBaggageButton);

            scanBaggageButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    String baggageNumber = baggageNumberField.getText();
                    /*
                    apply algorithms or operations on baggageNumber as per your requirements
                    */
                    // Display message for confirmation
                    JOptionPane.showMessageDialog(BaggageScreenPanel.this,
                            "Baggage scanned: " + baggageNumber,
                            "Baggage Scanning", JOptionPane.INFORMATION_MESSAGE);
                }
            });
        }
    }
}
