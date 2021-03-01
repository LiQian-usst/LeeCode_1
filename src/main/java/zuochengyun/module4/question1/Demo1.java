package zuochengyun.module4.question1;

public class Demo1 {
    // 斐波那契数列的递归和动态规划
    // 1、暴力递归
    public int f1(int n){
        if(n<0){
            return 0;
        }
        if(n==1||n==2){
            return 1;
        }
        return f1(n-1)+f1(n-1);
    }

    // 2、O(N)的办法
    public int f2(int n){
        if(n<0){
            return 0;
        }
        if(n==1||n==2){
            return 1;
        }
        int res=1;
        int pre=1;
        int temp;
        for(int i=3;i<=n;i++){
            temp = res;
            res = res + pre;
            pre = temp;
        }
        return res;
    }

    //3、O(logN)的方法

}
