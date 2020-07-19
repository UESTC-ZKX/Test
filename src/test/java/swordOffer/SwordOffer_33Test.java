package swordOffer;

import org.junit.Test;

import static org.junit.Assert.*;

public class SwordOffer_33Test {

    SwordOffer_33 swordOffer_33 = new SwordOffer_33();
    // 测试用例
    private int[] numbers = {3, 32, 321};
    private String res = "321323";

    @Test
    public void printMinNumber() {
        assertEquals(res, swordOffer_33.PrintMinNumber(numbers));

    }
}