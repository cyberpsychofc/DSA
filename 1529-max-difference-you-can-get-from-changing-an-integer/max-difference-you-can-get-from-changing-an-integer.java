class Solution {
    public int maxDiff(int num) {
        String s = Integer.toString(num);
        String t = s;
        int maxIndex = 0, minIndex = 0;
        while (maxIndex < s.length() && s.charAt(maxIndex) == '9') {
            maxIndex++;
        }
        if (maxIndex < s.length()) {
            s = s.replace(s.charAt(maxIndex), '9');
        }

        if ( t.charAt(0) != '1') 
            t = t.replace(t.charAt(0), '1');
        else {
            minIndex = 1;
            while (minIndex < s.length() && (t.charAt(minIndex) == '0' || t.charAt(minIndex) == '1')){
                minIndex++;
            }
            if (minIndex < s.length())
                t = t.replace(t.charAt(minIndex), '0');
        }
        return Integer.parseInt(s) - Integer.parseInt(t);
    }
}