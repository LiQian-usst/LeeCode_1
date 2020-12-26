package December;

public class leecode007 {
    // 整数反转 int:-2^31，2^31-1
    // 如何取到数得末尾
    // 假设有1147483649这个数字，它是小于最大的32位整数2147483647的，但是将这个数字反转过来后就变成了9463847411，这就比最大的32位整数还要大
    public int reverse_1(int x) {
        if(x == Integer.MIN_VALUE) return 0;
        //用于标记当前的数是正数还是负数
        boolean isPositive = true;
        if(x<0){
            isPositive = false;
            //转为正数做后续处理
            x = Math.abs(x);
        }
        String num = Integer.toString(x);
        StringBuilder sb = new StringBuilder(num);
        num = sb.reverse().toString();
        //整数反转后可能会溢出，先用long存储结果
        long result = Long.parseLong(num);
        if(!isPositive){
            result =  0 - result;
        }
        if(result>Integer.MAX_VALUE || result<Integer.MIN_VALUE) {//如果翻转后的数字超过int类型范围，则返回0
            return 0;
        }
        return (int)result;
    }

    public int reverse_2(int x){
        long res=0;
        while(x!=0){
            res = res*10+x%10;
            x = x/10;
        }
        //借助long转换来排除转换溢出的情况
        return res==(int)res?(int)res:0;
    }
}
