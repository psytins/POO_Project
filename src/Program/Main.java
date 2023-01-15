package Program;

import Classes.Game;
import Forms.GameForm;
import Forms.GameMenuForm;
import javax.swing.*;

public class Main {
    static public JFrame gameMenuFrame;
    static public JFrame gameFrame;

    public static void main(String[] args) {
        StartGameMenu();
    }

    public static void StartGameMenu(){
        gameMenuFrame = new JFrame("TicTacToe - Menu");
        gameMenuFrame.setContentPane(new GameMenuForm().getMainPanel());
        gameMenuFrame.setSize(800,800);
        //mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        gameMenuFrame.setVisible(true);
        //mainFrame.setResizable(false);
    }

    public static void StartGame(Game game){
        //Open Game Form
        gameFrame = new JFrame("TicTacToe - Game");
        gameFrame.setContentPane(new GameForm(game).getMainPanel());
        gameFrame.setSize(800,800);
        gameFrame.setExtendedState(gameFrame.getExtendedState() | JFrame.MAXIMIZED_BOTH);
        //gameFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        gameFrame.setVisible(true);
        //gameFrame.setResizable(false);
    }

}