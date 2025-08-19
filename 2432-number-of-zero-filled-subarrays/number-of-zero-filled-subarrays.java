class Solution {
    public long zeroFilledSubarray(int[] nums) {
        long total = 0;
        long size = 0;
        for (int i : nums){
            if (i == 0)
                size++;
            else {
                total += size * (size + 1) / 2;
                size = 0;
            }
        }
        total += size * (size + 1) / 2;
        return total;
    }
}