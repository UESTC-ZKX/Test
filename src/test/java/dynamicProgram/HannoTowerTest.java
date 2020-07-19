package dynamicProgram;

import org.junit.Test;

import static org.junit.Assert.*;

public class HannoTowerTest {

    HannoTower hannoTower = new HannoTower();
    // 测试用例
    private int n = 2;
    private int res = 3;

    @Test
    public void step() {
        assertEquals(res, hannoTower.step(n));
    }
}