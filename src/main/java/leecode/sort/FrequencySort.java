package leecode.sort;

import org.junit.Test;

import java.util.*;

public class FrequencySort {
    // 451. 根据字符出现频率排序
    public String frequencySort(String s) {
        Map<Character, Integer> frequencyMap = new HashMap<>();
        for(int i=0;i<s.length();i++){
            if(frequencyMap.containsKey(s.charAt(i))){
                frequencyMap.put(s.charAt(i),frequencyMap.get(s.charAt(i))+1);
            }else {
                frequencyMap.put(s.charAt(i),1);
            }
        }
        PriorityQueue<Character> pq = new PriorityQueue<>((o1, o2) -> frequencyMap.get(o2) - frequencyMap.get(o1));
        Set<Character> set = frequencyMap.keySet();
        for(Character c:set){
            pq.add(c);
        }
        StringBuilder sb = new StringBuilder();
        while(!pq.isEmpty()){
            Character c = pq.poll();
            Integer nums = frequencyMap.get(c);
            for(int i=0;i<nums;i++){
                sb.append(c);
            }
        }
        return sb.toString();
    }

    @Test
    public void test(){
        System.out.println(frequencySort("tree"));
    }
}
