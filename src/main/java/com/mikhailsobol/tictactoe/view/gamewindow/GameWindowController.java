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
import com.mikhailsobol.tictactoe.model.games.MultiplayerTicTacToeGame;
import com.mikhailsobol.tictactoe.model.games.SingleplayerTicTacToeGame;
import com.mikhailsobol.tictactoe.model.games.playable.PlayableGame;
import com.mikhailsobol.tictactoe.model.games.AbstractTicTacToeGame;
import com.mikhailsobol.tictactoe.view.uihelpers.WindowChanger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.Nullable;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class GameWindowController implements Initializable {

    protected static final String DEFAULT_LABEL_TEXT = "Current player: ";

    protected Player winner;

    protected TicTacToeCurrentMoveController currentMoveController;

    protected GameController gameController;

    protected Player currentPlayer;

    protected AbstractTicTacToeGame game;

    protected TicTacToeWinnerController winnerController;

    private IAi ai;

    @FXML
    private Label currentPlayerLabel;

    @FXML
    private Button buttons_00;

    @FXML
    private Button buttons_01;

    @FXML
    private Button buttons_02;

    @FXML
    private Button buttons_10;

    @FXML
    private Button buttons_11;

    @FXML
    private Button buttons_12;

    @FXML
    private Button buttons_20;

    @FXML
    private Button buttons_21;

    @FXML
    private Button buttons_22;

    @Override
    public void initialize(final URL location,
                           final ResourceBundle resources) {
        currentMoveController = new TicTacToeCurrentMoveController();
        game = PlayableGame.getGame();
        game = game.isSingleplayer() ? (SingleplayerTicTacToeGame) game : (MultiplayerTicTacToeGame) game;
        winnerController = new TicTacToeWinnerController();
        gameController = new GameController(game);
        if (game.isSingleplayer()) {
            ai = game.getAi();
        }
        try {
            currentPlayer = currentMoveController.getCurrentPlayer(game);
        } catch (PlayerNotFoundException | InvalidCoordinateException e) {
            e.printStackTrace();
        }
        updateLabel();
    }

    @FXML
    protected void buttonOnAction(final ActionEvent event) throws AlreadyOccupiedException,
            InvalidCoordinateException, PlayerNotFoundException, IOException, InterruptedException {
        final String buttonText = ((Button) event.getSource()).getId();
        final int[] coordinates = getCoordinates(buttonText);
        Point pointToMove = new Point(coordinates[0], coordinates[1]);
        gameController.makeMove(pointToMove);
        updateButtonByCoordinate(coordinates[0], coordinates[1]);
        updateInfo();
        if (getWinner() != null) {
            handleWinning(event);
            return;
        }
        if (game.isSingleplayer() && currentPlayer.getFigure().equals(Figure.O)) {
            aiMove();
        }
        if (getWinner() != null) {
            handleWinning(event);
        }
    }

    protected void handleWinning(final ActionEvent event) throws InvalidCoordinateException, IOException {
        winner = getWinner();
        Player.Winner.setWinner(winner);
        goToResultWindow(event);
    }

    protected void updateButtonByCoordinate(final int x,
                                          final int y) throws InvalidCoordinateException {
        final Button button = getButtonByCoordinate(x, y);
        final Point point = new Point(x, y);
        final String text = game.getField().getFigure(point) ==
                null ? "" : String.valueOf(game.getField().getFigure(point));
        button.setText(text);
        button.setDisable(true);
    }

    @Nullable
    @Contract(pure = true)
    private Button getButtonByCoordinate(final int x,
                                         final int y) {
        if (x == 0) {
            if (y == 0) return buttons_00;
            if (y == 1) return buttons_01;
            if (y == 2) return buttons_02;
        }
        if (x == 1) {
            if (y == 0) return buttons_10;
            if (y == 1) return buttons_11;
            if (y == 2) return buttons_12;
        }
        if (x == 2) {
            if (y == 0) return buttons_20;
            if (y == 1) return buttons_21;
            if (y == 2) return buttons_22;
        }
        return null;
    }

    private void aiMove() throws InvalidCoordinateException,
            AlreadyOccupiedException, PlayerNotFoundException {
        final Point point = ai.move(game.getField());
        gameController.makeMove(point);
        updateButtonByCoordinate(point.getX(), point.getY());
        updateInfo();
    }

    private void updateInfo() throws InvalidCoordinateException, PlayerNotFoundException {
        updateCurrentPlayer();
        updateLabel();
    }

    private void goToResultWindow(final ActionEvent event) throws IOException {
        new WindowChanger().changeWindow("ResultWindow", event);
    }

    protected Player getWinner() throws InvalidCoordinateException {
        return winnerController.getWinner(game);
    }

    private void updateCurrentPlayer() throws InvalidCoordinateException, PlayerNotFoundException {
        currentPlayer = currentMoveController.getCurrentPlayer(game);
    }

    protected int[] getCoordinates(final String buttonName) {
        final String coordinatesPart = buttonName.substring(buttonName.length() - 2);
        final String[] coordinateAsString = coordinatesPart.split("");
        final int firstCoordinate = Integer.parseInt(coordinateAsString[0]);
        final int secondCoordinate = Integer.parseInt(coordinateAsString[1]);
        return new int[] {firstCoordinate, secondCoordinate};
    }

    protected void updateLabel() {
        currentPlayerLabel.setText(DEFAULT_LABEL_TEXT + currentPlayer.getName());
    }

}
