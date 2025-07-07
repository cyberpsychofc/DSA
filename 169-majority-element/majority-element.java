class Solution {
    public int majorityElement(int[] nums) {
        int n = nums.length;

        int num = 0, count = 0;
        for (int x : nums){
            if (count == 0)
                num = x;
            // check if it's the same number, else decrease count by 1
            count += (x == num) ? 1 : -1;
        }
        count = 0;
        for (int x : nums){
            if (x == num)
                count++;
        }
        if (count > n / 2)
            return num;

        return -1;
    }
}