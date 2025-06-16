class Solution {
    public int helper(int n, Map<Integer, Integer> memo){
        if (n == 0 || n == 1)
            return 1;
        if (memo.containsKey(n))
            return memo.get(n);
        int result = helper(n - 1, memo) + helper(n - 2, memo);
        memo.put(n, result);
        return result;
    }
    public int climbStairs(int n) {
        Map<Integer, Integer> memo = new HashMap<>();
        return helper(n, memo);
    }
}