package swordOffer;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class SwordOffer_39Test extends MyClass {

    SwordOffer_39 swordOffer_39 = new SwordOffer_39();
    // 测试用例
    private TreeNode root;
    private int res = 3;

    @Before
    public void init(){
        root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
    }

    @Test
    public void treeDepth() {
        assertEquals(res, swordOffer_39.TreeDepth(root));
    }
}