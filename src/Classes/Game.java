package Classes;

public class Game {

    private Player playerOne;

    private Player playerTwo;

    private int win;

    private int gridNumber;
    private int[][] grid;

    private int gameOptions;

    public  Game(Player p1, Player p2, int win, int gridNumber, int gameOptions){
        this.playerOne = p1;
        this.playerTwo = p2;
        this.win = win;
        this.gridNumber  = gridNumber;
        this.gameOptions = gameOptions;

        //create grid
        this.grid = this.CreateGrid(gridNumber);
    }

    private int[][] CreateGrid(int gridNumber){
        int[][] finalGrid = new int[gridNumber][gridNumber];

        for(int r = 0; r < gridNumber; r++){
            for(int c = 0; c < gridNumber; c++){
                finalGrid[r][c] = -1;
            }
        }

        return finalGrid;
    }

    public int[][] getGrid() {
        return grid;
    }

    public void setGrid(int[][] grid) {
        this.grid = grid;
    }

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

    public int getWin(){
        return win;
    }

    public void setWin(int win) {
        this.win = win;
    }

    public int getGridNumber(){
        return gridNumber;
    }

    public void setGridNumber(int gridNumber) {
        this.gridNumber = gridNumber;
    }

    public int getGameOptions(){
        return gameOptions;
    }

    public void setGameOptions(int gameOptions) {
        this.gameOptions = gameOptions;
    }
}
