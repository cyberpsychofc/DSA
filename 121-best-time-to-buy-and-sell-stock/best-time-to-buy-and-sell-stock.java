class Solution {
    public int maxProfit(int[] prices) {
        int max_profit = 0;
        int min_price = Integer.MAX_VALUE;

        for (int i : prices){
            min_price = Math.min(min_price, i);
            max_profit = Math.max(max_profit, i - min_price);
        }
        return max_profit;
    }
}