class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int max = 0;
        int maxOnes = 0;
        for (int i = 0; i < nums.length; i++){
            if (nums[i] == 1){
                max++;
                maxOnes = Math.max(max, maxOnes);
                }
            else {
                max = 0;
            }
        }
        return maxOnes;
    }
}