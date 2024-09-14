import java.io.*;
import java.lang.*;
import java.util.*;
import java.util.Arrays;
//Aman Balam
public class SieveOfEratosthenes
{
    
    public static void main (String[] args)
    {
      int i = 0; 
      int max = 1000;
      int min = 2;
      boolean Holder[] = new boolean[max];
      
      for (i = 0; i< Holder.length; i++) {
         Holder[i] = true;
      }
      
      for ( i = min; i< Math.sqrt(max); i++) {
         if(Holder[i] == true) {
            for(int c = (i*i); c<max; c = c+i) {
               Holder[c] = false;
            }
         }
      }
      
      for (i = min; i< Holder.length; i++) {
         if(Holder[i]==true) {
            System.out.println(i);
         }
      }
    }
   }

    
    
     
    

        
    
   

