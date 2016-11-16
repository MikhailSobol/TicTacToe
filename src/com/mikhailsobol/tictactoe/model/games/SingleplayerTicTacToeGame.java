package com.mikhailsobol.tictactoe.model.games;


import com.mikhailsobol.tictactoe.controller.Ai.IAi;
import com.mikhailsobol.tictactoe.model.Player;
import com.mikhailsobol.tictactoe.model.enums.DifficultyLevel;
import com.mikhailsobol.tictactoe.model.fields.TicTacToeField;

public class SingleplayerTicTacToeGame<Figure> extends AbstractTicTacToeGame<Figure> {
// TODO: test this class.

    private final IAi ai;

    public SingleplayerTicTacToeGame(final Player<Figure>[] players,
                                     final TicTacToeField<Figure> field,
                                     final IAi ai,
                                     final boolean isSinglePlayer,
                                     final String name) {
        super(players, field, isSinglePlayer, name);
        this.ai = ai;
    }

    public DifficultyLevel getDifficultyLevel() {
        return ai.getDifficultyLevel();
    }

}
