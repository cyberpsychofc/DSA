class Solution {
    public int distanceTraveled(int mainTank, int additionalTank) {
        if (mainTank < 5)
            return 10 * mainTank;
        if (additionalTank > 0)
            return 50 + distanceTraveled(mainTank - 4, additionalTank - 1);
        return 10 + distanceTraveled(mainTank - 1, additionalTank);
    }
}