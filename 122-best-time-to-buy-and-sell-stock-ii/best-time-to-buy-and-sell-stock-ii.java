class Solution {
    public int maxProfit(int[] prices) {
        int[][] dp = new int[prices.length + 1][2];
        for (int[] row : dp)
            Arrays.fill(row, -1);

        // base condition
        dp[prices.length][0] = 0;
        dp[prices.length][1] = 0;

        int profit = 0;

        for (int i = prices.length - 1 ; i >= 0; i-- ){
            for (int buy = 0; buy <= 1; buy++) {
                if (buy == 0)
                    profit = Math.max(0 + dp[i + 1][0], -prices[i] + dp[i + 1][1]);
                if (buy == 1)
                    profit = Math.max(0 + dp[i + 1][1], prices[i] + dp[i + 1][0]);
                dp[i][buy] = profit;

            }
        }
        return dp[0][0];
    }
}