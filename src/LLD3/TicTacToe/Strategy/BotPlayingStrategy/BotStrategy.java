package LLD3.TicTacToe.Strategy.BotPlayingStrategy;

import LLD3.TicTacToe.Models.Board;
import LLD3.TicTacToe.Models.Move;
import LLD3.TicTacToe.Models.Player;

public interface BotStrategy {
    public Move makeBotMove(Board board, Player player);
}
