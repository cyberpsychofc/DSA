class Solution {
    public boolean isPowerOfFour(int n) {
        double power = Math.log(n) / Math.log(4);
        if (power == 1 && n % 4 != 0)
            return false;
        return power % 1 == 0.0 ? true : false;
    }
}