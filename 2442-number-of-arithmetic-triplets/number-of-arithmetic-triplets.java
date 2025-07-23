class Solution {
    public int arithmeticTriplets(int[] nums, int diff) {
        int answer = 0;
        Set<Integer> set = new HashSet<>();
        for (int i : nums) {
            set.add(i);
        }
        for (int i : nums) {
            if (set.contains(i + diff) && set.contains(i + (2 * diff)))
                answer++;
        }
        return answer;
    }
}