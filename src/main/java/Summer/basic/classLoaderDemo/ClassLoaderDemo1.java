package Summer.basic.classLoaderDemo;

public class ClassLoaderDemo1 {
    public static void main(String[] args) {
        ClassLoader cl1 = ClassLoaderDemo1.class.getClassLoader();
        System.out.println("cl1 的类加载器："+cl1);
        System.out.println("cl1 类加载器的父类加载器："+cl1.getParent());
        System.out.println("cl1 类加载器的爷爷类加载器："+cl1.getParent().getParent());

        // BootStrap ClassLoader由 C++开发
        ClassLoader cl2 = String.class.getClassLoader();
        System.out.println("String 的类加载器："+cl2);

        // BootStrap ClassLoader,加载java基础类。这个属性不能在java指令中指定，推断不是由java语言处理
        System.out.println("BootStrap ClassLoader加载目录："+System.getProperty("sun.boot.class.path"));
        // Ext ClassLoader 加载JAVA_HOME/ext下的jar包
        System.out.println("Ext ClassLoader加载目录："+System.getProperty("java.ext.dirs"));
        // App ClassLoader加载Classpath
        System.out.println("App ClassLoader加载目录："+System.getProperty("java.class.path"));
    }
}
