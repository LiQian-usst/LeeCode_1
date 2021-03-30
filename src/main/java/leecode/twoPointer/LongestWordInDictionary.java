package leecode.twoPointer;

import java.util.List;

public class LongestWordInDictionary {
    // 524. 通过删除字母匹配到字典里最长单词
    public String findLongestWord(String s, List<String> dictionary) {
        String res = "";
        Integer maxLen = Integer.MIN_VALUE;
        for(String s1:dictionary){
            int i = 0;
            int j = 0;
            while(i<s.length()){
                if(s.charAt(i)==s1.charAt(j)){
                    i++;
                    j++;
                    if(j==s1.length()){
                        if(s1.length()>maxLen){
                            maxLen = s1.length();
                            res = s1;
                        }
                        if(s1.length()==maxLen){
                            // 字符串自带字典序比较方法
                            res=res.compareTo(s1)>0?s1:res;
                        }
                        break;
                    }
                }else {
                    i++;
                }
            }
        }
        return res;
    }
}
