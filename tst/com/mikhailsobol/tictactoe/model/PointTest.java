package com.mikhailsobol.tictactoe.model;

import org.junit.Test;

import static org.junit.Assert.*;

public class PointTest {
    @Test
    public void getX() throws Exception {
        final int inputValue = 1;
        final int expectedValue = inputValue;
        final Point point = new Point(inputValue, 0);
        final int actualValue = point.getX();
        assertEquals(expectedValue, actualValue);
    }

    @Test
    public void getY() throws Exception {
        final int inputValue = 1;
        final int expectedValue = inputValue;
        final Point point = new Point(0, inputValue);
        final int actualValue = point.getY();
        assertEquals(expectedValue, actualValue);
    }

}