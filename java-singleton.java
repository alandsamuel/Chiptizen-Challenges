// check tutorial here https://www.geeksforgeeks.org/singleton-class-java/

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;
import java.lang.reflect.*;


class Singleton{
      
    // variable of type String 
    public String str; 
  
    // private constructor restricted to this class itself 
    private Singleton() 
    { 
        str = "Hello I am a singleton! Let me say " + this.str +" to you"; 
    } 
  
    // static method to create instance of Singleton class 
    public static Singleton getSingleInstance() 
    { 
        Singleton single_instance = new Singleton(); 
  
        return single_instance; 
    } 

}
