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
        if (!field.checkIfOccupied(point)) {
            throw new AlreadyOccupiedException();
        }
        field.setFigure(point, figure);
    }

}
