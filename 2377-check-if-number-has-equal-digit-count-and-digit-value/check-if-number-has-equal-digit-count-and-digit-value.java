class Solution {
    public boolean digitCount(String num) {
        Map<Character, Integer> countTable = new HashMap<>();
        for (char i : num.toCharArray())
            countTable.put(i, countTable.getOrDefault(i, 0) + 1);
        for (int i = 0; i < num.length(); i++) {
            if (!countTable.containsKey((char) (i + '0')))
                countTable.put((char)(i + '0'), 0);
            if ((int) (num.charAt(i) - '0') != countTable.get((char)(i + '0')))
                return false;
        }
        return true;
    }
}