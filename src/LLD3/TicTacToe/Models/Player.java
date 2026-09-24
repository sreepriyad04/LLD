package LLD3.TicTacToe.Models;

import LLD3.TicTacToe.Exceptions.InvalidMoveException;

import java.awt.*;
import java.util.Scanner;

public abstract class Player {
    private String name;
    private Symbol symbol;
    private PlayerType playerType;

    private static final Scanner scanner = new Scanner(System.in);

    public Player(String name, Symbol symbol, PlayerType playerType) {
        this.name = name;
        this.symbol = symbol;
        this.playerType = playerType;
    }

    public String getName() {
        return name;
    }

    public Symbol getSymbol() {
        return symbol;
    }

    public PlayerType getPlayerType() {
        return playerType;
    }

    public Move makeMove(Board board) {
        //get the row
        int[] cell = getCellFromUser();
        int row = cell[0];
        int col = cell[1];

        if(!validateCell(row, col, board)){
            cell = getCellFromUser();
            row = cell[0];
            col = cell[1];
        }

        return new Move(board.getBoard().get(row).get(col), this);

    }
    public boolean validateCell(int row,int col, Board board) {
        //rows - 0, 1, 2
        //col - 0, 1, 2
        if(row <0 && row >= board.getSize() && col < 0 && col >=  board.getSize() ||
                !board.getBoard().get(row).get(col).isEmpty()) {
            return false;
        }
        return true;
    }

    public int[] getCellFromUser(){
        System.out.println("Enter the row number: ");
        int row = scanner.nextInt();

        //get the col from the user
        System.out.println("Enter the col number: ");
        int col = scanner.nextInt();

        return new int[] {row, col};
    }


}
