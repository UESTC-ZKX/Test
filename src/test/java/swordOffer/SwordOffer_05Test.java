package swordOffer;

import org.junit.Before;
import org.junit.Test;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class SwordOffer_05Test extends MyClass {

    SwordOffer_05 swordOffer_05;
    // 测试用例
    private ListNode listNode = new ListNode(0);
    private ListNode listNode_1 = new ListNode(1);
    ArrayList<Integer> res = new ArrayList<Integer>(){{
        add(1);
        add(0);
    }};

    @Before
    public void init(){
        swordOffer_05 = new SwordOffer_05();
        listNode.next = listNode_1;
    }

    @Test
    public void printListFromTailToHead() {
        assertEquals(res,swordOffer_05.printListFromTailToHead(listNode));

    }
}