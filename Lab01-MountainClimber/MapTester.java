import java.awt.Color;
import java.awt.Graphics;

public class MapTester
{
    public static void main(String[] args)
    {        
        MapIllustrator map = new MapIllustrator("Colorado_480x480.txt");
        
        // construct DrawingPanel (the GUI that displays the map) - don't mess with this
        DrawingPanel panel = new DrawingPanel(map.getRows(), map.getCols());
        Graphics     g     = panel.getGraphics();
       map.drawMap(g);
       g.setColor(Color.red);
       System.out.println(map.drawPath(g,200));
       int bestRow = map.getIndexOfLowestPath(g);
       g.setColor(Color.green);
       System.out.println(map.drawPath(g,bestRow));
	
		 
    }
    
    /** test the drawPath method, find path starting at row 200 */
    public static void testDrawPath(MapIllustrator map, Graphics g) {
		map.drawMap(g); 
		
        g.setColor(Color.GREEN); 
        
        int totalChange = map.drawPath(g, 200); 
        
        System.out.println("Lowest-elevation-change path starting at row 200: " + totalChange); 
    }
    
    /** test the getIndexOfLowest method, which finds the overall best path / starting row */
    public static void testBestPath(MapIllustrator map, Graphics g) {
        g.setColor(Color.RED); 

        int bestRow = map.getIndexOfLowestPath(g); 
        
        g.setColor(Color.GREEN);
        
        int totalChange = map.drawPath(g, bestRow);
        
        System.out.println("Overall best lowest-elevation-change path at row: " + bestRow + ", total change of: " + totalChange);
    }
}