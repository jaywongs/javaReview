package jay;

/**
 * Created by jaywangs on 2019/3/15
 */
public class ThreadLocalDemo {
    public static void main(String[] args) {
        ThreadLocal<Boolean> mThreadLocal = new ThreadLocal<>();
        mThreadLocal.set(true);
        // threadlocal
        System.out.println("threadlocal:   " + mThreadLocal.get());

        new Thread("thread1"){
            @Override
            public void run() {
                mThreadLocal.set(false);
                System.out.println("thread1:   " + mThreadLocal.get());
            }
        }.start();

        new Thread("thread2"){
            @Override
            public void run() {
                System.out.println("thread2:   " + mThreadLocal.get());
            }
        }.start();
    }
}
