class Solution {
    public int findPivot(int[] nums){
        int start = 0, end = nums.length - 1;
        while (start <= end){
            int mid = start + (end - start) / 2;
            // check to what half should be searched in
            if (mid < end && nums[mid] > nums[mid + 1])
                return mid;
            if (mid > start && nums[mid] < nums[mid - 1])
                return mid - 1;
            if (nums[mid] <= nums[start])
                end = mid - 1;
            else
                start = mid + 1;
        }
        return -1;
    }
    public int findMin(int[] nums) {
        return nums[findPivot(nums) + 1];
    }
}