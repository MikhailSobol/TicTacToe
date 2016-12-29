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
        System.out.println("setting: " + point.getX() + point.getY());
        if (!field.checkCoordinate(point)) {
            throw new InvalidCoordinateException();
        }
        if (!field.checkIfOccupied(point)) {
            throw new AlreadyOccupiedException();
        }
        field.setFigure(point, figure);
    }

    private void printField(final IField field) throws InvalidCoordinateException {
        for (int i = 0; i < field.getSize(); i++) {
            for (int j = 0; j < field.getSize(); j++) {
                System.out.print(field.getFigure(new Point(i, j)));
            }
            System.out.println();
        }
        System.out.println("~~~~~~~~");
    }
}
