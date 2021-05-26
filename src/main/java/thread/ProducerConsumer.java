package thread;

import java.util.Queue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ConcurrentLinkedQueue;

/**
 * @author zhoukx
 * @ClassName: ProducerConsumer
 * @description:
 *  用多线程实现生产者、消费者模式，生产者负责往队列中生成随机Int数字【0~30】，
 *  每次生产完，随机sleep0`1秒，消费者负责从队列中消费数字（打印出来即可），
 *  如果生产出的数字等于9则认为故障，停止生产，
 *  并且消费者在知道生产者故障后依旧需要消费完队列中的数据，然后结束；
 * @date 2021/5/19
 */
public class ProducerConsumer {

    public static Queue<Integer> queue = new ConcurrentLinkedQueue<>();
    public static final Object lock1 = new Object();
    public static final Object lock2 = new Object();
    public static volatile boolean endFlag = false;

    public static void main(String[] args){

        Thread p1 = new Producer();
        Thread p2 = new Producer();

        Thread c1 = new Consumer();
        Thread c2 = new Consumer();

        p1.start();
        p2.start();
        c1.start();
        c2.start();
    }

    static class Producer extends Thread{
        @Override
        public void run(){
            while (!endFlag) {
                int num = (int) (Math.random() * 30);
//                synchronized (lock1) {
                    if (!endFlag) {
                        queue.add(num);
                        if (num == 9) {
                            endFlag = true;
                        }
                    }
//                }
//                notifyLock2();
                try {
                    Thread.sleep((long) (Math.random() * 1000));
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }

        private void notifyLock2() {
            synchronized(lock2){
                lock2.notify();
            }
        }
    }

    static class Consumer extends Thread {
        @Override
        public void run() {
            while(true){
                if(endFlag && queue.peek() == null){
                    break;
                }
//                synchronized (lock2) {
                        Integer temp = queue.peek();
                        if (temp != null) {
                            System.out.println(queue.poll());
                        }
                        // 因为生产者会sleep 1s，所以消费者这里会有多次空循环
//                        else {
//                            try {
//                                lock2.wait(1000);
//                            } catch (InterruptedException e) {
//                                e.printStackTrace();
//                            }
//                        }
//                }
            }
        }
    }

}
