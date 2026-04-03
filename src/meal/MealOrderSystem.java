package meal;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

// Dillon C Strickland
// 4/3/2026
// A meal order system, where you order a basic meal, with different discounts and drinks.
public class MealOrderSystem extends JFrame {
    private JTextField mealPriceField;
    private JRadioButton noneRB, studentRB, seniorRB;
    private JCheckBox drinkCheckBox;
    private JTextArea outputArea;
    private JButton calculateButton;

    public MealOrderSystem() {
        // Window Setup
        setTitle("Meal Order System");
        setSize(400, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new FlowLayout());

        // 1. Meal Price Input
        add(new JLabel("Meal Price: $"));
        mealPriceField = new JTextField(10);
        add(mealPriceField);

        // 2. Discount Radio Buttons
        noneRB = new JRadioButton("None", true);
        studentRB = new JRadioButton("Student");
        seniorRB = new JRadioButton("Senior");

        // Group them so only one can be selected
        ButtonGroup discountGroup = new ButtonGroup();
        discountGroup.add(noneRB);
        discountGroup.add(studentRB);
        discountGroup.add(seniorRB);

        add(new JLabel("Select Discount:"));
        add(noneRB); add(studentRB); add(seniorRB);

        // 3. Drink Option
        drinkCheckBox = new JCheckBox("Add Drink ($0.70)");
        add(drinkCheckBox);

        // 4. Calculate Button
        calculateButton = new JButton("Print Order");
        add(calculateButton);

        // 5. Output Area (Disabled text field/area)
        outputArea = new JTextArea(5, 30);
        outputArea.setEditable(false);
        add(outputArea);

        // Event Handling
        calculateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                calculateTotal();
            }
        });
    }

    private void calculateTotal() {
        try {
            double mealPrice = Double.parseDouble(mealPriceField.getText());
            double drinkPrice = 0.70;
            double total = mealPrice;
            String details = "Order Summary:\n";

            if (drinkCheckBox.isSelected()) {
                total += drinkPrice;
                details += "Meal + Drink included.\n";
            } else {
                details += "Meal only.\n";
            }

            // Apply Discounts
            if (studentRB.isSelected()) {
                // Student gets free drink or $0.70 off
                total -= 0.70;
                details += "Student Discount applied (-$0.70)\n";
            } else if (seniorRB.isSelected()) {
                // Senior gets 15% off entire order
                total = total * 0.85;
                details += "Senior Discount applied (15% off)\n";
            }

            // Ensure price doesn't go below zero
            if (total < 0) total = 0;

            outputArea.setText(details + String.format("Final Total: $%.2f", total));

        } catch (NumberFormatException ex) {
            outputArea.setText("Error: Please enter a valid meal price.");
        }
    }

    public static void main(String[] args) {
        new MealOrderSystem().setVisible(true);
    }
}