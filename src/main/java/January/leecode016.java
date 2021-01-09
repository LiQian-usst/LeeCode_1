package January;

import java.util.Arrays;

public class leecode016 {
    // 最接近的三数之和 a + b + c = target
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int len = nums.length;
        int res = 0;
        int min =Integer.MAX_VALUE;
        for(int i=0;i<len;i++){
            if(i==0 || nums[i]!=nums[i-1]){
                int start = i + 1;
                int end = len - 1;
                while (start < end) {
                    // 获得三数的和
                    int value = nums[i] + nums[start] + nums[end];
                    if (value == target) {
                        return value;
                    }
                    if (Math.abs(value - target) < min) {
                        min = Math.abs(value - target);
                        res = value;
                    }
                    if (value > target) {
                        end--;
                    } else {
                        start++;
                    }
                }
            }
        }
        return res;
    }
}
