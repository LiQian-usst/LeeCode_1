package Summer.basic.str;

public class TestChar {
    public static void main(String[] args) {
        int count = 1; //记录汉字的个数
        // "\u5845", u后的4位数均为16进制数, 这样表示一个字符
        for(char c = '\u4e00'; c <= '\u8c9f'; c++ ) {
            // "\t" 代表空格
            System.out.print(c + "\t");
            count++;
            if (count % 10 == 0) {
                System.out.println("");
            }
        }
        System.out.println(count);
    }
}
