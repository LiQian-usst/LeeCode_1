package leecode.twoPointer;

public class SumOfSquare {
    // 633. 平方数之和
    public boolean judgeSquareSum(int c) {
        if(c==1 || c==0){
            return true;
        }
        int a = 0;
        /*The result is the value closest to the true mathematical square root of the argument value.*/
        // 剪枝操作
        int b = (int)Math.sqrt(c);
        while(a<=b){
            if(a*a+b*b==c){
                return true;
            }else if(a*a+b*b>c){
                b--;
            }else {
                a++;
            }
        }
        return false;
    }
}
