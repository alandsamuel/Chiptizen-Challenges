package com.assignment;
import java.util.*;

/*

    Class ini berisi Game Tic Tac Toe yang dimainkan per Turn

 */

class TicTacToe {
    static String[][] userInput = new String[Enum.setupValue.row.val()][Enum.setupValue.column.val()];
    int maxInput = 9;

    public static void showBoardStatus(String[][] userInput){
        int collNumber = 1;
        System.out.println(); //line before :)
        for(int row = 0 ; row < 3 ; row++){
            for(int coll = 0 ; coll < 3 ; coll++){
                if(userInput[row][coll] == null){
                    userInput[row][coll] = Integer.toString(collNumber);
                }
                collNumber++;
                System.out.print("|" + userInput[row][coll] + "|");
            }
            System.out.println();
        }
        System.out.println(); //line after :)
    }

    public static boolean inputToArray(int input, String playerInput)
    {
        boolean Result = false;

        if(input > 6){
            if(!userInput[2][input - Enum.setupValue.row3.val()].matches("(^[xoXO-]$){1}")){
            userInput[2][input - Enum.setupValue.row3.val()] = playerInput;
            Result = true;}
        }
        else if(input > 3){
            userInput[1][input - Enum.setupValue.row2.val()] = playerInput;
            Result = true;
        }
        else{
            userInput[0][input- Enum.setupValue.row1.val()] = playerInput;
            Result = true;
        }

        return Result;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Processing processTicTac = new Processing();
        String Result = "";

        for(int i = 0; i < Enum.setupValue.maxInput.val() ; i++) {
            String player = Enum.playerSetup.p1.toString();
            if(i % 2 > 0)
            {
                player = Enum.playerSetup.p2.toString();
            }
            showBoardStatus(userInput);
            System.out.println("Player " + player +", choose your position : (Insert 0 (Zero) or Press Enter to skip)");
            System.out.println("(1 - 9)");
            int input = sc.nextInt();

            if(input == 0)
            {
                player = Enum.playerSetup.noChoice.toString();
            }

            if(inputToArray(input, player)) {
                Result = Processing.checker(userInput);
                if(!Result.contains(Enum.Messages.inProgress.toString())){
                    showBoardStatus(userInput);
                    System.out.println(Result);
                    break;
                }
            }else{
                System.out.println(Enum.Messages.duplicateInput.toString());
                i--; //reset counter, so user can input again
            }
        }
    }
}

