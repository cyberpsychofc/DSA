class Solution {
    public double new21Game(int n, int k, int maxPts) {
        if (k == 0)
            return 1.0;
        if (n >= k + maxPts - 1)
            return 1.0;
        double[] prob = new double[n + 1]; // DP table
        prob[0] = 1.0; // Alice starts with zero score
        double windowSum = 1.0;
        double result = 0.0;

        // fill scores
        for (int i = 1; i <= n ; i++) {
            prob[i] = windowSum / maxPts;
            if (i < k) // Alice can draw a card
                windowSum += prob[i];
            else  
                result += prob[i];
            if (i - maxPts >= 0) 
                windowSum -= prob[i - maxPts];
        }
                
        return result;
    }
}