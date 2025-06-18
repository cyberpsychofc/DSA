class Solution {
    public int helper(int m, int n, String s1, String s2, int[][] dp) {
        if (m == 0 || n == 0)
            return 0;
        if (dp[m][n] != -1)
            return dp[m][n];
        if (s1.charAt(m - 1) == s2.charAt(n - 1)) {
            dp[m][n] = 1 + helper(m - 1, n - 1, s1, s2, dp);
            return dp[m][n];
        }
        else {
            dp[m][n] = Math.max(helper(m, n - 1, s1, s2, dp), helper(m - 1, n, s1, s2, dp));
            return dp[m][n];
        }
    }
    public int longestCommonSubsequence(String text1, String text2) {
        int m = text1.length(), n = text2.length();
        int[][] dp = new int[m + 1][n + 1];
        for (int i = 1; i <= m; i++)
            for (int j =1; j <= n; j++)
                dp[i][j] = -1;
        return helper(m, n, text1, text2, dp);
    }
}