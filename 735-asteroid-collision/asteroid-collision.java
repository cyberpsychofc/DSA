class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> stk = new Stack<>();
        for (int i : asteroids) {
            boolean ifDestroyed = false;

            while (!stk.isEmpty() && stk.peek() > 0 && i < 0) {
                if (stk.peek() < -i) {
                    stk.pop();
                    continue;
                } else if (stk.peek() == -i) {
                    stk.pop();
                    ifDestroyed = true;
                    break;
                } else {
                    ifDestroyed = true;
                    break;
                }
            }
            if (!ifDestroyed)
                stk.push(i);
        }
        int[] ans = new int[stk.size()];
        for (int i = stk.size() - 1; i >= 0; i--) {
            ans[i] = stk.pop();
        }
        return ans;
    }
}