package jay;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by jaywangs on 2019/2/25
 */
public class ProducerAndConsumerWithCondition {

    static class CubbyHole{
        private int contents;
        private boolean available = false;
        private Lock lock = new ReentrantLock();
        private Condition full = lock.newCondition();
        private Condition empty = lock.newCondition();

        public synchronized int get(){
            int toBeReturn = 0;
            try {
                lock.lock();
                while (available){
                    empty.await();
                    toBeReturn = contents;
                }
                available = false;
                full.signal();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            finally {
                lock.unlock();
            }
            return toBeReturn;
        }

        public synchronized void put(int value) {
            try {
                lock.lock();
                while (!available) {
                    full.await();
                    contents = value;
                }
                empty.signal();
            }catch (InterruptedException e){
                e.printStackTrace();
            } finally {
                lock.unlock();
            }
        }
    }

    public static class consumer extends Thread {
        private int number;
        private ProductorAndConsumer.CubbyHole cubbyhole;
        public consumer(ProductorAndConsumer.CubbyHole c, int number){
            this.number = number;
            cubbyhole = c;
        }

        public void run() {
            int value = 0;
            for (int i = 0; i < 10; i ++) {
                value = cubbyhole.get();
                System.out.println("消费者 #" + this.number+ " got: " + value);
            }
        }
    }

    public static class producer extends Thread {
        private int number;
        private ProductorAndConsumer.CubbyHole cubbyhole;
        public producer (ProductorAndConsumer.CubbyHole c, int number){
            this.number = number;
            cubbyhole = c;
        }

        public void run() {
            for (int i = 0; i < 10; i ++) {
                cubbyhole.put(i);
                System.out.println("生产者 #" + this.number+ " put: " + i);
                try {
                    sleep((int)(Math.random() * 100));
                }catch (InterruptedException e){
                    e.printStackTrace();
                }
            }
        }
    }

    public static void main(String[] args) {
        ProductorAndConsumer.CubbyHole cubbyHole = new ProductorAndConsumer.CubbyHole();
        ProductorAndConsumer.producer p1 = new ProductorAndConsumer.producer(cubbyHole, 1);
        ProductorAndConsumer.consumer c1 = new ProductorAndConsumer.consumer(cubbyHole, 1);
        p1.start();
        c1.start();

    }
}
