package swordOffer;

import org.junit.Test;

import static org.junit.Assert.*;

public class SwordOffer_35Test {

    SwordOffer_35 swordOffer_35 = new SwordOffer_35();
    // 测试用例
    private String str = "abcdabc";
    private int res = 3;

    @Test
    public void firstNotRepeatingChar() {
        assertEquals(res, swordOffer_35.FirstNotRepeatingChar(str));
    }
}