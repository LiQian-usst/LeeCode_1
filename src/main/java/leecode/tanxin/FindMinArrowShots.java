package leecode.tanxin;

import java.util.Arrays;

public class FindMinArrowShots {
    // 452. 用最少数量的箭引爆气球
    // 在坐标 x 处射出一支箭，若有一个气球的直径的开始和结束坐标为 xstart，xend，
    // 且满足 xstart ≤ x ≤ xend，则该气球会被引爆。可以射出的弓箭的数量没有限制。
    // 实现 compare() 函数时避免使用 return o1[1] - o2[1]; 这种减法操作，防止溢出。
    public int findMinArrowShots(int[][] points) {
        // 1.先按照区间结尾从小到大排序
        Arrays.sort(points, (o1, o2) -> o1[1]<o2[1]?-1:(o1[1]==o2[1]?0:1));
        //Arrays.sort(points, Comparator.comparingInt(o -> o[1]));
        int res = 1;
        int pre = 0;
        for(int i=1;i<points.length;i++){
            int[] interval = points[i];
            int[] preInterval = points[pre];
            if(interval[0]<=preInterval[1]){
                // 满足同一区间
                continue;
            }
            res++;
            pre=i;
        }
        return res;
    }
}
