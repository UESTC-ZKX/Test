package swordOffer;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class SwordOffer_58Test extends MyClass {

    SwordOffer_58 swordOffer_58 = new SwordOffer_58();
    //测试用例
    private TreeLinkNode pHead = new TreeLinkNode(2);
    private TreeLinkNode treeLinkNode1;
    private TreeLinkNode treeLinkNode3;

    @Before
    public void init() {
        treeLinkNode1 = new TreeLinkNode(1);
        treeLinkNode3 = new TreeLinkNode(3);

        treeLinkNode1.left = pHead;

        pHead.next = treeLinkNode1;
        pHead.left = treeLinkNode3;

        treeLinkNode3.next = pHead;

    }


    @Test
    public void getNext() {
        assertEquals(treeLinkNode1, swordOffer_58.GetNext(pHead));
    }
}