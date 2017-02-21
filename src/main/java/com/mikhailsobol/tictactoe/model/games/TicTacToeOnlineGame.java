package com.mikhailsobol.tictactoe.model.games;


import com.mikhailsobol.tictactoe.model.Player;
import com.mikhailsobol.tictactoe.model.fields.IField;
import com.mikhailsobol.tictactoe.server.TicTacToeServer;

public class TicTacToeOnlineGame extends MultiplayerTicTacToeGame {

    private final TicTacToeServer server;

    public TicTacToeOnlineGame(final Player[] players, IField field,
                               final boolean isSinglePlayer,
                               final String name,
                               final TicTacToeServer server) {
        super(players, field, isSinglePlayer, name);
        this.server = server;
    }

    public TicTacToeServer getServer() {
        return server;
    }
}
