class Solution {
    public List<Integer> findKDistantIndices(int[] nums, int key, int k) {
        Set<Integer> set = new HashSet<>();
        for (int j = 0; j < nums.length; j++) {
            if (nums[j] == key) {
                int start = Math.max(0, j - k);
                int end = Math.min(nums.length - 1, j + k);
                for (int i = start; i <= end; i++) {
                    set.add(i);
                }
            }
        }
        List<Integer> result = new ArrayList<>(set);
        Collections.sort(result);

        return result;
    }
}