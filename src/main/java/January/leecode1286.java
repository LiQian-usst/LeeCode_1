package January;

import java.util.LinkedList;
import java.util.Queue;

public class leecode1286 {
    Queue<String> res = new LinkedList<>();
    // 输入参数包括：一个 有序且字符唯一 的字符串 characters（该字符串只包含小写英文字母）和一个数字 combinationLength
    public leecode1286(String characters, int combinationLength) {
        // 需要找出characters中所有的满足长度要求的组合
        backTrace(characters,combinationLength,0,res,new StringBuilder());
    }

    public String next() {
        return res.poll();
    }

    public boolean hasNext() {
        if(res.isEmpty()){
            return false;
        }
        return true;
    }

    public void backTrace(String characters, int combinationLength,int start, Queue<String> res, StringBuilder currentStr){
        if (currentStr.length() == combinationLength){
            res.offer(currentStr.toString());
        }else {
            for(int i=start;i<characters.length();i++){
                currentStr.append(characters.charAt(i));
                backTrace(characters,combinationLength,i+1,res,currentStr);
                currentStr.deleteCharAt(currentStr.length()-1);
            }
        }
    }
}
