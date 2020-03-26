import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner sc = new Scanner(System.in);
        
        //bikin 2d array dulu biar gampang
        int n = sc.nextInt();
        ArrayList<ArrayList<Integer>> arrLists = new ArrayList();
        for(int h = 0 ; h<n ; h++)
        {
            int input = sc.nextInt();
            ArrayList<Integer> rows = new ArrayList();
            for(int i = 0 ; i<input ; i++)
            {
                rows.add(sc.nextInt());
            }
            arrLists.add(rows);
        }
        
        int queries = sc.nextInt();
        
        for(int j = 0 ; j<queries ; j++)
        {
            int x = sc.nextInt();
            int y = sc.nextInt();
            ArrayList<Integer> myList = arrLists.get(x-1);
            if(y <= myList.size())
            {
                System.out.println(myList.get(y-1));
            } else {
                System.out.println("ERROR!");
            } 
        }
        
        sc.close();
    }
}