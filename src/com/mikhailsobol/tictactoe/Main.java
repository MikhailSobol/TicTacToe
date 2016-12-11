package com.mikhailsobol.tictactoe;


import com.mikhailsobol.tictactoe.view.executables.UIRunner;

public class Main {

    public static void main(String[] args) throws InterruptedException {
        final UIRunner uiRunner = new UIRunner();
        uiRunner.start();
        uiRunner.join();
    }

}
