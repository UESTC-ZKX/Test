package swordOffer;

/**
 * @ClassName SwordOffer_19
 * @Description: 第十九题
 * 操作给定的二叉树，将其变换为源二叉树的镜像。
 * 二叉树的镜像定义：源二叉树
 * 1
 * /  \
 * 2   3
 * 镜像二叉树
 * 1
 * /  \
 * 3     2
 * @Author UESTC-ZKX
 * @Date 2020/2/2
 **/
public class SwordOffer_19 extends MyClass {
    MyUtils myUtils = new MyUtils();

    // 递归法
    public void Mirror(TreeNode root) {
        // 递归终止条件
        if (myUtils.isNull(root) || (myUtils.isNull(root.left) && myUtils.isNull(root.right))) {
            return;
        }
        // 交换左右节点
        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;
        // 递归
        Mirror(root.left);
        Mirror(root.right);
    }
}
