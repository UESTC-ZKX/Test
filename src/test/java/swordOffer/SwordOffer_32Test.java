package swordOffer;

import org.junit.Test;

import static org.junit.Assert.*;

public class SwordOffer_32Test {

    SwordOffer_32 swordOffer_32 = new SwordOffer_32();
    // 测试用例
    private int n = 13;
    private int res = 6;


    @Test
    public void numberOf1Between1AndN_Solution() {
        assertEquals(res, swordOffer_32.NumberOf1Between1AndN_Solution(n));
    }
}