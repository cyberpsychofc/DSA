class Solution {
    public int helper(int amount, int[] coins, int[] dp) {
        if (amount == 0)
            return amount;
        
        int min = Integer.MAX_VALUE;

        for (int i = 0; i < coins.length; i++) {
            if (amount - coins[i] >= 0) {
                int subMin = 0;
                if (dp[amount - coins[i]] != -1)
                    subMin = dp[amount - coins[i]];
                else
                    subMin = helper(amount - coins[i], coins, dp);
                if (subMin != Integer.MAX_VALUE && subMin + 1 < min)
                    min = subMin + 1;
            }
        }
        dp[amount] = min;
        return min;
    }
    public int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, -1);
        dp[0] = 0;

        int ans = helper(amount, coins, dp);
        return (ans == Integer.MAX_VALUE) ? -1 : ans;
    }
}