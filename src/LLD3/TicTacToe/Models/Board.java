package LLD3.TicTacToe.Models;

import java.util.ArrayList;
import java.util.List;

public class Board {
    private int size;
    private List<List<Cell>> board;
    /*
        3 * 3 board
             0        1        2
        0 [Cell 0] [Cell 1] [Cell 2] -> List 0
        1 [Cell 3] [Cell 4] [Cell 5] -> List 1
        2 [Cell 6] [Cell 7] [Cell 8] -> List 2

        n = 10 -> 5
     */

    public Board(int size) {
        this.size = size;
        this.board = new ArrayList<>();//[]
        for(int i=0; i<size; i++){
            List<Cell> row = new ArrayList<>(); //[row0 row1 row 2]
            for(int j =0 ; j<size; j++){
                row.add(new Cell(i, j));//[cell3 cell4 cell5]
            }
            board.add(row);//[[cell0 cell1 cell2] [cell3 cell4 cell5]]
        }
    }

    public int getSize() {
        return size;
    }

    public List<List<Cell>> getBoard() {
        return board;
    }

    public void printBoard(){
        for(List<Cell> row: board){
            for(Cell cell : row){
                if(cell.getCellState() == CellState.EMPTY){
                    System.out.print("|   |");
                }else{
                    System.out.print("| "+cell.getPlayer().getSymbol().getCharacter()+ " |");
                }
            }
            System.out.println();
        }
    }

}
