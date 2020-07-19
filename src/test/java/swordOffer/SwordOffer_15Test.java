package swordOffer;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class SwordOffer_15Test extends MyClass {

    SwordOffer_15 swordOffer_15;
    // 测试用例
    ListNode listNode_1 = new ListNode(1);
    ListNode listNode_2 = new ListNode(2);
    ListNode listNode_3 = new ListNode(3);
    ListNode listNode_4 = new ListNode(4);
    int k = 2;
    ListNode res = listNode_3;

    @Before
    public void init() {
        swordOffer_15 = new SwordOffer_15();
        listNode_1.next = listNode_2;
        listNode_2.next = listNode_3;
        listNode_3.next = listNode_4;
    }

    @Test
    public void findKthToTail() {
        assertEquals(res.val, swordOffer_15.FindKthToTail(listNode_1, k).val);
    }
}