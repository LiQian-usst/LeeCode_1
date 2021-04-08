package leecode.sort;

import java.util.Comparator;
import java.util.PriorityQueue;

public class TestHeapII {
    public static void main(String[] args) {
        int[] a = {45,36,18,53,72,30,48,93,15,35};
        //2，通过比较器排序，实现最大堆
        PriorityQueue<Integer> maxHeap = new PriorityQueue<Integer>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                /**以下是对比较器升序、降序的理解.
                 *(1) 写成return o1.compareTo(o2) 或者 return o1-o2表示升序
                 *(2) 写成return o2.compareTo(o1) 或者return o2-o1表示降序
                 */
                return o2.compareTo(o1);
            }
        }) ;

        for(int i=0;i<a.length;i++) {
            maxHeap.offer(a[i]);
        }

        while(!maxHeap.isEmpty()) {
            System.out.print(maxHeap.poll()+" ");
        }
        //输出（降序）：93 72 53 48 45 36 35 30 18 15
        System.out.println();
    }
}
