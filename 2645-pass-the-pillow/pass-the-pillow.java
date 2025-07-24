class Solution {
    public int passThePillow(int n, int time) {
        int c = time / (n - 1);
        int timeLeft = time % (n - 1);
        return (c & 1) == 0 ? 1 + timeLeft : n - timeLeft;
    }
}