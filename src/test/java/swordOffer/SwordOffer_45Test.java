package swordOffer;

import org.junit.Test;

import static org.junit.Assert.*;

public class SwordOffer_45Test {

    SwordOffer_45 swordOffer_45 = new SwordOffer_45();
    //测试用例
    private int n = 5, m = 2;
    private int res = 2;

    @Test
    public void lastRemaining_Solution() {
        assertEquals(res, swordOffer_45.LastRemaining_Solution(n, m));
    }

    @Test
    public void lastRemaining_Solution_1() {
        assertEquals(res, swordOffer_45.LastRemaining_Solution(n, m));
    }
}