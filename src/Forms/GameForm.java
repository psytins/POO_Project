package Forms;

import Classes.Game;
import Classes.Player;

import javax.swing.*;
import java.awt.*;
import java.util.Objects;

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

    private final Game currentGame;
    private Player player1;
    private Player player2;

    public JPanel getMainPanel() {
        return mainPanel;
    }

    public GameForm(Game game){
        this.currentGame = game;
        initialize();

    }

    //Initialize game components
    public void initialize(){
        //Get the players
        this.player1 = currentGame.getPlayerOne();
        this.player2 = currentGame.getPlayerTwo();
        //Construct the grid
        ConstructGrid();
        //Set player labels
        playerOneRadioButton.setText(player1.getUsername());
        playerTwoRadioButton.setText(player2.getUsername());
        //Set turn to the player 1
        playerOneRadioButton.setSelected(true);
        playerTwoRadioButton.setSelected(false);
    }

    //Function to construct buttons grid
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

    //Return the winner - every time someone scores, this function is called
    public Player GameFinished(){
        if(Objects.equals(playerOneScoreLabel.getText(), String.valueOf(currentGame.getWin()))){
            return player1;
        } else if (Objects.equals(playerTwoScoreLabel.getText(), String.valueOf(currentGame.getWin()))) {
            return player2;
        }
        else {
            return null;
        }
    }

}
