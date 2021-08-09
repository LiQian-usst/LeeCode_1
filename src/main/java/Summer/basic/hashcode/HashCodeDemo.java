package Summer.basic.hashcode;

import java.util.HashSet;

public class HashCodeDemo {
    public static void main(String[] args) {
        EqualExample e1 = new EqualExample(1, 1, 1);
        EqualExample e2 = new EqualExample(1, 1, 1);
        System.out.println(e1.equals(e2)); // true
        HashSet<EqualExample> set = new HashSet<>();
        set.add(e1);
        set.add(e2);
        // 如果只重写 equals() 不重写 hashCode() 因此这两个对象的哈希值是不同的，最终导致集合添加了两个等价的对象
        System.out.println(set.size());
    }
}
