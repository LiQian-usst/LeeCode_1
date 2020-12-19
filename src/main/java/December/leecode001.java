package December;

import java.util.HashMap;
import java.util.Map;

/*
*  两数之和
* */
public class leecode001 {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i< nums.length; i++) {
            if(map.containsKey(target - nums[i])) {
                return new int[] {map.get(target-nums[i]),i};
            }
            //存放值和下标
            map.put(nums[i], i);
        }
        throw new IllegalArgumentException("No two sum solution");
    }
}
