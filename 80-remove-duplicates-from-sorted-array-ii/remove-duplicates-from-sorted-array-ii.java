class Solution {
    public int removeDuplicates(int[] nums) {
        int i = 0, j = 0;
        while (j < nums.length) {
            if (i < 2 || nums[j] != nums[i - 2]) {
                nums[i++] = nums[j];
            }
            j++;
        }
        return i;
    }
}