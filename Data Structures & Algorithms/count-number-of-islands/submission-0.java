class Solution {
    public int numIslands(char[][] grid) {
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        int numIslands = 0;
        for (int r = 0; r < grid.length; r++) {
            for (int c = 0; c < grid[0].length; c++) {
                if (grid[r][c] == '1' && !visited[r][c]) {
                    numIslands++;
                    dfsVisit(grid, visited, r, c);
                }
            }
        }
        return numIslands;
    }

    private void dfsVisit(char[][] grid, boolean[][] visited, int r, int c) {
        if (r >= grid.length || r < 0 || c >= grid[0].length || c < 0 
        || visited[r][c] || grid[r][c] == '0') {
            return;
        }
        
        visited[r][c] = true;
        dfsVisit(grid, visited, r + 1, c);
        dfsVisit(grid, visited, r - 1, c);
        dfsVisit(grid, visited, r, c + 1);
        dfsVisit(grid, visited, r, c - 1);

    }
}
