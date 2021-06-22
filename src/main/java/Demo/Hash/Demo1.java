package Demo.Hash;

import org.junit.Test;

public class Demo1 {
    @Test
    public void test(){
        // String的hashcode方法被重新实现：
        /*public int hashCode() {
            int h = hash;
            if (h == 0 && value.length > 0) {
                char val[] = value;

                for (int i = 0; i < value.length; i++) {
                    h = 31 * h + val[i];
                }
                hash = h;
            }
            return h;
        }*/
        String string = "hello world!";

        // Object的hashcode方法用的native方法
        /*
            public native int hashCode();
        */
        new Object();
    }
}
