package zuochengyun.module4.question1;

/**
 * @author qian.li
 * @title: Demo2
 * @description:
 * @date 2021/3/2 18:53
 */
public class Demo2 {
    // 跳台阶
    // O(N)做法
    public int f1(int n){
        if(n<0){
            return 0;
        }
        if(n<=2){
            return n;
        }
        int res = 2;
        int tmp;
        int pre = 1;
        for(int i=3;i<=n;i++){
            tmp = pre;
            res = res + pre;
            pre = tmp;
        }
        return res;
    }
}
