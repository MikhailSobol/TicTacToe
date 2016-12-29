package com.mikhailsobol.tictactoe.model.fields;


import com.mikhailsobol.tictactoe.model.Point;
import com.mikhailsobol.tictactoe.model.enums.Figure;
import com.mikhailsobol.tictactoe.model.exceptions.AlreadyOccupiedException;
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
    public synchronized void setFigure(final Point point,
                          final T figure) throws InvalidCoordinateException,
            AlreadyOccupiedException {
        if (!checkIfOccupied(point)) throw new AlreadyOccupiedException();
        field[point.getX()][point.getY()] = figure;
    }

    @Override
    public boolean checkCoordinate(final Point point) {
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

    @Override
    public boolean hasEmptyCell() {
        for (final T figure : this) if (figure == null) return false;
        return true;
    }

    private ArrayList<T> getFieldAsList() {
        final ArrayList<T> list = new ArrayList<>(FIELD_SIZE * FIELD_SIZE);
        for (int i = 0; i < FIELD_SIZE; i++) {
            list.addAll(Arrays.asList(field[i]).subList(0, FIELD_SIZE));
        }
        return list;
    }

}
