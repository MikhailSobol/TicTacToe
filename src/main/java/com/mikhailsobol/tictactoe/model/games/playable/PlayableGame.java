package com.mikhailsobol.tictactoe.model.games.playable;


import com.mikhailsobol.tictactoe.model.games.AbstractTicTacToeGame;

public class PlayableGame implements IPlayableGame {

    private static AbstractTicTacToeGame game;

    public PlayableGame(final AbstractTicTacToeGame game) {
        PlayableGame.game = game;
    }

    public static void setGame(final AbstractTicTacToeGame game) {
        PlayableGame.game = game;
    }

    public static AbstractTicTacToeGame getGame() {
        return game;
    }
}
