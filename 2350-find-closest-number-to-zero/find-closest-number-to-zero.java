class Solution {
    public int findClosestNumber(int[] nums) {
        int neg_max = Integer.MIN_VALUE;
        int pos_min = Integer.MAX_VALUE;
        for (int i : nums) {
            if (i >= 0)
                pos_min = Math.min(pos_min, i);
            else if (i < 0) 
                neg_max = Math.max(neg_max, i);
        }
        if (pos_min == 0 || neg_max == Integer.MIN_VALUE)
            return pos_min;

        if (pos_min == Math.abs(neg_max))
            return pos_min;
        else if (pos_min < Math.abs(neg_max))
            return pos_min;
        return neg_max;
    }
}