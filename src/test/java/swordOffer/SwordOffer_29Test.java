package swordOffer;

import org.junit.Test;

import static org.junit.Assert.*;

public class SwordOffer_29Test {

    SwordOffer_29 swordOffer_29 = new SwordOffer_29();
    // 测试用例
    private int[] array = {1, 2, 3, 2, 2, 2, 5, 4, 2};
    private int res = 2;

    @Test
    public void moreThanHalfNum_Solution() {
        assertEquals(res, swordOffer_29.MoreThanHalfNum_Solution(array));
    }
}