package com.mikhailsobol.tictactoe.controller;


import com.mikhailsobol.tictactoe.model.Player;
import com.mikhailsobol.tictactoe.model.Point;
import com.mikhailsobol.tictactoe.model.enums.Figure;
import com.mikhailsobol.tictactoe.model.exceptions.InvalidCoordinateException;
import com.mikhailsobol.tictactoe.model.fields.IField;
import com.mikhailsobol.tictactoe.model.games.AbstractTicTacToeGame;
import org.jetbrains.annotations.Nullable;

public class TicTacToeWinnerController {

    private static final Player DRAW_MARKER = new Player("DRAW", null);

    public Player getWinner(final AbstractTicTacToeGame game) throws InvalidCoordinateException {
        final IField field = game.getField();
        if (new TicTacToeCurrentMoveController().countOccupiedCells(field) == 9) return DRAW_MARKER;
        final Player[] players = game.getPlayers();
        for (int i = 0; i < field.getSize(); i++) {
            if (check(field, new Point(i, 0), p -> new Point(p.getX(), p.getY() + 1))) {
                return getPlayerByFigure((Figure) field.getFigure(new Point(i, 0)), players);
            }
        }
        for (int i = 0; i < field.getSize(); i++) {
            if (check(field, new Point(0, i), p -> new Point(p.getX() + 1, p.getY()))) {
                return getPlayerByFigure((Figure) field.getFigure(new Point(0, i)), players);
            }
        }
        if (check(field, new Point(0, 0), p -> new Point(p.getX() + 1, p.getY() + 1))) {
            return getPlayerByFigure((Figure) field.getFigure(new Point(0, 0)), players);
        }
        if (check(field, new Point(0, 2), p -> new Point(p.getX() + 1, p.getY() - 1))) {
            return getPlayerByFigure((Figure) field.getFigure(new Point(0, 2)), players);
        }

        return null;
    }

    private boolean check(final IField field,
                          final Point currentPoint,
                          final IPointGenerator pointGenerator) {
        final Figure currentFigure;
        final Figure nextFigure;
        final Point nextPoint = pointGenerator.getNextPoint(currentPoint);
        try {
            currentFigure = (Figure) field.getFigure(currentPoint);

            if (currentFigure == null)
                return false;

            nextFigure = (Figure) field.getFigure(nextPoint);
        } catch (final InvalidCoordinateException e) {
            return true;
        }

        return currentFigure == nextFigure && check(field, nextPoint, pointGenerator);

    }

    @Nullable
    private Player getPlayerByFigure(final Figure figure,
                                     final Player[] players) {
        for (final Player player : players) {
            if (player.getFigure() == figure) {
                return player;
            }
        }
        return null;
    }

    public interface IPointGenerator {

        Point getNextPoint(final Point point);

    }


}
