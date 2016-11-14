package com.mikhailsobol.tictactoe.model;


public class Player<T> {

    private final String name;

    private final T figure;

    public Player(final String name,
                  final T figure) {
        this.name = name;
        this.figure = figure;
    }

    public String getName() {
        return name;
    }

    public T getFigure() {
        return figure;
    }
}
