package leecode.twoPointer;

import org.junit.Test;

public class ValidPalindromeII {
    // 680. 验证回文字符串 Ⅱ
    public boolean validPalindrome(String s) {
        int life = 1;
        return util(s,life,0,s.length()-1);
    }

    private boolean util(String s,int life,int start,int end){
        while(start <= end){
            if (s.charAt(start) == s.charAt(end)){
                start++;
                end--;
            }else if(life>0){
                return util(s,life-1,start+1,end) || util(s,life-1,start,end-1);
            }else {
                return false;
            }
        }
        return true;
    }

    @Test
    public void test(){
        System.out.println(validPalindrome("cbbcc"));
    }

}
