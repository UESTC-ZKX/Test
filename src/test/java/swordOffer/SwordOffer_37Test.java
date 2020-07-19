package swordOffer;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class SwordOffer_37Test extends MyClass {

    SwordOffer_37 swordOffer_37 = new SwordOffer_37();
    // 测试用例
    private ListNode pHead1, pHead2;
    private ListNode res;

    @Before
    public void init() {
        pHead1 = new ListNode(1);
        pHead2 = new ListNode(2);
        res = new ListNode(3);

        pHead1.next = res;
        pHead2.next = res;
    }

    @Test
    public void findFirstCommonNode() {
        assertEquals(res, swordOffer_37.FindFirstCommonNode(pHead1, pHead2));
    }
}