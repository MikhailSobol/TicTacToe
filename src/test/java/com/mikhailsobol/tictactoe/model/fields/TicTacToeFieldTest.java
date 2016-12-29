package com.mikhailsobol.tictactoe.model.fields;

import com.mikhailsobol.tictactoe.model.Point;
import com.mikhailsobol.tictactoe.model.enums.Figure;
import org.junit.Test;

import static org.junit.Assert.*;


public class TicTacToeFieldTest {

    @Test
    public void testGetSize() throws Exception {
        final IField field = new TicTacToeField<Figure>();
        final int expectedSize = 3;
        final int actualSize = field.getSize();
        assertEquals(expectedSize, actualSize);
    }

    @Test
    public void testGetAndSetFigure() throws Exception {
        final IField field = new TicTacToeField<Figure>();
        final Figure figureToSet = Figure.X;
        for (int i = 0; i < field.getSize(); i++) {
            for (int j = 0; j < field.getSize(); j++) {
                field.setFigure(new Point(i, j), figureToSet);
            }
        }
        for (int i = 0; i < field.getSize(); i++) {
            for (int j = 0; j < field.getSize(); j++) {
                if (!((Figure)field.getFigure(new Point(i, j)) == figureToSet)) {
                    fail();
                }
            }
        }
    }

}