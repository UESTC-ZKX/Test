package swordOffer;

import java.math.BigInteger;

/**
 * @ClassName SwordOffer_36
 * @Description: 第三十六题
 * 在数组中的两个数字，如果前面一个数字大于后面的数字，则这两个数字组成一个逆序对。
 * 输入一个数组,求出这个数组中的逆序对的总数P。并将P对1000000007取模的结果输出。
 * 即输出P%1000000007
 * 输入描述:
 * 题目保证输入的数组中没有的相同的数字
 * <p>
 * 数据范围：
 * 对于%50的数据,size<=10^4
 * 对于%75的数据,size<=10^5
 * 对于%100的数据,size<=2*10^5
 * <p>
 * 示例1
 * <p>
 * 输入
 * 1,2,3,4,5,6,7,0
 * <p>
 * 输出
 * 7
 * @Author UESTC-ZKX
 * @Date 2020/2/15
 **/
public class SwordOffer_36 {

    private BigInteger res = BigInteger.valueOf(0);

    // 暴力法O（n*n）,超时
    public int InversePairs(int[] array) {
        if (array.length == 0) {
            return 0;
        }
        for (int i = array.length - 1; i > 0; i--) {
            for (int j = i - 1; j >= 0; j--) {
                if (array[j] > array[i]) {
                    res = res.add(BigInteger.valueOf(1));
                }
            }
        }
        return res.remainder(BigInteger.valueOf(1000000007)).intValue();
    }

    // 归并法（n*logn）
    // 思路：[A，B]中的逆序对=[A]的逆序对+[B]中的逆序对+将A，B混排在一起的逆序对
    public int InversePairs_1(int[] array) {
        if (array.length == 0) {
            return 0;
        }
        divided(array, 0, array.length - 1);
        return res.remainder(BigInteger.valueOf(1000000007)).intValue();
    }

    // 分治
    private void divided(int[] array, int left, int right) {
        // 递归终止条件
        if (left >= right) {
            return;
        }
        int mid = (left + right) / 2;
        divided(array, left, mid);
        divided(array, mid + 1, right);
        // 合并
        merge(array, left, mid, right);
    }

    // 合并
    private void merge(int[] array, int left, int mid, int right) {
        // 创建辅助空间
        int[] temp = new int[right - left + 1];
        // 左数组,右数组下标,辅助数组下标
        int i = left, j = mid + 1, index = 0;
        while (i <= mid && j <= right) {
            // 如果左数组小于右数组，无逆序，直接添加
            if (array[i] < array[j]) {
                temp[index++] = array[i++];
            }
            // 如果右数组小于左数组当前值，即左数组剩余值均与当前右值逆序。
            else {
                temp[index++] = array[j++];
                res = res.add(BigInteger.valueOf(mid - i + 1));
            }
        }
        // 若左数组有剩余
        while (i <= mid) {
            temp[index++] = array[i++];
        }
        // 若右数组有剩余
        while (j <= right) {
            temp[index++] = array[j++];
        }
        // 将辅助数组复制回原数组
        for (int t : temp) {
            array[left++] = t;
        }
    }
}
