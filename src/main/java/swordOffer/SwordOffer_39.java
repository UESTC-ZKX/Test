package swordOffer;

/**
 * @ClassName SwordOffer_39
 * @Description: 第三十九题
 * 输入一棵二叉树，求该树的深度。从根结点到叶结点依次经过的结点
 * （含根、叶结点）形成树的一条路径，最长路径的长度为树的深度。
 * @Author UESTC-ZKX
 * @Date 2020/2/16
 **/
public class SwordOffer_39 extends MyClass {

    public int TreeDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return Math.max(TreeDepth(root.left), TreeDepth(root.right)) + 1;
    }

}
