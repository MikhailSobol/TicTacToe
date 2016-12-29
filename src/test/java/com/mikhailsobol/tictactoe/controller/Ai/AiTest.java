package com.mikhailsobol.tictactoe.controller.Ai;

import com.mikhailsobol.tictactoe.controller.GameController;
import com.mikhailsobol.tictactoe.controller.TicTacToeCurrentMoveController;
import com.mikhailsobol.tictactoe.controller.TicTacToeMoveController;
import com.mikhailsobol.tictactoe.model.Player;
import com.mikhailsobol.tictactoe.model.enums.Figure;
import com.mikhailsobol.tictactoe.model.exceptions.AlreadyOccupiedException;
import com.mikhailsobol.tictactoe.model.exceptions.InvalidCoordinateException;
import com.mikhailsobol.tictactoe.model.exceptions.PlayerNotFoundException;
import com.mikhailsobol.tictactoe.model.fields.TicTacToeField;
import com.mikhailsobol.tictactoe.model.games.SingleplayerTicTacToeGame;
import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

import static org.junit.Assert.*;

public class AiTest {

    @Test
    public void move() throws Exception {
        final Set<IAi> ais = new HashSet<>(2);
        final IAi easyAi = new EasyAi();
        final IAi hardAi = new HardAi();
        ais.add(easyAi);
        ais.add(hardAi);

        for (final IAi ai : ais) {
            if (!test(ai))
                fail();
        }
    }

    private static boolean test(final IAi ai) throws InvalidCoordinateException {
        final Player[] players = { new Player("Mike", Figure.X), new Player("ai", Figure.O) };
        final TicTacToeField<Figure> field = new TicTacToeField<>();
        final TicTacToeMoveController moveController = new TicTacToeMoveController();
        final TicTacToeCurrentMoveController currentMoveController = new TicTacToeCurrentMoveController();
        final SingleplayerTicTacToeGame game = new SingleplayerTicTacToeGame(players, field, ai, true, "TTT");
        final GameController gameController = new GameController(game);
        for (int i = 0; i < 9; i++) {
            try {
                gameController.makeMove(ai.move(game.getField()));
            } catch (InvalidCoordinateException | PlayerNotFoundException | AlreadyOccupiedException e) {
                e.printStackTrace();
            }
        }
        return field.hasEmptyCell();
    }

}