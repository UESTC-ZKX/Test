package realTest.bilibili;

import java.util.Scanner;

/**
 * @ClassName ChangeWord
 * @Description: 给出两个单词word1和word2，计算出将word1 转换为word2的最少操作次数。
 * <p>
 * 你总共三种操作方法：
 * <p>
 * 插入一个字符
 * 删除一个字符
 * 替换一个字符
 * <p>
 * 输入描述:
 * 一共两行，分别代表word1和word2
 * <p>
 * 输出描述:
 * 直接打印次数即可
 * <p>
 * 输入例子1:
 * abc
 * abd
 * <p>
 * 输出例子1:
 * 1
 * <p>
 * 例子说明1:
 * 把c->d，只需要一次操作
 * @Author UESTC-ZKX
 * @Date 2020/2/21
 **/
public class ChangeWord {

    // 借助n*m的矩阵
    public static void main(String[] args) {
        int res = 0;
        Scanner scanner = new Scanner(System.in);
        String string1 = scanner.nextLine();
        String string2 = scanner.nextLine();
        scanner.close();
        int n = string1.length(), m = string2.length();
        if (n == 0 || m == 0) {
            res = Math.max(n, m);
            System.out.println(res);
            return;
        }
        int[][] dp = new int[n][m];
        for (int i = 0; i < n; i++) {
            dp[i][0] = i;
        }
        for (int i = 0; i < m; i++) {
            dp[0][i] = i;
        }
        for (int i = 1; i < n; i++) {
            for (int j = 1; j < m; j++) {
                if (string1.charAt(i) == string2.charAt(j)) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.min(dp[i - 1][j - 1] + 1, Math.min(dp[i - 1][j] + 1, dp[i][j - 1] + 1));
                }
            }
        }
        res = dp[n - 1][m - 1];
        System.out.println(res);
    }
}
