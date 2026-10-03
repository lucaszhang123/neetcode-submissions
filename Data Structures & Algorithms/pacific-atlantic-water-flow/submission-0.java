class Solution {
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        boolean[][] attempted = new boolean[heights.length][heights[0].length];
        boolean[][] rA = new boolean[heights.length][heights[0].length];
        boolean[][] rP = new boolean[heights.length][heights[0].length];

        for (int r = 0; r < heights.length; r++) {
            dfs(r, 0, rP, heights);
            dfs(r, heights[0].length - 1, rA, heights);
        }

        for (int c = 0; c < heights[0].length; c++) {
            dfs(0, c, rP, heights);
            dfs(heights.length - 1, c, rA, heights);
        }

        List<List<Integer>> solSet = new ArrayList<>();

        for (int r = 0; r < heights.length; r++) {
            for (int c = 0; c < heights[0].length; c++) {
                if (rA[r][c] && rP[r][c]) {
                    List<Integer> sol = new ArrayList<>();
                    sol.add(r);
                    sol.add(c);
                    solSet.add(sol);
                }
            }
        }

        return solSet;
    }

    public void dfs(int r, int c, boolean[][] ap, int[][] heights) {
        if (ap[r][c]) return;

        ap[r][c] = true;

        if (r - 1 >= 0 && heights[r - 1][c] >= heights[r][c]) {
            dfs(r - 1, c, ap, heights);
        }
        if (r + 1 < heights.length && heights[r + 1][c] >= heights[r][c]) {
            dfs(r + 1, c, ap, heights);
        }
        if (c - 1 >= 0 && heights[r][c - 1] >= heights[r][c]) {
            dfs(r, c - 1, ap, heights);
        }
        if (c + 1 < heights[0].length && heights[r][c + 1] >= heights[r][c]) {
            dfs(r, c + 1, ap, heights);
        }
    }
}
