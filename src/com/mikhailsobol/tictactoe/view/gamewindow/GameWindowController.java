package com.mikhailsobol.tictactoe.view.gamewindow;


import com.mikhailsobol.tictactoe.controller.Ai.IAi;
import com.mikhailsobol.tictactoe.controller.GameController;
import com.mikhailsobol.tictactoe.controller.TicTacToeCurrentMoveController;
import com.mikhailsobol.tictactoe.controller.TicTacToeWinnerController;
import com.mikhailsobol.tictactoe.model.Player;
import com.mikhailsobol.tictactoe.model.Point;
import com.mikhailsobol.tictactoe.model.enums.Figure;
import com.mikhailsobol.tictactoe.model.exceptions.AlreadyOccupiedException;
import com.mikhailsobol.tictactoe.model.exceptions.InvalidCoordinateException;
import com.mikhailsobol.tictactoe.model.exceptions.PlayerNotFoundException;
import com.mikhailsobol.tictactoe.model.games.AbstractTicTacToeGame;
import com.mikhailsobol.tictactoe.model.games.MultiplayerTicTacToeGame;
import com.mikhailsobol.tictactoe.model.games.SingleplayerTicTacToeGame;
import com.mikhailsobol.tictactoe.model.games.playable.PlayableGame;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class GameWindowController implements Initializable {

    private static final String DEFAULT_LABEL_TEXT = "Current player: ";

    @FXML
    Label currentPlayerLabel;

    private Player winner;

    private TicTacToeCurrentMoveController currentMoveController;

    private GameController gameController;

    private Player currentPlayer;

    private AbstractTicTacToeGame game;

    private TicTacToeWinnerController winnerController;

    private IAi ai;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        currentMoveController = new TicTacToeCurrentMoveController();
        game = PlayableGame.getGame();
        game = game.isSingleplayer() ? (SingleplayerTicTacToeGame) game : (MultiplayerTicTacToeGame) game;
        winnerController = new TicTacToeWinnerController();
        gameController = new GameController(game);
        if (game.isSingleplayer()) {
            ai = (IAi) game.getAi();
            System.out.println(ai.getDifficultyLevel());
        }
        try {
            currentPlayer = currentMoveController.getCurrentPlayer(game);
        } catch (PlayerNotFoundException e) {
            e.printStackTrace();
        } catch (InvalidCoordinateException e) {
            e.printStackTrace();
        }
        updateLabel();
    }

    @FXML
    private void buttonOnAction(final ActionEvent event) throws AlreadyOccupiedException,
            InvalidCoordinateException, PlayerNotFoundException {
        final String buttonText = ((Button) event.getSource()).getId();
        final int[] coordinates = getCoordinates(buttonText);
        Point pointToMove = new Point(coordinates[0], coordinates[1]);
        gameController.makeMove(pointToMove);
        ((Button) event.getSource()).setText(String.valueOf(currentPlayer.getFigure()));
        ((Button) event.getSource()).setDisable(true);
        if (getWinner() != null || currentMoveController.countOccupiedCells(game.getField()) == 9) {
            winner = getWinner();
            Player.Winner.setWinner(winner);
            goToResultWindow();
        }
        updateInfo();
        if (game.isSingleplayer() && currentPlayer.getFigure().equals(Figure.O)) {
            aiMove();
        }
    }

    private void updateButtons(final ActionEvent event) {
        // TODO: this method should update buttons text and disable occupied ones.
    }

    private void aiMove() throws InvalidCoordinateException,
            AlreadyOccupiedException, PlayerNotFoundException {
        gameController.makeMove(ai.move(game.getField()));
        System.out.println("Just made move!");
        updateInfo();
    }

    private void updateInfo() throws InvalidCoordinateException, PlayerNotFoundException {
        updateCurrentPlayer();
        updateLabel();
    }

    private void goToResultWindow() {

    }

    private Player getWinner() throws InvalidCoordinateException {
        return winnerController.getWinner(game);
    }

    private void updateCurrentPlayer() throws InvalidCoordinateException, PlayerNotFoundException {
        currentPlayer = currentMoveController.getCurrentPlayer(game);
    }

    private int[] getCoordinates(final String buttonName) {
        final String coordinatesPart = buttonName.substring(buttonName.length() - 2);
        final String[] coordinateAsString = coordinatesPart.split("");
        final int firstCoordinate = Integer.parseInt(coordinateAsString[0]);
        final int secondCoordinate = Integer.parseInt(coordinateAsString[1]);
        return new int[] {firstCoordinate, secondCoordinate};
    }

    private void updateLabel() {
        currentPlayerLabel.setText(DEFAULT_LABEL_TEXT + currentPlayer.getName());
    }

}
