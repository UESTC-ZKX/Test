package swordOffer;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class SwordOffer_08Test {

    private SwordOffer_08 swordOffer_08;
    // 测试用例
    private int[] array = {3,4,5,1,2};
    private int res = 1;

    @Before
    public void init(){ swordOffer_08 = new SwordOffer_08(); }

    @Test
    public void minNumberInRotateArray() {
        assertEquals(res,swordOffer_08.minNumberInRotateArray(array));
    }

    @Test
    public void minNumberInRotateArray_1() {
        assertEquals(res,swordOffer_08.minNumberInRotateArray_1(array));
    }
}