class Solution {
    public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        List<Boolean> lst = new ArrayList<>();
        
        int max = Arrays.stream(candies).max().orElse(0);

        for (int candy : candies){
            lst.add(candy + extraCandies >= max);
        }
        return lst;
    }
}