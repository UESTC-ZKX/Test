package swordOffer;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.Assert.*;

public class SwordOffer_06Test {

    private MyUtils myUtils;

    private SwordOffer_06 swordOffer_06;
    // 测试用例
    private int[] pre = {1,2,4,7,3,5,6,8};
    private int[] in = {4,7,2,1,5,3,8,6};

    @Before
    public void init(){
        swordOffer_06 = new SwordOffer_06();
        myUtils = new MyUtils();
    }

    @Test
    public void reConstructBinaryTree() {
        assertEquals(Arrays.toString(in),myUtils
                .traversal(swordOffer_06.reConstructBinaryTree(pre,in), "IN").toString());
        assertEquals(Arrays.toString(pre),myUtils
                .traversal(swordOffer_06.reConstructBinaryTree(pre,in), "PRE").toString());
    }









}