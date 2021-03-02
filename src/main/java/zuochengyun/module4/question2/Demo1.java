package zuochengyun.module4.question2;

/**
 * @author qian.li
 * @title: Demo1
 * @description:
 * @date 2021/3/2 19:36
 */
public class Demo1 {
    // 矩阵的最小路径和
    // 法1：dp[i][j]=min{dp[i-1][j],dp[i][j-1]}+arr[i][j]
    public int minPathSum1(int[][] arr){
        // 特判
        if(arr == null || arr.length==0 || arr[0]==null || arr[0].length==0){
            return 0;
        }
        int row = arr.length;
        int col = arr[0].length;
        int[][] dp = new int[row][col];
        dp[0][0] = arr[0][0];
        // 赋值第一行
        for(int i=1;i<col;i++){
            dp[0][i]=dp[0][i-1]+arr[0][i];
        }
        // 赋值第一列
        for(int j=1;j<row;j++){
            dp[j][0]=dp[j-1][0]+arr[j][0];
        }
        for(int i=1;i<col;i++){
            for(int j=1;j<row;j++){
                dp[i][j]=Math.min(dp[i-1][j],dp[i][j-1])+arr[i][j];
            }
        }
        return dp[row-1][col-1];
    }
}
