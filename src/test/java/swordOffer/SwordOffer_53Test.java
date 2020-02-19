package swordOffer;

import org.junit.Test;

import static org.junit.Assert.*;

public class SwordOffer_53Test {

    SwordOffer_53 swordOffer_53 = new SwordOffer_53();
    // 测试用例
    private char[] str = {'a', 'a', 'a'};
    private char[] pattern = {'a', 'b', '*', 'a', 'c', '*', 'a'};
    private boolean res = true;

    @Test
    public void match() {
        assertEquals(res, swordOffer_53.match(str, pattern));
    }
}