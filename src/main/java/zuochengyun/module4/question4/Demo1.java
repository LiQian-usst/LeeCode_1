package zuochengyun.module4.question4;

import org.junit.Test;

public class Demo1 {
    // 机器人到达指定位置方法数
    // N:长度     cur:当前位置     rest:剩余步数     P:终点位置
    //法1：暴力递归方式
    public int robotWalk(int N,int cur,int rest,int P){
        if(N<2||cur<1||cur>N||rest<0||P<1||P>N){
            return 0;
        }
        return walk(N,cur,rest,P);
    }

    public int walk(int N,int cur,int rest,int P){
        if(rest==0){
            return cur==P?1:0;
        }
        if(cur == 1){
            return walk(N,cur+1,rest-1,P);
        }
        if(cur == N){
            return walk(N,cur-1,rest-1,P);
        }
        if(rest>0){
            return walk(N,cur+1,rest-1,P)+walk(N,cur-1,rest-1,P);
        }
        return 0;
    }

    @Test
    public void test(){
        System.out.println(robotWalk(5,2,3,3));
    }
}
