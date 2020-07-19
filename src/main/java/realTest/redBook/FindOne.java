package realTest.redBook;

import java.util.Scanner;

/**
 * @ClassName FindOne
 * @Description: 薯队长在平时工作中需要经常跟数字打交道，
 * 某一天薯队长收到了一个满是数字的表格，
 * 薯队长注意到这些数字里边很多数字都包含1，
 * 比如101里边包含两个1，616里包含一个1。
 * 请你设计一个程序帮薯队长计算任意一个正整数n(0<n<=2147483647)，
 * 从1到n（包括n）的所有整数数字里含有多少个1。
 * <p>
 * 输入描述:
 * 正整数n(0<n<=2147483647)
 * <p>
 * 输出描述:
 * 从1到n（包括n）的所有整数数字里含有多少个1
 * <p>
 * 输入例子1:
 * 1
 * <p>
 * 输出例子1:
 * 1
 * <p>
 * 输入例子2:
 * 13
 * <p>
 * 输出例子2:
 * 6
 * <p>
 * 例子说明2:
 * 从1到13（包括13）有13个数字，
 * 其中包含1的数字有1，10，11，12，13，
 * 这些数字里分别有1，1，2，1，1个1，
 * 所以从1到13（包括13）的整数数字中一共有1+1+2+1+1=6个1
 * @Author UESTC-ZKX
 * @Date 2020/2/25
 **/
public class FindOne {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        long n = Integer.parseInt(scanner.nextLine());
        scanner.close();
        System.out.println(NumberOf1Between1AndN_Solution_1(n));
    }

    // 暴力法
    private static long NumberOf1Between1AndN_Solution(long n) {
        long res = 0;
        for (long i = 1; i <= n; i++) {
            char[] chars = (i + "").toCharArray();
            for (char c : chars) {
                if (c == '1') {
                    res++;
                }
            }
        }
        return res;
    }

    /**
     * 数学归纳法
     * 个位数上的1的个数：(n/10)*1 + (n%10)<1 ? 0 : (n%10 ≥ 2 ? 1 : (n%10-1)+1)
     * 十位数上的1的个数：(n/100)*10 + (n%100)<10 ? 0 : (n%100 ≥ 20 ? 10 : ( n%100-10)+1 )
     * 百位数上1的个数：(n/1000)*100 + (n%1000)<100 ? 0 : (n%1000 ≥ 200 ? 100 : (n%1000-100)+1)
     * 总计i：(n/(10i))i + (n%(10i))< i ? 0 : (n%10i ≥ 2i ? i : (n%10i-i)+1)
     */
    private static long NumberOf1Between1AndN_Solution_1(long n) {
        long res = 0;
        for (long i = 1; i <= n; i *= 10) {
            res += n / (i * 10) * i + (n % (i * 10) < i ? 0 : (n % (10 * i) >= 2 * i ? i : (n % (10 * i) - i + 1)));
        }
        return res;
    }

}
