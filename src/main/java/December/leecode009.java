package December;

public class leecode009 {
    //回文数
    //解法1
    public boolean isPalindrome(int x) {
        String num = Integer.toString(x);
        if(num.length()==1){
            return true;
        }
        int len = num.length();
        int start = 0;
        int end = len-1;
        while(start<=end){
            if(num.charAt(start)==num.charAt(end)){
                start++;
                end--;
            }else {
                return false;
            }
        }
        return true;
    }
}
