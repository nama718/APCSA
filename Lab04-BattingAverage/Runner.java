
import java.util.*;
import java.io.*;
public class Runner extends Team
{
    public static void main(String[] args)
    {
   
    Scanner input = null;
    String n = "";
    int playerCt = 0;
        try {
       input = new Scanner(new File("players.txt"));
    }
    catch(FileNotFoundException exception)
    {
         System.out.println("Cannot find the file");
    }
   
    String Real_Name;
    String Real_Numb;
    String avg;
    try
    {
    while(input.hasNextLine())
    {
    n = input.nextLine();
    String[] name = name  = n.split(" ");
    Real_Name = name[0];
    Real_Numb = name[1];
    avg = name[2];
    System.out.println(Real_Name + "\t#" + Real_Numb + "\t average >>> " + avg);
    playerCt++;
    name = null;
  }
  }
catch(ArrayIndexOutOfBoundsException tester)
{
    System.out.println("");
     } 
}
public Player[] getPlayersIndex(int i){
System.out.println(players[i].toString());
System.out.println(players.length);
return players;
}
public void addPlayer(Player p, int index, Player arr[])
   {
       int x;
       x = players.length+1;
       Player newarr[] = new Player[x];
       players = new Player[x];
       for(int i =0; i<x;i++)
       {
           newarr[i] = arr[i];
           newarr[x] = p;
        }
       System.out.println(Arrays.toString(newarr));
    }

}
