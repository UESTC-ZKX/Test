package swordOffer;

import java.util.ArrayList;

/**
 * @ClassName SwordOffer_20
 * @Description: 第二十题
 * 输入一个矩阵，按照从外向里以顺时针的顺序依次打印出每一个数字，
 * 例如，如果输入如下4 X 4矩阵：
 * 1   2   3  4
 * 5   6   7  8
 * 9  10  11  12
 * 13 14  15  16
 * 则依次打印出数字
 * 1,2,3,4,8,12,16,15,14,13,9,5,6,7,11,10.
 * @Author UESTC-ZKX
 * @Date 2020/2/3
 **/
public class SwordOffer_20 {

    MyUtils myUtils = new MyUtils();

    public ArrayList<Integer> printMatrix(int[][] matrix) {
        if (myUtils.isNull(matrix)) {
            return null;
        }

        ArrayList<Integer> list = new ArrayList<>();
        // 指针
        int i = 0, j = 0;
        // 边界
        int up = 0, down = matrix.length - 1, left = 0, right = matrix[0].length - 1;
        int totalNum = (right + 1) * (down + 1);
        int existNum = 0;

        while (existNum < totalNum) {
            // 有四个拐点
            // 左上
            for (j = left; j <= right; j++) {
                list.add(matrix[up][j]);
                existNum++;
            }
            up++;
            if (existNum == totalNum) {
                break;
            }
            // 右上
            for (i = up; i <= down; i++) {
                list.add(matrix[i][right]);
                existNum++;
            }
            right--;
            if (existNum == totalNum) {
                break;
            }
            // 右下
            for (j = right; j >= left; j--) {
                list.add(matrix[down][j]);
                existNum++;
            }
            down--;
            if (existNum == totalNum) {
                break;
            }
            // 左下
            for (i = down; i >= up; i--) {
                list.add(matrix[i][left]);
                existNum++;
            }
            left++;
        }
        return list;
    }
}
