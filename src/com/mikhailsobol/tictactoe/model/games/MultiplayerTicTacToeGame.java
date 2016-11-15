package com.mikhailsobol.tictactoe.model.games;


import com.mikhailsobol.tictactoe.controller.Ai.IAi;
import com.mikhailsobol.tictactoe.model.Player;
import com.mikhailsobol.tictactoe.model.enums.DifficultyLevel;
import com.mikhailsobol.tictactoe.model.fields.TicTacToeField;

public class MultiplayerTicTacToeGame<Figure> extends AbstractGame<Figure> {
// TODO: test this class.

    private final IAi ai;

    public MultiplayerTicTacToeGame(final Player<Figure>[] players,
                                    final TicTacToeField<Figure> field,
                                    final IAi ai,
                                    final boolean isSinglePlayer) {
        super(players, field, isSinglePlayer);
        this.ai = ai;
    }

    public Player<Figure>[] getPlayers() {
        return this.players;
    }

    public DifficultyLevel getDifficultyLevel() {
        return ai.getDifficultyLevel();
    }

}
