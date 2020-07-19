package swordOffer;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class SwordOffer_04Test {

    private SwordOffer_04 swordOffer_04;

    // 测试用例
    final static private StringBuffer str = new StringBuffer("We Are Happy");
    final static private String res = "We%20Are%20Happy";

    @Before
    public void init() {
        swordOffer_04 = new SwordOffer_04();
    }

    @Test
    public void replaceSpace() {
        assertEquals(res, swordOffer_04.replaceSpace(str));
    }

    @Test
    public void replaceSpace_1() {
        assertEquals(res, swordOffer_04.replaceSpace_1(str));
    }
}