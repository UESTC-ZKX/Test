package swordOffer;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class SwordOffer_09Test {

    private SwordOffer_09 swordOffer_09;
    // 测试用例
    private int n = 10;
    private int res = 55;

    @Before
    public void init() {
        swordOffer_09 = new SwordOffer_09();
    }

    @Test
    public void fibonacci() {
        assertEquals(res, swordOffer_09.Fibonacci(n));
    }

    @Test
    public void fibonacci_1() {
        assertEquals(res, swordOffer_09.Fibonacci_1(n));
    }
}