class Solution {
    // reverse using swap
    public void swap(int s, int e, int[] nums){
        while(s < e){
            int temp = nums[s];
            nums[s] = nums[e];
            nums[e] = temp;
            s++;
            e--;
        }
    }
    public void rotate(int[] nums, int k) {
        int n = nums.length;
        k = k % n;

        swap(0, n - 1, nums); // from start to end reverse the array
        swap(0, k - 1, nums); // from start to k, reverse back
        swap(k, n - 1, nums); // from k to end, reverse back
        // here you go, it's rotated!!!!
    }
}