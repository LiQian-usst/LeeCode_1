package January;

import java.util.ArrayList;
import java.util.List;

public class leecode830 {
    // 较大分组的位置
    public List<List<Integer>> largeGroupPositions(String s) {
        List<List<Integer>> res = new ArrayList<>();
        int start = 0;
        int end = 0;
        while(end<s.length()){
            if(s.charAt(start)==s.charAt(end)){
                end++;
                continue;
            }else if(end - start -1 >=2){
                List<Integer> integers = new ArrayList<>();
                integers.add(start);
                integers.add(end-1);
                res.add(integers);
            }
            start = end;
            end++;
        }
        if(end - start - 1>=2){
            List<Integer> integers = new ArrayList<>();
            integers.add(start);
            integers.add(end-1);
            res.add(integers);
        }
        return res;
    }
}
