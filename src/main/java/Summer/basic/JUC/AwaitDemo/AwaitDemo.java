package Summer.basic.JUC.AwaitDemo;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class AwaitDemo {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newCachedThreadPool();
        AwaitSignalExample example = new AwaitSignalExample();
        executorService.execute(() -> example.after());
        executorService.execute(() -> example.before());
    }
}
