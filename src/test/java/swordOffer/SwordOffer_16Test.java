package swordOffer;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class SwordOffer_16Test extends MyClass {

    SwordOffer_16 swordOffer_16;
    MyUtils myUtils;
    // 测试用例
    ListNode listNode_1 = new ListNode(1);
    ListNode listNode_2 = new ListNode(2);
    ListNode listNode_3 = new ListNode(3);
    ListNode listNode_4 = new ListNode(4);
    int[] res = new int[]{4, 3, 2, 1};

    @Before
    public void init() {
        swordOffer_16 = new SwordOffer_16();
        myUtils = new MyUtils();
        listNode_1.next = listNode_2;
        listNode_2.next = listNode_3;
        listNode_3.next = listNode_4;
    }

    @Test
    public void reverseList() {
        ListNode head = swordOffer_16.ReverseList(listNode_1);
        int[] array = new int[res.length];
        int i = 0;
        while (head != null) {
            array[i++] = head.val;
            head = head.next;
        }
        assertArrayEquals(res, array);
    }

    @Test
    public void reverseList_1() {
        ListNode head = swordOffer_16.ReverseList_1(listNode_1);
        int[] array = myUtils.linkListToArray(head);
        assertArrayEquals(res, array);
    }
}