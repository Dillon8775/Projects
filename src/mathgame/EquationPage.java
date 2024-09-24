package mathgame;

import javax.swing.*;
import java.awt.*;
import java.util.Random;

public class EquationPage extends AbstractPage {
    Random random = new Random();
    JLabel label = new JLabel();

    public EquationPage() {
        label.setBounds(0, 0, 100, 50);
        label.setFont(new Font(null, Font.PLAIN, 25));

        frame.add(label);
    }
}