package swordOffer;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class SwordOffer_17Test extends MyClass {

    SwordOffer_17 swordOffer_17;
    MyUtils myUtils;
    // 测试用例
    ListNode listNode_1 = new ListNode(1);
    ListNode listNode_2 = new ListNode(2);
    ListNode listNode_3 = new ListNode(3);
    ListNode listNode_4 = new ListNode(4);
    int[] res = new int[]{1, 2, 3, 4};

    @Before
    public void init() {
        swordOffer_17 = new SwordOffer_17();
        myUtils = new MyUtils();
        listNode_1.next = listNode_3;
        listNode_2.next = listNode_4;
    }

    @Test
    public void merge() {
        ListNode head = swordOffer_17.Merge(listNode_1, listNode_2);
        int[] array = myUtils.linkListToArray(head);
        assertArrayEquals(res, array);
    }
}