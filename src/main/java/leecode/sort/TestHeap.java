package leecode.sort;

import java.util.PriorityQueue;

public class TestHeap {
    public static void main(String[] args) {
        int[] a = {45,36,18,53,72,30,48,93,15,35};
        //1，默认实现的是最小堆，元素按照natural ordering排序（自然排序，例如，数字的从小到大）
        PriorityQueue<Integer> minHeap = new PriorityQueue<Integer>();

        for(int i=0;i<a.length;i++) {
            minHeap.offer(a[i]);
        }

        while(!minHeap.isEmpty()) {
            System.out.print(minHeap.poll()+" ");
        }
        //输出（升序）：15 18 30 35 36 45 48 53 72 93
        System.out.println();
    }
}
