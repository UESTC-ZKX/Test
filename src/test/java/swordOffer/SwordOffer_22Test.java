package swordOffer;

import org.junit.Test;

import static org.junit.Assert.*;

public class SwordOffer_22Test {

    SwordOffer_22 swordOffer_22 = new SwordOffer_22();
    // 测试用例
    int[] pushA = {1, 2, 3, 4, 5};
    int[] popA = {4, 3, 5, 1, 2};
    boolean res = false;

    @Test
    public void isPopOrder() {
        assertEquals(res, swordOffer_22.IsPopOrder(pushA, popA));
    }
}