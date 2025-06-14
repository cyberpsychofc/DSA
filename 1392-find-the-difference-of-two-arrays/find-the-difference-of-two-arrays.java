class Solution {
    public List<List<Integer>> findDifference(int[] nums1, int[] nums2) {
        Set<Integer> set1 = new HashSet<>();
        Set<Integer> set2 = new HashSet<>();

        for (int i : nums1)
            set1.add(i);
        for (int i : nums2)
            set2.add(i);
        for (int i : nums1)
            set2.remove(i);
        for (int i : nums2)
            set1.remove(i);

        List<List<Integer>> ans = new ArrayList<List<Integer>>();
        ans.add(new ArrayList<>(set1));
        ans.add(new ArrayList<>(set2));

        return ans;
    }
}