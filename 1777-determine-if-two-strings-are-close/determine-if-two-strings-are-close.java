class Solution {
    public boolean closeStrings(String word1, String word2) {
        if (word1.length() != word2.length())
            return false;

        Map<Character, Integer> map1 = new HashMap<Character, Integer>();
        Map<Character, Integer> map2 = new HashMap<Character, Integer>();

        for (char x : word1.toCharArray())
            map1.put(x, map1.getOrDefault(x, 0) + 1);
        for (char x : word2.toCharArray())
            map2.put(x, map2.getOrDefault(x, 0) + 1);

        if (!map1.keySet().equals(map2.keySet()))
            return false;
        List<Integer> val1 = new ArrayList<Integer>(map1.values());
        List<Integer> val2 = new ArrayList<Integer>(map2.values());
        Collections.sort(val1);
        Collections.sort(val2);
        
        if (!val1.equals(val2))
            return false;
        return true;
    }
}