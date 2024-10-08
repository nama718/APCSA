
import java.awt.Color;
import java.awt.Graphics;
import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;
import java.util.*;
import java.io.*;
public class MapIllustrator
{
/** the 2D array containing the elevations */
private static int[][] grid;
private int rows;
private int cols;
private int max = Integer.MIN_VALUE;
private int min  = Integer.MAX_VALUE;

/** constructor, parses input from the file into grid */
public MapIllustrator(String fileName)
{
   try{
   Scanner scan = new Scanner(new File(fileName));
   rows = scan.nextInt();
   cols = scan.nextInt();
   grid = new int[rows][cols];
   for(int r = 0; r < rows; r++){
       for(int c = 0; c < cols; c++) {
           grid[r][c] = scan.nextInt();
           if(grid[r][c]<min)
           min = grid[r][c];
           if(grid[r][c] > max)
           max = grid[r][c];
          }
      }
  }catch(FileNotFoundException e){
      e.printStackTrace();
  }
}

/** @return the min value in the entire grid */
public int findMin()
{
return min;
}

/** @return the max value in the entire grid */
public int findMax()
{
return max;
}

/**
* Draws the grid using the given Graphics object.
* Colors should be grayscale values 0-255, scaled based on min/max values in grid
*/
public void drawMap(Graphics g)
{
for(int r = 0; r < grid.length;r++)
{
    for(int c = 0; c < grid[0].length; c++)
    {
        int color = 255 * (grid[r][c] - min)/(max- min);
        g.setColor(new Color(color, color, color));
        g.drawRect(c, r, 1, 1);
    }
}
}

/**
* Find a path from West-to-East starting at given row.
* Choose a forward step out of 3 possible forward locations, using greedy method described in assignment.
* @return the total change in elevation traveled from West-to-East
*/
public int drawPath(Graphics g, int row)
{
int elevChange = 0;
int r = row;
int c = 0;
while(c < cols - 1)
{

    g.drawRect(c,r,1,1);

    int up = Integer.MAX_VALUE;
    if(r - 1>= 0)
        up = grid[r][c+1];
    int fwd = grid[r][c+1];
    int down = Integer.MAX_VALUE;
    if(r+1<grid.length)
        down = grid[+1][c+1];
       
    int diffUp = Math.abs(grid[r][c] -up);
    int diffFwd = Math.abs(grid[r][c] - fwd);
    int diffDown = Math.abs(grid[r][c] - down);
   
    if(diffUp < diffFwd && diffUp < diffDown)
    {
        elevChange+= diffUp;
        r = r-1;
    }
    if(diffFwd < diffUp & diffFwd < diffDown)
    {
        elevChange += diffFwd;
    }
    if(diffDown < diffUp && diffDown < diffFwd)
    {
        elevChange += diffDown;
        r = r + 1;
    }
    if(diffFwd == diffUp && diffFwd <= diffDown)
    {
        elevChange += diffFwd;
    }
    if(diffFwd == diffDown && diffFwd <= diffUp)
    {
        elevChange += diffFwd;
    }
    if(diffUp == diffDown && diffUp < diffFwd)
    {if(Math.random() < .5)
        {
            elevChange += diffUp;
            r = r-1;
        }
        else{
            elevChange += diffDown;
            r = r+1;
        }
       
    }
    c++;
}
g.drawRect(c,r,1,1);
return elevChange;
}

/** @return the index of the starting row for the lowest-elevation-change path in the entire grid. */
public int getIndexOfLowestPath(Graphics g)
{
int bestRow = 0;
int lowestElevChange = Integer.MAX_VALUE;
for(int r = 0; r < grid.length; r++)
{
    int eleveCh = drawPath(g, r);
    if(eleveCh < lowestElevChange)
    {
        lowestElevChange = eleveCh;
        bestRow = r;
    }
}

return bestRow;
}

/** return the number of rows in grid */
public int getRows()
{

return rows;
}

/** return the number of columns in grid (assumed rectangular) */
public int getCols()
{

return cols;
}
}
