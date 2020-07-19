package swordOffer;

/**
 * @ClassName SwordOffer_67
 * @Description: 第六十七题
 * 地上有一个m行和n列的方格。
 * 一个机器人从坐标0,0的格子开始移动，
 * 每一次只能向左，右，上，下四个方向移动一格，
 * 但是不能进入行坐标和列坐标的数位之和大于k的格子。
 * 例如，当k为18时，机器人能够进入方格（35,37），
 * 因为3+5+3+7 = 18。但是，它不能进入方格（35,38），
 * 因为3+5+3+8 = 19。请问该机器人能够达到多少个格子？
 * @Author UESTC-ZKX
 * @Date 2020/2/25
 **/
public class SwordOffer_67 {

    public int movingCount(int threshold, int rows, int cols) {
        if (threshold < 0 || rows < 1 || cols < 1) {
            return 0;
        }
        boolean[][] isPass = new boolean[rows][cols];
        return search(threshold, isPass, 0, 0);
    }

    private int search(int threshold, boolean[][] isPass, int x, int y) {
        // 终止条件
        if (x < 0 || x >= isPass.length || y < 0 || y >= isPass[0].length || isPass[x][y] || sum(x) + sum(y) > threshold) {
            return 0;
        }
        isPass[x][y] = true;
        return search(threshold, isPass, x + 1, y) +
                search(threshold, isPass, x - 1, y) +
                search(threshold, isPass, x, y + 1) +
                search(threshold, isPass, x, y - 1) + 1;
    }

    private int sum(int n) {
        int res = 0;
        while (n > 0) {
            res += n % 10;
            n /= 10;
        }
        return res;
    }

}
