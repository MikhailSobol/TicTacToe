package com.mikhailsobol.tictactoe.controller;


import com.mikhailsobol.tictactoe.model.Point;
import com.mikhailsobol.tictactoe.model.enums.Figure;
import com.mikhailsobol.tictactoe.model.exceptions.AlreadyOccupiedException;
import com.mikhailsobol.tictactoe.model.exceptions.InvalidCoordinateException;
import com.mikhailsobol.tictactoe.model.fields.IField;

public class TicTacToeMoveController {

    public void applyFigure(final IField<Figure> field,
                            final Figure figure,
                            final Point point) throws InvalidCoordinateException,
                                                        AlreadyOccupiedException {
        if (!field.checkCoordinate(point)) {
            throw new InvalidCoordinateException();
        }
        if (!checkIfOccupied(point, field)) {
            throw new AlreadyOccupiedException();
        }
        field.setFigure(point, figure);
    }

    private boolean checkIfOccupied(final Point point,
                                    final IField field) throws InvalidCoordinateException {
        return field.getFigure(point) == null;
    }

    private boolean checkCoordinateX(final int x,
                                     final int maxXSize,
                                     final int minXSize) {
        return x >= minXSize && x < maxXSize;
    }

    private boolean checkCoordinateY(final int y,
                                     final int maxYSize,
                                     final int minYSize) {
        return y >= minYSize && y < maxYSize;
    }

}
