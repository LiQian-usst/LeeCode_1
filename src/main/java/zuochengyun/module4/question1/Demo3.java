package zuochengyun.module4.question1;

import org.junit.Test;

/**
 * @author qian.li
 * @title: Demo3
 * @description:
 * @date 2021/3/2 19:08
 */
public class Demo3 {
    // 农场母牛下小牛问题    f(n)=f(n-1)+f(n-3),其中f(n-1)为上一年的牛,f(n-3)为今年将新出生的牛
    // 1.暴力递归
    public int f1(int n){
        if(n<1){
            return 0;
        }
        if(n<=3){
            return n;
        }
        return f1(n-1)+f1(n-3);
    }

    // 2.O(N)解法
    public int f2(int n){
        if(n<1){
            return 0;
        }
        if(n<=3){
            return n;
        }
        int res=3;
        int pre=2;
        int prepre=1;
        int tmp1;
        int tmp2;
        for(int i=4;i<=n;i++){
            tmp1 = pre;
            tmp2 = res;
            res = res +prepre;
            pre = tmp2;
            prepre = tmp1;
        }
        return res;
    }

    @Test
    public void test(){
        System.out.println(f2(6));
    }
}
