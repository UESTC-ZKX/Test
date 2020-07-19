package swordOffer;

import org.junit.Test;

import static org.junit.Assert.*;

public class SwordOffer_66Test {

    SwordOffer_66 swordOffer_66 = new SwordOffer_66();
    // 测试用例
    private char[] matrix = {
            'A', 'B', 'C', 'E',
            'S', 'F', 'C', 'S',
            'A', 'D', 'E', 'E'
    };
    private int rows = 3, cols = 4;
    private char[] str = {'S', 'E', 'E'};
    private boolean res = true;

    @Test
    public void hasPath() {
        assertEquals(res, swordOffer_66.hasPath(matrix, rows, cols, str));
    }
}