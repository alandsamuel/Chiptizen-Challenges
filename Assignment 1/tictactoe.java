import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

interface checkForWin
{
    public boolean check(String[][] userInput);
} 

class checkHorizontalWin{

}

class checkVerticalWin{

}

class checkDiagonalWin{

}

public class tictactoe {

    String[][] userInput = new String[3][3];

    private static boolean boolValidation(String stringInput){
        if(stringInput.matches("(^[xy-]$){1})"))
        {

        }

        return false;
    }

    private static String resultTictac(String a){
        String result = "";
        return result;
    }
    
    private static boolean insertAndProcessArray(int position, String player) {
        int column = 0;
        int rows = 0;
        
        if(position > 3 || position < 7)
        {
            column = 2;
            rows = (position - 3);
        }
        else if(position > 7)
        {
            column = 3;
            rows = (position - 6);
        }
        else
        {
            column = 1;
            rows = position;
        }


        userInput[column][rows] = 

        return true;
    }

    public static void main() {
        Scanner sc = new Scanner(System.in);

        for (int i = 0; i < 10; i++) {
            int player = 0;
            int user = 0;
            if (i % 2 != 0) {
                System.out.print("Player 1 || Input = ");
                user = sc.nextInt();
                player = x;
            } else {
                System.out.print("Player 2 || Input = ");
                user = sc.nextInt();
                player = 2;
            }

            insertAndProcessArray(user, player); //insert to Array & process
            

        }

    }
}