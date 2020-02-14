package swordOffer;

import org.junit.Test;

import static org.junit.Assert.*;

public class SwordOffer_34Test {

    SwordOffer_34 swordOffer_34 = new SwordOffer_34();
    // 测试用例
    private int index = 7;
    private int res = 8;

    @Test
    public void getUglyNumber_Solution() {
        assertEquals(res,swordOffer_34.GetUglyNumber_Solution(index));
    }
}