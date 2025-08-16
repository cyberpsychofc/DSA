class Solution {
    public static void flipDigit(char[] num , int index){
        num[index] = (num[index] == '9') ? '6' : '9';
    }
    public int maximum69Number (int num) {
        char[] numChar = String.valueOf(num).toCharArray();
        int max = num;
        for (int i = 0; i < numChar.length; i++) {
            flipDigit(numChar, i);
            max = Math.max(max, Integer.valueOf(new String(numChar)));
            flipDigit(numChar, i);
        }
        return max;
    }
}