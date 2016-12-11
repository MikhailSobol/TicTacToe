package com.mikhailsobol.tictactoe.controller;


import com.mikhailsobol.tictactoe.model.Player;
import com.mikhailsobol.tictactoe.model.Point;
import com.mikhailsobol.tictactoe.model.enums.Figure;
import com.mikhailsobol.tictactoe.model.exceptions.InvalidCoordinateException;
import com.mikhailsobol.tictactoe.model.exceptions.PlayerNotFoundException;
import com.mikhailsobol.tictactoe.model.fields.IField;
import com.mikhailsobol.tictactoe.model.games.AbstractTicTacToeGame;

public class TicTacToeCurrentMoveController {

    public Player getCurrentPlayer(final AbstractTicTacToeGame game) throws PlayerNotFoundException,
            InvalidCoordinateException {
        final Player[] players = game.getPlayers();
        final IField field = game.getField();
        final int occupiedCells = countOccupiedCells(field);
        final Figure currentFigure = getCurrentFigure(occupiedCells);
        return getPlayerByFigure(currentFigure, players);
    }

    public int countOccupiedCells(final IField field) throws InvalidCoordinateException {
        int count = 0;
        for (int i = 0; i < field.getSize(); i++) {
            for (int j = 0; j < field.getSize(); j++) {
                if (field.getFigure(new Point(i , j)) != null) {
                    count++;
                }
            }
        }
        return count;
    }

    private Player getPlayerByFigure(final Figure currentFigure, final Player[] players)
            throws PlayerNotFoundException {
        for (final Player player : players) {
            if (player.getFigure() == currentFigure) {
                return player;
            }
        }
        throw new PlayerNotFoundException();
    }

    private Figure getCurrentFigure(final int countOfOccupied) {
        return countOfOccupied % 2 == 0 ? Figure.X : Figure.O;
    }


}
