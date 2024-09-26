package calculator.screen;

import calculator.Main;
import calculator.Operators;
import calculator.frame.OperatorJCombo;

import javax.swing.*;
import javax.swing.text.JTextComponent;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Calculator extends Screen {
    private final JLabel calculatorLabel = new JLabel("Calculator");
    private final JTextField firstValue = new JTextField();
    private final JTextField secondValue = new JTextField();
    private final JTextField answer = new JTextField();
    private final OperatorJCombo operators = new OperatorJCombo();
    private final JButton calculate = new JButton("Calculate");
    private final JButton settings = new JButton();
    private final JButton exit = new JButton("Exit");
    private final List<JButton> buttons = new ArrayList<>();

    public Calculator() {
        this.setDefaultLayout();

        this.ofTextLabel(this.calculatorLabel, createBounds(190, 20, 200, 40));
        this.ofTextComponent(this.firstValue, createBounds(75, 75, 100, 20));
        this.ofDropdown(this.operators, createBounds(200, 75, 75, 20), true);
        this.ofTextComponent(this.secondValue, createBounds(305, 75, 100, 20));
        this.ofTextComponent(this.answer, createBounds(140, 350, 200, 40), false);
        this.ofButton(this.calculate, createBounds(140, 225, 200, 40), true, false);
        this.ofButton(this.settings, createBounds(450, 425, 20, 20), true, false);
        this.ofButton(this.exit, createBounds(140, 275, 200, 40), true, false);

        this.calculatorLabel.setFont(new Font("Bold", Font.BOLD, 18));

        int x = 320;
        int y = 200;
        for (int i = 0; i < 9; i++) {
            if (i == 3 || i == 6) {
                y += 40;
                x = 320;
            }
            JButton button = this.ofButton(new JButton(String.valueOf(i + 1)), createBounds(x, y, 40, 40), true);
            x += 40;
            this.buttons.add(button);
            button.setVisible(false);
        }

        x = 320;
        y = 320;
        for (int i = 0; i < 9; i++) {
            if (i >= 7) {
                y -= 20;
            }
            JButton button = this.ofButton(new JButton(buttonString(i)), createBounds(x, y, 20, 20), true);
            this.buttons.add(button);
            button.setMargin(new Insets(0, 0, 0, 0));
            button.setVisible(false);
            if (!(i >= 6)) {
                x += 20;
            }
        }

        this.getFrame().repaint();
    }

    @Override
    public void actionPerformed(ActionEvent a) {
        if (a.getSource() == this.calculate) {
            Double answer = null;
            try {
                Map<String, Double> values = ofMap(this.firstValue.getText(), this.secondValue.getText());
                answer = calculateBasicAnswer(values, this.operators);
            } catch (NumberFormatException e) {
                try {
                    answer = calculateAdvancedAnswer(this.operators);
                } catch (IndexOutOfBoundsException i) {
                    System.out.println("Missing number!");
                }
            }

            if (answer != null) {
                if (Main.roundNumbers) {
                    answer = Math.round(answer * 100.0) / 100.0D;
                }
                this.answer.setText(String.valueOf(answer));
                System.out.println(answer);
            } else {
                this.answer.setText("Invalid/missing number.");
            }
        }

        if (a.getSource() == this.operators) {
            if (this.operators.isSelectedOf(Operators.twoWayOperators())) {
                this.setDefaultLayout();
                Main.bl = false;
            }
            if (this.operators.isSelectedOf(Operators.oneWayOperators())) {
                this.secondValue.setText(null);
                this.secondValue.setVisible(false);
                this.operators.setBounds(290, this.operators.getY(), this.operators.getWidth(), this.operators.getHeight());
                this.firstValue.setBounds(150, this.operators.getY(), 120, this.operators.getHeight());
            }
            visible(this.operators.getSelectedItem().equals(Operators.ANY.asString()));
            this.getFrame().repaint();
        }

        if (a.getSource() == this.settings) {
            new Settings();
            this.getFrame().dispose();
        }

        for (JButton button : this.buttons) {
            if (a.getSource() == button) {
                if (button.getText().equals("C")) {
                    this.firstValue.setText("");
                } else {
                    this.firstValue.setText(this.firstValue.getText() + button.getText());
                }
            }
        }

        if (a.getSource() == this.exit) {
            System.out.println("Stopping!");
            this.getFrame().dispose();
        }
    }

    private void visible(boolean visible) {
        for (JButton button : this.buttons) {
            button.setVisible(visible);
        }
        Main.bl = visible;
    }

    private String buttonString(int i) {
        switch (i) {
            case 0 -> {
                return Operators.PLUS.asString();
            }
            case 1 -> {
                return Operators.MINUS.asString();
            }
            case 2 -> {
                return Operators.MULTIPLY.asString();
            }
            case 3 -> {
                return Operators.DIVIDE.asString();
            }
            case 4 -> {
                return Operators.MOD.asString();
            }
            case 5 -> {
                return "0";
            }
            case 6 -> {
                return "C";
            }
            case 7 -> {
                return ")";
            }
            case 8 -> {
                return "(";
            }
        }
        return null;
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
        } else if (operators.getSelectedItem().equals("%")) {
            answer = map.get(this.firstValue.getText()) % map.get(this.secondValue.getText());
        }
        return answer;
    }

    private Double calculateAdvancedAnswer(JComboBox<String> operators) {
        Double answer = null;
        if (operators.getSelectedItem().equals(Operators.SQUARE_ROOT.asString())) {
            answer = Math.sqrt(Double.parseDouble(this.firstValue.getText()));
        } else if (operators.getSelectedItem().equals(Operators.CUBED_ROOT.asString())) {
            answer = Math.cbrt(Double.parseDouble(this.firstValue.getText()));
        } else if (operators.getSelectedItem().equals(Operators.CIRCLE_AREA.asString())) {
            answer = Math.PI * Math.pow(Double.parseDouble(this.firstValue.getText()), 2);
        } else if (operators.getSelectedItem().equals(Operators.ANY.asString())) {
            answer = calculateAnyAnswer(this.firstValue);
        }
        return answer;
    }

    public Double calculateAnyAnswer(JTextComponent input) throws IndexOutOfBoundsException {
        List<Double> numbers = new ArrayList<>();
        List<Character> operators = new ArrayList<>();

        for (char character : input.getText().toCharArray()) {
            if (Character.isDigit(character)) {
                double numericalValue = Character.getNumericValue(character);
                numbers.add(numericalValue);
            } else {
                operators.add(character);
            }
        }

        Double x = null;
        for (int i = 0; i < operators.size(); i++) {
            if (operators.get(i) == '%' || operators.get(i).equals('*') || operators.get(i).equals('/')) {
                switch (operators.get(i)) {
                    case '*' -> x = numbers.get(i) * numbers.get(i + 1);
                    case '/' -> x = numbers.get(i) / numbers.get(i + 1);
                    case '%' -> x = numbers.get(i) % numbers.get(i + 1);
                }
                numbers.set(i, x);
                numbers.remove(i + 1);
                operators.remove(i);
                i--;
            }
        }

        x = numbers.getFirst();
        for (int i = 0; i < operators.size(); i++) {
            switch (operators.get(i)) {
                case '+' -> x += numbers.get(i + 1);
                case '-' -> x -= numbers.get(i + 1);
            }
        }
        return x;
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