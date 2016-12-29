package com.mikhailsobol.tictactoe.controller.Ai;


import com.mikhailsobol.tictactoe.model.Point;
import com.mikhailsobol.tictactoe.model.enums.AiDifficultyLevel;
import com.mikhailsobol.tictactoe.model.exceptions.InvalidCoordinateException;
import com.mikhailsobol.tictactoe.model.fields.IField;

public class EasyAi implements IAi {

    @Override
    public AiDifficultyLevel getDifficultyLevel() {
        return AiDifficultyLevel.EASY;
    }

    @Override
    public Point getPoint(final IField field) throws InvalidCoordinateException {
        int x, y;
        do {
            x = (int) (Math.random() * field.getSize());
            y = (int) (Math.random() * field.getSize());
        } while (!(field.checkIfOccupied(new Point(x, y))));
        return new Point(x, y);
    }

}
