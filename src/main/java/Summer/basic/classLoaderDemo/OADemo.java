package Summer.basic.classLoaderDemo;
import java.net.URL;
import java.net.URLClassLoader;

public class OADemo {
    public static void main(String[] args) throws Exception {
        Double salary = 2000.00;
        Double money;
        /*URL url = new URL("file:D:\\code\\workspace\\leecode_1\\SalaryMaker.jar");
        URLClassLoader urlClassLoader = new URLClassLoader(new URL[]{url});*/

        SalaryClassLoader classLoader = new SalaryClassLoader("D:\\code\\workspace\\leecode_1\\");

        while(true){
            //money = calSalary(salary,urlClassLoader);
            money = calSalary(salary,classLoader);
            System.out.println("实际到手的工资:"+money);
            Thread.sleep(1000);
        }
    }

    private static Double calSalary(Double salary,ClassLoader classLoader) throws Exception {
       /* SalaryMaker salaryMaker = new SalaryMaker();
        return salaryMaker.cal(salary);*/
        Class<?> clazz = classLoader.loadClass("com.liqian.Salary.SalaryMaker");
        Object object = clazz.newInstance();
        return (Double)clazz.getMethod("cal",Double.class).invoke(object,salary);
    }
}
