class Solution {
    public String generateTag(String caption) {
        caption = caption.trim();
        String[] words = caption.split(" ");

        for (int i = 0; i < words.length; i++){
            if (words[i].length() == 0) continue;
            words[i] = i == 0 ? words[i].toLowerCase() : Character.toUpperCase(words[i].charAt(0)) + words[i].substring(1, words[i].length()).toLowerCase();
        }
            
        return String.join("", words).length() <= 99 ? '#' + String.join("", words) : '#' + String.join("", words).substring(0, 99);
    }
}