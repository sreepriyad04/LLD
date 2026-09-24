package LLD3.TicTacToe;

import LLD3.TicTacToe.Controllers.GameController;
import LLD3.TicTacToe.Exceptions.InvalidGameException;
import LLD3.TicTacToe.Exceptions.InvalidMoveException;
import LLD3.TicTacToe.Models.*;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws InvalidGameException {
            int boardSize = 3;
            Player player1 = new HumanPlayer("Priya", new Symbol('X'));
            Player player2 = new BotPlayer("GPT Player", new Symbol('O'),BotDifficultyLevel.MEDIUM);

            List<Player> players = new ArrayList<>();
            players.add(player1);
            players.add(player2);

            GameController gameController = new GameController();
            System.out.println("=======TiCTacToe========");

            Game game = gameController.startGame(boardSize, players);

            while(gameController.getGameState(game) == GameState.IN_PROGRESS){
                //Print the board
                gameController.printBoard(game);

                //Make the move
                gameController.makeMove(game);

                //check winner
            }
    }
}
