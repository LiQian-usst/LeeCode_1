package zuochengyun.module4.question5;

import org.junit.Test;

/**
 * @author qian.li
 * @title: Demo1
 * @description:
 * @date 2021/3/9 19:18
 */
public class Demo1 {
    /**
    * @description: 换钱的方法数 
    * @param   
    * @return  
    * @throws
    * @author qian.li
    * @date 2021/3/9 19:29 
    */
    public int coins(int[] arr,int aim){
        int len = arr.length;
        int[][] dp = new int[len][aim+1];
        for(int row=0;row<len;row++){
            dp[row][0] = 1;
        }
        for(int k=1;arr[len-1]*k<=aim;k++){
            dp[len-1][arr[len-1]*k] = 1;
        }
        int res;
        for(int i=len-2;i>=0;i--){
            for(int j=1;j<=aim;j++){
                res = 0;
                for(int k=0;j-k*arr[i]>=0;k++){
                    res+=dp[i+1][j-k*arr[i]];
                }
                dp[i][j]=res;
            }
        }
        return dp[0][aim];
    }

    @Test
    public void test(){
        int[] arr={5,10,25,1};
        System.out.println(coins(arr,15));
    }
}
