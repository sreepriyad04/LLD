package LLD3.TicTacToe.Strategy.WinningStrategy;

import LLD3.TicTacToe.Models.Board;
import LLD3.TicTacToe.Models.Move;

public interface WinningStartegy {
    boolean checkWinner(Move move, Board board, String isUndo);
}
