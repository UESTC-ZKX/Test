package swordOffer;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @ClassName SwordOffer_61
 * @Description: 第六十一题
 * 从上到下按层打印二叉树，
 * 同一层结点从左至右输出。每一层输出一行。
 * @Author UESTC-ZKX
 * @Date 2020/2/22
 **/
public class SwordOffer_61 extends MyClass {

    ArrayList<ArrayList<Integer>> Print(TreeNode pRoot) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        Queue<MyTreeNode> queue = new LinkedList<>();
        if (pRoot == null) {
            return res;
        }
        MyTreeNode myTreeNode = new MyTreeNode(0, pRoot);
        while (myTreeNode != null && myTreeNode.treeNode != null) {
            if (myTreeNode.treeNode.left != null) {
                queue.offer(new MyTreeNode(myTreeNode.level + 1, myTreeNode.treeNode.left));
            }
            if (myTreeNode.treeNode.right != null) {
                queue.offer(new MyTreeNode(myTreeNode.level + 1, myTreeNode.treeNode.right));
            }
            if (res.size() <= myTreeNode.level) {
                res.add(new ArrayList<Integer>());
            }
            res.get(myTreeNode.level).add(myTreeNode.treeNode.val);
            myTreeNode = queue.poll();
        }
        return res;
    }

    class MyTreeNode {
        int level;
        TreeNode treeNode;

        MyTreeNode(int level, TreeNode treeNode) {
            this.level = level;
            this.treeNode = treeNode;
        }
    }
}
