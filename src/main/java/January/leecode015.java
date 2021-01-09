package January;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class leecode015 {
    // 三数之和
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        int len = nums.length;
        List<List<Integer>> res = new ArrayList<>();
        for(int first=0;first<len;first++){
            if(first==0 || nums[first]!=nums[first-1]){
                int third = len-1;
                int target = -nums[first];
                // 转为两数之和
                for(int second=first+1;second<len;second++){
                    if(second==first+1 || nums[second]!=nums[second-1]){
                        while(second<third && nums[second]+nums[third]>target){
                            third--;
                        }
                        if(second!=third && nums[second]+nums[third]==target){
                            List<Integer> list = new ArrayList<>();
                            list.add(nums[first]);
                            list.add(nums[second]);
                            list.add(nums[third]);
                            res.add(list);
                        }
                    }
                }
            }
        }
        return res;
    }
}
