package swordOffer;

/**
 * @ClassName SwordOffer_09
 * @Description:
 * 第九题
 * 大家都知道斐波那契数列，
 * 现在要求输入一个整数n，
 * 请你输出斐波那契数列的第n项（从0开始，第0项为0）。
 * n<=39
 * @Author UESTC-ZKX
 * @Date 2020/1/23
 **/
public class SwordOffer_09 {

    MyUtils myUtils = new MyUtils();

    // 递归法
    public int Fibonacci(int n) {
        if(myUtils.isNull(n)){
            return 0;
        }
        if(n <= 1){
            return n;
        }
        return Fibonacci(n-1) + Fibonacci(n-2);
    }

    // 循环法
    public int Fibonacci_1(int n){
        if(myUtils.isNull(n)){
            return 0;
        }
        int res = 1;
        int resTemp = 0;
        int temp = 0;
        for(int i = 2; i <= n; i++){
                temp = res;
                res = res + resTemp;
                resTemp = temp;
        }
        if(n == 0){
            return resTemp;
        }
        return res;
    }
}
