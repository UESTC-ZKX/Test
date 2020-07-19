package swordOffer;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class SwordOffer_18Test extends MyClass {

    SwordOffer_18 swordOffer_18;
    //生成树
    SwordOffer_06 swordOffer_06;
    // 测试用例
    TreeNode root1;
    private int[] pre1 = {1, 2, 4, 7, 3, 5, 6, 8};
    private int[] in1 = {4, 7, 2, 1, 5, 3, 8, 6};
    TreeNode root2;
    private int[] pre2 = {2, 4, 7};
    private int[] in2 = {4, 7, 2};
    Boolean res = true;

    @Before
    public void init() {
        swordOffer_18 = new SwordOffer_18();
        swordOffer_06 = new SwordOffer_06();
        root1 = swordOffer_06.reConstructBinaryTree(pre1, in1);
        root2 = swordOffer_06.reConstructBinaryTree(pre2, in2);
    }

    @Test
    public void hasSubtree() {
        assertEquals(res, swordOffer_18.HasSubtree(root1, root2));
    }

    @Test
    public void hasSubtree_1() {
        assertEquals(res, swordOffer_18.HasSubtree_1(root1, root2));
    }
}