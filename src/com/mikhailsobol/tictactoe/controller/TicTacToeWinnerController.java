package com.mikhailsobol.tictactoe.controller;


import com.mikhailsobol.tictactoe.model.Player;
import com.mikhailsobol.tictactoe.model.Point;
import com.mikhailsobol.tictactoe.model.enums.Figure;
import com.mikhailsobol.tictactoe.model.fields.IField;
import com.mikhailsobol.tictactoe.model.games.AbstractTicTacToeGame;

public class TicTacToeWinnerController {
// TODO: test this class.

    public Player getWinner(final AbstractTicTacToeGame game) {
        final IField field = game.getField();
        final Player[] players = game.getPlayers();
        for (int i = 0; i < field.getSize(); i++) {
            if (field.getFigure(new Point(0, i)) == field.getFigure(new Point(1, i)) &&
                    field.getFigure(new Point(0, i)) == field.getFigure(new Point(2, i))) {
                return getPlayerByFigure((Figure) field.getFigure(new Point(0, i)), players);
            }
        }
        for (int i = 0; i < field.getSize(); i++) {
            if (field.getFigure(new Point(i, 0)) == field.getFigure(new Point(i, 1)) &&
                    field.getFigure(new Point(i, 0)) == field.getFigure(new Point(i, 2))) {
                return getPlayerByFigure((Figure) field.getFigure(new Point(i, 0)), players);
            }
        }
        if (field.getFigure(new Point(0, 0)) == field.getFigure(new Point(1, 1)) &&
                field.getFigure(new Point(0, 0)) == field.getFigure(new Point(2, 2))) {
            return getPlayerByFigure((Figure) field.getFigure(new Point(0, 0)), players);
        }
        if (field.getFigure(new Point(0, 2)) == field.getFigure(new Point(1, 1)) &&
                field.getFigure(new Point(1, 1)) == field.getFigure(new Point(2, 0))) {
            return getPlayerByFigure((Figure) field.getFigure(new Point(0, 2)), players);
        }
        return null;
    }

    private Player getPlayerByFigure(final Figure figure,
                                     final Player[] players) {
        for (final Player player : players) {
            if (player.getFigure() == figure) {
                return player;
            }
        }
        return null;
    }

}
