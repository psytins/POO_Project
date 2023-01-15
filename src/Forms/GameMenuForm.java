package Forms;

import Program.Main;

import Classes.Game;
import Classes.Player;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowEvent;
import java.util.Objects;

public class GameMenuForm {
    private JPanel mainPanel;
    private JPanel centerPanel;
    private JPanel topPanel;
    private JPanel bottomPanel;
    private JPanel leftPanel;
    private JPanel rightPanel;
    private JButton startButton;
    private JLabel sizeLabel;
    private JRadioButton randomRadioButton;
    private JRadioButton misereRadioButton;
    private JRadioButton normalRadioButton;
    private JSlider gridSizeSlider;
    private JSlider winSlider;
    private JLabel winNumLabel;
    private JLabel gridSizeLabel;
    private JLabel info;
    private JSlider gameModeSlider;
    private JLabel gameModeLabel;
    private JButton exitButton;

    public JPanel getMainPanel() {
        return mainPanel;
    }

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
                StartGame();
            }
        });

        exitButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                ExitGame();
            }
        });

        gridSizeSlider.addChangeListener(new ChangeListener() {
            //Change label when grid size slider is changed
            @Override
            public void stateChanged(ChangeEvent e) {
                String gridSize = String.valueOf(gridSizeSlider.getValue());
                gridSizeLabel.setText( "Grid Size: " + gridSize + "x" + gridSize);
            }
        });
        winSlider.addChangeListener(new ChangeListener() {
            //Change label when win slider is changed
            @Override
            public void stateChanged(ChangeEvent e) {
                String winNumber = String.valueOf(winSlider.getValue());
                winNumLabel.setText("To Win: " + winNumber);
            }
        });
        gameModeSlider.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                switch (gameModeSlider.getValue()) {
                    case 0 -> gameModeLabel.setText("Gamemode: Normal");
                    case 1 -> gameModeLabel.setText("Gamemode: Misére");
                    case 2 -> gameModeLabel.setText("Gamemode: Random Turn");
                    default -> {
                    }
                }
            }
        });
    }

    //Initialize game components
    public void initialize(){
        //set labels
        gridSizeLabel.setText("Grid Size: " + gridSizeSlider.getValue() + "x" + gridSizeSlider.getValue());
        winNumLabel.setText("To Win: " + String.valueOf(winSlider.getValue()));
        gameModeLabel.setText("Gamemode: Normal");
        //0 -> Normal
        //1 -> Misére
        //2 -> Random Turn

    }
    public void StartGame(){
        if(winSlider.getValue() > gridSizeSlider.getValue())
            JOptionPane.showMessageDialog(mainPanel, "Win parameter can't be higher than grid size.");
        else {
            String playerOneName = JOptionPane.showInputDialog("Player 1, who are you ?");
            if(Objects.equals(playerOneName, "Gonçalo") || Objects.equals(playerOneName, "João") ){JOptionPane.showMessageDialog(mainPanel,"Uh...\nBeautiful name ;)");}

            String playerTwoName = JOptionPane.showInputDialog("Player 2, who are you ?");
            if(Objects.equals(playerTwoName, "Gonçalo")|| Objects.equals(playerTwoName, "João") ){JOptionPane.showMessageDialog(mainPanel,"Uh...\nBeautiful name ;)");}

            if(playerOneName != null && playerTwoName != null && !playerOneName.equals("") && !playerTwoName.equals(""))
            {
                Player playerOne = new Player(playerOneName);
                Player playerTwo = new Player(playerTwoName);

                Game game = new Game(playerOne, playerTwo, winSlider.getValue(), gridSizeSlider.getValue(), gameModeSlider.getValue());

                Main.StartGame(game);
                //Close this form
                Main.gameMenuFrame.dispatchEvent(new WindowEvent(Main.gameMenuFrame, WindowEvent.WINDOW_CLOSING));
            }
            else {
                JOptionPane.showMessageDialog(mainPanel,"Something went wrong!\nPlease try again.");
            }
        }

    }

    public void ExitGame(){
        JOptionPane.showMessageDialog(mainPanel, "Thank you for playing!");
        Main.gameMenuFrame.dispatchEvent(new WindowEvent(Main.gameMenuFrame, WindowEvent.WINDOW_CLOSING));
    }
}