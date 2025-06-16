class Solution {
    public int maximumDifference(int[] nums) {
        int i = 0; 
        int max = -1;
        int minElement = nums[0];
        while (i < nums.length) {
            minElement = Math.min(minElement, nums[i]);
            if (nums[i] > minElement)
                max = Math.max(max, nums[i] - minElement);
            else
                minElement = nums[i];
            i++;
        }
        return max;
    }
}