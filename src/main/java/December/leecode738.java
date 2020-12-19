package December;

import org.junit.Test;

/*
* 给定一个非负整数 N，找出小于或等于 N 的最大的整数，同时这个整数需要满足其各个位数上的数字是单调递增。
*
*（当且仅当每个相邻位数上的数字 x 和 y 满足 x <= y 时，我们称这个整数是单调递增的。）
*
* */
public class leecode738 {
    public int monotoneIncreasingDigits(int N) {
        //转为字符串
        char[] num = Integer.toString(N).toCharArray();
        //获得字符串的长度
        int len = num.length;
        for(int i = num.length-1;i>0;i--){
            if(num[i-1] > num[i]){
                num[i-1]-=1;
                len=i;
            }
        }
        for(int i=len;i<=num.length-1;i++){
            num[i] = '9';
        }
        return Integer.parseInt(new String(num));
    }
    @Test
    public void test(){
        System.out.println(monotoneIncreasingDigits(12534));
    }
}
