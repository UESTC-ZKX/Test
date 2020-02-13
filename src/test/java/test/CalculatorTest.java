package test;

import org.junit.Before;

import static org.junit.Assert.assertEquals;

public class CalculatorTest {


    Calculator calculator;

    @Before
    public void init(){
        calculator = new Calculator();
    }

    @org.junit.Test
    public void priority() {
        assertEquals(0, calculator.priority("+"));
        assertEquals(0,calculator.priority("-"));
        assertEquals(1,calculator.priority("*"));
        assertEquals(1,calculator.priority("/"));
    }

    @org.junit.Test
    public void sum() {
        assertEquals(3,calculator.sum(1, "+", 2));
        assertEquals(-1,calculator.sum(1, "-", 2));
        assertEquals(2,calculator.sum(1, "*", 2));
        assertEquals(0,calculator.sum(1, "/", 2));
    }

    @org.junit.Test
    public void count() {
        System.out.println("输出结果为："+calculator.count("2 + 6 * 7 * 5"));
    }
}