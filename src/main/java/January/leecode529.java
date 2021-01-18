package January;

/**
 * @author qian.li
 * @title: leecode529
 * @description:
 * @date 2021/1/18 18:54
 */
public class leecode529 {
    // 定义当前点击点的周围八个位置
    int[] dirX = {0, 1, 0, -1, 1, 1, -1, -1};
    int[] dirY = {1, 0, -1, 0, 1, -1, 1, -1};

    // 扫雷游戏
    public char[][] updateBoard(char[][] board, int[] click) {
        int x = click[0];
        int y = click[1];
        if(board[x][y]=='M'){
            //情况1
            board[click[0]][click[1]] = 'X';
        } else {
            dfs(board,x,y);
        }
        return board;
    }

    public void dfs(char[][] board, int x, int y){
        // 定义地雷的数量
        int cnt  = 0;
        // 计算当前点击点周围地雷的数量
        for(int i=0;i<8;i++){
            int tx = x+dirX[i];
            int ty = y+dirY[i];
            // 边界判断
            if(tx<0||tx>=board.length||ty<0||ty>=board[0].length){
                continue;
            }
            if(board[tx][ty]=='M'){
                cnt++;
            }
        }
        if(cnt>0){
            //情况3(结束条件)
            board[x][y]=(char)(cnt+'0');
        }else {
            board[x][y]='B';
            for(int i=0;i<8;i++){
                int tx = x+dirX[i];
                int ty = y+dirY[i];
                // 边界判断,同时去掉不是'未挖出的空方块'
                if(tx<0||tx>=board.length||ty<0||ty>=board[0].length||board[tx][ty]!='E'){
                    continue;
                }else {
                    dfs(board,tx,ty);
                }
            }
        }
    }
}
