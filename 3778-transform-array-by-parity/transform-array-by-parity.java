class Solution {
    public int[] transformArray(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
                nums[i] = nums[i] & 1;
        }
        Arrays.sort(nums);
        return nums;
    }
}