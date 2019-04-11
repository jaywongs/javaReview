package jay;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by jaywangs on 2019/2/28
 */
public class SynchronizedExample {
    public void func1() {
        synchronized (SynchronizedExample.class) {
            for (int i = 0; i < 10; i++) {
                System.out.print(i + " ");
            }
        }
    }

    public static void main(String[] args) {
//        SynchronizedExample e1 = new SynchronizedExample();
//        ExecutorService executorService = Executors.newCachedThreadPool();
//        executorService.execute(()->e1.func1());
//        executorService.execute(()->e1.func1());

        SynchronizedExample e1 = new SynchronizedExample();
        SynchronizedExample e2 = new SynchronizedExample();
        ExecutorService executorService = Executors.newCachedThreadPool();
        executorService.execute(() -> e1.func1());
        executorService.execute(() -> e2.func1());
    }
}
