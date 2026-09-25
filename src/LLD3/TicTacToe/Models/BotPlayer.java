package LLD3.TicTacToe.Models;

import LLD3.TicTacToe.Factory.BotPlayingStrategyFactory;
import LLD3.TicTacToe.Strategy.BotPlayingStrategy.BotStrategy;

public class BotPlayer extends Player{
    private BotDifficultyLevel botDifficultyLevel;
    private BotStrategy botStrategy;

    public BotPlayer(String name, Symbol symbol, BotDifficultyLevel botDifficultyLevel) {
        super(name, symbol, PlayerType.BOT);
        this.botDifficultyLevel = botDifficultyLevel;
        this.botStrategy = BotPlayingStrategyFactory.getBotPlayingStretegy(botDifficultyLevel);
    }

    public BotDifficultyLevel getBotDifficultyLevel() {
        return botDifficultyLevel;
    }

    public void setBotDifficultyLevel(BotDifficultyLevel botDifficultyLevel) {
        this.botDifficultyLevel = botDifficultyLevel;
    }

    @Override
    public Move makeMove(Board board) {
        return botStrategy.makeBotMove(board, this);
    }
}

