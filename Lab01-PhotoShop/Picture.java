import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JFileChooser;
import javax.swing.UIManager;
import java.awt.*;
import java.awt.font.*;
import java.awt.geom.*;
import java.text.*;
import java.util.*;
import java.util.List; 
import java.io.*;
import java.lang.reflect.Array;

/**
 * A class that represents a picture made up of a rectangle of {@link Pixel}s
 */
public class Picture {

    /** The 2D array of pixels that comprise this picture */
	private Pixel[][] pixels;

    /**
     * Creates a Picture from an image file in the "images" directory
     * @param picture The name of the file to load
     */
    public Picture(String picture) {
        File file = new File("./images/"+picture);
        BufferedImage image;
        if (!file.exists()) throw new RuntimeException("No picture at the location "+file.getPath()+"!");
        try {
            image = ImageIO.read(file);
        } catch (IOException e) {
            throw new RuntimeException(e.getMessage());
        }
        pixels = new Pixel[image.getHeight()][image.getWidth()];
        for (int y = 0; y<pixels.length; y++) {
            for (int x = 0; x<pixels[y].length; x++) {
                int rgb = image.getRGB(x, y);
                /*
                 * For the curious - BufferedImage saves an image's RGB info into a hexadecimal integer
                 * The below extracts the individual values using bit-shifting and bit-wise ANDing with all 1's
                 */
                pixels[y][x] = new Pixel((rgb>>16)&0xff, (rgb>>8)&0xff, rgb&0xff);
            }
        }
    }

    /**
     * Creates a solid-color Picture of a given color, width, and height
     * @param red The red value of the color
     * @param green The green value of the color
     * @param blue The blue value of the color
     * @param height The height of the Picture
     * @param width The width of the Picture
     */
    public Picture(int red, int green, int blue, int height, int width) {
        pixels = new Pixel[height][width];
        for (int y = 0; y<pixels.length; y++) {
            for (int x = 0; x<pixels[y].length; x++) {
                pixels[y][x] = new Pixel(red, green, blue);
            }
        }
    }

    /**
     * Creates a solid white Picture of a given width and height
     * @param color The {@link Color} of the Picture
     * @param height The height of the Picture
     * @param width The width of the Picture
     */
    public Picture(int height, int width) {
        this(Color.WHITE, height, width);
    }

    /**
     * Creates a solid-color Picture of a given color, width, and height
     * @param color The {@link Color} of the Picture
     * @param width The width of the Picture
     * @param height The height of the Picture
     */
    public Picture(Color color, int height, int width) {
        this(color.getRed(), color.getGreen(), color.getBlue(), height, width);
    }

    /**
     * Creates a Picture based off of an existing {@link Pixel} 2D array
     * @param pixels A rectangular 2D array of {@link Pixel}s. Must be at least 1x1
     */
    public Picture(Pixel[][] pixels) {
        if (pixels.length==0 || pixels[0].length==0) throw new RuntimeException("Can't have an empty image!");
        int width = pixels[0].length;
        for (int i = 0; i<pixels.length; i++) if (pixels[i].length!=width)
            throw new RuntimeException("Pictures must be rectangles. pixels[0].length!=pixels["+i+"].length!");
        this.pixels = new Pixel[pixels.length][width];
        for (int i = 0; i<pixels.length; i++) {
            for (int j = 0; j<pixels[i].length; j++) {
                this.pixels[i][j] = new Pixel(pixels[i][j].getColor());
            }
        }
    }

    /**
     * Creates a Picture based off of an existing Picture
     * @param picture The Picture to copy
     */
    public Picture(Picture picture) {
        this(picture.pixels);
    }

    /**
     * Gets the width of the Picture
     * @return The width of the Picture
     */
    public int getWidth() {
        return pixels[0].length;
    }

    /**
     * Gets the height of the Picture
     * @return The height of the Picture
     */
    public int getHeight() {
        return pixels.length;
    }

    /**
     * Gets the {@link Pixel} at a given coordinate
     * @param x The x location of the {@link Pixel}
     * @param y The y location of the {@link Pixel}
     * @return The {@link Pixel} at the given location
     */
    public Pixel getPixel(int x, int y) {
        if (x>=getWidth() || y>=getHeight() || x<0 || y<0) throw new RuntimeException("No pixel at ("+x+", "+y+")");
        return pixels[y][x];
    }

    /**
     * Sets the {@link Pixel} at a given coordinate
     * @param x The x location of the {@link Pixel}
     * @param y The y location of the {@link Pixel}
     * @param pixel The new {@link Pixel}
     */
    public void setPixel(int x, int y, Pixel pixel) {
        if (x>=getWidth() || y>=getHeight() || x<0 || y<0) throw new RuntimeException("No pixel at ("+x+", "+y+")");
        if (pixel==null) throw new NullPointerException("Pixel is null"); //guard is required because pixel's value isn't used in this method
        pixels[y][x] = pixel;
    }

    /**
     * Opens a {@link PictureViewer} to view this Picture
     * @return the {@link PictureViewer} viewing the Picture
     */
    public PictureViewer view() {
        return new PictureViewer(this);
    }

	/**
	 * Save the image on disk as a JPEG
	 * Call programmatically on a Picture object, it will prompt you to choose a save location
	 * In the save dialogue window, specify the file AND extension (e.g. "lilies.jpg")
	 * Extension must be .jpg as ImageIO is expecting to write a jpeg
	 */
	public void save()
	{
		try {
	        UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
	    } 
		catch(Exception e) {
	        e.printStackTrace();
	    }
		
		BufferedImage image = new BufferedImage(this.pixels[0].length, this.pixels.length, BufferedImage.TYPE_INT_RGB);

		for (int r = 0; r < this.pixels.length; r++)
			for (int c = 0; c < this.pixels[0].length; c++)
				image.setRGB(c, r, this.pixels[r][c].getColor().getRGB());

		//user's Desktop will be default directory location
		JFileChooser chooser = new JFileChooser(System.getProperty("user.home") + "/Desktop");

		chooser.setDialogTitle("Select picture save location / file name");

		File file = null;

		int choice = chooser.showSaveDialog(null);

		if (choice == JFileChooser.APPROVE_OPTION)
			file = chooser.getSelectedFile();

		//append extension if user didn't read save instructions
		if (!file.getName().endsWith(".jpg") && !file.getName().endsWith(".JPG") && !file.getName().endsWith(".jpeg") && !file.getName().endsWith(".JPEG"))
			file = new File(file.getAbsolutePath() + ".jpg");
		
		try {
			ImageIO.write(image, "jpg", file);
			System.out.println("File created at " + file.getAbsolutePath());
		}
		catch (IOException e) {
			System.out.println("Can't write to location: " + file.toString());
		}
		catch (NullPointerException|IllegalArgumentException e) {
			System.out.println("Invalid directory choice");
		}
	}
	
	/** return a copy of the reference to the 2D array of pixels that comprise this picture */
	public Pixel[][] getPixels() {
		return pixels;
	}


    /********************************************************
     *************** STUDENT METHODS BELOW ******************
     ********************************************************/

    /** remove all blue tint from a picture */
    public void zeroBlue()
    {
    	
        for (int i = 0; i<pixels.length; i++) {
            for (int j = 0; j<pixels[i].length; j++) {
                this.pixels[i][j] = new Pixel(pixels[i][j].getRed(),pixels[i][j].getGreen(),0);
            }
        }
    }

    /** remove everything BUT blue tint from a picture */
    public void keepOnlyBlue()
    {
    	for (int i = 0; i<pixels.length; i++) {
            for (int j = 0; j<pixels[i].length; j++) {
                this.pixels[i][j] = new Pixel(0,0,pixels[i][j].getBlue());
            }
        }
    }

    /** invert a picture's colors */
    public void negate()
    {
    	
        
        for ( Pixel[] rowArray : pixels )
        {
            for ( Pixel b : rowArray )
            {
                b.setRed( 255 - b.getRed() );
                b.setGreen( 255 - b.getGreen());
                b.setBlue( 255 - b.getBlue());
            }
        }
    }
    

    /** simulate the over-exposure of a picture in film processing */
    public void solarize(int threshold)
    {
    	for(int i = 0; i < getWidth(); i++){
           
            for(int m = 0; m < getHeight(); m++)
            {
                if(pixels[m][i].getRed() < threshold && pixels[m][i].getRed() > 0)
                {
                    pixels[m][i] = new Pixel(255 - pixels[m][i].getRed(), pixels[m][i].getGreen(), pixels[m][i].getBlue());
                   }
                if(pixels[m][i].getGreen() < threshold && pixels[m][i].getGreen() > 0)
                {
                    pixels[m][i] = new Pixel(pixels[m][i].getRed(), 255 - pixels[m][i].getGreen(), pixels[m][i].getBlue());
                   }
                   if(pixels[m][i].getBlue() < threshold && pixels[m][i].getBlue() > 0)
                {
                    pixels[m][i] = new Pixel(pixels[m][i].getRed(), pixels[m][i].getGreen(), 255 - pixels[m][i].getBlue());
                   }
               
               }
           
           }
    }

    /** convert an image to grayscale */
    public void grayscale()
    {
    	
        for ( Pixel[] rowArray : pixels )
        {
            for ( Pixel b : rowArray )
            {
                int avg = (int)( ( b.getRed() + b.getGreen() + b.getBlue() ) / 3 );
                b.setRed( avg );
                b.setBlue( avg );
                b.setGreen( avg );
            }
        }
    }

	/** change the tint of the picture by the supplied coefficients */
	public void tint(double red, double blue, double green)
	{
	  for ( Pixel[] rowArray : pixels )
        {
            for ( Pixel b : rowArray )
            {
                int r = (int)( ( b.getRed() * red));
                int g = (int)( ( b.getGreen() * green));
                int bl = (int)( ( b.getBlue() * blue));
                if(r < 225 & g < 225 & bl < 225)
                {
                    
                   
                b.setRed(r);
                b.setBlue(bl);
                b.setGreen(g);
            }
            else
            {
                g = 225;
                b.setRed(r);
                b.setBlue(bl);
                b.setGreen(g);
            }
            }
        }
      }
	
	/** reduces the number of colors in an image to create a "graphic poster" effect */
	public void posterize(int span)
	{
	    Pixel c = new Pixel();
	    int r = c.getRed()*span;
            int g = c.getGreen()*span;   
            int bl = c.getBlue()*span;
            for (int i = 0; i<pixels.length; i++) {
            for (int j = 0; j<pixels[i].length; j++) {
                this.pixels[i][j] = new Pixel((pixels[i][j].getRed()*span)/span,(pixels[i][j].getGreen()*span)/span,(pixels[i][j].getBlue()*span)/span);
            }
        }
		
	}

    /** mirror an image about a vertical midline, left to right */
    public void mirrorVertical()
    {
		Pixel leftPixel  = null;
		Pixel rightPixel = null;

		int width = pixels[0].length;

		for (int r = 0; r < pixels.length; r++)
		{
			for (int c = 0; c < width / 2; c++)
			{
				leftPixel  = pixels[r][c];
				rightPixel = pixels[r][(width - 1) - c];

				rightPixel.setColor(leftPixel.getColor());
			}
		}
    }

    /** mirror about a vertical midline, right to left */
    public void mirrorRightToLeft()
    {
    	
        Pixel leftPixel  = null;
        Pixel rightPixel = null;

        int width = pixels[0].length;

        for (int r = 0; r < pixels.length; r++)
        {
            for (int c = width/2; c < width ; c++)
            {
            rightPixel  = pixels[r][c];
            leftPixel = pixels[r][(width + 1) - c];
            leftPixel.setColor(rightPixel.getColor());
            }
        }
    }

    /** mirror about a horizontal midline, top to bottom */
    public void mirrorHorizontal()
    {
        Pixel topPixel = null;
        Pixel bottomPixel = null;
        int height = pixels.length;
    	for (int i = 0; i<pixels.length; i++) {
            for (int j = 0; j<pixels[i].length; j++) {
                topPixel = pixels[i][j];
                bottomPixel = pixels[height - 1 - i][j];
                topPixel.setColor( bottomPixel.getColor() );
            }
        }
    }

    /** flip an image upside down about its bottom edge */
    public void verticalFlip()
    {
    	
        Pixel upPixel  = null;
        Pixel downPixel = null;

        int height = pixels.length;
        int width = pixels[0].length;
        for (int r = 0; r < pixels.length/2; r++)
        {
            for (int c = 0; c < pixels[0].length; c++)
            {
            upPixel  = pixels[r][c];
            downPixel = pixels[height-r-1][c];
            Color x = upPixel.getColor();
            upPixel.setColor(downPixel.getColor());
            downPixel.setColor(x);
            x = null;
            }
        }
    
    
    }

    /** fix roof on greek temple */
    public void fixRoof()
    {
    int Point = 276;
    Pixel leftPixel = null;
    Pixel rightPixel = null;
    int count = 0;
   
    
    
    for (int i = 27; i < 97; i++)
    {
      
      for (int j = 13; j < Point; j++)
      {
        
        leftPixel = pixels[i][j];      
        rightPixel = pixels[i]                       
        [Point - j + Point];
        rightPixel.setColor(leftPixel.getColor());
      }
    }
    }
        public void edgeDetection(int dist)
        {
        Pixel p = new Pixel();
         Pixel leftPixel = null;
        Pixel rightPixel = null;
        Pixel[][] pixels = this.getPixels();
        Color rightColor = null;
        for ( int row = 0; row < pixels.length; row++ )
        {
            for ( int col = 0; col < pixels[0].length - 1; col++ )
            {
                leftPixel = pixels[row][col];
                rightPixel = pixels[row][col + 1];
                rightColor = rightPixel.getColor();
                if ( leftPixel.colorDistance( rightColor ) > dist )
                {
                    leftPixel.setColor( Color.BLACK );
                }
                else
                {
                    leftPixel.setColor( Color.WHITE );
                }
            }
        }
        }

	/** copy another picture's pixels into this picture, if a color is within dist of param Color */
	public void chromakey(Picture other, Color color, int dist)
	{
		
        Pixel fromPixel = null;
        Pixel toPixel = null;
        Pixel[][] toPixels = this.getPixels();
        Pixel[][] fromPixels = other.getPixels();
        for ( int row = 0; row < this.getHeight(); row++ )
        {
            for ( int col = 0; col < this.getWidth(); col++ )
            {
                toPixel = toPixels[row][col];
                if ( toPixel.getBlue() > toPixel.getRed() )
                {
                    fromPixel = fromPixels[row][col];
                    toPixel.setColor( fromPixel.getColor() );
                }
            }
        }
	}

	/** steganography encode (hide the message in msg in this picture) */
	public void encode(Picture msg)
	 {
	     Pixel[][] m = msg.getPixels();
        Pixel[][] cp = this.getPixels();
        Pixel c = null;
        Pixel message = null;
        int count = 0;
        for ( int row = 0; row < this.getHeight(); row++ )
        {
            for ( int col = 0; col < this.getWidth(); col++ )
            {
                
                c = cp[row][col];
                if ( c.getRed() % 2 == 1 )
                    c.setRed( c.getRed() - 1 );
                message = m[row][col];
                if ( message.colorDistance( Color.BLACK ) < 50 )
                {
                    c.setRed( c.getRed() + 1 );
                    count++;
                }
            }
        }
        System.out.println(count);
	}

	/** steganography decode (return a new Picture containing the message hidden in this picture) */
	public Picture decode()
	{
		 
        int height = this.getHeight();
        int width = this.getWidth();
        Pixel c = null;
        Pixel m = null;
        Picture message = new Picture( height, width );
        Pixel[][] mPixel = message.getPixels();
        int count = 0;
        for ( int row = 0; row < this.getHeight(); row++ )
        {
            for ( int col = 0; col < this.getWidth(); col++ )
            {
                c = pixels[row][col];
                m = mPixel[row][col];
                if (c.getRed() % 2 == 1 )
                {
                    m.setColor( Color.BLACK );
                    count++;
                }
            }
        }
        System.out.println( count );
        return message;

		
	}

	/** perform a simple blur using the colors of neighboring pixels */
	public void simpleBlur()
	{
	
	Picture beach = new Picture(this);
	Pixel[][] copyPixels = beach.getPixels();
	Pixel[][] pixels = this.getPixels();
	Pixel leftPixel = null;
	Pixel rightPixel = null;
	
	int width = pixels[0].length;
	int length = pixels.length;
	 for(int row = 1; row < pixels.length-1; row++)
	{
	    for (int col = 1; col < width-1; col++)
	    {
	        ArrayList<Pixel> pixelGroup = new ArrayList<Pixel>();
	        pixelGroup.add(pixels[row+1][col+1]);
	        pixelGroup.add(pixels[row+1][col]);
	        pixelGroup.add(pixels[row+1][col-1]);
	        pixelGroup.add(pixels[row][col+1]);
	        pixelGroup.add(pixels[row-1][col+1]);
	        pixelGroup.add(pixels[row][col]);
	        pixelGroup.add(pixels[row-1][col]);
	        pixelGroup.add(pixels[row][col-1]);
	        pixelGroup.add(pixels[row-1][col-1]);
	        
	        int r=0,b=0,g=0;
	        for(Pixel bPixel :pixelGroup)
	        {
	            r = r + bPixel.getRed();
	            b = b + bPixel.getBlue();
	            g = g + bPixel.getGreen();
	           }
	        int size = pixelGroup.size();
	        r = (10*(r/pixelGroup.size()) + pixels[row][col].getRed())/11;
	        b = (10*(b/pixelGroup.size()) + pixels[row][col].getBlue())/11;
	        g = (10*(g/pixelGroup.size()) + pixels[row][col].getGreen())/11;
	        Color newColor = new Color(r,g,b);
	        
	        copyPixels[row][col].setColor(newColor);
	       }
	     }
	    for(int row = 1; row < pixels.length-1;row++)
	    {
	        for(int col = 1; col < width-1; col++)
	        pixels[row][col].setColor(copyPixels[row][col].getColor());
	       }
	
	}

	/** perform a blur using the colors of pixels within radius of current pixel */
	public Picture blur(int radius)
	{
		//TODO
        Picture beach = new Picture(this);
	Pixel[][] copyPixels = beach.getPixels();
	Pixel[][] pixels = this.getPixels();
	Pixel leftPixel = null;
	Pixel rightPixel = null;
	
	int width = pixels[0].length;
	int length = pixels.length;
	 for(int row = 1; row < pixels.length-1; row++)
	{
	    for (int col = 1; col < width-1; col++)
	    {
	        ArrayList<Pixel> pixelGroup = new ArrayList<Pixel>();
	        pixelGroup.add(pixels[radius+1][col+1]);
	        pixelGroup.add(pixels[radius+1][col]);
	        pixelGroup.add(pixels[radius+1][col-1]);
	        pixelGroup.add(pixels[radius][col+1]);
	        pixelGroup.add(pixels[radius-1][col+1]);
	        pixelGroup.add(pixels[radius][col]);
	        pixelGroup.add(pixels[radius-1][col]);
	        pixelGroup.add(pixels[radius][col-1]);
	        pixelGroup.add(pixels[radius-1][col-1]);
	        
	        int r=0,b=0,g=0;
	        for(Pixel bPixel :pixelGroup)
	        {
	            r = r + bPixel.getRed();
	            b = b + bPixel.getBlue();
	            g = g + bPixel.getGreen();
	           }
	        int size = pixelGroup.size();
	        r = (10*(r/pixelGroup.size()) + pixels[radius][col].getRed())/11;
	        b = (10*(b/pixelGroup.size()) + pixels[radius][col].getBlue())/11;
	        g = (10*(g/pixelGroup.size()) + pixels[radius][col].getGreen())/11;
	        Color newColor = new Color(r,g,b);
	        
	        copyPixels[row][col].setColor(newColor);
	       }
	     }
	    for(int row = 1; row < pixels.length-1;row++)
	    {
	        for(int col = 1; col < width-1; col++)
	        pixels[row][col].setColor(copyPixels[row][col].getColor());
	       }

		return null;
	}
	
	/**
	 * Simulate looking at an image through a pane of glass
	 * @param dist the "radius" of the neighboring pixels to use
	 * @return a new Picture with the glass filter applied
	 */
	 public Picture glassFilter(int dist) 
	{
	int width  = this.getWidth();
        int height = this.getHeight();
        Picture pic2 = new Picture(width, height);
        int XPOS = 0;
        int YPOS = 0;
        Pixel current = null;
        int DISTANCE = dist;
        Random r = new Random();
        try{
        for (int i = DISTANCE; i < width-DISTANCE-1; i++) {
            for (int j = DISTANCE; j < height-DISTANCE-1; j++) {
                int ii = r.nextInt(((DISTANCE+j)-(DISTANCE-j))+(DISTANCE-j));
                int jj = r.nextInt(((DISTANCE+i)-(DISTANCE-i))+(DISTANCE-i));
                pixels[ii][jj].setColor(pixels[i][j].getColor());
            }
        }
    }
    catch(ArrayIndexOutOfBoundsException e)
    {
       
        }
   
   
       
   
        return pic2;
	
	
    }
     public static int random(int a, int b) {
        return a + (int) (Math.random() * (b-a+1));
    }
    
    }
    

   

