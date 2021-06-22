package leecode.Search.DFS;

public class SurroundedRegions {

    int[][] direction = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    int m;
    int n;

    // 130.被包围的区域 标记出和外侧相连的
    // 深度优先搜索
    public void solve(char[][] board) {
        m = board.length;
        n = board[0].length;
        // 上下边界(行不变，列变)
        for(int i=0;i<m;i++){
            dfs(board,i,0);
            dfs(board,i,n-1);
        }
        // 左右边界（列不变，行变）
        for(int j=0;j<n;j++){
            dfs(board,0,j);
            dfs(board,m-1,j);
        }
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if (board[i][j] == 'T') {
                    board[i][j] = 'O';
                } else if (board[i][j] == 'O') {
                    board[i][j] = 'X';
                }
            }
        }
    }

    private void dfs(char[][] board, int r, int c) {
        if (r < 0 || r >= m || c < 0 || c >= n || board[r][c] != 'O') {
            return;
        }
        board[r][c] = 'T';
        for (int[] d : direction) {
            dfs(board, r + d[0], c + d[1]);
        }
    }
}