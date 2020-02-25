package swordOffer;

import java.util.*;

/**
 * @ClassName SwordOffer_60
 * @Description:
 * 第六十题
 * 请实现一个函数按照之字形打印二叉树，
 * 即第一行按照从左到右的顺序打印，
 * 第二层按照从右至左的顺序打印，
 * 第三行按照从左到右的顺序打印，其他行以此类推。
 * @Author UESTC-ZKX
 * @Date 2020/2/22
 **/
public class SwordOffer_60 extends MyClass {

    // 层序遍历，隔行反转
    public ArrayList<ArrayList<Integer>> Print(TreeNode pRoot) {
        Queue<MyTreeNode> queue = new LinkedList<>();
        ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
        if(pRoot == null){
            return res;
        }
        MyTreeNode myTreeNode = new MyTreeNode(0, pRoot);
        while (myTreeNode != null && myTreeNode.treeNode != null){
            if(myTreeNode.treeNode.left != null){
                queue.offer(new MyTreeNode(myTreeNode.level+1, myTreeNode.treeNode.left));
            }
            if(myTreeNode.treeNode.right != null){
                queue.offer(new MyTreeNode(myTreeNode.level+1, myTreeNode.treeNode.right));
            }
            if(res.size() <= myTreeNode.level) {
                res.add(new ArrayList<Integer>());
            }
            res.get(myTreeNode.level).add(myTreeNode.treeNode.val);
            if (queue.size() != 0) {
                myTreeNode = queue.poll();
            }else {
                break;
            }
        }
        if(res.size() > 1) {
            for (int i = 1; i < res.size(); i = i + 2) {
                Collections.reverse(res.get(i));
            }
        }
        return res;
    }

    class MyTreeNode{
        int level;
        TreeNode treeNode;
        MyTreeNode(int level, TreeNode treeNode){
            this.level = level;
            this.treeNode = treeNode;
        }
    }
}
