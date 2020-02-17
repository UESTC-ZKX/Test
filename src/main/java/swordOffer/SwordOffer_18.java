package swordOffer;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName SwordOffer_18
 * @Description:
 * 第十八题
 * 输入两棵二叉树A，B，判断B是不是A的子结构。
 * （ps：我们约定空树不是任意一个树的子结构）
 * @Author UESTC-ZKX
 * @Date 2020/1/28
 **/
public class SwordOffer_18 extends MyClass {
    MyUtils myUtils = new MyUtils();

    // 中序遍历和前序遍历的公共序列找子树
    public boolean HasSubtree(TreeNode root1,TreeNode root2) {
        if(myUtils.isNull(root1,root2)){
            return false;
        }
        List<Integer> list1 = new ArrayList<>();
        List<Integer> list2 = new ArrayList<>();
        String in1 = myUtils.traversal(root1, "IN").toString();
        String in2 = myUtils.traversal(root2, "IN").toString();
        String pre1 = myUtils.traversal(root1, "PRE").toString();
        String pre2 = myUtils.traversal(root2, "PRE").toString();
        in1 = in1.substring(1,in1.length()-1);
        in2 = in2.substring(1,in2.length()-1);
        pre1 = pre1.substring(1,pre1.length()-1);
        pre2 = pre2.substring(1,pre2.length()-1);
        if(in1.indexOf(in2) != -1 && pre1.indexOf(pre2) != -1){
            return true;
        }
        else {
            return false;
        }
    }

    // 递归法
    public boolean HasSubtree_1(TreeNode root1, TreeNode root2){
        if(myUtils.isNull(root1,root2)){
            return false;
        }
        return TreeEquals(root1, root2) ||
                HasSubtree_1(root1.left, root2) ||
                HasSubtree_1(root1.right, root2);
    }
    // 子结构相等
    private boolean TreeEquals(TreeNode tree1, TreeNode tree2){
        if ( tree2 == null ){
            return true;
        }
        if ( tree1 == null ){
            return false;
        }

        if ( tree1.val != tree2.val ){
            return false;
        }
        return TreeEquals(tree1.left, tree2.left)
                && TreeEquals(tree1.right, tree2.right);

    }
}
