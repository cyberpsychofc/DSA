class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int n = matrix.length, m = matrix[0].length;

        int start = 0, end = (n * m) - 1;

        while (start <= end){
            int mid = start + (end - start) / 2;

            int r = mid / m;
            int c = mid % m;
            int val = matrix[r][c];

            if (val == target)
                return true;
            else if (val < target)
                start = mid + 1;
            else
                end = mid - 1;
        }
        return false;
    }
}