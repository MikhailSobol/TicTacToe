package com.mikhailsobol.tictactoe.model.fields;


import com.mikhailsobol.tictactoe.model.Point;
import com.mikhailsobol.tictactoe.model.exceptions.InvalidCoordinateException;

public interface IField<T> {

    int getSize();

    T getFigure(final Point point) throws InvalidCoordinateException;

    void setFigure(final Point point,
                      final T figure);

    boolean checkCoordinate(final Point point);

}
