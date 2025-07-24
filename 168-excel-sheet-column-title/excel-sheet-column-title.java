class Solution {
    public String convertToTitle(int columnNumber) {
        int temp = columnNumber;
        StringBuilder sb = new StringBuilder();

        // A - 65 aur Z - 90
        while (temp > 0) {
            int offset = --temp % 26;
            System.out.println(offset);
            temp /= 26;

                sb.append((char) (65 + offset));
        }
        return sb.reverse().toString();
    }
}