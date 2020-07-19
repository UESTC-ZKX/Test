package swordOffer;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

/**
 * @ClassName SwordOffer_41
 * @Description: 1，和为s的两个数字
 * 输入一个递增排序的数组和一个数字S，在数组中查找两个数，使得他们的和正好是S，
 * 如果有多对数字的和等于S，输出两个数的乘积最小的。
 * <p>
 * 对应每个测试案例，输出两个数，小的先输出。
 * <p>
 * 2，和为S的连续正数序列
 * 小明很喜欢数学,有一天他在做数学作业时,要求计算出9~16的和,
 * 他马上就写出了正确答案是100。但是他并不满足于此,
 * 他在想究竟有多少种连续的正数序列的和为100(至少包括两个数)。
 * 没多久,他就得到另一组连续正数和为100的序列:18,19,20,21,22。
 * 现在把问题交给你,你能不能也很快的找出所有和为S的连续正数序列? Good Luck!
 * <p>
 * 输出所有和为S的连续正数序列。序列内按照从小至大的顺序，序列间按照开始数字从小到大的顺序
 * @Author UESTC-ZKX
 * @Date 2020/2/17
 **/
public class SwordOffer_41 {

    /**
     * 和为s的两个数字
     *
     * @param array 正序数组
     * @param sum   和
     * @return 两数
     */
    // 利用已经排序的特性，从两端开始 O(N)
    public ArrayList<Integer> FindNumbersWithSum(int[] array, int sum) {
        ArrayList<Integer> res = new ArrayList<>();
        if (array.length < 2) {
            return res;
        }
        int left = 0, right = array.length - 1;
        // 对于和一定时，两数差越大，乘积越小，所以第一次找到的为乘积最小的
        while (left <= right) {
            if (array[left] + array[right] == sum) {
                res.add(array[left]);
                res.add(array[right]);
                break;
            }
            // 若和大于sum，右下标左移
            if (array[left] + array[right] > sum) {
                right--;
            }
            // 若和大于sum，右下标左移
            if (array[left] + array[right] < sum) {
                left++;
            }
        }
        return res;
    }

    // 利用hashMap O(N)
    public ArrayList<Integer> FindNumbersWithSum_1(int[] array, int sum) {
        ArrayList<Integer> res = new ArrayList<>();
        if (array.length < 2) {
            return res;
        }
        HashMap<Integer, Integer> map = new HashMap<>();
        // 最小乘积的最大值不会超过两数相等时的乘积
        int minProduct = (sum / 2 + 1) * (sum / 2 + 1);
        for (int i : array) {
            map.put(sum - i, i);
        }
        for (int j : array) {
            if (map.containsKey(j)) {
                if (j * map.get(j) < minProduct) {
                    res.clear();
                    res.add(Math.min(j, map.get(j)));
                    res.add(Math.max(j, map.get(j)));
                }
            }
        }
        return res;
    }

    /**
     * 和为S的连续正数序列(转化为矩形面积)
     *
     * @param sum 连续序列的和
     * @return 连续序列结果集
     */
    public ArrayList<ArrayList<Integer>> FindContinuousSequence(int sum) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        //
        if (sum == 3) {
            res.add(new ArrayList<Integer>() {{
                add(1);
                add(2);
            }});
        }
        /**
         * i为连续序列的项数(从2开始)
         * 当i为奇数且sum/i = ??.0
         * 当i为偶数且sum/i = ??.5
         * 有解（主注意左界限大于0）
         */
        for (int i = 2; i < sum && (sum / i - i / 2 >= 0); i++) {
            ArrayList<Integer> temp = new ArrayList<>();
            // i为奇数时
            if (i % 2 == 1 && sum % i == 0) {
                for (int j = sum / i - i / 2; j <= sum / i + i / 2; j++) {
                    temp.add(j);
                }
                res.add(temp);
            }
            // i为偶数时
            if (i % 2 == 0 && sum % i == i / 2) {
                for (int j = sum / i - i / 2 + 1; j <= sum / i + i / 2; j++) {
                    temp.add(j);
                }
                res.add(temp);
            }
        }
        Collections.reverse(res);
        return res;
    }
}
