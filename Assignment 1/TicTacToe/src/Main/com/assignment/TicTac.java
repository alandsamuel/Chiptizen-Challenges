package com.assignment;
import java.util.*;

/*

    Class ini berisi Game Tic Tac Toe yang Menggunakan 1 input string
    yang akan me-return hasil dari pertandingan berdasarkan input tersebut

 */

class TicTac {
    static String[][] userInput = new String[3][3];

    public static void convertAndShowBoard(String input){
        int maxInput = 9;
        StringBuilder sb = new StringBuilder(input.trim().substring(0,maxInput).toLowerCase());

        int sbIndex = 0;
        for(int row = 0 ; row < Enum.setupValue.row.val() ; row++) //jalan 3x (rows)
        {
            for(int coll = 0; coll < Enum.setupValue.column.val() ; coll ++) //jalan 3x (column)
            {
                userInput[row][coll] = Character.toString(sb.charAt(sbIndex));
                System.out.print("|" + userInput[row][coll] + "|");
                if(!userInput[row][coll].matches("(^[xoXO-]$){1}"))
                {
                    System.out.println(Enum.Messages.invalidInput.toString());
                    break;
                }
                sbIndex++;
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Processing processTicTac = new Processing();
        String input = "";
        if(args == null) {
            input = sc.nextLine();
        }else{
            input = args[0];
        }

        convertAndShowBoard(input);

        String Result;
        Result = Processing.checker(userInput);

        System.out.println(Result);
    }
}