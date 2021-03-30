package leecode.twoPointer;

import org.junit.Test;

import java.util.Arrays;
import java.util.HashSet;

public class ReverseVowels {
    private final static HashSet<Character> vowels = new HashSet<>(
            Arrays.asList('a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U'));
    // 345. 反转字符串中的元音字母(a,e,i,o,u)
    public String reverseVowels(String s) {
        int start = 0;
        int end = s.length()-1;
        char[] res= new char[s.length()];
        while(start <= end){
            if(!vowels.contains(s.charAt(start))){
                res[start] = s.charAt(start);
                start++;
            }else if(!vowels.contains(s.charAt(end))){
                res[end] = s.charAt(end);
                end--;
            }else {
                res[start] = s.charAt(end);
                res[end] = s.charAt(start);
                start++;
                end--;
            }
        }
        return new String(res);
    }

    @Test
    public void test(){
        System.out.println(reverseVowels("hello"));
    }
}
