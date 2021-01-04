package January;

import org.junit.Test;

public class leecode043 {
    // 字符串乘法
    public String multiply(String num1, String num2) {
        // 特判
        if(num1.equals("0")||num2.equals("0")){
            return "0";
        }
        String res = "0";
        int m = num1.length(),n = num2.length();
        for(int i = n-1;i>=0;i--){
            StringBuilder curr = new StringBuilder();
            // 进位值
            int add = 0;
            // 末位补充0
            for(int j=n-1;j>i;j--){
                curr.append(0);
            }
            int y = num2.charAt(i) - '0';
            for(int j = m-1;j>=0;j--){
                int x = num1.charAt(j) - '0';
                int val = x*y + add;
                curr.append(val%10);
                add = val/10;// 进位值更新
            }
            if(add!=0){
                curr.append(add);
            }
            res = addStrings(res,curr.reverse().toString());
        }
        return res;
    }
    // 字符串相加
    public String addStrings(String num1, String num2) {
        int i = num1.length() - 1, j = num2.length() - 1, add = 0;
        StringBuffer ans = new StringBuffer();
        while (i >= 0 || j >= 0 || add != 0) {
            // 取num1
            int x = i >= 0 ? num1.charAt(i) - '0' : 0;
            // 取num2
            int y = j >= 0 ? num2.charAt(j) - '0' : 0;
            int result = x + y + add;
            ans.append(result % 10);
            add = result / 10;
            i--;
            j--;
        }
        ans.reverse();
        return ans.toString();
    }
    @Test
    public void test(){
        System.out.println(multiply("123","456"));
    }
}
