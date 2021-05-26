package leetCode.easy;

import org.junit.Test;
import org.openjdk.jol.info.ClassLayout;

import static org.junit.Assert.*;

public class LeetCode_7Test {

    LeetCode_7 leetCode_7 = new LeetCode_7();
    @Test
    public void reverse() {
        // 测试用例
        int x = 321;
        int res = 123;
        assertEquals(res, leetCode_7.reverse(x));
//        System.out.println(ClassLayout.parseInstance(leetCode_7).toPrintable());
    }
}