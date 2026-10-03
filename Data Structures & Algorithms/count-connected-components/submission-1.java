class Solution {
    public int countComponents(int n, int[][] edges) {
        boolean[] visited = new boolean[n];

        List<Integer>[] adj = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            adj[i] = new ArrayList<Integer>();
        }

        for (int[] e : edges) {
            adj[e[0]].add(e[1]);
            adj[e[1]].add(e[0]);
        }

        int counter = 0;
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                counter++;
                dfs(i, adj, visited);
            }
        }

        return counter;
    }

    public void dfs(int i, List<Integer>[] adj, boolean[] visited) {
        visited[i] = true;
        for (int n : adj[i]) {
            if (!visited[n]) {
                dfs(n, adj, visited);
            }
        }
    }
}
