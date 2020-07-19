package swordOffer;

/**
 * @ClassName SwordOffer_31
 * @Description: 第三十一题
 * 在古老的一维模式识别中,常常需要计算连续子向量的最大和,
 * 当向量全为正数的时候,问题很好解决。
 * 但是,如果向量中包含负数,是否应该包含某个负数,并期望旁边的正数会弥补它呢？
 * 例如:{6,-3,-2,7,-15,1,2,2},
 * 连续子向量的最大和为8(从第0个开始,到第3个为止)。
 * 给一个数组，返回它的最大连续子序列的和，你会不会被他忽悠住？(子向量的长度至少是1)
 * @Author UESTC-ZKX
 * @Date 2020/2/13
 **/
public class SwordOffer_31 {

    MyUtils myUtils = new MyUtils();

    // 暴力法 时间复杂度O（N*N）
    public int FindGreatestSumOfSubArray(int[] array) {
        int res;
//        if(myUtils.isNull(array) || array.length == 0){
//            return ???;
//        }
        int curNum, maxNum = array[0];
        for (int i = 0; i < array.length; i++) {
            curNum = array[i];
            if (curNum > maxNum) {
                maxNum = curNum;
            }
            for (int j = i + 1; j < array.length; j++) {
                curNum += array[j];
                if (curNum > maxNum) {
                    maxNum = curNum;
                }
            }
        }
        res = maxNum;
        return res;
    }

    // 动态规划 时间复杂度O(N)
    public int FindGreatestSumOfSubArray_1(int[] array) {
        int res = array[0];
        // 状态转移方程，dp[i]为包含第i个元素在内的最大子序列
        int[] dp = new int[array.length];
        dp[0] = array[0];
        for (int i = 1; i < array.length; i++) {
            dp[i] = Math.max(array[i], dp[i - 1] + array[i]);
            res = Math.max(res, dp[i]);
        }
        return res;
    }
}
