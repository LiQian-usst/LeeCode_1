package December;
import org.junit.Test;

import java.util.*;

/*
*  描述：给定一个字符串数组，将字母异位词组合在一起。字母异位词指字母相同，但排列不同的字符串。
*
* */
public class leecode049 {

    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> result = new ArrayList<List<String>>();
        if(strs==null || strs.length==0){
            return result;
        }
        //用于暂存值
        Map<String,List<String>> map = new HashMap<String,List<String>>();
        for(int i=0;i<strs.length;i++){
            if(map.get(sortStringInternalChar(strs[i]))==null){
                //没有则创建
                List<String> list = new ArrayList<String>();
                list.add(strs[i]);
                map.put(sortStringInternalChar(strs[i]),list);
            }else{
                //有则新增
                List<String> list = map.get(sortStringInternalChar(strs[i]));
                list.add(strs[i]);
                map.put(sortStringInternalChar(strs[i]),list);
            }
        }
        Iterator<Map.Entry<String, List<String>>> iterator = map.entrySet().iterator();
        while(iterator.hasNext()){
            Map.Entry<String, List<String>> next = iterator.next();
            result.add(next.getValue());
        }
        return result;
    }

    //对字符串内部的字符进行排序
    public String sortStringInternalChar(String str){
        char[] chs = str.toCharArray();
        for (int i = 0; i < chs.length - 1; i++) {
            for (int j = 0; j < chs.length - 1 - i; j++) {
                if (chs[j] > chs[j + 1]) {
                    char temp = chs[j];
                    chs[j] = chs[j + 1];
                    chs[j + 1] = temp;
                }
            }
        }
        return String.valueOf(chs);
    }

    @Test
    public void test(){

    }
}
