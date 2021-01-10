package January;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class leecode093 {
    // return是方法返回；break是中止循环；continue是退出当前躺的循环
    // 复原ip地址
    public List<String> restoreIpAddresses(String s) {
        int len = s.length();
        List<String> res = new ArrayList<>();
        // 如果长度不够，不搜索
        if (len < 4 || len > 12) {
            return res;
        }
        // 双端队列便于状态回溯
        Deque<String> path = new ArrayDeque<>(4);
        // 划分的次数
        int splitTimes = 0;
        dfs(s, len, splitTimes, 0, path, res);
        return res;
    }

    private void dfs(String s, int len, int split, int begin, Deque<String> path, List<String> res) {
        if (begin == len) {
            if (split == 4) {
                //达到s的末尾且当前分了四次才是符合条件的
                res.add(String.join(".", path));
            }
            return;
        }

        // 看到剩下的不够了，就退出（剪枝），len - begin 表示剩余的还未分割的字符串的位数
        if (len - begin < (4 - split) || len - begin > 3 * (4 - split)) {
            return;
        }

        for (int i = 0; i < 3; i++) {
            if (begin + i >= len) {
                break;
            }
            int ipSegment = judgeIfIpSegment(s, begin, begin + i);
            // 在判断是 ip 段的情况下，才去做截取
            if (ipSegment != -1) {
                // 要转为字符串
                path.addLast(ipSegment + "");
                dfs(s, len, split + 1, begin + i + 1, path, res);
                path.removeLast();
            }
        }
    }


    /**
     * 判断 s 的子区间 [left, right] 是否能够成为一个 ip 段
     * 判断的同时顺便把类型转为int
     */
    private int judgeIfIpSegment(String s, int left, int right) {
        int len = right - left + 1;
        // 大于 1 位的时候，不能以 0 开头
        if (len > 1 && s.charAt(left) == '0') {
            return -1;
        }
        // 转成 int 类型
        int res = 0;
        for (int i = left; i <= right; i++) {
            // int 和 char做运算时,char会取ASCII码值
            res = res * 10 + s.charAt(i) - '0';
        }
        if (res > 255) {
            return -1;
        }
        return res;
    }

}
