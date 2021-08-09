package Summer.basic.str;

public class TestBoxing {
    public static void main(String[] args) {
        // 在Java SE5之前，如果要生成一个数值为10的Integer对象，必须这样进行
        Integer x = new Integer(10);
        // 自动装箱
        Integer i = 10;
        // 自动拆箱
        int j = i;
    }
}
