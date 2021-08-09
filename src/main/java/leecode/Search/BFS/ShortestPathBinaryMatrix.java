package leecode.Search.BFS;
import java.util.*;

public class ShortestPathBinaryMatrix {
    // 1091. 二进制矩阵中的最短路径
    // 利用BFS搜索求解
    public int shortestPathBinaryMatrix(int[][] grid) {
        return BFS(grid);
    }
    // 广度优先遍历
    public int BFS(int[][] grid){
        int m = grid.length, n = grid[0].length;
        // 定义方向
        int[][] direction = {{1, -1}, {1, 0}, {1, 1}, {0, -1}, {0, 1}, {-1, -1}, {-1, 0}, {-1, 1}};
        Queue<Pair> queue = new LinkedList<>();
        queue.add(new Pair(0,0));
        int minLength = 0;
        while(!queue.isEmpty()){
            int size = queue.size();
            minLength++;
            for(int i=0;i<size;i++){
                Pair cur = queue.poll();
                int x = cur.x;
                int y = cur.y;
                // 为1的点不能过
                if(grid[x][y]==1){
                    continue;
                }
                if (x == m-1 && y == n-1){
                    return minLength;
                }
                // 标记已访问
                grid[x][y] = 1;
                for (int[] d : direction) {
                    int nr = x + d[0], nc = y + d[1];
                    if (nr < 0 || nr >= m || nc < 0 || nc >= n) {
                        continue;
                    }
                    queue.add(new Pair(nr, nc));
                }
            }
        }
        return -1;
    }
    // 定义元素类型Pair
    class Pair{
        public int x;
        public int y;
        public Pair(int x,int y){
            this.x = x;
            this.y = y;
        }
    }
}
