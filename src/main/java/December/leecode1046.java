package December;

import java.util.Comparator;
import java.util.PriorityQueue;

public class leecode1046 {
    // 最后一块石头的重量
    public int lastStoneWeight(int[] stones) {
        // 大顶堆（不指定时默认为小顶堆）
        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());
        for(int stone:stones){
            pq.offer(stone);
        }
        while(pq.size()>1){
            int y = pq.poll();
            int x = pq.poll();
            if(y-x>0){
                pq.offer(y-x);
            }
        }
        return pq.size()==0?0:pq.poll();
    }
}
