package LLD3.TicTacToe.Models;

public class Move {
    private Player player;
    private Cell cell;

    public Move(Cell cell,Player player) {
        this.player = player;
        this.cell = cell;
    }

    public Player getPlayer() {
        return player;
    }

    public Cell getCell() {
        return cell;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public void setCell(Cell cell) {
        this.cell = cell;
    }
}
