

public class Player extends Team 
{
    private static String name;
    private static int number;
    private int atBats = 0;
    private int hits = 0;
    private static String Avg = " ";
    public Player(String pName, int pNum)
    {
        name = pName;
        number = pNum;
    }
    public Player()
    {
    }
    public Player(String pName, int pNum, int atB, int pHit)
    {
        name = pName;
        number = pNum;
        atBats = atB;
        hits = pHit;
    }
    
    public double getBattingAverage()
    {
        double x = (double) hits/atBats;
        x = x*1000;
        x = Math.round(x);
        return x;
    }
    public static String getName(int i)
    {
        return players[i].name;
    }
    public static int getLength()
    {
        return players.length;
    }
    public static int getNumber(int i)
    {
        return players[i].number;
    }
    
    public String toString()
    {
        return("Name: " + name + " Number: " + number + " AtBats: " + atBats + " Hits: " + hits);
    }
    public String getBattingAverageString(int i)
    {
        String bAvg = "";
        double b = Math.round(getBattingAverage());
        b = b*100;
        bAvg = "Batting Average" + b;
        bAvg = Avg;
        return players[i].Avg;
    }
    
}
