package thread;

/**
 * @ClassName Print1To100
 * @Description: Java 多线程中两个线程交替执行，一个输出偶数，一个输出奇数
 * 使用synchronized
 * @Author UESTC-ZKX
 * @Date 2020/3/8
 **/
public class ThreadPrintDemo1 {

    public static void main(String[] args) {
        final ThreadPrintDemo1 demo2 = new ThreadPrintDemo1();
        Thread t1 = new Thread(demo2::print1);
        Thread t2 = new Thread(demo2::print2);


        t2.start();
        t1.start();
    }

    public synchronized void print2() {
        for (int i = 1; i <= 100; i += 2) {
            System.out.println("奇数线程：" + i);
            this.notify();
            if (i == 99) {
                return;
            }
            try {
                this.wait();
            } catch (InterruptedException e) {
                // TODO
            }
        }
    }

    public synchronized void print1() {
        for (int i = 0; i <= 100; i += 2) {
            System.out.println("偶数线程：" + i);
            this.notify();
            if (i == 100) {
                return;
            }
            try {
                this.wait();
            } catch (InterruptedException e) {
                // TODO
            }
        }
    }
}
