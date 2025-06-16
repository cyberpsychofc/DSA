class Solution {
    public String decodeString(String s) {
        Stack<String> st = new Stack<>();
        int i = s.length() - 1;

        while (i >= 0) {
            if (s.charAt(i) == ']' || Character.isLetter(s.charAt(i))) {
                st.push(String.valueOf(s.charAt(i)));
            } else if (s.charAt(i) == '[') {
                StringBuilder sub = new StringBuilder();
                while (!st.peek().equals("]")) {
                    sub.append(st.pop());
                }
                st.pop();
                st.push(sub.toString());
            } else if (Character.isDigit(s.charAt(i))) {
                StringBuilder n = new StringBuilder();
                while (i > 0 && Character.isDigit(s.charAt(i - 1))) {
                    n.append(s.charAt(i--));
                }
                n.append(s.charAt(i));
                
                String subst2 = st.pop();
                int num = Integer.parseInt(n.reverse().toString());
                st.push(subst2.repeat(num));
            }
            i--;
        }

        StringBuilder ans = new StringBuilder();
        while (!st.isEmpty()) {
            ans.append(st.pop());
        }
        return ans.toString();
    }

}