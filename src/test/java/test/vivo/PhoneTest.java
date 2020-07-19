package test.vivo;

import org.junit.Test;

import static org.junit.Assert.*;

public class PhoneTest {

    Phone phone = new Phone();

    @Test
    public void solution() {
        // 测试用例
        int res = 35;
        int n = 11;
        assertEquals(res, phone.solution(n));
    }
}