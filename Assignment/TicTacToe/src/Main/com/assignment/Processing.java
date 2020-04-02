package com.assignment;
import java.util.*;

public class Processing{
    static String winner = "";
    static int noInput;
    static int userInputSize;

    public static String checker(String[][] userInput){

        List<String> myList = new ArrayList();
        myList.add(checkVerticalWin(userInput));
        myList.add(checkHorizontalWin(userInput));
        myList.add(checkDiagonalWin(userInput));

        checkInsideBoard(userInput);

        if (noInput > 0) {
            return Enum.Messages.inProgress.toString();
        }

        if (myList.contains(Enum.Status.Invalid.toString())) {
            return Enum.Messages.invalidGame.toString();
        }

        myList.removeIf(x -> x.equals(Enum.Status.Success.toString()));
        if (myList.size() == 0 && winner == "" && userInputSize == 9) {
            return Enum.Messages.draw.toString();
        }else if(myList.size() == 0 && winner == "" && userInputSize < 9){
            return  Enum.Messages.inProgress.toString();
        }

        return winner + " " + Enum.Messages.winner;
    }

    protected static String checkVerticalWin(String[][] userInput){
        int winFound = 0;
        for(int coll = 0 ; coll < 3; coll++)
        {
            int row = 0;
            if(userInput[row][coll] != "-" && userInput[row+1][coll] != "-" && userInput[row+2][coll]!= "-"){
                if(userInput[row][coll] != null && userInput[row+1][coll] != null && userInput[row+2][coll]!= null) {
                    if (userInput[row][coll].equals(userInput[row + 1][coll]) && userInput[row + 1][coll].equals(userInput[row + 2][coll])) {
                        winFound += 1;
                        winner = userInput[row][coll];
                    }
                }
            }
        }

        if(winFound > 1){
            return Enum.Status.Invalid.toString();
        }
        return Enum.Status.Success.toString();
    }

    protected static String checkHorizontalWin(String[][] userInput){
        int winFound = 0;
        for(int row = 0 ; row < 3; row++)
        {
            int coll = 0;
            if(userInput[row][coll] != "-" && userInput[row][coll+1] != "-" && userInput[row][coll+2]!= "-"){
                if(userInput[row][coll] != null && userInput[row][coll + 1] != null && userInput[row][coll+2]!= null) {
                    if (userInput[row][coll].equals(userInput[row][coll + 1]) && userInput[row][coll + 1].equals(userInput[row][coll + 2])) {
                        winFound += 1;
                        winner = userInput[row][coll];
                    }
                }
            }
        }

        if(winFound > 1){
            return Enum.Status.Invalid.toString();
        }
        return Enum.Status.Success.toString();
    }

    protected static String checkDiagonalWin(String[][] userInput){
        int winFound = 0;
        if(userInput[0][0] != null && userInput[1][1] != null && userInput[2][2]!= null) {
            if(userInput[0][0].equals(userInput[1][1]) && userInput[1][1].equals(userInput[2][2]))
            {
                if(userInput[0][0] != "-" && userInput[1][1] != "-" && userInput[2][2] != "-"){
                    winFound += 1;
                    winner = userInput[1][1];
                }
            }
        }

        if(userInput[2][0] != null && userInput[1][1] != null && userInput[0][2]!= null) {
            if (userInput[2][0].equals(userInput[1][1]) && userInput[1][1].equals(userInput[0][2])) {
                if (userInput[2][0] != "-" && userInput[1][1] != "-" && userInput[0][2] != "-") {
                    winFound += 1;
                    winner = userInput[1][1];
                }
            }
        }

        if(winFound > 1){
            return Enum.Status.Invalid.toString();
        }
        return Enum.Status.Success.toString();
    }

    protected static void checkInsideBoard(String[][] userInput){
        noInput = 0;
        userInputSize = 0;
        for (String[] rows : userInput) {
            for (String item : rows) {
                if (item != null) {
                    if(item.equals("-")){
                        noInput++;
                    }
                    else if(item.matches("(^[xoXO]$){1}")){
                        userInputSize++; //check board is it full
                    }
                }
            }
        }

    }
}