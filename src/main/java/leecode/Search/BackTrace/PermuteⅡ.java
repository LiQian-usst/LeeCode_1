package leecode.Search.BackTrace;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PermuteⅡ {
    // 47.全排列Ⅱ
    // 回溯法
    public List<List<Integer>> permuteUnique(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> curNum = new ArrayList<>();
        int[] visited = new int[nums.length];
        backTrace(nums,visited,result,curNum);
        return result;
    }

    public void backTrace(final int[] nums,int[] visited,List<List<Integer>> result,List<Integer> curNum){
        if(curNum.size()==nums.length){
            result.add(new ArrayList<>(curNum));
            return;
        }
        for(int i=0;i<nums.length;i++){
            if(i!=0 && nums[i]==nums[i-1] && visited[i-1]==0){
                continue;
            }
            if(visited[i]==1){
                continue;
            }
            visited[i] = 1;
            curNum.add(nums[i]);
            backTrace(nums,visited,result,curNum);
            curNum.remove(curNum.size()-1);
            visited[i] = 0;
        }
    }
}
