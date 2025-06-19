class Solution {
    private static boolean[] counts = new boolean[100001];

    public int partitionArray(int[] nums, int k) {
        int min = nums[0];
        int max = nums[0];
        counts[nums[0]] = true;
        for (int i = 1; i < nums.length; i++) {
            counts[nums[i]] = true;
            if (min > nums[i]) {
                for (int j = nums[i] + 1; j < min; j++) {
                    counts[j] = false;
                }
                min = nums[i];
            } else if (max < nums[i]) {
                for (int j = max + 1; j < nums[i]; j++) {
                    counts[j] = false;
                }
                max = nums[i];
            }
        }
        int res = 1;
        for (int i = min + 1; i <= max; i++) {
            if (counts[i] && i - min > k) {
                res++;
                min = i;
            }
        }
        return res;
    }
}