package swordOffer;

/**
 * @ClassName MyClass
 * @Description: 自定义数据结构的类
 * @Author UESTC-ZKX
 * @Date 2020/1/21
 **/
public class MyClass {

    // 链表节点
    class ListNode {
        int val;
        ListNode next = null;
        ListNode(int val) {
            this.val = val;
        }
    }

    // 树节点
    class TreeNode {
        int val;
        TreeNode left = null;
        TreeNode right = null;
        TreeNode(int val) {
            this.val = val;
        }
    }
}