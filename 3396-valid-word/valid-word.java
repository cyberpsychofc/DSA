class Solution {
    public boolean isValid(String word) {
        boolean vowelPresent = false;
        boolean consoPresent = false;

        if (word.length() < 3)
            return false;
        for (char c : word.toCharArray()){
            if (!Character.isLetterOrDigit(c))
                return false;
            else{
                if (c == 'A' || c == 'E' || c == 'I' || c == 'O' || c == 'U' || c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u')
                    vowelPresent = true;
                else if (Character.isLetter(c))
                    consoPresent = true;
            }
        }

        return vowelPresent && consoPresent;
    }
}