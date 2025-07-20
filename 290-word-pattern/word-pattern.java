class Solution {
    public boolean wordPattern(String pattern, String s) {
        String[] words = s.split(" ");
        if (pattern.length() != words.length) {
            return false;
        }
        Map<Character, String> map = new HashMap<>();

        for (int i = 0; i < pattern.length(); i++) {
            if (map.containsKey(pattern.charAt(i)) && map.get(pattern.charAt(i)).equals(words[i]))
                continue;
            else if (map.containsKey(pattern.charAt(i)) && !(map.get(pattern.charAt(i)).equals(words[i])) || !(map.containsValue(pattern.charAt(i))) && map.containsValue(words[i])) {
                return false;
                }
            else
                map.put(pattern.charAt(i), words[i]);
        }
        return true;
    }
}