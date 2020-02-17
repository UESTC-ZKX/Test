package swordOffer;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class SwordOffer_25Test extends MyClass {

    private SwordOffer_25 swordOffer_25 = new SwordOffer_25();
    private SwordOffer_06 swordOffer_06 = new SwordOffer_06();
    // 测试用例
    private int[] pre = {1,2,3};
    private int[] in = {2,1,3};
    private TreeNode root;
    private int target = 3;
    private ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
    private ArrayList<Integer> list = new ArrayList<Integer>(){{
        add(1);
        add(2);
    }};

    @Before
    public void init(){
        root = swordOffer_06.reConstructBinaryTree(pre, in);
        res.add(list);
    }

    @Test
    public void findPath() {
        assertEquals(res, swordOffer_25.FindPath(root, target));
    }
}