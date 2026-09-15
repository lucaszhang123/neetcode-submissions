class Solution {
    boolean[][] visited;
    public int counter = 0;

    public int orangesRotting(int[][] grid) {
        List<int[]> startRotten = new ArrayList<>();
        visited = new boolean[grid.length][grid[0].length];

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 2) {
                    startRotten.add(new int[]{i, j});
                    visited[i][j] = false;
                }
            }
        }

        bfs(grid, startRotten);

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1 && !visited[i][j]) {
                    return -1;
                }
            }
        }
        return counter;
    }

    public void bfs(int[][] grid, List<int[]> bfsq) {
        List<int[]> newbfsq = new ArrayList<>();
        for (int[] coord : bfsq) {
            int x = coord[0];
            int y = coord[1];

            if (x - 1 >= 0 && grid[x-1][y] == 1 && !visited[x-1][y]) {
                newbfsq.add(new int[]{x-1, y});
                visited[x-1][y] = true;
            }
            if (x + 1 < grid.length && grid[x + 1][y] == 1 && !visited[x+1][y]) {
                newbfsq.add(new int[]{x+1, y});
                visited[x+1][y] = true;
            }
            if (y - 1 >= 0 && grid[x][y-1] == 1 && !visited[x][y-1]) {
                newbfsq.add(new int[]{x, y-1});
                visited[x][y-1] = true;
            }
            if (y + 1 < grid[0].length && grid[x][y+1] == 1 && !visited[x][y+1]) {
                newbfsq.add(new int[]{x, y+1});
                visited[x][y+1] = true;
            }

        }

    

        if (newbfsq.size() > 0) {
            counter++;
            bfs(grid, newbfsq);
        }
        
    }
}
