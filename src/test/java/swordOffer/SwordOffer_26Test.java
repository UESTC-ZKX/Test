package swordOffer;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class SwordOffer_26Test extends MyClass {

    SwordOffer_26 swordOffer_26 = new SwordOffer_26();
    // 测试用例
    private RandomListNode randomListNode_1, randomListNode_2, randomListNode_3;
    private int res = 3;

    @Before
    public void init() {
        randomListNode_1 = new RandomListNode(1);
        randomListNode_2 = new RandomListNode(2);
        randomListNode_3 = new RandomListNode(3);

        randomListNode_1.next = randomListNode_2;
        randomListNode_1.random = randomListNode_3;

        randomListNode_2.next = randomListNode_3;
        randomListNode_2.random = randomListNode_3;
    }

    @Test
    public void RandomListclone() {
        assertEquals(res, swordOffer_26.Clone(randomListNode_1).next.random.label);

    }
}