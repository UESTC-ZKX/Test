package realTest.bilibili;

import java.util.Scanner;

/**
 * @ClassName OneZeroPackageProblem
 * @Description: 0/1 背包问题
 * 有为N件物品，它们的重量w分别是w1,w2,...,wn，
 * 它们的价值v分别是v1,v2,...,vn，
 * 每件物品数量有且仅有一个，现在给你个承重为M的背包，
 * 求背包里装入的物品具有的价值最大总和？
 * <p>
 * 输入描述:
 * 物品数量N=5件
 * 重量w分别是2 2 6 5 4
 * 价值v分别是6 3 5 4 6
 * 背包承重为M=10
 * <p>
 * 输出描述:
 * 背包内物品最大总和为15
 * <p>
 * 输入例子1:
 * 5
 * 10
 * 2 2 6 5 4
 * 6 3 5 4 6
 * <p>
 * 输出例子1:
 * 15
 * @Author UESTC-ZKX
 * @Date 2020/2/14
 **/
public class OneZeroPackageProblem {

    // 输入参数
    private static int n, m;
    private static int[] w, v;

    // 辅助参数
    private static int curWeight = 0, curValue = 0;
    private static int bestValue = 0;
    private static int[] dp;

    public static void main(String[] args) {
        // 初始化部分
        Scanner scanner = new Scanner(System.in);
        n = Integer.parseInt(scanner.nextLine());
        m = Integer.parseInt(scanner.nextLine());
        String[] strings = scanner.nextLine().split(" ");
        if (strings.length == 0 || strings == null) {
            return;
        }
        w = new int[strings.length + 1];
        for (int i = 1; i <= strings.length; i++) {
            w[i] = Integer.parseInt(strings[i - 1]);
        }
        strings = scanner.nextLine().split(" ");
        v = new int[strings.length + 1];
        for (int i = 1; i <= strings.length; i++) {
            v[i] = Integer.parseInt(strings[i - 1]);
        }
        dp = new int[strings.length + 1];
        scanner.close();
        // 计算部分
        backTrack(1);
        System.out.println(bestValue);
    }

    // 回溯方法
    private static void backTrack(int n) {
        // 递归终止条件
        if (n >= dp.length) {
            // 找到更优解
            if (curValue > bestValue) {
                bestValue = curValue;
            }
            return;
        }
        // 不选第n个
        dp[n] = 0;
        backTrack(n + 1);
        // 选第n个
        dp[n] = 1;
        if (curWeight + w[n] <= m) {
            curWeight += w[n];
            curValue += v[n];
            backTrack(n + 1);
            // 回溯
            curWeight -= w[n];
            curValue -= v[n];
        }
    }

}
