package leecode.Search;
import java.util.*;

public class ShortestPathBinaryMatrix {
    // 1091. 二进制矩阵中的最短路径
    // 利用BFS搜索求解
    public int shortestPathBinaryMatrix(int[][] grid) {
        return BFS(grid);
    }

    public int BFS(int[][] grid){
        int m = grid.length, n = grid[0].length;
        // 定义方向
        int[][] direction = {{1, -1}, {1, 0}, {1, 1}, {0, -1}, {0, 1}, {-1, -1}, {-1, 0}, {-1, 1}};
        // 定义队列
        Queue<Pair> queue = new LinkedList();
        Pair pair = new Pair(0, 0);
        queue.offer(pair);
        int pathLength = 0;
        while(!queue.isEmpty()){
            // 将当前同一层次的所以值进行访问
            int size = queue.size();
            pathLength++;
            for(int i=0;i<size;i++){
                Pair cur = queue.poll();
                // 情况1：节点值为1，此时为无效路径
                if(grid[cur.x][cur.y]==1){
                    continue;
                }
                // 情况2：到达边界条件
                if(cur.x == m-1 && cur.y == n-1){
                    return pathLength;
                }
                // 标记
                grid[cur.x][cur.y] = 1;
                for(int[] d:direction){
                    int newX = cur.x + d[0];
                    int newY = cur.y + d[1];
                    if(newX < 0 || newX >= m || newY < 0 || newY >= n){
                        continue;
                    }
                    queue.add(new Pair(newX, newY));
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
