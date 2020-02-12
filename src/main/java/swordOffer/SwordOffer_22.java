package swordOffer;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * @ClassName SwordOffer_22
 * @Description:
 * 第二十二题
 * 输入两个整数序列，
 * 第一个序列表示栈的压入顺序，
 * 请判断第二个序列是否可能为该栈的弹出顺序。
 * 假设压入栈的所有数字均不相等。
 * 例如序列1,2,3,4,5是某栈的压入顺序，
 * 序列4,5,3,2,1是该压栈序列对应的一个弹出序列，
 * 但4,3,5,1,2就不可能是该压栈序列的弹出序列。
 *（注意：这两个序列的长度是相等的）
 * @Author UESTC-ZKX
 * @Date 2020/2/4
 **/
public class SwordOffer_22 {

    MyUtils myUtils = new MyUtils();
    public boolean IsPopOrder(int [] pushA,int [] popA) {
        if(myUtils.isNull(pushA, popA)){
            return false;
        }

        // 入栈存入栈
        Stack<Integer> stack = new Stack<Integer>();
        // 出栈存入队列
        Queue<Integer> queue = new LinkedList<Integer>();
        for (int i : popA){
            queue.offer(i);
        }
        for (int i : pushA){
            if(i == queue.element()){
                queue.poll();
                continue;
            }
            stack.push(i);
        }
        while (!stack.empty() && queue.peek() != null){
            if(stack.pop() != queue.poll()){
                return false;
            }
        }
        return true;
    }
}
