package swordOffer;

import org.junit.Test;

import static org.junit.Assert.*;

public class MyUtilsTest {
    private MyUtils myUtils = new MyUtils();
    // 测试用例
    private int[] array = {5,4,3,2,1};
    private int[] res_mySort = {1,2,3,4,5};

    @Test
    public void mySort() {
        myUtils.mySort(array);
        assertArrayEquals(res_mySort,array);
    }

    @Test
    public void quickSortByStack() {
        myUtils.quickSortByStack(array);
        assertArrayEquals(res_mySort,array);
    }

    // 测试用例
    private int n = 10, first = 1, second = 2;
    private int[] res_Fibonacci = {1,2,3,5,8,13,21,34,55,89};

    @Test
    public void Fibonacci(){
        assertArrayEquals(res_Fibonacci, myUtils.fibonacci(n,first,second));

    }
}