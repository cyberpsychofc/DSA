class Solution {
    public int maxVowels(String s, int k) {
        Set<Character> vowels = new HashSet<>(Arrays.asList('a','e','i','o','u'));

        int max = Integer.MIN_VALUE;
        int noOfVowels = 0;

        for (int i =0; i < s.length(); i++){
            if(vowels.contains(s.charAt(i))){
                noOfVowels++;
            }
            if (i >= k - 1){
                max = Math.max(max, noOfVowels);
                if (vowels.contains(s.charAt(i - k + 1)))
                    noOfVowels--;
            }
        }
        return max;
    }
}