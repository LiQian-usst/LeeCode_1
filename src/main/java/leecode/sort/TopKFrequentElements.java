package leecode.sort;

import java.util.*;

public class TopKFrequentElements {
    public int[] topKFrequent(int[] nums, int k) {
        int[] res = new int[k];
        // key:数字 value:数字出现的次数
        Map<Integer, Integer> map = new HashMap<>();
        for(int i=0;i<nums.length;i++){
            if(map.containsKey(nums[i])){
                map.put(nums[i],map.get(nums[i])+1);
            }else {
                map.put(nums[i],1);
            }
        }

        // 升序,即最小堆
        // 用最小堆的原因是:新加入数的出现频率只需要比当前出现频率最小的数大就可以，然后删除堆顶的数，加入新的数，
        // 此时堆会自动调整成新的最小堆的形式
        PriorityQueue<Integer> pq = new PriorityQueue<>((Comparator<Integer>) (a, b) -> map.get(a)-map.get(b));
        for (Integer key : map.keySet()) {
            if (pq.size() < k) {
                pq.add(key);
            } else if (map.get(key) > map.get(pq.peek())) {
                pq.remove();
                pq.add(key);
            }
        }
        int i =0;
        while (!pq.isEmpty()) {
            res[i] = pq.remove();
            i++;
        }
        return res;
    }
}
