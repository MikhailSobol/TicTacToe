package com.mikhailsobol.tictactoe.view.mainmenuwindow;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class MainMenu extends Application implements Runnable {

    private static final String TITLE = "Tic tac toe. Main window.";

    private static final int WIDTH = 800;

    private static final int HEIGHT = 600;

    @Override
    public void run() {
        launch();
    }

    @Override
    public void start(final Stage primaryStage) throws Exception {
        final FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("/MainMenuWindow.fxml"));
        final Parent root = loader.load();
        primaryStage.setTitle(TITLE);
        primaryStage.setScene(new Scene(root, WIDTH, HEIGHT));
        primaryStage.setResizable(false);
        primaryStage.show();
    }

}
