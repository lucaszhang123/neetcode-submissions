class Solution {
    public int numEnclaves(int[][] grid) {
        int r = grid.length;
        int c = grid[0].length;
        boolean[][] visited = new boolean[r][c];
        int[][] able = new int[r][c]; // 0: unknown; 1: can; 2: can't

        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (grid[i][j] == 0 || visited[i][j]) continue;

                List<int[]> component = new ArrayList<>();
                boolean[] canEscape = new boolean[1];
                dfs(i, j, visited, grid, component, canEscape);

                int result;
                if (canEscape[0]) result = 1;
                else result = 2;
                
                for (int[] cell : component) {
                    able[cell[0]][cell[1]] = result;
                }
            }
        }

        int counter = 0;
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (able[i][j] == 2) counter++;
            }
        }
        return counter;
    }

    public void dfs(int r, int c, boolean[][] visited, int[][] grid, List<int[]> component, boolean[] canEscape) {
        if (visited[r][c]) return;
        visited[r][c] = true;
        component.add(new int[]{r, c});

        if (r == 0 || r == grid.length - 1 || c == 0 || c == grid[0].length - 1) canEscape[0] = true;

        if (r - 1 >= 0 && grid[r - 1][c] == 1) dfs(r - 1, c, visited, grid, component, canEscape);
        if (r + 1 <= grid.length - 1 && grid[r + 1][c] == 1) dfs(r + 1, c, visited, grid, component, canEscape);
        if (c - 1 >= 0 && grid[r][c - 1] == 1) dfs(r, c - 1, visited, grid, component, canEscape);
        if (c + 1 <= grid[0].length - 1 && grid[r][c + 1] == 1) dfs(r, c + 1, visited, grid, component, canEscape);
    }
}