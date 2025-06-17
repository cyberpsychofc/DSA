class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int n = matrix.length, m = matrix[0].length;

        int mid = 0;

        for (int i = 0; i < n; i++) {
            if (matrix[i][0] == target)
                return true;
            else if (matrix[i][0] > target){
                mid = i - 1;
                break;
                }
            else
                mid = i;
        }
        if (mid >= 0) {
            for (int j = 0; j < m; j++){
                if (matrix[mid][j] == target)
                    return true;
            }
        }
        return false;
        
    }
}