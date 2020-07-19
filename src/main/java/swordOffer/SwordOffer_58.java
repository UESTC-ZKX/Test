package swordOffer;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName SwordOffer_58
 * @Description: 第五十八题
 * 给定一个二叉树和其中的一个结点，
 * 请找出中序遍历顺序的下一个结点并且返回。
 * 注意，树中的结点不仅包含左右子结点，同时包含指向父结点的指针。
 * @Author UESTC-ZKX
 * @Date 2020/2/20
 **/
public class SwordOffer_58 extends MyClass {

    // 中序遍历集合
    private List<TreeLinkNode> list = new ArrayList<>();

    public TreeLinkNode GetNext(TreeLinkNode pNode) {
        if (pNode == null) {
            return null;
        }
        TreeLinkNode root = pNode;
        // 找到根节点
        while (root.next != null) {
            root = root.next;
        }
        traversal(root);
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i) == pNode && i + 1 < list.size()) {
                return list.get(i + 1);
            }
        }
        return null;
    }

    //中序遍历
    private void traversal(TreeLinkNode root) {
        if (root == null) {
            return;
        }
        traversal(root.left);
        list.add(root);
        traversal(root.right);
    }
}
