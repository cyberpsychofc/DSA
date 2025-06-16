class Solution {
    public String predictPartyVictory(String senate) {
        Deque<Integer> rad = new ArrayDeque<>();
        Deque<Integer> dire = new ArrayDeque<>();
        char[] x = senate.toCharArray();
        for (int i = 0 ; i < x.length; i++){
            if (x[i] == 'R')
                rad.offerLast(i);
            else
                dire.offerLast(i);
        }

        while (!rad.isEmpty() && !dire.isEmpty()){
            int d = dire.pollFirst();
            int r = rad.pollFirst();

            if (r < d)
                rad.offerLast(d + senate.length());
            else
                dire.offerLast(r + senate.length());
        }
        return (!rad.isEmpty()) ? "Radiant" : "Dire";
    }
}