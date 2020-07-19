package swordOffer;

import org.junit.Test;

import static org.junit.Assert.*;

public class SwordOffer_31Test {

    SwordOffer_31 swordOffer_31 = new SwordOffer_31();
    // 测试用例
    private int[] array = {6, -3, -2, 7, -15, 1, 2, 2};
    private int res = 8;

    @Test
    public void findGreatestSumOfSubArray() {
        assertEquals(res, swordOffer_31.FindGreatestSumOfSubArray(array));
    }

    @Test
    public void findGreatestSumOfSubArray_1() {
        assertEquals(res, swordOffer_31.FindGreatestSumOfSubArray_1(array));
    }
}