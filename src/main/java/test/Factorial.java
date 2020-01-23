package test;
import java.math.BigInteger;
/**
 * @ClassName Factorial
 * @Description: 大数阶乘
 * 例如：
 * 输入 50000
 * 输出 903555
 * @Author UESTC-ZKX
 * @Date 2019/1/20
 **/
public class Factorial {
    public static BigInteger publicCache = new BigInteger("1");		//公用缓存
    public static int i = 50000;									//存储阶乘位数
    static Object lock = new Object();								//锁
    static Thread t[] = new Thread[5];								//线程数组(多次测试启动五个线程时较优)

    public static class Mutiply implements Runnable{
        public void run(){
            int temp = 1;											//线程内暂存i（1~50000）
            BigInteger privateCache = new BigInteger("1");			//线程私有缓存
            while(true) {
                synchronized (lock) {								//TODO 采用阻塞式同步，可以优化同步方式
                    if(i >= 1) {
                        temp = i;
                        i--;
                    }
                    else break;
                }
                privateCache = privateCache.multiply(BigInteger.valueOf(temp));
            }
            synchronized (lock) {
                publicCache = publicCache.multiply(privateCache);
            }
        }
    }
    static void factorial() {
        String s;
        char result[];
        int sum = 0;
        Runnable m = new Mutiply();
        for(int j = 0 ; j < 5 ; j++) {
            t[j] = new Thread(m);
            t[j].start();
        }
        for(int j = 0 ; j < 5 ; j++) {
            try {
                t[j].join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        s = publicCache.toString();
        result = s.toCharArray();
        for(char c : result) {
            sum += Integer.parseInt(String.valueOf(c));
        }
        System.out.println(sum);
    }
    public static void main(String[] args) {
        long startTime = System.currentTimeMillis();
        factorial();
        long endTime = System.currentTimeMillis();
        System.out.println("程序运行时间：" + (endTime - startTime) + "ms");
    }
}
