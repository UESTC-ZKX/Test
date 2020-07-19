package swordOffer;

import org.junit.Test;

import static org.junit.Assert.*;

public class SwordOffer_24Test {

    SwordOffer_24 swordOffer_24 = new SwordOffer_24();
    // 测试用例
    private int[] sequence = {2, 3, 1};
    private boolean res = true;

    @Test
    public void verifySquenceOfBST() {
        assertEquals(res, swordOffer_24.VerifySquenceOfBST(sequence));
    }
}