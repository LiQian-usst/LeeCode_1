package December;

public class leecode008 {
    //字符串转整数
    //可以用trim()来去除字符串中的空字符
    public int myAtoi(String s) {
        if(s==null||s.equals("")){
            return 0;
        }
        int len = s.length();
        int start=0,end;
        boolean hasFlag = false;
        for(int i=0;i<len;i++){
            //得到第一个非空白字符的位置
            if(s.charAt(i)!=' '){
                start = i;
                break;
            }
        }
        //如果第一个非空字符不是 ‘+’、‘-’、也不是数字
        if(s.charAt(start)!='+' && s.charAt(start)!='-' && !Character.isDigit(s.charAt(start))){
            return 0;
        }
        //此时前首位可能是符号也可能是数字
        if(!Character.isDigit(s.charAt(start))){
            hasFlag = true;
            start++;
        }
        end = start;
        long longOfNum = 0;
        while(end<len&&Character.isDigit(s.charAt(end))){
            longOfNum = Long.parseLong(s.substring(start,end+1));
            //如果转为long后超出限制需要返回最大值或者最小值
            if((int)longOfNum!=longOfNum) {
                if(hasFlag && s.charAt(start-1)=='-'){
                    return Integer.MIN_VALUE;
                }else {
                    return Integer.MAX_VALUE;
                }
            }
            end++;
        }
        if(start==end){
            return 0;
        }
        if(hasFlag && s.charAt(start-1)=='-'){
            longOfNum = 0 - longOfNum;
        }
        return (int)longOfNum;
    }
}
