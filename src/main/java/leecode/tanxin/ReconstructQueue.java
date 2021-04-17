package leecode.tanxin;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ReconstructQueue {
    // 406. 根据身高重建队列
    public int[][] reconstructQueue(int[][] people) {
        // 按照第一个元素降序(身高)，第二个元素升序
        Arrays.sort(people, (o1, o2) -> o1[0]==o2[0]?o1[1]-o2[1]:o2[0]-o1[0]);
        List<int[]> queue = new ArrayList<>();
        for(int[] p:people){
            queue.add(p[1],p);
        }
        return queue.toArray(new int[queue.size()][]);
    }
}
