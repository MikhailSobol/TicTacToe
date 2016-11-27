package com.mikhailsobol.tictactoe.view.mainmenuwindow;

import com.mikhailsobol.tictactoe.model.enums.DifficultyLevel;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ChoiceBox;

import java.net.URL;
import java.util.ArrayList;
import java.util.EnumSet;
import java.util.ResourceBundle;

public class MainMenuController implements Initializable {

    @FXML
    private ChoiceBox aiDifficultyLevelChoiceBox;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        initializeChoiceBox();
    }

    private void initializeChoiceBox() {
        final ArrayList<DifficultyLevel> aiDifficultyLevels =
                new ArrayList<>(EnumSet.allOf(DifficultyLevel.class));
        final ObservableList levels = FXCollections.observableList(aiDifficultyLevels);
        aiDifficultyLevelChoiceBox.setItems(levels);
    }

}
