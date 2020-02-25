package realTest.huawei;

import org.junit.Test;

import static org.junit.Assert.*;

public class TakeUmbrellaTest {

    TakeUmbrella takeUmbrella = new TakeUmbrella();
    //测试用例
    private int T = 5;
    private int n = 1;
    private int m = 1;
    private int res = 3;

    @Test
    public void minTime() {
        assertEquals(res, takeUmbrella.minTime(T, m, n));
    }
}