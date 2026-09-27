class Solution {
    public int minPathSum(int[][] grid) {
        int[][] minPath = new int[grid.length][grid[0].length];
        minPath[0][0] = grid[0][0];
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (i == 0) {
                    if (j == 0) continue;
                    else minPath[i][j] = minPath[i][j - 1] + grid[i][j];
                }
                else {
                    if (j == 0) minPath[i][j] = minPath[i - 1][j] + grid[i][j];
                    else minPath[i][j] = grid[i][j] + Math.min(minPath[i - 1][j], minPath[i][j-1]); 
                }
            }
        }

        return minPath[grid.length - 1][grid[0].length - 1];
    }
}