class Solution {
    public static int helper(Map<Integer, Integer> memo, int x){
        if (memo.containsKey(x))
            return memo.get(x);
        else{
            int term = helper(memo, x - 1) + helper(memo, x - 2);
            memo.put(x, term);
        }
        return helper(memo, x);
    }
    public int fib(int n) {
        Map<Integer, Integer> memo = new HashMap<>();
        memo.put(0,0);
        memo.put(1,1);
        return helper(memo, n);
    }
}