class Solution {
    public boolean increasingTriplet(int[] nums) {
        int left = Integer.MAX_VALUE;
        int middle = Integer.MAX_VALUE;
        int right = Integer.MAX_VALUE;

        for (int i = 0; i < nums.length; i++) {
            int x = nums[i];
            
            if (left >= x)
                left = x;
            else if (middle >= x)
                middle = x;
            else {
                right = x;
                return true;
            }
        }
        return false;
    }
}