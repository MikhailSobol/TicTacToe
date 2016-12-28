package com.mikhailsobol.tictactoe.controller.Ai;


import com.mikhailsobol.tictactoe.model.Point;
import com.mikhailsobol.tictactoe.model.enums.AiDifficultyLevel;
import com.mikhailsobol.tictactoe.model.exceptions.AlreadyOccupiedException;
import com.mikhailsobol.tictactoe.model.exceptions.InvalidCoordinateException;
import com.mikhailsobol.tictactoe.model.fields.IField;

public class HardAi implements IAi {

    @Override
    public Point move(final IField field) throws InvalidCoordinateException, AlreadyOccupiedException {
        return new EasyAi().move(field);
    }

    @Override
    public AiDifficultyLevel getDifficultyLevel() {
        return AiDifficultyLevel.HARD;
    }
}
