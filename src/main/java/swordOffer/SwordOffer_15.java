package swordOffer;

import java.util.Stack;

/**
 * @ClassName SwordOffer_15
 * @Description:
 * 第十五题
 * 输入一个链表，输出该链表中倒数第k个结点。
 * @Author UESTC-ZKX
 * @Date 2020/1/25
 **/
public class SwordOffer_15 extends MyClass {
    MyUtils myUtils = new MyUtils();
    public ListNode FindKthToTail(ListNode head,int k) {
        if (myUtils.isNull(head) || k < 1){
            return null;
        }
        Stack<ListNode> stack = new Stack();
        int length = 0;
        while (head != null){
            stack.push(head);
            head = head.next;
            length++;
        }
        if(k > length){
            return null;
        }

        while (k-- > 1){
            if (stack.empty()){
                return null;
            }
            else {
                stack.pop();
            }
        }
        return stack.peek();
    }

    // TODO 双指针相距k，同步遍历，后指针到头时，前指针为结果
}
