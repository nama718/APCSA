public class player extends Tester
//30
{
    
    String name;
    int number;
    public String DefaultName()
   {
     return name = "";  
    }
     public int DefaultNumber()
   {
     return number = -1;  
    }
   public player(String n, int num)
   {
       name = n;
       number = num;
    } 
   public String playerInfo()
   {
       return name + " (Number" + number + ")";
       
    } 
   
}