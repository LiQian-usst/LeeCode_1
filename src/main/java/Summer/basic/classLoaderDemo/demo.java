package Summer.basic.classLoaderDemo;

import com.sun.xml.internal.ws.util.ByteArrayBuffer;

import java.io.File;
import java.io.FileInputStream;

public class demo {
    public static void main(String[] args) throws ClassNotFoundException {
        String filePath = "D:\\code\\workspace\\leecode_1\\SalaryMaker.myclass";
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
    }
}
