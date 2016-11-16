package com.mikhailsobol.tictactoe.controller;

import com.mikhailsobol.tictactoe.model.Player;
import com.mikhailsobol.tictactoe.model.Point;
import com.mikhailsobol.tictactoe.model.enums.Figure;
import com.mikhailsobol.tictactoe.model.fields.IField;
import com.mikhailsobol.tictactoe.model.fields.TicTacToeField;
import com.mikhailsobol.tictactoe.model.games.MultiplayerTicTacToeGame;
import org.junit.Test;

import java.util.Objects;

import static org.junit.Assert.*;

public class TicTacToeWinnerControllerTest {

    @Test
    public void testGetWinnerWhenWinnerIsPlayer1OnHorizontal() throws Exception {
        final TicTacToeWinnerController winnerController = new TicTacToeWinnerController();
        final Player[] players = {new Player("M", Figure.X), new Player("S", Figure.O)};
        final int fieldSize = 3;
        final Player expectedPlayer = players[0];
        for (int i = 0; i < fieldSize; i++) {
            final TicTacToeField field = new TicTacToeField();
            final MultiplayerTicTacToeGame game = new MultiplayerTicTacToeGame(players, field, false, "XO");
            field.setFigure(new Point(i, 0), Figure.X);
            field.setFigure(new Point(i, 1), Figure.X);
            field.setFigure(new Point(i, 2), Figure.X);
            assertEquals(expectedPlayer.getFigure(), winnerController.getWinner(game).getFigure());
        }
    }

    @Test
    public void testGetWinnerWhenWinnerIsPlayer2OnHorizontal() throws Exception {
        final TicTacToeWinnerController winnerController = new TicTacToeWinnerController();
        final Player[] players = {new Player("M", Figure.X), new Player("S", Figure.O)};
        final int fieldSize = 3;
        final Player expectedPlayer = players[1];
        for (int i = 0; i < fieldSize; i++) {
            final TicTacToeField field = new TicTacToeField();
            final MultiplayerTicTacToeGame game = new MultiplayerTicTacToeGame(players, field, false, "XO");
            field.setFigure(new Point(i, 0), Figure.O);
            field.setFigure(new Point(i, 1), Figure.O);
            field.setFigure(new Point(i, 2), Figure.O);
            assertEquals(expectedPlayer.getFigure(), winnerController.getWinner(game).getFigure());
        }
    }

    @Test
    public void testGetWinnerWhenNoWinnerOnHorizontal() throws Exception {
        final TicTacToeWinnerController winnerController = new TicTacToeWinnerController();
        final Player[] players = {new Player("M", Figure.X), new Player("S", Figure.O)};
        final int fieldSize = 3;
        for (int i = 0; i < fieldSize; i++) {
            final TicTacToeField field = new TicTacToeField();
            final MultiplayerTicTacToeGame game = new MultiplayerTicTacToeGame(players, field, false, "XO");
            field.setFigure(new Point(i, 0), Figure.O);
            field.setFigure(new Point(i, 1), Figure.O);
            field.setFigure(new Point(i, 2), Figure.X);
            assertNull(winnerController.getWinner(game));
        }
    }

    @Test
    public void testGetWinnerWhenWinnerIsPlayer1OnVertical() throws Exception {
        final TicTacToeWinnerController winnerController = new TicTacToeWinnerController();
        final Player[] players = {new Player("M", Figure.X), new Player("S", Figure.O)};
        final int fieldSize = 3;
        final Player expectedPlayer = players[0];
        for (int i = 0; i < fieldSize; i++) {
            final TicTacToeField field = new TicTacToeField();
            final MultiplayerTicTacToeGame game = new MultiplayerTicTacToeGame(players, field, false, "XO");
            field.setFigure(new Point(0, i), Figure.X);
            field.setFigure(new Point(1, i), Figure.X);
            field.setFigure(new Point(2, i), Figure.X);
            assertEquals(expectedPlayer.getFigure(), winnerController.getWinner(game).getFigure());
        }
    }

    @Test
    public void testGetWinnerWhenWinnerIsPlayer2OnVertical() throws Exception {
        final TicTacToeWinnerController winnerController = new TicTacToeWinnerController();
        final Player[] players = {new Player("M", Figure.X), new Player("S", Figure.O)};
        final int fieldSize = 3;
        final Player expectedPlayer = players[1];
        for (int i = 0; i < fieldSize; i++) {
            final TicTacToeField field = new TicTacToeField();
            final MultiplayerTicTacToeGame game = new MultiplayerTicTacToeGame(players, field, false, "XO");
            field.setFigure(new Point(0, i), Figure.O);
            field.setFigure(new Point(1, i), Figure.O);
            field.setFigure(new Point(2, i), Figure.O);
            assertEquals(expectedPlayer.getFigure(), winnerController.getWinner(game).getFigure());
        }
    }

    @Test
    public void testGetWinnerWhenNoWinnerOnVertical() throws Exception {
        final TicTacToeWinnerController winnerController = new TicTacToeWinnerController();
        final Player[] players = {new Player("M", Figure.X), new Player("S", Figure.O)};
        final int fieldSize = 3;
        final Player expectedPlayer = players[1];
        for (int i = 0; i < fieldSize; i++) {
            final TicTacToeField field = new TicTacToeField();
            final MultiplayerTicTacToeGame game = new MultiplayerTicTacToeGame(players, field, false, "XO");
            field.setFigure(new Point(0, i), Figure.X);
            field.setFigure(new Point(1, i), Figure.O);
            field.setFigure(new Point(2, i), Figure.O);
            assertNull(winnerController.getWinner(game));
        }
    }

    @Test
    public void testGetWinnerWhenWinnerIsPlayer1OnFirstDiagonal() throws Exception {
        final TicTacToeWinnerController winnerController = new TicTacToeWinnerController();
        final Player[] players = {new Player("M", Figure.X), new Player("S", Figure.O)};
        final int fieldSize = 3;
        final Player expectedPlayer = players[0];
        final TicTacToeField field = new TicTacToeField();
        final MultiplayerTicTacToeGame game = new MultiplayerTicTacToeGame(players, field, false, "XO");
        field.setFigure(new Point(0, 0), Figure.X);
        field.setFigure(new Point(1, 1), Figure.X);
        field.setFigure(new Point(2, 2), Figure.X);
        assertEquals(expectedPlayer.getFigure(), winnerController.getWinner(game).getFigure());
    }

    @Test
    public void testGetWinnerWhenWinnerIsPlayer2OnFirstDiagonal() throws Exception {
        final TicTacToeWinnerController winnerController = new TicTacToeWinnerController();
        final Player[] players = {new Player("M", Figure.X), new Player("S", Figure.O)};
        final int fieldSize = 3;
        final Player expectedPlayer = players[1];
        final TicTacToeField field = new TicTacToeField();
        final MultiplayerTicTacToeGame game = new MultiplayerTicTacToeGame(players, field, false, "XO");
        field.setFigure(new Point(0, 0), Figure.O);
        field.setFigure(new Point(1, 1), Figure.O);
        field.setFigure(new Point(2, 2), Figure.O);
        assertEquals(expectedPlayer.getFigure(), winnerController.getWinner(game).getFigure());
    }

    @Test
    public void testGetWinnerWhenWinnerIsPlayer1OnSecondDiagonal() throws Exception {
        final TicTacToeWinnerController winnerController = new TicTacToeWinnerController();
        final Player[] players = {new Player("M", Figure.X), new Player("S", Figure.O)};
        final int fieldSize = 3;
        final Player expectedPlayer = players[0];
        final TicTacToeField field = new TicTacToeField();
        final MultiplayerTicTacToeGame game = new MultiplayerTicTacToeGame(players, field, false, "XO");
        field.setFigure(new Point(0, 2), Figure.X);
        field.setFigure(new Point(1, 1), Figure.X);
        field.setFigure(new Point(2, 0), Figure.X);
        assertEquals(expectedPlayer.getFigure(), winnerController.getWinner(game).getFigure());
    }

    @Test
    public void testGetWinnerWhenWinnerIsPlayer2OnSecondDiagonal() throws Exception {
        final TicTacToeWinnerController winnerController = new TicTacToeWinnerController();
        final Player[] players = {new Player("M", Figure.X), new Player("S", Figure.O)};
        final int fieldSize = 3;
        final Player expectedPlayer = players[1];
        final TicTacToeField field = new TicTacToeField();
        final MultiplayerTicTacToeGame game = new MultiplayerTicTacToeGame(players, field, false, "XO");
        field.setFigure(new Point(0, 2), Figure.O);
        field.setFigure(new Point(1, 1), Figure.O);
        field.setFigure(new Point(2, 0), Figure.O);
        assertEquals(expectedPlayer.getFigure(), winnerController.getWinner(game).getFigure());
    }

}

