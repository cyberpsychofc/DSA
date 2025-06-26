class Solution {
    public int maxProfit(int[] prices) {
        int maxProfit = 0;
        int minPrice = prices[0];
        for (int i = 1; i < prices.length; i++){
            int currProfit = prices[i] - minPrice;
            maxProfit = Math.max(currProfit, maxProfit);
            minPrice = Math.min(minPrice, prices[i]);
        }
        return maxProfit;
    }
}