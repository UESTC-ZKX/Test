package swordOffer;

import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.*;

public class SwordOffer_65Test {

    SwordOffer_65 swordOffer_65 = new SwordOffer_65();
    // 测试用例
    private int[] num = {2,3,4,2,6,2,5,1};
    private int size = 3;
    private Integer[] res = {4,4,6,6,6,5};

    @Test
    public void maxInWindows() {
        assertEquals(Arrays.asList(res), swordOffer_65.maxInWindows(num, size));
    }
}