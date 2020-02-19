package swordOffer;

import org.junit.Test;

import static org.junit.Assert.*;

public class SwordOffer_54Test {

    SwordOffer_54 swordOffer_54 = new SwordOffer_54();
    //测试用例
    private char[] str = {'-', '1', 'E', '-', '1', '6'};

    @Test
    public void isNumeric() {
        assertEquals(true, swordOffer_54.isNumeric(str));
    }
}