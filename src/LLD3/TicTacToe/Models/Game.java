package LLD3.TicTacToe.Models;

import LLD3.TicTacToe.Exceptions.InvalidGameException;
import LLD3.TicTacToe.Strategy.WinningStrategy.ColWinningStrategy;
import LLD3.TicTacToe.Strategy.WinningStrategy.DiagonalWinningStrategy;
import LLD3.TicTacToe.Strategy.WinningStrategy.RowWinningStrategy;
import LLD3.TicTacToe.Strategy.WinningStrategy.WinningStartegy;

import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Game {
    private Board board;
    private List<Player> players;
    private List<Move> moves;
    private Player winner;
    private GameState gameState;
    private int nextPlayerIndex;
    private List<WinningStartegy> winningStartegies;
    private final Scanner scanner = new Scanner(System.in);

    private Game(Builder builder, List<WinningStartegy> winningStartegies) {
        this.board = new Board(builder.boardSize);
        this.players = builder.players;
        this.moves = new ArrayList<>();
        this.winner = null;
        this.gameState = GameState.IN_PROGRESS;
        this.nextPlayerIndex = 0;
        this.winningStartegies = winningStartegies;
    }

    public Board getBoard() {
        return board;
    }

    public void setBoard(Board board) {
        this.board = board;
    }

    public List<Player> getPlayers() {
        return players;
    }

    public void setPlayers(List<Player> players) {
        this.players = players;
    }

    public List<Move> getMoves() {
        return moves;
    }

    public void setMoves(List<Move> moves) {
        this.moves = moves;
    }

    public Player getWinner() {
        return winner;
    }

    public void setWinner(Player winner) {
        this.winner = winner;
    }

    public GameState getGameState() {
        return gameState;
    }

    public void setGameState(GameState gameState) {
        this.gameState = gameState;
    }

    public int getNextPlayerIndex() {
        return nextPlayerIndex;
    }

    public void setNextPlayerIndex(int nextPlayerIndex) {
        this.nextPlayerIndex = nextPlayerIndex;
    }
    public static Builder getGameBuilder(){
        return new Builder();
    }

    public void makeMove(){
        Player currentPlayer = players.get(nextPlayerIndex);

        System.out.println("This is "+ currentPlayer.getName() + "'s move");

        Move move = currentPlayer.makeMove(board);

        //Make the move on the board
        int row = move.getCell().getRow();
        int col = move.getCell().getCol();

        Cell cell = board.getBoard().get(row).get(col);
        if(!cell.isEmpty()){
            System.out.println("Cell is already filled. please try another cell");
            return;
        }
        cell.setCellState(CellState.FILLED);
        cell.setPlayer(currentPlayer);

        System.out.println(currentPlayer.getName() + " has made the move. ");

//        move.setCell(cell);


        //add the move to the moves list
        //Is there any problem here ?
        moves.add(move);

        if(checkWinner(move)){
            gameState = GameState.WON;
            winner = currentPlayer;
        }else if(moves.size() == board.getSize()*board.getSize()){
            gameState = GameState.DRAW;
        }
        this.board.printBoard();
        System.out.println("Do you want to undo your move? y/n");
        String isUndo = scanner.next();

        if(isUndo.equals("y")){
            undo();
        }
        else {
            nextPlayerIndex = (nextPlayerIndex + 1) % players.size();
        }

    }
    public boolean checkWinner(Move move){
        for(WinningStartegy winningStartegy: winningStartegies){
            if(winningStartegy.checkWinner(move, this.board, "n")){
                return true;
            }
        }
        return false;
    }
    public void undo() {
        if (moves.isEmpty()) {
            System.out.println("No moves to undo ");
            return;
        }
        Move lastMove = moves.get(moves.size() - 1);
        Cell cell = lastMove.getCell();
        cell.setCellState(CellState.EMPTY);
        cell.setPlayer(null);
        for(WinningStartegy winningStartegy: winningStartegies){
            winningStartegy.checkWinner(lastMove, this.board, "y");
        }

        System.out.println("The last move is undone. It's now "+ players.get(nextPlayerIndex).getName() + "'s move");
    }
    public static class Builder{
        private int boardSize;
        private List<Player> players;

        public Builder() {
            this.players = new ArrayList<>();
        }

        public int getBoardSize() {
            return boardSize;
        }

        public Builder setBoardSize(int boardSize) {
            this.boardSize = boardSize;
            return this;
        }
        

        public List<Player> getPlayers() {
            return players;
        }

        public Builder setPlayers(List<Player> players) {
            this.players = players;
            return this;
        }
        //Validations before creating the game
        private void validate() throws InvalidGameException {
            //validate player count: should be boardSize- 1
            if(players.size() <= 1 && players.size() > boardSize){
                throw new InvalidGameException("Player count must be greater than 1 and less than "+ boardSize + "for a board size " + boardSize);
            }

            //validate unique Symbols
            //TODO: Implement this later

            //validate at most one bot
            int botCount = 0;
            for(Player player: players){
                if(player.getPlayerType() == PlayerType.BOT){
                    botCount++;
                }
            }
            if(botCount > 1){
                //throw a new exception
            }

        }
        public Game build() throws InvalidGameException {
            //valildations
            validate();
            List<WinningStartegy> winningStartegies1 = new ArrayList<>();
            winningStartegies1.add(new RowWinningStrategy());
            winningStartegies1.add(new ColWinningStrategy());
            winningStartegies1.add(new DiagonalWinningStrategy());
            return new Game(this, winningStartegies1);
        }
    }
}
