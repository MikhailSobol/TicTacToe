package com.mikhailsobol.tictactoe.model.games;


import com.mikhailsobol.tictactoe.model.Player;
import com.mikhailsobol.tictactoe.model.fields.TicTacToeField;

public class MultiplayerTicTacToeGame<Figure> extends AbstractTicTacToeGame<Figure> {

    public MultiplayerTicTacToeGame(final Player<Figure>[] players,
                                    final TicTacToeField<Figure> field,
                                    final boolean isSinglePlayer,
                                    final String name) {
        super(players, field, isSinglePlayer, name);
    }
}
