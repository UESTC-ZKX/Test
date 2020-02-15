package swordOffer;

import org.junit.Test;

import static org.junit.Assert.*;

public class SwordOffer_36Test {

    SwordOffer_36 swordOffer_36 = new SwordOffer_36();
    // 测试用例
    private int[] array = {1,2,3,4,5,6,7,0};
    private int res = 7;

    @Test
    public void inversePairs() {
        assertEquals(res, swordOffer_36.InversePairs(array));
    }

    @Test
    public void inversePairs_1() {
        assertEquals(res, swordOffer_36.InversePairs_1(array));
    }
}