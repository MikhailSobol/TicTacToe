package com.mikhailsobol.tictactoe.model.games;


import com.mikhailsobol.tictactoe.model.Player;
import com.mikhailsobol.tictactoe.model.fields.IField;

public abstract class AbstractGame<T> {

    protected final Player<T>[] players;

    protected final IField<T> field;

    protected final boolean isSingleplayer;

    public AbstractGame(final Player<T>[] players,
                        final IField<T> field,
                        final boolean isSinglePlayer) {
        this.players = players;
        this.field = field;
        this.isSingleplayer = isSinglePlayer;
    }

    public IField<T> getField() {
        return field;
    }

    public boolean isSingleplayer() {
        return isSingleplayer;
    }
}
