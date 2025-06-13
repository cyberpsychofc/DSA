class Solution {
    private int validPairs(int[] nums, int thres){
        int index =0, count = 0;

        while (index < nums.length - 1){
            if (nums[index + 1] - nums[index] <= thres) {
                count++;
                index++;
            } index++;
        }
        return count;
    }
    public int minimizeMax(int[] nums, int p) {
        Arrays.sort(nums);

        int n = nums.length;
        int left = 0, right = nums[n - 1] - nums[0];

        while (left < right) {
            int mid = left + (right - left) / 2;

            if (validPairs(nums, mid) >= p)
                right = mid;
            else
                left = mid + 1;
        }
        return left;
    }
}