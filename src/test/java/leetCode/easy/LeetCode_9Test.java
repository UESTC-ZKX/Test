package leetCode.easy;

import org.junit.Test;

import static org.junit.Assert.*;

public class LeetCode_9Test {

    LeetCode_9 leetCode_9 = new LeetCode_9();

    @Test
    public void isPalindrome() {
        // 测试用例
        int x = 121;
        assertTrue(leetCode_9.isPalindrome(x));
    }
}