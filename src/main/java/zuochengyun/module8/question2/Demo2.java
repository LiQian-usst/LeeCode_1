package zuochengyun.module8.question2;

import java.util.HashMap;
import java.util.Map;

/**
 * @author qian.li
 * @title: Democ2
 * @description:
 * @date 2021/3/25 19:41
 */
public class Demo2 {

    /**
     * s[i]:arr[0...i]的和
     * arr[i..j] = s[j] - s[i-1] 此时i>=1,即子数组的范围是1开始
     * @param arr
     * @param target
     * @return
     */
    public int getMaxLen(int[] arr,int target){
        Map<Integer, Integer> map = new HashMap<>();
        int len = 0;
        int sum = 0;
        // 相对于从-1开始，则此时子数组范围为0开始
        map.put(0,-1);
        for(int i=0;i<arr.length;i++){
            sum+=arr[i];
            if(map.containsKey(sum-target)){
                len = Math.max(len,i-map.get(sum-target));
            }
            if(!map.containsKey(sum)){
                map.put(sum,i);
            }
        }
        return len;
    }
}
