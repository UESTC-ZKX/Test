package swordOffer;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class SwordOffer_03Test {

    private SwordOffer_03 swordOffer_03;

    // 测试用例
    final static private int a[][] = new int[][]{{1, 2, 10}, {2, 3, 11}, {3, 4, 12}};
    final static private int num = 10;
    final static private boolean res = true;


    @Before
    public void init() {
        swordOffer_03 = new SwordOffer_03();
    }

    @Test
    public void find() {
        assertEquals(res, swordOffer_03.find(a, num));
    }

    @Test
    public void find_1() {
        assertEquals(res, swordOffer_03.find_1(a, num));
    }

    @Test
    public void find_2() {
        assertEquals(res, swordOffer_03.find_2(a, num));
    }
}