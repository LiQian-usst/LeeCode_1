package January;

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
        Set<Integer> set = new HashSet<>();
        int res = 0;
        for(int slow=0;slow<tree.length;slow++){
            int fast = slow;
            while(fast < tree.length && (set.size()<2 ||(set.size()==2 && set.contains(tree[fast])))){
                set.add(tree[fast]);
                fast++;
            }
            // 小的优化
            if(fast == tree.length && fast-slow >= res){
                return fast - slow;
            }
            res = Math.max(res,fast-slow);
            set.clear();
        }
        return res;
    }
}
