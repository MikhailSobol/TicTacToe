package com.mikhailsobol.tictactoe.controller;

import com.mikhailsobol.tictactoe.model.Point;
import com.mikhailsobol.tictactoe.model.enums.Figure;
import com.mikhailsobol.tictactoe.model.exceptions.AlreadyOccupiedException;
import com.mikhailsobol.tictactoe.model.exceptions.InvalidCoordinateException;
import com.mikhailsobol.tictactoe.model.fields.IField;
import com.mikhailsobol.tictactoe.model.fields.TicTacToeField;

import org.junit.Test;

import static org.junit.Assert.*;


public class TicTacToeMoveControllerTest {

    @Test
    public void testApplyFigure() throws Exception {
        final IField field = new TicTacToeField();
        final TicTacToeMoveController moveController = new TicTacToeMoveController();
        final Point point = new Point(0, 0);
        final Figure inputValue = Figure.X;
        final Figure expectedValue = inputValue;
        moveController.applyFigure(field, inputValue, point);
        final Figure actualFigure = (Figure) field.getFigure(point);
        assertEquals(expectedValue, actualFigure);
    }

    @Test
    public void testApplyFigureWhenOccupied() throws Exception {
        final IField field = new TicTacToeField();
        final TicTacToeMoveController moveController = new TicTacToeMoveController();
        final Point point = new Point(0, 0);
        field.setFigure(point, Figure.X);
        try {
            moveController.applyFigure(field, Figure.X, point);
            fail();
        } catch (AlreadyOccupiedException e) {}
    }

    @Test
    public void testApplyFigureWhenInvalidPoint() throws Exception {
        final IField field = new TicTacToeField();
        final TicTacToeMoveController moveController = new TicTacToeMoveController();
        final Point point = new Point(-1, 5);
        try {
            moveController.applyFigure(field, Figure.X, point);
            fail();
        } catch (InvalidCoordinateException e) {}
    }

}