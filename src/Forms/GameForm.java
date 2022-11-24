package Forms;

import Classes.Game;

import javax.swing.*;
import java.awt.*;

public class GameForm {
    private JPanel mainPanel;
    private JPanel gamePanel;
    private JPanel infoPanel;
    private JLabel turnrLabel;
    private JLabel scoreLabel;
    private JRadioButton playerOneRadioButton;
    private JRadioButton playerTwoRadioButton;
    private JLabel playerOneScoreLabel;
    private JLabel playerTwoScoreLabel;
    private JButton cancelGameButton;

    private Game currentGame;

    public GameForm(Game game){
        this.currentGame = game;
        ConstructGrid();
    }

    public void ConstructGrid(){
        JButton tempButton;
        gamePanel.setLayout(new GridLayout(currentGame.getGridNumber(), currentGame.getGridNumber()));

        for(int r = 0; r < currentGame.getGrid().length; r++){
            for(int c = 0; c < currentGame.getGrid().length; c++){
                tempButton = new JButton("");

                gamePanel.add(tempButton);

            }
        }

    }

    public JPanel getMainPanel() {
        return mainPanel;
    }
}
