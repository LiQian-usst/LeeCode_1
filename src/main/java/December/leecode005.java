package December;

public class leecode005 {
    //最长回文子串
    public String longestPalindrome(String s) {
        //特判
        int len = s.length();
        if(len<2){
            return s;
        }

        int maxLen = 1;
        int begin = 0;
        //java初始的布尔值为false,dp[i][j]代表从下标i到下标j的子串是否是回文子串
        boolean[][] dp = new boolean[len][len];
        char[] charArray = s.toCharArray();

        for(int i=0;i<len;i++){
            dp[i][i] = true;
        }
        //左下角先填
        for(int j=1;j<len;j++){
            for(int i=0;i<j;i++){
                if (charArray[i] != charArray[j]) {
                    dp[i][j] = false;
                } else {
                    if (j - i < 3) {
                        dp[i][j] = true;
                    } else {
                        dp[i][j] = dp[i + 1][j - 1];
                    }
                }

                // 只要 dp[i][j] == true 成立，就表示子串 s[i..j] 是回文，此时记录回文长度和起始位置
                if (dp[i][j] && j - i + 1 > maxLen) {
                    maxLen = j - i + 1;
                    begin = i;
                }
            }
        }
        return s.substring(begin,begin+maxLen);
    }
}
