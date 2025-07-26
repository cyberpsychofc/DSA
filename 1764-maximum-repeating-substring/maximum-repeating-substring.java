class Solution {
    public static int helper(int[] dp, String sequence, String word, int currIdx) {
        int seqLength = sequence.length();
        int wordLength = word.length();

        if (currIdx + wordLength > seqLength)
            return 0;

        if (dp[currIdx] != -1)
            return dp[currIdx];

        int count = 0;
        int idx = currIdx;

        while (idx + wordLength <= seqLength && sequence.substring(idx, wordLength + idx).equals(word)) {
            idx += wordLength;
            count++;
        }

        dp[currIdx] = Math.max(count, helper(dp, sequence, word, currIdx + 1));

        return dp[currIdx];
    }

    public int maxRepeating(String sequence, String word) {
        int[] dp = new int[sequence.length() + 1];
        Arrays.fill(dp, -1);

        return helper(dp, sequence, word, 0);
    }
}