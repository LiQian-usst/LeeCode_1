package leecode.tanxin;

import java.util.Arrays;

public class FindContentChildren {
    // 455. 分发饼干
    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);
        int res = 0;
        int gi=0;
        int si=0;
        while(gi<g.length && si<s.length){
            if(s[si]>=g[gi]){
                gi++;
                res++;
            }
            si++;
        }
        return res;
    }
}
