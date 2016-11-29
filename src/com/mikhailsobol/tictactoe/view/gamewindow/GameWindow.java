package com.mikhailsobol.tictactoe.view.gamewindow;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class GameWindow extends Application implements Runnable {

    private static final String TITLE = "Tic Tac Toe. Game Window.";

    private static final int WIDTH = 626;

    private static final int HEIGHT = 743;

    @Override
    public void run() {
        launch();
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        final FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("GameWindow.fxml"));
        final Parent root = loader.load();
        primaryStage.setTitle(TITLE);
        primaryStage.setScene(new Scene(root, WIDTH, HEIGHT));
        primaryStage.setResizable(false);
        primaryStage.show();
    }
}
