package Summer.basic.classLoaderDemo;

import com.sun.xml.internal.ws.util.ByteArrayBuffer;
import java.io.File;
import java.io.FileInputStream;
import java.security.SecureClassLoader;

public class SalaryClassLoader extends SecureClassLoader {

    private String classPath;

    public SalaryClassLoader(String classPath){
        this.classPath = classPath;
    }

    // 需要实现从 .myclass 文件中加载
    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {
        String filePath = this.classPath + name.replace(".","\\").concat(".myclass");
        FileInputStream fis;
        ByteArrayBuffer ba = new ByteArrayBuffer();
        byte[] b;
        int code;
        try {
            fis = new FileInputStream(new File(filePath));
            while((code = fis.read())!=-1){
                ba.write(code);
            }
            b = ba.toByteArray();
        }catch (Exception e){
            throw new ClassNotFoundException("自定义类文件不存在");
        }
        return super.defineClass(name,b,0,b.length);
    }
}
