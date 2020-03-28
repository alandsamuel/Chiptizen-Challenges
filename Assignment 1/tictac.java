import java.util.*;

enum Status{
    Success,
    Failed,
    Invalid
}

enum Messages{
    winner {
        public String toString() {
            return "Wins The Game!";
        }
    },
    draw {
        public String toString() {
            return "Draw Game!";
        }
    },
    inprogress{
        public String toString() {
            return "Game still in Progress!";
        }
    },
    invalidGame{
        public String toString() {
            return "Invalid Grid Detected!";
        }
    },
    invalidInput{
        public String toString() {
            return "Invalid Input Detected (Not X,O,-)!";
        }
    }
}

class forWin{

    public String checker(String[][] userInput){
        String winner = "";

        String[] vertical = checkVerticalWin(userInput).split(",");
        String[] horizontal = checkHorizontalWin(userInput).split(",");
        String[] diagonal = checkDiagonalWin(userInput).split(",");

        if(vertical[0] == horizontal[0] || vertical[0] == diagonal[0])
        {
            return Messages.invalidGame.toString();
        }
        else if (horizontal[0] == diagonal[0])
        {
            return Messages.invalidGame.toString();
        }

        winner = (vertical[1]!= null)? vertical[1] : (horizontal[1] != null) ? horizontal[1] : diagonal[1];

        return winner + Messages.winner;
        // return 
    }

    protected String checkVerticalWin(String[][] userInput){
        int winFound = 0;
        String status;
        String winner = "";
        for(int coll = 1 ; coll <= 3; coll++)
        {
            int row = 1;
            if(userInput[row][coll] != "-" && userInput[row+1][coll] != "-" && userInput[row+2][coll]!= "-"){
                if(userInput[row][coll] == userInput[row+1][coll] && userInput[row+1][coll] == userInput[row+2][coll]);
                {
                    winFound += 1;
                    winner = userInput[row][coll];
                }
            }
        }

        if(winFound > 1)
        {
            status = Status.Invalid.toString();
            return status;
        }
        
        status = Status.Success.toString() + "," + winner;
        return status;
    }

    protected String checkHorizontalWin(String[][] userInput){
        int winFound = 0;
        String status;
        String winner = "";
        for(int row = 1 ; row <= 3; row++)
        {
            int coll = 1;
            if(userInput[row][coll] != "-" && userInput[row][coll+1] != "-" && userInput[row][coll+2]!= "-"){
                if(userInput[row][coll] == userInput[row][coll+1] && userInput[row][coll+1] == userInput[row][coll+2]);
                {
                    winFound += 1;
                    winner = userInput[row][coll];
                }
            }
        }

        if(winFound > 1)
        {
            status = Status.Invalid.toString();
            return status;
        }
        
        status = Status.Success.toString() + "," + winner;
        return status;
    }

    protected String checkDiagonalWin(String[][] userInput){
        int winFound = 0;
        String status;
        String winner = "";
        if(userInput[1][1] == userInput[2][2] && userInput[2][2] == userInput[3][3])
        {
            if(userInput[1][1] != "-" && userInput[2][2] != "-" && userInput[3][3] != "-"){
                winFound += 1;
                winner = userInput[2][2];
            }
        }
        else if(userInput[3][1] == userInput[2][2] && userInput[2][2] == userInput[1][3])
        {
            if(userInput[3][1] != "-" && userInput[2][2] != "-" && userInput[1][3] != "-"){
                winFound += 1;
                winner = userInput[2][2];
            }
        }

        if(winFound > 1)
        {
            status = Status.Invalid.toString();
            return status;
        }
        
        status = Status.Success.toString() + "," + winner;
        return status;
    }
}

public class tictac {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        forWin fw = new forWin();
        String input = sc.next();
        
        StringBuilder sb = new StringBuilder(input);        
        String[][] userInput = new String[3][3];
        int sbIndex = 0;
        for(int i = 1 ; i <= 3 ; i++) //jalan 3x (rows)
        {
            for(int j = 1; j <= 3 ; j ++) //jalan 3x (column)
            {   
                userInput[i][j] = Character.toString(sb.charAt(sbIndex));
                if(!userInput[i][j].matches("(^[xoXO-]$){1}"))
                {
                    System.out.println(Messages.invalidInput.toString());
                    break;
                }
                sbIndex++;
            }
        }

        String Result = fw.checker(userInput);

        System.out.println(Result);
    }
}