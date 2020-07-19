package test.vivo;

import org.junit.Test;

import static org.junit.Assert.*;

public class FindMTest {

    FindM findM = new FindM();

    @Test
    public void solution() {
        // 测试用例
        int n = 100;
        int res = 455;
        assertEquals(res, findM.solution(n));
    }
}