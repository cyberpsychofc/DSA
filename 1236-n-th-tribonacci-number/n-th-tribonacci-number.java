class Solution {
    public int tribo(int n, Map<Integer, Integer> memo){
        if (memo.containsKey(n))
            return memo.get(n);
        if (n == 0)
            return 0;
        if (n == 1 || n == 2)
            return 1;
        int ans = tribo(n - 1, memo) + tribo(n - 2, memo) + tribo(n - 3, memo);
        memo.put(n, ans);
        return ans;
    }
    public int tribonacci(int n) {
        Map<Integer, Integer> map = new HashMap<>();
        return tribo(n, map);
    }
}