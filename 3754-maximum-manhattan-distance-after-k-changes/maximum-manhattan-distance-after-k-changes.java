class Solution {
    public int maxDistance(String s, int k) {
        int north = 0, south = 0, east = 0, west = 0;
        int i = 0;
        int max = Integer.MIN_VALUE;

        for (char dir : s.toCharArray()) {
            if (dir == 'N') {
                north++;
            } else if (dir == 'S') {
                south++;
            } else if (dir == 'E') {
                east++;
            } else {
                west++;
            }

            int base = Math.abs(north - south) + Math.abs(east - west);
            int extra = Math.min(2 * k, i + 1 - base);
            int total = base + extra;

            max = Math.max(max, total);
            i++;
        }
        return max;
    }
}