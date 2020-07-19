package thread;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @ClassName ThreadPrintDemo2
 * @Description: Java 多线程中两个线程交替执行，一个输出偶数，一个输出奇数
 * 使用volatile
 * @Author UESTC-ZKX
 * @Date 2020/3/8
 **/
public class ThreadPrintDemo2 {

    // 用volatile修饰也可static volatile int cxsNum = 0;
    static AtomicInteger cxsNum = new AtomicInteger(0);
    static volatile boolean flag = false;

    public static void main(String[] args) {

        Thread t1 = new Thread(() -> {
            for (; 100 > cxsNum.get(); ) {
                if (!flag && (cxsNum.get() == 0 || cxsNum.incrementAndGet() % 2 == 0)) {
                    System.out.println("偶数线程：" + cxsNum.get());
                    flag = true;
                }
            }
        }
        );

        Thread t2 = new Thread(() -> {
            for (; 100 > cxsNum.get(); ) {
                if (flag && (cxsNum.incrementAndGet() % 2 != 0)) {
                    System.out.println("奇数线程：" + cxsNum.get());
                    flag = false;
                }
            }
        }
        );

        t1.start();
        t2.start();
    }

}
