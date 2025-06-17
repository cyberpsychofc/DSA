class Solution {
    public int uniquePaths(int m, int n) {
        long result = 1;
        for (int i = 1; i <= m - 1; i++) {
            result = result * (n + i - 1) / i;
        }
        return (int) result;
    }
}