package February;

import java.util.*;

/**
 * @author qian.li
 * @title: leecode20
 * @description:
 * @date 2021/2/23 19:24
 */
public class leecode20 {
    // 有效的括号
    public boolean isValid(String s) {
        int n = s.length();
        if (n % 2 == 1) {
            return false;
        }
        // 初始map
        Map<Character, Character> pairs = new HashMap<Character, Character>() {{
            put(')', '(');
            put(']', '[');
            put('}', '{');
        }};
        Deque<Character> stack = new LinkedList<>();// LinkedList底层时双向链表
        for (int i = 0; i < n; i++) {
            char ch = s.charAt(i);
            if (pairs.containsKey(ch)) {
                if (stack.isEmpty() || stack.peek() != pairs.get(ch)) {
                    return false;
                }
                stack.pop();
            } else {
                // 出现(,{,[时直接放到stack里面
                stack.push(ch);
            }
        }
        return stack.isEmpty();
    }
}
