package swordOffer;

/**
 * @ClassName SwordOffer_03
 * @Description: 第3题
 * 一个二维数组，每一行从左到右递增，每一列从上到下递增．
 * 输入一个二维数组和一个整数，判断数组中是否含有整数
 * 例如：
 * 输入a = 1 2 3
 * 3 4 5
 * num = 1;
 * 输出 true
 * @Author UESTC-ZKX
 * @Date 2020/1/21
 **/
public class SwordOffer_03 {
    MyUtils myUtils = new MyUtils();

    // 暴力法 时间复杂度 o(n*m)
    boolean find(int a[][], int num) {
        if (myUtils.isNull(a, num)) {
            return false;
        }
        for (int b[] : a) {
            for (int i : b) {
                if (i == num) {
                    return true;
                }
            }
        }
        return false;
    }

    // 半二分法 时间复杂度 o(n*logm)
    boolean find_1(int a[][], int num) {
        if (myUtils.isNull(a, num)) {
            return false;
        }
        for (int b[] : a) {
            int left = 0;
            int right = b.length - 1;
            int mid = 0;
            while (left <= right) {
                mid = (left + right) / 2;
                if (b[mid] < num) {
                    left = mid + 1;
                } else {
                    if (b[mid] > num) {
                        right = mid - 1;
                    } else {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    // 切片法 时间复杂度o(n + m)
    boolean find_2(int a[][], int num) {
        if (myUtils.isNull(a, num)) {
            return false;
        }
        //长n,宽m
        int n = a.length - 1;
        int m = a[0].length - 1;
        // 从左下开始切
        for (int i = n, j = 0; i >= 0 && j <= m; ) {
            // 左下临时变量
            int temp = a[i][j];
            if (temp == num) {
                return true;
            } else {
                if (num > temp) {
                    j++;
                } else {
                    i--;
                }
            }
        }
        return false;
    }

}
