package swordOffer;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.Assert.*;

public class SwordOffer_30Test {

    SwordOffer_30 swordOffer_30 = new SwordOffer_30();
    // 测试用例
    private int[] input = {4,5,1,6,2,7,3,8};
    private int k = 4;
    private ArrayList<Integer> res = new ArrayList<Integer>(Arrays.asList(1,2,3,4));

    @Test
    public void getLeastNumbers_Solution() {
        assertEquals(res, swordOffer_30.GetLeastNumbers_Solution(input, k));
    }

    @Test
    public void getLeastNumbers_Solution_1() {
        assertEquals(res, swordOffer_30.GetLeastNumbers_Solution_1(input, k));
    }
}