package test;

import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class Test1Test {

    Test1 test1 = new Test1();

    @Test
    public void checkSam() {
        // 测试用例
        String stringA = "Here you are";
        String stringB = "are you Here";
        boolean res = true;
        assertEquals(res, test1.checkSam(stringA, stringB));

    }

    @Test
    public void longestValidParentheses() {
        // 测试用例
        String string = ")()()))()()()";
        int res = 10;
        assertEquals(res, test1.longestValidParentheses(string));
    }

    @Test
    public void getSolution() {
        // 测试用例
        int n = 1;
        ArrayList<String> res = new ArrayList<String>() {{
            add("move from left to right");
        }};
        assertEquals(res, test1.getSolution(n));

    }

    @Test
    public void detectCycle() {

    }

    @Test
    public void maxUncrossedLines() {
        // 测试用例[2, 5, 1, 2, 5],[10, 5, 2, 1, 5, 2]
        int[] A = {2, 5, 1, 2, 5};
        int[] B = {10, 5, 2, 1, 5, 2};
        int res = 3;
        assertEquals(res, test1.maxUncrossedLines(A, B));
    }

    @Test
    public void minRemove() {
        // 测试用例
        String string = "))((";
        String res = "";
        assertEquals(res, test1.minRemove(string));
    }
}