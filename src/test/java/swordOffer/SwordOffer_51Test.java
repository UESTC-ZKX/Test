package swordOffer;

import org.junit.Test;

import static org.junit.Assert.*;

public class SwordOffer_51Test {

    SwordOffer_51 swordOffer_51 = new SwordOffer_51();
    // 测试用例
    private int[] numbers = {2,3,1,0,2,5,3};
    private int[] duplication = new int[1];
    private int length = 7;
    private int res = 2;

    @Test
    public void duplicate() {
        assertEquals(true, swordOffer_51.duplicate(numbers, length, duplication));
        assertEquals(res, duplication[0]);
    }
}