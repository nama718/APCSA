import java.util.Scanner;

public class PrimeFactorization
{
    public static void main (String[] args)
    {
        Scanner k = new Scanner(System.in);
        System.out.println("Enter a number:");
        int num = k.nextInt();
        
        while (num!=0)
        {
        System.out.println("The Prime factorization for " + num + " is:");  
        for(int i = 2; i <= num; i++)
        {
            
            while(num % i == 0) 
             {
               
             System.out.print(i + " \n");
             num = num/=i;    
                }
            
        }
        
        System.out.println("Enter again >>>");
        num = k.nextInt();
         
        }
        if(num > 2)
        {
            System.out.println(num);
        }
        if(num == 0)
        {
            System.out.println("Prime Factorization Stopped");
        }
        }
    }
    