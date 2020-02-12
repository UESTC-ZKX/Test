package swordOffer;

import java.util.ArrayList;

/**
 * @ClassName SwordOffer_23
 * @Description:
 * 第二十三题
 * 从上往下打印出二叉树的每个节点，同层节点从左至右打印。
 * @Author UESTC-ZKX
 * @Date 2020/2/4
 **/
public class SwordOffer_23 extends MyClass {
    MyUtils myUtils = new MyUtils();
    public ArrayList<Integer> PrintFromTopToBottom(TreeNode root) {
        if(myUtils.isNull(root)){
            return null;
        }
        ArrayList<Integer> res = new ArrayList<Integer>();
        res = (ArrayList<Integer>) myUtils.traversal(root, "LEVEL");
        return res;
    }

}
