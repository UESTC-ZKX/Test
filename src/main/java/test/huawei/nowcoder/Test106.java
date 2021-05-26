package test.huawei.nowcoder;

import java.util.Scanner;

/**
 * @author zhoukx
 * @ClassName: Test106
 * @description:
 * 题目描述
 * 将一个字符串str的内容颠倒过来，并输出。str的长度不超过100个字符。
 *
 *
 * 输入描述:
 * 输入一个字符串，可以有空格
 *
 * 输出描述:
 * 输出逆序的字符串
 *
 * 示例1
 * 输入
 * I am a student
 * 输出
 * tneduts a ma I
 * @date 2021/5/22
 */
public class Test106 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String string = scanner.nextLine();
        char[] chars = string.toCharArray();
        StringBuilder res = new StringBuilder();
        for(int i = chars.length - 1; i >= 0; i--){
            res.append(chars[i]);
        }
        System.out.println(res);

    }

}
