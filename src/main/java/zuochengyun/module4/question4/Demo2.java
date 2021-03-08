package zuochengyun.module4.question4;

import org.junit.Test;

public class Demo2 {
    // 法2:动态规划
    public int robotWalk2(int N,int cur,int rest,int P){
        if(N<2||cur<1||cur>N||rest<0||P<1||P>N){
            return 0;
        }
        int[][] dp = new int[rest+1][N+1];
        dp[0][P]=1;
        // 第0行已经赋过值
        for(int i=1;i<=rest;i++){
            for(int j=1;j<=N;j++){
                if(j==1){
                    dp[i][j]=dp[i-1][2];
                }else if(j==N){
                    dp[i][j]=dp[i-1][N-1];
                }else {
                    dp[i][j]=dp[i-1][j-1]+dp[i-1][j+1];
                }
            }
        }
        return dp[rest][cur];
    }

    @Test
    public void test(){
        System.out.println(robotWalk2(7,4,9,5));
    }
}
