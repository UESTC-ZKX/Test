package swordOffer;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class SwordOffer_62Test extends MyClass {

    SwordOffer_62 swordOffer_62 = new SwordOffer_62();
    MyUtils myUtils = new MyUtils();
    // 测试用例
    private TreeNode root = new TreeNode(1);
    private List<Integer> res = new ArrayList<Integer>() {{
        add(1);
        add(2);
        add(3);
    }};

    @Before
    public void init() {
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
    }

    @Test
    public void serializeAndDeserialize() {
        TreeNode newRoot = swordOffer_62.Deserialize(swordOffer_62.Serialize(root));
        assertEquals(res, myUtils.traversal(newRoot, "PRE"));
    }

}