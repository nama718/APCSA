
import java.awt.*;
import java.util.Random;
public class PictureTester 
{
    public static void main(String[] args) 
    {
    	//construct a Picture object from a jpg image on disk
    	//PUT YOUR TESTS HERE
        Picture beach = new Picture("beach.jpg"); 
        //beach.zeroBlue();
        //beach.view();
        //beach.keepOnlyBlue();
        //beach.view();
        //beach.negate();
        //beach.view();
        //beach.solarize(100);
        //beach.view();
        Pixel b = new Pixel();
        //beach.grayscale();
        //beach.view();
        //beach.tint(.5,1,2);
        //beach.view();
        //beach.posterize(63);
        //beach.view();
        //beach.mirrorRightToLeft();
        //beach.view();
        //beach.mirrorHorizontal();
        //beach.view();
        //beach.verticalFlip();
        //beach.view();
        Picture temple = new Picture("temple.jpg"); 
        //temple.view();
        //temple.fixRoof();
        //temple.view();
        Picture swan = new Picture("swan.jpg");
        
        //swan.edgeDetection(2);
        //swan.view();
        //beach.view();
        //beach.simpleBlur();
        //beach.view();
        //int min = 1;
	//int max = 400;
        //Random random = new Random();
	//int value = random.nextInt(max + min) + min;
        //beach.blur(value);
        //beach.view();
        //beach.view();
        //beach.glassFilter(170);
        //beach.view();
    }
    
    
    
    
    /** this method is static, you don't need to call it on an object (just "testChromekey()") */
	public static void testChromakey()
	{
		Picture one = new Picture("blue-mark.jpg");
		Picture two = new Picture("moon-surface.jpg");
		
		one.view(); 
		two.view(); 
		
		one.chromakey(two, new Color(10, 40, 75), 60); 
		
		one.view();
	}
	
    /** this method is static, you don't need to call it on an object (just "testSteganography()") */
	public static void testSteganography()
	{
		Picture msg   = new Picture("msg.jpg");
		Picture beach = new Picture("beach.jpg");
		
		beach.encode(msg); 
		
		beach.decode().view(); 
	}
	
	
	
}
