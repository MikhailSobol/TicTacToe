package com.mikhailsobol.tictactoe.view.uihelpers;

import com.mikhailsobol.tictactoe.model.games.factrories.TicTacToeGameFactory;

public class FactoryContainer {

    private static final TicTacToeGameFactory FACTORY = new TicTacToeGameFactory();

    public static TicTacToeGameFactory getFactory() {
        return FACTORY;
    }
}
