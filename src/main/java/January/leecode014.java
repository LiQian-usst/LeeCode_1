package January;

public class leecode014 {
    // 最长公共字符串
    public String longestCommonPrefix(String[] strs) {
        if(strs==null || strs.length==0){
            return "";
        }
        int length = strs[0].length();
        int count = strs.length;
        for(int j=0;j<length;j++){
            char val = strs[0].charAt(j);
            for(int i=0;i<count;i++){
                if(j>=strs[i].length() || strs[i].charAt(j)!=val){
                    return strs[0].substring(0,j);
                }
            }
        }
        return strs[0];
    }
}
