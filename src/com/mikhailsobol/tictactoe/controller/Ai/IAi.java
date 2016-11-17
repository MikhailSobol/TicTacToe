package com.mikhailsobol.tictactoe.controller.Ai;


import com.mikhailsobol.tictactoe.controller.TicTacToeMoveController;
import com.mikhailsobol.tictactoe.model.enums.DifficultyLevel;
import com.mikhailsobol.tictactoe.model.enums.Figure;
import com.mikhailsobol.tictactoe.model.exceptions.AlreadyOccupiedException;
import com.mikhailsobol.tictactoe.model.exceptions.InvalidCoordinateException;
import com.mikhailsobol.tictactoe.model.fields.IField;

public interface IAi {

    void move(final TicTacToeMoveController moveController,
              final Figure figure,
              final IField field) throws InvalidCoordinateException, AlreadyOccupiedException;

    DifficultyLevel getDifficultyLevel();

}
