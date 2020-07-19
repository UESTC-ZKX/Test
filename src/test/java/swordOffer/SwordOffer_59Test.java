package swordOffer;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class SwordOffer_59Test extends MyClass {

    SwordOffer_59 swordOffer_59 = new SwordOffer_59();
    //测试用例
    private TreeNode pRoot = new TreeNode(1);

    @Before
    public void init() {
        pRoot.left = new TreeNode(2);
        pRoot.right = new TreeNode(2);
    }

    @Test
    public void isSymmetrical() {
        assertEquals(true, swordOffer_59.isSymmetrical(pRoot));
    }
}