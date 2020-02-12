package swordOffer;

import java.util.Stack;

/**
 * @ClassName SwordOffer_16
 * @Description:
 * 第十六题
 * 输入一个链表，反转链表后，输出新链表的表头。
 * @Author UESTC-ZKX
 * @Date 2020/1/28
 **/
public class SwordOffer_16 extends MyClass {
    MyUtils myUtils = new MyUtils();
    // 利用栈
    public ListNode ReverseList(ListNode head) {
        if(myUtils.isNull(head)){
            return null;
        }
        ListNode res,temp;
        Stack<ListNode> stack = new Stack();
        while (head != null){
            stack.push(head);
            head = head.next;
        }
        res = stack.pop();
        temp = res;
        while (!stack.empty()){
            temp.next = stack.pop();
            temp = temp.next;
        }
        temp.next = null;
        return res;
    }

    // 临时变量
    public ListNode ReverseList_1(ListNode head){
        if(myUtils.isNull(head, head.next)){
            return head;
        }
        ListNode res;
        ListNode left,temp,right;
        left = null;
        temp = head;
        right = null;
        while (temp != null){
           right = temp.next;
           temp.next = left;
           left = temp;
           temp = right;
        }
        res = left;
        return res;
    }
}
