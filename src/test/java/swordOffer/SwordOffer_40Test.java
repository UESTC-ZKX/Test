package swordOffer;

import org.junit.Test;

import static org.junit.Assert.*;

public class SwordOffer_40Test {

    SwordOffer_40 swordOffer_40 = new SwordOffer_40();
    // 测试用例
    private int[] array = {1, 2, 3, 4, 5, 6, 1, 2, 3, 4};
    private int[] num1 = {0}, num2 = {0};

    @Test
    public void findNumsAppearOnce() {
        swordOffer_40.FindNumsAppearOnce(array, num1, num2);
        assertEquals(5, num1[0]);
        assertEquals(6, num2[0]);
    }
}