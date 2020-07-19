package swordOffer;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class SwordOffer_56Test extends MyClass {

    SwordOffer_56 swordOffer_56 = new SwordOffer_56();
    //测试用例
    private ListNode pHead = new ListNode(0);
    private ListNode res = pHead;

    @Before
    public void init() {
        pHead.next = new ListNode(1);
        pHead.next.next = new ListNode(2);
        pHead.next.next.next = pHead;
    }

    @Test
    public void entryNodeOfLoop() {

        assertEquals(res, swordOffer_56.EntryNodeOfLoop(pHead));

    }
}