package com.mikhailsobol.tictactoe.model.fields;


import com.mikhailsobol.tictactoe.model.Point;

public class TicTacToeField<T> implements IField<T> {

    private static final int FIELD_SIZE = 3;

    private final T[][] field = (T[][]) new Object[FIELD_SIZE][FIELD_SIZE];

    @Override
    public int getSize() {
        return FIELD_SIZE;
    }

    @Override
    public T getFigure(final Point point) {
        return field[point.getX()][point.getY()];
    }

    @Override
    public void setFigure(final Point point,
                             final T figure) {
        field[point.getX()][point.getY()] = figure;
    }

}
