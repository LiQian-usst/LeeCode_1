package leecode.Search.DFS;

public class MaxAreaOfIsland {
    // 695.岛屿的最大面积
    // DFS深度优先算法解决
    private int m, n;
    // 方向移动类的问题都可这样设置方向
    private int[][] direction = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

    public int maxAreaOfIsland(int[][] grid) {
        m = grid.length;
        n = grid[0].length;
        int maxArea = 0;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                maxArea = Math.max(maxArea,dfs(grid,i,j));
            }
        }
        return maxArea;
    }

    public int dfs(int[][] grid, int x, int y){
        if(grid[x][y]==0){
            return 0;
        }
        grid[x][y] = 0;
        int area = 1;
        // 从一条路径走到底
        // 然后走另外一条路到底
        for(int[] d:direction){
            int curX = x + d[0];
            int curY = y + d[1];
            if(curX<0 || curX >=m || curY<0 || curY>=n){
                continue;
            }
            area += dfs(grid,curX,curY);
        }
        return area;
    }
}
