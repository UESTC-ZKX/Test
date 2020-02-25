package swordOffer;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName SwordOffer_63
 * @Description:
 * 给定一棵二叉搜索树，请找出其中的第k小的结点。
 * 例如， （5，3，7，2，4，6，8）    中，
 * 按结点数值大小顺序第三小结点的值为4。
 * @Author UESTC-ZKX
 * @Date 2020/2/23
 **/
public class SwordOffer_63 extends MyClass {

    List<TreeNode> list = new ArrayList<>();

    // 利用中序遍历
    public TreeNode KthNode(TreeNode pRoot, int k) {
        inTraversal(pRoot);
        if(k <= list.size() && k > 0){
            return list.get(k-1);
        }
        return null;
    }

    private void inTraversal(TreeNode pRoot){
        if(pRoot == null){
            return;
        }
        inTraversal(pRoot.left);
        list.add(pRoot);
        inTraversal(pRoot.right);
    }

}
