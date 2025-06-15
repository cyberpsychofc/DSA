class Solution {
    public String removeStars(String s) {
        Deque<Character> dq = new ArrayDeque<Character>();
        int pos = 0;
        while (pos < s.length()) {
            if (s.charAt(pos) == '*' && !dq.isEmpty())
                    dq.pollLast();
            else 
                dq.addLast(s.charAt(pos));
            pos++;
        }
        StringBuilder sb = new StringBuilder();
        for (Character c : dq)
            sb.append(c);
        return sb.toString();
    }
}