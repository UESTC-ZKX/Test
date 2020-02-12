package swordOffer;

import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class SwordOffer_28Test {

    SwordOffer_28 swordOffer_28 = new SwordOffer_28();
    // 测试用例
    private String str = "abc";
    private String[] res = {
            "abc","acb","bac","bca","cab","cba"
    };

    @Test
    public void permutation() {
        ArrayList<String> arrayList = swordOffer_28.Permutation(str);
        assertArrayEquals(res, arrayList.toArray());
    }
}