package December;

public class leecode316 {
    /*
    * 给你一个字符串 s ，请你去除字符串中重复的字母，使得每个字母只出现一次。需保证 返回结果的字典序最小（要求不能打乱其他字符的相对位置）。
    * tips: 给定一个字符串 ss，如何去掉其中的一个字符ch，使得得到的字符串字典序最小呢？
    * 答案是：找出最小的满足 s[i]>s[i+1]的下标 i，并去除字符 s[i]。为了叙述方便，下文中称这样的字符为「关键字符」。
    * */
    public String removeDuplicateLetters(String s) {
        //用于标记字符是否已经加入到新字符中
        boolean[] vis = new boolean[26];
        int[] nums = new int[26];
        for (int i = 0; i < s.length(); i++) {
            //下标0-25,值代表字符出现的次数
            nums[s.charAt(i) - 'a']++;
        }
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            //新字符没有加入
            if (!vis[ch - 'a']) {
                //此时考虑是否删除最后一个字符
                while (sb.length() > 0 && sb.charAt(sb.length() - 1) > ch) {
                    if (nums[sb.charAt(sb.length() - 1) - 'a'] > 0) {
                        vis[sb.charAt(sb.length() - 1) - 'a'] = false;
                        sb.deleteCharAt(sb.length() - 1);
                    } else {
                        //不能删
                        break;
                    }
                }
                vis[ch - 'a'] = true;
                sb.append(ch);
            }
            nums[ch-'a']-=1;
        }
        return sb.toString();
    }
}
