class Solution {
    public void islandsAndTreasure(int[][] grid) {
        for (int r = 0; r < grid.length; r++) {
            for (int c = 0; c < grid[0].length; c++) {
                if (grid[r][c] == 0) {
                    boolean[][] visited = new boolean[grid.length][grid[0].length];
                    HashSet<int[]> src = new HashSet<>();
                    int[] srcRC = {r, c};
                    src.add(srcRC);
                    bfs(src, 1, visited, grid);
                }
            }
        }
    }

    private void bfs(HashSet<int[]> bfsq, int bfsLayer, boolean[][] visited, int[][] grid) {
        HashSet<int[]> children = new HashSet<>();
        HashSet<int[]> fullNeighbors = new HashSet<>();

        for (int[] coord : bfsq) {
            int[] l = {coord[0] - 1, coord[1]};
            int[] r = {coord[0] + 1, coord[1]};
            int[] b = {coord[0], coord[1] - 1};
            int[] t = {coord[0], coord[1] + 1};
            fullNeighbors.add(l);
            fullNeighbors.add(r);
            fullNeighbors.add(b);
            fullNeighbors.add(t);
        }

        for (int[] neighbor : fullNeighbors) {
            if (neighbor[0] < 0 || neighbor[0] >= grid.length ||
            neighbor[1] < 0 || neighbor[1] >= grid[0].length ||
            visited[neighbor[0]][neighbor[1]] == true ||
            grid[neighbor[0]][neighbor[1]] == -1 ||
            grid[neighbor[0]][neighbor[1]] < bfsLayer ||
            children.contains(neighbor)) {
                continue;
            } 

            children.add(neighbor);
            visited[neighbor[0]][neighbor[1]] = true;
            grid[neighbor[0]][neighbor[1]] = bfsLayer;
        }

        if (children.size() == 0) return;

        bfs(children, bfsLayer + 1, visited, grid);
    }
}
