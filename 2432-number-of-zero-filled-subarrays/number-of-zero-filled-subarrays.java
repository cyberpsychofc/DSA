class Solution {
    public long zeroFilledSubarray(int[] nums) {
        long total = 0;
        long size = 0;
        for (int i : nums){
            if (i == 0){
                size++;
                total += size;
            }
            else {
                size = 0;
            }
        }
        return total;
    }
}