package leecode.Search.DFS;

public class NumIslands {
    private int m;
    private int n;
    private int[][] direction = {{1,0},{-1,0},{0,1},{0,-1}};
    // 200.岛屿数量
    public int numIslands(char[][] grid) {
        m = grid.length;
        n = grid[0].length;
        int numOfIslands = 0;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(dfs(grid,i,j)>0){
                    numOfIslands++;
                }
            }
        }
        return numOfIslands;
    }

    public int dfs(char[][] grid, int x, int y){
        if(x<0 || x>=m || y<0 || y>=n || grid[x][y]=='0'){
            return 0;
        }
        grid[x][y] = '0';
        int size = 1;
        for(int[] d:direction){
            size+=dfs(grid,x+d[0],y+d[1]);
        }
        return size;
    }
}
