class Solution {
    public String[] divideString(String s, int k, char fill) {
        ArrayList<String> x = new ArrayList<>();
        if (k > s.length()){
            x.add(s + String.valueOf(fill).repeat(k - s.length()));
            return x.toArray(new String[0]);
        }
            
        int first = 0;
        int last = k;
        
        while (last < s.length()) {
            x.add(s.substring(first, last));
            first = last;
            if (last + k > s.length() && s.length() % k != 0) {
                last = s.length();
            } else
                last = last + k;
        }
        if (s.substring(first, last).length() < k) {
            x.add(s.substring(first, last) + String.valueOf(fill).repeat(k - s.substring(first, last).length()));
        } else
            x.add(s.substring(first, last));
        return x.toArray(new String[0]);
    }
}