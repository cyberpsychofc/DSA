class Solution {
    public int equalPairs(int[][] grid) {
        int count = 0;
        Map<List<Integer>, Integer> map = new HashMap<>();
        for (int i = 0; i < grid.length; i++) {
            List<Integer> col = new ArrayList<>();

            for (int j : grid[i])
                col.add(j);

            map.put(col, map.getOrDefault(col, 0) + 1);
        }
        for (int i = 0; i < grid.length; i++) {
            List<Integer> row = new ArrayList<>();

            for (int j = 0; j < grid.length; j++)
                row.add(grid[j][i]);
            if (map.containsKey(row))
                count += map.get(row);
        }
        return count;
    }
}