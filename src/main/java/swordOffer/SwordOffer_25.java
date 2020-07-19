package swordOffer;

import java.util.ArrayList;

/**
 * @ClassName SwordOffer_25
 * @Description: 第二十五题
 * 输入一颗二叉树的跟节点和一个整数，
 * 打印出二叉树中结点值的和为输入整数的所有路径。
 * 路径定义为从树的根结点开始往下一直到叶结点所经过的结点形成一条路径。
 * (注意: 在返回值的list中，数组长度大的数组靠前)
 * @Author UESTC-ZKX
 * @Date 2020/2/9
 **/
public class SwordOffer_25 extends MyClass {
    private MyUtils myUtils = new MyUtils();
    private ArrayList<ArrayList<Integer>> res = new ArrayList<>();
    private ArrayList<Integer> list = new ArrayList<>();

    public ArrayList<ArrayList<Integer>> FindPath(TreeNode root, int target) {
        // 递归终止条件
        if (myUtils.isNull(root)) {
            return res;
        }
        list.add(root.val);
        target -= root.val;
        if (target == 0 && myUtils.isNull(root.left) && myUtils.isNull(root.right)) {
            res.add(new ArrayList<>(list));
        }
        FindPath(root.left, target);
        FindPath(root.right, target);
        list.remove(list.size() - 1);
        return res;
    }
}
