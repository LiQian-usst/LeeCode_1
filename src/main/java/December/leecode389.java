package December;

import java.util.Arrays;

public class leecode389 {
    /*
    * 给定两个字符串 s 和 t，它们只包含小写字母。
    *
    * 字符串 t 由字符串 s 随机重排，然后在随机位置添加一个字母。
    *
    * 请找出在 t 中被添加的字母。
    *
    * */
    public char findTheDifference(String s, String t) {
        char[] charArray_s = s.toCharArray();
        Arrays.sort(charArray_s);
        char[] charArray_t = t.toCharArray();
        Arrays.sort(charArray_t);
        for(int i=0;i<charArray_s.length;i++){
            if(charArray_s[i]!=charArray_t[i]){
                return charArray_t[i];
            }
        }
        return charArray_t[charArray_s.length];
    }
}
