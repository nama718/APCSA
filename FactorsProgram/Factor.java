import java.util.Scanner;

public class Factor
{
    public static void main (String[] args)
    {
        Scanner k = new Scanner(System.in);
        System.out.println("Enter a number:");
        int num = k.nextInt();
        
        while (num!= 0)
        {
        System.out.println("Factors for the number " + num + " :"); 
        for(int i = 1; i <= num; i++)
        {
            
            if(num % i == 0 && i != 1 && i != num) 
             {
             System.out.print(i + " \n");
                 
                }
            
        }
        System.out.println("Enter again >>>");
        num = k.nextInt();
        }
        if(num == 0)
        {
            System.out.println("Factoring Stopped");
        }
        }
    }
        
        
    

