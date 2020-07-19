package swordOffer;

import org.junit.Test;

import static org.junit.Assert.*;

public class SwordOffer_44Test {

    SwordOffer_44 swordOffer_44 = new SwordOffer_44();
    // 测试用例
    private int[] numbers = {1, 3, 0, 0, 5};
    private boolean res = true;

    @Test
    public void isContinuous() {
        assertEquals(res, swordOffer_44.isContinuous(numbers));
    }
}