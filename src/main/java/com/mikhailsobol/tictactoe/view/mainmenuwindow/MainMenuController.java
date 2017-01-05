package com.mikhailsobol.tictactoe.view.mainmenuwindow;

import com.mikhailsobol.tictactoe.controller.Ai.EasyAi;
import com.mikhailsobol.tictactoe.controller.Ai.HardAi;
import com.mikhailsobol.tictactoe.controller.Ai.IAi;
import com.mikhailsobol.tictactoe.model.enums.AiDifficultyLevel;
import com.mikhailsobol.tictactoe.model.exceptions.UnsupportedGameTypeException;
import com.mikhailsobol.tictactoe.model.games.AbstractTicTacToeGame;
import com.mikhailsobol.tictactoe.model.games.playable.PlayableGame;
import com.mikhailsobol.tictactoe.model.games.MultiplayerTicTacToeGame;
import com.mikhailsobol.tictactoe.model.games.SingleplayerTicTacToeGame;
import com.mikhailsobol.tictactoe.model.games.factrories.TicTacToeGameFactory;
import com.mikhailsobol.tictactoe.view.uihelpers.FactoryContainer;
import com.mikhailsobol.tictactoe.view.uihelpers.WindowChanger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;

import java.io.IOException;
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

    @FXML
    private void onlineButtonOnAction(final ActionEvent event) throws IOException {
        new WindowChanger().changeWindow("OnlineWindow", event);
    }

    private void goToGameWindow(final ActionEvent event) throws Exception {
        new WindowChanger().changeWindow("GameWindow", event);
    }

    private boolean checkAi() {
        return aiDifficultyLevelChoiceBox.getValue() instanceof AiDifficultyLevel;
    }

    private IAi getAi() {
        return aiDifficultyLevelChoiceBox.getValue().equals(AiDifficultyLevel.EASY) ? new EasyAi() : new HardAi();
    }

    private AbstractTicTacToeGame getGame(final String gameType) throws UnsupportedGameTypeException {
        return SINGLEPLAYER_BUTTON_TEXT.equals(gameType) ? getSingleplayerGame() : getMultiplayerGame();
    }

    private SingleplayerTicTacToeGame getSingleplayerGame() throws UnsupportedGameTypeException {
        return (SingleplayerTicTacToeGame) FactoryContainer.getFactory().getGame("SINGLEPLAYER", getAi());
    }

    private MultiplayerTicTacToeGame getMultiplayerGame() throws UnsupportedGameTypeException {
        return (MultiplayerTicTacToeGame) FactoryContainer.getFactory().getGame("MULTIPLAYER", null);
    }

    private void initializeChoiceBox() {
        final ArrayList<AiDifficultyLevel> aiDifficultyLevels =
                new ArrayList<>(EnumSet.allOf(AiDifficultyLevel.class));
        final ObservableList levels = FXCollections.observableList(aiDifficultyLevels);
        aiDifficultyLevelChoiceBox.setItems(levels);
    }

}
