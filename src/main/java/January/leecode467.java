package January;
import java.util.HashMap;
import java.util.Map;

public class leecode467 {
    // 环绕字符串中唯一的字符串
    public int findSubstringInWraproundString(String p) {
        int count = 1;
        Map<Character,Integer> map = new HashMap();
        // 特判1
        if(p.length()==0||p==null){
            return 0;
        }
        // 特判2
        if(p.length()==1){
            return 1;
        }
        // 放入第一个值
        map.put(p.charAt(0),1);
        for(int i=1;i<p.length();i++){
            if(p.charAt(i)-p.charAt(i-1)==1 || (p.charAt(i)=='a'&&p.charAt(i-1)=='z')){
                count = count+1;
            }else {
                count=1;
            }
            if(map.get(p.charAt(i))!=null){
                map.put(p.charAt(i),Math.max(map.get(p.charAt(i)),count));
            }else {
                map.put(p.charAt(i),count);
            }
        }
        int res =0;
        for(Integer integer :map.values()){
            res +=integer;
        }
        return res;
    }
}
