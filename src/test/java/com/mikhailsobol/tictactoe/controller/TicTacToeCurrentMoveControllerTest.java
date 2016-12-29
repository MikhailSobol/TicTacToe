package com.mikhailsobol.tictactoe.controller;

import com.mikhailsobol.tictactoe.model.Player;
import com.mikhailsobol.tictactoe.model.Point;
import com.mikhailsobol.tictactoe.model.enums.Figure;
import com.mikhailsobol.tictactoe.model.fields.TicTacToeField;
import com.mikhailsobol.tictactoe.model.games.MultiplayerTicTacToeGame;
import org.junit.Test;

import static org.junit.Assert.*;


public class TicTacToeCurrentMoveControllerTest {

    @Test
    public void getCurrentPlayerWhenZeroMoves() throws Exception {
        final Player[] players = { new Player("Mike", Figure.X), new Player("Steve", Figure.O) };
        final TicTacToeField<Figure> field = new TicTacToeField<>();
        final TicTacToeMoveController moveController = new TicTacToeMoveController();
        final TicTacToeCurrentMoveController currentMoveController = new TicTacToeCurrentMoveController();
        final MultiplayerTicTacToeGame game = new MultiplayerTicTacToeGame(players, field, false, "XO");
        final Player expectedPlayer = players[0];
        final Player currentPlayer = currentMoveController.getCurrentPlayer(game);
        assertEquals(currentPlayer.getFigure(), expectedPlayer.getFigure());
    }

    @Test
    public void getCurrentPlayerWhenOneMoves() throws Exception {
        final Player[] players = { new Player("Mike", Figure.X), new Player("Steve", Figure.O) };
        final TicTacToeField<Figure> field = new TicTacToeField<>();
        final TicTacToeMoveController moveController = new TicTacToeMoveController();
        final TicTacToeCurrentMoveController currentMoveController = new TicTacToeCurrentMoveController();
        final MultiplayerTicTacToeGame game = new MultiplayerTicTacToeGame(players, field, false, "XO");
        final Player expectedPlayer = players[1];
        moveController.applyFigure(field, Figure.X, new Point(0, 0));
        final Player currentPlayer = currentMoveController.getCurrentPlayer(game);
        assertEquals(currentPlayer.getFigure(), expectedPlayer.getFigure());
    }

    @Test
    public void getCurrentPlayerWhenTwoMoves() throws Exception {
        final Player[] players = { new Player("Mike", Figure.X), new Player("Steve", Figure.O) };
        final TicTacToeField<Figure> field = new TicTacToeField<>();
        final TicTacToeMoveController moveController = new TicTacToeMoveController();
        final TicTacToeCurrentMoveController currentMoveController = new TicTacToeCurrentMoveController();
        final MultiplayerTicTacToeGame game = new MultiplayerTicTacToeGame(players, field, false, "XO");
        final Player expectedPlayer = players[0];
        moveController.applyFigure(field, Figure.X, new Point(0, 0));
        moveController.applyFigure(field, Figure.O, new Point(0, 1));
        final Player currentPlayer = currentMoveController.getCurrentPlayer(game);
        assertEquals(currentPlayer.getFigure(), expectedPlayer.getFigure());
    }

}