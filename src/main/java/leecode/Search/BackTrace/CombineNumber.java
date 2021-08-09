package leecode.Search.BackTrace;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class CombineNumber {
    // 77.组合
    /*If n = 4 and k = 2, a solution is:
            [
            [3,4],
            [2,4],
            [2,3],
            [1,4],
            [1,3],
            [1,2],
            ]*/
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> resultList = new ArrayList<>();
        Deque<Integer> curList = new ArrayDeque<>();
        backTrace(resultList,curList,1,k,n);
        return resultList;
    }

    public void backTrace(List<List<Integer>> resultList,Deque<Integer> curList,int start,int k,final int n){
        if(curList.size()==k){
            resultList.add(new ArrayList<>(curList));
            return;
        }
        for(int i=start;i<=n;i++){
            curList.addLast(i);
            // 注意此处从i+1开始
            backTrace(resultList,curList,i+1,k,n);
            curList.removeLast();
        }
    }
}
