package December;

import java.util.Arrays;

public class leecode455 {
    /*
    * 贪心算法：分发小饼干
    * 应该按照孩子的胃口从小到大的顺序依次满足每个孩子，且对于每个孩子，应该选择可以满足这个孩子的胃口且尺寸最小的饼干
    * */
    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);
        int numOfChildren = g.length;
        int numOfCookies = s.length;
        int count = 0;
        for (int i = 0, j = 0; i < numOfChildren && j < numOfCookies; i++, j++) {
            //题眼
            while (j < numOfCookies && g[i] > s[j]) {
                j++;
            }
            if (j < numOfCookies) {
                count++;
            }
        }
        return count;
    }
}
