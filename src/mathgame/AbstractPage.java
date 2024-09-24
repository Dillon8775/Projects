package mathgame;

import javax.swing.*;

public abstract class AbstractPage {
    JFrame frame = new JFrame();

    public AbstractPage() {
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 400);
        frame.setLayout(null);
        frame.setVisible(true);
    }
}