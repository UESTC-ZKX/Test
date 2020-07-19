package swordOffer;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName SwordOffer_27
 * @Description: 第二十七题
 * 输入一棵二叉搜索树，
 * 将该二叉搜索树转换成一个排序的双向链表。
 * 要求不能创建任何新的结点，只能调整树中结点指针的指向。
 * @Author UESTC-ZKX
 * @Date 2020/2/11
 **/
public class SwordOffer_27 extends MyClass {
    MyUtils myUtils = new MyUtils();

    public TreeNode Convert(TreeNode pRootOfTree) {
        if (myUtils.isNull(pRootOfTree)) {
            return null;
        }

        List<TreeNode> list = new ArrayList<>();
        inTraversal(pRootOfTree, list);

        for (int i = 0; i < list.size(); i++) {
            if (i - 1 >= 0) {
                list.get(i).left = list.get(i - 1);
            }
            if (i + 1 < list.size()) {
                list.get(i).right = list.get(i + 1);
            }
        }
        return list.get(0);
    }

    // 中序遍历
    private void inTraversal(TreeNode treeNode, List<TreeNode> list) {
        if (myUtils.isNull(treeNode)) {
            return;
        }
        inTraversal(treeNode.left, list);
        list.add(treeNode);
        inTraversal(treeNode.right, list);
    }
}
