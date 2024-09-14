import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.HashMap;
import java.util.*;
import java.util.Scanner;
import java.io.*;
public class HashMapProbs
{
    
    public static void main (String[] args)
    {
        //2
        HashMap<String, String> animalSounds = new HashMap<String,String>();
        animalSounds.put("Dog","Woof");
        animalSounds.put("Cat","Meow");
        animalSounds.put("Cow","Moo");
        animalSounds.put("Pig","Oink");
        System.out.println(animalSounds);
        //3
        Scanner x = new Scanner(System.in);
        System.out.println("Enter a name:");
        String str = x.nextLine();
        try {
        
        System.out.println(animalSounds.get(str));
        }
       catch(Exception e) {
      System.out.println("Null");
      }
      //4
      System.out.println("The Total amount of Keys: " + animalSounds.size());
      //5
      System.out.println("Enter an animal:");
      String newAnimal = x.nextLine();
      System.out.println("Enter The Animal's Sound:");
      String newSound = x.nextLine();
      animalSounds.put(newAnimal,newSound);
      System.out.println(animalSounds);
      //7
      System.out.println(takeBefore("str","bye"));
      //8
      System.out.println(multiple("hello"));
      //9
      System.out.println(charWord(new String[] {"tea", "salt", "soda", "taco"}));
      //10
     
    
        }
        public static HashMap<String, String> takeBefore(String a, String b)
        {
            
            HashMap<String, String> s = new HashMap<String,String>();
            char[] c = a.toCharArray(); 
            char[] d = b.toCharArray();
            for(int i = 0; i < c.length; i++)
            {
            if(c[i] < d[i])
            {
                char x = c[i];
                char y = d[i];
                String q = Character.toString(x);
                String r = Character.toString(y);
                s.put(q,r);
            }
            else
            {
                if(d[i] < c[i])
                {
                char x = c[i];
                char y = d[i];
                String q = Character.toString(x);
                String r = Character.toString(y);
                s.put(r,q);
                }
            }
            
        }
            return s;
        }
        public static HashMap<String, Boolean> multiple(String s)
        {
            char[] c = s.toCharArray();
            HashMap<String, Boolean> f = new HashMap<String,Boolean>();
            boolean x = false;
           
          
        
        for(int i = 0; i <c.length; i++) {  
            int count = 1;  
            for(int j = i+1; j <c.length; j++) {  
                if(c[i] == c[j] && c[i] != ' ') {  
                    count++;  
                    
                    
                }  
            }
        
            
            if(count > 1 && c[i] != '0')  
              {
                  char z = c[i]; 
                  String q = Character.toString(z);
                  x = true;
                  f.put(q,x);
                  
               }
               else
               {
                  char t = c[i]; 
                  String p = Character.toString(t);
                  f.put(p,x);
                  
                }
            f.put("o",false);    
            }
                return f;
        }
        public static HashMap<String, String> charWord(String[] words)
        {
            HashMap<String, String> f = new HashMap<String,String>();
             for (String s:words) {
            if (!f.containsKey(s.substring(0,1))) {  
         f.put(s.substring(0,1), s);

           }
          else
          {
          String e = f.get(s.substring(0,1));
          f.put(s.substring(0,1), e+s);
         }

         }
        return f;
        }
        public static void printMax()
        {
         Scanner input = null;
         String n = "";
         
         HashMap<String, Integer> f = new HashMap<String,Integer>();
             try {
           input = new Scanner(new File("dream.txt"));
          }
          catch(FileNotFoundException exception)
         {
         System.out.println("Cannot find the file");
         }
         while(input.hasNext())
         {
             String word = input.next();
             f.put(word,2);
             
            }
         int max = Collections.max(f.values());
         for(String key : f.keySet())
         if(f.get(key) == max)
         System.out.println("Highest frequency word: " + key + ". " + max);
         
        }
        
        }
    


