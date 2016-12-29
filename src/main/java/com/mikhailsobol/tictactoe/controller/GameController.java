package com.mikhailsobol.tictactoe.controller;


import com.mikhailsobol.tictactoe.model.Player;
import com.mikhailsobol.tictactoe.model.Point;
import com.mikhailsobol.tictactoe.model.enums.Figure;
import com.mikhailsobol.tictactoe.model.exceptions.AlreadyOccupiedException;
import com.mikhailsobol.tictactoe.model.exceptions.InvalidCoordinateException;
import com.mikhailsobol.tictactoe.model.exceptions.PlayerNotFoundException;
import com.mikhailsobol.tictactoe.model.games.AbstractTicTacToeGame;

public class GameController {

    private final AbstractTicTacToeGame<Figure> game;

    public GameController(final AbstractTicTacToeGame<Figure> game) {
        this.game = game;
    }

    public void makeMove(final Point point) throws InvalidCoordinateException,
            PlayerNotFoundException, AlreadyOccupiedException {
        final TicTacToeCurrentMoveController currentMoveController = new TicTacToeCurrentMoveController();
        final TicTacToeMoveController moveController = new TicTacToeMoveController();
        final Player player = currentMoveController.getCurrentPlayer(game);
        moveController.applyFigure(game.getField(), (Figure) player.getFigure(), point);
    }

}
