package LLD3.TicTacToe.Strategy.WinningStrategy;

import LLD3.TicTacToe.Models.Board;
import LLD3.TicTacToe.Models.Move;
import LLD3.TicTacToe.Models.Symbol;

import java.util.HashMap;
import java.util.Map;

public class RowWinningStrategy implements WinningStartegy{
    private Map<Integer, Map<Symbol, Integer>> rowMaps = new HashMap<>();
    //Map<rowNumber, Map<Symbol, count>>
    @Override
    public boolean checkWinner(Move move, Board board, String isUndo) {
        int row = move.getCell().getRow();
        Symbol symbol = move.getPlayer().getSymbol();
        if(isUndo.equals("y")){
            rowMaps.get(row).put(symbol, rowMaps.get(row).get(symbol) -1);
            return false;
        }
        else {
            if (!rowMaps.containsKey(row)) {
                rowMaps.put(row, new HashMap<>());
            }
            Map<Symbol, Integer> currRowMap = rowMaps.get(row);
            if (!currRowMap.containsKey(symbol)) {
                currRowMap.put(symbol, 0);
            }
            currRowMap.put(symbol, currRowMap.get(symbol) + 1);

            return currRowMap.get(symbol) == board.getSize();
        }
    }
}
