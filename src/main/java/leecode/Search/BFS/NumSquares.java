package leecode.Search.BFS;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class NumSquares {
    // 279. 完全平方数
    // 利用BFS搜索求解
    public int numSquares(int n) {
        // 生成小于n的所有平方数
        List<Integer> squares = generateSquares(n);
        Queue<Integer> queue = new LinkedList<>();
        boolean[] marked = new boolean[n + 1];
        queue.add(n);
        marked[n] = true;
        int level = 0;
        while(!queue.isEmpty()){
            int size = queue.size();
            level++;
            for(int i=0;i<size;i++){
                int cur = queue.poll();
                for(int s:squares){
                    int next = cur - s;
                    if(next<0){
                        break;
                    }
                    if (next == 0){
                        return level;
                    }
                    if(marked[next]){
                        continue;
                    }
                    marked[next] = true;
                    queue.add(next);
                }
            }
        }
        return n;
    }

    /*
    *  生成小于n的平方数序列
    * */
    public List<Integer> generateSquares(int n){
        List<Integer> squares = new ArrayList<>();
        for(int i=1;i<n;i++){
            if(i*i <= n){
                squares.add(i*i);
            }else {
                return squares;
            }
        }
        return squares;
    }
}
