package com.mikhailsobol.tictactoe.view.executables;


import com.mikhailsobol.tictactoe.view.mainmenuwindow.MainMenu;

public class UIRunner extends Thread {

    @Override
    public void run() {
        final MainMenu mainMenu = new MainMenu();
        final Thread mainMenuThread  = new Thread(mainMenu, "mainMenuThread");
        mainMenuThread.start();
        try {
            mainMenuThread .join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Done");
    }
}
