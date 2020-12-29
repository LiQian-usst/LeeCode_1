package December;

import org.junit.Test;

public class leecode010 {
    // 字符串匹配：给你一个字符串 s 和一个字符规律 p，请你来实现一个支持 '.' 和 '*' 的正则表达式匹配
    public boolean isMatch(String s, String p) {
        return util(s,p,0,0);
    }

    public boolean util(String s, String p, int s_index, int p_index){
        if(s_index==s.length() && p_index==p.length()){
            return true;
        }
        //s没结束但是p结束(注：s结束但是p没结束仍可能满足匹配)
        if((s_index!=s.length() && p_index==p.length())){
            return false;
        }
        //模式串后1位是*
        if(p_index + 1 < p.length() && p.charAt(p_index+1)=='*'){
            if((s_index!=s.length() && s.charAt(s_index)==p.charAt(p_index)) || (s_index!=s.length() && p.charAt(p_index)=='.')){
                return util(s,p,s_index+1,p_index) || util(s,p,s_index,p_index+2) || util(s,p,s_index+1,p_index+2);
            }else {
                return util(s,p,s_index,p_index+2);
            }
        }
        //模式串后1位不是*
        if((s_index!=s.length() && s.charAt(s_index) == p.charAt(p_index)) || ((s_index!=s.length() && p.charAt(p_index)=='.'))){
            return util(s,p,s_index+1,p_index+1);
        }
        //p的后一位不是*且当前位不匹配 、p的后一位不是*且s串已经到头
        return false;
    }

    @Test
    public void test(){
        System.out.println(isMatch("ab",".*"));
    }
}
