package dynamicProgram;

import swordOffer.MyUtils;
import swordOffer.SwordOffer_09;

/**
 * @ClassName Fibonacci
 * @Description:
 * 斐波那契相关及扩展
 * @Author UESTC-ZKX
 * @Date 2020/2/13
 **/
public class Fibonacci{
    MyUtils myUtils = new MyUtils();

    /**
     * 兔子繁殖
     * 如果一开始有一对兔子，它们每月生育一对兔子，
     * 小兔在出生后一个月又开始生育且繁殖情况与最初的那对兔子一样，
     * 那么n个月后有多少对兔子？
     * @param  n 多少个月
     * @return 兔子数
     */
    public int rabbit(int n){
        return new SwordOffer_09().Fibonacci_1(n);
        //递归实现 return new SwordOffer_09().Fibonacci(n);
    }

    /**
     * 上楼问题
     * N级台阶，一次上1级或2级，总共有多少种走法
     * @param   n 台阶数
     * @return  走法
     */
    public int upstairs(int n){
        return new SwordOffer_09().Fibonacci_1(n);
        //递归实现 return new SwordOffer_09().Fibonacci(n);
    }

    /**
     * 上楼问题Plus
     * N级台阶，一次上1级到M级，总共有多少种走法
     * @param   n 台阶数
     * @param   m 做多一次上的级数
     * @return  走法
     */
    public int upstairsPlus(int n, int m){

        // 状态 TODO 也可优化为长度为Math.min(m,n)的dp[],循环使用
        int[] dp = new int[Math.max(m,n)+1];

        // 前m级时，全加即：f(n) = f(n-1) + f(n-2)+ ··· +f(1)
        int sum = 1;
        for(int i = 1; i <= m; i++){
            dp[i] = sum;
            sum +=  dp[i];
        }
        // 大于m时，dp[n] = dp[n-1]+ ··· +dp[n-m]
        if(n > m){
            for(int i = m+1; i <= n; i++){
                dp[i] = 0;
                for(int j = i-1; j >= i - m; j--){
                    dp[i] += dp[j];
                }
            }
        }
        return dp[n];
    }

    /**
     * 上楼问题Max
     * N级台阶，一次上1级或2级或者下1级（不超过一次），总共有多少种走法
     * @param   n 台阶数
     * @return  走法
     */
    public int upstairsMax(int n){
        /**
         * 状态转移方程
         * dp[n] = f[n] + (f(1)*f(n) + f(2)* f(n-1) + ··· + f(n-1)* f(2))
         * （f[n] 为只上时的斐波那契数列）
         */
        int res = 0;
        int[] dp = new int[n+1];
        int[] f = myUtils.fibonacci(n+1,1,1);
        dp[1] = f[1];
        for(int i = 2; i <= n; i++){
            int sum = 0;
            for(int j = 1; j < i; j++){
                sum += (f[j]*f[i+1-j]);
            }
            dp[i] = f[i] + sum;
        }
        res = dp[n];
        return res;
    }
}
