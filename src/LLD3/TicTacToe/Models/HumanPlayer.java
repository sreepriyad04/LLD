package LLD3.TicTacToe.Models;

public class HumanPlayer extends Player{
    public HumanPlayer(String name, Symbol symbol) {
        super(name, symbol, PlayerType.HUMAN);
    }
}
