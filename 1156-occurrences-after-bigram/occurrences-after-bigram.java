class Solution {
    public String[] findOcurrences(String text, String first, String second) {
        List<String> lst = new ArrayList<>();
        String[] words = text.split(" ");
        for (int i = 0; i < words.length - 2; i++) {
            if (words[i].equals(first) && words[i + 1].equals(second))
                lst.add(words[i + 2]);
        }
        return lst.toArray(new String[0]);
    }
}