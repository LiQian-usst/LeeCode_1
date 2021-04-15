package leecode.tanxin;

import java.util.Arrays;
import java.util.Comparator;

public class EraseOverlapIntervals {
    // 435.无重叠区间
    // 描述：给定一个区间的集合，找到需要移除区间的最小数量，使剩余区间互不重叠。
    // 解法：先计算最多能组成的不重叠区间个数，然后用区间总个数减去不重叠区间的个数
    public int eraseOverlapIntervals(int[][] intervals) {
        // 1.先按照区间结尾从小到大排序
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[1]-o2[1]<0?-1:(o1[1]-o2[1]==0?0:1);
            }
        });
        // 2.依次添加后续区间不重复的区间
        int res = 1;
        int pre = 0;
        for(int i=1;i<intervals.length;i++){
            int[] preInterval = intervals[pre];
            int[] interval = intervals[i];
            // 此时满足
            if(preInterval[1]<=interval[0]){
                res++;
                pre = i;
            }
        }
        return intervals.length-res;
    }
}
