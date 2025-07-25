class Solution {
    public int maxSum(int[] nums) {
        Set<Integer> set = new HashSet<>();
        int max = Integer.MIN_VALUE, sum = 0;
        // remove duplicates
        for (int i : nums){
            set.add(i);
        }

        for (int i : set){
            max = Math.max(max, i);
            if(i > 0) {
                sum += i;
            }
        }
        if (sum == 0)
            sum = max;
        return sum;
    }
}