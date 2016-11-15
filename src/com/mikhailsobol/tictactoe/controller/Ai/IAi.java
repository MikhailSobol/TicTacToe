package com.mikhailsobol.tictactoe.controller.Ai;


import com.mikhailsobol.tictactoe.model.Point;
import com.mikhailsobol.tictactoe.model.enums.DifficultyLevel;
import com.mikhailsobol.tictactoe.model.enums.Figure;

public interface IAi {

    void move(final Point point, final Figure figure);

    DifficultyLevel getDifficultyLevel();

}
