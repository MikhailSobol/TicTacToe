package com.mikhailsobol.tictactoe.model.games.factrories;


import com.mikhailsobol.tictactoe.controller.Ai.IAi;
import com.mikhailsobol.tictactoe.model.Player;
import com.mikhailsobol.tictactoe.model.enums.Figure;
import com.mikhailsobol.tictactoe.model.exceptions.UnsupportedGameTypeException;
import com.mikhailsobol.tictactoe.model.fields.IField;
import com.mikhailsobol.tictactoe.model.fields.TicTacToeField;
import com.mikhailsobol.tictactoe.model.games.AbstractTicTacToeGame;
import com.mikhailsobol.tictactoe.model.games.MultiplayerTicTacToeGame;
import com.mikhailsobol.tictactoe.model.games.SingleplayerTicTacToeGame;
import com.mikhailsobol.tictactoe.model.games.TicTacToeOnlineGame;
import com.mikhailsobol.tictactoe.server.TicTacToeServer;

public class TicTacToeGameFactory extends AbstractTicTacTieGameFactory {

    private static final String SINGLEPLAYER_NAME = "SINGLEPLAYER";

    private static final String MULTIPLAYER_NAME = "MULTIPLAYER";

    private static final String ONLINE_NAME = "ONLINE";

    @Override
    public AbstractTicTacToeGame getGame(final String gameName,
                                         final IAi ai) throws UnsupportedGameTypeException {
        switch (gameName) {
            case SINGLEPLAYER_NAME:
                return getSingleplayerGame(ai);
            case MULTIPLAYER_NAME:
                return getMultiplayerGame();
            case ONLINE_NAME:
                return getOnlineGame();
        }
        throw new UnsupportedGameTypeException();
    }

    private static AbstractTicTacToeGame getSingleplayerGame(final IAi ai) {
        final Player[] players = {new Player("Player1", Figure.X), new Player("Player2", Figure.O)};
        final IField field = new TicTacToeField();
        final boolean isSingle = true;
        final String name = "Tic Tac Toe";
        return new SingleplayerTicTacToeGame(players,
                (TicTacToeField) field, ai, isSingle, name);
    }

    private static AbstractTicTacToeGame getMultiplayerGame() {
        final Player[] players = {new Player("Player1", Figure.X), new Player("Player2", Figure.O)};
        final IField field = new TicTacToeField();
        final boolean isSingle = false;
        final String name = "Tic Tac Toe";
        return new MultiplayerTicTacToeGame(players, field, isSingle, name);
    }

    private static AbstractTicTacToeGame getOnlineGame() {
        final Player[] players = {new Player("Player1", Figure.X), new Player("Player2", Figure.O)};
        final IField field = new TicTacToeField();
        final boolean isSingle = false;
        final String name = "Tic Tac Toe";
        final TicTacToeServer server = new TicTacToeServer();
        return new TicTacToeOnlineGame(players, field, isSingle, name, server);
    }
}
