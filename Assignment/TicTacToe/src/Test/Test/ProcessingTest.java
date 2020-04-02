package Test;

import com.assignment.Processing;
import com.assignment.Enum;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ProcessingTest {

    @Test
    void checkerXWins() {
        Processing p = new Processing();
        String input = "XOXXOOXXO";
        StringBuilder sb = new StringBuilder(input.trim().substring(0,9).toLowerCase());
        String[][] userInput = new String[3][3];

        int sbIndex = 0;
        for(int row = 0 ; row < 3 ; row++) //jalan 3x (rows)
        {
            for(int coll = 0; coll < 3 ; coll ++) //jalan 3x (column)
            {
                userInput[row][coll] = Character.toString(sb.charAt(sbIndex));
                sbIndex++;
            }
        }

        assertEquals("X Wins The Game!", p.checker(userInput), "X Should Win the game");
    }

    @Test
    void checkerOWins() {
        Processing p = new Processing();
        String input = "XOOXOXOXO";
        StringBuilder sb = new StringBuilder(input.trim().substring(0,9).toLowerCase());
        String[][] userInput = new String[3][3];

        int sbIndex = 0;
        for(int row = 0 ; row < 3 ; row++) //jalan 3x (rows)
        {
            for(int coll = 0; coll < 3 ; coll ++) //jalan 3x (column)
            {
                userInput[row][coll] = Character.toString(sb.charAt(sbIndex));
                sbIndex++;
            }
        }

        assertEquals("O Wins The Game!", p.checker(userInput), "O Should Win the game");
    }

    @Test
    void checkerDraw() {
        Processing p = new Processing();
        String input = "OXOXOXXOX";
        StringBuilder sb = new StringBuilder(input.trim().substring(0,9).toLowerCase());
        String[][] userInput = new String[3][3];

        int sbIndex = 0;
        for(int row = 0 ; row < 3 ; row++) //jalan 3x (rows)
        {
            for(int coll = 0; coll < 3 ; coll ++) //jalan 3x (column)
            {
                userInput[row][coll] = Character.toString(sb.charAt(sbIndex));
                sbIndex++;
            }
        }

        assertEquals("Draw Game!", p.checker(userInput), "Test for Draw game, so no one wins");
    }

    @Test
    void checkerInProgress() {
        Processing p = new Processing();
        String input = "XOXX--O--";
        StringBuilder sb = new StringBuilder(input.trim().substring(0,9).toLowerCase());
        String[][] userInput = new String[3][3];

        int sbIndex = 0;
        for(int row = 0 ; row < 3 ; row++) //jalan 3x (rows)
        {
            for(int coll = 0; coll < 3 ; coll ++) //jalan 3x (column)
            {
                userInput[row][coll] = Character.toString(sb.charAt(sbIndex));
                sbIndex++;
            }
        }

        assertEquals("Game still in Progress!", p.checker(userInput), "Test for InProgress, so no one wins");
    }

    @Test
    void checkerInvalid() {
        Processing p = new Processing();
        String input = "XXXOOOXXO";
        StringBuilder sb = new StringBuilder(input.trim().substring(0,9).toLowerCase());
        String[][] userInput = new String[3][3];

        int sbIndex = 0;
        for(int row = 0 ; row < 3 ; row++) //jalan 3x (rows)
        {
            for(int coll = 0; coll < 3 ; coll ++) //jalan 3x (column)
            {
                userInput[row][coll] = Character.toString(sb.charAt(sbIndex));
                sbIndex++;
            }
        }

        assertEquals("Invalid Grid Detected !", p.checker(userInput), "Test for Invalid Grid, so no one wins");
    }
}