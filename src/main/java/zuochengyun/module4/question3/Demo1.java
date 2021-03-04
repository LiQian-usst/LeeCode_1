package zuochengyun.module4.question3;

import org.junit.Test;

/**
 * @author qian.li
 * @title: Demo1
 * @description:
 * @date 2021/3/3 18:41
 */
public class Demo1 {
    // 换钱的最少货币数
    // 法1：暴力递归找到所有满足的组合
    public int minCoins1(int[] arr,int aim){
        if (arr == null || arr.length == 0 || aim < 0){
            return -1;
        }
        return process(arr,0,aim);
    }

    public int process(int[] arr,int i,int rest){
        if(i==arr.length){
            // 该方案找不开，返回-1
            return rest==0?0:-1;
        }
        int res = -1;
        for(int k=0;k*arr[i]<=rest;k++){
            int next = process(arr,i+1,rest - k*arr[i]);
            if(next!=-1){
                if(res==-1){
                    res = k+next;
                }else {
                    res = Math.min(res,k+next);
                }
            }
        }
        return res;
    }

    @Test
    public void test(){
        int[] arr = {5,2,3};
        System.out.println(minCoins1(arr,20));
    }
}
