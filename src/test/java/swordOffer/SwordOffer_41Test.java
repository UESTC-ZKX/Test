package swordOffer;

import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class SwordOffer_41Test {

    private SwordOffer_41 swordOffer_41 = new SwordOffer_41();
    // 测试用例1
    private int[] array = {1, 2, 3, 4, 5, 6, 7, 8, 9};
    private int sum = 8;
    private ArrayList<Integer> arrayList = new ArrayList() {{
        add(1);
        add(7);
    }};

    @Test
    public void findNumbersWithSum() {
        assertEquals(arrayList, swordOffer_41.FindNumbersWithSum(array, sum));
    }

    @Test
    public void findNumbersWithSum_1() {
        assertEquals(arrayList, swordOffer_41.FindNumbersWithSum_1(array, sum));
    }

    // 测试用例
    private int sum1 = 9;
    private ArrayList<ArrayList<Integer>> arrayLists = new ArrayList<>();

    @Test
    public void FindContinuousSequence() {
        arrayLists.add(new ArrayList<Integer>() {{
            add(2);
            add(3);
            add(4);
        }});
        arrayLists.add(new ArrayList<Integer>() {{
            add(4);
            add(5);
        }});
        ArrayList<ArrayList<Integer>> temp = swordOffer_41.FindContinuousSequence(sum1);
        assertEquals(arrayLists, temp);
    }
}