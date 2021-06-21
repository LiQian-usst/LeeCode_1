package leecode.fenzhi;

import java.util.ArrayList;
import java.util.List;

public class DiffWaysToCompute {
    // 241.为运算表达式设计优先级
    public List<Integer> diffWaysToCompute(String expression) {
        List<Integer> ways = new ArrayList<>();
        for(int i=0;i<expression.length();i++){
            char c = expression.charAt(i);
            if(c=='+'||c=='-'||c=='*'){
                List<Integer> left = diffWaysToCompute(expression.substring(0,i));
                List<Integer> right = diffWaysToCompute(expression.substring(i+1));
                for(Integer l:left){
                    for(Integer r:right){
                        switch (c) {
                            case '+':
                                ways.add(l+r);
                                break;
                            case '-':
                                ways.add(l-r);
                                break;
                            case '*':
                                ways.add(l*r);
                                break;
                        }
                    }
                }
            }
        }
        if (ways.size()==0){
            ways.add(Integer.valueOf(expression));
        }
        return ways;
    }
}
