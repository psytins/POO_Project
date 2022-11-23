package Classes;

public class Game {

    private Player playerOne;

    private Player playerTwo;

    private int scorePlayerOne;

    private int scorePlayerTwo;

    private int win;

    private int grid;

    private int gameOptions;

    public Player getPlayerOne() {
        return playerOne;
    }

    public void setPlayerOne(Player playerOne) {
        this.playerOne = playerOne;
    }

    public Player getPlayerTwo() {
        return playerTwo;
    }

    public void setPlayerTwo(Player playerTwo) {
        this.playerTwo = playerTwo;
    }


    public int getScorePlayerOne(){
        return scorePlayerOne;
    }

    public void setScorePlayerOne(int scorePlayerOne) {
        this.scorePlayerOne = scorePlayerOne;
    }

    public int getScorePlayerTwo(){
        return scorePlayerTwo;
    }

    public void setScorePlayerTwo(int scorePlayerTwo) {
        this.scorePlayerTwo = scorePlayerTwo;
    }

    public int getWin(){
        return win;
    }

    public void setWin(int win) {
        this.win = win;
    }

    public int getGrid(){
        return grid;
    }

    public void setGrid(int grid) {
        this.grid = grid;
    }

    public int getGameOptions(){
        return gameOptions;
    }

    public void setGameOptions(int gameOptions) {
        this.gameOptions = gameOptions;
    }
}
