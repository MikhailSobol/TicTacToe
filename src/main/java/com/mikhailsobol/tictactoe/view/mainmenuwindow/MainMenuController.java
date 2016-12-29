package com.mikhailsobol.tictactoe.view.mainmenuwindow;

import com.mikhailsobol.tictactoe.controller.Ai.EasyAi;
import com.mikhailsobol.tictactoe.controller.Ai.HardAi;
import com.mikhailsobol.tictactoe.controller.Ai.IAi;
import com.mikhailsobol.tictactoe.model.Player;
import com.mikhailsobol.tictactoe.model.enums.AiDifficultyLevel;
import com.mikhailsobol.tictactoe.model.enums.Figure;
import com.mikhailsobol.tictactoe.model.fields.IField;
import com.mikhailsobol.tictactoe.model.fields.TicTacToeField;
import com.mikhailsobol.tictactoe.model.games.AbstractTicTacToeGame;
import com.mikhailsobol.tictactoe.model.games.playable.PlayableGame;
import com.mikhailsobol.tictactoe.model.games.MultiplayerTicTacToeGame;
import com.mikhailsobol.tictactoe.model.games.SingleplayerTicTacToeGame;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ArrayList;
import java.util.EnumSet;
import java.util.ResourceBundle;

public class MainMenuController implements Initializable {

    private static final String SINGLEPLAYER_BUTTON_TEXT = "Singleplayer";

    @FXML
    private ChoiceBox aiDifficultyLevelChoiceBox;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        initializeChoiceBox();
    }

    @FXML
    private void gameButtonOnAction(final ActionEvent event) throws Exception {
        final String gameType = ((Button) event.getSource()).getText();
        if (SINGLEPLAYER_BUTTON_TEXT.equals(gameType) && !checkAi()) return;
        final AbstractTicTacToeGame game = getGame(gameType);
        PlayableGame.setGame(game);
        goToGameWindow(event);
    }

    private void goToGameWindow(final ActionEvent event) throws Exception {
        Parent settingSceneParent = FXMLLoader.load(getClass().getClassLoader().getResource("GameWindow.fxml"));
        Scene settingScene = new Scene(settingSceneParent);
        Stage stageTheEventSourceNodeBelongs = (Stage) ((Node)event.getSource()).getScene().getWindow();
        stageTheEventSourceNodeBelongs.setScene(settingScene);
    }

    private boolean checkAi() {
        return aiDifficultyLevelChoiceBox.getValue() instanceof AiDifficultyLevel;
    }

    private IAi getAi() {
        return aiDifficultyLevelChoiceBox.getValue().equals(AiDifficultyLevel.EASY) ? new EasyAi() : new HardAi();
    }

    private AbstractTicTacToeGame getGame(final String gameType) {
        return SINGLEPLAYER_BUTTON_TEXT.equals(gameType) ? getSingleplayerGame() : getMultiplayerGame();
    }

    private SingleplayerTicTacToeGame getSingleplayerGame() {
        final Player[] players = {new Player("Player1", Figure.X), new Player("Player2", Figure.O)};
        final IField field = new TicTacToeField();
        final IAi ai = getAi();
        final boolean isSingle = true;
        final String name = "Tic Tac Toe";
        return new SingleplayerTicTacToeGame(players,
                (TicTacToeField) field,ai, isSingle, name);
    }

    private MultiplayerTicTacToeGame getMultiplayerGame() {
        final Player[] players = {new Player("Player1", Figure.X), new Player("Player2", Figure.O)};
        final IField field = new TicTacToeField();
        final boolean isSingle = false;
        final String name = "Tic Tac Toe";
        return new MultiplayerTicTacToeGame(players, field, isSingle, name);
    }

    private void initializeChoiceBox() {
        final ArrayList<AiDifficultyLevel> aiDifficultyLevels =
                new ArrayList<>(EnumSet.allOf(AiDifficultyLevel.class));
        final ObservableList levels = FXCollections.observableList(aiDifficultyLevels);
        aiDifficultyLevelChoiceBox.setItems(levels);
    }

}
