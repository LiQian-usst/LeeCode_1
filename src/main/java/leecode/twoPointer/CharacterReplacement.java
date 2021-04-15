package leecode.twoPointer;

/**
 * @author qian.li
 * @title: leecode424
 * @description:
 * @date 2021/1/13 18:49
 */
public class CharacterReplacement {
    public int characterReplacement(String s, int k) {
        // 维护了窗口内所有值出现的次数
        int[] arr = new int[26];
        // 窗口内出现次数最多的字符的出现次数
        int maxCountInWin = 0;
        char[] a = s.toCharArray();
        // 窗口范围
        int left = 0,right;
        int res = 0;
        for(right = 0;right<a.length;right++){
            // 窗口内该字符出现次数+1
            arr[a[right]-'A']++;
            maxCountInWin = Math.max(maxCountInWin,arr[a[right]-'A']);
            if(maxCountInWin+k>=right-left+1){
                res = Math.max(res,right-left+1);
            }else {
                arr[a[left]-'A']--;
                left++;
            }
        }
        return res;
    }
}
