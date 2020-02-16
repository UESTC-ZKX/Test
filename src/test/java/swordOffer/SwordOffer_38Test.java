package swordOffer;

import org.junit.Test;

import static org.junit.Assert.*;

public class SwordOffer_38Test {

    SwordOffer_38 swordOffer_38 = new SwordOffer_38();
    // 测试用例
    private int[] array = {3,3,3,3,4,5};
    private int key = 3;
    private int res = 4;

    @Test
    public void getNumberOfK() {
        assertEquals(res, swordOffer_38.GetNumberOfK(array, key));
    }
}