package December;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

public class leecode205 {
    //同构字符串 说明：可以假设s和t具有相同的长度
    public boolean isIsomorphic(String s, String t) {
        int len = s.length();
        //存储映射
        Map map = new HashMap<Character,Character>();
        for(int i=0;i<len;i++){
            if(!map.containsKey(s.charAt(i))){
                if(map.containsValue(t.charAt(i))){
                    return false;
                }
                map.put(s.charAt(i),t.charAt(i));
            }else {
                if(!map.get(s.charAt(i)).equals(t.charAt(i))){
                    return false;
                }
            }
        }
        return true;
    }

    @Test
    public void test(){
        System.out.println(isIsomorphic("ab","aa"));
    }
}
