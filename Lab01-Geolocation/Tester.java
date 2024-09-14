 
//Name: Aman Balam
import java.util.*;
import static java.lang.System.*;
	public class Tester
	{
	    //2   	  
	    public static void main(String[] args)
		{
	            //3
		    System.out.println("Hello again, world!");
		    //4 
		    //This is a comment!
		    //5
		    int numApples = 25;
		    //6
		    final int PRICE_OF_APPLES = 100;
		    //7
		    System.out.println("The total for " + numApples + " apple(s):\n"
		    + numApples * PRICE_OF_APPLES + " cents"); 
		    //8
		    int totalPrice = numApples * PRICE_OF_APPLES;
		    if(totalPrice >=2000)
		    System.out.println("Thank you valued customer!");
		    //9
		    for(int n = 10; n >= 0; n--)
		    {
		       System.out.print(n + " ");
		       System.out.println();
		      }
		    //10
		    for(int x = 150; x <301; x+=3)
		    {
		        System.out.print(x + " ");
		        System.out.println();
		      }
		    //11
		    int sum;
		    for(int n = 0; n<101; n++)
		    {
		        sum = n*(n+1)/2;
		        System.out.println(sum);
		      }
		    //12 Quiet
		    
		    //13
		    Scanner console = new Scanner(System.in);
		    //14
		    System.out.println("Enter a number >>>");
		    double num = console.nextDouble();
		    //15
		    System.out.println(Math.sqrt(num));
		    //16
		    System.out.println(Math.pow(num,3));
		    //17
		    System.out.println("Enter a number >>>");
		    int num1 = console.nextInt();
		    System.out.println("Enter another number >>>");
		    int num2 = console.nextInt();
		    if(num1 + 10 >= num2 || num1 -10 >= num2)
		    
		        System.out.println("Within 10");
		     else
		     System.out.println("Not Within 10");
		    //18
		    int c = 0;
		    int b = 0;
		    int x = console.nextInt();
		    while(x!=0)
		    {
		        
		        c =+x;
		        b++;
		        double y = ((double)c)/b;
		        System.out.println(y);
		      }
		    //19
		    double areas[] = new double[20];
		    //20
		    areas[0] = 4.56; 
		    //21
		    int length = areas.length; 
		    //22
		    boolean [] arrayB = {true, true, false, false, true};
		    //23 no idea
		    }
		    //24  
		       public static void simpleMethod()
		    {
		        
		        System.out.println("This is a method!");
		      }
		    //25
		       public static int sum(int a, int b)
		    {
		        
		        return a + b;
		      }
		    //26
		    public static int sumToN(int n)
		    {
		       int sum = 0;
		       
		      
		       for (int x = 1;  x<=n; x++)
		       if(x%3 ==0 || x%5 ==0)
		       sum +=x;
		       
		       
		       return sum;
		      }
		    //27
		    public static void triangle (int n)
		    {
		      for (int x = 1; x <=n; x++)
		      {
		          for (int y = 1; y <=x; y++)
		          {
		              System.out.print(x);
		             
		          }
		          System.out.println();
		      }
		  
                    }
                    //28
                    public static String altCaps(String s)
                    {
                        char [] array = s.toCharArray();
                        for(int i = 0; i <s.length(); i++)
                        {
                            if(s.indexOf(i) %2 ==0)
                            {
                                s.substring(i).toUpperCase();
                            }
                            
                        }
                        return s;
                        
                       
                        
                    }
                    //29
                    public static void happy(String[] args){
                        
                       
                    Tester thisObj = new Tester();
                    thisObj.triangle(3);
                    thisObj.simpleMethod();
                    thisObj.sum(1,2);
                    thisObj.sumToN(3);
                    thisObj.altCaps("happy");
                }
                //31
                public static void help(String [] args)
    {
        
        player p1 = new player("Mary", 30);
        player p2 = new player("Bob", 31);
        player p3 = new player("Samantha", 32);
        player p4 = new player("Ford", 333);
        out.println("Starting Point");
        out.println(p1);
        out.println(p2);
        out.println(p3);
        out.println(p4);
        
        
       
    }
                
                
                
            }

		     
		      

		
		



