package swordOffer;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName SwordOffer_66
 * @Description: 第六十六题
 * 请设计一个函数，用来判断在一个矩阵中是否存在一条包含某字符串所有字符的路径。
 * 路径可以从矩阵中的任意一个格子开始，
 * 每一步可以在矩阵中向左，向右，向上，向下移动一个格子。
 * 如果一条路径经过了矩阵中的某一个格子，则该路径不能再进入该格子。
 * 例如:
 * a b c e
 * s f c s
 * a d e e
 * 矩阵中包含一条字符串"bcced"的路径，
 * 但是矩阵中不包含"abcb"路径，
 * 因为字符串的第一个字符b占据了矩阵中的第一行第二个格子之后，
 * 路径不能再次进入该格子。
 * @Author UESTC-ZKX
 * @Date 2020/2/25
 **/
public class SwordOffer_66 {

    public boolean hasPath(char[] matrix, int rows, int cols, char[] str) {
        if (matrix.length <= 0 || rows <= 0 || cols <= 0 || str.length <= 0) {
            return false;
        }
        char[][] chars = new char[rows][cols];
        // 记录起点
        List<Integer> list = new ArrayList<>();

        for (int i = 0; i < matrix.length; i++) {
            chars[i / cols][i % cols] = matrix[i];
            if (matrix[i] == str[0]) {
                list.add(i);
            }
        }
        // 如果没找到起点
        if (list.size() == 0) {
            return false;
        }
        // 遍历起点
        for (int i : list) {
            // 记录是否经过
            boolean[][] isPass = new boolean[rows][cols];
            int x = i / cols, y = i % cols;
            if (search(chars, x, y, str, 0, isPass)) {
                return true;
            }
        }
        return false;
    }

    /**
     * 递归回溯寻找
     *
     * @param chars  矩阵
     * @param x      纵坐标
     * @param y      横坐标
     * @param str    目标字符串
     * @param index  目标字符串下标
     * @param isPass 是否经过
     * @return
     */
    private boolean search(char[][] chars, int x, int y, char[] str, int index, boolean[][] isPass) {

        // 递归终止条件
        if (x < 0 || x >= chars.length || y < 0 || y >= chars[0].length || chars[x][y] != str[index] || isPass[x][y]) {
            return false;
        }
        if (index == str.length - 1) {
            return true;
        }
        isPass[x][y] = true;
        if (search(chars, x + 1, y, str, index + 1, isPass) ||
                search(chars, x - 1, y, str, index + 1, isPass) ||
                search(chars, x, y + 1, str, index + 1, isPass) ||
                search(chars, x, y - 1, str, index + 1, isPass)) {
            return true;
        }
        // 回溯
        isPass[x][y] = false;
        return false;
    }

}
