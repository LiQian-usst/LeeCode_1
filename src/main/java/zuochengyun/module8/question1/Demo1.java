package zuochengyun.module8.question1;

import org.junit.Test;

/**
 * @author qian.li
 * @title: Demo1
 * @description:
 * @date 2021/3/15 20:16
 */
public class Demo1 {
    // 未排序正数数组中累加和为给定值的最长子数组长度
    // 使用快慢指针
    public int getMaxLength(int[] arr,int sum){
        int left = 0;
        int right = 0;
        int len = 0; // 记录当前和为sum的子数组长度
        int k = arr[0]; //记录当前子数组的和
        while(left<arr.length && right<arr.length){
            if(k==sum){
                if(right-left+1>len){
                    len = right-left+1;
                }
                left++;
                k = k - arr[left];
            }
            if(k<sum){
                right++;
                if(right<arr.length){
                    k = k + arr[right];
                }else {
                    return len;
                }
            }
            if(k>sum){
                left++;
                k = k - arr[left];
            }
        }
        return len;
    }

    @Test
    public void test(){
        int[] arr = {1,2,1,1,1};
        System.out.println(getMaxLength(arr,3));
    }


}
