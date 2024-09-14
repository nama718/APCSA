
public class SoundLabProbs
{
    public int lastIndexOf(int[] nums, int value)
    {
       
        for(int i = nums.length -1; i>= 0; i--)
        {
            if(nums[i] == value)
            {
                return i;
            }
        }
        
        
        return -1;
    }
    public int range(int[] nums1)
    {
        boolean range = false;
        boolean max  = false;
        boolean min = false;
        
        int x = nums1[0];
        for(int i = 1; i < nums1.length; i++)
         x = Math.min(x, nums1[i]);
        min = true;
        
        int y = nums1[0];
        for(int i = 1; i < nums1.length; i++)
         y = Math.max(y, nums1[i]);
        max = true;
        
        int leftover = y-x;
        range = true;
        
        if(range && max && min == true)
        {
        return leftover;
        }
        
        return 0;
        }
    public int minDifference(int[] nums2)
    {
        int count = 0;
        int min,sum,min1,min2;
        min1 = 0;
        min2 = 1;
        min = nums2[0] + nums2[1];
        
      for(int i = 0; i < nums2.length - 1; i++)
      {
        for(int j = i+1; j < nums2.length; j++)
        {
          sum = nums2[i] + nums2[j];
          if(Math.abs(min) > Math.abs(sum))
          {
            min = sum;
            min1 = i;
            min2 = j;
            
          }
        }
      }
       return nums2[min1] -2;
     
    }
    public String reverseWords(String str)
    {
        String split[] = str.split(" ");
        String reverse = "";
         for (int i = 0; i < split.length; i++) { 
            if (i == split.length - 1) 
                reverse = split[i] + reverse; 
            else
                reverse = " " + split[i] + reverse; 
        } 
 
        return reverse;
    }
    public int priceIsRight(int[] bids, int price)
    {
        int count = 0;
        for (int i =0; i< bids.length; i++)
        {
            
            if (bids[i] <= price)
            {
                while (i < bids.length)
                {
                if(bids[i+1] > bids[i])
                
                return bids[i+1];
                } 
            }
        }
        
        return price;
    }
    public int[] productExceptSelf(int[] nums3)
    {
        int result[];
        int product = 1;
        result = new int[4];
        int count = 0;
        int i = 0;
        while (i < nums3.length)
        {
        for( i = 0; i <nums3.length; i++)
        {
            product = nums3[1] * nums3[2] * nums3[3];
            result[0] = product;
            count++;
        }
        for( i = 0; i <nums3.length; i++)
        {
            product = nums3[0] * nums3[2] * nums3[3];
            result[1] = product;
            count++;
        }
        for( i = 0; i <nums3.length; i++)
        {
            product = nums3[0] * nums3[1] * nums3[3];
            result[2] = product;
            count++;
        }
        for( i = 0; i <nums3.length; i++)
        {
            product = nums3[0] * nums3[1] * nums3[2];
            result[3] = product;
            count++;
        }
    }
        return result;
    }

    
    
}
