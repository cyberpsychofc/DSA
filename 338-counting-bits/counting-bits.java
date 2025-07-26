class Solution {
    public int[] countBits(int n) {
        int[] dp = new int[n + 1];
        int msb = 1;

        for (int i = 1; i <= n; i++) {
            if (msb << 1 == i)
                msb = i;
            dp[i] = dp[i - msb] + 1;
        }
        return dp;
    }
}