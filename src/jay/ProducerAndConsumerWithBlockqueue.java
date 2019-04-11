package jay;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

/**
 * Created by jaywangs on 2019/2/25
 */
public class ProducerAndConsumerWithBlockqueue {

    private static BlockingQueue<Integer> queue = new ArrayBlockingQueue<Integer>(10);
    private static int content;

    public static class producer extends Thread {
        private int number;
        public void run() {
            try {
                for (int i = 0; i < 10; i ++) {
                    queue.put(i);
                    System.out.println("producer #" + this.number+ " put: " + i);
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static class consumer extends Thread {
        private int number;
        public void run() {
            try {
                for (int i = 0; i < 10; i ++) {
                    int value = queue.take();
                    System.out.println("consumer #" + this.number+ " got: " + value);
                }
            }catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        producer producer = new producer();
        consumer consumer = new consumer();

        producer.start();
        consumer.start();
    }

}
