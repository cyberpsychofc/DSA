class Solution {
    public int longestPalindromeSubseq(String s) {
        String t = new StringBuilder(s).reverse().toString();
        int x = s.length();
        int dp[][] = new int[x + 1][x + 1];
        for (int i = 1; i <= x; i++) {
            for (int j = 1; j <= x; j++) {
                if (s.charAt(i - 1) == t.charAt(j - 1))
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                else
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
            }
        }
        return dp[x][x];
    }
}