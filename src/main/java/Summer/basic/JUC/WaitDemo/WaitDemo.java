package Summer.basic.JUC.WaitDemo;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class WaitDemo {
    public static void main(String[] args) {
        // 初始化一个线程池
        ExecutorService executorService = Executors.newCachedThreadPool();
        WaitNotifyExample example = new WaitNotifyExample();
        // 实际上是开启了一个线程执行这个任务
        executorService.execute(new Runnable() {
            @Override
            public void run() {
                example.after();
            }
        });
        executorService.execute(() -> example.before());
    }
}
