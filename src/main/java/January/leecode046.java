package January;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class leecode046 {
    // 全排列 [1,2,3]
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if(nums.length==0){
            return res;
        }
        backtrack(res,nums,new ArrayList<>());
        return res;
    }

    public void backtrack(List<List<Integer>> res,int[] nums,List<Integer> list){
        if(list.size()==nums.length){
            res.add(new ArrayList<>(list));
        }else {
            for(int i=0;i<nums.length;i++){
                if(!list.contains(nums[i])){
                    list.add(nums[i]);
                    backtrack(res,nums,list);
                    list.remove(list.size()-1);
                }
            }
        }
    }
}
