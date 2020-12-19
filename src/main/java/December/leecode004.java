package December;

import java.text.DecimalFormat;
import java.util.Arrays;

public class leecode004 {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int length1 = nums1.length;
        int length2 = nums2.length;
        int[] nums3 = new int[length1+length2];
        for(int i=0;i<length1;i++){
            nums3[i] = nums1[i];
        }
        for(int i=0;i<length2;i++){
            nums3[i+length1] = nums2[i];
        }
        Arrays.sort(nums3);
        if(nums3.length%2==0){
            DecimalFormat df=new DecimalFormat("0.00000");//设置保留位数
            //偶数
            return Double.parseDouble(df.format((float) (nums3[(length1+length2)/2]+nums3[(length1+length2)/2 -1])/2));
        }else {
            //奇数
            return nums3[(length1+length2)/2];
        }
    }
}
