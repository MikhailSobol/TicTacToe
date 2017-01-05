package com.mikhailsobol.tictactoe.view.uihelpers;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class WindowChanger {

    public void changeWindow(final String resource,
                              final ActionEvent event) throws IOException {
        Parent settingSceneParent = FXMLLoader.load(getClass().getClassLoader().getResource(resource + ".fxml"));
        Scene settingScene = new Scene(settingSceneParent);
        Stage stageTheEventSourceNodeBelongs = (Stage) ((Node)event.getSource()).getScene().getWindow();
        stageTheEventSourceNodeBelongs.setScene(settingScene);
    }

}
