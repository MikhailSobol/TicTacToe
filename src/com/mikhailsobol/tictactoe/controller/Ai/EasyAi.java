package com.mikhailsobol.tictactoe.controller.Ai;


import com.mikhailsobol.tictactoe.model.Point;
import com.mikhailsobol.tictactoe.model.enums.AiDifficultyLevel;
import com.mikhailsobol.tictactoe.model.exceptions.AlreadyOccupiedException;
import com.mikhailsobol.tictactoe.model.exceptions.InvalidCoordinateException;
import com.mikhailsobol.tictactoe.model.fields.IField;

public class EasyAi implements IAi {

    @Override
    public Point move(final IField field) throws InvalidCoordinateException,
                                            AlreadyOccupiedException {
        return getPoint(field);
    }

    @Override
    public AiDifficultyLevel getDifficultyLevel() {
        return AiDifficultyLevel.EASY;
    }

    private Point getPoint(final IField field) throws InvalidCoordinateException {
        int x, y;
        do {
            x = (int) (Math.random() * field.getSize());
            y = (int) (Math.random() * field.getSize());
        } while (!(field.isEmpty(new Point(x, y))));
        return new Point(x, y);
    }

}
