package LLD3.TicTacToe.Controllers;

import LLD3.TicTacToe.Exceptions.InvalidGameException;
import LLD3.TicTacToe.Exceptions.InvalidMoveException;
import LLD3.TicTacToe.Models.Game;
import LLD3.TicTacToe.Models.GameState;
import LLD3.TicTacToe.Models.Player;

import java.util.List;

public class GameController {

    public Game startGame(int dimension, List<Player> players) throws InvalidGameException {
        return Game.getGameBuilder().setBoardSize(dimension).setPlayers(players).build();
    }
    public void makeMove(Game game) {
        game.makeMove();
    }
    public GameState getGameState(Game game){
        return game.getGameState();
    }
    public Player getWinner(){
        return null;
    }
    public void printBoard(Game game){
        game.getBoard().printBoard();
    }

    //startGame
    //makeMove
    //getGameState
    //getWinner
    //printBoard

}
