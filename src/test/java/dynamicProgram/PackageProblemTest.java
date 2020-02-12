package dynamicProgram;

import org.junit.Test;

import static org.junit.Assert.*;

public class PackageProblemTest {

    PackageProblem packageProblem = new PackageProblem();
    // 测试用例
    private int n = 5, c = 10;
    private int[] wi = {2, 2, 6, 5, 4},
                  pi = {6, 3, 5, 4, 6};
    private int res = 15;

    @Test
    public void findMaxValue() {
        assertEquals(res, packageProblem.findMaxValue(n, wi, pi, c));
    }
}