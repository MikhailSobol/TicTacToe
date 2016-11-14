package com.mikhailsobol.tictactoe.model.fields;


import com.mikhailsobol.tictactoe.model.Point;

public interface IField<T> {

    int getSize();

    T getFigure(final Point point);

    void setFigure(final Point point,
                      final T figure);

}
