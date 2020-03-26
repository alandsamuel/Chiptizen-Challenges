import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        
        Scanner sc = new Scanner(System.in);
        
        int nElements = sc.nextInt();
        List<Integer> intList = new ArrayList<Integer>();
        //Input Element
        for(int h = 0 ; h< nElements ; h++)
        {
            intList.add(sc.nextInt());
        }
        
        //queries?
        int xQuery = sc.nextInt();
        for(int i = 0 ; i<xQuery ; i ++)
        {
            String query = sc.next();
            int index = 0;
            int value = 0;
            switch(query){
                case "Insert" :
                    index = sc.nextInt();
                    value = sc.nextInt();

                    intList.add(index,value);
                    break;
                case "Delete" :
                    index = sc.nextInt();

                    intList.remove(index);
                    break;
                default :
                    index = sc.nextInt();

                    intList.get(index);
            }
        }
        
        for (Integer num : intList)
        {
            System.out.print(num + " ");
        }
    }
}