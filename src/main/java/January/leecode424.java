package January;

/**
 * @author qian.li
 * @title: leecode424
 * @description:
 * @date 2021/1/13 18:49
 */
public class leecode424 {
    public int characterReplacement(String s, int k) {
        // 维护了窗口内所有值出现的次数
        int[] arr = new int[26];
        // 窗口内出现次数最多的字符的出现次数
        int maxCountInWin=0;
        char[] a = s.toCharArray();
        int left = 0,right;
        int res = 0;
        // right一直向右扩充
        for(right = 0;right < a.length;right++){
            arr[a[right]-'A']++;
            // 每扩充一格 就重新计算maxCount
            maxCountInWin=Math.max(maxCountInWin,arr[a[right]-'A']);
            // 重复字符可以填满整个窗口,更新结果。
            if(right-left+1 <= k+maxCountInWin){
                res=Math.max(right-left+1,res);
            } else {
                // 窗口大小 减去 重复字符出现次数>k ，说明重复字符不能填满整个窗口
                arr[a[left]-'A']--;
                left++;
            }
        }
        return res;
    }
}
