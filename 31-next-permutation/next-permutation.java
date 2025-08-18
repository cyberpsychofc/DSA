class Solution {
    public static void swap(int arr[], int idx1, int idx2) {
        int temp = arr[idx1];
        arr[idx1] = arr[idx2];
        arr[idx2] = temp;
    }
    public static void reverse(int[] arr, int st, int end) {
        while (st <= end) {
            swap(arr, st, end);
            st++;
            end--;
        }
    }
    public void nextPermutation(int[] nums) {
        int dip = -1;
        // find the dip
        for (int i = nums.length - 2; i >= 0; i--) {
            if (nums[i] < nums[i + 1]) {
                dip = i;
                break;
            }
        }
        // Already at the highest permutation
        if (dip == -1) {
            reverse(nums, 0, nums.length - 1);
            return;
        }
        // next number in the permutation in the right suffix
        for (int i = nums.length - 1; i >= dip; i--) {
            // swap it with the dip
            if (nums[i] > nums[dip]) {
                swap(nums, i, dip);
                break;
            }
        }
        reverse(nums, dip + 1, nums.length - 1); // make the right suffix increasing   
    }
}