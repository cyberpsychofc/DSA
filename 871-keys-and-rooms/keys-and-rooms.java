class Solution {
    public void dfs(int v, List<List<Integer>> adj, boolean[] visited) {
        visited[v] = true;

        for (Integer n : adj.get(v)) {
            if (!visited[n])
                dfs(n, adj, visited);
        }
    }
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        boolean[] visited = new boolean[rooms.size()];
        dfs(0, rooms, visited);

        // check visited the nodes to see if
        for (boolean isVisited : visited)
            if (!isVisited)
                return false;

        return true;
    }
}