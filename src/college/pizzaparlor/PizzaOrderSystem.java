package college.pizzaparlor;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

// Dillon Craig Strickland
// 4/3/2026
// A pizza ordering system, where you can order different sized pizzas with different toppings.
public class PizzaOrderSystem extends JFrame {

    // Components
    private JRadioButton smallBtn, mediumBtn, largeBtn;
    private ButtonGroup sizeGroup;
    private JList<String> toppingsList;
    private JButton orderButton;
    private JTextArea receiptArea;

    public PizzaOrderSystem() {
        // 1. Setup Frame Properties
        setTitle("Pizza Parlor Cash Register");
        setSize(400, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new FlowLayout(FlowLayout.CENTER, 20, 10));

        // 2. Pizza Size Selection (Radio Buttons)
        JPanel sizePanel = new JPanel();
        sizePanel.setBorder(BorderFactory.createTitledBorder("Select Size"));
        smallBtn = new JRadioButton("Small ($8)");
        mediumBtn = new JRadioButton("Medium ($10)");
        largeBtn = new JRadioButton("Large ($12)");
        
        sizeGroup = new ButtonGroup();
        sizeGroup.add(smallBtn);
        sizeGroup.add(mediumBtn);
        sizeGroup.add(largeBtn);
        smallBtn.setSelected(true); // Default selection

        sizePanel.add(smallBtn);
        sizePanel.add(mediumBtn);
        sizePanel.add(largeBtn);

        // Toppings Selection (List Box)
        String[] toppings = {"Pepperoni", "Mushrooms", "Onions", "Sausage", "Bacon", "Extra Cheese", "Black Olives"};
        toppingsList = new JList<>(toppings);
        toppingsList.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
        JScrollPane listScroller = new JScrollPane(toppingsList);
        listScroller.setPreferredSize(new Dimension(150, 100));

        // Order Button
        orderButton = new JButton("Place Order");

        // Receipt Display Area
        receiptArea = new JTextArea(10, 30);
        receiptArea.setEditable(false);
        receiptArea.setBorder(BorderFactory.createLineBorder(Color.GRAY));

        // Action Listener for the Button
        orderButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                calculateTotal();
            }
        });

        // Add everything to the frame
        add(sizePanel);
        add(new JLabel("Hold Ctrl/Cmd to select multiple toppings:"));
        add(listScroller);
        add(orderButton);
        add(new JScrollPane(receiptArea));
    }

    private void calculateTotal() {
        double total = 0;
        String sizeName = "";

        // Determine size price
        if (smallBtn.isSelected()) {
            total = 8;
            sizeName = "Small";
        } else if (mediumBtn.isSelected()) {
            total = 10;
            sizeName = "Medium";
        } else if (largeBtn.isSelected()) {
            total = 12;
            sizeName = "Large";
        }

        // Get selected toppings (assuming $1.00 per topping)
        List<String> selectedToppings = toppingsList.getSelectedValuesList();
        double toppingCost = selectedToppings.size() * 1.00;
        total += toppingCost;

        // Display Receipt
        StringBuilder sb = new StringBuilder();
        sb.append("--- PIZZA ORDER ---\n");
        sb.append("Size: ").append(sizeName).append("\n");
        sb.append("Toppings: ").append(selectedToppings.isEmpty() ? "None" : selectedToppings).append("\n");
        sb.append("-------------------\n");
        sb.append(String.format("TOTAL: $%.2f", total));

        receiptArea.setText(sb.toString());
    }

    public static void main(String[] args) {
        // Run the GUI on the Event Dispatch Thread
        new PizzaOrderSystem().setVisible(true);
    }
}