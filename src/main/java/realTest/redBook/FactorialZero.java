package realTest.redBook;

import java.util.Scanner;

/**
 * @ClassName FactorialZero
 * @Description: 输入一个自然数n，求表达式 f(n) = 1!2!3!.....n!
 * 的结果末尾有几个连续的0？
 * <p>
 * 输入描述:
 * 自然数n
 * <p>
 * 输出描述:
 * f(n)末尾连续的0的个数
 * <p>
 * 输入例子1:
 * 11
 * <p>
 * 输出例子1:
 * 9
 * @Author UESTC-ZKX
 * @Date 2020/2/24
 **/
public class FactorialZero {
    public static void main(String[] args) {
        int res = 0;
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        scanner.close();
        if (n < 1) {
            System.out.println(res);
            return;
        }
        System.out.println(factorial(n));
    }

    static int factorial(int n) {
        int res = 0;
        for (int i = 1; i <= n; i++) {
            int temp = i;
            int j = 0;
            while (temp % 5 == 0) {
                j++;
                temp /= 5;
            }
            res += (n - i + 1) * j;
        }
        return res;
    }
}
