package swordOffer;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class SwordOffer_10Test {

    private SwordOffer_10 swordOffer_10;
    // 测试用例
    int n = 3;
    int res = 2;

    @Before
    public void init() {
        swordOffer_10 = new SwordOffer_10();
    }

    @Test
    public void numberOf1() {
        assertEquals(res,swordOffer_10.NumberOf1(n));
    }
}