package swordOffer;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class SwordOffer_27Test extends MyClass{

    SwordOffer_27 swordOffer_27 = new SwordOffer_27();
    SwordOffer_06 swordOffer_06 = new SwordOffer_06();
    MyUtils myUtils = new MyUtils();
    // 测试用例
    private int[] pre = {2,1,3};
    private int[] in = {1,2,3};
    private TreeNode pRootOfTree;
    private int[] res = {1,2,3};

    @Before
    public void init(){
        pRootOfTree = swordOffer_06.reConstructBinaryTree(pre, in);
    }

    @Test
    public void convert() {
        TreeNode treeNode = swordOffer_27.Convert(pRootOfTree);
        assertArrayEquals(res, myUtils.linkListToArray(treeNode));
    }
}