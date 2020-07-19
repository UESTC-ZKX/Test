package leetCode.medium;

import org.junit.Test;

import static org.junit.Assert.*;

public class LeetCode_213Test {

    LeetCode_213 leetCoed_213 = new LeetCode_213();
    // 测试用例
    private int[] nums = {2, 1};
    private int res = 2;

    @Test
    public void rob() {
        assertEquals(res, leetCoed_213.rob(nums));
    }
}