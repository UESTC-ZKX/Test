package swordOffer;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.Assert.*;

public class SwordOffer_20Test {

    SwordOffer_20 swordOffer_20 = new SwordOffer_20();
    // 测试用例
    private int[][] matrix = new int[][]{
            {1, 2, 3, 4},
            {5, 6, 7, 8},
            {9, 10, 11, 12},
            {13, 14, 15, 16}
    };
    private ArrayList<Integer> res = new ArrayList<Integer>(Arrays.asList(
            1, 2, 3, 4, 8, 12, 16, 15, 14, 13, 9, 5, 6, 7, 11, 10
    ));

    @Test
    public void printMatrix() {
        assertEquals(res, swordOffer_20.printMatrix(matrix));
    }
}