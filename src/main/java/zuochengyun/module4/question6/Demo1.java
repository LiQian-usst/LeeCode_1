package zuochengyun.module4.question6;

import org.junit.Test;

/**
 * @author qian.li
 * @title: Demo1
 * @description:
 * @date 2021/3/15 18:36
 */
public class Demo1 {
    // 最长公共子序列问题
    public int getDp(char[] str1,char[] str2){
       int row = str1.length;
       int col = str2.length;
       int[][] dp = new int[row][col];
       dp[0][0] = str1[0]==str2[0]?1:0;
       for(int i=1;i<row;i++){
           dp[i][0] = Math.max(dp[i-1][0],str1[i]==str2[0]?1:0);
       }
       for(int j=1;j<col;j++){
           dp[0][j] = Math.max(dp[0][j-1],str1[0]==str2[j]?1:0);
       }
       for(int i=1;i<row;i++){
           for(int j=1;j<col;j++){
               dp[i][j] = Math.max(dp[i-1][j],dp[i][j-1]);
               if(str1[i]==str2[j]){
                   dp[i][j] = Math.max(dp[i][j],dp[i-1][j-1]+1);
               }
           }
       }
       return dp[row-1][col-1];
    }
    @Test
    public void test(){
        char[] str1 = {'1','A','2','C','3','D','4','B','5','6'};
        char[] str2 = {'B','1','D','2','3','C','A','4','5','B','6','A'};
        System.out.println(getDp(str1,str2));
    }
}
