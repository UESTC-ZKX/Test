package swordOffer;

import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

public class SwordOffer_23Test extends MyClass {

    private SwordOffer_23 swordOffer_23 = new SwordOffer_23();
    private SwordOffer_06 swordOffer_06 = new SwordOffer_06();
    // 测试用例
    TreeNode root;
    private int[] pre = {1, 2, 4, 7, 3, 5, 6, 8};
    private int[] in = {4, 7, 2, 1, 5, 3, 8, 6};
    private List<Integer> res = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8);

    @Before
    public void init() {
        root = swordOffer_06.reConstructBinaryTree(pre, in);
    }

    @Test
    public void printFromTopToBottom() {
        assertEquals(res, swordOffer_23.PrintFromTopToBottom(root));
    }
}