package jpanel;
import javax.swing.*;
import java.awt.event.*;

public class JavaWorld {
    
    public static void main(String[] args) {
        // The Initial JFrame window
        JFrame frame = new JFrame("The Java World");

        frame.setSize(1080, 720);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);

        JPanel panel = new JPanel();

        JLabel helloText = new JLabel("Hello!");
        JLabel pressTheButtonLabel = new JLabel("Press the button!");

        JButton button = new JButton(":D");
        
        panel.add(helloText);
        panel.add(pressTheButtonLabel);
        panel.add(button);

        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                pressTheButtonLabel.setText("Button clicked!");
                panel.remove(helloText);
                refresh(panel);
            }
        });

        frame.add(panel);
    }

    private static void refresh(JPanel panel) {
        panel.revalidate();
        panel.repaint();
    }
}