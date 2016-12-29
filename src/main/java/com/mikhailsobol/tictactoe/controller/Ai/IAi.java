package com.mikhailsobol.tictactoe.controller.Ai;


import com.mikhailsobol.tictactoe.model.Point;
import com.mikhailsobol.tictactoe.model.enums.AiDifficultyLevel;
import com.mikhailsobol.tictactoe.model.exceptions.AlreadyOccupiedException;
import com.mikhailsobol.tictactoe.model.exceptions.InvalidCoordinateException;
import com.mikhailsobol.tictactoe.model.exceptions.PlayerNotFoundException;
import com.mikhailsobol.tictactoe.model.fields.IField;

public interface IAi {

    default Point move(final IField field) throws InvalidCoordinateException, AlreadyOccupiedException, PlayerNotFoundException {
        return getPoint(field);
    }

    AiDifficultyLevel getDifficultyLevel();

    Point getPoint(final IField field) throws InvalidCoordinateException, AlreadyOccupiedException, PlayerNotFoundException;

}
