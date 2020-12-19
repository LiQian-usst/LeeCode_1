package December;

import org.junit.Test;
import java.util.HashMap;
import java.util.Map;

public class leecode290 {
    /*
    * 给定一种规律 pattern 和一个字符串 str ，判断 str 是否遵循相同的规律。
    * 这里的 遵循 指完全匹配，例如， pattern 里的每个字母和字符串 str 中的每个非空单词之间存在着双向连接的对应规律。
    *
    * */
    public boolean wordPattern(String pattern, String s) {
        //两个map用于实现双向映射
        Map<String, Character> str2ch = new HashMap<>();
        Map<Character, String> ch2str = new HashMap<>();
        String[] strArray = s.split(" ");
        if(strArray.length!=pattern.length()){
            return false;
        }
        for(int i=0;i<pattern.length();i++){
            if(str2ch.containsKey(strArray[i]) && str2ch.get(strArray[i])!=pattern.charAt(i)){
                return false;
            }
            //注意字符串内容的比较，使用equals()
            if(ch2str.containsKey(pattern.charAt(i)) && !ch2str.get(pattern.charAt(i)).equals(strArray[i])){
                return false;
            }
            str2ch.put(strArray[i],pattern.charAt(i));
            ch2str.put(pattern.charAt(i),strArray[i]);
        }
        return true;
    }
    @Test
    public void test(){
        System.out.println(wordPattern("abba","dog cat cat dog"));
    }
}
