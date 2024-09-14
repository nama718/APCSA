

public class SoundClip extends SoundTester

{
     double[] clip;
     
     public SoundClip(double[] c)
    {
        
        clip = c;
       
    }
    public SoundClip()
    {
    }
    
    public void nullSoundclip()
    {
        clip = null;
    }
    
    
    
    public void adjustVolume(double factor)
    {
         for (int i = 0; i < clip.length; i++)
         {
             clip[i] *= factor;
            }
    }
    public void mix(double[] clip1, double[] clip2)
    {
        clip = new double [6];
        int x = clip1.length;
        int y = clip2.length;
        clip = new double[y];
        int i = 0;
        while(i < clip.length)
        {
        for( i = 0; i<clip.length;i++)
        {
        clip[i] += clip1[i] + clip2[i];
        
    }
    }
    }
    
    public void append(double[] other)
    {
        double[] result;
        int a = other.length;
        result = new double [a+1];
        int i = 0;
        int j = 0;
        clip = result;
        int f = clip.length;
        int g = f+1;
        for (i = 0; i < clip.length; i++)
        {
            result[i] = clip[i];
            
        }
        for(i = 0; i <other.length; i++)
        {
            result[i] += other[i];
            g++;
        }
            
        
    }
    public void fadeIn(double seconds)
    {   
        Sound test = new Sound();
        int x = test.toNumSamples(seconds);
        SoundClip test1 = new SoundClip();
        for (int i = 0; i < clip.length; i++)
        {
            clip[i] *= i/x;
        }
        
    }
    public void fadeOut(double seconds)
    {
        Sound test = new Sound();
        int x = test.toNumSamples(seconds);
        SoundClip test1 = new SoundClip();
        for (int i = 0; i < clip.length; i++)
        {
            clip[i] /= i/x;
        }
    }
    public void reverse()
    {
        int y = clip.length-1;
        Sound test = new Sound();
        int x = test.toNumSamples(3);
        
        double[] clip2;
        clip2 = clip;
        
        
        
        
        
        SoundClip test1 = new SoundClip();
        for (int i = 0; i < clip.length; i ++)
        {
            clip[i] *= i/x;
        }
        
       
 
}

public void speedUp(double factor)
{
    Sound test = new Sound();
    int x = test.toNumSamples(factor);
    SoundClip test1 = new SoundClip();
    for (int i = 0; i < clip.length; i++)
         {
             clip[i+1]/= factor;
            }
}
}
