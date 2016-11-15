package com.mikhailsobol.tictactoe.model.games;


import com.mikhailsobol.tictactoe.model.Player;
import com.mikhailsobol.tictactoe.model.fields.TicTacToeField;

public class MultiplayerTicTacToeGame<Figure> extends AbstractGame<Figure> {
// TODO: test this class.

    public MultiplayerTicTacToeGame(final Player<Figure>[] players,
                                    final TicTacToeField<Figure> field,
                                    final boolean isSinglePlayer) {
        super(players, field, isSinglePlayer);
    }

    public Player<Figure> getPlayer() {
        return this.players[0];
    }
}
