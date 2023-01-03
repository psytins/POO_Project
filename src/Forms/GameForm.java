package Forms;

import Classes.Game;
import Classes.Player;
import Program.Main;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowEvent;
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
        main();
    }

    public void main(){
        //Listeners
        cancelGameButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                //When the Cancel button is clicked
                CancelGame();

            }
        });

    }

    //Cancel game when cancel button is pressed
    public void CancelGame(){
        //cancel current stats
        GameFinished();
        //Close actual game window
        Main.gameFrame.dispatchEvent(new WindowEvent(Main.gameFrame, WindowEvent.WINDOW_CLOSING));
        //Open game menu window
        Main.StartGameMenu();
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
        ChangeTurn(player1);
    }
    public void ChangeTurn(Player turnTo){
        if(turnTo == player1) {
            playerOneRadioButton.setSelected(true);
            playerTwoRadioButton.setSelected(false);
            currentGame.setTurn(player1);
        }
        else if (turnTo == player2) {
            playerOneRadioButton.setSelected(false);
            playerTwoRadioButton.setSelected(true);
            currentGame.setTurn(player2);
        }
    }

    //Function to construct buttons grid
    public void ConstructGrid(){
        JButton tempButton;
        gamePanel.setLayout(new GridLayout(currentGame.getGridNumber(), currentGame.getGridNumber()));

        for(int r = 0; r < currentGame.getGrid().length; r++){
            for(int c = 0; c < currentGame.getGrid().length; c++){
                tempButton = new JButton("");
                tempButton.setName(String.valueOf(r) + String.valueOf(c));
                tempButton.addMouseListener(new MouseAdapter() {
                    @Override
                    public void mouseClicked(MouseEvent e) {
                        super.mouseClicked(e);
                        PlayerMove(e.getComponent());
                    }
                });

                gamePanel.add(tempButton);
            }
        }
    }

    public void PlayerMove(Component clickedButton){
        JButton button = (JButton) clickedButton;
        if(Objects.equals(button.getText(), "")){ //make the move only if is empty
            button.setText(currentGame.getTurn().getUsername());
            if (currentGame.getTurn() == player1){
                ChangeTurn(player2);
            }
            else if(currentGame.getTurn() == player2){
                ChangeTurn(player1);
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
