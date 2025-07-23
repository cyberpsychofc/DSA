class Solution {
    public int secondHighest(String s) {
        Set<Integer> digits = new HashSet<>();
        int first = Integer.MIN_VALUE, second = Integer.MIN_VALUE;
        for (char c : s.toCharArray()) {
            if (Character.isDigit(c)) {
                digits.add(Character.digit(c, 10));
            }
        }
        for (int i : digits) {
            if (i > first) {
                second = first;
                first = i;
            } else if (i > second)
                second = i;
        }
        if (first == second)
            second = -1;
        return (second != Integer.MIN_VALUE) ? second : -1;
    }
}