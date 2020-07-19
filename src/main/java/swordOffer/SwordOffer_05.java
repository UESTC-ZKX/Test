package swordOffer;

import java.util.ArrayList;
import java.util.Stack;

/**
 * @ClassName SwordOffer_05
 * @Description: 第5题
 * 输入一个链表，按链表从尾到头的顺序返回一个ArrayList。
 * @Author UESTC-ZKX
 * @Date 2020/1/21
 **/
public class SwordOffer_05 extends MyClass {

    // 工具类
    MyUtils myUtils = new MyUtils();

    // 利用栈
    public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
        if (myUtils.isNull(listNode)) {
            return null;
        }
        Stack<Integer> stack = new Stack<Integer>();
        ArrayList<Integer> list = new ArrayList<Integer>();
        while (listNode != null) {
            stack.push(listNode.val);
            listNode = listNode.next;
        }
        while (!stack.empty()) {
            list.add(stack.pop());
        }
        return list;
    }
}

