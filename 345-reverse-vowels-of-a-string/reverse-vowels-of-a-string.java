class Solution {
    public String reverseVowels(String s) {
        char[] ch = s.toCharArray();
        String vowels = "aeiouAEIOU";
        int start = 0, end = s.length() - 1;

        while (start < end) {
            while (start < end && !vowels.contains(Character.toString(ch[start])))
                start++;
            while (start < end && !vowels.contains(Character.toString(ch[end])))
                end--;
            // swap
            char x = ch[start];
            ch[start] = ch[end];
            ch[end] = x;

            start++;
            end--;
        }
        return new String(ch);
    }
}