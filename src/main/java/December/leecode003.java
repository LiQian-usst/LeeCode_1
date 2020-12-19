package December;

import java.util.HashSet;

public class leecode003 {
    /*
    * 给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。
    * */
    public int lengthOfLongestSubstring(String s) {
        HashSet<Character> set = new HashSet<>();
        int right = -1;
        int maxLen = 0;
        int len = s.length();
        for(int left=0;left<len;left++){
            //删除上一个位置的元素
            if(left>0){
                set.remove(s.charAt(left-1));
            }
            while(right+1<len && !set.contains(s.charAt(right+1))){
                set.add(s.charAt(right+1));
                right++;
            }
            maxLen=Math.max(maxLen,right-left+1);//通过下标计算出新的不重复子串的长度
        }
        return maxLen;
    }
}

