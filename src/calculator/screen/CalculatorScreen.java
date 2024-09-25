package calculator.screen;

import calculator.Main;
import calculator.frame.OperatorJCombo;
import calculator.Operators;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.HashMap;
import java.util.Map;

public class CalculatorScreen extends AbstractScreen {
    private final JTextField firstValue = new JTextField();
    private final JTextField secondValue = new JTextField();
    private final JTextField answer = new JTextField();
    private final OperatorJCombo operators = new OperatorJCombo();
    private final JButton calculate = new JButton("Calculate");
    private final JButton settings = new JButton();
    private final JButton exit = new JButton("Exit");

    public CalculatorScreen() {
        this.setDefaultLayout();

        this.ofTextComponent(this.firstValue, createBounds(75, 75, 100, 20));
        this.ofDropdown(this.operators, createBounds(215, 75, 50, 20), true);
        this.ofTextComponent(this.secondValue, createBounds(305, 75, 100, 20));
        this.ofTextComponent(this.answer, createBounds(140, 350, 200, 40), false);
        this.ofButton(this.calculate, createBounds(140, 225, 200, 40), true, false);
        this.ofButton(this.settings, createBounds(450, 425, 20, 20), true, false);
        this.ofButton(this.exit, createBounds(140, 275, 200, 40), true, false);

        this.getFrame().repaint();
    }

    @Override
    public void actionPerformed(ActionEvent a) {
        if (a.getSource() == this.calculate) {
            Double answer;
            try {
                Map<String, Double> values = ofMap(this.firstValue.getText(), this.secondValue.getText());
                answer = calculateBasicAnswer(values, this.operators);
            } catch (NumberFormatException e) {
                answer = calculateAdvancedAnswer(this.operators);
            }
            this.answer.setText(answer != null ? String.valueOf(answer) : "Invalid/missing number");
        }

        if (a.getSource() == this.operators) {
            if (this.operators.isSelectedOf(Operators.twoWayOperators())) {
                this.setDefaultLayout();
            }
            if (this.operators.isSelectedOf(Operators.oneWayOperators())) {
                this.secondValue.setText(null);
                this.secondValue.setVisible(false);
                this.operators.setBounds(290, this.operators.getY(), this.operators.getWidth(), this.operators.getHeight());
                this.firstValue.setBounds(150, this.operators.getY(), 120, this.operators.getHeight());
            }
            this.getFrame().repaint();
        }

        if (a.getSource() == this.settings) {
            new SettingsScreen();
            this.getFrame().dispose();
        }

        if (a.getSource() == this.exit) {
            System.out.println("Stopping!");
            this.getFrame().dispose();
        }
    }

    private void setDefaultLayout() {
        this.firstValue.setBounds(75, 75, 100, 20);
        this.secondValue.setVisible(true);
        this.operators.setBounds(215, 75, 50, 20);
        this.operators.setLayout(new FlowLayout());
        this.secondValue.setBounds(305, 75, 100, 20);
    }

    private Map<String, Double> ofMap(String firstValue, String secondValue) {
        Map<String, Double> map = new HashMap<>();
        map.put(firstValue, Double.parseDouble(firstValue));
        map.put(secondValue, Double.parseDouble(secondValue));
        return map;
    }

    private Double calculateBasicAnswer(Map<String, Double> map, JComboBox<String> operators) {
        Double answer = null;
        if (operators.getSelectedItem().equals("+")) {
            answer = map.get(this.firstValue.getText()) + map.get(this.secondValue.getText());
        } else if (operators.getSelectedItem().equals("-")) {
            answer = map.get(this.firstValue.getText()) - map.get(this.secondValue.getText());
        } else if (operators.getSelectedItem().equals("*")) {
            answer = map.get(this.firstValue.getText()) * map.get(this.secondValue.getText());
        } else if (operators.getSelectedItem().equals("/")) {
            answer = map.get(this.firstValue.getText()) / map.get(this.secondValue.getText());
        }
        return answer;
    }

    private Double calculateAdvancedAnswer(JComboBox<String> operators) {
        Double answer = null;
        if (operators.getSelectedItem().equals(Operators.SQUARE_ROOT.getStringOperator())) {
            answer = Math.sqrt(Double.parseDouble(this.firstValue.getText()));
        } else if (operators.getSelectedItem().equals(Operators.CUBED_ROOT.getStringOperator())) {
            answer = Math.cbrt(Double.parseDouble(this.firstValue.getText()));
        } else if (operators.getSelectedItem().equals(Operators.CIRCLE_AREA.getStringOperator())) {
            answer = Main.PI * Math.pow(Double.parseDouble(this.firstValue.getText()), 2);
        }
        return answer;
    }

    public JTextField getFirstValue() {
        return this.firstValue;
    }

    public JTextField getSecondValue() {
        return this.secondValue;
    }

    @Override
    protected String windowTitle() {
        return "Calculator";
    }
}