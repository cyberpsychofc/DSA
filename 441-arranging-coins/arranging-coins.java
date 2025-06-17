class Solution {
    public int arrangeCoins(int n) {
        int start = 1, end = n, result = 0;

        while (start <= end){
            int mid = start + (end - start) / 2;
            long tri = (long) mid * (mid + 1) / 2;

            if (tri <= n){
                result = mid;
                start = mid + 1;
            }
            else 
                end = mid - 1;
        }
        return result;
    }
}