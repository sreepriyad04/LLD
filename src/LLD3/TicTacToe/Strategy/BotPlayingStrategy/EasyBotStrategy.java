package LLD3.TicTacToe.Strategy.BotPlayingStrategy;

import LLD3.TicTacToe.Models.*;

public class EasyBotStrategy implements BotStrategy {
    @Override
    public Move makeBotMove(Board board, Player player) {
        for(int i =0; i<board.getSize();i++){
            for (int j = 0; j < board.getSize(); j++) {
                Cell cell = board.getBoard().get(i).get(j);
                if(cell.getCellState() == CellState.EMPTY){
                    return new Move(cell, player);
                }
            }
        }
        return null;
    }
}
