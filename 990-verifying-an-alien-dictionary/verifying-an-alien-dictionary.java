class Solution {
    public boolean isAlienSorted(String[] words, String order) {
        int i = 0;
        while (i < words.length - 1) {
            int j = 0;
            while (j < words[i].length()) {
                if (j >= words[i + 1].length())
                    return false;
                if (words[i].charAt(j) != words[i + 1].charAt(j)) {
                    char curr = words[i].charAt(j);
                    char next = words[i + 1].charAt(j);
                    if (order.indexOf(curr) > order.indexOf(next))
                        return false;
                    else
                        break;
                }
                j++;
            }
            i++;
        }
        return true;
    }
}