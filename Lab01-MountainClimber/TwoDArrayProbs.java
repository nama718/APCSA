import java.util.*;
import java.io.*;
public class TwoDArrayProbs 
{
    int[][] nums;
    public TwoDArrayProbs(int [][] n)
    {
        nums = n;
    }
    public TwoDArrayProbs()
    {
        
    }
    public int sum()
    {
        int s=0;
        for(int i = 0; i < nums.length; i++)
        {
         for (int j = 0; j < 2; j++)
        {
            s = s + nums[i][j];
        }
        }
        return s;
    }
    public boolean isSquare()
    {
        boolean isSquare = false;
        int row = nums.length;
        int column = nums[0].length;
        if(row == column)
        {
        isSquare = true;
    }
    return isSquare;
    }
    public void addMatrix(int[][] other)
    {
       for(int i = 0; i < nums.length; i++)
        {
         for (int j = 0; j < 3; j++)
        {
           nums[i][j] = nums[i][j] + other[i][j]; 
        }
        
        } 
       print();
    }
    private void print()
    {
        for (int i = 0; i < nums.length; i++)
 
            
            for (int j = 0; j < nums[i].length; j++)
                System.out.print("[ "+ nums[i][j] + " " + "]");
    }
    public int columnSum(int col)
    {
    
    int sum = 0;
    for (int r = 0; r < nums.length; r++)
      {
      sum += nums[r][col];
		}
    return sum;
	}
    
    public boolean isColumnMagic()
    {
      boolean Magic = false;
      int s1 = 0;
      int s2 = 0;
      int s3 = 0;
     for (int r = 0; r < nums.length; r++)
      {
      s1 += nums[r][0];
		}
    for (int r = 0; r < nums.length; r++)
      {
      s2 += nums[r][1];
		}
    for (int r = 0; r < nums.length; r++)
      {
      s3 += nums[r][2];
		}
    if(s1 == s2)
    {
        Magic = true;
    }
    if(s2 == s3)
    {
        Magic = true;
    }
      return Magic;
    }
    public static int diagDifference()
        {
            int [] [] nums = {{1, 2, 3},
                              {1, 2, 4},
                              {2, 2, 1}};
            int sum1 = 0;
            int sum2 = 0;
            int count = 0;
            for(int r = 0; r < nums.length; r++)
            {
                sum1 += nums[r][r];
            }
            for(int i = nums.length -1; i >= 0; i--)
            {
                sum2 += nums[i][count];
                count++;
            }
            return(Math.abs(sum1-sum2));
        }


    
    }
  

  
  
 
    

