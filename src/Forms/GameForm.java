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
    private JRadioButton playerOneRadioButton;
    private JRadioButton playerTwoRadioButton;
    private JButton cancelGameButton;
    private JButton drawButton;

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
        drawButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                DrawGame("Draw");
            }
        });

    }

    public void DrawGame(String whatIs){
        String[] choices = {"Play Again", "Exit"};
        int option = JOptionPane.showOptionDialog(
                null
                , whatIs + "!\nWhat do you wanna do next?"
                , whatIs + "!"
                , JOptionPane.YES_NO_OPTION
                , JOptionPane.PLAIN_MESSAGE
                , null
                , choices
                , "Play Again"
        );

        switch (option) {
            case 0 -> {
                Game game = new Game(currentGame.getPlayerOne(), currentGame.getPlayerTwo(), currentGame.getWin(), currentGame.getGridNumber(), currentGame.getGameOptions());

                //Close this form
                Main.gameFrame.dispatchEvent(new WindowEvent(Main.gameFrame, WindowEvent.WINDOW_CLOSING));
                Main.StartGame(game);
            }
            case 1 -> CancelGame();
        }
    }

    //Cancel game when cancel button is pressed
    public void CancelGame(){
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
        playerOneRadioButton.setText("Player 1: " + player1.getUsername());
        playerTwoRadioButton.setText("Player 2: " + player2.getUsername());
        //Set turn to the player 1
        ChangeTurn(player1);
    }
    public void ChangeTurn(Player turnTo){
        if(turnTo == player1) {
            playerOneRadioButton.setEnabled(true);
            playerTwoRadioButton.setEnabled(false);

            playerOneRadioButton.setSelected(true);
            playerTwoRadioButton.setSelected(false);

            currentGame.setTurn(player1);
        }
        else if (turnTo == player2) {
            playerOneRadioButton.setEnabled(false);
            playerTwoRadioButton.setEnabled(true);

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
                tempButton.setBackground(new Color(38,70,83));
                tempButton.setForeground(new Color(38,70,83));
                tempButton.setFont(new Font("Consolas", Font.PLAIN,20));
                tempButton.setFocusPainted(false);
                tempButton.setName(String.valueOf(r) + String.valueOf(c));
                tempButton.addMouseListener(new MouseAdapter() {
                    @Override
                    public void mouseClicked(MouseEvent e) {
                        super.mouseClicked(e);
                        PlayerMove(e.getComponent());
                    }
                });

                currentGame.getButtonGrid()[r][c] = tempButton;

                gamePanel.add(tempButton);
            }
        }
    }

    public void PlayerMove(Component clickedButton){
        JButton button = (JButton) clickedButton;

        if(Objects.equals(button.getText(), "")){ //make the move only if is empty
            button.setText(currentGame.getTurn().getUsername());


            int pos1 = Integer.parseInt(clickedButton.getName().substring(0,1));
            int pos2 = Integer.parseInt(clickedButton.getName().substring(1));

            //Normal game option
            if(currentGame.getGameOptions()== 0){
                if (currentGame.getTurn() == player1){
                    button.setBackground(new Color(244,162,97));
                    currentGame.getGrid()[pos1][pos2] = 1;
                    if(checkWin(1)){
                        DrawGame(player1.getUsername() + " WON");
                    }
                    ChangeTurn(player2);
                }
                else if(currentGame.getTurn() == player2){
                    button.setBackground(new Color(231,111,81));
                    currentGame.getGrid()[pos1][pos2] = 2;
                    if(checkWin(2)){
                        DrawGame(player2.getUsername() + " WON");
                    }
                    ChangeTurn(player1);
                }
            }

            //Misére game option
            if(currentGame.getGameOptions()==1){
                if (currentGame.getTurn() == player1){
                    button.setBackground(new Color(244,162,97));
                    currentGame.getGrid()[pos1][pos2] = 1;
                    if(checkWin(1)){
                        DrawGame(player2.getUsername() + " WON");
                    }
                    ChangeTurn(player2);
                }
                else if(currentGame.getTurn() == player2){
                    button.setBackground(new Color(231,111,81));
                    currentGame.getGrid()[pos1][pos2] = 2;
                    if(checkWin(2)){
                        DrawGame(player1.getUsername() + " WON");
                    }
                    ChangeTurn(player1);
                }
            }

            //Random turn game option
            if(currentGame.getGameOptions()==2){
                if (currentGame.getTurn() == player1){
                    button.setBackground(new Color(244,162,97));
                    currentGame.getGrid()[pos1][pos2] = 1;
                    if(checkWin(1)){
                        DrawGame(player1.getUsername() + " WON");
                    }
                    double randomNum = Math.random();
                    if (randomNum < 0.5) {
                        ChangeTurn(player1);
                    } else {
                        ChangeTurn(player2);
                    }
                }
                else if(currentGame.getTurn() == player2){
                    button.setBackground(new Color(231,111,81));
                    currentGame.getGrid()[pos1][pos2] = 2;
                    if(checkWin(2)){
                        DrawGame(player2.getUsername() + " WON");
                    }
                    double randomNum = Math.random();
                    if (randomNum < 0.5) {
                        ChangeTurn(player1);
                    } else {
                        ChangeTurn(player2);
                    }
                }
            }

        }
    }

    // Method to check if a player has won the game
    public boolean checkWin(int player) {
        int BOARD_SIZE = currentGame.getWin();
        int BOARD_SIZE_DIAG = currentGame.getGridNumber();
        int [][] board = currentGame.getGrid();
        int numToWin = currentGame.getWin();

        JButton [][] buttonsToWin = new JButton[BOARD_SIZE][BOARD_SIZE];

        // Check rows
        for (int i = 0; i < BOARD_SIZE; i++) {
            boolean rowWin = true;
            for (int j = 0; j < BOARD_SIZE; j++) {
                if (board[i][j] != player) {
                    rowWin = false;
                    break;
                }
                buttonsToWin[i][j] = currentGame.getButtonGrid()[i][j];
            }
            if (rowWin) {
                for (JButton btn : buttonsToWin[i]) {
                    btn.setBackground(Color.red);
                }

                return true;
            }
        }

        // Check columns
        for (int i = 0; i < BOARD_SIZE; i++) {
            boolean colWin = true;
            for (int j = 0; j < BOARD_SIZE; j++) {
                if (board[j][i] != player) {
                    colWin = false;
                    break;
                }
                buttonsToWin[j][i] = currentGame.getButtonGrid()[j][i];
            }
            if (colWin) {
                for (JButton[] jButtons : buttonsToWin) {
                    jButtons[i].setBackground(Color.red);
                }
                return true;
            }
        }

//        // Check diagonals
//        for (int i = 0; i <= BOARD_SIZE_DIAG - numToWin; i++) {
//            for (int j = 0; j <= BOARD_SIZE_DIAG - numToWin; j++) {
//                int count = 0;
//                int x = i, y = j;
//                while (x < BOARD_SIZE_DIAG && y < BOARD_SIZE_DIAG) {
//                    if (board[x][y] == player) {
//                        count++;
//                        buttonsToWin[x][y] = currentGame.getButtonGrid()[x][y];
//                        if (count == numToWin) {
//                            for (int k = 0; k < numToWin; k++) {
//                                buttonsToWin[x - k][y - k].setBackground(Color.red);
//                            }
//                            return true;
//                        }
//                    } else {
//                        count = 0;
//                    }
//                    x++;
//                    y++;
//                }
//            }
//        }
//
//        // Check reverse diagonals
//        for (int i = 0; i <= BOARD_SIZE_DIAG - numToWin; i++){
//            for (int j = BOARD_SIZE - 1; j >= numToWin - 1; j--) {
//            int count = 0;
//            int x = i, y = j;
//            while (x < BOARD_SIZE_DIAG && y >= 0) {
//                if (board[x][y] == player) {
//                    count++;
//                    buttonsToWin[x][y] = currentGame.getButtonGrid()[x][y];
//                    if (count == numToWin) {
//                        for (int k = 0; k < numToWin; k++) {
//                            buttonsToWin[x - k][y + k].setBackground(Color.red);
//                        }
//                        return true;
//                    }
//                } else {
//                    count = 0;
//                }
//                x++;
//                y--;
//            }
//        }
//    }

        // No win
        return false;
    }

}
