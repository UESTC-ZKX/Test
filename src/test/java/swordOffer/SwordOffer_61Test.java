package swordOffer;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class SwordOffer_61Test extends MyClass {

    SwordOffer_61 swordOffer_61 = new SwordOffer_61();
    //测试用例
    private TreeNode pRoot = new TreeNode(1);
    private ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();

    @Before
    public void init(){
        pRoot.left = new TreeNode(2);
        pRoot.right = new TreeNode(3);

        res.add(new ArrayList<Integer>(){{
            add(1);
        }});
        res.add(new ArrayList<Integer>(){{
            add(2);
            add(3);
        }});
    }


    @Test
    public void print() {
        assertEquals(res, swordOffer_61.Print(pRoot));
    }
}