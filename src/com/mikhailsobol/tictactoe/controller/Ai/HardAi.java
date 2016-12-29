package com.mikhailsobol.tictactoe.controller.Ai;


import com.mikhailsobol.tictactoe.controller.TicTacToeCurrentMoveController;
import com.mikhailsobol.tictactoe.controller.TicTacToeWinnerController;
import com.mikhailsobol.tictactoe.model.Point;
import com.mikhailsobol.tictactoe.model.enums.AiDifficultyLevel;
import com.mikhailsobol.tictactoe.model.enums.Figure;
import com.mikhailsobol.tictactoe.model.exceptions.AlreadyOccupiedException;
import com.mikhailsobol.tictactoe.model.exceptions.InvalidCoordinateException;
import com.mikhailsobol.tictactoe.model.exceptions.PlayerNotFoundException;
import com.mikhailsobol.tictactoe.model.fields.IField;

public class HardAi implements IAi {

    @Override
    public Point move(final IField field) throws InvalidCoordinateException,
            AlreadyOccupiedException, PlayerNotFoundException {
        return getPoint(field);
    }

    @Override
    public AiDifficultyLevel getDifficultyLevel() {
        return AiDifficultyLevel.HARD;
    }

    private Point getPoint(final IField field)
                           throws InvalidCoordinateException,
                                    AlreadyOccupiedException, PlayerNotFoundException {
        Point point = checkForOpportunityToWin(field, Figure.O);
        if (point != null) return point;
        point = blockOpponentWinning(field, Figure.X);
        if (point != null) return point;
        return new EasyAi().move(field);
    }

    private Point blockOpponentWinning(final IField field,
                                       final Figure figure) throws InvalidCoordinateException, PlayerNotFoundException {
        return checkForOpportunityToWin(field, figure);
    }

    private Point checkForOpportunityToWin(final IField field,
                                           final Figure figure) throws InvalidCoordinateException, PlayerNotFoundException {
        if (checkVertical(field, figure) != null) return checkVertical(field, figure);
        if (checkHorizontal(field, figure) != null) return checkHorizontal(field, figure);
        if (checkDiagLeftToRight(field, figure) != null) return checkDiagLeftToRight(field, figure);
        return checkDiagRightToLeft(field, figure);
    }

    private Point countFigureAndGetPoint(final IField field,
                                         final Figure figure,
                                         Point startingPoint,
                                         final TicTacToeWinnerController.IPointGenerator pointGenerator)
            throws InvalidCoordinateException {
        int figureCounter = 0;
        Point nullPoint = null;
        do {
            if (field.getFigure(startingPoint) != null && !figure.equals(field.getFigure(startingPoint))) return null;
            if (field.getFigure(startingPoint) == null) nullPoint = startingPoint;
            if (figure.equals(field.getFigure(startingPoint))) figureCounter++;
            startingPoint = pointGenerator.getNextPoint(startingPoint);
        } while (field.checkCoordinate(startingPoint));
        return figureCounter == 2 ? nullPoint : null;
    }

    private Point checkVertical(final IField field,
                                final Figure figure) throws InvalidCoordinateException {
        for (int i = 0; i < field.getSize(); i++) {
            final Point point = countFigureAndGetPoint(field, figure,
                    new Point(i, 0), point1 -> new Point(point1.getX(), point1.getY() + 1));
            if (point != null) {
                return point;
            }
        }
        return null;
    }

    private Point checkHorizontal(final IField field,
                                  final Figure figure) throws InvalidCoordinateException {
        for (int i = 0; i < field.getSize(); i++) {
            final Point point = countFigureAndGetPoint(field, figure,
                    new Point(0, i), point1 -> new Point(point1.getX() + 1, point1.getY()));
            if (point != null) {
                return point;
            }
        }
        return null;
    }

    private Point checkDiagLeftToRight(final IField field,
                                       final Figure figure) throws InvalidCoordinateException {
        final Point point = countFigureAndGetPoint(field, figure,
                new Point(0, 0), point1 -> new Point(point1.getX() + 1, point1.getY() + 1));
        if (point != null) {
            return point;
        }
        return null;
    }

    private Point checkDiagRightToLeft(final IField field,
                                       final Figure figure) throws InvalidCoordinateException {
        final Point point = countFigureAndGetPoint(field, figure,
                new Point(0, 2), point1 -> new Point(point1.getX() + 1, point1.getY() - 1));
        if (point != null) {
            return point;
        }
        return null;
    }

}
