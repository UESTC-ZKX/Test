package swordOffer;

/**
 * @ClassName swordOffer.MyClass
 * @Description: 自定义数据结构的类
 * @Author UESTC-ZKX
 * @Date 2020/1/21
 **/
public class MyClass {

    // 链表节点
    public class ListNode {
        int val;
        ListNode next = null;
        ListNode(int val) {
            this.val = val;
        }
    }

    // 树节点
    public class TreeNode {
        int val;
        TreeNode left = null;
        TreeNode right = null;
        TreeNode(int val) {
            this.val = val;
        }
    }

    // 随机链表节点
    public class RandomListNode {
        int label;
        RandomListNode next = null;
        RandomListNode random = null;
        RandomListNode(int label) {
            this.label = label;
        }
    }

    // 带父节点的树节点
    public class TreeLinkNode{
        int val;
        TreeLinkNode left = null;
        TreeLinkNode right = null;
        TreeLinkNode next = null;

        TreeLinkNode(int val) {
            this.val = val;
        }
    }
}
