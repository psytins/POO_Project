package Forms;

import Classes.Game;

import javax.swing.*;

public class GameForm {
    private JPanel mainPanel;
    private JPanel gamePanel;
    private JPanel infoPanel;
    private JLabel testLabel;

    private Game currentGame;

    public GameForm(Game game){
        this.currentGame = game;
        ConstructGrid();
    }

    public void ConstructGrid(){
        testLabel.setText(currentGame.getPlayerOne().getUsername()); //test

    }

    public JPanel getMainPanel() {
        return mainPanel;
    }
}
