package com.mikhailsobol.tictactoe.controller.Ai;


import com.mikhailsobol.tictactoe.controller.TicTacToeMoveController;
import com.mikhailsobol.tictactoe.model.Point;
import com.mikhailsobol.tictactoe.model.enums.DifficultyLevel;
import com.mikhailsobol.tictactoe.model.enums.Figure;
import com.mikhailsobol.tictactoe.model.exceptions.AlreadyOccupiedException;
import com.mikhailsobol.tictactoe.model.exceptions.InvalidCoordinateException;
import com.mikhailsobol.tictactoe.model.fields.IField;

public class HardAi implements IAi {

    @Override
    public Point move(final IField field) throws InvalidCoordinateException, AlreadyOccupiedException {
        return new EasyAi().move(field);
    }

    @Override
    public DifficultyLevel getDifficultyLevel() {
        return DifficultyLevel.HARD;
    }
}
