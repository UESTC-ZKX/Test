package swordOffer;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class SwordOffer_11Test {

    SwordOffer_11 swordOffer_11;
    //测试用例
    double base = 2;
    int exponent = 4;
    double res = 16;

    @Before
    public void init() {
        swordOffer_11 = new SwordOffer_11();
    }

    @Test
    public void power() {
        assertEquals(res, swordOffer_11.Power(base, exponent), 0);
    }
}