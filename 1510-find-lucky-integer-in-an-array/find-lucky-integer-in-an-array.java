class Solution {
    public int findLucky(int[] arr) {
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();

        for (int i : arr){
            map.put(i, map.getOrDefault(i, 0) + 1);
        }

        int max = -1;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()){
            if(entry.getKey() == entry.getValue() && entry.getKey() > max)  
                max = entry.getKey();
        }

        return max;
    }
}