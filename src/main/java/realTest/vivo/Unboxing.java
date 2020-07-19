package realTest.vivo;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * @ClassName Unboxing
 * @Description: 小v所在的公司即将举行年会，年会方案设计过程中必不可少的一项就是抽奖活动。
 * 小v在本次活动中被委以重任，负责抽奖活动的策划；
 * 为了让中奖的礼物更加精美且富有神秘感，打算采用礼品盒来包装奖品，
 * 此时小v发挥了自己的创意想捉弄一下获奖的同事，便采取了多重包装来包装奖品。
 * <p>
 * 现给出一个字符串，并假定用一对圆括号( )表示一个礼品盒，0表示奖品，
 * 你能据此帮获奖者算出最少要拆多少个礼品盒才能拿到奖品吗？
 * <p>
 * 输入描述:
 * 一行字符串，仅有'('、')'、'0' 组成，其中一对'(' ')'表示一个礼品盒，‘
 * 0’表示奖品；输入的字符串一定是有效的，即'(' ')'一定是成对出现的。
 * <p>
 * 输出描述:
 * 输出结果为一个数字，表示小v要拆的最少礼品盒数量
 * <p>
 * 输入例子1:
 * (()(()((()(0)))))
 * <p>
 * 输出例子1:
 * 5
 * <p>
 * 输入例子2:
 * (((0)))
 * <p>
 * 输出例子2:
 * 3
 * @Author UESTC-ZKX
 * @Date 2020/3/7
 **/
public class Unboxing {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String inputStr = br.readLine();
        int output = solution(inputStr);
        System.out.println(output);
    }

    private static int solution(String str) {
        // TODO Write your code here
        int res = 0;
        Stack<Character> stack = new Stack<>();
        Map<Character, Character> map = new HashMap<Character, Character>() {{
            put(')', '(');
        }};
        for (char c : str.toCharArray()) {
            if (!stack.empty()) {
                if (map.get(c) == stack.peek()) {
                    stack.pop();
                } else if (c == '0') {
                    res = stack.size();
                } else {
                    stack.push(c);
                }
            } else {
                if (c != '0') {
                    stack.push(c);
                }
            }
        }
        return res;
    }
}
