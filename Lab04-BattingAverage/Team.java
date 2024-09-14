

public class Team 
{
   static Player[] players;
   public Team()
    {
        players = new Player[9];
    }
   public void append(int p)
   {
       players = new Player[p];
    }
   public Team(int numPlayers)
    {
        players = new Player[numPlayers];
    }
   public int returnPlayer(int i)
   {
       players = new Player[i];
       return i;
    }
    
   
   public void printTeamStats()
    { 
        for(int i = 0; i < players.length; i++)
        {
            System.out.println(players[i].getName(i));
            System.out.println(players[i].getNumber(i));
            System.out.println(players[i].getBattingAverage());
        }
    }
}
