class Solution {
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        List<Integer> tbr = new ArrayList<>();
        if (n == 1) {
            tbr.add(0);
            return tbr;
        }
        ArrayList<Integer>[] adj = new ArrayList[n];
        for (int[] e : edges) {
            if (adj[e[0]] == null) adj[e[0]] = new ArrayList<>();
            adj[e[0]].add(e[1]);
            if (adj[e[1]] == null) adj[e[1]] = new ArrayList<>();
            adj[e[1]].add(e[0]);
        }

        int[] minHeights = new int[n];
        
        int min = -1;
        for (int i = 0; i < n; i++) {
            Set<Integer> visited = new HashSet<>();
            visited.add(i);

            List<Integer> bfsq = new ArrayList<>();
            bfsq.add(i); 
            minHeights[i] = bfs(bfsq, visited, 0, adj);

            if (minHeights[i] < min || min == -1) min = minHeights[i];
        }
        
        for (int i = 0; i < n; i++) {
            if (minHeights[i] == min) tbr.add(i);
        }
        return tbr;
    }
    public int bfs(List<Integer> bfsq, Set<Integer> visited, int d, ArrayList<Integer>[] edges) {
        System.out.println();
        
        List<Integer> unvisited = new ArrayList<Integer>();
        for (int x : bfsq) {
            for (int neighbor : edges[x]) {
                if (visited.contains(neighbor)) {
                    continue;
                }
                unvisited.add(neighbor);
                visited.add(neighbor);
            }
        }

        if (unvisited.size() == 0) {
            return d;
        } 
        
        return bfs(unvisited, visited, d + 1, edges);
        
    }
}