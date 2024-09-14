

public class TwoDRunner 
{
    public static void main(String[] args)
    {
        TwoDArrayProbs test = new TwoDArrayProbs(new int[][]{{1, 2}, {10, 11}});
        System.out.println(test.sum());
        TwoDArrayProbs test1 = new TwoDArrayProbs(new int[][]{{2,3,1}, {5,4,6}});
        System.out.println(test1.isSquare());
        new TwoDArrayProbs(new int[][]{{1,2,3}, {3,2,1}}).addMatrix(new int[][]{{2,3,1}, {3,1,2}});
        TwoDArrayProbs test2 = new TwoDArrayProbs(new int[][] {{1,2,3},{4,5,6}});
        System.out.println(" ");
        System.out.println(test2.columnSum(2));
        TwoDArrayProbs test3 = new TwoDArrayProbs(new int[][] {{1, 2, 3},{1,0,0},{2, 2, 1}});
        System.out.println(test3.isColumnMagic());
        TwoDArrayProbs test4 = new TwoDArrayProbs();
        System.out.println(test4.diagDifference());
    }
}
    
    

