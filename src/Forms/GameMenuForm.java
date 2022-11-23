package Forms;

import Classes.Game;
import Classes.Player;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class GameMenuForm {
    private JPanel mainPanel;
    private JPanel centerPanel;
    private JPanel topPanel;
    private JPanel bottomPanel;
    private JPanel leftPanel;
    private JPanel rightPanel;
    private JButton startButton;
    private JLabel sizeLabel;
    private JLabel modeLabel;
    private JLabel gridLabel;
    private JLabel winLabel;
    private JRadioButton randomRadioButton;
    private JRadioButton misereRadioButton;
    private JRadioButton normalRadioButton;
    private JSlider gridSizeSlider;
    private JSlider winSlider;
    private JPanel gameModePanel;
    private JLabel winNumLabel;
    private JLabel gridSizeLabel;

    public GameMenuForm() {
        initialize();
        main();

    }

    public void main(){


        //Listeners
        startButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                //Start Game
                StarGame();
            }
        });
        gridSizeSlider.addChangeListener(new ChangeListener() {
            //Change label when grid size slider is changed
            @Override
            public void stateChanged(ChangeEvent e) {
                String gridSize = String.valueOf(gridSizeSlider.getValue());
                gridSizeLabel.setText( gridSize + "x" + gridSize);
            }
        });
        winSlider.addChangeListener(new ChangeListener() {
            //Change label when win slider is changed
            @Override
            public void stateChanged(ChangeEvent e) {
                String winNumber = String.valueOf(winSlider.getValue());
                winNumLabel.setText(winNumber);
            }
        });
    }

    public void initialize(){
        //set labels
        gridSizeLabel.setText(String.valueOf(gridSizeSlider.getValue()) + "x" + String.valueOf(gridSizeSlider.getValue()));
        winNumLabel.setText(String.valueOf(winSlider.getValue()));

    }

    public void StarGame(){
        String playerOneName = JOptionPane.showInputDialog("Player 1, who are you ?");
        String playerTwoName = JOptionPane.showInputDialog("Player 2, who are you ?");

        Player playerOne = new Player(playerOneName);
        Player playerTwo = new Player(playerTwoName);

        Game game = new Game(playerOne, playerTwo, winSlider.getValue(), gridSizeSlider.getValue(), 0);

        //Open Game Form
        JFrame gameFrame = new JFrame("TicTacToe - Game");
        gameFrame.setContentPane(new GameForm(game).getMainPanel());
        gameFrame.setSize(800,800);
        gameFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        gameFrame.setVisible(true);
        gameFrame.setResizable(false);
    }

    public JPanel getMainPanel() {
        return mainPanel;
    }
}
