package LLD3.TicTacToe.Factory;

import LLD3.TicTacToe.Models.BotDifficultyLevel;
import LLD3.TicTacToe.Strategy.BotPlayingStrategy.BotStrategy;
import LLD3.TicTacToe.Strategy.BotPlayingStrategy.EasyBotStrategy;
import LLD3.TicTacToe.Strategy.BotPlayingStrategy.HardBotStrategy;
import LLD3.TicTacToe.Strategy.BotPlayingStrategy.MediumBotStrategy;

public class BotPlayingStrategyFactory {
    public static BotStrategy getBotPlayingStretegy(BotDifficultyLevel level){
        return switch(level){
            case EASY -> new EasyBotStrategy();
            case MEDIUM -> new MediumBotStrategy();
            case HARD -> new HardBotStrategy();
        };
    }
}
