package calculator;

import calculator.screen.CalculatorScreen;

import javax.swing.*;
import javax.swing.text.JTextComponent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static final double PI = 3.14159265359;
    private static final List<JTextField> inputs = new ArrayList<>();

    public static void main(String[] args) {
        System.out.println("Starting calculator app...");

        openCalculatorScreen();

        System.out.println("Successfully started calculator app!");
    }

    protected static void openCalculatorScreen() {
        CalculatorScreen launchPage = new CalculatorScreen();
        inputs.add(launchPage.getFirstValue());
        inputs.add(launchPage.getSecondValue());

        for (JTextComponent field : inputs) {
            field.addKeyListener(new KeyAdapter() {
                public void keyTyped(KeyEvent e) {
                    try {
                        Double.parseDouble(field.getText() + e.getKeyChar());
                    } catch (NumberFormatException n) {
                        e.consume();
                    }
                }
            });
        }
    }
}