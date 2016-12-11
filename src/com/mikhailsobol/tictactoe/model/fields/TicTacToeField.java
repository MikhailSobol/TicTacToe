package com.mikhailsobol.tictactoe.model.fields;


import com.mikhailsobol.tictactoe.model.Point;
import com.mikhailsobol.tictactoe.model.exceptions.InvalidCoordinateException;

public class TicTacToeField<T> implements IField<T> {

    private static final int FIELD_SIZE = 3;

    private final T[][] field = (T[][]) new Object[FIELD_SIZE][FIELD_SIZE];

    @Override
    public int getSize() {
        return FIELD_SIZE;
    }

    @Override
    public T getFigure(final Point point) throws InvalidCoordinateException {
        if (!checkCoordinate(point)) {
            throw new InvalidCoordinateException();
        }
        return field[point.getX()][point.getY()];
    }

    @Override
    public void setFigure(final Point point,
                             final T figure) {
        field[point.getX()][point.getY()] = figure;
    }

    @Override
    public boolean checkCoordinate(final Point point) {
        return point.getX() < FIELD_SIZE && point.getY() >= 0 &&
                point.getY() < FIELD_SIZE && point.getY() >= 0;
    }

    @Override
    public boolean checkIfOccupied(final Point point) throws InvalidCoordinateException {
        if (!checkCoordinate(point)) throw new InvalidCoordinateException();
        return this.getFigure(point) == null;
    }


}
