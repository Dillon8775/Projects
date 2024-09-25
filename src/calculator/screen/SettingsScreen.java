package calculator.screen;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class SettingsScreen extends AbstractScreen {
    private final JLabel settingsTitle = new JLabel("Settings");

    public SettingsScreen() {
        this.settingsTitle.setFont(new Font("Bold", Font.BOLD, 24));
        this.ofTextLabel(this.settingsTitle, this.createBounds(190, 40, 200, 40));

        this.getFrame().repaint();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
    }

    @Override
    protected String windowTitle() {
        return "Calculator Settings";
    }
}
