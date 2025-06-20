class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        Set<Integer> window = new HashSet<>();
        
        for (int end = 0; end < nums.length; end++) {
            if (window.contains(nums[end]))
                return true;

            window.add(nums[end]);

            if (window.size() > k)
                window.remove(nums[end - k]);
        }
        return false;
    }
}