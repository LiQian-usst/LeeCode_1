package January;

import java.util.Arrays;

/**
 * @author qian.li
 * @title: leecode287
 * @description:
 * @date 2021/1/22 18:37
 */
public class leecode287 {
    public int findDuplicate(int[] nums) {
        Arrays.sort(nums);
        for(int i=0;i<nums.length-1;i++){
            if(nums[i]==nums[i+1]){
                return nums[i];
            }
        }
        return -1;
    }
}
