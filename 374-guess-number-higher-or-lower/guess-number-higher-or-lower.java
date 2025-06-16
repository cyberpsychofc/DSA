/** 
 * Forward declaration of guess API.
 * @param  num   your guess
 * @return 	     -1 if num is higher than the picked number
 *			      1 if num is lower than the picked number
 *               otherwise return 0
 * int guess(int num);
 */

public class Solution extends GuessGame {
    public int guessNumber(int n) {
        // suppose n = 10, so [1,2,3,4,5,6,7,8,9,10]
        // system picks a random number
        int start = 1, end = n;
        while (start <= end){
            int mid = start + (end - start) / 2;
            if (guess(mid) == 0)
                return mid;
            if (guess(mid) == - 1)
                end = mid - 1; 
            if (guess(mid) == 1)
                start = mid + 1;
        }
        return -1;
    }
}