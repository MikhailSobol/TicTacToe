package com.mikhailsobol.tictactoe.model.fields;


import com.mikhailsobol.tictactoe.model.Point;
import com.mikhailsobol.tictactoe.model.exceptions.AlreadyOccupiedException;
import com.mikhailsobol.tictactoe.model.exceptions.InvalidCoordinateException;

public interface IField<T> extends Iterable<T> {

    int getSize();

    T getFigure(final Point point) throws InvalidCoordinateException;

    void setFigure(final Point point,
                   final T figure) throws InvalidCoordinateException, AlreadyOccupiedException;

    boolean checkCoordinate(final Point point);

    boolean checkIfOccupied(final Point point) throws InvalidCoordinateException;

}
