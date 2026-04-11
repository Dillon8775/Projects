package college.cc;

import javax.swing.*;
import java.awt.*;

// Dillon Strickland
// 4/9/2026
// An application which takes in a valid code and credit card number, and displays if the card number is valid.
public class ScannerApp extends JFrame {
    private JTextField codeField;
    private JTextField cardField;

    private StringBuilder passedCodes = new StringBuilder();
    private StringBuilder failedCodes = new StringBuilder();

    // Constructor to create the application
    public ScannerApp() {
        setTitle("Dillon Industries Scanner");
        setSize(400, 250);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new FlowLayout());

        // Scanned code button
        add(new JLabel("Scanned Code:"));
        codeField = new JTextField(15);
        add(codeField);

        // Credit card button
        add(new JLabel("Credit Card:"));
        cardField = new JTextField(15);
        add(cardField);

        // Construct buttons
        JButton scanButton = new JButton("Scan Code");
        JButton verifyButton = new JButton("Verify Card");
        JButton displayButton = new JButton("Display Log");

        // Add buttons
        add(scanButton);
        add(verifyButton);
        add(displayButton);

        // Scan Button Logic
        scanButton.addActionListener(e -> {
            String code = codeField.getText();

            // Checks if the code length is exactly 8 and doesn't contain any spaces, then appends it to the passed codes.
            if (code.length() == 8 && !code.contains(" ")) {
                String firstThree = code.substring(0, 3);
                passedCodes.append(firstThree).append(" ");
            } else {
                failedCodes.insert(0, code + " ");
            }

            codeField.setText("");
        });

        // Regex
        String regex = "^[1-9]\\d{3}-[1-3]{4}-\\d{4}-\\d{4}$";

        // Checks if the card number is valid with the code
        verifyButton.addActionListener(e -> {
            String card = cardField.getText();

            if (card.matches(regex)) {
                JOptionPane.showMessageDialog(this, "Valid card number!");
            } else {
                JOptionPane.showMessageDialog(this, "Invalid card number!");
            }
        });

        // Adds the listener for the "display log" button, which displays all passed and failed codes.
        displayButton.addActionListener(e -> {
            String message = "Passed Codes: " + passedCodes.toString()
                    + "\nFailed Codes: " + failedCodes.toString();

            JOptionPane.showMessageDialog(this, message);
        });
    }

    // Runs the program
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new ScannerApp().setVisible(true);
        });
    }
}