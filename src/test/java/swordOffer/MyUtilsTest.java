package swordOffer;

import org.junit.Test;

import static org.junit.Assert.*;

public class MyUtilsTest {
    private MyUtils myUtils = new MyUtils();
    // 测试用例
    private int[] array = {5,4,3,2,1};
    private int[] res = {1,2,3,4,5};

    @Test
    public void mySort() {
        myUtils.mySort(array);
        assertArrayEquals(res,array);
    }
}