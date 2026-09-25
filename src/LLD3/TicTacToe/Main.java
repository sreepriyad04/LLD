package LLD3.TicTacToe;

import LLD3.TicTacToe.Controllers.GameController;
import LLD3.TicTacToe.Exceptions.InvalidGameException;
import LLD3.TicTacToe.Exceptions.InvalidMoveException;
import LLD3.TicTacToe.Models.*;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws InvalidGameException {
        Scanner scanner = new Scanner(System.in);
//            int boardSize = 3;
//            Player player1 = new HumanPlayer("Priya", new Symbol('X'));
//            Player player2 = new BotPlayer("GPT Player", new Symbol('O'),BotDifficultyLevel.MEDIUM);
//
//            List<Player> players = new ArrayList<>();
//            players.add(player1);
//            players.add(player2);

            GameController gameController = new GameController();
            System.out.println("=======TiCTacToe========");
            System.out.println("Enter the dimension of the board");
            int boardSize = scanner.nextInt();

            System.out.println("Do you want to have a bot ? y/n");
            String isBot = scanner.next();

            List<Player> players = new ArrayList<>();

            int noOfHumanPlayers = boardSize -1;

            if(isBot.equals("y")){
                noOfHumanPlayers = boardSize-2;
            }
            for(int i =0; i<noOfHumanPlayers; i++){
                System.out.println("Enter the name of the player "+(i+1));
                String playerName = scanner.next();

                System.out.println("Enter the Symbol for the player"+(i+1));
                String playerSymbol = scanner.next();

                players.add(new HumanPlayer(playerName, new Symbol(playerSymbol.charAt(0))));
            }
            if(isBot.equals("y")){
                System.out.println("Enter the name of the bot ");
                String playerName = scanner.next();

                System.out.println("Enter the Symbol for the bot");
                String playerSymbol = scanner.next();

                players.add(new BotPlayer(playerName, new Symbol(playerSymbol.charAt(0)), BotDifficultyLevel.EASY));
            }



            Game game = gameController.startGame(boardSize, players);

            while(gameController.getGameState(game) == GameState.IN_PROGRESS){
                //Print the board
                gameController.printBoard(game);

                //Make the move
                gameController.makeMove(game);
            }
            if(gameController.getGameState(game) == GameState.WON){
                gameController.printBoard(game);
                System.out.println("The winner is: "+ gameController.getWinner(game).getName() + " has won the game. Congratulations");
            }
            else if(gameController.getGameState(game) == GameState.DRAW){
                System.out.println("It's a draw. Nobody won the game");
            }
    }
}
