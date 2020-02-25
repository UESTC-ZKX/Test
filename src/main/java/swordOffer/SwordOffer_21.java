package swordOffer;

import java.util.Stack;

/**
 * @ClassName SwordOffer_21
 * @Description:
 * 第二十一题
 * 定义栈的数据结构，
 * 请在该类型中实现一个能够得到栈中所含最小元素的min函数（时间复杂度应为O（1））。
 * @Author UESTC-ZKX
 * @Date 2020/2/3
 **/
public class SwordOffer_21 {

    private Stack<Integer> stack = new Stack<Integer>();
    private Stack<Integer> min = new Stack<Integer>();
    private Stack<Integer> max = new Stack<Integer>();


    public void push(int node) {
        if(min.empty()){
            min.push(node);
        }else {
            if (node < min.peek()){
                min.push(node);
            }
            else {
                min.push(min.peek());
            }
        }
        if(max.empty()){
            max.push(node);
        }else {
            if (node > max.peek()){
                max.push(node);
            }
            else {
                max.push(max.peek());
            }
        }
        stack.push(node);
    }

    public void pop() {
        stack.pop();
        min.pop();
    }

    public int top() {
        return stack.peek();
    }

    public int min() {
        return min.peek();
    }

    public int max() {
        return max.peek();
    }
}
