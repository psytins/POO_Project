import Forms.GameMenuForm;
import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        JFrame mainFrame = new JFrame("TicTacToe - Menu");
        mainFrame.setContentPane(new GameMenuForm().mainPanel);
        mainFrame.setSize(800,800);
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainFrame.setVisible(true);
        mainFrame.setResizable(false);
    }

}