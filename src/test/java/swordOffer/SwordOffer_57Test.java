package swordOffer;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class SwordOffer_57Test extends MyClass {

    SwordOffer_57 swordOffer_57 = new SwordOffer_57();
    MyUtils myUtils = new MyUtils();
    // 测试用例
    private ListNode pHead = new ListNode(1);
    private int[] res = {1,2,5};

    @Before
    public void init(){
        pHead.next = new ListNode(2);
        pHead.next.next = new ListNode(3);
        pHead.next.next.next = new ListNode(3);
        pHead.next.next.next.next = new ListNode(4);
        pHead.next.next.next.next.next = new ListNode(4);
        pHead.next.next.next.next.next.next = new ListNode(5);
//        pHead.next.next.next.next.next.next.next = new ListNode(5);
    }

    @Test
    public void deleteDuplication() {
        assertArrayEquals(res, myUtils.linkListToArray(swordOffer_57.deleteDuplication(pHead)));
    }
}