package leetCode.easy;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @ClassName LeetCode_167Test
 * @Description
 * @Author UESTC-ZKX
 * @Date 2020/7/20
 **/
class LeetCode_167Test {

    LeetCode_167 leetCode_167 = new LeetCode_167();
    // 测试用例
    private int[] numbers = {2, 7, 11, 15};
    private int target = 9;

    private int[] res = {1, 2};

    @Test
    void twoSum() {
        assertArrayEquals(res, leetCode_167.twoSum(numbers, target));
    }
}