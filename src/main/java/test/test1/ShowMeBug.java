package test.test1;

/**
 * @author zhoukx
 * @ClassName: Pay
 * @description: TODO
 * @date 2021/5/23
 */
    // 必须定义 `ShowMeBug` 入口类和 `public static void main(String[] args)` 入口方法
    public class ShowMeBug{
    private volatile double balance; // 账户余额
    private Object lock = new Object();

    // 执行的方法
    public void run() {
        deposit(1);
    }

    /**
     * 存款
     *
     * @param money 存入金额
     */
    public void deposit(double money) {
        //todo
        synchronized (lock){
            balance += money;
        }
    }

    /**
     * 获得账户余额
     */
    public double getBalance() {
        return balance;
    }

    public static void main(String[] args) {
        ShowMeBug account = new ShowMeBug();
        //todo:100线程并发
        int index = 100;
        while(index-- > 0){
            Thread t = new Thread(account::run);
            t.start();
        }

        // 自旋等待
        while (account.getBalance() < 100){

        }
        System.out.println("账户余额: " + account.getBalance());
    }

}
