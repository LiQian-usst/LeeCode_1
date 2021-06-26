package leecode.Search.BackTrace;

import java.util.ArrayList;
import java.util.List;

public class LetterCombinations {
    private static final String[] KEYS = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
    // 17.电话号码的字母组合
    public List<String> letterCombinations(String digits) {
        // 用于存储最后的结果
        List<String> combinations = new ArrayList<>();
        if (digits == null || digits.length() == 0) {
            return combinations;
        }
        backTrace(new StringBuilder(),combinations,digits);
        return combinations;
    }

    public void backTrace(StringBuilder sb, List<String> combinations, final String digits){
         if(sb.length() == digits.length()){
             combinations.add(sb.toString());
             return;
         }
         // 计算下标
        int curDigits = digits.charAt(sb.length())-'0';
        String letter = KEYS[curDigits];
        for(char c:letter.toCharArray()){
            sb.append(c);
            backTrace(sb,combinations,digits);
            sb.deleteCharAt(sb.length()-1);
        }
    }
}

