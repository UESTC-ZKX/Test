package leetCode.medium;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;


/**
 * @ClassName LeetCode_337
 * @Description: 打家劫舍3
 * 在上次打劫完一条街道之后和一圈房屋后，小偷又发现了一个新的可行窃的地区。
 * 这个地区只有一个入口，我们称之为“根”。 除了“根”之外，
 * 每栋房子有且只有一个“父“房子与之相连。一番侦察之后，
 * 聪明的小偷意识到“这个地方的所有房屋的排列类似于一棵二叉树”。
 * 如果两个直接相连的房子在同一天晚上被打劫，房屋将自动报警。
 * <p>
 * 计算在不触动警报的情况下，小偷一晚能够盗取的最高金额。
 * <p>
 * 示例 1:
 * <p>
 * 输入: [3,2,3,null,3,null,1]
 * <p>
 * 3
 * / \
 * 2   3
 * \   \
 * 3   1
 * <p>
 * 输出: 7
 * 解释: 小偷一晚能够盗取的最高金额 = 3 + 3 + 1 = 7.
 * 示例 2:
 * <p>
 * 输入: [3,4,5,1,3,null,1]
 * <p>
 *      3
 * / \
 * 4   5
 * / \   \
 * 1   3   1
 * <p>
 * 输出: 9
 * 解释: 小偷一晚能够盗取的最高金额 = 4 + 5 = 9.
 * @Author UESTC-ZKX
 * @Date 2020/2/17
 **/
public class LeetCode_337 extends MyClass {

    // 递归法
    public int rob(TreeNode root) {
        // 递归终止条件
        if (root == null) {
            return 0;
        }
        if (root.left != null && root.right != null) {
            return Collections.max(Arrays.asList(
                    rob(root.left) + rob(root.right),

                    rob(root.left.left) +
                            rob(root.left.right) +
                            rob(root.right.left) +
                            rob(root.right.right) + root.val
            ));
        } else {
            if (root.left != null) {
                return Collections.max(Arrays.asList(
                        rob(root.left),
                        rob(root.left.left) + rob(root.left.right) + root.val
                ));
            }
            if (root.right != null) {
                return Collections.max(Arrays.asList(
                        rob(root.right),
                        rob(root.right.left) + rob(root.right.right) + root.val
                ));
            }
        }
        // 递归终止条件
        return root.val;
    }

    // 借助HashMap
    private HashMap<TreeNode, Integer> map = new HashMap<>();

    public int rob_1(TreeNode root) {
        // 递归终止条件
        if (map.containsKey(root)) {
            return map.get(root);
        }
        if (root == null) {
            return 0;
        }
        if (root.left != null && root.right != null) {
            int temp = Collections.max(Arrays.asList(
                    rob_1(root.left) + rob_1(root.right),

                    rob_1(root.left.left) +
                            rob_1(root.left.right) +
                            rob_1(root.right.left) +
                            rob_1(root.right.right) + root.val
            ));
            map.put(root, temp);
            return temp;
        } else {
            if (root.left != null) {
                int temp = Collections.max(Arrays.asList(
                        rob_1(root.left),
                        rob_1(root.left.left) + rob_1(root.left.right) + root.val
                ));
                map.put(root, temp);
                return temp;
            }
            if (root.right != null) {
                int temp = Collections.max(Arrays.asList(
                        rob_1(root.right),
                        rob_1(root.right.left) + rob_1(root.right.right) + root.val
                ));
                map.put(root, temp);
                return temp;
            }
        }
        // 递归终止条件
        map.put(root, root.val);
        return root.val;
    }
}
