class Solution {
    public int finalPositionOfSnake(int n, List<String> commands) {
        int i = 0, j = 0;
        for (String dir : commands) {
            if (dir.equals("UP") && i > 0)
                i--;
            else if (dir.equals("DOWN") && i < n)
                i++;
            else if (dir.equals("RIGHT") && j < n)
                j++;
            else if (dir.equals("LEFT") && j > 0)
                j--;
        }
        return (i * n) + j;
    }
}