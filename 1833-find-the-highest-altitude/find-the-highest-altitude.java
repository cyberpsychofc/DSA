import java.util.*;
import java.util.Collections;
class Solution {
    public int largestAltitude(int[] gain) {
        int prefixSum[] = new int[gain.length+1];
        prefixSum[0] = 0;
        for(int i=1;i<prefixSum.length;i++){
            prefixSum[i] = prefixSum[i-1] + gain[i-1];
        }
        
        return Arrays.stream(prefixSum).max().getAsInt();
    }
}