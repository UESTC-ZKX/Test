package swordOffer;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class SwordOffer_14Test {

    private SwordOffer_14 swordOffer_14;
    // 测试用例
    private int[] array = {1, 2, 3, 4, 5};
    private int[] res = {1, 3, 5, 2, 4};

    @Before
    public void init() {
        swordOffer_14 = new SwordOffer_14();
    }

    @Test
    public void reOrderArray() {
        swordOffer_14.reOrderArray(array);
        assertArrayEquals(res, array);
    }
}