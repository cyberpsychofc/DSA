class Solution {
    public boolean canJump(int[] nums) {
        int end = nums.length - 1;
        int i = end - 1;
        while (i >= 0){
            if (nums[i] + i >= end)
                end = i;
            i--;
        }
        return end == 0;
    }
}