package January;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

/**
 * @author qian.li
 * @title: leecode904
 * @description:
 * @date 2021/1/14 19:48
 */
public class leecode904 {
    // 合法序列：找到最长的包含两种不同”类型“的子序列
    public int totalFruit(int[] tree) {
        if(tree == null) return 0;
        if(tree.length <= 1) return tree.length;
        int begin = 0;
        int end = 1;
        int fruit1 = tree[0];
        while(end < tree.length && tree[end] == fruit1)
            end++;
        if(end == tree.length) return tree.length;
        int ans = end-begin;
        int fruit2 = tree[end];
        end++;
        for(;end<tree.length;end++){
            if(tree[end] != fruit1 && tree[end] != fruit2){
                ans = Math.max(ans,end-begin);
                fruit2 = tree[end];
                begin = end-1;
                fruit1 = tree[end-1];
                while(tree[begin-1]==tree[end-1])
                    begin--;

            }
        }
        return Math.max(ans,end-begin);
    }
}
