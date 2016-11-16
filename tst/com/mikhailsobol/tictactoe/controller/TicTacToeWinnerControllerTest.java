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
    public void testGetWinnerWhenWinnerIsPlayer1OnVertical() throws Exception {
        final Player[] players = { new Player("M", Figure.X), new Player("S", Figure.O) };
        final TicTacToeField field = new TicTacToeField();
        final MultiplayerTicTacToeGame game = new MultiplayerTicTacToeGame(players, field, false, "XO");
        final TicTacToeMoveController moveController = new TicTacToeMoveController();
        final TicTacToeCurrentMoveController currentMoveController = new TicTacToeCurrentMoveController();
        final TicTacToeWinnerController winnerController = new TicTacToeWinnerController();
        moveController.applyFigure(field, (Figure) currentMoveController.getCurrentPlayer(game).getFigure(), new Point(0, 0));
        moveController.applyFigure(field, (Figure) currentMoveController.getCurrentPlayer(game).getFigure(), new Point(0, 1));
        moveController.applyFigure(field, (Figure) currentMoveController.getCurrentPlayer(game).getFigure(), new Point(1, 0));
        moveController.applyFigure(field, (Figure) currentMoveController.getCurrentPlayer(game).getFigure(), new Point(1, 1));
        moveController.applyFigure(field, (Figure) currentMoveController.getCurrentPlayer(game).getFigure(), new Point(2, 0));
        final Player expectedWinner = players[0];
        final Player actualWinner = winnerController.getWinner(game);
        if (expectedWinner.getFigure() != actualWinner.getFigure() &&
                !Objects.equals(expectedWinner.getName(), actualWinner.getName())) {
            fail();
        }
    }

    @Test
    public void testGetWinnerWhenWinnerIsPlayer1OnHorizontal() throws Exception {
        final Player[] players = { new Player("M", Figure.X), new Player("S", Figure.O) };
        final TicTacToeField field = new TicTacToeField();
        final MultiplayerTicTacToeGame game = new MultiplayerTicTacToeGame(players, field, false, "XO");
        final TicTacToeMoveController moveController = new TicTacToeMoveController();
        final TicTacToeCurrentMoveController currentMoveController = new TicTacToeCurrentMoveController();
        final TicTacToeWinnerController winnerController = new TicTacToeWinnerController();
        moveController.applyFigure(field, (Figure) currentMoveController.getCurrentPlayer(game).getFigure(), new Point(0, 0));
        moveController.applyFigure(field, (Figure) currentMoveController.getCurrentPlayer(game).getFigure(), new Point(1, 0));
        moveController.applyFigure(field, (Figure) currentMoveController.getCurrentPlayer(game).getFigure(), new Point(0, 1));
        moveController.applyFigure(field, (Figure) currentMoveController.getCurrentPlayer(game).getFigure(), new Point(1, 1));
        moveController.applyFigure(field, (Figure) currentMoveController.getCurrentPlayer(game).getFigure(), new Point(0, 2));
        final Player expectedWinner = players[0];
        final Player actualWinner = winnerController.getWinner(game);
        if (expectedWinner.getFigure() != actualWinner.getFigure() &&
                !Objects.equals(expectedWinner.getName(), actualWinner.getName())) {
            fail();
        }
    }

    @Test
    public void testGetWinnerWhenWinnerIsPlayer1OnFirstDiagonal() throws Exception {
        final Player[] players = { new Player("M", Figure.X), new Player("S", Figure.O) };
        final TicTacToeField field = new TicTacToeField();
        final MultiplayerTicTacToeGame game = new MultiplayerTicTacToeGame(players, field, false, "XO");
        final TicTacToeMoveController moveController = new TicTacToeMoveController();
        final TicTacToeCurrentMoveController currentMoveController = new TicTacToeCurrentMoveController();
        final TicTacToeWinnerController winnerController = new TicTacToeWinnerController();
        moveController.applyFigure(field, (Figure) currentMoveController.getCurrentPlayer(game).getFigure(), new Point(0, 0));
        moveController.applyFigure(field, (Figure) currentMoveController.getCurrentPlayer(game).getFigure(), new Point(1, 0));
        moveController.applyFigure(field, (Figure) currentMoveController.getCurrentPlayer(game).getFigure(), new Point(1, 1));
        moveController.applyFigure(field, (Figure) currentMoveController.getCurrentPlayer(game).getFigure(), new Point(2, 1));
        moveController.applyFigure(field, (Figure) currentMoveController.getCurrentPlayer(game).getFigure(), new Point(2, 2));
        final Player expectedWinner = players[0];
        final Player actualWinner = winnerController.getWinner(game);
        if (expectedWinner.getFigure() != actualWinner.getFigure() &&
                !Objects.equals(expectedWinner.getName(), actualWinner.getName())) {
            fail();
        }
    }

    @Test
    public void testGetWinnerWhenWinnerIsPlayer1OnSecondDiagonal() throws Exception {
        final Player[] players = { new Player("M", Figure.X), new Player("S", Figure.O) };
        final TicTacToeField field = new TicTacToeField();
        final MultiplayerTicTacToeGame game = new MultiplayerTicTacToeGame(players, field, false, "XO");
        final TicTacToeMoveController moveController = new TicTacToeMoveController();
        final TicTacToeCurrentMoveController currentMoveController = new TicTacToeCurrentMoveController();
        final TicTacToeWinnerController winnerController = new TicTacToeWinnerController();
        moveController.applyFigure(field, (Figure) currentMoveController.getCurrentPlayer(game).getFigure(), new Point(0, 2));
        moveController.applyFigure(field, (Figure) currentMoveController.getCurrentPlayer(game).getFigure(), new Point(1, 0));
        moveController.applyFigure(field, (Figure) currentMoveController.getCurrentPlayer(game).getFigure(), new Point(1, 1));
        moveController.applyFigure(field, (Figure) currentMoveController.getCurrentPlayer(game).getFigure(), new Point(2, 1));
        moveController.applyFigure(field, (Figure) currentMoveController.getCurrentPlayer(game).getFigure(), new Point(2, 0));
        final Player expectedWinner = players[0];
        final Player actualWinner = winnerController.getWinner(game);
        if (expectedWinner.getFigure() != actualWinner.getFigure() &&
                !Objects.equals(expectedWinner.getName(), actualWinner.getName())) {
            fail();
        }
    }

    @Test
    public void testGetWinnerWhenWinnerIsPlayer2OnHorizontal() throws Exception {
        final Player[] players = {new Player("M", Figure.X), new Player("S", Figure.O)};
        final TicTacToeField field = new TicTacToeField();
        final MultiplayerTicTacToeGame game = new MultiplayerTicTacToeGame(players, field, false, "XO");
        final TicTacToeMoveController moveController = new TicTacToeMoveController();
        final TicTacToeCurrentMoveController currentMoveController = new TicTacToeCurrentMoveController();
        final TicTacToeWinnerController winnerController = new TicTacToeWinnerController();
        moveController.applyFigure(field, (Figure) currentMoveController.getCurrentPlayer(game).getFigure(), new Point(2, 2));
        moveController.applyFigure(field, (Figure) currentMoveController.getCurrentPlayer(game).getFigure(), new Point(0, 0));
        moveController.applyFigure(field, (Figure) currentMoveController.getCurrentPlayer(game).getFigure(), new Point(1, 1));
        moveController.applyFigure(field, (Figure) currentMoveController.getCurrentPlayer(game).getFigure(), new Point(1, 0));
        moveController.applyFigure(field, (Figure) currentMoveController.getCurrentPlayer(game).getFigure(), new Point(1, 2));
        moveController.applyFigure(field, (Figure) currentMoveController.getCurrentPlayer(game).getFigure(), new Point(2, 0));
        final Player expectedWinner = players[1];
        final Player actualWinner = winnerController.getWinner(game);
        if (expectedWinner.getFigure() != actualWinner.getFigure() &&
                !Objects.equals(expectedWinner.getName(), actualWinner.getName())) {
            fail();
        }
    }

    @Test
    public void testGetWinnerWhenWinnerIsPlayer2OnVertical() throws Exception {
        final Player[] players = {new Player("M", Figure.X), new Player("S", Figure.O)};
        final TicTacToeField field = new TicTacToeField();
        final MultiplayerTicTacToeGame game = new MultiplayerTicTacToeGame(players, field, false, "XO");
        final TicTacToeMoveController moveController = new TicTacToeMoveController();
        final TicTacToeCurrentMoveController currentMoveController = new TicTacToeCurrentMoveController();
        final TicTacToeWinnerController winnerController = new TicTacToeWinnerController();
        moveController.applyFigure(field, (Figure) currentMoveController.getCurrentPlayer(game).getFigure(), new Point(2, 2));
        moveController.applyFigure(field, (Figure) currentMoveController.getCurrentPlayer(game).getFigure(), new Point(0, 0));
        moveController.applyFigure(field, (Figure) currentMoveController.getCurrentPlayer(game).getFigure(), new Point(1, 1));
        moveController.applyFigure(field, (Figure) currentMoveController.getCurrentPlayer(game).getFigure(), new Point(0, 1));
        moveController.applyFigure(field, (Figure) currentMoveController.getCurrentPlayer(game).getFigure(), new Point(1, 0));
        moveController.applyFigure(field, (Figure) currentMoveController.getCurrentPlayer(game).getFigure(), new Point(0, 2));
        final Player expectedWinner = players[1];
        final Player actualWinner = winnerController.getWinner(game);
        if (expectedWinner.getFigure() != actualWinner.getFigure() &&
                !Objects.equals(expectedWinner.getName(), actualWinner.getName())) {
            fail();
        }
    }

    @Test
    public void testGetWinnerWhenWinnerIsPlayer2OnFirstDiagonal() throws Exception {
        final Player[] players = {new Player("M", Figure.X), new Player("S", Figure.O)};
        final TicTacToeField field = new TicTacToeField();
        final MultiplayerTicTacToeGame game = new MultiplayerTicTacToeGame(players, field, false, "XO");
        final TicTacToeMoveController moveController = new TicTacToeMoveController();
        final TicTacToeCurrentMoveController currentMoveController = new TicTacToeCurrentMoveController();
        final TicTacToeWinnerController winnerController = new TicTacToeWinnerController();
        moveController.applyFigure(field, (Figure) currentMoveController.getCurrentPlayer(game).getFigure(), new Point(2, 0));
        moveController.applyFigure(field, (Figure) currentMoveController.getCurrentPlayer(game).getFigure(), new Point(0, 0));
        moveController.applyFigure(field, (Figure) currentMoveController.getCurrentPlayer(game).getFigure(), new Point(0, 1));
        moveController.applyFigure(field, (Figure) currentMoveController.getCurrentPlayer(game).getFigure(), new Point(1, 1));
        moveController.applyFigure(field, (Figure) currentMoveController.getCurrentPlayer(game).getFigure(), new Point(1, 0));
        moveController.applyFigure(field, (Figure) currentMoveController.getCurrentPlayer(game).getFigure(), new Point(2, 2));
        final Player expectedWinner = players[1];
        final Player actualWinner = winnerController.getWinner(game);
        if (expectedWinner.getFigure() != actualWinner.getFigure() &&
                !Objects.equals(expectedWinner.getName(), actualWinner.getName())) {
            fail();
        }
    }

    @Test
    public void testGetWinnerWhenWinnerIsPlayer2OnSecondDiagonal() throws Exception {
        final Player[] players = {new Player("M", Figure.X), new Player("S", Figure.O)};
        final TicTacToeField field = new TicTacToeField();
        final MultiplayerTicTacToeGame game = new MultiplayerTicTacToeGame(players, field, false, "XO");
        final TicTacToeMoveController moveController = new TicTacToeMoveController();
        final TicTacToeCurrentMoveController currentMoveController = new TicTacToeCurrentMoveController();
        final TicTacToeWinnerController winnerController = new TicTacToeWinnerController();
        moveController.applyFigure(field, (Figure) currentMoveController.getCurrentPlayer(game).getFigure(), new Point(1, 0));
        moveController.applyFigure(field, (Figure) currentMoveController.getCurrentPlayer(game).getFigure(), new Point(0, 2));
        moveController.applyFigure(field, (Figure) currentMoveController.getCurrentPlayer(game).getFigure(), new Point(0, 1));
        moveController.applyFigure(field, (Figure) currentMoveController.getCurrentPlayer(game).getFigure(), new Point(1, 1));
        moveController.applyFigure(field, (Figure) currentMoveController.getCurrentPlayer(game).getFigure(), new Point(1, 2));
        moveController.applyFigure(field, (Figure) currentMoveController.getCurrentPlayer(game).getFigure(), new Point(2, 0));
        final Player expectedWinner = players[1];
        final Player actualWinner = winnerController.getWinner(game);
        if (expectedWinner.getFigure() != actualWinner.getFigure() &&
                !Objects.equals(expectedWinner.getName(), actualWinner.getName())) {
            fail();
        }
    }

}