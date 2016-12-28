package com.mikhailsobol.tictactoe.model.fields;


import com.mikhailsobol.tictactoe.model.Point;
import com.mikhailsobol.tictactoe.model.enums.Figure;
import com.mikhailsobol.tictactoe.model.exceptions.InvalidCoordinateException;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;

public class TicTacToeField<T> implements IField<T>, Iterable<T> {

    private static final int FIELD_SIZE = 3;

    private final T[][] field = (T[][]) new Object[FIELD_SIZE][FIELD_SIZE];

    @Override
    public int getSize() {
        return FIELD_SIZE;
    }

    @Override
    public synchronized T getFigure(final Point point) throws InvalidCoordinateException {
        if (!checkCoordinate(point)) {
            throw new InvalidCoordinateException();
        }
        return field[point.getX()][point.getY()];
    }

    @Override
    public boolean isEmpty(final Point point) throws InvalidCoordinateException {
        return getFigure(point) == null;
    }

    @Override
    public void setFigure(final Point point,
                          final T figure) {
        field[point.getX()][point.getY()] = figure;
    }

    @Override
    public synchronized boolean checkCoordinate(final Point point) {
        return point.getX() < FIELD_SIZE && point.getY() >= 0 &&
                point.getY() < FIELD_SIZE && point.getY() >= 0;
    }

    @Override
    public synchronized boolean checkIfOccupied(final Point point) throws InvalidCoordinateException {
        if (!checkCoordinate(point)) throw new InvalidCoordinateException();
        return this.getFigure(point) == null;
    }

    @Override
    public Iterator<T> iterator() {
        final ArrayList<T> fieldList = getFieldAsList();
        return fieldList.iterator();
    }

    private ArrayList<T> getFieldAsList() {
        final ArrayList<T> list = new ArrayList<>(FIELD_SIZE * FIELD_SIZE);
        for (int i = 0; i < FIELD_SIZE; i++) {
            list.addAll(Arrays.asList(field[i]).subList(0, FIELD_SIZE));
        }
        return list;
    }

}
