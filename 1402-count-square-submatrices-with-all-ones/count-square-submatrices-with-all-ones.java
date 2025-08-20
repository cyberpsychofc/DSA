class Solution {
    public int countSquares(int[][] matrix) {
        int m = matrix.length, n = matrix[0].length, sum = 0;
        int[][] dp = new int[m][n];

        // right bottom, since we are traversing from left to right and top to bottom (we need a square)

        // take min. of up, left and diagonal
        for (int i = 0; i < m; i++){
            dp[i][0] = matrix[i][0];
            sum += dp[i][0];
        }
        for (int j = 1; j < n; j++){
            dp[0][j] = matrix[0][j];
            sum += dp[0][j];
        }

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (matrix[i][j] == 0)  // to form square it must be a 1
                    dp[i][j] = 0;
                else
                    dp[i][j] = Math.min(Math.min(dp[i][j - 1], dp[i - 1][j]), dp[i - 1][j - 1]) + 1;
                sum += dp[i][j];
            }
        }
        return sum;
    }
}