class Solution {
    public double findMaxAverage(int[] nums, int k) {
        if (nums.length == 1)
            return (double) nums[0];

        int max = Integer.MIN_VALUE;

        int runningSum = 0;

        for (int i =0; i < nums.length; i++){
            runningSum += nums[i];

            if (i >= k - 1){
                // choose max
                max = Math.max(max, runningSum);
                // remove the element out of the window
                runningSum -= nums[i - (k - 1)];
            }
        }
        return (double) max / k;
    }
}