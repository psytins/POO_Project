package Forms;

import Classes.Game;
import Classes.Player;

import javax.swing.*;
import java.awt.*;

public class GameForm {
    private JPanel mainPanel;
    private JPanel gamePanel;
    private JPanel infoPanel;
    private JLabel turnLabel;
    private JLabel scoreLabel;
    private JRadioButton playerOneRadioButton;
    private JRadioButton playerTwoRadioButton;
    private JLabel playerOneScoreLabel;
    private JLabel playerTwoScoreLabel;
    private JButton cancelGameButton;

    private Game currentGame;
    private Player player1;
    private Player player2;

    public GameForm(Game game){
        this.currentGame = game;
        initialize();

    }

    public void initialize(){
        //Get the players
        this.player1 = currentGame.getPlayerOne();
        this.player2 = currentGame.getPlayerTwo();
        //Construct the grid
        ConstructGrid();
        //Set player labels
        playerOneRadioButton.setText(player1.getUsername());
        playerTwoRadioButton.setText(player2.getUsername());
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
