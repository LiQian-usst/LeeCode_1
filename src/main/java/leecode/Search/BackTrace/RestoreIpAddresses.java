package leecode.Search.BackTrace;

import java.util.ArrayList;
import java.util.List;

public class RestoreIpAddresses {
    // 93.复原 IP 地址
    // 回溯法
    public List<String> restoreIpAddresses(String s) {
        List<String> result = new ArrayList<>();
        StringBuilder tempAddress = new StringBuilder();
        backTrace(0,result,tempAddress,s);
        return result;
    }

    // 参数一：ip地址的段
    // 参数二：存储最终结果的集合
    // 参数三：临时地址
    // 参数四：剩余可以使用的数字
    private void backTrace(int k,List<String> result,StringBuilder tempAddress,String str){
        if(k==4 || str.length()==0){
            if(k==4 && str.length()==0){
                result.add(tempAddress.toString());
            }
            return;
        }

        for(int i=0;i<=2 && i<str.length();i++){
            // 除了0以外，不能出现01这类以0开头的数字
            if(i!=0 && str.charAt(0)=='0'){
                break;
            }
            String curStr = str.substring(0,i+1);
            if(Integer.valueOf(curStr)<=255){
                if(tempAddress.length()!=0){
                    curStr = '.'+curStr;
                }
                tempAddress.append(curStr);
                backTrace(k+1,result,tempAddress,str.substring(i+1));
                tempAddress.delete(tempAddress.length()-curStr.length(),tempAddress.length());
            }
        }
    }
}
