package com.mikhailsobol.tictactoe.view.resultwindow;


import com.mikhailsobol.tictactoe.model.Player;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class ResultWindowController implements Initializable {

    private static final String DEFAULT_WINNER_TEXT = "Winner is: ";

    private static final String DEFAULT_DRAW_TEXT = "Draw!";

    private static final String DRAW_PLAYER_NAME = "DRAW";
    @FXML
    private Label resultLabel;

    private Player winner = Player.Winner.getWinner();

    @Override
    public void initialize(final URL url,
                           final ResourceBundle resourceBundle) {
        final String result =
                DRAW_PLAYER_NAME.equals(winner.getName()) ?
                        DEFAULT_DRAW_TEXT : DEFAULT_WINNER_TEXT + winner.getName();
        resultLabel.setText(result);
    }

    @FXML
    private void mainMenuButtonOnAction(final ActionEvent event) throws IOException {
        Parent settingSceneParent = FXMLLoader.load(getClass().getClassLoader().getResource("MainMenuWindow.fxml"));
        Scene settingScene = new Scene(settingSceneParent);
        Stage stageTheEventSourceNodeBelongs = (Stage) ((Node)event.getSource()).getScene().getWindow();
        stageTheEventSourceNodeBelongs.setScene(settingScene);
    }

}
