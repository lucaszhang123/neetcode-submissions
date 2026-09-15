class Solution {
    public boolean exist(char[][] board, String word) {
        boolean[][] visited = new boolean[board.length][board[0].length];
        for (int r = 0; r < board.length; r++) {
            for (int c = 0; c < board[0].length; c++) {
                
                if (dfs(r, c, 0, word, board, visited)) return true;
            }
        }
        return false;
    }

    public boolean dfs(int r, int c, int i, String word, char[][] board, boolean[][] visited) {
        if (i == word.length()) return true;
        char lookup = word.charAt(i);
        if (r >= 0 && r < board.length && c >= 0 && c < board[0].length && lookup == board[r][c] && !visited[r][c]) {
            visited[r][c] = true;
            boolean u = dfs(r + 1, c, i + 1, word, board, visited);
            boolean d = dfs(r - 1, c, i + 1, word, board, visited);
            boolean ri = dfs(r, c + 1, i + 1, word, board, visited);
            boolean l = dfs(r, c - 1, i + 1, word, board, visited);

            visited[r][c] = false;
            return (u || d || ri || l);
            
        }
        
        return false;
    }
}
