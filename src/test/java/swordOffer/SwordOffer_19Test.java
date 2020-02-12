package swordOffer;

import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class SwordOffer_19Test extends MyClass {

    private MyUtils myUtils = new MyUtils();

    private SwordOffer_19 swordOffer_19;
    //生成树
    private SwordOffer_06 swordOffer_06;
    // 测试用例
    private int[] pre = {1,2,3};
    private int[] in = {2,1,3};
    private TreeNode root;
    private int[] res = {1,3,2};



    @Before
    public void init(){
        swordOffer_06 = new SwordOffer_06();
        swordOffer_19 = new SwordOffer_19();
        root = swordOffer_06.reConstructBinaryTree(pre, in);
    }


    @Test
    public void mirror() {
        swordOffer_19.Mirror(root);
        List<Integer> list = myUtils.traversal(root, "PRE");
        assertArrayEquals(res, list.stream().mapToInt(Integer::valueOf).toArray());

    }
}