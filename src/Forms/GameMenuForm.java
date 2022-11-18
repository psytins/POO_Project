package Forms;

import javax.swing.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class GameMenuForm {
    private JButton testButton;
    public JPanel mainPanel;

    public GameMenuForm() {

        testButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                JOptionPane.showMessageDialog(null, "Hello World!");
            }
        });
    }
}
