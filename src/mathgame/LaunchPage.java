package mathgame;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LaunchPage extends AbstractPage implements ActionListener {
    JButton startButton = new JButton("Generate Equation");

    public LaunchPage() {
        startButton.setBounds(50, 50, 200, 40);
        startButton.setFocusable(false);
        startButton.addActionListener(this);

        frame.add(this.startButton);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == startButton) {
            frame.dispose();
            EquationPage equationPage = new EquationPage();
        }
    }
}