package leecode.Search.DFS;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PacificAtlantic {
    int[][] direction = {{1,0},{-1,0},{0,1},{0,-1}};
    int m;
    int n;
    // 417.太平洋大西洋水流问题
    // 深度优先时，不一定需要依次遍历图中的结点去处理，有的问题可以从边上出发
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        List<List<Integer>> result = new ArrayList<>();
        m = heights.length;
        n = heights[0].length;
        // 记录每个坐标是否能到太平洋
        boolean[][] canReachP = new boolean[m][n];
        // 记录每个坐标是否能到太平洋
        boolean[][] canReachA = new boolean[m][n];

        for(int i=0;i<m;i++){
            dfs(heights,i,0,canReachP);
            dfs(heights,i,n-1,canReachA);
        }

        for(int j=0;j<n;j++){
            dfs(heights,0,j,canReachP);
            dfs(heights,m-1,j,canReachA);
        }

        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                // 每个坐标进行深度优先便利
                if(canReachP[i][j]&&canReachA[i][j]){
                    result.add(Arrays.asList(i,j));
                }
            }
        }
        return result;
    }

    public void dfs(int[][] heights,int x,int y,boolean[][] canReach){
        if(canReach[x][y]){
            return;
        }
        canReach[x][y] = true;
        for(int[] d:direction){
            int nextX = x + d[0];
            int nextY = y + d[1];
            if(nextX<0 || nextX>=m || nextY<0 || nextY>=n || heights[x][y]>heights[nextX][nextY]){
                continue;
            }
            dfs(heights,nextX,nextY,canReach);
        }
    }
}
