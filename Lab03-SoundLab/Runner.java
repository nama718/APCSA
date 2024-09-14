
import java.util.Arrays;
public class Runner extends SoundLabProbs
{
    public static void main(String[] args)
    {
        SoundLabProbs test = new SoundLabProbs();
        int nums[] = {8,3,4,5,8};
        System.out.println(test.lastIndexOf(nums,8));
        int nums1[] = {8,3,5,7,2,4};
        System.out.println(test.range(nums1));
        int nums2[] = {4,8,6,1,5,9,4};
        System.out.println(test.minDifference(nums2));
        System.out.println(test.reverseWords("Hello world"));
        int bids[] = {1500,1600,2000,2500};
        System.out.println(test.priceIsRight(bids,1900));
        int nums3[] = {1,2,3,4};
        System.out.println(Arrays.toString(test.productExceptSelf(nums3)));
        //
        double[] clip = {0.5, 1, 0, -1};
        Sound.show(clip);
        Sound.play(clip);
        //
        clip= Sound.pureTone(3.0, 1.0);
        Sound.show(clip);
    }
}
