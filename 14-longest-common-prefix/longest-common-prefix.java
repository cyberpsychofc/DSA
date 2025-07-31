class Solution {
    private TrieNode root;

    public Solution() {
        root = new TrieNode();
    }

    public void insert(String word) {
        TrieNode node = root;

        for (char c : word.toCharArray()) {
            int index = c - 'a';
            if (node.children[index] == null) {
                node.children[index] = new TrieNode();
                node.childCount++;
            }
            node = node.children[index];
        }
        node.isLeaf = true;
    }

    public String commonPrefix() {
        StringBuilder sb = new StringBuilder();
        TrieNode node = root;

        while (node != null) {
            if (node.childCount != 1 || node.isLeaf)
                break;

            for (int i =0; i < 26; i++) {
                if (node.children[i] != null) {
                    sb.append((char) (i + 'a'));
                    node = node.children[i];
                    break;
                }
            }
        }
        return sb.toString();
    }

    public String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) return "";

        Solution trie = new Solution();

        for (String word : strs) {
            if (word.isEmpty()) return "";
            trie.insert(word);
        }

        return trie.commonPrefix();
    }
}

class TrieNode{
    TrieNode[] children = new TrieNode[26];
    boolean isLeaf = false;
    int childCount = 0;
}