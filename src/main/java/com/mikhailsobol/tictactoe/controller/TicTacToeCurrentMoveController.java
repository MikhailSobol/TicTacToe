package com.mikhailsobol.tictactoe.controller;


import com.mikhailsobol.tictactoe.model.Player;
import com.mikhailsobol.tictactoe.model.enums.Figure;
import com.mikhailsobol.tictactoe.model.exceptions.InvalidCoordinateException;
import com.mikhailsobol.tictactoe.model.exceptions.PlayerNotFoundException;
import com.mikhailsobol.tictactoe.model.fields.IField;
import com.mikhailsobol.tictactoe.model.games.AbstractTicTacToeGame;
import org.jetbrains.annotations.Contract;

public class TicTacToeCurrentMoveController {

    public Player getCurrentPlayer(final AbstractTicTacToeGame game)
            throws PlayerNotFoundException, InvalidCoordinateException {
        return getPlayerByFigure(getCurrentFigure(countOccupiedCells(game.getField())),
                game.getPlayers());
    }

    int countOccupiedCells(final IField field) throws InvalidCoordinateException {
        int counter = 0;
        for (final Object figure : field) {
            if (figure != null) counter++;
        }
        return counter;
    }

    private Player getPlayerByFigure(final Figure currentFigure,
                                     final Player[] players)
            throws PlayerNotFoundException {
        for (final Player player : players) {
            if (player.getFigure() == currentFigure) {
                return player;
            }
        }
        throw new PlayerNotFoundException();
    }

    @Contract(pure = true)
    private Figure getCurrentFigure(final int countOfOccupied) {
        return countOfOccupied % 2 == 0 ? Figure.X : Figure.O;
    }


}
