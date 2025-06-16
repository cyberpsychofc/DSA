class Solution {
    public int[] searchRange(int[] nums, int target) {
        int res[] = {-1,-1};
        if (nums.length == 0)
            return res;

        res[0] = search(nums, target, true);
        res[1] = search(nums, target, false);

        return res;
    }

    public int search(int[] nums, int target, boolean searchForStart) {
        int ans = -1;
        int start = 0;
        int end = nums.length - 1;
        while (start <= end) {
            int mid = start + (end - start) / 2;

            if (nums[mid] > target)
                end = mid - 1;
            else if ( target > nums[mid])
                start = mid + 1;
            else {
                ans = mid;
                if (searchForStart)
                    end = mid - 1;
                else
                    start = mid + 1;
            }
        }
        return ans;
    }
}