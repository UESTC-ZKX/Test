package swordOffer;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class SwordOffer_63Test extends MyClass {

    SwordOffer_63 swordOffer_63 = new SwordOffer_63();
    // 测试用例
    private TreeNode pRoot = new TreeNode(2);
    private int k = 2;
    private TreeNode res = pRoot;

    @Before
    public void init(){
        pRoot.left = new TreeNode(1);
        pRoot.right = new TreeNode(3);
    }

    @Test
    public void kthNode() {
        assertEquals(res, swordOffer_63.KthNode(pRoot, k));
    }
}