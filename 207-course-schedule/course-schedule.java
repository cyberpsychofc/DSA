class Solution {
    public boolean dfs(int v, List<List<Integer>> adj, boolean visited[], boolean[] recC) {
        visited[v] = true;
        recC[v] = true;

        for (int n : adj.get(v)) {
            if (!visited[n]){
                if (!dfs(n, adj, visited, recC))
                    return false;
                }
            else if (recC[n])
                return false;
        }
        recC[v] = false; // backtrack
        return true;
    }
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        boolean[] visited = new boolean[numCourses];
        boolean[] recC = new boolean[numCourses];
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < numCourses; i++)
            adj.add(new ArrayList<>());

        for (int[] pair : prerequisites)
            adj.get(pair[1]).add(pair[0]);

        for (int i = 0; i < numCourses; i++)
            if (!visited[i])
                if (!dfs(i, adj, visited, recC))
                    return false;
        return true;
    }
}