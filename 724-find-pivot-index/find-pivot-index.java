class Solution {
    public int pivotIndex(int[] nums) {
        if (nums.length == 0)
            return -1;
        int left = 0, right = 0;
        for (int n : nums)
            right += n;
        
        for (int i = 0; i < nums.length; i++){
            right -= nums[i];
            if (left == right)
                return i;
            left += nums[i];
        }
        return -1;
    }
}