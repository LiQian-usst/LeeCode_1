package leecode.dongtaiguihua.fibonacci;

public class ClimbStairs {
    // 70.爬楼梯
    public int climbStairs(int n) {
       /* 定义一个数组 dp 存储上楼梯的方法数（为了方便讨论，数组下标从 1 开始），
          dp[i] 表示走到第 i 个楼梯的方法数目。第 i 个楼梯可以从第 i-1 和 i-2
          个楼梯再走一步到达，走到第 i 个楼梯的方法数为走到第 i-1 和第 i-2 个楼
          梯的方法数之和。即：
                    dp[i] = dp[i-1] + dp[i-2]
        */
        if(n<=2){
            return n;
        }
        //  dp[i] 表示走到第 i 个楼梯的方法数目
        int[] dp = new int[n+1];
        dp[1] = 1;
        dp[2] = 2;
        for(int i=3;i<=n;i++){
            dp[i] = dp[i-1] + dp[i-2];
        }
        return dp[n];
    }
}
