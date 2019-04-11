package jay;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by jaywangs on 2019/2/25
 */
public class ProductorAndConsumer {
    static class CubbyHole{
        private int contents;
        private boolean available = false;

        public synchronized int get(){
            while (available == false){
                try {
                    wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            available = false;
            notifyAll();
            return contents;
        }

        public synchronized void put(int value) {
            while (available == true) {
                try {
                    wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            contents = value;
            available = true;
            notifyAll();
        }
    }

    public static class consumer extends Thread {
        private int number;
        private CubbyHole cubbyhole;
        public consumer(CubbyHole c, int number){
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
        private CubbyHole cubbyhole;
        public producer (CubbyHole c, int number){
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
        CubbyHole cubbyHole = new CubbyHole();
        producer p1 = new producer(cubbyHole, 1);
        consumer c1 = new consumer(cubbyHole, 1);
        p1.start();
        c1.start();

    }
}
