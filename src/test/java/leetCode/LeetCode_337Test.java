package leetCode;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class LeetCode_337Test extends MyClass{

    LeetCode_337 leetCode_337 = new LeetCode_337();
    //测试用例
    private TreeNode root = new TreeNode(3);
    private int res = 7;

    @Before
    public void init(){
        root.left = new TreeNode(2);
        root.left.right = new TreeNode(3);

        root.right = new TreeNode(3);
        root.right.right = new TreeNode(1);
    }

    @Test
    public void rob() {
        assertEquals(res, leetCode_337.rob(root));
    }

    @Test
    public void rob_1() {
        assertEquals(res, leetCode_337.rob_1(root));
    }

}