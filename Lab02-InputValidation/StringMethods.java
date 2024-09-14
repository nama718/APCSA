
import java.util.Scanner;
public class StringMethods
{
    
    //6
    public void unusualHello(String name)
    {
        System.out.println("Hello " + name + ", you dummy!");
    }
    //7
    public String stringRipper(String str)
    {
        int x = str.length();
        String jelly = str.substring(0,1);
        String jelly1 = str.substring(x-1);
        return jelly+jelly1;
    }
    //8
    public boolean evenFooBar(String s)
    {
        if (s.indexOf("foo")!=-1 && s.indexOf("bar")!=-1)
        {
            return true;
        }
        else
        {
            return false;
        }
    }
    //9 No idea :(
    
    //10
    
    public int sumString(String str)
    {
        int sum = 0;
        int cat = 0;
        Scanner console = new Scanner(str);
        while(console.hasNext())
        {
            if(console.hasNextInt()){
                
                sum = sum+= console.nextInt();
                
            }
            else{
                console.next();
            }
        }
        return sum;
    }
    //11
    public String decode (String key, String code)
    {
        Scanner console = new Scanner(code);
        console.useDelimiter(" ");
        int hello = 0;
        while(console.hasNextInt())
        {
            for (int i = 0; i < code.length(); i++)
            {
            if(console.hasNextInt()){
                    hello = console.nextInt();
                    return key.substring(console.nextInt(hello));
                }
                else{
                    console.next();
                }
            }   
        }
        return key.substring(console.nextInt(hello));
    }

}
