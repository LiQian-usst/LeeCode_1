package leecode.BinarySearch;

import org.junit.Test;

public class MySqrt {
    // 69. x 的平方根
    public int mySqrt(int x) {
        if(x<=1){
            return x;
        }
        int left = 1;
        int right = x;
        while(left<=right){
            int m = left + (right-left)/2;
            // 如果不转为long的话此处会溢出
            if((long)m*m>x){
                right = m-1;
            }else if(m*m == x || (m+1)*(m+1)>x){
                return m;
            }else {
                left = m+1;
            }
        }
        return right;
    }

    @Test
    public void test(){
        System.out.println(mySqrt(2147395599));
    }
}
