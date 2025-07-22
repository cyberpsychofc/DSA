class Solution {
    public int thirdMax(int[] nums) {
        Set<Integer> set = new HashSet<>();
        int answer = Integer.MIN_VALUE;
        int first = Integer.MIN_VALUE, second = Integer.MIN_VALUE, third = Integer.MIN_VALUE;

        for (int i : nums) {
            set.add(i);
        }

        if (set.size() < 3) {
            for (int i : set) {
                answer = Integer.max(answer, i);
            }
        } else {
            for (int i : set) {
                if (i > first) {
                    third = second;
                    second = first;
                    first = i;
                } else if (i > second) {
                    third = second;
                    second = i;
                } else if (i > third)
                    third = i;
            }
            answer = third;
        }
        return answer;
    }
}