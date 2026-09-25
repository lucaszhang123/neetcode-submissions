class Solution {
    public void solve(char[][] board) {
        boolean[][] visited = new boolean[board.length][board[0].length];
        for (int i = 0; i < board.length; i++) {
            if (i == 0 || i == board.length - 1) {
                for (int j = 0; j < board[0].length; j++) {
                    if (board[i][j] == 'O')  dfs(i, j, board, visited);
                }
            }
            else {
                if (board[i][0] == 'O') dfs(i, 0, board, visited);
                if (board[i][board[0].length - 1] == 'O') dfs(i, board[0].length - 1, board, visited);
            }
        }

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == '-') board[i][j] = 'O';
                else if (board[i][j] == 'O') board[i][j] = 'X';
            }   
        }
    }
    public void dfs(int r, int c, char[][] board, boolean[][] visited) {
        if (visited[r][c]) return;

        visited[r][c] = true;
        board[r][c] = '-';
        
        if (r - 1 >= 0 && board[r - 1][c] == 'O') {
            dfs(r - 1, c, board, visited);
        } 
        if (r + 1 < board.length && board[r + 1][c] == 'O') {
            dfs(r + 1, c, board, visited);
        }
        if (c - 1 >= 0 && board[r][c - 1] == 'O') {
            dfs(r, c - 1, board, visited);
        } 
        if (c + 1 < board[0].length && board[r][c + 1] == 'O') {
            dfs(r, c + 1, board, visited);
        }
    }
}
