package LLD3.TicTacToe.Strategy.WinningStrategy;

import LLD3.TicTacToe.Models.Board;
import LLD3.TicTacToe.Models.Move;
import LLD3.TicTacToe.Models.Symbol;

import java.util.HashMap;
import java.util.Map;

public class DiagonalWinningStrategy implements WinningStartegy{
    private Map<Symbol, Integer> leftDiagnol = new HashMap<>();
    private Map<Symbol, Integer> rightDiagnol = new HashMap<>();
    @Override
    public boolean checkWinner(Move move, Board board, String isUndo) {
        int row = move.getCell().getRow();
        int col = move.getCell().getCol();
        Symbol symbol = move.getPlayer().getSymbol();

        if(row == col){
            if(isUndo.equals("y")){
                leftDiagnol.put(symbol, leftDiagnol.get(symbol) -1);
                return false;
            }
            if(!leftDiagnol.containsKey(symbol)){
                leftDiagnol.put(symbol, 0);
            }
            leftDiagnol.put(symbol, leftDiagnol.get(symbol)+1);
            if(leftDiagnol.get(symbol) == board.getSize()){
                return true;
            } //false
        }
        if(row + col == board.getSize()-1){
            if(isUndo.equals("y")){
                rightDiagnol.put(symbol, rightDiagnol.get(symbol) -1);
                return false;
            }
            if(!rightDiagnol.containsKey(symbol)){
                rightDiagnol.put(symbol, 0);
            }
            rightDiagnol.put(symbol, rightDiagnol.get(symbol)+1);
            if(rightDiagnol.get(symbol) == board.getSize()){
                return true;
            }
        }
        return false;
    }
}
