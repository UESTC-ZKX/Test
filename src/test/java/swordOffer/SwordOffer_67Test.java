package swordOffer;

import org.junit.Test;

import static org.junit.Assert.*;

public class SwordOffer_67Test {

    SwordOffer_67 swordOffer_67 = new SwordOffer_67();
    //测试用例
    private int threshold = 10, rows = 2, cols = 2;
    private int res = 4;

    @Test
    public void movingCount() {
        assertEquals(res, swordOffer_67.movingCount(threshold, rows, cols));
    }
}