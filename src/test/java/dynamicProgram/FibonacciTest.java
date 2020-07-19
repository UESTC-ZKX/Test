package dynamicProgram;

import org.junit.Test;
import test.Factorial;

import static org.junit.Assert.*;

public class FibonacciTest {

    Fibonacci fibonacci = new Fibonacci();
    // 测试用例
    private int n = 9, m = 2;
    private int res_upstairsPlus = 55;

    @Test
    public void upstairsPlus() {
        assertEquals(res_upstairsPlus, fibonacci.upstairsPlus(n, m));
    }

    // 测试用例
    private int input = 3;
    private int res_upstairsMax = 10;

    @Test
    public void upstairsMax() {
        assertEquals(res_upstairsMax, fibonacci.upstairsMax(input));
    }
}