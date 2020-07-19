package swordOffer;

import org.junit.Before;
import org.junit.Test;
import org.omg.PortableInterceptor.INACTIVE;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class SwordOffer_07Test {

    private SwordOffer_07 swordOffer_07;
    // 测试用例
    private List<Integer> list = new ArrayList<Integer>() {{
        add(1);
        add(2);
        add(3);
    }};
    List res;

    @Before
    public void init() {
        swordOffer_07 = new SwordOffer_07();
        res = new ArrayList();
    }

    @Test
    public void pop() {
        for (int node : list) {
            swordOffer_07.push(node);
        }
        while (!swordOffer_07.stack1.empty() || !swordOffer_07.stack2.empty()) {
            int n = swordOffer_07.pop();
            res.add(n);
        }
        assertEquals(list, res);
    }

    @Test
    public void pop_1() {
        for (int node : list) {
            swordOffer_07.push_1(node);
        }
        while (!swordOffer_07.stack1.empty() || !swordOffer_07.stack2.empty()) {
            int n = swordOffer_07.pop_1();
            res.add(n);
        }
        assertEquals(list, res);
    }
}