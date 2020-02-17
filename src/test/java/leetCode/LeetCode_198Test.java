package leetCode;

import org.junit.Test;

import static org.junit.Assert.*;

public class LeetCode_198Test {

    LeetCode_198 leetCode_198 = new LeetCode_198();
    // 测试用例
    private  int[] nums = {1,2,3,1};
    private int res = 4;

    @Test
    public void rob() {
        assertEquals(res, leetCode_198.rob(nums));
    }
}