package swordOffer;

/**
 * @ClassName SwordOffer_59
 * @Description: 第五十九题
 * 请实现一个函数，用来判断一颗二叉树是不是对称的。
 * 注意，如果一个二叉树同此二叉树的镜像是同样的，定义其为对称的。
 * @Author UESTC-ZKX
 * @Date 2020/2/20
 **/
public class SwordOffer_59 extends MyClass {

    public boolean isSymmetrical(TreeNode pRoot) {
        if (pRoot == null) {
            return true;
        }
        return isMirror(pRoot.left, pRoot.right);

    }

    private boolean isMirror(TreeNode left, TreeNode right) {
        if (left == null && right == null) {
            return true;
        }
        if (left == null || right == null || left.val != right.val) {
            return false;
        }
        return isMirror(left.left, right.right) && isMirror(left.right, right.left);
    }

}
