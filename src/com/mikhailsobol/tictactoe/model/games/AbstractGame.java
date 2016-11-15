package com.mikhailsobol.tictactoe.model.games;


import com.mikhailsobol.tictactoe.model.Player;
import com.mikhailsobol.tictactoe.model.fields.IField;

public abstract class AbstractGame<T> {

    private final String name;

    final Player<T>[] players;

    final IField<T> field;

    final boolean isSingleplayer;

    public AbstractGame(final Player<T>[] players,
                        final IField<T> field,
                        final boolean isSinglePlayer,
                        final String name) {
        this.players = players;
        this.field = field;
        this.isSingleplayer = isSinglePlayer;
        this.name = name;
    }

    public IField<T> getField() {
        return field;
    }

    public boolean isSingleplayer() {
        return isSingleplayer;
    }

    public String getName() {
        return this.name;
    }

    public Player[] getPlayers() {
        return this.players;
    }

}
