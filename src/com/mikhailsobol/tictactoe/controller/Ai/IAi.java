package com.mikhailsobol.tictactoe.controller.Ai;


import com.mikhailsobol.tictactoe.model.Point;
import com.mikhailsobol.tictactoe.model.enums.DifficultyLevel;
import com.mikhailsobol.tictactoe.model.exceptions.AlreadyOccupiedException;
import com.mikhailsobol.tictactoe.model.exceptions.InvalidCoordinateException;
import com.mikhailsobol.tictactoe.model.fields.IField;

public interface IAi {

    Point move(final IField field) throws InvalidCoordinateException, AlreadyOccupiedException;

    DifficultyLevel getDifficultyLevel();

}
