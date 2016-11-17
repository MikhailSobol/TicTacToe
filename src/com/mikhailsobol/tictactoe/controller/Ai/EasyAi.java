package com.mikhailsobol.tictactoe.controller.Ai;


import com.mikhailsobol.tictactoe.controller.TicTacToeMoveController;
import com.mikhailsobol.tictactoe.model.Point;
import com.mikhailsobol.tictactoe.model.enums.DifficultyLevel;
import com.mikhailsobol.tictactoe.model.enums.Figure;
import com.mikhailsobol.tictactoe.model.exceptions.AlreadyOccupiedException;
import com.mikhailsobol.tictactoe.model.exceptions.InvalidCoordinateException;
import com.mikhailsobol.tictactoe.model.fields.IField;

public class EasyAi implements IAi {
// TODO: test this class.

    @Override
    public void move(final TicTacToeMoveController moveController,
                     final Figure figure,
                     final IField field) throws InvalidCoordinateException,
                                            AlreadyOccupiedException {
        final Point point = getPoint(field);
        moveController.applyFigure(field, figure, point);
    }

    @Override
    public DifficultyLevel getDifficultyLevel() {
        return DifficultyLevel.EASY;
    }

    private Point getPoint(final IField field) throws InvalidCoordinateException {
        int x, y;
        do {
            x = (int) (Math.random() * field.getSize());
            y = (int) (Math.random() * field.getSize());
        } while (!(field.getFigure(new Point(x, y)) == null));
        return new Point(x, y);
    }

}
