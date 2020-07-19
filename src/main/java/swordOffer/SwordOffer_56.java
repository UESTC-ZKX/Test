package swordOffer;

/**
 * @ClassName SwordOffer_56
 * @Description: 第五十六题
 * 给一个链表，若其中包含环，
 * 请找出该链表的环的入口结点，
 * 否则，输出null。
 * @Author UESTC-ZKX
 * @Date 2020/2/19
 **/
public class SwordOffer_56 extends MyClass {

    // 追击判断
    public ListNode EntryNodeOfLoop(ListNode pHead) {
        if (pHead == null || pHead.next == null) {
            return null;
        }
        ListNode listNode1 = pHead, listNode2 = pHead;
        // 第一次相遇点
        while (listNode1 != null && listNode2 != null && listNode2.next != null) {
            listNode1 = listNode1.next;
            listNode2 = listNode2.next.next;
            if (listNode1 == listNode2) {
                listNode1 = pHead;
                break;
            }
        }
        // 同速从相遇点和头节点出发，再次相遇点为环的起点
        while (listNode1 != null || listNode2 != null) {
            if (listNode1 == listNode2) {
                return listNode1;
            }
            listNode1 = listNode1.next;
            listNode2 = listNode2.next;
        }
        return null;
    }
}
