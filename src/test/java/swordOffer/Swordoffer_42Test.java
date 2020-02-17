package swordOffer;

import org.junit.Test;

import static org.junit.Assert.*;

public class Swordoffer_42Test {

    Swordoffer_42 swordOffer_42 = new Swordoffer_42();
    // 测试用例
    private String str1 = "I am a student.";
    private String res1 = "student. a am I";

    @Test
    public void reverseSentence() {
        assertEquals(res1, swordOffer_42.ReverseSentence(str1));
    }

    // 测试用例
    private String str2 = "abcXYZdef";
    private int n = 3;
    private String res2 = "XYZdefabc";

    @Test
    public void LeftRotateString(){
        assertEquals(res2, swordOffer_42.LeftRotateString(str2, n));
    }
}