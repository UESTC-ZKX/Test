package test;

import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

// 操作符对象
class operator{
    String operator;
    int priority;

    // 构造函数
    operator(String operator, int priority){
        this.operator = operator;
        this.priority = priority;
    }
}

/**
 * @ClassName Calculator
 * @Description: 整数计算器
 * 例如：
 * 输入 1 + 2 * 3 - 4
 * 输出 3
 * @Author UESTC-ZKX
 * @Date 2020/1/18
 **/
public class Calculator {

    // 初始化操作符集合
    Set<String> operatorSet = new HashSet<String>(){{
        add("+");
        add("-");
        add("*");
        add("/");
    }};

    // 判断操作符优先级
    int priority(String s){
        if("*".equals(s) || "/".equals(s)){
            return 1;
        }
        if("+".equals(s) || "-".equals(s)){
            return 0;
        }
        return -1;
    }

    // 简单计算
    int sum(int a, String operator, int b){
        int res = 0;
        try {
            if ("+".equals(operator)) {
                res = a + b;
            }
            if ("-".equals(operator)) {
                res = a - b;
            }
            if ("*".equals(operator)) {
                res = a * b;
            }
            if ("/".equals(operator)) {
                res = a / b;
            }
        }
        catch (ArithmeticException e){
            System.out.println("0不能作为除数！");
        }
        return res;
    }

    int count(String strs){

        // 初始化操作数栈和操作符栈
        Stack<Integer> numsStack = new Stack<Integer>();
        Stack<operator> operatorStack = new Stack<operator>();

        // 分割输入字符串
        String str[] = strs.split("\\s+");

        for(String s : str){
            if(operatorSet.contains(s)){
                if(operatorStack.isEmpty()){
                    operatorStack.push(new operator(s,priority(s)));
                }else{
                    if(priority(s) > operatorStack.peek().priority){
                        operatorStack.push(new operator(s,priority(s)));
                    }
                    else {
                        int b = numsStack.pop();
                        int a = numsStack.pop();
                        String operator = operatorStack.pop().operator;
                        numsStack.push(sum(a,operator,b));
                        operatorStack.push(new operator(s,priority(s)));
                    }
                }
            }
            else {
                numsStack.push(Integer.parseInt(s));
            }
        }

        while (!operatorStack.empty()){
            int b = numsStack.pop();
            int a = numsStack.pop();
            String operator = operatorStack.pop().operator;
            numsStack.push(sum(a,operator,b));
        }
        return numsStack.pop();
    }
}
