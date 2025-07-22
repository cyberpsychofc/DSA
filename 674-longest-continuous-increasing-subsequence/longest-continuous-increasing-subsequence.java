class Solution {
    public int findLengthOfLCIS(int[] nums) {
        int i = 0, count = 0, countFinal = 1;

        while (i < nums.length - 1){
            if (nums[i] < nums[i + 1]) {
                count++;
                countFinal = Math.max(countFinal, count + 1);
            }
            else {
                count = 0;
            }
            i++;
        }
        return countFinal;
    }
}