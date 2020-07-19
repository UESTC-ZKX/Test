package leetCode.hard;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @ClassName LeetCode_312Test
 * @Description
 * @Author UESTC-ZKX
 * @Date 2020/7/19
 **/
class LeetCode_312Test {

    LeetCode_312 leetCode_312 = new LeetCode_312();
    // 测试用例
    private int[] nums = {3,1,5,8};
    private int res = 167;

    private int index = 2;
    private int[] oldNums = {3,1,5,8};
    private int[] newNums = new int[3];
    private int[] resNums = {3,1,8};

    @Test
    void maxCoins() {
        assertEquals(res, leetCode_312.maxCoins(nums));
    }

    @Test
    void removeNum() {
        leetCode_312.removeNum(index, oldNums, newNums);
        assertArrayEquals(resNums, newNums);
    }

    @Test
    void maxCoins_1() {
        assertEquals(res, leetCode_312.maxCoins_1(nums));
    }
}