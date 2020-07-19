package leetCode.medium;

/**
 * @ClassName LeetCode_213
 * @Description: 打家劫舍2
 * 你是一个专业的小偷，计划偷窃沿街的房屋，每间房内都藏有一定的现金。
 * 这个地方所有的房屋都围成一圈，这意味着第一个房屋和最后一个房屋是紧挨着的。
 * 同时，相邻的房屋装有相互连通的防盗系统，
 * 如果两间相邻的房屋在同一晚上被小偷闯入，系统会自动报警。
 * <p>
 * 给定一个代表每个房屋存放金额的非负整数数组，
 * 计算你在不触动警报装置的情况下，能够偷窃到的最高金额。
 * <p>
 * 示例 1:
 * <p>
 * 输入: [2,3,2]
 * 输出: 3
 * 解释:
 * 你不能先偷窃 1 号房屋（金额 = 2），
 * 然后偷窃 3 号房屋（金额 = 2）,
 * 因为他们是相邻的。
 * 示例 2:
 * <p>
 * 输入: [1,2,3,1]
 * 输出: 4
 * 解释:
 * 你可以先偷窃 1 号房屋（金额 = 1），
 * 然后偷窃 3 号房屋（金额 = 3）。
 * 偷窃到的最高金额 = 1 + 3 = 4 。
 * @Author UESTC-ZKX
 * @Date 2020/2/17
 **/
public class LeetCode_213 {

    public int rob(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }
        return Math.max(maxValue(nums, 0, nums.length - 1), maxValue(nums, 1, nums.length));
    }

    /**
     * 为n时的最大价值
     *
     * @param nums  房屋序列
     * @param start 开始下标
     * @param end   结束下标
     * @return 最大价值
     */
    private int maxValue(int[] nums, int start, int end) {
        if (end - start <= 0) {
            return 0;
        }
        if (end - start <= 1) {
            return nums[start];
        }
        int preMax = nums[start], curMax = Math.max(nums[start], nums[start + 1]);
        for (int i = start + 2; i < end; i++) {
            int temp = curMax;
            curMax = Math.max(preMax + nums[i], curMax);
            preMax = temp;
        }
        return curMax;
    }

}
