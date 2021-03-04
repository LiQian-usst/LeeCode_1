package zuochengyun.module4.question3;

import org.junit.Test;

/**
 * @author qian.li
 * @title: Demo2
 * @description:
 * @date 2021/3/4 19:03
 */
public class Demo2 {
    // 换钱的最少货币数
    // 法2：动态规划 dp[i][rest] = min{dp[i][rest-arr[i]+1,dp[i+1][rest]};
    public int minCoins2(int[] arr,int aim){
        if (arr == null || arr.length == 0 || aim < 0){
            return -1;
        }
        int N = arr.length;
        int[][] dp = new int[N+1][aim+1];

        for(int col=1;col<=aim;col++){
            dp[N][col]=-1;
        }
        for(int i=N-1;i>=0;i--){
            for(int rest=0;rest<=aim;rest++){
                dp[i][rest] = -1;
                // 先设置为下面的值
                if(dp[i+1][rest]!=-1){
                    dp[i][rest] = dp[i+1][rest];
                }
                if(rest-arr[i]>=0 && dp[i][rest-arr[i]]!=-1){
                    if(dp[i][rest] == -1){
                        dp[i][rest] = dp[i][rest-arr[i]]+1;
                    }else {
                        dp[i][rest] = Math.min(dp[i][rest],dp[i][rest-arr[i]]+1);
                    }
                }
            }
        }
        return dp[0][aim];
    }

    @Test
    public void test(){
        int[] arr = {5,2,3};
        System.out.println(minCoins2(arr,20));
    }
}
