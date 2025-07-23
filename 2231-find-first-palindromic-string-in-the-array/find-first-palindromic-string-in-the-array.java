class Solution {
    public static boolean checkPalindrome(String word) {
        int i = 0, j = word.length() - 1;
        while (i < j) {
            if (word.charAt(i) != word.charAt(j))
                return false;
            i++;
            j--;
        }
        return true;
    }
    public String firstPalindrome(String[] words) {
        for (String word : words) {
            if(checkPalindrome(word))
                return word;
        }
        return "";
    }
}