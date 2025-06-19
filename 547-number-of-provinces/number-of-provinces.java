class Solution {
    public void dfs(int v, int[][] adj, boolean[] visited) {
        visited[v] = true;

        for (int i = 0; i < adj.length; i++) {
                //check for neighbours which have not been visited yet
                if (adj[v][i] == 1 && !visited[i])
                    dfs(i, adj, visited);
        }
    }
    public int findCircleNum(int[][] isConnected) {
        int ans = 0;
        boolean visited[] = new boolean[isConnected.length];

        for (int i=0; i < isConnected.length; i++) {
            if (!visited[i]) {
                ans++;
                dfs(i, isConnected, visited);
            }
        }
        return ans;
    }
}