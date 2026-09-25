package LLD3.TicTacToe.Strategy.WinningStrategy;

import LLD3.TicTacToe.Models.Board;
import LLD3.TicTacToe.Models.Move;
import LLD3.TicTacToe.Models.Symbol;

import java.util.HashMap;
import java.util.Map;

public class ColWinningStrategy implements WinningStartegy {
    private Map<Integer, Map<Symbol, Integer>> colMaps = new HashMap<>();
    //Map<rowNumber, Map<Symbol, count>>
    @Override
    public boolean checkWinner(Move move, Board board, String isUndo) {
        int col = move.getCell().getCol();
        Symbol symbol = move.getPlayer().getSymbol();
        if(isUndo.equals("y")){
            colMaps.get(col).put(symbol, colMaps.get(col).get(symbol) -1);
            return false;
        }
        if(!colMaps.containsKey(col)){
            colMaps.put(col, new HashMap<>());
        }
        Map<Symbol, Integer> currColMap = colMaps.get(col);
        if(!currColMap.containsKey(symbol)){
            currColMap.put(symbol, 0);
        }
        currColMap.put(symbol, currColMap.get(symbol) + 1);

        return currColMap.get(symbol) == board.getSize();

    }
}
