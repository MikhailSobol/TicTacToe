package com.mikhailsobol.tictactoe.model.games.factrories;


import com.mikhailsobol.tictactoe.controller.Ai.IAi;
import com.mikhailsobol.tictactoe.model.exceptions.UnsupportedGameTypeException;
import com.mikhailsobol.tictactoe.model.games.AbstractTicTacToeGame;

public abstract class AbstractTicTacTieGameFactory {

    public abstract AbstractTicTacToeGame getGame(final String gameName,
                                                  final IAi ai) throws UnsupportedGameTypeException;

}
