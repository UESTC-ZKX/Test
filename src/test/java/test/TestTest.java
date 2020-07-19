package test;

import org.junit.Test;

import static org.junit.Assert.*;

public class TestTest {

    Test1 test1 = new Test1();
    // 测试用例
    private String[] strings = {
            "()",
            "()[]{}",
            "(]",
            ")("
    };
    private boolean[] res = {true, true, false, false};

    @Test
    public void isValid() {
        for (int i = 0; i < res.length; i++) {
            assertEquals(res[i], test1.isValid(strings[i]));
        }

    }
}