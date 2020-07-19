package leetCode.hard;

import java.util.LinkedList;

/**
 * @ClassName LeetCode_312
 * @Description
 * 有 n 个气球，编号为0 到 n-1，每个气球上都标有一个数字，这些数字存在数组 nums 中。
 * 现在要求你戳破所有的气球。如果你戳破气球 i ，就可以获得 nums[left] * nums[i] * nums[right] 个硬币。
 * 这里的 left 和 right 代表和 i 相邻的两个气球的序号。注意当你戳破了气球 i 后，气球 left 和气球 right 就变成了相邻的气球。
 * 求所能获得硬币的最大数量。
 * 说明:
 * 	你可以假设 nums[-1] = nums[n] = 1，但注意它们不是真实存在的所以并不能被戳破。
 * 	0 ≤ n ≤ 500, 0 ≤ nums[i] ≤ 100
 * 示例:
 * 输入: [3,1,5,8]
 * 输出: 167
 * 解释: nums = [3,1,5,8] --> [3,5,8] -->   [3,8]   -->  [8]  --> []
 *      coins =  3*1*5      +  3*5*8    +  1*3*8      + 1*8*1   = 167
 * @Author UESTC-ZKX
 * @Date 2020/7/19
 **/
public class LeetCode_312 {

    /**
     * 超时法
     * @param nums 气球数组
     * @return 最大值
     */
    public int maxCoins(int[] nums) {
        // 终止条件
        if (nums.length == 1){
            return nums[0];
        }
        // 暂存最大值
        int max = 0;
        for (int i = 0; i < nums.length; i++) {
            int temp = 0;
            int[] newNums = new int[nums.length - 1];
            removeNum(i, nums, newNums);
            if (i == 0 ){
                temp = nums[i] * nums[i+1];
            }
            else if (i == nums.length-1){
                temp = nums[i] * nums[i-1];
            }
            else {
                temp = nums[i-1] * nums[i] * nums[i+1];
            }

            max = Math.max(max, temp + maxCoins(newNums));
        }
        return max;
    }
    /**
     * 删除原数组中的一个元素，形成新数组
     * @param index  下标
     * @param oldNums 原数组
     * @param newNums 新数组
     */
    void removeNum(int index, int[] oldNums, int[] newNums){
        for(int j = 0; j < oldNums.length; j++){
            if(j < index){
                newNums[j] = oldNums[j];
            }
            if(j > index){
                newNums[j-1] = oldNums[j];
            }
        }
    }

    /**
     * leetCode题解
     * @param nums
     * @return 最大值
     */
    public int maxCoins_1(int[] nums) {
        int n = nums.length;
        int[][] rec = new int[n + 2][n + 2];
        int[] val = new int[n + 2];
        val[0] = val[n + 1] = 1;
        for (int i = 1; i <= n; i++) {
            val[i] = nums[i - 1];
        }
        for (int i = n - 1; i >= 0; i--) {
            for (int j = i + 2; j <= n + 1; j++) {
                for (int k = i + 1; k < j; k++) {
                    int sum = val[i] * val[k] * val[j];
                    sum += rec[i][k] + rec[k][j];
                    rec[i][j] = Math.max(rec[i][j], sum);
                }
            }
        }
        return rec[0][n + 1];
    }

}