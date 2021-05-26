package test.huawei.nowcoder;

import java.util.Scanner;

/**
 * @author zhoukx
 * @ClassName: Test108
 * @description:
 * 题目描述
 * 正整数A和正整数B 的最小公倍数是指 能被A和B整除的最小的正整数值，设计一个算法，求输入A和B的最小公倍数。
 *
 * 输入描述:
 * 输入两个正整数A和B。
 *
 * 输出描述:
 * 输出A和B的最小公倍数。
 *
 * 示例1
 * 输入
 * 5 7
 * 输出
 * 35
 * @date 2021/5/22
 */
public class Test108 {

    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        String[] strings = scanner.nextLine().split(" ");
        int a = Integer.parseInt(strings[0]);
        int b = Integer.parseInt(strings[1]);
        int res = 1;
        // 暴力法
//        for(; ; res++){
//            if(res % a == 0 && res % b == 0){
//                break;
//            }
//        }
//        System.out.println(res);
        // 辗转相除
        if(a >= b){
            res = a*b / method(a, b);
        }
        else {
            res = a*b / method(b, a);
        }
        System.out.println(res);
    }

    // 取最大公因数
    public static int method(int a, int b){
        if(a % b == 0){
            return b;
        }
        else {
            return method(b, a % b);
        }
    }

}
