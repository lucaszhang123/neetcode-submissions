class Solution {
    public int maxAreaOfIsland(int[][] grid) {
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        int maxArea = 0;

        for (int r = 0; r < grid.length; r++) {
            for (int c = 0; c < grid[0].length; c++) {
                if (grid[r][c] == 1 && !visited[r][c]) {
                    int currIslandArea = areaIslands(grid, visited, r, c);
                    if (currIslandArea > maxArea) maxArea = currIslandArea;
                }
            }
        }

        return maxArea;
    }

    private int areaIslands(int[][] grid, boolean[][] visited, int r, int c) {
        if (r < 0 || c < 0 || r >= grid.length || c >= grid[0].length ||
        visited[r][c] || grid[r][c] == 0) {
            return 0;
        }
        
        visited[r][c] = true;
        return 1 + areaIslands(grid, visited, r + 1, c) + areaIslands(grid, visited, r - 1, c)
        + areaIslands(grid, visited, r, c + 1) + areaIslands(grid, visited, r, c - 1);
    }
}
