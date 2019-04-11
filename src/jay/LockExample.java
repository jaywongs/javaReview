package jay;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by jaywangs on 2019/2/28
 */
public class LockExample {
    private Lock lock = new ReentrantLock(); //JDK实现 而synchronized是JVM实现的

    public void func() {
        lock.lock();
        try {
            for (int i = 0; i < 10; i ++){
                System.out.print(i + " ");
            }
        }finally {
            lock.unlock();
        }
    }

    public static void main(String[] args) {
        LockExample lockExample = new LockExample();
        ExecutorService executorService = Executors.newCachedThreadPool();
        executorService.execute(() -> lockExample.func());
        executorService.execute(() -> lockExample.func());
    }
}
