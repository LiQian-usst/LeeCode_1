package leecode.Search.BackTrace;

import java.util.ArrayList;
import java.util.List;

public class Permute {
    // 46.全排列
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> curNum = new ArrayList<>();
        int[] visited = new int[nums.length];
        backTrace(nums,visited,result,curNum);
        return result;
    }

    private void backTrace(final int[] nums,int[] visited,List<List<Integer>> result,List<Integer> curNum){
        if(curNum.size()==nums.length){
            result.add(new ArrayList<>(curNum));
            return;
        }
        for(int i=0;i<nums.length;i++){
            if(visited[i]==0){
                visited[i] = 1;
                curNum.add(nums[i]);
                backTrace(nums,visited,result,curNum);
                curNum.remove(curNum.size()-1);
                visited[i] = 0;
            }
        }
    }
}
