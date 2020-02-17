package leetCode;

import org.junit.Test;

import static org.junit.Assert.*;

public class LeetCoed_198Test {

    LeetCoed_198 leetCoed_198 = new LeetCoed_198();
    // 测试用例
    private  int[] nums = {1,2,3,1};
    private int res = 4;

    @Test
    public void rob() {
        assertEquals(res, leetCoed_198.rob(nums));
    }
}