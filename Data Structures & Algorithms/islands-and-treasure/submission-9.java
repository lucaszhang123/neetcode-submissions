class Solution {
    public void islandsAndTreasure(int[][] grid) {
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        List<int[]> src = new ArrayList<>();

        for (int r = 0; r < grid.length; r++) {
            for (int c = 0; c < grid[0].length; c++) {
                if (grid[r][c] == 0) {
                    src.add(new int[]{r, c});
                    visited[r][c] = true;   // mark treasures visited immediately
                }
            }
        }

        bfs(src, 1, visited, grid);
    }

    private void bfs(List<int[]> bfsq, int bfsLayer, boolean[][] visited, int[][] grid) {
        if (bfsq.isEmpty()) return;

        List<int[]> children = new ArrayList<>();
        int[][] dirs = {{-1,0},{1,0},{0,-1},{0,1}};

        for (int[] coord : bfsq) {
            for (int[] d : dirs) {
                int nr = coord[0] + d[0];
                int nc = coord[1] + d[1];

                if (nr < 0 || nr >= grid.length || nc < 0 || nc >= grid[0].length ||
                    visited[nr][nc] || grid[nr][nc] == -1) {
                    continue;
                }

                visited[nr][nc] = true;
                grid[nr][nc] = bfsLayer;
                children.add(new int[]{nr, nc});
            }
        }

        bfs(children, bfsLayer + 1, visited, grid);
    }
}