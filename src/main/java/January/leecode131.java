package January;

import java.util.ArrayList;
import java.util.List;

public class leecode131 {
    public List<List<String>> partition(String s) {
        List<List<String>> res = new ArrayList<>();
        if(s==null || s.length()==0){
            return res;
        }
        backTrace(res,s,0,new ArrayList<>());
        return res;
    }

    public void backTrace(List<List<String>> res,String s,int index,List<String> currentStr){
        if(index==s.length()){
            res.add(new ArrayList<>(currentStr));
        }else {
            for(int i=index;i<s.length();i++){
                if(index == i){
                    // 截取一个字符必定满足
                    currentStr.add(String.valueOf(s.charAt(index)));
                    backTrace(res,s,index+1,currentStr);
                    currentStr.remove(currentStr.size()-1);
                }else if(isHuiWen(s,index,i)){
                    // 满足回文字符串才截取
                    currentStr.add(s.substring(index,i+1));
                    backTrace(res,s,i+1,currentStr);
                    currentStr.remove(currentStr.size()-1);
                }
            }
        }
    }

    public boolean isHuiWen(String s,int start,int end){
        String str = s.substring(start,end+1);
        int startIndex = 0;
        int endIndex = str.length()-1;
        while(startIndex < endIndex){
            if(str.charAt(startIndex) == str.charAt(endIndex)){
                startIndex++;
                endIndex--;
            }else {
                return false;
            }
        }
        return true;
    }
}