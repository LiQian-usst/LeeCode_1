package January;

import org.junit.Test;

// 01背包问题
public class leecode01bag {
    int[] v = {0,2,4,3,7};
    int[] w = {0,2,3,5,5};
    Integer[][] dp = new Integer[5][11];

    @Test
    public void testKnapsack3() {
        int result = dp(10,4);
        System.out.println(result);
    }

    // i为列(容量)，j为行
    public int dp(int i, int j){
        // 填基本值
        for(int x=0;x<=i;x++){
            dp[0][x] = 0;
        }

        for(int y=0;y<=j;y++){
            dp[y][0] = 0;
        }
        // 开始填表
        for(int m=1;m<=j;m++){
            for(int n=1;n<=i;n++){
                // 装不下
                if(n<w[m]){
                    dp[m][n]=dp[m-1][n];
                }else {
                    // 装得下
                    dp[m][n]=Math.max(dp[m-1][n],dp[m-1][n-w[m]]+v[m]);
                }
            }
        }
        return dp[j][i];
    }
}
