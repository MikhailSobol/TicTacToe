package com.mikhailsobol.tictactoe.model.games;

import com.mikhailsobol.tictactoe.model.Player;
import com.mikhailsobol.tictactoe.model.enums.Figure;;
import com.mikhailsobol.tictactoe.model.fields.TicTacToeField;
import org.junit.Test;

import static org.junit.Assert.*;

public class MultiplayerTicTacToeGameTest {

    @Test
    public void testGetName() {
        final String inputValue = "XO";
        final String expectedValue = inputValue;
        final MultiplayerTicTacToeGame game = new MultiplayerTicTacToeGame(null, null, false, inputValue);
        final String actualValue = game.getName();
        assertEquals(expectedValue, actualValue);
    }

    @Test
    public void testGetField() {
        final TicTacToeField<Figure> inputField = new TicTacToeField<>();
        final TicTacToeField<Figure> expectedField = inputField;
        final MultiplayerTicTacToeGame<Figure> game = new MultiplayerTicTacToeGame<Figure>(null,
                inputField, false, "");
        final TicTacToeField<Figure> actualField = (TicTacToeField<Figure>) game.getField();
        assertEquals(expectedField, actualField);
    }

    @Test
    public void testIsSingleplayer() {
        final boolean inputValue = false;
        final boolean expectedValue = inputValue;
        final MultiplayerTicTacToeGame<Figure> game = new MultiplayerTicTacToeGame<>(null, null, inputValue, "");
        final boolean actualValue = game.isSingleplayer();
        assertEquals(expectedValue, actualValue);
    }

    @Test
    public void testGetPlayers() {
        final Player[] inputPlayers = new Player[]{new Player("Mike", Figure.X),
                new Player("Steve", Figure.O)};
        final Player[] expectedPlayers = inputPlayers;
        final MultiplayerTicTacToeGame<Figure> game = new MultiplayerTicTacToeGame<>(inputPlayers, null, false, "");
        final Player<Figure>[] actualPlayers = game.getPlayers();
        for (int i = 0; i < expectedPlayers.length; i++) {
            if (!expectedPlayers[i].getName().equals(actualPlayers[i].getName()) ||
                    !(expectedPlayers[i].getFigure() == actualPlayers[i].getFigure())) {
                fail();
            }
        }
    }

}