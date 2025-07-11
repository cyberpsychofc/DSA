class Solution {
    public int jump(int[] nums) {
        int n = nums.length;
        int [] dp = new int[n];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[n - 1] = 0;
        for (int i = n - 2; i >= 0; i--){
            for(int j = i + 1; j < n && j <= i + nums[i]; j++){
                if (dp[j] != Integer.MAX_VALUE)
                    dp[i] = Math.min(dp[i], dp[j] + 1); 
            }
        }
        return dp[0];
    }
}