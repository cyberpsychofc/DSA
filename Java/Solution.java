import java.util.HashSet;
public class Solution {
    public static double[] merge(int[] num1, int[] num2) {

        int num1Length = num1.length;
        int num2Length = num2.length;

        double[] merged = new double[num1Length + num2Length];

        int num1Position, num2Position, mergedPosition;
        num1Position = num2Position = mergedPosition = 0;

        while(num1Position < num1Length && num2Position < num2Length) {
            if (num1[num1Position] < num2[num2Position]) {
                merged[mergedPosition++] = num1[num1Position++];
            } else {
                merged[mergedPosition++] = num2[num2Position++];
            }
        }

        while (num1Position < num1Length) {
            merged[mergedPosition++] = num1[num1Position++];
        }

        while (num2Position < num2Length) {
            merged[mergedPosition++] = num2[num2Position++];
        }

        return merged;
    }
    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        double[] merged = merge(nums1,nums2);
        double median;
        int size = merged.length;
        if(size%2 == 0)
            median = (merged[(size/2)-1] + merged[((size/2)+1)-1])/2;
        else
            median = merged[size/2];
        return median;
    }
    public static void main(String arg[]){
        int [] a = {1,3};
        int [] b = {2};
        System.out.print(findMedianSortedArrays(a,b));
    }
}
