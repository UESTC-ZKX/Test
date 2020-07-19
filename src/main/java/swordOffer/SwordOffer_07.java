package swordOffer;

import java.util.Stack;

/**
 * @ClassName SwordOffer_07
 * @Description: 第七题
 * 用两个栈来实现一个队列，
 * 完成队列的Push和Pop操作。
 * 队列中的元素为int类型
 * @Author UESTC-ZKX
 * @Date 2020/1/22
 **/
public class SwordOffer_07 {
    Stack<Integer> stack1 = new Stack<Integer>();
    Stack<Integer> stack2 = new Stack<Integer>();

    public void push(int node) {
        stack1.push(node);
    }

    public int pop() {
        int res;
        while (!stack1.empty()) {
            stack2.push(stack1.pop());
        }
        res = stack2.pop();
        while (!stack2.empty()) {
            stack1.push(stack2.pop());
        }
        return res;
    }

    /********************  优化版  *******************/
    public void push_1(int node) {
        stack1.push(node);
    }

    public int pop_1() {
        int res;
        if (stack2.empty()) {
            while (!stack1.empty()) {
                stack2.push(stack1.pop());
            }
        }
        res = stack2.pop();
        return res;
    }
}
