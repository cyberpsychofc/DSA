class Solution {
    public int countHillValley(int[] nums) {
        int pointer = 1, count = 0;
        int hillsOrValleys = 0;
        for (int i = 1; i < nums.length; i++){
            if (nums[i] == nums[i - 1]) {
                count++;
                continue;
            }
            else {
                nums[pointer++] = nums[i];
            }
        }
        for (int i = 1; i < nums.length - (count  + 1); i++) {
            if ((nums[i - 1] < nums[i] && nums[i] > nums[i + 1]) || (nums[i] < nums[i - 1] && nums[i] < nums[i + 1]))
                hillsOrValleys++;
        }
        return hillsOrValleys;
    }
}