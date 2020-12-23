package December;

import java.util.HashMap;
import java.util.Map;

public class leecode387 {
    //找到字符中第一个唯一的字符
    public int firstUniqChar(String s) {
        //用于记录当前字符在之前有没出现
        Map<Character,Integer> map = new HashMap<>();
        for(int i=0;i<s.length();i++){
            int j = i+1;
            if(map.containsKey(s.charAt(i))){
                continue;
            }
            while(j<s.length()){
                if(s.charAt(i)!=s.charAt(j)){
                    j++;
                }else {
                    map.put(s.charAt(i),1);
                    break;
                }
            }
            if(j==s.length()){
                return i;
            }
        }
        return -1;
    }

}
