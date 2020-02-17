package leetCode;

/**
 * @ClassName LeetCoed_198
 * @Description:
 * 打家劫舍1
 * 你是一个专业的小偷，计划偷窃沿街的房屋。每间房内都藏有一定的现金，
 * 影响你偷窃的唯一制约因素就是相邻的房屋装有相互连通的防盗系统，
 * 如果两间相邻的房屋在同一晚上被小偷闯入，系统会自动报警。
 *
 * 给定一个代表每个房屋存放金额的非负整数数组，
 * 计算你在不触动警报装置的情况下，能够偷窃到的最高金额。
 *
 * 示例 1:
 *
 * 输入: [1,2,3,1]
 * 输出: 4
 * 解释: 偷窃 1 号房屋 (金额 = 1) ，
 * 然后偷窃 3 号房屋 (金额 = 3)。
 * 偷窃到的最高金额 = 1 + 3 = 4 。
 * 示例 2:
 *
 * 输入: [2,7,9,3,1]
 * 输出: 12
 * 解释: 偷窃 1 号房屋 (金额 = 2),
 * 偷窃 3 号房屋 (金额 = 9)，
 * 接着偷窃 5 号房屋 (金额 = 1)。
 * 偷窃到的最高金额 = 2 + 9 + 1 = 12 。
 * @Author UESTC-ZKX
 * @Date 2020/2/17
 **/
public class LeetCode_198 {

    public int rob(int[] nums) {
        if(nums.length == 0){
            return 0;
        }
        if(nums.length == 1){
            return nums[0];
        }
        return maxValue_1(nums);
    }

    /**
     * 偷到n时的最大金额(递归)
     * @param nums 房屋序列
     * @param n    n
     * @return 最大金额
     */
    private int maxValue(int[] nums, int n){
        if(n == 0){
            return nums[0];
        }
        if(n == 1){
            return Math.max(nums[1],nums[0]);
        }
        return Math.max(maxValue(nums, n-1),maxValue(nums, n-2)+nums[n]);
    }

    /**
     * 偷到n时的最大金额(迭代)
     * @param nums 房屋序列
     * @return 最大金额
     */
    private int maxValue_1(int[] nums){
        int preMax = nums[0], curMax = Math.max(nums[0], nums[1]);
        for(int i = 2; i < nums.length; i++){
            int temp = curMax;
            curMax = Math.max(curMax, preMax+nums[i]);
            preMax = temp;
        }
        return curMax;
    }

}
